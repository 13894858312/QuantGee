package action;

import com.opensymphony.xwork2.Action;

import bean.Account;

public class LoginAction implements Action {

	private String uname; // 表单中的姓名
	private String upass; // 表单中的密码

	@Override
	public String execute() throws Exception {
		System.out.println("姓名:" + uname);
		System.out.println("密码:" + upass);
		if (uname.equals("bcy") && upass.equals("bcy")) {
			return "success";
		}
		return "fail";
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
