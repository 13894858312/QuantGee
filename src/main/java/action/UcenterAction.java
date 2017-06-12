package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.user.AccountService;
import service.user.UserService;
import vo.user.AccountVO;
import vo.user.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by duoduogao on 17/6/12.
 */
@Controller
public class UcenterAction extends ActionSupport {

    private String result;
    private String accountID;
    private UserVO userVO;

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
        JSONObject json = JSONObject.fromObject(userVO);
        result = json.toString();
        return SUCCESS;
    }

    public String updateUserInfo(){
        if (userService.updateUserInfo(userVO)){
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("tipMessage", "修改成功！");
            result= JSONObject.fromObject(userVO).toString();
            return SUCCESS;
        }else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("tipMessage", "修改失败！");
            return SUCCESS;
        }
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

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}
