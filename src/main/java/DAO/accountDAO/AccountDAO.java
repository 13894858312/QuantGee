package DAO.accountDAO;

import bean.Account;
import po.UserAnalysisDataPO;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface AccountDAO {

    /**
     * 添加用户账户并更新注册统计数据
     * @param account 要添加的用户账户
     * @return boolean 是否添加成功
     */
    public boolean addAccount(Account account);

    /**
     * 修改用户账户信息
     * @param account 要修改的用户账户
     * @return boolean 是否修改成功
     */
    public boolean updateAccount(Account account);

    /**
     * 获取用户账号信息
     * @param userID 用户id
     * @return  Account
     */
    public Account getAccount(String userID);

    /**
     * 获取网站数据分析的结果
     * @return 返回到截止日期为止的用户数量
     */
    public UserAnalysisDataPO getUserAnalysisData();

}
