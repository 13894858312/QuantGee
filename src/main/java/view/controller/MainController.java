package view.controller;

import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Created by wangxue on 2017/3/9.
 * 主要负责管理stage
 */
public class MainController {

    private static Stage stage;

    public MainController(Stage stage){
        this.stage = stage;
    }

    public static Stage getStage(){
        return stage;
    }

    public static void resetStage(){
        stage.centerOnScreen();
    }

}
