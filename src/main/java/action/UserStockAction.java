package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.stock.CollectStockService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by duoduogao on 17/6/11.
 */
public class UserStockAction extends ActionSupport{

    private ArrayList<StockCurrentVO> stockCurrentVOS;

    private String accountID;

    private String result;
    private String codeID;



    @Autowired
    private CollectStockService collectStockService;

    public String getCollectStock(){
        System.out.println(accountID);
        ArrayList<StockCurrentVO> collectedStocks = collectStockService.getCollectedStocks(accountID);
        JSONArray jsonObject = JSONArray.fromObject(collectedStocks);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String deleteCollectedStock(){
        if (collectStockService.deleteCollectedStock(new StockCollectInputVO(accountID,codeID))){
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("tipMessage", "删除成功！");
            return SUCCESS;
        }else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("tipMessage", "删除失败！");
            return "fail";
        }
    }


    public ArrayList<StockCurrentVO> getStockCurrentVOS() {
        return stockCurrentVOS;
    }

    public void setStockCurrentVOS(ArrayList<StockCurrentVO> stockCurrentVOS) {
        this.stockCurrentVOS = stockCurrentVOS;
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

    public String getCodeID() {
        return codeID;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }
}
