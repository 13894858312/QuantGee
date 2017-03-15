package view.UI;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import logic.tools.DateHelper;
import vo.StockDailyInfoVO;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Administrator on 2017/3/13.
 */
public class LogYield_Compare extends Pane {
    public LogYield_Compare(ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList, int width, int height){

        this.getStylesheets().add("/css/logYield_Compare.css");
        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Date");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Logarithmic Yield");

        //chart
        final LineChart<String, Number> lc = new LineChart<String, Number>(xAxis, yAxis);
        lc.setCreateSymbols(false);
        lc.setPrefSize(width, height);
        lc.setTitle("Logarithmic Yield Of Shares");

        //data
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("Logarithm Yield");
        for(int i=stockDailyInfoVOArrayList.size()-1;i>=0;i--){
            StockDailyInfoVO stockDailyInfoVO = stockDailyInfoVOArrayList.get(i);
            series.getData().add(new XYChart.Data<String, Number>(DateHelper.getInstance().dateTransToString(stockDailyInfoVO.date), stockDailyInfoVO.logarithmYield));
        }

        lc.getData().addAll(series);
        getChildren().add(lc);
    }
}
