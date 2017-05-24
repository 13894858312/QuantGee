package action;

import com.opensymphony.xwork2.Action;
import net.sf.json.JSONArray;
import org.apache.struts2.json.annotations.JSON;
import vo.admin.UserAccountVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17.
 */
public class TestAction implements Action {
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
        UserAccountVO userAccountVO1 = new UserAccountVO("123","2017-05-10","zdy","118873");
        UserAccountVO userAccountVO2 = new UserAccountVO("456","2017-03-23","wyy","234543");
        UserAccountVO userAccountVO3 = new UserAccountVO("789","2017-01-18","bcy","766675");
        ArrayList<UserAccountVO> arrayList = new ArrayList<UserAccountVO>();
        arrayList.add(userAccountVO1);
        arrayList.add(userAccountVO2);
        arrayList.add(userAccountVO3);
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

}
