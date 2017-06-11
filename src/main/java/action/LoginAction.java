package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.RE;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.CollectStockService;
import service.user.AccountService;
import vo.stock.StockCurrentVO;
import vo.user.AccountVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class LoginAction extends ActionSupport {

    private HttpServletRequest request;

    //	private AccountVO accountVO = new AccountVO(); // 表单中的姓名
    private AccountVO accountVO; // 表单中的姓名


    private ArrayList<StockCurrentVO> stockCurrentVOS; //用户收藏的股票


    private String result;

    @Autowired
    private AccountService accountService;
    @Autowired
    private CollectStockService collectStockService;

    //	@Result({
//			@Result(name = "success" ,value = "/view/ucenter/user_center.jsp"),
//			@Result(name = "fail" ,value = "/view/ucenter/login.jsp")
//	})
    public String login() {
        if (accountService.login(accountVO)) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("accountID", accountVO.getAccountID());
            stockCurrentVOS = collectStockService.getCollectedStocks(accountVO.getAccountID());
            return SUCCESS;
        } else {
            request = ServletActionContext.getRequest();
            request.setAttribute("tipMessage", "登陆失败！");
            return "fail";
        }

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

    public String haveLogin() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        JSONObject jsonObject = JSONObject.fromObject(session);
        result = jsonObject.toString();
        System.out.println("haveLogin" + result);
        if (session.get("accountID") != null) {
            return SUCCESS;
        } else {
            return "fail";
        }
    }

    public String getUserInfo(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();

        return result;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public ArrayList<StockCurrentVO> getStockCurrentVOS() {
        return stockCurrentVOS;
    }

    public void setStockCurrentVOS(ArrayList<StockCurrentVO> stockCurrentVOS) {
        this.stockCurrentVOS = stockCurrentVOS;
    }

}
