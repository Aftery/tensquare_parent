package top.aftery.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import top.aftery.common.util.JwtUtil;

/**
 * @ClassName QaApplication
 * @Description QaApplication
 * @Author Aftery
 * @Date 2020/1/27 19:43
 * @Version 1.0
 */
@SpringBootApplication
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
