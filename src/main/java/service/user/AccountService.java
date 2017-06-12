package service.user;


import vo.user.AccountVO;

/**
 * Created by Mark.W on 2017/5/5.
 * 用户登陆登出注册修改密码的接口
 */
public interface AccountService {

	/**
	 * 注册帐号
	 * @param account		帐号信息
	 * @return boolean		是否注册成功
	 */
    public boolean register(AccountVO account);

    /**
	 * 登录帐号
	 * @param account		帐号信息
	 * @return boolean		是否登录成功
	 */
    public boolean login(AccountVO account);

    /**
	 * 修改帐号信息
	 * @param account		帐号信息
	 * @return boolean		是否修改成功
	 */
    public boolean modifyPassword(AccountVO account);

    /**
	 * 登出帐号
	 * @param account		帐号信息
	 * @return boolean		是否登出成功
	 */
    public boolean logout(AccountVO account);

	/**
	 * 验证原密码 用来修改密码
	 * @param account  帐号信息
	 * @return boolean
	 */
	public boolean checkAccount(AccountVO account);

}
