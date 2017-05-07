package DAO.userDAO;

import bean.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface UserDAO {

    public boolean updateUserInfo(User user);

    public boolean addFriend(String userID , String friendID);

    public boolean deleteFriend(String userID , String friendID);

    public ArrayList<User> getFriendList(String userID);

}
