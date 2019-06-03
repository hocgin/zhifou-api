package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Gallery;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface GalleryService extends IService<Gallery> {
    
    /**
     * 用 文章ID 查找图片
     * @param postId
     * @return
     */
    List<Gallery> findByPostId(Long postId);
}
