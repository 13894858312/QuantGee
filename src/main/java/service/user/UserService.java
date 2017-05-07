package service.user;

import bean.User;
import input.FriendsInput;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface UserService {

	/**
	 * 更新用户信息
	 * @param user	用户信息
	 * @return boolean 是否更新成功
	 */
    public boolean updateUserInfo(User user);

    /**
     * 获取好友列表
     * @param accountID 用户ID
     * @return  ArrayList<User> 好友列表
     */
    public ArrayList<User> getFriends(String accountID);

    /**
     * 查找好友
     * @param accountID 好友ID
     * @return User 好友的User
     */
    public User searchFriend(String accountID);
    
    /**
     * 添加好友
     * @param friendsInput 
     * @return boolean 是否添加成功
     */
    public boolean addFriends(FriendsInput friendsInput);

    /**
     * 删除好友
     * @param friendsInput
     * @return boolean 是否删除成功
     */
    public boolean deleteFriends(FriendsInput friendsInput);
}

