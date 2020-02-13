package top.aftery.user.controller;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.PageResult;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.common.util.JwtUtil;
import top.aftery.user.pojo.User;
import top.aftery.user.service.UserService;

import javax.crypto.interfaces.PBEKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName User
 * @Description User
 * @Author Aftery
 * @Date 2020/1/28
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * @param userId   添加关注数用户的id
     * @param friendid 添加粉丝的用户id
     * @param x        数量
     */
    @PostMapping("/{userId}/{friendid}/{x}")
    public void updateFollowcountAndFanscount(@PathVariable String userId, @PathVariable String friendid, @PathVariable int x) {
        userService.updateFollowcountAndFanscount(x, userId, friendid);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        user = userService.login(user.getMobile(), user.getPassword());
        if (user == null) {
            return new Result(false, StatusCode.LOGINERROR, "登录失败");
        }
        //生成token
        String token = jwtUtil.createJWT(user.getId(), user.getNickname(), "user");
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("roles", "user");
        return new Result(true, StatusCode.OK, "登录成功", map);

    }

    @PostMapping("/sendsms/{mobile}")
    public Result sendSms(@PathVariable String mobile) {
        if (!Validator.isMobile(mobile)) {
            return new Result(false, StatusCode.ERROR, "请输入正确的手机号码!");
        }
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK, "验证码发送成功");
    }

    @PostMapping("/register/{code}")
    public Result regist(@PathVariable String code, @RequestBody User user) {
        String checkCode = (String) redisTemplate.opsForValue().get("smscode_" + user.getMobile());

        if (StrUtil.isEmpty(checkCode)) {
            return new Result(false, StatusCode.ERROR, "请先获取手机验证码!");
        }
        if (!checkCode.equals(code)) {
            return new Result(false, StatusCode.ERROR, "请输入正确验证码!");
        }
        boolean mobile = Validator.isMobile(user.getMobile());

        if (!Validator.isMobile(user.getMobile())) {
            return new Result(false, StatusCode.ERROR, "请输入正确手机号码!");
        }
        userService.add(user);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping()
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @PostMapping(value = "/search")
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param user
     */
    @PostMapping()
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param user
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     * 必须是管理员才能删除
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }


}
