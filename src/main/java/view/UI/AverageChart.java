package view.UI;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import logic.tools.DateHelper;
import javafx.scene.chart.XYChart;
import vo.AverageLineVO;
import vo.CumulativeYieldGraphDataVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */
public class AverageChart extends Pane{

    //累计收益率
    public AverageChart(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList1, ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList2
            , int width, int height){
            this.getStylesheets().add("/css/averageChart.css");
            //x-xAxis
            final CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("日期 (天)");

            //y-yAxis
            final NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("累计收益率 (%)");

            //chart
            final LineChart<String, Number> averageLineChart = new LineChart<String, Number>(xAxis, yAxis);
            averageLineChart.setPrefSize(width, height);
//            averageLineChart.setCreateSymbols(false);

            //date
            XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
            series1.setName("基准收益率");
            for (int i = 0; i <cumulativeYieldGraphDataVOArrayList1.size() ; i++) {
                CumulativeYieldGraphDataVO cumulativeYieldGraphDataVO = cumulativeYieldGraphDataVOArrayList1.get(i);
                series1.getData().add(new XYChart.Data<String, Number>(
                        DateHelper.getInstance().dateTransToString(cumulativeYieldGraphDataVO.date), cumulativeYieldGraphDataVO.ratio*100));
                Circle circle = new Circle(1);
                circle.setFill(Color.rgb(148,56,71));
                series1.getData().get(i).setNode(circle);
            }
            XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
            series2.setName("策略收益率");
            for (int i = 0; i <cumulativeYieldGraphDataVOArrayList2.size() ; i++) {
                CumulativeYieldGraphDataVO cumulativeYieldGraphDataVO = cumulativeYieldGraphDataVOArrayList2.get(i);
                series2.getData().add(new XYChart.Data<String, Number>(
                    DateHelper.getInstance().dateTransToString(cumulativeYieldGraphDataVO.date), cumulativeYieldGraphDataVO.ratio*100));
                Circle circle = new Circle(1);
                circle.setFill(Color.rgb(170,241,227));
                series2.getData().get(i).setNode(circle);
            }



            averageLineChart.getData().addAll(series1,series2);
            //鼠标监听
            for (XYChart.Data<String, Number> d : series1.getData()) {
                Tooltip.install(d.getNode(), new Tooltip(
                        d.getXValue().toString() + "\n" +
                                "累计收益率 : " + "\n" + d.getYValue()));

                //Adding class on hover
                d.getNode().setOnMouseEntered(event -> d.getNode().getStyleClass().add("onHover"));

                //Removing class on exit
                d.getNode().setOnMouseExited(event -> d.getNode().getStyleClass().remove("onHover"));
            }

            for (XYChart.Data<String, Number> d : series2.getData()) {
                Tooltip.install(d.getNode(), new Tooltip(
                        d.getXValue().toString() + "\n" +
                                "累计收益率 : "+ "\n" + d.getYValue()));

                //Adding class on hover
                d.getNode().setOnMouseEntered(event -> d.getNode().getStyleClass().add("onHover"));

                //Removing class on exit
                d.getNode().setOnMouseExited(event -> d.getNode().getStyleClass().remove("onHover"));
            }
            getChildren().add(averageLineChart);


    }



}
