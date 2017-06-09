package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class StockAction extends ActionSupport{
    private String result;
    private String stockCode;

    @Autowired
    private StockBasicInfoService stockBasicInfoService;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    private StockHistoricalVO getStockHistoricalVO(int num1, int num2){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, num1);
        String startdate = DateHelper.formerNTradeDay(enddate, num2);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getStockKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(20,480));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String totheStock(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(stockCode);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }
}
