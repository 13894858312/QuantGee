package logic.tools;

import bean.Account;
import bean.User;
import po.UserAnalysisDataPO;
import vo.admin.UserAnalysisDataVO;
import vo.user.AccountVO;
import vo.user.UserVO;

/**
 * Created by Mark.W on 2017/5/15.
 * vo与entity的转换
 */
public class TransferHelper {

    /**
     * 将accountvo转换为account
     * @param accountVO accountVO
     * @return Account
     */
    public static Account transToAccount(AccountVO accountVO) {
        if(accountVO == null) {
            return null;
        }

        Account account = new Account();
        account.setUserId(accountVO.getAccountID());
        account.setPassword(accountVO.getPassword());
        account.setRegisterDate(accountVO.getRegisterDate());

        return account;
    }

    /**
     * 将UserAnalysisDataPO转换为UserAnalysisDataVO
     * @param analysisDataPO analysisDataPO
     * @return  UserAnalysisDataVO
     */
    public static UserAnalysisDataVO transToUserAnalysisVO(UserAnalysisDataPO analysisDataPO) {
        if(analysisDataPO == null) {
            return null;
        }

        UserAnalysisDataVO userAnalysisDataVO = new
                UserAnalysisDataVO(analysisDataPO.getUserNum(), analysisDataPO.getRegisterNumByTime());
        return userAnalysisDataVO;
    }

    /**
     * 将UserVO转换为User
     * @param userVO userVO
     * @return User
     */
    public static User transToUser(UserVO userVO) {
        if(userVO == null) {
            return null;
        }

        User user = new User();
        user.setUserId(userVO.getAccountID());
        user.setAlterName(userVO.getUserName());
        user.setPhoneNumber(userVO.getPhoneNumber());

        return user;
    }

    /**
     * 将User转换为UserVO
     * @param user user
     * @return User
     */
    public static UserVO transToUserVO(User user) {
        if(user == null) {
            return null;
        }

        UserVO userVO = new UserVO();
        user.setUserId(user.getUserId());
        user.setAlterName(user.getAlterName());
        user.setPhoneNumber(user.getPhoneNumber());

        return userVO;
    }
}
