package logic.strategy.backTesting;

import bean.Stock;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/6/8.
 * KNN机器学习策略
 */
@Service("4")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KnnMachingStrategy implements IStrategy {
    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> nextDates, ArrayList<String> formerDates) {

        if (nextDates.size() == 0) {
            return null;
        }

        int k = stockPool.getInputVO().getK();
        int m = stockPool.getInputVO().getVectorLength();
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock formerStock = stockPool.getStocksList().get(i).getStockByDate(formerRPeriodDate);
            if (formerStock == null){
                continue;
            }
            boolean live = true;                     //持有期内每天的股票信息必须有 否则不持有该股票
            for (int j = 1; j < nextDates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(nextDates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }
            if (!live) { continue;}

            double predictPrice = knnPredict(stockPool, formerStock.getCode(), formerDates, k, m);
            double yield = (predictPrice-formerStock.getClose())/formerStock.getClose();

System.out.println("****************************************** predictPrice:"+predictPrice );
System.out.println("****************************************** yield:"+yield );
if (yield >0) {
    System.out.println("***********************************************************************************************************************");
}
            if (predictPrice > 0) {
                yieldStocks.add(new YieldStock(formerStock.getCode(), yield));
            }
        }


        for(int i=0; i<holdingStocks.size(); ++i) {
            holdingStocks.get(i).setCanContinueHold(false);
        }

        ArrayList<String> result = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum, true);

        return result;
    }

    @Override
    public int getStrategyType() {
        return 4;
    }

    private double knnPredict(StockPool stockPool, String code, ArrayList<String> dates, int k, int m) {
        LogicStock stock = stockPool.getStockByCode(code);
        ArrayList<Double> closes = new ArrayList<>();
        for(int i=0;i <dates.size(); ++i) {
            Stock temp = stock.getStockByDate(dates.get(i));
            if(temp != null) {
                closes.add(temp.getClose());
            }
        }

        if (closes.size()-m <= k) {
            return 0;
        }

        ArrayList<KnnNear> sourceknns = new ArrayList<>();
        ArrayList<KnnNear> knnNears = new ArrayList<>();
        int aStart = closes.size()-m;

        //计算邻近值cos
        for (int i=0; i<closes.size()-m; ++i) {
            int aIndex = aStart;
            double up=0, down1=0, down2=0;
            for (int j=i; j<i+m;++j) {
                down1 += Math.pow(closes.get(j), 2);
                down2 += Math.pow(closes.get(aIndex), 2);
                up += closes.get(j) * closes.get(aIndex);
                aIndex ++;
            }
            double cos = up/(Math.sqrt(down1 * down2));
            sourceknns.add(new KnnNear(cos, closes.get(i+m), i+m));
        }

        //按cos排序(取出sourceKnn前k)
        for (int i=0; i<k; ++i) {
            int index = 0;
            for (int j=1; j<sourceknns.size(); ++j) {
                if (sourceknns.get(index).getCos() < sourceknns.get(j).getCos()) {
                    index = j;
                }
            }
            KnnNear temp = sourceknns.get(index);
            knnNears.add(new KnnNear(temp.getClose(), k-i, temp.getTimeRank()));
            sourceknns.remove(index);
        }

        //按照时间排序
        for (int i=0; i<knnNears.size()-1; ++i) {
            for(int j=0; j<knnNears.size()-1-i; ++i) {
                if(knnNears.get(j).getTimeRank() > knnNears.get(j+1).getTimeRank()) {
                    KnnNear temp = knnNears.get(j);
                    knnNears.set(j, new KnnNear(knnNears.get(j+1).getClose(), knnNears.get(j+1).getCosRank()+j+1));
                    knnNears.set(j+1, new KnnNear(temp.getClose(), temp.getCosRank()+j+2));
                }
            }
        }

        //按照rank排序
        for (int i=0; i<knnNears.size()-1; ++i) {
            for(int j=0; j<knnNears.size()-1-i; ++i) {
                if(knnNears.get(j).getRank() > knnNears.get(j+1).getRank()) {
                    KnnNear temp = knnNears.get(j);
                    knnNears.set(j, new KnnNear(knnNears.get(j+1).getClose(), knnNears.get(j+1).getRank()));
                    knnNears.set(j+1, new KnnNear(temp.getClose(), temp.getRank()));
                }
            }
        }

        double w = 1.0/(double)(k+ (k*(k-1))/2), result=0;

        for (int i=0; i<knnNears.size(); ++i) {
            result += i*w*knnNears.get(i).getClose();
        }

        return result;
    }

    private class KnnNear {
        private int rank;
        private double close;
        private int cosRank;

        private double cos;
        private int timeRank;

        public KnnNear(double close, int rank) {
            this.rank = rank;
            this.close = close;
        }

        public KnnNear(double close, int cosRank, int timeRank) {
            this.close = close;
            this.cosRank = cosRank;
            this.timeRank = timeRank;
        }

        public KnnNear(double cos, double close, int timeRank) {
            this.cos = cos;
            this.close = close;
            this.timeRank = timeRank;
        }

        public double getCos() {
            return cos;
        }

        public double getClose() {
            return close;
        }

        public int getTimeRank() {
            return timeRank;
        }

        public int getCosRank() {
            return cosRank;
        }

        public int getRank() {
            return rank;
        }
    }

}
