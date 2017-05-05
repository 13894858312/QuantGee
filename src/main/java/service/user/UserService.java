package service.user;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface UserService {

    public String getCollectedStockCode(String userID);

    public String getCollectedStrategy(String userID);

    public String collectStock();

    public String collectStrategy();

    public String getFriends();

    public String addFriends();

    public String deleteFriends();
}
