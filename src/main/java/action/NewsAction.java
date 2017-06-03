package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.stock.NewsService;
import vo.stock.NewsVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/3.
 */
@Controller
public class NewsAction extends ActionSupport{
    private String result;

    @Autowired
    private NewsService newsService;

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getNews(){
        ArrayList<NewsVO> newsVOArrayList = newsService.getNews();
        JSONArray jsonArray = JSONArray.fromObject(newsVOArrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }
}
