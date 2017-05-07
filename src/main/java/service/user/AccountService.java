package service.user;


import bean.Account;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AccountService {

	/**
	 * 注册帐号
	 * @param account		帐号信息
	 * @return boolean		是否注册成功
	 */
    public boolean register(Account account);

    /**
	 * 登录帐号
	 * @param account		帐号信息
	 * @return boolean		是否登录成功
	 */
    public boolean login(Account account);

    /**
	 * 修改帐号信息
	 * @param account		帐号信息
	 * @return boolean		是否修改成功
	 */
    public boolean modifyPassword(Account account);

    /**
	 * 登出帐号
	 * @param account		帐号信息
	 * @return boolean		是否登出成功
	 */
    public boolean logout(Account account);

}
