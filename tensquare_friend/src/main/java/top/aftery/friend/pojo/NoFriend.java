package top.aftery.friend.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName NoFriend
 * @Description NoFriend
 * @Author Aftery
 * @Date 2020/2/13 14:35
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_nofriend")
@IdClass(NoFriend.class)
public class NoFriend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;

}
