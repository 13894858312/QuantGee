package logic.trade;

import DAO.stockInfoDAO.StockInfoDAO;
import DAO.tradeDAO.TradeDAO;
import bean.*;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(inputVO.getStockCode());
        ArrayList<TradeRecordVO> result = new ArrayList<>();

        while(trades.hasNext()) {
            result.add(transferHelper.transToTradeRecordVO(trades.next(), marketInfo.getName()));
        }
        return result;
    }

    @Override
    public ArrayList<TradeRecordVO> getTradeRecords(String userID) {
        Iterator<Trade> trades = tradeDAO.getUserTradeList(userID);
        ArrayList<TradeRecordVO> result = new ArrayList<>();

        while(trades.hasNext()) {
            Trade temp = trades.next();
            MarketInfo marketInfo = stockInfoDAO.getMarketInfo(temp.getStockId());
            result.add(transferHelper.transToTradeRecordVO(temp, marketInfo.getName()));
        }
        return result;
    }

    @Override
    public double addTradeRecord(TradeRecordVO tradeRecord) {
        Trade trade = transferHelper.transToTrade(tradeRecord);
        if(!tradeDAO.addTradeInfo(trade)) {
            return -1;
        }

        HoldingStock holdingStock = tradeDAO.getHoldingStock(tradeRecord.getUserID(), tradeRecord.getStockCode());

        //用于获取实时股票价格
        Current current = stockInfoDAO.getStockRealTimeInfo(tradeRecord.getStockCode());
        double userMoney;

        //添加一条新持有股票
        if (holdingStock == null || holdingStock.getHoldNum() == 0) {
            HoldingStock newHoldingStock = new HoldingStock();

            newHoldingStock.setCode(tradeRecord.getStockCode());
            newHoldingStock.setUserId(tradeRecord.getUserID());
            newHoldingStock.setHoldNum(tradeRecord.getNumOfStock());
            newHoldingStock.setSellOutMoney((0.0));

            //根据实时股票价格来确定买入的资金
            newHoldingStock.setInitFund(current.getTrade() * tradeRecord.getNumOfStock());

            userMoney = tradeDAO.getUserMoney(tradeRecord.getUserID());
            if(userMoney == -1) {
                return -1;
            }
            userMoney -= current.getTrade() * tradeRecord.getNumOfStock();

            if (!tradeDAO.updateUserMoney(tradeRecord.getUserID(), userMoney)) {
                return -1;
            }

            if(!tradeDAO.updateHoldingStock(newHoldingStock)) {
                return -1;
            }
        } else {
            //买入 覆盖原先的记录
            if (tradeRecord.getAction() == 0) {
                holdingStock.setHoldNum(holdingStock.getHoldNum() + tradeRecord.getNumOfStock());
                holdingStock.setInitFund(holdingStock.getInitFund() + tradeRecord.getNumOfStock() * tradeRecord.getPrice());

                userMoney = tradeDAO.getUserMoney(tradeRecord.getUserID());
                if(userMoney == -1) {
                    return -1;
                }
                userMoney -= current.getTrade() * tradeRecord.getNumOfStock();

                if (!tradeDAO.updateUserMoney(tradeRecord.getUserID(), userMoney)) {
                    return -1;
                }
            } else {
                if(holdingStock.getHoldNum() - tradeRecord.getNumOfStock() < 0) {
                    return -1;
                }

                holdingStock.setHoldNum(holdingStock.getHoldNum() - tradeRecord.getNumOfStock());
                holdingStock.setSellOutMoney(holdingStock.getSellOutMoney() + current.getTrade() * tradeRecord.getNumOfStock());

                userMoney = tradeDAO.getUserMoney(tradeRecord.getUserID());
                if(userMoney == -1) {
                    return -1;
                }
                userMoney += current.getTrade() * tradeRecord.getNumOfStock();

                if (!tradeDAO.updateUserMoney(tradeRecord.getUserID(), userMoney)) {
                    return -1;
                }
            }

            if(!tradeDAO.updateHoldingStock(holdingStock)) {
                return -1;
            }
        }

        return MathHelper.formatData(userMoney,2);
    }

    @Override
    public HoldingStockVO getRealTimeHoldingStockInfo(TradeInputVO inputVO) {
        HoldingStock holdingStock = tradeDAO.getHoldingStock(inputVO.getUserID(), inputVO.getStockCode());
        double nowPrice;
        Current current = stockInfoDAO.getStockRealTimeInfo(inputVO.getStockCode());
        if (current == null) {
            String date = DateHelper.formerTradeDay(DateHelper.getNowDate());
            Stock stock = stockInfoDAO.getStockInfo(inputVO.getStockCode(), date);
            nowPrice = stock.getClose();
        } else {
            nowPrice = current.getTrade();
        }

        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(inputVO.getStockCode());
        return transferHelper.transToHoldingStockVO(holdingStock, nowPrice, marketInfo.getName());
    }

    @Override
    public ArrayList<HoldingStockVO> getHoldingStocks(String userID) {
        Iterator<HoldingStock> holdingStocks = tradeDAO.getHoldingStocks(userID);
        ArrayList<HoldingStockVO> result = new ArrayList<>();

        while(holdingStocks.hasNext()) {
            HoldingStock temp = holdingStocks.next();
            if (temp.getHoldNum() == 0) {
                continue;
            }
            //获取当前股票价格
            double nowPrice;
            Current current = stockInfoDAO.getStockRealTimeInfo(temp.getCode());
            if (current == null) {
                String date = DateHelper.formerTradeDay(DateHelper.getNowDate());
                Stock stock = stockInfoDAO.getStockInfo(temp.getCode(), date);
                nowPrice = stock.getClose();
            } else {
                nowPrice = current.getTrade();
            }

            //获取股票名称
            MarketInfo marketInfo = stockInfoDAO.getMarketInfo(temp.getCode());
            result.add(transferHelper.transToHoldingStockVO(temp, nowPrice, marketInfo.getName()));
        }
        return result;
    }

    @Override
    public double getUserMoney(String userID) {
        double result =  tradeDAO.getUserMoney(userID);
        return MathHelper.formatData(result,2);
    }

}
