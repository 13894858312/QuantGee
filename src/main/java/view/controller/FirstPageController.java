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

    private MainPageController mainPageController;

    @FXML
    public void goToMain(){

        mainPageController = new MainPageController();
        mainPageController.showLeftPane();

    }

    @FXML
    public void close(){
        System.exit(0);
    }

}
