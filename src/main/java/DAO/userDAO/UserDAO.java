package DAO.userDAO;

import PO.UserPO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface UserDAO {

    /**
     * 修改用户信息
     * @param userPO 用户信息
     * @return boolean 是否添加成功
     */
    public boolean updateUserInfo(UserPO userPO);

    /**
     * 按ID搜索用户
     * @param userID 用户ID
     * @return User 用户信息
     */
    public UserPO searchUser(String userID);

}
