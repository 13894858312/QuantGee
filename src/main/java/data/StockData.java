package data;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

import dataDao.StockDataDao;
import po.StockPO;

/**
 * Created by Mark.W on 2017/3/4.
 */
public class StockData implements StockDataDao{
	
	
	public StockPO getStockPO(String date, String stockCode) {
		
		String path = System.getProperty("user.dir");
		path.replace("\\\\", "/");
		String[] newDate = date.split("/");
		
		path  = path+"/all_data_by_year/"+newDate[2]+".txt";
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
		
		path  = path+"/all_data_by_year/"+newDate[2]+".txt";
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
		path  = path+"/all_data_by_name/"+getFileNameByCode(stockCode)+".txt";
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
					
					if (strings[1].equals(endDate)&&Integer.parseInt(strings[6])!=0) {
						
						inTimeRange = true;
						StockPO po = new StockPO(strings[1],Double.parseDouble(strings[2]),
								Double.parseDouble(strings[3]),Double.parseDouble(strings[4]),
								Double.parseDouble(strings[5]),Integer.parseInt(strings[6]),
								Double.parseDouble(strings[7]),strings[8],strings[9],strings[10]);
						stockPOS.add(po);
						
					}else{
						if (inTimeRange) {
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
		File file = new File(path+"/all_data_by_name/fileName.txt");

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
		File file = new File(path+"/all_data_by_name/fileName.txt");

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
		return vaildDate;
	}
}
