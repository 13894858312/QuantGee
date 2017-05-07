package DAO.accountDAO;

import bean.Account;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface AccountDAO {

    public boolean addAccount(Account account);

    public boolean updateAccount(Account account);

}
