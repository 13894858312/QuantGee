package service.user;

import vo.UserVO;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface UserService {

	/**
	 * 更新用户的基本信息
	 * @param userVO	用户信息
	 * @return boolean 是否更新成功
	 */
    public boolean updateUserInfo(UserVO userVO);

    /**
     * 获取用户的基本信息
     * @param accountID 用户id
     * @return UserVO
     */
    public UserVO getUserInfo(String accountID);

//    /**
//     * 获取好友列表
//     * @param accountID 用户ID
//     * @return  ArrayList<UserVO> 好友列表
//     */
//    public ArrayList<UserVO> getFriends(String accountID);
//
//    /**
//     * 查找好友
//     * @param accountID 好友ID
//     * @return User 好友的User
//     */
//    public UserVO searchFriend(String accountID);
//
//    /**
//     * 添加好友
//     * @param friendsForm
//     * @return boolean 是否添加成功
//     */
//    public boolean addFriends(FriendsForm friendsForm);
//
//    /**
//     * 删除好友
//     * @param friendsForm
//     * @return boolean 是否删除成功
//     */
//    public boolean deleteFriends(FriendsForm friendsForm);
}

