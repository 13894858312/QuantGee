package DAO.userDAO;

import bean.User;
import po.UserPO;

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



}
