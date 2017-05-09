package logic.user;

import DAO.accountDAO.AccountDAO;
import bean.Account;
import service.user.AccountService;

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
    public boolean register(Account account) {
        return false;
    }

    @Override
    public boolean login(Account account) {
        return false;
    }

    @Override
    public boolean modifyPassword(Account account) {
        return false;
    }

    @Override
    public boolean logout(Account account) {
        return false;
    }
}
