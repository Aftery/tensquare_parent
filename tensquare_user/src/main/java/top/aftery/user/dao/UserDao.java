package top.aftery.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.user.pojo.User;

import java.util.List;

/**
 * @ClassName User
 * @Description User
 * @Author Aftery
 * @Date 2020/1/28 
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    /**
     * 根据手机号码查询用户信息
     * @param mobile
     * @return
     */
    User findByMobile(String mobile);

}
