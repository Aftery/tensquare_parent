package top.aftery.friend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import top.aftery.friend.pojo.Friend;

/**
 * @ClassName FriendDao
 * @Description FriendDao
 * @Author Aftery
 * @Date 2020/2/13 14:38
 * @Version 1.0
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    /**
     * 查询有没有关注
     *
     * @param userid   关注者id
     * @param friendid 被关注者id
     * @return
     */
    Friend findByUseridAndFriendid(String userid, String friendid);

    /**
     * 修改相互关注状态
     *
     * @param islike   状态
     * @param userid   关注者id
     * @param friendid 被关注者id
     */
    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?", nativeQuery = true)
    void updateIslike(String islike, String userid, String friendid);

    /**
     * 删除当前好友列表
     *
     * @param userId   当前用户
     * @param friendid 操作的目标用户
     */
    @Modifying
    @Query(value = "delete from tb_friend where  userid=? and friendid=?", nativeQuery = true)
    void deleteFriend(String userId, String friendid);
}
