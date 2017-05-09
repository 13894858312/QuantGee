package data.accountData;

import DAO.accountDAO.AccountDAO;
import bean.Account;

/**
 * Created by wangxue on 2017/5/5.
 */
public class AccountData implements AccountDAO {

    @Override
    public boolean addAccount(Account account) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }
}
