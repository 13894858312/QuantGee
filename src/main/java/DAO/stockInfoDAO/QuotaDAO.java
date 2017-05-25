package DAO.stockInfoDAO;

import bean.Boll;
import bean.Kdj;
import bean.Macd;
import bean.Rsi;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/23.
 */
public interface QuotaDAO {
    /**
     * 得到MACD
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param code 股票代码
     * @return Iterator<Macd>
     */
    public Iterator<Macd> getMACDs(String startDate, String endDate, String code);

    /**
     * 添加MACD
     * @param macd macd数据
     * @return boolean
     */
    public boolean addMACD(Macd macd);

    /**
     * 得到KDJ
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param code 股票代码
     * @return Iterator<Kdj>
     */
    public Iterator<Kdj> getKDJs(String startDate, String endDate, String code);

    /**
     * 添加kdj
     * @param kdj kdj数据
     * @return boolean
     */
    public boolean addKDJ(Kdj kdj);

    /**
     * 得到Rsi
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param code 股票代码
     * @return Iterator<Rsi>
     */
    public Iterator<Rsi> getRSIs(String startDate, String endDate, String code);

    /**
     * 添加boll
     * @param rsi rsi数据
     * @return boolean
     */
    public boolean addRSI(Rsi rsi);

    /**
     * 得到boll
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param code 股票代码
     * @return Iterator<Boll>
     */
    public Iterator<Boll> getBOLLs(String startDate, String endDate, String code);

    /**
     * 添加boll
     * @param boll boll数据
     * @return boolean
     */
    public boolean addBOLL(Boll boll);


}
