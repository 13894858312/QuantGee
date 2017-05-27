package vo.strategy;

/**
 * 累计收益率图中坐标信息
 * Created by Mark.W on 2017/3/23.
 */
public class CumulativeYieldGraphDataVO {
    public String date;
    public double ratio;  //收益率

    /**
     * @param date 日期 横坐标
     * @param ratio 收益率
     */
    public CumulativeYieldGraphDataVO(String date, double ratio) {
        this.date = date;
        this.ratio = ratio;
    }
}
