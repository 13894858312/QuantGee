package vo;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class AverageLineVO {

    public String averageLineX;
    public double averageLineY;

    /**
     * @param averageLineX 横坐标（时间）
     * @param averageLineY 纵坐标（均值）
     */
    public AverageLineVO(String averageLineX, double averageLineY) {
        this.averageLineX = averageLineX;
        this.averageLineY = averageLineY;
    }

}
