package form;

/**
 * Created by Mark.W on 2017/5/7.
 */
public class FriendsForm {
    private String userID;
    private String friendID;

    public FriendsForm(String userID, String friendID) {
        this.userID = userID;
        this.friendID = friendID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFriendID() {
        return friendID;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }
}
