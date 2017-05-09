package data.accountData;

import DAO.accountDAO.AccountDAO;
import PO.AccountPO;

/**
 * Created by wangxue on 2017/5/5.
 */
public class AccountData implements AccountDAO {

    @Override
    public boolean addAccount(AccountPO accountPO) {
        return false;
    }

    @Override
    public boolean updateAccount(AccountPO accountPO) {
        return false;
    }

}
