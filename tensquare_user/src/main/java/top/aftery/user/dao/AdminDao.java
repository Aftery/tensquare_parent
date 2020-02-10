package top.aftery.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.user.pojo.Admin;

/**
 * @ClassName Admin
 * @Description Admin
 * @Author Aftery
 * @Date 2020/1/28
 * @Version 1.0
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

    /**
     * 根据用户名查询数据
     *
     * @param loginname
     * @return
     */
    Admin findByLoginname(String loginname);

}
