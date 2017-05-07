package service.admin;

import bean.UserAnalysisData;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AdminService {

    public boolean findUser(String userID);

    public UserAnalysisData getUserAnalysisData();
}
