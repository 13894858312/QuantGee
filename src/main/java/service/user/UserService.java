package service.user;

import bean.User;
import input.FriendsInput;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface UserService {

    public boolean updateUserInfo(User user);

    public ArrayList<User> getFriends(String userID);

    public boolean addFriends(FriendsInput friendsInput);

    public boolean deleteFriends(FriendsInput friendsInput);
}
