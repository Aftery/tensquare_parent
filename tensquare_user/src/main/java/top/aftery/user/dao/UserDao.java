package top.aftery.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Modifying
    @Query(value = "UPDATE tb_user SET followcount=followcount+? WHERE id=?",nativeQuery = true)
    void updateFollowcount(int x, String userId);

    @Modifying
    @Query(value = "UPDATE tb_user SET fanscount=fanscount+? WHERE id=?",nativeQuery = true)
    void updatedFanscount(int x, String friendid);
}
