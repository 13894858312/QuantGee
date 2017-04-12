package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Created by wangxue on 2017/4/5.
 */
public class StrategyBoardController {

    //主板 创业板 中小板
    @FXML
    private RadioButton mother;
    @FXML
    private RadioButton gem;
    @FXML
    private RadioButton small;

    String blockname = "主板";

    @FXML
    private ToggleGroup RBs;

    /*
     * @return string 0=主板
     */
    public String getChosenBoard(){
        return blockname;
    }

    @FXML
    private void choose0(){
        blockname = "主板";
    }

    @FXML
    private void choose1(){
        blockname = "创业板";
    }

    @FXML
    private void choose2(){
        blockname = "中小板";
    }

}
