package logic.tools;

import bean.*;
import org.springframework.stereotype.Service;
import po.UserAnalysisDataPO;
import vo.admin.UserAnalysisDataVO;
import vo.stock.NewsVO;
import vo.stock.StockCurrentVO;
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
        account.setRegisterDate(accountVO.getRegisterDate());

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
                DateHelper.getNowTime(),
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
        HoldingStockVO result = new HoldingStockVO(holdingStock.getStockId(), holdingStock.getUserId(),
                holdingStock.getHoldNum(), holdingStock.getInitFund(), MathHelper.formatData(yield, 4));
        return result;
    }

    /**
     * 将Trade转换为TradeRecordVO
     * @param trade trade
     * @return TradeRecordVO
     */
    public TradeRecordVO transToTradeRecordVO(Trade trade) {
        TradeRecordVO result = new TradeRecordVO(trade.getTime(), trade.getUserId(), trade.getStockId(),
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
        trade.setStockId(tradeRecordVO.getStockCode());
        trade.setUserId(tradeRecordVO.getUserID());
        trade.setPrice(tradeRecordVO.getPrice());
        trade.setTime(tradeRecordVO.getTime());

        return trade;
    }
}
