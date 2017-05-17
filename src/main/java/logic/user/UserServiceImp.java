package logic.user;

import DAO.userDAO.UserDAO;
import bean.User;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import vo.user.UserVO;
import service.user.UserService;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TransferHelper transferHelper;

    @Override
    public boolean updateUserInfo(UserVO userVO) {
        User user = transferHelper.transToUser(userVO);
        if(user != null) {
            if(userDAO.updateUserInfo(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserVO getUserInfo(String accountID) {
//        User user = userDAO.searchUser(accountID);
//        return transferHelper.transToUserVO(user);

        UserVO userVO = new UserVO("wyy", "wyyyy", "wyyyyyy");
        return userVO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public TransferHelper getTransferHelper() {
        return transferHelper;
    }

    public void setTransferHelper(TransferHelper transferHelper) {
        this.transferHelper = transferHelper;
    }
}
