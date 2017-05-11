package service.user;

import vo.user.UserVO;

/**
 * Created by Mark.W on 2017/5/5.
 * 用户信息操作的接口
 */
public interface UserService {

	/**
	 * 更新用户的基本信息
	 * @param userVO	用户信息
	 * @return boolean 是否更新成功
	 */
    public boolean updateUserInfo(UserVO userVO);

    /**
     * 获取用户的基本信息
     * @param accountID 用户id
     * @return UserVO
     */
    public UserVO getUserInfo(String accountID);

}

