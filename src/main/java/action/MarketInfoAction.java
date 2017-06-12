package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.MarketInfoService;
import service.stock.StockBasicInfoService;
import vo.stock.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/2.
 */
@Controller
public class MarketInfoAction extends ActionSupport {
    private String result;

    @Autowired
    private StockBasicInfoService stockBasicInfoService;
    @Autowired
    private MarketInfoService marketInfoService;

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    private StockHistoricalVO getMarketInfo(int num1, int num2, String type){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, num1);
        String startdate = DateHelper.formerNTradeDay(enddate, num2);
        StockInputVO stockInputVO = new StockInputVO("sh", startdate, enddate, type);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getDayKline(){
        JSONObject jsonObject = JSONObject.fromObject(getMarketInfo(20,300, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getWeekKline(){
        JSONObject jsonObject = JSONObject.fromObject(getMarketInfo(20,600, "w"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getMonthKline(){
        JSONObject jsonObject = JSONObject.fromObject(getMarketInfo(20,800, "m"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealSH(){
        RealTimeLineVO realTimeLineVO = marketInfoService.getIndexRealTimeLine("上证指数");
        JSONObject jsonObject = JSONObject.fromObject(realTimeLineVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealSHData(){
        CurrentIndexVO currentIndexVO = marketInfoService.getIndexRealTimeInfo("上证指数");
        JSONObject jsonObject = JSONObject.fromObject(currentIndexVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getAllStock(){
        ArrayList<String> arrayList = stockBasicInfoService.getAllStockCodes();
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

}
