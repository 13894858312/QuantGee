package logic.user;

import DAO.userDAO.UserDAO;
import bean.User;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import vo.user.UserVO;
import service.user.UserService;

/**
 * Created by Mark.W on 2017/5/9.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
        User user = userDAO.searchUser(accountID);
        return transferHelper.transToUserVO(user);
    }

}
