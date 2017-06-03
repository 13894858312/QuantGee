package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.StockBasicInfoService;
import vo.stock.StockCurrentVO;

import java.util.ArrayList;

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

    public String getList(){
        ArrayList<StockCurrentVO> stockCurrentVOArrayList = stockBasicInfoService.getAllStockRealTime();
        JSONArray jsonArray = JSONArray.fromObject(stockCurrentVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

}
