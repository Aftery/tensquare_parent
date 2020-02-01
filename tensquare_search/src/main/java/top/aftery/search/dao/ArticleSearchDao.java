package top.aftery.search.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.aftery.search.pojo.Article;

/**
 * @ClassName ArticleSearchDao
 * @Description ArticleSearchDao
 * @Author Aftery
 * @Date 2020/2/1 12:58
 * @Version 1.0
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {

    /**
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
