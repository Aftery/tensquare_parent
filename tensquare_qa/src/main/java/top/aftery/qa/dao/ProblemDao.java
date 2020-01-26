package top.aftery.qa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.qa.pojo.Problem;
/**
 * @ClassName ProblemDao
 * @Description ProblemDao
 * @Author Aftery
 * @Date 2020/1/26 10:38
 * @Version 1.0
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	
}
