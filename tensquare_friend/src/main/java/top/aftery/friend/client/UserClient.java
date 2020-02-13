package top.aftery.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName UserClient
 * @Description UserClient
 * @Author Aftery
 * @Date 2020/2/13 18:08
 * @Version 1.0
 */
@Component
@FeignClient("tensquare-user")
public interface UserClient {

    @PostMapping("/user/{userId}/{friendid}/{x}")
    void updateFollowcountAndFanscount(@PathVariable("userId") String userId, @PathVariable("friendid") String friendid,@PathVariable("x") int x);
}
