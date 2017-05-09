package service.admin;

import vo.UserAnalysisDataForm;
import vo.UserAccoutForm;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AdminService {
    /**
     * 搜索用户
     * @param userID 用户ID
     * @return UserAccoutForm
     */
    public UserAccoutForm searchUser(String userID);

    /**
     * 获取网站数据分析的结果
     * @return 返回到截止日期为止的用户数量
     */
    public UserAnalysisDataForm getUserAnalysisData();
}
