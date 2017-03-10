package view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by wangxue on 2017/3/9.
 */
public class MainPageController{

    @FXML private Pane rightPane;

    @FXML private Button search_0;
    @FXML private Button search_1;
    @FXML private Button search_2;

    @FXML private Button leave;

    @FXML private DatePicker date;
    @FXML private DatePicker start_1;
    @FXML private DatePicker end_1;
    @FXML private DatePicker start_2;
    @FXML private DatePicker end_2;

    @FXML private TextField num_1;
    @FXML private TextField num_2_0;
    @FXML private TextField num_2_1;

    public void showLeftPane(){

        try{

            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource("/fxml/MainPage.fxml"));
            Pane root = rootLoader.load();
            MainController.getStage().setScene(new Scene(root));
            MainController.resetStage();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void closeStage(){
        System.exit(0);
    }

    @FXML
    public void showMarketInfo(){

        //待补充
        showRightPane(RightType.MARKETINFO);
    }

    @FXML
    public void showSearchShares(){

        //待补充
        showRightPane(RightType.SEARCHSHARES);
    }

    @FXML
    public void showCompareShares(){

        //待补充
        showRightPane(RightType.COMPARESHARES);
    }

    private void showRightPane(RightType rightType){

        String str = "" ;

        if(rightType == RightType.MARKETINFO){
            str += ("/fxml/MarketInfo.fxml");
        }else if(rightType == RightType.SEARCHSHARES){
            str += ("/fxml/SearchShares.fxml");
        }else if(rightType == RightType.COMPARESHARES){
            str += ("/fxml/CompareShares.fxml");
        }

        try{

            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource(str));
            Pane root = rootLoader.load();
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(root);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void noResult(){

        Stage dialog = new Stage();

        try{

            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource("/fxml/Dialog.fxml"));
            Pane root = rootLoader.load();
            dialog.setScene(new Scene(root));
            DialogController dialogController = rootLoader.getController();
            dialogController.setText("未找到数据");

        }catch (IOException e){
            e.printStackTrace();
        }

        dialog.centerOnScreen();
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setResizable(false);
        dialog.show();

        return;

    }

}
