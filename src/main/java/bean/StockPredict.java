package bean;

import javax.persistence.*;

/**
 * Created by Mark.W on 2017/5/27.
 */
@Entity
@IdClass(StockPredictPK.class)
public class StockPredict {
    private String code;
    private String date;
    private Double predictedPrice;
    private Double actualPrice;
    private Double historyDeviation;

    private Double predictIncrease;

    @Basic
    @Column(name = "predictIncrease", nullable = true, precision = 0)
    public Double getPredictIncrease() {
        return predictIncrease;
    }

    public void setPredictIncrease(Double predictIncrease) {
        this.predictIncrease = predictIncrease;
    }

    @Id
    @Column(name = "code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Id
    @Column(name = "date", nullable = false, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "predictedPrice", nullable = true, precision = 0)
    public Double getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(Double predictedPrice) {
        this.predictedPrice = predictedPrice;
    }

    @Basic
    @Column(name = "actualPrice", nullable = true, precision = 0)
    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    @Basic
    @Column(name = "historyDeviation", nullable = true, precision = 0)
    public Double getHistoryDeviation() {
        return historyDeviation;
    }

    public void setHistoryDeviation(Double historyDeviation) {
        this.historyDeviation = historyDeviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPredict that = (StockPredict) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (predictedPrice != null ? !predictedPrice.equals(that.predictedPrice) : that.predictedPrice != null)
            return false;
        if (actualPrice != null ? !actualPrice.equals(that.actualPrice) : that.actualPrice != null) return false;
        if (historyDeviation != null ? !historyDeviation.equals(that.historyDeviation) : that.historyDeviation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (predictedPrice != null ? predictedPrice.hashCode() : 0);
        result = 31 * result + (actualPrice != null ? actualPrice.hashCode() : 0);
        result = 31 * result + (historyDeviation != null ? historyDeviation.hashCode() : 0);
        return result;
    }
}
