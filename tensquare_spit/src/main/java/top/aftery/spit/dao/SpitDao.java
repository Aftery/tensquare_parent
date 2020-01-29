package top.aftery.spit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.aftery.spit.pojo.Spit;

/**
 * @ClassName SpitDao
 * @Description SpitDao
 * @Author Aftery
 * @Date 2020/1/29 15:50
 * @Version 1.0
 */
public interface SpitDao extends MongoRepository<Spit,String> {

}
