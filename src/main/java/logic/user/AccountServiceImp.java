package logic.user;

import DAO.accountDAO.AccountDAO;
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
    public boolean register(AccountVO account) {
        return false;
    }

    @Override
    public boolean login(AccountVO account) {
        return false;
    }

    @Override
    public boolean modifyPassword(AccountVO account) {
        return false;
    }

    @Override
    public boolean logout(AccountVO account) {
        return false;
    }
}
