package in.hocg.zhifou.controller.param;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by hocgin on 2019/5/6.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class AddPostParam {
    @NotBlank(message = "标题不能为空")
    private String title;
    private String icon = "http://lorempixel.com/500/500";
    private String[] tags = new String[]{};
    private String[] images = new String[]{
            "http://lorempixel.com/900/300/"
    };
    @NotBlank(message = "简要描述不能为空")
    private String desc;
    private String content;
    @NotBlank(message = "作者昵称不能为空")
    private String username;
    private String avatar;
    
    
    public JSONObject asFileJSONObject() {
        long datetime = System.currentTimeMillis();
        
        JSONObject author = new JSONObject()
                .fluentPut("avatar", this.avatar)
                .fluentPut("username", this.username);
        
        String id = String.format("ID-post-%s", String.valueOf(datetime));
        return new JSONObject().fluentPut("id", id)
                .fluentPut("isLiked", false)
                .fluentPut("isCollected", false)
                .fluentPut("createdAt", datetime)
                .fluentPut("pageviews", 0)
                
                .fluentPut("url", String.format("/post?v=/today/%s.json", id))
                .fluentPut("icon", icon)
                .fluentPut("title", title)
                .fluentPut("tags", Lists.newArrayList(tags))
                .fluentPut("images", Lists.newArrayList(images))
                .fluentPut("content", content)
                .fluentPut("desc", desc)
                .fluentPut("author", author);
    }
}
