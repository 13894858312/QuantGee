package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.stock.CollectStockService;
import service.stock.StockBasicInfoService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by duoduogao on 17/6/11.
 */
public class UserStockAction extends ActionSupport{

    private ArrayList<StockCurrentVO> stockCurrentVOS;
 private ArrayList<String> test;

    public ArrayList<String> getTest() {
        return test;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
    }

    private String accountID;

    private String result;
    private String codeID;
    private String stockName;


    @Autowired
    private CollectStockService collectStockService;
    @Autowired
    private StockBasicInfoService stockBasicInfoService;

    public String getCollectStock(){
        System.out.println(accountID);
        ArrayList<StockCurrentVO> collectedStocks = collectStockService.getCollectedStocks(accountID);
//        JSONArray jsonObject = JSONArray.fromObject(collectedStocks);
        result = JSONArray.fromObject(collectedStocks).toString();
        return SUCCESS;
    }

    public String deleteCollectedStock(){
//        if (collectStockService.deleteCollectedStock(new StockCollectInputVO(accountID,codeID))){
//            HttpServletRequest request = ServletActionContext.getRequest();
//            request.setAttribute("tipMessage", "删除成功！");
//            return SUCCESS;
//        }else {
//            HttpServletRequest request = ServletActionContext.getRequest();
//            request.setAttribute("tipMessage", "删除失败！");
//            return "fail";
//        }
        return SUCCESS;
    }

    public String addCollectedStock(){
        for (String s:test) {
            System.out.println(s);
        }
//        System.out.println(codeID);
        result="success!";
//        if(collectStockService.collectStock(new StockCollectInputVO(accountID, stockBasicInfoService.getCodeByName(stockName)))){
//            ArrayList<String> arrayList = new ArrayList<>();
//            arrayList.add("success");
//            JSONArray jsonArray = JSONArray.fromObject(arrayList);
//            result = jsonArray.toString();
//        }else{
//            ArrayList<String> arrayList = new ArrayList<>();
//            arrayList.add("error");
//            JSONArray jsonArray = JSONArray.fromObject(arrayList);
//            result = jsonArray.toString();
//        }
        return SUCCESS;
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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}
