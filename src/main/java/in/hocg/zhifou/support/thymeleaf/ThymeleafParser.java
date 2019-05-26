package in.hocg.zhifou.support.thymeleaf;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@AllArgsConstructor
@Component
public class ThymeleafParser {
    private HttpServletRequest request;
    private ServletContext servletContext;
    private HttpServletResponse response;
    private SpringTemplateEngine springTemplateEngine;
    
    /**
     * 解析 thymeleaf 语法
     */
    public String thymeleafTemplate(String templateName, Map<String, Object> params) {
        Assert.notNull(templateName, "模版名称必须填写");
        
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        if (Objects.nonNull(params)) {
            ctx.setVariables(params);
        }
        return springTemplateEngine.process(templateName, ctx);
    }
    
}
