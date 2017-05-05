package view.UI;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import logic.tools.DateHelper;
import vo.StockDailyInfoVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/13.
 */
public class LogYield_Compare extends Pane {
    public LogYield_Compare(ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList, int width, int height){

        this.getStylesheets().add("/css/logYield_Compare.css");
        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("日期 (天)");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("对数收益率 (%)");

        /* chart */
        final AreaChart<String, Number> lc = new AreaChart<String, Number>(xAxis, yAxis);
        lc.setCreateSymbols(false);
        lc.setPrefSize(width, height);

        //data
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("对数收益率");
        for(int i=stockDailyInfoVOArrayList.size()-1;i>=0;i--){
            StockDailyInfoVO stockDailyInfoVO = stockDailyInfoVOArrayList.get(i);
            series.getData().add(new XYChart.Data<String, Number>(DateHelper.getInstance().dateTransToString(stockDailyInfoVO.date), stockDailyInfoVO.logarithmYield*100));
        }

        lc.getData().addAll(series);
        getChildren().add(lc);
    }
}
