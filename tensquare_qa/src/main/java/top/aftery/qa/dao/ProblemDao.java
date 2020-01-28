package top.aftery.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;
import top.aftery.qa.pojo.Problem;
import top.aftery.qa.pojo.Reply;

/**
 * @ClassName ProblemDao
 * @Description ProblemDao
 * @Author Aftery
 * @Date 2020/1/27 19:43
 * @Version 1.0
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 查询最新问答列表
     * @param labelid 标签ID
     * @return
     */
    @Query(value = "SELECT * FROM tb_pl,tb_problem WHERE id=problemid AND labelid=? ORDER BY replytime DESC",nativeQuery = true)
    Page<Problem> newlist(String labelid, Pageable pageable);

    /**
     * 热门问答列表
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_pl,tb_problem WHERE id=problemid AND labelid=? ORDER BY reply DESC",nativeQuery = true)
    Page<Problem> hotlist(String labelid,Pageable pageable);


    /**
     * 等待回答列表
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_pl,tb_problem WHERE id=problemid AND labelid=? AND reply=0 ORDER BY createtime DESC",nativeQuery = true)
    Page<Problem> waitlist(String labelid,Pageable pageable);
}
