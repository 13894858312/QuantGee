package view.UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.controller.SearchSharesController;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Ensemble_AdvCandleStickChart extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("AdvCandleStickChart from Ensemble");
//        Scene scene = new Scene(new AdvCandleStickChart());
//        scene.getStylesheets().add("/css/ensemble_AdvCandleStickChart.css");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
