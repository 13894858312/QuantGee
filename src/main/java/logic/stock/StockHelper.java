package logic.stock;

/**
 * Created by Mark.W on 2017/6/3.
 */
public class StockHelper {

    /**
     * 判断代码是否是大盘
     * sh=上证指数 sz=深圳成指 zxb=中小板 cyb=创业板
     * @param code 股票代码
     */
    public static boolean isBlock(String code) {
        if(code.equals("sh") || code.equals("sz") || code.equals("zxb") || code.equals("cyb")) {
            return true;
        }
        return false;
    }

    public static String getMarketName(String code) {
        String result = null;

        if (code.startsWith("300")) { //cyb
            result = "创业板";
        } else if (code.startsWith("60")) {  //sh
            result = "上证";
        } else if (code.startsWith("000")) { //sz
            result = "深证";
        } else if (code.startsWith("60")){ //zxb
            result = "中小板";
        }
        return result;
    }
}
