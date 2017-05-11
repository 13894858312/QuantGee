package vo.strategy;

/**
 * Created by Mark.W on 2017/5/11.
 * 发布策略信息的vo
 */
public class StrategyPostVO {
    private String userID;
    private String postDate;
    private String postDescription;
    private StrategyVO strategyVO;

    private int likeNum;

    public StrategyPostVO() {}

    /**
     * @param userID userID
     * @param postDate 发布时间
     * @param postDescription 发布的描述
     * @param strategyVO 策略内容
     * @param likeNum 点赞数
     */
    public StrategyPostVO(String userID, String postDate, String postDescription, StrategyVO strategyVO, int likeNum) {
        this.userID = userID;
        this.postDate = postDate;
        this.postDescription = postDescription;
        this.strategyVO = strategyVO;
        this.likeNum = likeNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public StrategyVO getStrategyVO() {
        return strategyVO;
    }

    public void setStrategyVO(StrategyVO strategyVO) {
        this.strategyVO = strategyVO;
    }
}

