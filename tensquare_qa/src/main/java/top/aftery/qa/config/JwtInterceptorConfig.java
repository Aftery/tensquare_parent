package top.aftery.qa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.aftery.qa.filter.JwtInterceptor;

/**
 * @ClassName JwtInterceptorConfig
 * @Description JwtInterceptorConfig
 * @Author Aftery
 * @Date 2020/2/10 18:37
 * @Version 1.0
 */
@Configuration
public class JwtInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns("**/login/**");
    }
}
