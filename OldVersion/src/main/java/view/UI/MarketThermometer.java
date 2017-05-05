package view.UI;

import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import vo.MarketInfoVO;

/**
 * Created by Administrator on 2017/3/10.
 */
public class MarketThermometer extends Pane {

    public MarketThermometer(MarketInfoVO marketInfoVO){

        this.getStylesheets().add("/css/marketThermometer.css");
        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("涨跌幅");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("股票个数");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setPrefSize(700,500);
        bc.setCategoryGap(30);
        bc.setTitle("市场温度计");
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("股票个数");
        series.getData().add(new XYChart.Data<String, Number>("跌停\n"+"   ("+marketInfoVO.rateNums[0]+")", marketInfoVO.rateNums[0]));
        series.getData().add(new XYChart.Data<String, Number>("跌幅5%-10%\n"+"   ("+marketInfoVO.rateNums[1]+")", marketInfoVO.rateNums[1]));
        series.getData().add(new XYChart.Data<String, Number>("跌幅0-5%\n"+"   ("+marketInfoVO.rateNums[2]+")", marketInfoVO.rateNums[2]));
        series.getData().add(new XYChart.Data<String, Number>("涨幅0-5%\n"+"   ("+marketInfoVO.rateNums[3]+")", marketInfoVO.rateNums[3]));
        series.getData().add(new XYChart.Data<String, Number>("涨幅5%-10%\n"+"   ("+marketInfoVO.rateNums[4]+")", marketInfoVO.rateNums[4]));
        series.getData().add(new XYChart.Data<String, Number>("涨停\n"+"   ("+marketInfoVO.rateNums[5]+")", marketInfoVO.rateNums[5]));
        series.getData().add(new XYChart.Data<String, Number>("开收>5%\n"+"   ("+marketInfoVO.greaterThanFiveNum+")", marketInfoVO.greaterThanFiveNum));
        series.getData().add(new XYChart.Data<String, Number>("开收<-5%\n"+"   ("+marketInfoVO.lessThanFiveNum+")", marketInfoVO.lessThanFiveNum));

        bc.getData().addAll(series);

        getChildren().add(bc);
    }

}
