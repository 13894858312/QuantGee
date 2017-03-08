package logicService;

import logic.tools.AverageLineType;
import vo.AverageLineVO;
import vo.KLineVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public interface GraphCalculationService {

    /**
     * 根据开始日期，结束日期和股票编号绘画k线图
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockCode 股票编号
     * @return  ArrayList<KLineVO>
     */
    public ArrayList<KLineVO> getKLineInfo(Date startDate, Date endDate, String stockCode);

    /**
     * 根据开始日期、结束日期、时间间隔和股票编号绘画均线图图
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param averageLineType 均线图时间间隔
     * @param stockCode  股票编号
     * @return ArrayList<AverageLineVO>
     */
    public ArrayList<AverageLineVO> getAverageLineInfo(Date startDate, Date endDate, AverageLineType averageLineType, String stockCode);


}
