package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import service.stock.StockQuotaService;
import vo.stock.*;

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
    @Autowired
    private StockQuotaService stockQuotaService;

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

    private StockHistoricalVO getStockHistoricalVO(int num1, int num2, String type){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, num1);
        String startdate = DateHelper.formerNTradeDay(enddate, num2);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, type);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getStockDayKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(20,480, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getStockWeekKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(20,480, "w"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getStockMonthKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(20,480, "m"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String totheStock(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(20,30,"d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getIndex(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 20);
        String startdate = DateHelper.formerNTradeDay(enddate, 120);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, "d");
        StockIndexVO stockIndexVO = stockQuotaService.getStockIndex(stockInputVO);
        JSONObject jsonObject = JSONObject.fromObject(stockIndexVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealTimeInfo(){

        System.out.println("success");

        RealTimeLineVO realTimeLineVO = stockBasicInfoService.getStockRealTimeLineInfo(stockCode);
        JSONObject jsonObject = JSONObject.fromObject(realTimeLineVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealCurrentInfo(){
        StockCurrentVO stockCurrentVO = stockBasicInfoService.getStockRealTimeInfo(stockCode);
        JSONObject jsonObject = JSONObject.fromObject(stockCurrentVO);
        result = jsonObject.toString();
        return SUCCESS;
    }
}
