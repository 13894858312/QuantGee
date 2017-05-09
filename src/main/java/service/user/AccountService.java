package service.user;


import PO.AccountPO;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AccountService {

	/**
	 * 注册帐号
	 * @param accountPO		帐号信息
	 * @return boolean		是否注册成功
	 */
    public boolean register(AccountPO accountPO);

    /**
	 * 登录帐号
	 * @param accountPO		帐号信息
	 * @return boolean		是否登录成功
	 */
    public boolean login(AccountPO accountPO);

    /**
	 * 修改帐号信息
	 * @param accountPO		帐号信息
	 * @return boolean		是否修改成功
	 */
    public boolean modifyPassword(AccountPO accountPO);

    /**
	 * 登出帐号
	 * @param accountPO		帐号信息
	 * @return boolean		是否登出成功
	 */
    public boolean logout(AccountPO accountPO);

}
