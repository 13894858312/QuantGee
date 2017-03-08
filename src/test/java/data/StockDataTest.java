package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.StockPO;

public class StockDataTest {

	@Test
	public void testGetStockPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStockPOsByDate() {
		fail("Not yet implemented");
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
	

}
