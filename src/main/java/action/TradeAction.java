package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.PredictStockService;
import service.stock.StockBasicInfoService;
import service.stock.StockQuotaService;
import vo.stock.StockHistoricalVO;
import vo.stock.StockIndexVO;
import vo.stock.StockInputVO;
import vo.stock.StockPredictVO;

/**
 * Created by Administrator on 2017/6/11.
 */
@Controller
public class TradeAction extends ActionSupport{
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
        if (stockCode == null){
            stockCode = "sh";
        }
        System.out.println(stockCode);
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

    public String getSTCodeInfo(){
        JSONObject jsonObject = JSONObject.fromObject(stockBasicInfoService.getStockRealTimeInfo(stockCode));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getTradeIndex(){
        if (stockCode == "sh"){
            stockCode = "000001";
        }
System.out.println(stockCode);
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 20);
        String startdate = DateHelper.formerNTradeDay(enddate, 120);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, "d");
        StockIndexVO stockIndexVO = stockQuotaService.getStockIndex(stockInputVO);
        JSONObject jsonObject = JSONObject.fromObject(stockIndexVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getPredictResult(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 1);
        String startdate = DateHelper.formerNTradeDay(enddate, 130);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, "d");
        StockPredictVO stockPredictVO = predictStockService.getStockPredictInfo(stockInputVO);
        JSONObject jsonObject = JSONObject.fromObject(stockPredictVO);
        result = jsonObject.toString();
        return SUCCESS;
    }
}
