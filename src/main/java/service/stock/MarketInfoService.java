package service.stock;

import bean.AverageLine;
import bean.Histogram;
import bean.KLine;
import input.AverageLineInput;
import input.HistogramInput;
import input.KLineInput;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface MarketInfoService {

    public KLine getKLine(KLineInput kLineInput);

    public AverageLine getAverageLine(AverageLineInput averageLineInput);

    public Histogram getHistogram(HistogramInput histogramInput);

}
