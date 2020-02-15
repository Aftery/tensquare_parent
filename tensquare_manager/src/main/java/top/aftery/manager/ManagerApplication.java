package top.aftery.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import top.aftery.common.util.JwtUtil;

/**
 * @ClassName ManagerApplication
 * @Description ManagerApplication
 * @Author Aftery
 * @Date 2020/2/15 14:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
