package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
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

    public String getCandleStick(){
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
        JSONArray jsonArray = JSONArray.fromObject(stockHistoricalVO.getkLine());
        result = jsonArray.toString();
        return SUCCESS;
    }
}
