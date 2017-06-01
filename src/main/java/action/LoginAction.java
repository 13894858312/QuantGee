package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.user.AccountService;
import vo.user.AccountVO;

import java.util.ArrayList;

@Controller
public class LoginAction extends ActionSupport {

    //	private AccountVO accountVO = new AccountVO(); // 表单中的姓名
    private AccountVO accountVO; // 表单中的姓名
    private ArrayList<String> testStrings;


    @Autowired
    private AccountService accountService;

    //	@Result({
//			@Result(name = "success" ,value = "/view/ucenter/user_center.jsp"),
//			@Result(name = "fail" ,value = "/view/ucenter/login.jsp")
//	})
    public String login() {
        testStrings = new ArrayList<>();
        testStrings.add("bcy");
        testStrings.add("gzy");
        testStrings.add("love");
//		if(accountService.login(accountVO)) {
        return SUCCESS;
//		} else {
//			return "fail";
//		}

    }

    public String logout() {
        System.out.println("yes");
        if (accountService.login(accountVO)) {
            return SUCCESS;
        } else {
            return "fail";
        }

    }

    public String register() {

        if (accountService.register(accountVO)) {
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

    public ArrayList<String> getTestStrings() {
        return testStrings;
    }

    public void setTestStrings(ArrayList<String> testStrings) {
        this.testStrings = testStrings;
    }

}
