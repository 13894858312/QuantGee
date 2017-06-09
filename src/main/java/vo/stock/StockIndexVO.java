package vo.stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/6/9.
 */
public class StockIndexVO {
    private String code;
    private String name;
    private String stockMarket;
    private String startDate;
    private String endDate;

    //macd
    private ArrayList<LineVO> diff;
    private ArrayList<LineVO> dea;
    private ArrayList<LineVO> macd;

    //kdj
    private ArrayList<LineVO> k;
    private ArrayList<LineVO> d;
    private ArrayList<LineVO> j;

    //rsi
    private ArrayList<LineVO> rsi6;
    private ArrayList<LineVO> rsi12;
    private ArrayList<LineVO> rsi24;

    //boll
    private ArrayList<LineVO> mid;
    private ArrayList<LineVO> up;
    private ArrayList<LineVO> low;

    public StockIndexVO(String code, String name, String stockMarket, String startDate, String endDate,
                        ArrayList<LineVO> diff, ArrayList<LineVO> dea, ArrayList<LineVO> macd, ArrayList<LineVO> k,
                        ArrayList<LineVO> d, ArrayList<LineVO> j, ArrayList<LineVO> rsi6, ArrayList<LineVO> rsi12,
                        ArrayList<LineVO> rsi24, ArrayList<LineVO> mid, ArrayList<LineVO> up, ArrayList<LineVO> low) {
        this.code = code;
        this.name = name;
        this.stockMarket = stockMarket;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diff = diff;
        this.dea = dea;
        this.macd = macd;
        this.k = k;
        this.d = d;
        this.j = j;
        this.rsi6 = rsi6;
        this.rsi12 = rsi12;
        this.rsi24 = rsi24;
        this.mid = mid;
        this.up = up;
        this.low = low;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getStockMarket() {
        return stockMarket;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public ArrayList<LineVO> getDiff() {
        return diff;
    }

    public ArrayList<LineVO> getDea() {
        return dea;
    }

    public ArrayList<LineVO> getMacd() {
        return macd;
    }

    public ArrayList<LineVO> getK() {
        return k;
    }

    public ArrayList<LineVO> getD() {
        return d;
    }

    public ArrayList<LineVO> getJ() {
        return j;
    }

    public ArrayList<LineVO> getRsi6() {
        return rsi6;
    }

    public ArrayList<LineVO> getRsi12() {
        return rsi12;
    }

    public ArrayList<LineVO> getRsi24() {
        return rsi24;
    }

    public ArrayList<LineVO> getMid() {
        return mid;
    }

    public ArrayList<LineVO> getUp() {
        return up;
    }

    public ArrayList<LineVO> getLow() {
        return low;
    }
}
