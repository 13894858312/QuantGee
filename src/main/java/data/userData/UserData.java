package data.userData;

import DAO.userDAO.UserDAO;
import bean.User;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class UserData implements UserDAO {

    @Override
    public boolean updateUserInfo(User user) {
        return false;
    }

    @Override
    public User searchUser(String userID) {
        return null;
    }

    @Override
    public boolean addFriend(String userID, String friendID) {
        return false;
    }

    @Override
    public boolean deleteFriend(String userID, String friendID) {
        return false;
    }

    @Override
    public ArrayList<User> getFriendList(String userID) {
        return null;
    }

}
