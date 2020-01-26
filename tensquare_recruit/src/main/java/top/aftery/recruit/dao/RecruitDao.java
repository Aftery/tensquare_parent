package top.aftery.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.recruit.pojo.Recruit;

import java.util.List;

/**
 * @ClassName RecruitDao
 * @Description RecruitDao
 * @Author Aftery
 * @Date 2020/1/16 19:28
 * @Version 1.0
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    /**
     * 查询前6的热门职位并根据创建时间排序
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询前6的热门职位并且不是关闭状态的
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateNotOrderByConditionDesc(String state);
}
