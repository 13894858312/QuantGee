package logic.calculation;

import logic.tools.AverageLineType;
import logicService.GraphCalculationService;
import vo.AverageLineVO;
import vo.KLineVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class GraphCalculation implements GraphCalculationService {

    public ArrayList<KLineVO> getKLineInfo(Date startDate, Date endDate, String stockCode) {
        return null;
    }

    public ArrayList<AverageLineVO> getAverageLineInfo(Date startDate, Date endDate, AverageLineType averageLineType, String stockCode) {
        return null;
    }
}
