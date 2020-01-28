package top.aftery.article.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @ClassName Channel
 * @Description Channel
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="tb_channel")
public class Channel implements Serializable{

	@Id
	private String id;//ID
	private String name;//频道名称
	private String state;//状态

}
