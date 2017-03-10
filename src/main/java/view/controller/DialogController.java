package view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

/**
 * Created by wangxue on 2017/3/10.
 */
public class DialogController {

    @FXML private Label myLabel ;
    @FXML private Pane root;

    public void setText(String str){
        myLabel.setText(str);
    }

    @FXML
    private void close(){
        ((Stage)root.getScene().getWindow()).close();
    }

}
