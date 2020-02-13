package top.aftery.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ArticleApplication
 * @Description ArticleApplication
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}


}
