package in.hocg.share.app.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.visola.spring.security.tokenfilter.TokenAuthenticationFilter;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private TokenAuthenticationFilter tokenAuthenticationFilter;
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    @Override
    public void configure(WebSecurity web) {
        web.debug(true);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         配置拦截器
        */
        http.addFilterBefore(tokenAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(fixBugFilter(), TokenAuthenticationFilter.class)
        ;
        
        /*
         全局配置
        */
        http.csrf().disable()
//                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().cacheControl();
        
        /*
         URL 授权管理
        */
        http.authorizeRequests()
                
                // 针对 fetch 对跨域请求发送 OPTIONS 请求的处理
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/error").permitAll()
        
                .antMatchers(HttpMethod.POST, "/api/v1/*/comment/_search").permitAll()
                
                // 账号相关
                .antMatchers(HttpMethod.POST, "/api/v1/account/sign-in").anonymous()
                .antMatchers(HttpMethod.POST, "/api/v1/account/sign-up").anonymous()
                
                // 需要登陆
                .antMatchers("/api/v1/**").hasRole("USER")
        ;
        
    
        /*
         异常处理
        */
//        ExceptionHandling authenticationEntryPoint = new ExceptionHandling();
//        http.exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPoint)
//                .accessDeniedHandler(authenticationEntryPoint)
//        ;
    
    }
    
    @Bean
    FixBugFilter fixBugFilter() {
        // 处理 TokenAuthenticationFilter 异常不能被拦截的问题
        return new FixBugFilter();
    }
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
