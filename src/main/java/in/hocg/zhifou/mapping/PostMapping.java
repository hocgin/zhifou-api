package in.hocg.zhifou.mapping;

import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.PostSummaryVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface PostMapping {
    
    PostMapping INSTANCE = Mappers.getMapper(PostMapping.class);
    
    /**
     * POST -> PostDetailVo
     *
     * @param post
     * @return
     */
    @Mappings({
            @Mapping(target = "v", ignore = true),
            @Mapping(target = "uri", ignore = true),
            @Mapping(target = "tags", ignore = true),
            @Mapping(target = "classify", ignore = true),
            @Mapping(target = "isLiked", ignore = true),
            @Mapping(target = "isFavorites", ignore = true),
            @Mapping(target = "pageviews", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "banner", ignore = true),
    })
    PostDetailVo toPostDetailVo(Post post);
    
    /**
     * POST -> PostSummaryVo
     * @param post
     * @return
     */
    @Mappings({
            @Mapping(target = "v", ignore = true),
            @Mapping(target = "uri", ignore = true),
            @Mapping(target = "tags", ignore = true),
            @Mapping(target = "classify", ignore = true),
            @Mapping(target = "isLiked", ignore = true),
            @Mapping(target = "isFavorites", ignore = true),
            @Mapping(target = "pageviews", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "banner", ignore = true),
    })
    PostSummaryVo toPostSummaryVo(Post post);
    
    /**
     * PublishedPostRo -> Post
     * @param entity
     * @return
     */
    Post fromPublishedPostRo(PublishedPostRo entity);
}
