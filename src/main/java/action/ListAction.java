package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    StockBasicInfoService stockBasicInfoService;
    MarketInfoService marketInfoService;

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    private StockHistoricalVO getMarketInfo(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        date = calendar.getTime();
        String startdate = simpleDateFormat.format(date);
        calendar.add(Calendar.MONTH, -5);
        date = calendar.getTime();
        String enddate = simpleDateFormat.format(date);
        StockInputVO stockInputVO = new StockInputVO("000001", enddate, startdate);
        StockHistoricalVO stockHistoricalVO = stockBasicInfoService.getStockHistoricalInfo(stockInputVO);
        return stockHistoricalVO;
    }

    public String getIndustryUpList(){
        ArrayList<TopStockVO> topStockVOArrayList = marketInfoService.getTopIndustryStocks(0);
        JSONArray jsonArray = JSONArray.fromObject(topStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getIndustryDownList(){
        ArrayList<TopStockVO> topStockVOArrayList = marketInfoService.getTopIndustryStocks(1);
        JSONArray jsonArray = JSONArray.fromObject(topStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getStockUpList(){
        ArrayList<TopStockVO> topStockVOArrayList = marketInfoService.getTopStocks(0);
        JSONArray jsonArray = JSONArray.fromObject(topStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getStockDownList(){
        ArrayList<TopStockVO> topStockVOArrayList = marketInfoService.getTopStocks(1);
        JSONArray jsonArray = JSONArray.fromObject(topStockVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }
}
