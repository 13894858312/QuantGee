package logic.user;

import DAO.userDAO.UserDAO;
import bean.User;
import logic.tools.TransferHelper;
import vo.user.UserVO;
import service.user.UserService;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    @Override
    public boolean updateUserInfo(UserVO userVO) {
        User user = TransferHelper.transToUser(userVO);
        if(user != null) {
            if(userDAO.updateUserInfo(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserVO getUserInfo(String accountID) {
        User user = userDAO.searchUser(accountID);
        return TransferHelper.transToUserVO(user);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
