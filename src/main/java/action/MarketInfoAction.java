package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import vo.stock.RealTimeLineVO;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;

import java.text.SimpleDateFormat;
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

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    private StockHistoricalVO getMarketInfo(int num1, int num2){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, num1);
        String startdate = DateHelper.formerNTradeDay(enddate, num2);
        StockInputVO stockInputVO = new StockInputVO("sh", startdate, enddate);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getDayKline(){
        JSONObject jsonObject = JSONObject.fromObject(getMarketInfo(20,480));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getWeekKline(){
        JSONObject jsonObject = JSONObject.fromObject(getMarketInfo(20,480));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealSHDate(){
        RealTimeLineVO realTimeLineVO = stockBasicInfoService.getStockRealTimeLineInfo("sh");
        JSONArray jsonArray = JSONArray.fromObject(realTimeLineVO.getTimes());
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getRealSHPrice(){
        RealTimeLineVO realTimeLineVO = stockBasicInfoService.getStockRealTimeLineInfo("sh");
        JSONArray jsonArray = JSONArray.fromObject(realTimeLineVO.getNowPrice());
        result = jsonArray.toString();
        return SUCCESS;
    }

}
