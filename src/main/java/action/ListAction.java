package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import vo.stock.StockCurrentVO;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;

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

    public String getList(){
        StockHistoricalVO stockHistoricalVO = getMarketInfo();
        JSONObject jsonObject = JSONObject.fromObject(stockHistoricalVO);
        result = jsonObject.toString();
//        ArrayList<StockCurrentVO> stockCurrentVOArrayList = stockBasicInfoService.getAllStockRealTime();
//        JSONArray jsonArray = JSONArray.fromObject(stockCurrentVOArrayList);
//        result = jsonArray.toString();
        return SUCCESS;
    }


}
