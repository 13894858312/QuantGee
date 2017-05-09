package service.admin;

import vo.UserAccountVO;
import vo.UserAnalysisDataVO;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface AdminService {
    /**
     * 搜索用户
     * @param userID 用户ID
     * @return UserAccountVO
     */
    public UserAccountVO searchUser(String userID);

    /**
     * 获取网站数据分析的结果
     * @return 返回到截止日期为止的用户数量
     */
    public UserAnalysisDataVO getUserAnalysisData();
}
