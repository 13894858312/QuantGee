package view.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.io.IOException;
import view.controller.MainPageController;

/**
 * Created by wangxue on 2017/3/9.
 */
public class FirstPageController{

    @FXML private Pane firstPane;
    @FXML private Button go;

    @FXML
    public void goToMain(){

        try{

            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource("/fxml/MainPage.fxml"));
            Pane root = rootLoader.load();
            MainController.getStage().setScene(new Scene(root));
            MainController.resetStage();

            MainPageController mainPageController = rootLoader.getController();

        } catch (IOException e){
            e.printStackTrace();
        }


    }

    @FXML
    public void close(){
        System.exit(0);
    }

}
