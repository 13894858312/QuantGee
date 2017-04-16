package data;

import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;

import dataDao.StockDataDao;
import po.BaseCumulativeYieldPO;
import po.StockPO;

/**
 * Created by Mark.W on 2017/3/4.
 */
public class StockData implements StockDataDao{
	
	
	public StockPO getStockPO(String date, String stockCode) {
		
		if (date==null||date.equals("")) {
			return null;
		}
		
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		String[] newDate = date.split("/");
		
		path  = path+"/all_stock_data/all_data_by_year/"+newDate[2]+".txt";
		File file = new File(path);
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			line = br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] strings = line.split("\\t");
				if (strings[1].equals(date) && strings[8].equals(stockCode)&&Integer.parseInt(strings[6])!=0) {

					StockPO po = new StockPO(strings[1],Double.parseDouble(strings[2]),
							Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
							Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
							Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]);
					return po;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<StockPO> getStockPOsByDate(String date){
		
		ArrayList<StockPO> stockPOS = new ArrayList<StockPO>();
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		String[] newDate = date.split("/");
		
		path  = path+"/all_stock_data/all_data_by_year/"+newDate[2]+".txt";
		File file = new File(path);
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			line = br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] strings = line.split("\\t");
				if (strings[1].equals(date) && Integer.parseInt(strings[6])!=0) {
					StockPO po = new StockPO(strings[1],Double.parseDouble(strings[2]),
							Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
							Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
							Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]);
					stockPOS.add(po);
				}
			}
			
			return stockPOS;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<StockPO> getStockPOsByTimeInterval(String startDate, String endDate, String stockCode) {
		
		ArrayList<StockPO> stockPOS = new ArrayList<StockPO>();
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		path  = path+"/all_stock_data/all_data_by_name/"+getFileNameByCode(stockCode)+".txt";
		File file = new File(path);

		String[] validDate = getVaildDate(startDate, endDate, path);
		startDate = validDate[0];
		endDate = validDate[1];
		if (endDate==null||startDate==null) {
			return null;
		}
		
		if (startDate.equals(endDate)) {
			stockPOS.add(getStockPO(endDate, stockCode));
			return stockPOS;
		}
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			line = br.readLine();
			boolean inTimeRange = false; 	//在要搜寻的时间范围内
			
			while((line = br.readLine()) != null) {
				
				String[] strings = line.split("\\t");
				
				if (inTimeRange) {
					if (strings[1].equals(startDate)) {
						inTimeRange = false;
					}
					
					if (Integer.parseInt(strings[6])!=0) {
						StockPO po = new StockPO(strings[1],Double.parseDouble(strings[2]),
								Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
								Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
								Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]);
						stockPOS.add(po);
					}
					
				}else {
					if (strings[1].equals(endDate)) {

						inTimeRange = true;
						
						if (Integer.parseInt(strings[6])!=0) {
							StockPO po = new StockPO(strings[1],Double.parseDouble(strings[2]),
									Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
									Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
									Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]);
							stockPOS.add(po);
						}
						
					}else{
						if (!inTimeRange) {
							break;
						}
					}
				}
			}
			return stockPOS;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public String getStockCodeByName(String stockName) {
		
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		File file = new File(path+"/all_stock_data/all_data_by_name/fileName.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null) {
				line  = line.replaceAll("Ａ", "A");
				String[] strings = line.split(":");
				strings[1] = strings[1].replace(" ","");
				if (strings[1].equals(stockName) ) {
					return strings[0];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getFileNameByCode(String stockCode) {
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		File file = new File(path+"/all_stock_data/all_data_by_name/fileName.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null) {
				String[] strings = line.split(":");
				if (strings[0].equals(stockCode) ) {
					return strings[2];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String[] getVaildDate(String startDate , String endDate , String path){
		
		File file = new File(path);
		int endDateDiff = 0;
		int startDateDiff = 0;
		String firstLineDate = "";
		String lastLineDate = "";
		String[] vaildDate = new String[2];
		String[] endDates = endDate.split("/");
		String[] startDates = startDate.split("/");
		Date newStartDate = new Date(Integer.parseInt(startDates[2])+100, Integer.parseInt(startDates[0])-1, Integer.parseInt(startDates[1]));
		Date newEndDate = new Date(Integer.parseInt(endDates[2])+100, Integer.parseInt(endDates[0])-1, Integer.parseInt(endDates[1]));
		String lastDate = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			br.readLine();					//读表头
			
			String line = br.readLine();	//读第一行
			
			String[] strings = line.split("\\t");
			firstLineDate = strings[1];
			if (strings[1].equals(endDate)) {
				vaildDate[1] = endDate;
			}else {
				String[] date = strings[1].split("/");
				Date newDate = new Date(Integer.parseInt(date[2])+100, Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
				endDateDiff = (int) ((newEndDate.getTime() - newDate.getTime()) / (1000*3600*24));
				startDateDiff = (int)((newStartDate.getTime() - newDate.getTime()) / (1000*3600*24));
				lastDate = strings[1];
			}
			

			while((line = br.readLine()) != null){
				
				strings = line.split("\\t");
				
				lastLineDate = strings[1];
				
				if (strings[1].equals(startDate)) {
					vaildDate[0] =  startDate;
				}
				if (strings[1].equals(endDate)) {
					vaildDate[1] = endDate;
				}
				
				String[] date = strings[1].split("/"); 
				//获取有效的结束日期
				if (vaildDate[1]==null) {
					
					Date newDate = new Date(Integer.parseInt(date[2])+100, Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
					if(endDateDiff*(int) ((newEndDate.getTime() - newDate.getTime()) / (1000*3600*24))<0){
						vaildDate[1] = strings[1];
					}
					endDateDiff = (int) ((newEndDate.getTime() - newDate.getTime()) / (1000*3600*24));
					
				}
				
				
				//获取有效的开始日期
				if(vaildDate[0]==null){
					Date newDate = new Date(Integer.parseInt(date[2])+100, Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
					if(startDateDiff*(int) ((newStartDate.getTime() - newDate.getTime()) / (1000*3600*24))<0){
						vaildDate[0] = lastDate;
					}
					startDateDiff = (int) ((newStartDate.getTime() - newDate.getTime()) / (1000*3600*24));
				}
				
				lastDate = strings[1];
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (vaildDate[0]==null) {
			vaildDate[0]=lastLineDate;
		}
		
		if (vaildDate[1]==null) {
			vaildDate[1]=firstLineDate;
		}
		
		return vaildDate;
	}

	@Override
	public ArrayList<ArrayList<StockPO>> getStockPOsByBlockName(String startDate, String endDate, String blockName) {
		
		//判断板块名称，不符合规范则返回空
		if (!(blockName.equals("主板")||blockName.equals("创业板")||blockName.equals("中小板"))) {
			return null;
		}
		
		ArrayList<ArrayList<StockPO>> datas = new ArrayList<ArrayList<StockPO>>();
		
		//在Block_Name中获取当前板块的所有股票编码
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		File file = new File(path+"/all_stock_data/Block_Name/"+blockName+".txt");
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			
			//读取当前板块的所有股票代码
			while((line = br.readLine()) != null) {
				String[] strings = line.split(":");
				
				//获取到股票代码调用getStockPOsByTimeInterval方法读取该代码的股票信息
				datas.add(getStockPOsByTimeInterval(startDate, endDate, strings[0]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public ArrayList<ArrayList<StockPO>> getAllStockPO(String startDate, String endDate) {
		
		ArrayList<ArrayList<StockPO>> datas = new ArrayList<ArrayList<StockPO>>();
		
		//在Block_Name中获取所有股票编码
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		File file = new File(path+"/all_stock_data/all_data_by_name/fileName.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = br.readLine()) != null) {
				String[] strings = line.split(":");
				
				//获取到股票代码调用getStockPOsByTimeInterval方法读取该代码的股票信息
				ArrayList<StockPO> pos = getStockPOsByTimeInterval(startDate, endDate, strings[0]);
//				datas.add(getStockPOsByTimeInterval(startDate, endDate, strings[0]));
				datas.add(pos);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return datas;
		
	}

//	public ArrayList<ArrayList<StockPO>> getAllStockPO1(String startDate, String endDate) {
//		
//		ArrayList<ArrayList<StockPO>> allDatas = new ArrayList<ArrayList<StockPO>>();
//		
//		//查询“股票历史数据ALL.txt”
//		String path = System.getProperty("user.dir");
//		path.replace("\\\\", "/");
//		File file = new File(path+"/all_stock_data/股票历史数据ALL.txt");
//		
//		BufferedReader br;
//		
//		try {
//			
//			br = new BufferedReader(new FileReader(file));
//			
//			String line = br.readLine();		//第一行舍弃
//			String code = "";					//记录股票代码
//			
//			ArrayList<StockPO> stockPOs = new ArrayList<StockPO>();		//记录当前股票信息
//
//			while((line = br.readLine()) != null) {
//				
//				String[] strings  = line.split("\\t");
//				
//				int i = 0;
//				//判断是否是新股票
//				if (!code.equals(strings[8])) {
//
//					code = strings[8];
//					if (!stockPOs.isEmpty()) {
//						ArrayList<StockPO> datas = new ArrayList<>();
//						datas.addAll(stockPOs);
//						allDatas.add(datas);
//						i++;
//					}
//					
////					if (!allDatas.isEmpty()) {
////						System.out.println(allDatas.get(i-1).get(0).getCodeNumber());
////					}
//					
//					stockPOs = new ArrayList<>();
//					continue;
//				}
//				
//				//将股票信息存入Arraylist
//				stockPOs.add(new StockPO(strings[1],Double.parseDouble(strings[2]),
//						Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
//						Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
//						Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]));
//				
//				
//			}
//			
//			//加入最后一次股票数据
//			allDatas.add(stockPOs);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return allDatas;
//	}

	@Override
	public ArrayList<BaseCumulativeYieldPO> getBaseYieldByBlockName(String blockName, String startDate, String endDate) {
		
		ArrayList<BaseCumulativeYieldPO>  yielPOs  = new ArrayList<>();
		
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		path = path+"/all_stock_data/Block_Name/"+blockName+".txt";
		File file = new File(path);
		

		String[] vaildDate = getVaildDate(startDate, endDate, path);
		startDate = vaildDate[0];
		endDate = vaildDate[1];
		
		if (endDate==null||startDate==null) {
			return null;
		}
		
		try {
			//将收益率化成两位小数
			DecimalFormat df = new DecimalFormat("######0.00"); 
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			boolean inTimeRange = false; 	//在要搜寻的时间范围内
			
			while ((line=br.readLine())!=null) {
				
				String[] strings = line.split("\\t");
				
				if (inTimeRange) {
					if (strings[1].equals(startDate)) {
						inTimeRange = false;
					}
					
					BaseCumulativeYieldPO baseCumulativeYielPO = new BaseCumulativeYieldPO(strings[1], Double.valueOf(df.format(Double.valueOf(strings[4]))));
					yielPOs.add(baseCumulativeYielPO);
					
				}else {
					if (strings[1].equals(endDate)) {

						inTimeRange = true;
						
						BaseCumulativeYieldPO baseCumulativeYielPO = new BaseCumulativeYieldPO(strings[1], Double.valueOf(df.format(Double.valueOf(strings[4]))));
						yielPOs.add(baseCumulativeYielPO);
						
					}else{
						if (!inTimeRange) {
							break;
						}
					}
				}
			}
			return yielPOs;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
