package in.hocg.zhifou.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hocgin on 2018/12/30.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "CustomFilter", urlPatterns = "/**")
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.debug("开启自定义拦截器");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("application/json; charset=utf-8");
        String origin = servletRequest.getHeader("Origin");
        servletResponse.setHeader("Access-Control-Allow-Origin", origin);
        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        servletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        servletResponse.setHeader("Access-Control-Expose-Headers", "*");
        chain.doFilter(request, servletResponse);
    }
    
    @Override
    public void destroy() {
    }
}
