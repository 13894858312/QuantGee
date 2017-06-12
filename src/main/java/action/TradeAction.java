package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.MarketInfoService;
import service.stock.PredictStockService;
import service.stock.StockBasicInfoService;
import service.stock.StockQuotaService;
import service.trade.TradeService;
import vo.stock.StockHistoricalVO;
import vo.stock.StockIndexVO;
import vo.stock.StockInputVO;
import vo.stock.StockPredictVO;
import vo.trade.HoldingStockVO;
import vo.trade.TradeInputVO;
import vo.trade.TradeRecordVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/11.
 */
@Controller
public class TradeAction extends ActionSupport{
    private String result;
    private String stockCode;
    private String accountID;
    private int tradeAction;
    private String numOfStock;
    private double nowPrice;



    @Autowired
    private StockBasicInfoService stockBasicInfoService;
    @Autowired
    private StockQuotaService stockQuotaService;
    @Autowired
    private PredictStockService predictStockService;
    @Autowired
    private MarketInfoService marketInfoService;
    @Autowired
    private TradeService tradeService;

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

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public int getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(int tradeAction) {
        this.tradeAction = tradeAction;
    }

    public String getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(String numOfStock) {
        this.numOfStock = numOfStock;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(double nowPrice) {
        this.nowPrice = nowPrice;
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

    public String getSTCodeInfo(){
        JSONObject jsonObject = new JSONObject();
        if(stockCode == "sh") {
            jsonObject = JSONObject.fromObject(marketInfoService.getIndexRealTimeInfo(stockCode));
        }else {
            jsonObject = JSONObject.fromObject(stockBasicInfoService.getStockRealTimeInfo(stockCode));
        }
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getTradeIndex(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 1);
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

    public String getBOLLKlineInfo(){
        JSONObject jsonObject = JSONObject.fromObject(getStockHistoricalVO(1,120, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getTradeActionResult(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(now);
        String stockName = stockBasicInfoService.getCodeByName(stockCode);
        TradeRecordVO tradeRecordVO = new TradeRecordVO(date, accountID, stockCode, stockName, tradeAction, Integer.parseInt(numOfStock), nowPrice);
        if(tradeService.addTradeRecord(tradeRecordVO) != -1){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("success");
            arrayList.add(stockName);
            JSONArray jsonArray = JSONArray.fromObject(arrayList);
            result = jsonArray.toString();
        }else{
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("error");
            JSONArray jsonArray = JSONArray.fromObject(arrayList);
            result = jsonArray.toString();
        }
        return SUCCESS;
    }

    public String getUserTradeStockInfo(){
        System.out.println(accountID);
        ArrayList<HoldingStockVO> holdingStockVOArrayList = tradeService.getHoldingStocks(accountID);
        JSONArray jsonArray = JSONArray.fromObject(holdingStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getTheStockTradeInfo(){
        HoldingStockVO holdingStockVO = tradeService.getRealTimeHoldingStockInfo(new TradeInputVO(accountID,stockCode));
        JSONObject jsonObject = JSONObject.fromObject(holdingStockVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getAllTradeRecord(){
        ArrayList<TradeRecordVO> tradeRecordVOS = tradeService.getTradeRecords(accountID);
        JSONArray jsonArray = JSONArray.fromObject(tradeRecordVOS);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getBalance(){
        double balance = tradeService.getUserMoney(accountID);
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(balance);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }
}