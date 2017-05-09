package DAO.accountDAO;

import PO.AccountPO;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface AccountDAO {

    /**
     * 添加用户账户
     * @param accountPO 要添加的用户账户
     * @return boolean 是否添加成功
     */
    public boolean addAccount(AccountPO accountPO);

    /**
     * 修改用户账户信息
     * @param accountPO 要修改的用户账户
     * @return boolean 是否修改成功
     */
    public boolean updateAccount(AccountPO accountPO);

}
