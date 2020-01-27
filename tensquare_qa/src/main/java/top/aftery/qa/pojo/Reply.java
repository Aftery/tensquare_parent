package top.aftery.qa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @ClassName Reply
 * @Description Reply
 * @Author Aftery
 * @Date 2020/1/27 19:43
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="tb_reply")
public class Reply implements Serializable{

	@Id
	private String id;//编号
	private String problemid;//问题ID
	private String content;//回答内容
	private java.util.Date createtime;//创建日期
	private java.util.Date updatetime;//更新日期
	private String userid;//回答人ID
	private String nickname;//回答人昵称
}
