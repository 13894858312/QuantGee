package logic.tools;

import bean.*;
import logic.strategy.backTesting.StrategyHelper;
import org.springframework.stereotype.Service;
import po.UserAnalysisDataPO;
import vo.admin.UserAnalysisDataVO;
import vo.stock.CurrentIndexVO;
import vo.stock.NewsVO;
import vo.stock.StockCurrentVO;
import vo.strategy.StrategyVO;
import vo.trade.HoldingStockVO;
import vo.trade.TradeRecordVO;
import vo.user.AccountVO;
import vo.user.UserVO;

/**
 * Created by Mark.W on 2017/5/15.
 * vo与entity的转换
 */
@Service
public class TransferHelper {

    /**
     * 将accountvo转换为account
     * @param accountVO accountVO
     * @return Account
     */
    public Account transToAccount(AccountVO accountVO) {
        if(accountVO == null) {
            return null;
        }

        Account account = new Account();
        account.setUserId(accountVO.getAccountID());
        account.setPassword(accountVO.getPassword());
        account.setRegisterDate(DateHelper.getNowDate());

        return account;
    }

    /**
     * 将UserAnalysisDataPO转换为UserAnalysisDataVO
     * @param analysisDataPO analysisDataPO
     * @return  UserAnalysisDataVO
     */
    public UserAnalysisDataVO transToUserAnalysisVO(UserAnalysisDataPO analysisDataPO) {
        if(analysisDataPO == null) {
            return null;
        }

        UserAnalysisDataVO userAnalysisDataVO = new
                UserAnalysisDataVO(analysisDataPO.getUserNum(), analysisDataPO.getRegisterNumByTime());
        return userAnalysisDataVO;
    }

    /**
     * 将UserVO转换为User
     * @param userVO userVO
     * @return User
     */
    public User transToUser(UserVO userVO) {
        if(userVO == null) {
            return null;
        }

        User user = new User();
        user.setUserId(userVO.getAccountID());
        user.setAlterName(userVO.getUserName());
        user.setPhoneNumber(userVO.getPhoneNumber());

        return user;
    }

    /**
     * 将User转换为UserVO
     * @param user user
     * @return User
     */
    public UserVO transToUserVO(User user) {
        if(user == null) {
            return null;
        }

        UserVO userVO = new UserVO();
        userVO.setAccountID(user.getUserId());
        userVO.setUserName(user.getAlterName());
        userVO.setPhoneNumber(user.getPhoneNumber());

        return userVO;
    }

    /**
     * 将News转换为NewsVO
     * @param news news
     * @return NewsVO
     */
    public NewsVO transToNewsVO(News news) {
        if(news == null) {
            return null;
        }

        return new NewsVO(news.getClassify(), news.getTitle(), news.getTime(),
                news.getUrl(), news.getContent());
    }

    /**
     * 将stock转换为StockCurrentVO
     * @param marketInfo marketInfo
     * @param stock stock
     * @return StockCurrentVO
     */
    public StockCurrentVO transToStockCurrent(MarketInfo marketInfo, Current stock) {

        if(marketInfo == null || stock == null) {
            return null;
        }

        StockCurrentVO stockCurrentVO = new StockCurrentVO(marketInfo.getCode(), marketInfo.getName(), marketInfo.getcName(),
                TimeHelper.getNowTime(),
                stock.getTrade(), stock.getOpen(), stock.getLow(), stock.getHigh(), stock.getAmount(),
                stock.getVolume(), stock.getChangepercent(), stock.getTurnoverratio(),stock.getSettlement(),
                stock.getPer(), stock.getPb(), stock.getMktcap());

        return stockCurrentVO;
    }


    /**
     * 将HoldingStockVO转换为HoldingStock
     * @param holdingStock holdingStock
     * @param price price
     * @return HoldingStockVO
     */
    public HoldingStockVO transToHoldingStockVO(HoldingStock holdingStock, double price) {
        double yield = (holdingStock.getHoldNum() * price + holdingStock.getSellOutMoney() - holdingStock.getInitFund())/holdingStock.getInitFund();
        HoldingStockVO result = new HoldingStockVO(holdingStock.getCode(), holdingStock.getUserId(),
                holdingStock.getHoldNum(), holdingStock.getInitFund(), MathHelper.formatData(yield, 4));
        return result;
    }

    /**
     * 将Trade转换为TradeRecordVO
     * @param trade trade
     * @return TradeRecordVO
     */
    public TradeRecordVO transToTradeRecordVO(Trade trade) {
        TradeRecordVO result = new TradeRecordVO(trade.getTime(), trade.getUserId(), trade.getCode(),
                trade.getAction(), trade.getNumOfStock(), trade.getPrice());
        return result;
    }

    /**
     * 将TradeRecordVO转换为Trade
     * @param tradeRecordVO tradeRecordVO
     * @return Trade
     */
    public Trade transToTrade(TradeRecordVO tradeRecordVO) {
        Trade trade = new Trade();
        trade.setAction(tradeRecordVO.getAction());
        trade.setNumOfStock(tradeRecordVO.getNumOfStock());
        trade.setCode(tradeRecordVO.getStockCode());
        trade.setUserId(tradeRecordVO.getUserID());
        trade.setPrice(tradeRecordVO.getPrice());
        trade.setTime(tradeRecordVO.getTime());

        return trade;
    }

    /**
     * 将StrategyVO转换为Strategy
     * @param vo StrategyVO
     * @return Strategy
     */
    public Strategy transToStrategy(StrategyVO vo) {
        Strategy result = new Strategy();
        String name;
        String time = TimeHelper.getNowTime();
        if(vo.getStrateygyName() != null) {
            name = vo.getStrateygyName();
        } else {
            name = StrategyHelper.getStrategyName(vo.getStrategyType()) + time.replace(":", "");
        }

        result.setUserId(vo.getUserID());
        result.setTime(time);
        result.setStrategyName(name);
        result.setStrategyType(vo.getStrategyType());
        result.setLastYield(vo.getLastYield());
        result.setInitFund(vo.getInitFund());
        result.setNotSt(bool_to_byte(vo.isNotST()));
        result.setHoldingPeriod(vo.getHoldingPeriod());
        result.setReturnPeriod(vo.getReturnPeriod());
        result.setStopLoss(vo.getStopLoss());
        result.setStopProfit(vo.getStopProfit());
        result.setRatio(vo.getRatio());
        result.setHoldingStockNum(vo.getHoldingStockNum());
        result.setShortReturnPeriod(vo.getShortReturnPeriod());
        result.setChangeNumber(vo.getChangeNumber());
        result.setTrainPeriod(vo.getTrainPeriod());
        result.setK(vo.getK());
        result.setVectorLength(vo.getVectorLength());

        return result;
    }

    /**
     * 将Strategy转换为StrategyVO
     * @param strategy Strategy
     * @return StrategyVO
     */
    public StrategyVO transToStrategyVO(Strategy strategy) {
        StrategyVO result = new StrategyVO(strategy.getStrategyId(), strategy.getUserId(), strategy.getStrategyName(),strategy.getTime(),
                strategy.getLastYield(), strategy.getStrategyType(), strategy.getInitFund(), byte_to_bool(strategy.getNotSt()), strategy.getHoldingPeriod(),
                strategy.getReturnPeriod(), strategy.getStopLoss(), strategy.getStopProfit(), strategy.getRatio(),strategy.getHoldingStockNum(),
                strategy.getShortReturnPeriod(), strategy.getChangeNumber(), strategy.getTrainPeriod(), strategy.getK(),strategy.getVectorLength());

        return result;
    }

    private boolean byte_to_bool(byte a){
        if(a == (byte) 1){
            return true;
        }else{
            return false;
        }
    }

    private byte bool_to_byte(boolean b){
        if(b){
            return (byte) 1;
        }else {
            return (byte) 0;
        }
    }

    public CurrentIndexVO transToCurrentIndexVO(CurrentIndex currentIndex) {
        CurrentIndexVO result = new CurrentIndexVO(currentIndex.getCode(), currentIndex.getPreclose(), currentIndex.getHigh(),
                currentIndex.getLow(), currentIndex.getVolume(),currentIndex.getAmount(),currentIndex.getOpenNum(),
                currentIndex.getCloseNum(), currentIndex.getChanges(),currentIndex.getT());
        return result;
    }
}
