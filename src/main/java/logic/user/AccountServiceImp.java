package logic.user;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import logic.tools.TransferHelper;
import service.user.AccountService;
import vo.user.AccountVO;

/**
 * Created by Mark.W on 2017/5/9.
 */
public class AccountServiceImp implements AccountService{

    private AccountDAO accountDAO;

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean register(AccountVO accountVO) {
        Account account = TransferHelper.transToAccount(accountVO);
        return accountDAO.addAccount(account);
    }

    @Override
    public boolean login(AccountVO accountVO) {
        if(accountVO != null) {
            Account account = accountDAO.getAccount(accountVO.getAccountID());

            if(accountVO.getPassword().equals(account.getPassword())) {
                account.setIsLogIn(1);
                if(accountDAO.updateAccount(account)) {        //更新登陆状态
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean modifyPassword(AccountVO accountVO) {
        if(accountVO != null) {
            Account account = accountDAO.getAccount(accountVO.getAccountID());

            account.setPassword(accountVO.getPassword());
            if(accountDAO.updateAccount(account)) {        //更新密码
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean logout(AccountVO accountVO) {
        if(accountVO != null) {
            Account account = accountDAO.getAccount(accountVO.getAccountID());

            account.setIsLogIn(0);
            if(accountDAO.updateAccount(account)) {        //更新登出状态
                return true;
            }
        }
        return false;
    }
}
