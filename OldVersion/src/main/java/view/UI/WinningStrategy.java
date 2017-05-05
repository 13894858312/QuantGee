package view.UI;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import logic.tools.MathHelper;
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

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("策略胜率 (%)");

        /* chart */
        final AreaChart<Number, Number> lc = new AreaChart<Number, Number>(xAxis, yAxis);
        lc.setPrefSize(width, height);

        //data
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();

        if(!judge) {
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                Circle circle = new Circle(1);
                circle.setFill(Color.rgb(2,226,244));
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.holdingPeriod, abnormalReturnGraphDataVO.stategyWinRate*100));
                xAxis.setLabel("持有期日期 (天)");
                series.setName("持有期日期");
                series.getData().get(i).setNode(circle);
            }
        }else{
            for (int i = 0; i <abnormalReturnGraphDataVOArrayList.size(); i++) {
                Circle circle = new Circle(1);
                circle.setFill(Color.rgb(2,226,244));
                AbnormalReturnGraphDataVO abnormalReturnGraphDataVO = abnormalReturnGraphDataVOArrayList.get(i);
                series.getData().add(new XYChart.Data<Number, Number>(abnormalReturnGraphDataVO.returnPeriod, abnormalReturnGraphDataVO.stategyWinRate*100));
                xAxis.setLabel("形成期日期 (天)");
                series.setName("形成期日期");
                series.getData().get(i).setNode(circle);
            }
        }

        lc.getData().addAll(series);
        for (XYChart.Data<Number, Number> d : series.getData()) {
            Tooltip.install(d.getNode(), new Tooltip(
                    series.getName() + " :" + d.getXValue().toString() + "\n" +
                            "策略胜率 : " + "\n" + MathHelper.formatData((double)d.getYValue(),4) + "%"));

            //Adding class on hover
            d.getNode().setOnMouseEntered(event -> d.getNode().getStyleClass().add("onHover"));

            //Removing class on exit
            d.getNode().setOnMouseExited(event -> d.getNode().getStyleClass().remove("onHover"));
        }
        getChildren().add(lc);
    }
}
