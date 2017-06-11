package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import service.user.AccountService;
import service.user.UserService;
import vo.user.UserVO;

import java.util.Map;

/**
 * Created by duoduogao on 17/6/12.
 */
public class UcenterAction extends ActionSupport {

    private String result;
    private String accountID;

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;


    public String haveLogin() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        JSONObject jsonObject = JSONObject.fromObject(session);
        result = jsonObject.toString();
        if (session.get("accountID") != null) {
            return SUCCESS;
        } else {
            result = "{" + '"' + "accountID" + '"' + ":" + '"' + '"' + "}";
        }
        return SUCCESS;
    }

    public String getUserInfo() {
        UserVO userVO = userService.getUserInfo(accountID);
        System.out.println((userVO == null) + "   1");
        JSONObject json = JSONObject.fromObject(userVO);
        result = json.toString();
        return SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
