package service.user;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface UserService {

    public boolean updateUserInfo(User user);

    public ArrayList<User> getFriends();

    public boolean addFriends();

    public boolean deleteFriends();

}
