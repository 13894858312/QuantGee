package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.StockPO;

public class StockDataTest {

	@Test
	public void testGetStockPO() {
		StockData stockData = new StockData();
//		StockPO po = stockData.getStockPO("4/29/14", "1");
		StockPO po2 = stockData.getStockPO("10/10/11", "2418");
//		assertEquals("data:4/29/14	openPrice:11.02	maxValue:11.25	minValue:10.92	closePrice:11.16	volume:41362100	ADJ:11.16	stockCode:1	stockName:深发展Ａ	stockMarket:SZ", po.toString());
		assertEquals("data:10/10/11	openPrice:8.72	maxValue:8.75	minValue:8.6	closePrice:8.63	volume:284600	ADJ:8.47	stockCode:2418	stockName:康盛股份	stockMarket:SZ", po2.toString());
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
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval( "4/17/14", "4/25/14","1");
		for (StockPO stockPO : stockPOs) {
			System.out.println(stockPO.getVolume());
		}
	}
	
	@Test
	public void testGetStockPOsByTimeInterval2() {
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("8/19/11", "8/29/11", "402");
		for (StockPO stockPO : stockPOs) {
			System.out.println(stockPO.getVolume());
		}
	}
	
	@Test
	public void testGetStockPOsByTimeInterval3() {
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("2/7/05", "2/10/05", "1");
		for (StockPO stockPO : stockPOs) {
			System.out.println(stockPO.getVolume());
		}
	}
	
	@Test
	public void testGetStockPOsByTimeInterval4(){
		StockData stockData = new StockData();
		ArrayList<StockPO> stockPOs = stockData.getStockPOsByTimeInterval("4/26/14", "4/29/14", "1");
		assertEquals(2, stockPOs.size());
	}
	
	@Test
	public void testGetStockCodeByName(){
		StockData stockData = new StockData();
		String stockCode = stockData.getStockCodeByName("莱美药业");
		assertEquals("300006", stockCode);
	}
}
