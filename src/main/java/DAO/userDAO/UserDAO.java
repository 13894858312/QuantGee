package DAO.userDAO;

import bean.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface UserDAO {

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return boolean 是否添加成功
     */
    public boolean updateUserInfo(User user);

    /**
     * 按ID搜索用户
     * @param userID 用户ID
     * @return User 用户信息
     */
    public User searchUser(String userID);

    /**
     *
     * @param
     * @return
     */
    public boolean addFriend(String userID , String friendID);

    /**
     *
     * @param
     * @return
     */
    public boolean deleteFriend(String userID , String friendID);

    /**
     *
     * @param
     * @return
     */
    public ArrayList<User> getFriendList(String userID);

}
