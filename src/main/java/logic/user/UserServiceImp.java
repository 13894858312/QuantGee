package logic.user;

import vo.UserForm;
import service.user.UserService;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class UserServiceImp implements UserService {

    @Override
    public boolean updateUserInfo(UserForm userForm) {
        return false;
    }

    @Override
    public UserForm getUserInfo(String accountID) {
        return null;
    }
}
