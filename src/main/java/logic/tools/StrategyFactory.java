package logic.tools;

import logic.calculation.MeanReversionStrategy;
import logic.calculation.MomentumDriveStrategy;
import logic.calculation.Strategy;
import vo.StrategyType;

/**
 * Created by Mark.W on 2017/3/29.
 */
public class StrategyFactory {
    private static StrategyFactory ourInstance = new StrategyFactory();

    public static StrategyFactory getInstance() {
        return ourInstance;
    }

    public Strategy getStrategy(StrategyType strategyType) {
        Strategy strategy = null;

        switch (strategyType) {
            case MEAN_REVERSION:
                strategy = new MeanReversionStrategy();
                break;
            case MOMENTUM_DRIVEN:
                strategy = new MomentumDriveStrategy();
                break;
            default:
                    break;
        }

        return strategy;
    }
}
