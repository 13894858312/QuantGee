package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String uname; // 表单中的姓名
	private String upass; // 表单中的密码

	public String execute() {
		System.out.println(uname);
		System.out.println(upass);
		if (uname.equals("bcy")&&upass.equals("bcy")){
			return SUCCESS;
		}else {
			return "fail";
		}
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

}
