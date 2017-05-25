package logic.stock;

import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.*;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.stock.StockBasicInfoService;
import sun.security.pkcs11.wrapper.CK_DATE;
import vo.stock.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockBasicInfoServiceImp implements StockBasicInfoService {

    @Autowired
    private StockInfoDAO stockInfoDAO;

    @Autowired
    private QuotaDAO quotaDAO;

    @Autowired
    private TransferHelper transferHelper;


    @Override
    public ArrayList<RealTimeLineVO> getStockRealTimeLineInfo(String code) {
        Iterator<Current> stocks = stockInfoDAO.getStockRealTimeList(code);
        ArrayList<RealTimeLineVO> result = new ArrayList<>();

        while(stocks.hasNext()) {
            Current temp = stocks.next();
            result.add(new RealTimeLineVO(temp.getCode(), temp.getTime(), temp.getTrade(), temp.getVolume()));
        }
        return result;
    }

    @Override
    public StockCurrentVO getStockRealTimeInfo(String code) {
        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(code);
        Current current = stockInfoDAO.getStockRealTimeInfo(code);

        return transferHelper.transToStockCurrent(marketInfo, current);
    }

    @Override
    public ArrayList<StockCurrentVO> getAllStockRealTime() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();
        return this.getStockCurrentVOs(codes);
    }

    @Override
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName) {
        Iterator<String> codes = stockInfoDAO.getAllStockCodesByIndustry(industryName);
        return this.getStockCurrentVOs(codes);
    }

    /**
     * 根据代码列表获取数据 用来方法服用
     * @param codes 代码
     * @return ArrayList<StockCurrentVO>
     */
    public ArrayList<StockCurrentVO> getStockCurrentVOs(Iterator<String> codes) {

        ArrayList<StockCurrentVO> result = new ArrayList<>();

        while(codes.hasNext()) {
            String code = codes.next();
            if(code != null && !code.equals("")) {
                result.add(getStockRealTimeInfo(code));
            }
        }

        if(result.size() == 0) {
            return null;
        }
        return result;
    }


    @Override
    public StockHistoricalVO getStockHistoricalInfo(StockInputVO inputVO) {

        assert inputVO != null : "StockBasicInfoServiceImp.getStockHistoricalInfo.inputvo为null";

        //日k
        ArrayList<KLineVO> kLine = new ArrayList<>();
        //成交量
        ArrayList<LineVO> volume = new ArrayList<>();
        //均线图
        ArrayList<LineVO> ma5 = new ArrayList<>();
        ArrayList<LineVO> ma10 = new ArrayList<>();
        ArrayList<LineVO> ma20 = new ArrayList<>();
        //对数收益
        ArrayList<LineVO> logarithmYields = new ArrayList<>();
        //macd
        ArrayList<LineVO> diff = new ArrayList<>();
        ArrayList<LineVO> dea = new ArrayList<>();
        ArrayList<LineVO> macd = new ArrayList<>();
        //kdj
        ArrayList<LineVO> k = new ArrayList<>();
        ArrayList<LineVO> d = new ArrayList<>();
        ArrayList<LineVO> j = new ArrayList<>();
        //rsi
        ArrayList<LineVO> rsi6 = new ArrayList<>();
        ArrayList<LineVO> rsi12 = new ArrayList<>();
        ArrayList<LineVO> rsi24 = new ArrayList<>();
        //boll
        ArrayList<LineVO> mid = new ArrayList<>();
        ArrayList<LineVO> up = new ArrayList<>();
        ArrayList<LineVO> low = new ArrayList<>();

        Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getStockCode(),
                inputVO.getStartDate(), inputVO.getEndDate());

        Stock stock = null, formerStock;
        String date;

        while(stocks.hasNext()) {
            formerStock = stock;
            stock = stocks.next();
            date = stock.getDate();

            kLine.add(new KLineVO(date, stock.getOpen(), stock.getClose(), stock.getLow(), stock.getHigh()));
            volume.add(new LineVO(date, stock.getVolume()));
            ma5.add(new LineVO(date, stock.getMa5()));
            ma10.add(new LineVO(date, stock.getMa10()));
            ma20.add(new LineVO(date, stock.getMa20()));

            //对数收益率
            if(formerStock != null && stock != null) {
                double logarithmYield = Math.log(stock.getClose() / formerStock.getClose());
                logarithmYields.add(new LineVO(date, logarithmYield));
            }
        }

        Iterator<Macd> macds = quotaDAO.getMACDs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());
        Iterator<Kdj> kdjs = quotaDAO.getKDJs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());
        Iterator<Rsi> rsis = quotaDAO.getRSIs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());
        Iterator<Boll> bolls = quotaDAO.getBOLLs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());

        Macd m;
        while(macds.hasNext()) {
            m = macds.next();
            diff.add(new LineVO(m.getDate(), m.getDiff()));
            dea.add(new LineVO(m.getDate(), m.getDea()));
            macd.add(new LineVO(m.getDate(), m.getMacd()));
        }

        Kdj kdj;
        while(kdjs.hasNext()) {
            kdj = kdjs.next();
            k.add(new LineVO(kdj.getDate(), kdj.getK()));
            d.add(new LineVO(kdj.getDate(), kdj.getD()));
            j.add(new LineVO(kdj.getDate(), kdj.getJ()));
        }

        Rsi rsi;
        while(rsis.hasNext()) {
            rsi = rsis.next();
            rsi6.add(new LineVO(rsi.getDate(), rsi.getRsi6()));
            rsi12.add(new LineVO(rsi.getDate(), rsi.getRsi12()));
            rsi24.add(new LineVO(rsi.getDate(), rsi.getRsi24()));
        }

        Boll boll;
        while(bolls.hasNext()) {
            boll = bolls.next();
            mid.add(new LineVO(boll.getDate(), boll.getMid()));
            up.add(new LineVO(boll.getDate(), boll.getUp()));
            low.add(new LineVO(boll.getDate(), boll.getLow()));
        }

        MarketInfo market = stockInfoDAO.getMarketInfo(inputVO.getStockCode());

        StockHistoricalVO result = new StockHistoricalVO(market.getCode(), market.getName(), market.getcName(), inputVO.getStartDate(),
                inputVO.getEndDate(), kLine, volume, ma5, ma10, ma20, logarithmYields, diff, dea, macd,
                k, d, j, rsi6, rsi12, rsi24, mid, up, low);

        return result;
    }

}
