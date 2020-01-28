package top.aftery.qa.dao;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;
import top.aftery.qa.pojo.Reply;

import java.util.List;

/**
 * @ClassName ReplyDao
 * @Description ReplyDao
 * @Author Aftery
 * @Date 2020/1/27 19:43
 * @Version 1.0
 */
public interface ReplyDao extends JpaRepository<Reply,String>,JpaSpecificationExecutor<Reply>{


}
