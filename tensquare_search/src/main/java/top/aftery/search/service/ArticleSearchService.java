package top.aftery.search.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.aftery.search.dao.ArticleSearchDao;
import top.aftery.search.pojo.Article;

import java.util.List;

/**
 * @ClassName ArticleSearchService
 * @Description ArticleSearchService
 * @Author Aftery
 * @Date 2020/2/1 12:59
 * @Version 1.0
 */
@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;


    /**
     * 增加文章
     *
     * @param article
     */
    public void add(Article article) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        article.setId(snowflake.nextId() + "");
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageable);
    }


}
