package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.StockPO;

public class GetStockPOsByTimeIntervalTest {

	@Test
	public void test1() {
		StockData stockData = new StockData();
		ArrayList<ArrayList<StockPO>> data = stockData.getAllStockPO("2/10/14","4/29/14");
//		System.out.println(data==null);
//		System.out.println(data.size());
//		for (ArrayList<StockPO> arrayList : data) {
//			System.out.println(arrayList.get(0).toString());
//		}
//		System.out.println(data.get(6).size());
	}

}
