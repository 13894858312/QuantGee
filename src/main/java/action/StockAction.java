package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.PredictStockService;
import service.stock.StockBasicInfoService;
import service.stock.StockQuotaService;
import vo.stock.*;

import java.util.ArrayList;
import java.util.stream.Stream;

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
    @Autowired
    private PredictStockService predictStockService;

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
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,480, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getStockWeekKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,480, "w"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getStockMonthKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,480, "m"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String judgeValidStockCode(){
        ArrayList<String> arrayList = new ArrayList<>();
        String str = stockBasicInfoService.getNameByCode(stockCode);
        if(str == null){
            arrayList.add("error");
        }else{
            arrayList.add("success");
        }
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String totheStock(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,30,"d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getIndex(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 1);
        String startdate = DateHelper.formerNTradeDay(enddate, 120);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, "d");
        StockIndexVO stockIndexVO = stockQuotaService.getStockIndex(stockInputVO);
        JSONObject jsonObject = JSONObject.fromObject(stockIndexVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getBOLLKline(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,120, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRealTimeInfo(){
        RealTimeLineVO realTimeLineVO = stockBasicInfoService.getStockRealTimeLineInfo(stockCode);
        System.out.println(realTimeLineVO.getCode());
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

    public String getPredictInfo(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 1);
        String startdate = DateHelper.formerNTradeDay(enddate, 120);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, "d");
        StockPredictVO stockPredictVO = predictStockService.getStockPredictInfo(stockInputVO);
        JSONObject jsonObject = JSONObject.fromObject(stockPredictVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getMKRBInfo(){
        StockAnalysisVO stockAnalysisVO = predictStockService.getStockAnalysisInfo(stockCode);
        JSONObject jsonObject = JSONObject.fromObject(stockAnalysisVO);
        result = jsonObject.toString();
        return SUCCESS;
    }
}
