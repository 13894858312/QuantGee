package service.stock;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface MarketInfoService {

    public String getKLineInfoByName();

    public String getKLineInfoByCode();

    public String getAverageLineInfoByName();

    public String getAverageLineInfoByCode();

    public String getHistogram();
}
