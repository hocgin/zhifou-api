package in.hocg.zhifou.support.security;


import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 * 必须登陆
 *
 * @author hocgin
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Inherited
@java.lang.annotation.Documented
@PreAuthorize("hasAuthority('ROLE_USER')")
public @interface NeedLogin {
}
