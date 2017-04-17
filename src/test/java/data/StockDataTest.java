package data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import po.BaseCumulativeYieldPO;
import po.StockPO;

public class StockDataTest {

	@Test
	public void testGetStockPO1() {
		StockData stockData = new StockData();
		StockPO po2 = stockData.getStockPO("10/10/11", "2418");
		assertEquals("data:10/10/11	openPrice:8.72	maxValue:8.75	minValue:8.6	closePrice:8.63	volume:284600	ADJ:8.47	stockCode:2418	stockName:康盛股份	stockMarket:SZ", po2.toString());
	}
	
	@Test
	public void testGetStockPO2(){
		StockData stockData = new StockData();
		StockPO po = stockData.getStockPO("4/29/14", "1");
		assertEquals("data:4/29/14	openPrice:11.02	maxValue:11.25	minValue:10.92	closePrice:11.16	volume:41362100	ADJ:11.16	stockCode:1	stockName:深发展Ａ	stockMarket:SZ", po.toString());
	}

	@Test
	public void testGetStockPOsByDate() {
		StockData stockData = new StockData();
		ArrayList<StockPO> list = stockData.getStockPOsByDate("4/21/14");
		assertEquals(10.9, list.get(0).getMaxValue(),0);
	}

	@Test
	public void testGetStockPOsByTimeInterval1() {
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval( "4/19/14", "4/29/14","1",false);
		assertEquals(7, stockPOs.size());
	}
	
	@Test
	public void testGetStockPOsByTimeInterval2() {
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("4/1/14","4/29/14", "150",false);
		assertEquals(1, stockPOs.size());
	}
	
	@Test
	public void testGetStockPOsByTimeInterval3() {
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("2/1/05","4/29/14", "2039",false);
		assertEquals(2151, stockPOs.size());
	}
	
	@Test
	public void testGetStockPOsByTimeInterval4(){
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("4/26/14", "4/29/14", "1",false);
		assertEquals(2, stockPOs.size());
	}
	
	@Test
	public void testGetStockPOsByTimeInterval5(){
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("4/26/14", "4/29/14", "10",true);
		assertEquals(true, stockPOs==null);
	}
	
	@Test
	public void testGetStockCodeByName(){
		StockData stockData = new StockData();
		String stockCode = stockData.getStockCodeByName("南玻A");
		assertEquals("12", stockCode);
	}
	
	@Test
	public void testGetStockCodeByName2(){
		StockData stockData = new StockData();
		String stockCode = stockData.getStockCodeByName("深发展A");
		assertEquals("1", stockCode);
	}
	
	@Test
	public void testGetStockCodeByName3(){
		StockData stockData = new StockData();
		String stockCode = stockData.getStockCodeByName("*ST中华A");
		assertEquals("17", stockCode);
	}
	
	@Test
	public void testGetValidDate(){
		StockData stockData = new StockData();
		String[] validDate = stockData.getVaildDate("4/13/14", "4/30/14", "D:/workspace/QuantGee/all_stock_data/all_data_by_name/1_深发展Ａ.txt");
		assertEquals("start:4/14/14 end:4/29/14", "start:"+validDate[0]+" end:"+validDate[1]);
	}
	
	@Test
	public void testGetValidDate2(){
		StockData stockData  = new StockData();
		String[] validDate = stockData.getVaildDate("8/19/11", "8/20/11", "D:/workspace/QuantGee/all_stock_data/all_data_by_name/402_金 融 街.txt");
		String[] trueDate = new String[2];
		trueDate[0] = "8/19/11";
		trueDate[1] = "8/19/11";
		assertArrayEquals(trueDate, validDate);
	}
	
	@Test
	public void testGetValidDate3(){
		StockData stockData  = new StockData();
		String[] validDate = stockData.getVaildDate("2/1/14", "2/4/14", "D:/workspace/QuantGee/all_stock_data/all_data_by_name/1_深发展Ａ.txt");
		String[] trueDate = new String[2];
		trueDate[0] = "2/3/14";
		trueDate[1] = "2/3/14";
		assertArrayEquals(trueDate, validDate);
	}
	
	@Test
	public void testGetValidDate4(){
		StockData stockData  = new StockData();
		String[] validDate = stockData.getVaildDate("4/27/14", "4/29/14", "D:/workspace/QuantGee/all_stock_data/all_data_by_name/1_深发展Ａ.txt");
		String[] trueDate = new String[2];
		trueDate[0] = "4/28/14";
		trueDate[1] = "4/29/14";
		assertArrayEquals(trueDate, validDate);
	}
	
	@Test
	public void testGetAllStockPO() {
		StockData stockData = new StockData();
		ArrayList<ArrayList<StockPO>> data = stockData.getAllStockPO("2/10/14","4/29/14",false);
		assertEquals(791, data.size());
	}
	
	@Test
	public void testGetBaseYieldByBlockName1(){
		StockData stockData = new StockData();
		ArrayList<BaseCumulativeYieldPO> data = stockData.getBaseYieldByBlockName("000300", "4/13/14", "4/29/14");
		for (BaseCumulativeYieldPO baseCumulativeYieldPO : data) {
			System.out.println(baseCumulativeYieldPO.getBaseRatio());
		}
	}
	
	@Test
	public void testGetBaseYieldByBlockName2(){
		StockData stockData = new StockData();
		ArrayList<BaseCumulativeYieldPO> data = stockData.getBaseYieldByBlockName("399005", "2/10/05", "4/29/14");
		for (BaseCumulativeYieldPO baseCumulativeYieldPO : data) {
			System.out.println(baseCumulativeYieldPO.getBaseRatio());
		}
	}
}
