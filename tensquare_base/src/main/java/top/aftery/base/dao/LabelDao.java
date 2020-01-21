package top.aftery.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.aftery.base.pojo.Label;

/**
 * @ClassName LabelDao
 * @Description LabelDao
 * @Author Aftery
 * @Date 2020/1/20 13:24
 * @Version 1.0
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
