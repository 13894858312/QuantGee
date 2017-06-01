package logic.trade;

import DAO.stockInfoDAO.StockInfoDAO;
import DAO.tradeDAO.TradeDAO;
import bean.Current;
import bean.HoldingStock;
import bean.Trade;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.trade.TradeService;
import vo.trade.HoldingStockVO;
import vo.trade.TradeInputVO;
import vo.trade.TradeRecordVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/26.
 */

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TradeServiceImp implements TradeService {

    @Autowired
    private TradeDAO tradeDAO;

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private TransferHelper transferHelper;

    @Override
    public ArrayList<TradeRecordVO> getTradeRecords(TradeInputVO inputVO) {
        Iterator<Trade> trades = tradeDAO.getUserTradeList(inputVO.getUserID(), inputVO.getStockCode());
        ArrayList<TradeRecordVO> result = new ArrayList<>();

        while(trades.hasNext()) {
            result.add(transferHelper.transToTradeRecordVO(trades.next()));
        }
        return result;
    }

    @Override
    public ArrayList<TradeRecordVO> getTradeRecords(String userID) {
        Iterator<Trade> trades = tradeDAO.getUserTradeList(userID);
        ArrayList<TradeRecordVO> result = new ArrayList<>();

        while(trades.hasNext()) {
            result.add(transferHelper.transToTradeRecordVO(trades.next()));
        }
        return result;
    }

    @Override
    public boolean addTradeRecord(TradeRecordVO tradeRecord) {
        Trade trade = transferHelper.transToTrade(tradeRecord);
        tradeDAO.addTradeInfo(trade);

        HoldingStock holdingStock = tradeDAO.getHoldingStock(tradeRecord.getUserID(), tradeRecord.getStockCode());

        //用于获取实时股票价格
        Current current = stockInfoDAO.getStockRealTimeInfo(tradeRecord.getStockCode());

        //添加一条新持有股票
        if (holdingStock == null || holdingStock.getHoldNum() == 0) {
            HoldingStock newHoldingStock = new HoldingStock();

            newHoldingStock.setStockId(tradeRecord.getStockCode());
            newHoldingStock.setUserId(tradeRecord.getUserID());
            newHoldingStock.setHoldNum(tradeRecord.getNumOfStock());
            newHoldingStock.setSellOutMoney((0.0));

            //根据实时股票价格来确定买入的资金
            newHoldingStock.setInitFund(current.getTrade() * tradeRecord.getNumOfStock());

            tradeDAO.updateHoldingStock(holdingStock);
        } else {
            //买入 覆盖原先的记录
            if (tradeRecord.getAction() == 0) {
                holdingStock.setHoldNum(holdingStock.getHoldNum() + tradeRecord.getNumOfStock());
                holdingStock.setInitFund(holdingStock.getInitFund() + tradeRecord.getNumOfStock() * tradeRecord.getPrice());

            } else {
                assert (holdingStock.getHoldNum() - tradeRecord.getNumOfStock() >= 0) : "logic.TradeServiceImp.addTradeRecord.HoldNum小于0";

                holdingStock.setHoldNum(holdingStock.getHoldNum() - tradeRecord.getNumOfStock());
                holdingStock.setSellOutMoney(holdingStock.getSellOutMoney() + current.getTrade() * tradeRecord.getNumOfStock());
            }

            tradeDAO.updateHoldingStock(holdingStock);
        }

        return true;
    }

    @Override
    public HoldingStockVO getRealTimeHoldingStockInfo(TradeInputVO inputVO) {
        HoldingStock holdingStock = tradeDAO.getHoldingStock(inputVO.getUserID(), inputVO.getStockCode());
        Current current = stockInfoDAO.getStockRealTimeInfo(inputVO.getStockCode());
        return transferHelper.transToHoldingStockVO(holdingStock, current.getTrade());
    }

    @Override
    public ArrayList<HoldingStockVO> getHoldingStocks(String userID) {
        Iterator<HoldingStock> holdingStocks = tradeDAO.getHoldingStocks(userID);
        ArrayList<HoldingStockVO> result = new ArrayList<>();

        while(holdingStocks.hasNext()) {
            HoldingStock temp = holdingStocks.next();
            Current current = stockInfoDAO.getStockRealTimeInfo(temp.getStockId());
            result.add(transferHelper.transToHoldingStockVO(temp, current.getTrade()));
        }
        return result;
    }
}