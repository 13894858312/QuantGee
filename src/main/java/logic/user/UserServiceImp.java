package logic.user;

import vo.user.UserVO;
import service.user.UserService;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class UserServiceImp implements UserService {

    @Override
    public boolean updateUserInfo(UserVO userVO) {
        return false;
    }

    @Override
    public UserVO getUserInfo(String accountID) {
        return null;
    }
}
