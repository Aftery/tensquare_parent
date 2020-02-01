package top.aftery.search.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.PageResult;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.search.pojo.Article;
import top.aftery.search.service.ArticleSearchService;

/**
 * @ClassName ArticleSearchController
 * @Description ArticleSearchController
 * @Author Aftery
 * @Date 2020/2/1 13:02
 * @Version 1.0
 */
@RestController
@CrossOrigin
@Slf4j
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;


    @PostMapping
    public Result save(@RequestBody Article article) {
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    @GetMapping("/search/{keywords}/{page}/{size}")
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
        log.info("查询数量:{}",articlePage.getContent().size());
        return new Result(true, StatusCode.OK, "", new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
    }
}
