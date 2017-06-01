package action;

import bean.User;
import com.opensymphony.xwork2.Action;
import logic.user.UserServiceImp;
import net.sf.json.JSONArray;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.user.UserService;
import vo.admin.UserAccountVO;
import vo.user.UserVO;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.soap.Addressing;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17.
 */
@Controller
public class TestAction implements Action {
    @Autowired
    private UserService userService;

    private String username;
    private String password;
    private int age;
    private Date date;
    private String result;

    public String getResult(){
        return result;
    }

    public void setResult(){
        this.result = result;
    }

    public String getUsername() {
        username = "zdy";
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JSON(name="mypassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JSON(format="yyyy-MM-dd")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String execute() throws Exception {
        UserVO userVO = userService.getUserInfo("123");
//        System.out.println(userVO.getUserName() + " " + userVO.getPhoneNumber());
        ArrayList<UserVO> arrayList = new ArrayList<UserVO>();
        arrayList.add(userVO);
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String string = simpleDateFormat.format(date);
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        arrayList1.add(string);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

}
