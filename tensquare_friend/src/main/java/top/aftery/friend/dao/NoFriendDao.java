package top.aftery.friend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.aftery.friend.pojo.Friend;
import top.aftery.friend.pojo.NoFriend;

/**
 * @ClassName FriendDao
 * @Description FriendDao
 * @Author Aftery
 * @Date 2020/2/13 14:38
 * @Version 1.0
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {

    /**
     * 查询有没有关注
     * @param userid 关注者id
     * @param friendid 被关注者id
     * @return
     */
    NoFriend findByUseridAndFriendid(String userid, String friendid);

    /**
     * 修改相互关注状态
     * @param islike 状态
     * @param userid 关注者id
     * @param friendid 被关注者id
     */
    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?",nativeQuery = true)
    void updateIslike(String islike, String userid, String friendid);

}
