package top.aftery.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.aftery.common.util.JwtUtil;

/**
 * @ClassName [UserApplication]
 * @Description [UserApplication]
 * @Author Aftery
 * @Date 2020/1/28 
 * @Version 1.0
 */
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder(){
		return  new BCryptPasswordEncoder();
	}


	@Bean
	public JwtUtil JwtUtil(){
		return new JwtUtil();
	}
}
