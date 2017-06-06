package logic.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.stock.PredictStockService;
import vo.stock.StockAnalysisVO;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class PredictStockServiceImpTest {

    @Autowired
    private PredictStockService predictStockService;

    @Test
    public void getStockAnalysisInfo1() throws Exception {
        StockAnalysisVO result = predictStockService.getStockAnalysisInfo("000007");
        System.out.println("********************"+ result.getCode() + "*************************************");
        System.out.println("MACD: "+ result.getMacdAnalysis());
        System.out.println("***************************************************************");
        System.out.println("KDJ : "+ result.getKdjAnalysis());
        System.out.println("***************************************************************");
        System.out.println("RSI : "+ result.getRsiAnalysis());
        System.out.println("***************************************************************");
        System.out.println("BOLL: "+ result.getBollAnalysis());
        System.out.println("***************************************************************");
    }

    @Test
    public void getStockAnalysisInfo2() throws Exception {
        StockAnalysisVO result = predictStockService.getStockAnalysisInfo("000006");
        System.out.println("********************"+ result.getCode() + "*************************************");
        System.out.println("MACD: "+ result.getMacdAnalysis());
        System.out.println("***************************************************************");
        System.out.println("KDJ : "+ result.getKdjAnalysis());
        System.out.println("***************************************************************");
        System.out.println("RSI : "+ result.getRsiAnalysis());
        System.out.println("***************************************************************");
        System.out.println("BOLL: "+ result.getBollAnalysis());
        System.out.println("***************************************************************");
    }


}