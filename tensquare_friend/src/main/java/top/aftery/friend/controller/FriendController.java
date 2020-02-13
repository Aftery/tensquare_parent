package top.aftery.friend.controller;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.friend.client.UserClient;
import top.aftery.friend.dao.NoFriendDao;
import top.aftery.friend.service.FriendService;
import top.aftery.friend.service.NoFriendService;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName FriendController
 * @Description FriendController
 * @Author Aftery
 * @Date 2020/2/13 14:39
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private NoFriendService noFriendService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserClient userClient;

    @PutMapping("/like/{friendid}/{type}")
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        Claims user_claims = (Claims) request.getAttribute("user_claims");
        if (null == user_claims) {
            return new Result(false, StatusCode.LOGINERROR, "权限不足!");
        }

        if (StrUtil.isNotEmpty(friendid)) {
            if (StrUtil.isNotEmpty(type)) {
                if ("1".equalsIgnoreCase(type)) {
                    //喜欢
                    int flag = friendService.addFriend(user_claims.getId(), friendid);
                    if (flag == 0) {
                        return new Result(false, StatusCode.ERROR, "不能重复添加好友!");
                    } else if (flag == 1) {
                        //更新用户的关注数和被关注者的粉丝数
                        userClient.updateFollowcountAndFanscount(user_claims.getId(), friendid, 1);
                        return new Result(false, StatusCode.ERROR, "添加好友成功!");
                    }
                }
                if ("2".equalsIgnoreCase(type)) {
                    //不喜欢
                    int flag = noFriendService.addNoFriend(user_claims.getId(), friendid);
                    if (flag == 0) {
                        return new Result(false, StatusCode.ERROR, "不能重复添加非好友!");
                    } else if (flag == 1) {
                        return new Result(false, StatusCode.ERROR, "添加非好友成功!");
                    }

                }
            }
        }

        return new Result(false, StatusCode.ERROR, "请求参数错误!");
    }

    @DeleteMapping("/{friendid}")
    public Result deleFriend(@PathVariable String friendid) {
        Claims user_claims = (Claims) request.getAttribute("user_claims");
        if (null == user_claims) {
            return new Result(false, StatusCode.LOGINERROR, "权限不足!");
        }
        if (StrUtil.isNotEmpty(friendid)) {
            friendService.deleFriend(user_claims.getId(), friendid);
            //更新用户的关注数和被关注者的粉丝数
            userClient.updateFollowcountAndFanscount(user_claims.getId(), friendid, -1);
            return new Result(false, StatusCode.ERROR, "删除好友成功!");
        }
        return new Result(false, StatusCode.ERROR, "请求参数错误!");
    }
}
