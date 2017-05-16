package logic.tools;

import bean.*;
import logic.stock.KLineData;
import po.UserAnalysisDataPO;
import vo.admin.UserAnalysisDataVO;
import vo.stock.NewsVO;
import vo.stock.StockCurrentVO;
import vo.stock.StockHistoricalVO;
import vo.user.AccountVO;
import vo.user.UserVO;

/**
 * Created by Mark.W on 2017/5/15.
 * vo与entity的转换
 */
public class TransferHelper {

    /**
     * 将accountvo转换为account
     * @param accountVO accountVO
     * @return Account
     */
    public static Account transToAccount(AccountVO accountVO) {
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
    public static UserAnalysisDataVO transToUserAnalysisVO(UserAnalysisDataPO analysisDataPO) {
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
    public static User transToUser(UserVO userVO) {
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
    public static UserVO transToUserVO(User user) {
        if(user == null) {
            return null;
        }

        UserVO userVO = new UserVO();
        user.setUserId(user.getUserId());
        user.setAlterName(user.getAlterName());
        user.setPhoneNumber(user.getPhoneNumber());

        return userVO;
    }

    /**
     * 将News转换为NewsVO
     * @param news news
     * @return NewsVO
     */
    public static NewsVO transToNewsVO(News news) {
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
    public static StockCurrentVO transToStockCurrent(MarketInfo marketInfo, Stock stock) {

        if(marketInfo == null || stock == null) {
            return null;
        }

        StockCurrentVO stockCurrentVO = new StockCurrentVO();

        stockCurrentVO.setStockCode(marketInfo.getStockID());
        stockCurrentVO.setStockName(marketInfo.getStockName());
        stockCurrentVO.setStockMarket(marketInfo.getcMarket());
        stockCurrentVO.setOpen(stock.getOpen());
        stockCurrentVO.setClose(stock.getClose());
        stockCurrentVO.setLow(stock.getLow());
        stockCurrentVO.setHigh(stock.getHigh());
        stockCurrentVO.setVolume(stock.getVolume());
        stockCurrentVO.setP_change(stock.getpChange());
        stockCurrentVO.setPrice_change(stock.getPriceChange());
//            stockCurrentVO.setTurnover(stock.getTurnOver());
        //缺少换手率数据

        return stockCurrentVO;
    }

    /**
     * 将stock转换为StockCurrentVO
     * @param marketInfo marketInfo
     * @param stock stock
     * @return StockCurrentVO
     */
    public static StockHistoricalVO transToStockHistorical(MarketInfo marketInfo, Stock stock) {

        if(marketInfo == null || stock == null) {
            return null;
        }

        StockHistoricalVO historicalVO = new StockHistoricalVO();

        historicalVO.setStockCode(marketInfo.getStockID());
        historicalVO.setStockName(marketInfo.getStockName());
        historicalVO.setStockMarket(marketInfo.getcMarket());

        //基础数据
        historicalVO.setDate(stock.getDate());
        historicalVO.setOpen(stock.getOpen());
        historicalVO.setClose(stock.getClose());
        historicalVO.setLow(stock.getLow());
        historicalVO.setHigh(stock.getHigh());
        historicalVO.setP_change(stock.getpChange());
        historicalVO.setPrice_change(stock.getPriceChange());
        historicalVO.setVolume(stock.getVolume());
        historicalVO.setVolume(stock.getVolume());
        historicalVO.setVolume(stock.getVolume());
        //均线数据
        historicalVO.setMa5(stock.getMa5());
        historicalVO.setMa10(stock.getMa10());
        historicalVO.setMa20(stock.getMa20());

        return historicalVO;
    }
}
