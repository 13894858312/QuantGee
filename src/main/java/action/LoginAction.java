package action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.user.AccountService;
import vo.user.AccountVO;

@Controller
public class LoginAction extends ActionSupport{

//	private AccountVO accountVO = new AccountVO(); // 表单中的姓名
	private AccountVO accountVO; // 表单中的姓名

	@Autowired
	private AccountService accountService;

	public String login() {

		if(accountService.login(accountVO)) {
			return SUCCESS;
		} else {
			return "fail";
		}

	}
	public String logout() {
		System.out.println("yes");
		if(accountService.login(accountVO)) {
			return SUCCESS;
		} else {
			return "fail";
		}

	}

	public AccountVO getAccountVO() {
		return accountVO;
	}

	public void setAccountVO(AccountVO accountVO) {
		this.accountVO = accountVO;
	}

}
