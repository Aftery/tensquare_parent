package top.aftery.gathering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.gathering.pojo.Gathering;
/**
 * @ClassName Gathering
 * @Description Gathering
 * @Author Aftery
 * @Date 2020/1/28 19:04
 * @Version 1.0
 */
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering>{
	
}
