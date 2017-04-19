package view.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.concurrent.Callable;

/**
 * Created by wangxue on 2017/4/19.
 */
public class Loading implements Callable {

    Stage stage;
    Stage parent;

    public Loading(Stage parent){

        Image image = new Image("/pictures/loading.gif",300,230,true,true);
        ImageView imageView = new ImageView(image);
        Pane pane = new AnchorPane(imageView);
        Scene scene = new Scene(pane);
        stage = new Stage();
        stage.setScene(scene);

        this.parent = parent;

    }

    @Override
    public Stage call() throws Exception {

        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.initOwner(parent);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                stage.show();
            }
        });

        return stage;

    }

}
