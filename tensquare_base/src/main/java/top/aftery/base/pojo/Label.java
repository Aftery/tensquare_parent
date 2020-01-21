package top.aftery.base.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Label
 * @Description Label
 * @Author Aftery
 * @Date 2020/1/20 13:15
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

    @Id
    private String id;
    //标签名称   
    private String labelname;
    //状态    
    private String state;
    //使用数量
    private Long count;
    //关注数    
    private Long fans;
    //是否推荐
    private String recommend;

}
