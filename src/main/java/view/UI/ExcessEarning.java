package view.UI;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import logic.tools.DateHelper;
import vo.AbnormalReturnGraphDataVO;
import vo.StockDailyInfoVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ExcessEarning extends Pane{
    public ExcessEarning(boolean judge, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOArrayList, int width, int height){

        this.getStylesheets().add("/css/logYield_Compare.css");
        //x-xAxis
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Date");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("ExcessEarning Yield");

        /* chart */
        final AreaChart<Number, Number> lc = new AreaChart<Number, Number>(xAxis, yAxis);
        lc.setCreateSymbols(false);
        lc.setPrefSize(width, height);
        lc.setTitle("ExcessEarning Yield Chart");

        //data
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("Date");
        if(!judge) {
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.holdingPeriod, abnormalReturnGraphDataVO.abnormalReturn));
            }
        }else{
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.returnPeriod, abnormalReturnGraphDataVO.abnormalReturn));
            }
        }

        lc.getData().addAll(series);
        getChildren().add(lc);
    }
}
