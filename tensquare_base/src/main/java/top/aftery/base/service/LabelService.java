package top.aftery.base.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.base.dao.LabelDao;
import top.aftery.base.pojo.Label;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LableService
 * @Description LableService
 * @Author Aftery
 * @Date 2020/1/20 13:34
 * @Version 1.0
 */
@Slf4j
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        log.info("添加数据是:{}", label);
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        label.setId(snowflake.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * @param label
     * @return
     */
    public List<Label> findSearch(Label label) {
        List<Label> all = labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，也就是要把条件封装到那个对象中去
             * @param query 封装的查询条件，group By order by等
             * @param cb 用来封装条件的对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (StrUtil.isNotEmpty(label.getLabelname())) {
                    Predicate labelname = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(labelname);
                }
                if (StrUtil.isNotEmpty(label.getState())) {
                    Predicate labelname = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(labelname);
                }

                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return cb.and(predicates);
            }
        });
        return all;
    }

    /**
     * @param label
     * @param page
     * @param size
     * @return
     */
    public Page<Label> pageSearch(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);

        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (StrUtil.isNotEmpty(label.getLabelname())) {
                    Predicate labelname = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(labelname);
                }
                if (StrUtil.isNotEmpty(label.getState())) {
                    Predicate labelname = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(labelname);
                }

                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return cb.and(predicates);
            }
        }, pageable);
    }
}
