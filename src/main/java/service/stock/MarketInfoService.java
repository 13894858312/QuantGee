package service.stock;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface MarketInfoService {

    public KLine getKLine(KLineInput kLineInput);

    public AverageLine getAverageLine(AverageLineInput averageLineInput);

    public Histogram getHistogram(HistogramInput histogramInput);

}
