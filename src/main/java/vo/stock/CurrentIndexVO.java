package vo.stock;

import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/6/10.
 * 大盘实时数据 用于列表展示
 */
public class CurrentIndexVO {
    private String code;//    code:指数代码
    private Double preclose;//    preclose:昨日收盘点位
    private Double high;//    high:最高点位
    private Double low;//    low:最低点位
    private Long volume;//    volume:成交量(手)
    private Double amount;//    amount:成交金额（亿元）
    private Double openNum;//    openNum:开盘点位
    private Double closeNum;//    closeNum:收盘点位
    private Double changes;//    changes:涨跌幅
    private String time;

    public CurrentIndexVO(String code, Double preclose, Double high, Double low, Long volume,
                          Double amount, Double openNum, Double closeNum, Double changes, String time) {
        this.code = code;
        this.preclose = MathHelper.formatData(preclose,2);
        this.high = MathHelper.formatData(high,2);
        this.low = MathHelper.formatData(low, 2);
        this.volume = volume;
        this.amount = amount;
        this.openNum = MathHelper.formatData(openNum,2);
        this.closeNum = MathHelper.formatData(closeNum, 2);
        this.changes = MathHelper.formatData(changes,2);
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPreclose() {
        return preclose;
    }

    public void setPreclose(Double preclose) {
        this.preclose = preclose;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOpenNum() {
        return openNum;
    }

    public void setOpenNum(Double openNum) {
        this.openNum = openNum;
    }

    public Double getCloseNum() {
        return closeNum;
    }

    public void setCloseNum(Double closeNum) {
        this.closeNum = closeNum;
    }

    public Double getChanges() {
        return changes;
    }

    public void setChanges(Double changes) {
        this.changes = changes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
