package top.aftery.friend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aftery.friend.dao.FriendDao;
import top.aftery.friend.dao.NoFriendDao;
import top.aftery.friend.pojo.Friend;
import top.aftery.friend.pojo.NoFriend;

/**
 * @ClassName FriendService
 * @Description FriendService
 * @Author Aftery
 * @Date 2020/2/13 14:39
 * @Version 1.0
 */
@Service
@Transactional
public class NoFriendService {

    @Autowired
    private NoFriendDao noFriendDao;


    public int addNoFriend(String userId, String friendid) {
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userId, friendid);
        if (noFriend != null) {
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserid(userId);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }
}
