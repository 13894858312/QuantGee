package logic.stock;

import bean.Stock;
import logic.tools.MathHelper;
import org.springframework.stereotype.Service;
import vo.stock.MaVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/16.
 * 股票数据分析的类
 */
@Service
public class StockDataCalculation {

    /**
     * 均线图是将每天的收盘价加权平均,从而得到一条带有趋势性的轨迹。
     * 在日 K 线图中一般白线、黄线、紫线、绿线、蓝线依次分别表示:5、10、20、30、60日移动平均线。
     * 移动平均线常用线有 5 天、10 天、30 天、60 天、120 天和 240 天的指标。
     * 5天 10天的短期移动平均线。是短线操作的参照指标，称做日均线指标;
     * 30天 60天的是中期均线指标，称做季均线指标;
     * 120天 240天的是长期均线指标，称做年均线指标。
     * @param sourceStocks 股票信息
     * @param period 均线周期
     * @return ArrayList<MaVO>
     */
    public ArrayList<MaVO> calculateMA(Iterator<Stock> sourceStocks, int period) {

        //如果总天数小于均线图的时间间隔出错
        ArrayList<Stock> stocks = new ArrayList<>();
        while(sourceStocks.hasNext()) {
            stocks.add(sourceStocks.next());
        }

        if(period >= stocks.size()) {
            return null;
        }

        ArrayList<MaVO> result = new ArrayList<>();
        Stock stock;

        for (int i = period-1; i<stocks.size(); ++i){
            stock = stocks.get(i);

            double all = 0;
            for(int j=i-period+1; j<i+1; ++j) {
                all += stocks.get(j).getClose();
            }

            double average = MathHelper.formatData(all/(double)period, 4);

            result.add(new MaVO(stock.getStockId(),period, stock.getDate(), average));
        }

        return result;
    }

}
