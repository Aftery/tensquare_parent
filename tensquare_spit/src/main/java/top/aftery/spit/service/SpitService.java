package top.aftery.spit.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aftery.spit.dao.SpitDao;
import top.aftery.spit.pojo.Spit;

import java.util.List;

/**
 * @ClassName SpitService
 * @Description SpitService
 * @Author Aftery
 * @Date 2020/1/29 15:51
 * @Version 1.0
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */

    public Spit findById(String id) {
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 增加
     *
     * @param spit
     */
    public void add(Spit spit) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        //主键值
        spit.set_id(snowflake.nextId() + "");
        spitDao.save(spit);
    }

    /**
     * 修改
     *
     * @param spit
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

}
