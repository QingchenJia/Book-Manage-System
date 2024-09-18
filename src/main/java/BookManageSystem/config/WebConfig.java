package BookManageSystem.config;

import BookManageSystem.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    public LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/User/login",
                        "/User/register",
                        "/Admin/login",
                        "/index.html",
                        "/html/**",
                        "/css/**",
                        "/element-ui/**",
                        "/img/**",
                        "/js/**",
                        "/favicon.ico"
                );
    }
}
