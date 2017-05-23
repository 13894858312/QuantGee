package action;

import com.opensymphony.xwork2.Action;
import net.sf.json.JSONArray;
import org.apache.struts2.json.annotations.JSON;

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
        System.out.println("success");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        JSONArray jsonArray = JSONArray.fromObject(arrayList);
        result = jsonArray.toString();
        return SUCCESS;
    }

}
