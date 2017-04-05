package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Created by wangxue on 2017/4/5.
 */
public class StrategyBoardController {

    @FXML
    private RadioButton mother;
    @FXML
    private RadioButton gem;
    @FXML
    private RadioButton small;

    @FXML
    private ToggleGroup RBs;

    public void getChosenBoard(){
        RBs.getSelectedToggle();
        System.out.print(RBs.getSelectedToggle());
    }
}
