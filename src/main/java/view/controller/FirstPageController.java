package view.controller;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by wangxue on 2017/3/9.
 */
public class FirstPageController{

    @FXML private Pane firstPane;
    @FXML private Button go;

    @FXML
    public void goToMain(){
        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(getClass().getResource("/fxml/首页.fxml"));

        try{
            Pane root = rootLoader.load();
            MainController.getStage().setScene(new Scene(root));
            MainController.resetStage();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void close(Event event){
        System.exit(0);
    }

}
