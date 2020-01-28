package top.aftery.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.aftery.article.pojo.Channel;
/**
 * @ClassName ChannelDao
 * @Description ChannelDao
 * @Author Aftery
 * @Date 2020/1/28 12:04
 * @Version 1.0
 */
public interface ChannelDao extends JpaRepository<Channel,String>,JpaSpecificationExecutor<Channel>{
	
}
