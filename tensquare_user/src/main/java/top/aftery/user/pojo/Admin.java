package top.aftery.user.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Admin
 * @Description Admin
 * @Author Aftery
 * @Date 2020/1/28
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {

    @Id
    private String id;//ID
    private String loginname;//登陆名称
    private String password;//密码
    private String state;//状态
}
