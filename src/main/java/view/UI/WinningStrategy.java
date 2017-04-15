package view.UI;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import vo.AbnormalReturnGraphDataVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/15.
 */
public class WinningStrategy extends Pane {
    public WinningStrategy(boolean judge, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOArrayList, int width, int height){

//        this.getStylesheets().add("/css/logYield_Compare.css");
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
        if(judge) {
            for (int i = abnormalReturnGraphDataVOArrayList.size() - 1; i >= 0; i--) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.holdingPeriod, abnormalReturnGraphDataVO.stategyWinRate));
            }
        }else{
            for (int i = abnormalReturnGraphDataVOArrayList.size() - 1; i >= 0; i--) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.returnPeriod, abnormalReturnGraphDataVO.stategyWinRate));
            }
        }

        lc.getData().addAll(series);
        getChildren().add(lc);
    }
}
