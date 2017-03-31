package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.StockPO;

public class GetStockPOsByTimeIntervalTest {

	@Test
	public void test1() {
		StockData stockData = new StockData();
		ArrayList<ArrayList<StockPO>> data = stockData.getAllStockPO();
		System.out.println(data.get(0).get(1).toString());
	}

}
