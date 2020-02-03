package top.aftery.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RqbbitMqApplication
 * @Description RqbbitMqApplication
 * @Author Aftery
 * @Date 2020/2/2 11:55
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
public class RqbbitMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RqbbitMqApplication.class);
    }

}
