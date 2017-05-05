package service.admin;

import bean.Account;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AdminService {

    public String modifyAdminPassword(String password);

    public String deleteUser(Account account);

    public String findUser(String userID);
}
