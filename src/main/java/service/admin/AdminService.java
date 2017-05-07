package service.admin;

import bean.UserAnalysisData;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AdminService {
    /**
     * 搜索用户
     * @param userID 用户ID
     * @return搜索到该用户则返回true,否则返回false
     */
    public boolean searchUser(String userID);

    /**
     * 获取网站数据分析的结果
     * @return返回到截止日期为止的用户数量
     */
    public UserAnalysisData getUserAnalysisData();
}
