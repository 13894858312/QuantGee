package logic.user;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.user.AccountService;
import vo.user.AccountVO;

/**
 * Created by Mark.W on 2017/5/9.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountServiceImp implements AccountService{

//    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransferHelper transferHelper;

    @Override
    public boolean register(AccountVO accountVO) {
        Account account = transferHelper.transToAccount(accountVO);
        return accountDAO.addAccount(account);
    }

    @Override
    public boolean login(AccountVO accountVO) {
//        Account account = accountDAO.getAccount(accountVO.getAccountID());
//
//        if(accountVO.getPassword().equals(account.getPassword())) {
//            account.setIsLogIn(1);
//            if(accountDAO.updateAccount(account)) {        //更新登陆状态
//                return true;
//            }
//        }
//
//        return false;

        if (accountVO.getAccountID().equals("bcy")&&accountVO.getPassword().equals("bcy")){
			return true;
		}else {
			return false;
		}
    }

    @Override
    public boolean modifyPassword(AccountVO accountVO) {
        Account account = accountDAO.getAccount(accountVO.getAccountID());

        account.setPassword(accountVO.getPassword());
        if(accountDAO.updateAccount(account)) {        //更新密码
            return true;
        }

        return false;
    }

    @Override
    public boolean logout(AccountVO accountVO) {
        Account account = accountDAO.getAccount(accountVO.getAccountID());

        account.setIsLogIn(0);
        if(accountDAO.updateAccount(account)) {        //更新登出状态
            return true;
        }
        return false;
    }
}
