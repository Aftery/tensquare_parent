package top.aftery.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName WebApplication
 * @Description WebApplication
 * @Author Aftery
 * @Date 2020/2/15 15:24
 * @Version 1.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
