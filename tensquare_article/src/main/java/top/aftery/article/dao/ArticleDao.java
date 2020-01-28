package top.aftery.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.aftery.article.pojo.Article;
/**
 * @ClassName ArticleDao
 * @Description ArticleDao
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 文章审核
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state=1 WHERE id=?",nativeQuery = true)
    void updateState(String id);

    /**
     * 文章点赞
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup=thumbup+1 WHERE id=?",nativeQuery = true)
    void  addThumbup(String id);

}
