package top.aftery.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.recruit.pojo.Recruit;
/**
 * @ClassName RecruitDao
 * @Description RecruitDao
 * @Author Aftery
 * @Date 2020/1/16 19:28
 * @Version 1.0
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	
}
