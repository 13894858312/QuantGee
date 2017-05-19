package logic.admin;

import DAO.accountDAO.AccountDAO;
import DAO.userDAO.UserDAO;
import bean.Account;
import bean.User;
import logic.tools.TransferHelper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import po.UserAnalysisDataPO;
import vo.admin.UserAccountVO;
import vo.admin.UserAnalysisDataVO;
import service.admin.AdminService;

/**
 * Created by Mark.W on 2017/5/9.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AdminServiceImp implements AdminService{

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TransferHelper transferHelper;

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
        return transferHelper.transToUserAnalysisVO(analysisData);
    }

}
