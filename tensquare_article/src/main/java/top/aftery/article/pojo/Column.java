package top.aftery.article.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * @ClassName Column
 * @Description Column
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="tb_column")
public class Column implements Serializable{

	@Id
	//ID
	private String id;
	//专栏名称
	private String name;
	//专栏简介
	private String summary;
	//用户ID
	private String userid;
	//申请日期
	private java.util.Date createtime;
	//审核日期
	private java.util.Date checktime;
	//状态
	private String state;


}
