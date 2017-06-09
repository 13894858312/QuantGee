package vo.stock;

/**
 * Created by Mark.W on 2017/5/7.
 * 收藏股票的表单
 */
public class StockCollectInputVO {
    private String userID;
    private String code;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
