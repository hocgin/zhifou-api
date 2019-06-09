package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Comment;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.CommentMapper;
import in.hocg.zhifou.mapping.CommentMapping;
import in.hocg.zhifou.pojo.ro.AddCommentRo;
import in.hocg.zhifou.pojo.vo.CommentVo;
import in.hocg.zhifou.pojo.vo.UserSummaryVo;
import in.hocg.zhifou.service.CommentService;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.support.base.request.PageQuery;
import in.hocg.zhifou.support.mybatis.MybatisPlusKit;
import in.hocg.zhifou.util.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {
    
    private final UserService userService;
    
    @Override
    public void comment(Principal principal,
                        String targetId,
                        AddCommentRo param) {
        
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            throw ApiException.newInstance("请先进行登陆");
        }
        
        Comment comment = CommentMapping.INSTANCE.fromAddCommentRo(param);
        comment.setTargetId(targetId);
        comment.setCreator(user.getId());
        baseMapper.insert(comment);
    }
    
    @Override
    public IPage<CommentVo> queryRootComment(String targetId,
                                             PageQuery<Void> query) {
        Page page = query.page();
        QueryWrapper wrapper = query.wrapper();
        
        IPage<Comment> comments = findAllByTargetIdAndRootId(targetId, null, page);
        CommentVo body;
        List<Comment> records = comments.getRecords();
        ArrayList<CommentVo> result = new ArrayList<>(records.size());
        User user;
        
        // 填充信息
        for (Comment comment : records) {
            user = userService.getById(comment.getCreator());
            if (Objects.isNull(user)) {
                continue;
            }
            body = CommentMapping.INSTANCE.toCommentVo(comment);
            body.setCommenter(new UserSummaryVo(user));
            
            body.setCommentCount(countByRootId(comment.getId()));
            result.add(body);
        }
        
        Page<CommentVo> rtn = MybatisPlusKit.newPage(comments);
        rtn.setRecords(result);
        return rtn;
    }
    
    @Override
    public Long countByRootId(Long id) {
        if (Objects.isNull(id)) {
            return 0L;
        }
    
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        return Long.valueOf(baseMapper.selectCount(queryWrapper.eq(Comment::getRootId, id)));
    }
    
    
    @Override
    public IPage<CommentVo> queryChildrenComment(String targetId,
                                                 Long rootId,
                                                 PageQuery<Void> pageable) {
        Page page = pageable.page();
        IPage<Comment> paging = findAllByTargetIdAndRootId(targetId, rootId, page);
        
        CommentVo body;
        List<Comment> comments = paging.getRecords();
        ArrayList<CommentVo> records = new ArrayList<>(comments.size());
        User user;
        
        // 填充信息
        for (Comment comment : comments) {
            user = userService.getById(comment.getCreator());
            if (Objects.isNull(user)) {
                continue;
            }
            
            body = CommentMapping.INSTANCE.toCommentVo(comment);
            body.setCommenter(new UserSummaryVo(user));
            
            // 填充父评论
            Long parentId = comment.getParentId();
            if (!Objects.equals(parentId, rootId)) {
                Comment pComment = baseMapper.selectById(parentId);
                if (Objects.nonNull(pComment)) {
                    User pCommenter = userService.getById(pComment.getCreator());
                    if (Objects.nonNull(pCommenter)) {
                        body.setPCommenter(new UserSummaryVo(pCommenter));
                    }
                }
            }
            
            // 查询子评论
            records.add(body);
        }
        
        Page<CommentVo> rtn = MybatisPlusKit.newPage(paging);
        rtn.setRecords(records);
        return rtn;
    }
    
    
    @Override
    public IPage<Comment> findAllByTargetIdAndRootId(String targetId, Long rootId,
                                                     IPage<Comment> pageable) {
        Assert.notNull(targetId, "关联的目标不能为空");
        
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        IPage<Comment> commentIPage = baseMapper.selectPage(pageable, queryWrapper.eq(Comment::getTargetId, targetId)
                .eq(Objects.nonNull(rootId), Comment::getRootId, rootId)
                .isNull(Objects.isNull(rootId), Comment::getRootId)
        );
        return commentIPage;
    }
}
