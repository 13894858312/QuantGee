package view.UI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.controller.FirstPageController;
import view.controller.MainController;

import java.io.IOException;

/**
 * Created by wangxue on 2017/3/9.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(getClass().getResource("/fxml/FirstPage.fxml"));

        try{
            Pane root = rootLoader.load();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e){
            e.printStackTrace();
        }

        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();

        FirstPageController firstPageController = rootLoader.getController();

        MainController mainController = new MainController(primaryStage);

    }

    public static void main(String[] args){

        launch(args);

    }

}
