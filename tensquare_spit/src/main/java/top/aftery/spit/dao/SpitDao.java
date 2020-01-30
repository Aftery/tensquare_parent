package top.aftery.spit.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import top.aftery.spit.pojo.Spit;

/**
 * @ClassName SpitDao
 * @Description SpitDao
 * @Author Aftery
 * @Date 2020/1/29 15:50
 * @Version 1.0
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据上级ID查询吐槽列表（分页）
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
