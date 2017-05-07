package service.strategy;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface StrategyService {

    public boolean deleteMyStrategy();

    public StrategyBackTesting getStrategyBackTesting(StrategyInput strategyInput);

    public boolean addMyStartegy(Strategy strategy);

    public ArrayList<Strategy> getMyStrategy();

    public ArrayList<Stock> getCollectedStrategy(String userID);

    public boolean collectStrategy();

}
