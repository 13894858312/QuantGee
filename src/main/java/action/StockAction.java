package action;

import com.opensymphony.xwork2.ActionSupport;
import logic.tools.DateHelper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;

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
    private StockHistoricalVO getStockHistoricalVO(){
        String date = DateHelper.getNowDate();
        String enddate = DateHelper.formerNTradeDay(date, 20);
        String startdate = DateHelper.formerNTradeDay(enddate, 120);
        StockInputVO stockInputVO = new StockInputVO(stockCode, startdate, enddate);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }
    public String getStockFirstInfo(){
        JSONArray jsonArray = JSONArray.fromObject(getStockHistoricalVO().getkLine());
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getMA5(){
        JSONArray jsonArray = JSONArray.fromObject(getStockHistoricalVO().getMa5());
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getMA10(){
        JSONArray jsonArray = JSONArray.fromObject(getStockHistoricalVO().getMa10());
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getMA20(){
        JSONArray jsonArray = JSONArray.fromObject(getStockHistoricalVO().getMa20());
        result = jsonArray.toString();
        return SUCCESS;
    }
}
