package view.UI;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
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

        this.getStylesheets().add("/css/yieldArea.css");
        //x-xAxis
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("日期 (day)");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("策略胜率 (%)");

        /* chart */
        final AreaChart<Number, Number> lc = new AreaChart<Number, Number>(xAxis, yAxis);
        lc.setCreateSymbols(false);
        lc.setPrefSize(width, height);

        //data
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("日期");
        if(!judge) {
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.holdingPeriod, abnormalReturnGraphDataVO.stategyWinRate*100));
            }
        }else{
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.returnPeriod, abnormalReturnGraphDataVO.stategyWinRate*100));
            }
        }

        lc.getData().addAll(series);
        getChildren().add(lc);
    }
}
