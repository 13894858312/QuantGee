package vo.stock;

/**
 * Created by Mark.W on 2017/6/5.
 * 股票指标的分析
 */
public class StockAnalysisVO {
    private String code;
    private String macdAnalysis;
    private String kdjAnalysis;
    private String rsiAnalysis;
    private String bollAnalysis;

    public StockAnalysisVO(String code, String macdAnalysis, String kdjAnalysis,
                           String rsiAnalysis, String bollAnalysis) {
        this.code = code;
        this.macdAnalysis = macdAnalysis;
        this.kdjAnalysis = kdjAnalysis;
        this.rsiAnalysis = rsiAnalysis;
        this.bollAnalysis = bollAnalysis;
    }

    public String getCode() {
        return code;
    }

    public String getMacdAnalysis() {
        return macdAnalysis;
    }

    public String getKdjAnalysis() {
        return kdjAnalysis;
    }

    public String getRsiAnalysis() {
        return rsiAnalysis;
    }

    public String getBollAnalysis() {
        return bollAnalysis;
    }
}
