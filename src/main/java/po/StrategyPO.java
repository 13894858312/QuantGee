package po;


/**
 * Created by Administrator on 2017/5/7.
 */
public class StrategyPO {

    private String strategyID;
    private String strategyName;
    /**
     * custom 自定义策略
     * momentum 动量策略
     * mean     均值回归策略
     */
    private String strategyType;
    private String strategyContent;

    public StrategyPO(){}

    /**
     * @param strategyID 策略ID
     * @param strategyName 策略名称
     * @param strategyType 策略类型
     * @param strategyContent 策略内容
     */
    public StrategyPO(String strategyID , String strategyName , String strategyType , String strategyContent){
        this.strategyID = strategyID;
        this.strategyName = strategyName;
        this.strategyType = strategyType;
        this.strategyContent = strategyContent;
    }

    public String getStrategyName(){
        return strategyName;
    }

    public void setStrategyName(String strategyName){
        this.strategyName = strategyName;
    }

    public String getStrategyContent(){
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent){
        this.strategyContent = strategyContent;
    }

    public String getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(String strategyID) {
        this.strategyID = strategyID;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

}
