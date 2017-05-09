package data.userData;

import DAO.userDAO.UserDAO;
import po.UserPO;

/**
 * Created by wangxue on 2017/5/5.
 */
public class UserData implements UserDAO{

    @Override
    public boolean updateUserInfo(UserPO userPO) {
        return false;
    }

    @Override
    public UserPO searchUser(String userID) {
        return null;
    }

}
