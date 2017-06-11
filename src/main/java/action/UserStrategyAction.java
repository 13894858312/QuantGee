package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import service.strategy.MyStrategyService;
import vo.strategy.StrategyVO;

import java.util.ArrayList;

/**
 * Created by duoduogao on 17/6/11.
 */
public class UserStrategyAction extends ActionSupport{

    //获取的accountID
    private String accountID;

    //返回的json
    private String result;


    @Autowired
    private MyStrategyService myStrategyService;

    public String getMyStrategys(){
        ArrayList<StrategyVO> collectStrategys = myStrategyService.getMyStrategys(accountID);
        JSONArray json = JSONArray.fromObject(collectStrategys);
        result = json.toString();
        return SUCCESS;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
