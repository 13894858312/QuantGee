package vo.strategy;

/**
 * Created by Mark.W on 2017/5/11.
 * 策略具体信息的vo
 * 经典策略只需要指定策略类型
 */
public class StrategyVO {
    /**
     * custom 自定义策略
     * momentum 动量策略
     * mean     均值回归策略
     */
    private String strategyType;

    private String strategyID;
    private String strategyName;
    private String description;
}
