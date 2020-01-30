package top.aftery.spit.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.PageResult;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.spit.pojo.Spit;
import top.aftery.spit.service.SpitService;

import java.security.PublicKey;

/**
 * @ClassName SpitController
 * @Description SpitController
 * @Author Aftery
 * @Date 2020/1/29 15:54
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findOne(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
    }

    /**
     * 增加
     *
     * @param spit
     */
    @PostMapping()
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param spit
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Spit spit, @PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据上级ID查询吐槽数据（分页）
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/comment/{parentid}/{page}/{size}")
    public Result findByParentid(@PathVariable String parentid, @PathVariable int page, int size) {
        Page<Spit> parents = spitService.findByParentid(parentid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Spit>(parents.getTotalElements(), parents.getContent()));
    }


    //吐槽点赞
    @PutMapping(" /thumbup/{spitId}")
    public Result updateThumbup(@PathVariable String spitId){
        //判断用户是否对这个吐槽点过赞
        // 后边我们会修改为当前登陆的用户
        String userid="2023";
        if(redisTemplate.opsForValue().get("thumbup_" + userid + "_" + spitId)!=null){
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.updateThumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + spitId,1);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

}
