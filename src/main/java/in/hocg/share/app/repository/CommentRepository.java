package in.hocg.share.app.repository;

import in.hocg.share.app.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    /**
     * 分页查询评论
     *
     * @param targetId
     * @param rootId
     * @param pageable
     * @return
     */
    Page<Comment> findAllByTargetIdAndRootId(String targetId, Long rootId, Pageable pageable);
    
    /**
     * 查询父评论的子评论数量
     *
     * @param parentId
     * @return
     */
    long countAllByRootId(Long parentId);
}
