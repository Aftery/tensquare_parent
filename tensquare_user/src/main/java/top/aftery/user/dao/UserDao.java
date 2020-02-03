package top.aftery.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.user.pojo.User;
/**
 * @ClassName User
 * @Description User
 * @Author Aftery
 * @Date 2020/1/28 
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
	
}
