package vo.strategy;

/**
 * Created by Mark.W on 2017/5/11.
 * 策略具体信息的vo
 * 经典策略只需要指定策略类型
 */
public class StrategyVO {
    /********************回测必须参数*******************/
    private int stockPoolType;              //0指定板块 1指定股票
    private int strategyType;               //0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
    private double initFund;                //初始资金
    private boolean notST;                  //是否排除st
    private int holdingPeriod;              //股票持有期
    private int returnPeriod;               //形成期 (strategyType为1时表示N日移动均线 strategyType为2时表示第一条N日平滑均线(长周期)）
    private double stopLoss;                //止损点 输入百分数 如20表示20%
    private double stopProfit;              //止盈点
    /********************回测必须参数********************/


    /******************不同策略的可选参数*****************/
    private double ratio;                   //strategyType为0时需要此参数 持有股票的比例,用于计算持有的股票数量 输入百分数 如20表示20%
    private int holdingStockNum;            //strategyType为1,2,3时需要此参数 持有的股票数量
    private int shortReturnPeriod;          //strategyType为2时需要此参数 表示第二条N日平滑均线(短周期)
    private int changeNumber;               //strategyType为3时需要此参数 表示每次换仓换股数量
    private int trainPeriod;                //strategyType为4时需要此参数 表示训练数据的天数(n)
    private int k;                          //strategyType为4时需要此参数 表示最近邻的数量 n-m>k
    private int vectorLength;               //strategyType为4时需要此参数 表示最近邻向量的长度(m)
    /******************不同策略的可选参数*****************/



}
