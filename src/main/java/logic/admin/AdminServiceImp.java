package logic.admin;

import DAO.accountDAO.AccountDAO;
import DAO.userDAO.UserDAO;
import bean.Account;
import bean.User;
import logic.tools.TransferHelper;
import po.UserAnalysisDataPO;
import po.UserPO;
import vo.admin.UserAccountVO;
import vo.admin.UserAnalysisDataVO;
import service.admin.AdminService;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class AdminServiceImp implements AdminService{

    private AccountDAO accountDAO;
    private UserDAO userDAO;

    @Override
    public UserAccountVO searchUser(String userID) {
        Account account = accountDAO.getAccount(userID);
        User user = userDAO.searchUser(userID);

        if(account == null || user == null) {
            return null;
        }

        UserAccountVO userAccountVO = new UserAccountVO();
        userAccountVO.setAccountID(account.getUserId());
        userAccountVO.setRegisterDate(account.getRegisterDate());
        userAccountVO.setPhoneNumber(user.getPhoneNumber());
        userAccountVO.setUserName(user.getAlterName());

        return userAccountVO;
    }

    @Override
    public UserAnalysisDataVO getUserAnalysisData() {
        UserAnalysisDataPO analysisData = accountDAO.getUserAnalysisData();
        return TransferHelper.transToUserAnalysisVO(analysisData);
    }


    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
