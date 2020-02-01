package top.aftery.search.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @ClassName Article
 * @Description Article
 * @Author Aftery
 * @Date 2020/2/1 12:48
 * @Version 1.0
 */
@Getter
@Setter
@Document(indexName = "tensquare", type = "article")
public class Article {
    @Id
    private String id;


    //是否索引,就是看该域是否能被搜索
    //是否分词,就是表示搜索的时候是整体匹配还是单词匹配
    //是否存储,就是是否在页面上显示
    //标题
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    //文章正文
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    //审核状态
    private String state;

}
