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
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userId, String friendid) {
        //首先判断有没有数据，有的话就不能重复添加
        Friend byUseridAndFriendid = friendDao.findByUseridAndFriendid(userId, friendid);
        if (byUseridAndFriendid != null) {
            return 0;
        }

        //向喜欢表中添加记录,单方面关注Islike设置为0
        byUseridAndFriendid = new Friend();
        byUseridAndFriendid.setUserid(userId);
        byUseridAndFriendid.setFriendid(friendid);
        byUseridAndFriendid.setIslike("0");
        friendDao.save(byUseridAndFriendid);
        //判断对方是否喜欢你，如果喜欢，将islike设置为1
        if (friendDao.findByUseridAndFriendid(friendid, userId) != null) {
            //把双方islike设置为1
            friendDao.updateIslike("1", userId, friendid);
            friendDao.updateIslike("1", friendid, userId);
        }
        return 1;
    }

    /**
     *
     * @param userId 当前用户
     * @param friendid 目标用户
     */
    public void deleFriend(String userId, String friendid) {
        //删除表中userId到friendid
        friendDao.deleteFriend(userId,friendid);
        //更新friendid表中的islike设置为0
        friendDao.updateIslike("0",friendid,userId);
        //添加数据到非好友表中
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userId);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);


    }
}
