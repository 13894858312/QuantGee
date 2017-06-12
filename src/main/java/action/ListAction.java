package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.CollectStockService;
import service.stock.MarketInfoService;
import service.stock.StockBasicInfoService;
import vo.stock.StockCurrentVO;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;
import vo.stock.TopStockVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/3.
 */
@Controller
public class ListAction extends ActionSupport {
    private String result;
    private String stockName;
    private String stockCode;

    @Autowired
    private StockBasicInfoService stockBasicInfoService;
    @Autowired
    private MarketInfoService marketInfoService;
    @Autowired
    private CollectStockService collectStockService;

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    private StockHistoricalVO getStockVOInlist(int num1, int num2, String type){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, num1);
        String startdate = DateHelper.formerNTradeDay(enddate, num2);
        stockCode = stockBasicInfoService.getCodeByName(stockName);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate, type);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getWebStockName(){
        stockCode = stockBasicInfoService.getCodeByName(stockName);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(stockName);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getStockKline(){
        JSONObject jsonObject = JSONObject.fromObject(getStockVOInlist(20,480, "d"));
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getStockUpList(){
        ArrayList<TopStockVO> topStockVOArrayList = marketInfoService.getTopStocks(0);
        JSONArray jsonArray = JSONArray.fromObject(topStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getStockCurrentVO(){
        StockCurrentVO stockCurrentVO = stockBasicInfoService.getStockRealTimeInfo(stockCode);
        JSONObject jsonObject = JSONObject.fromObject(stockCurrentVO);
        result = jsonObject.toString();
        return SUCCESS;
    }

    public String getRecommandStock(){
        ArrayList<String> arrayList = collectStockService.getRecommendedStock(null, 3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }
}
