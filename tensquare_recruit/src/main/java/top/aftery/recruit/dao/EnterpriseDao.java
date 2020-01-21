package top.aftery.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.recruit.pojo.Enterprise;
/**
 * @ClassName EnterpriseDao
 * @Description EnterpriseDao
 * @Author Aftery
 * @Date 2020/1/16 19:28
 * @Version 1.0
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
	
}
