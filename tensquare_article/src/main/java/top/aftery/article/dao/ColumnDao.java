package top.aftery.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.article.pojo.Column;
/**
 * @ClassName ColumnDao
 * @Description ColumnDao
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column>{
	
}
