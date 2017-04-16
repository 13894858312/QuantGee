package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * 控制输入股票名称小单元的controller
 * Created by wangxue on 2017/3/29.
 */
public class StrategyStockController {

    @FXML private Button button;
    @FXML private TextField name;
    @FXML private HBox rootPane;

    private int index;
    private boolean isAdd = true;
    private StrategyInputController strategyInputController;

    public void init(StrategyInputController strategyInputController){
        this.strategyInputController = strategyInputController;
    }

    @FXML
    private void option(){

        if(isAdd){
            //新增一行输入框
            strategyInputController.addBlock();
            setDelete();
        }else{
            //删除本行
            rootPane.getChildren().clear();
            strategyInputController.deleteBlock(index);
        }

    }

    @FXML
    private void selectText(){
        name.setText("");
    }

    public void setDelete(){
        isAdd = false;
        button.setText("删除");
    }

    public void setAdd(){
        isAdd = true;
        button.setText("新增");
    }

    public String getBlockName(){

        String name = this.name.getText().trim();

        if(name==null || name.equals("") || name.isEmpty()){
            return null;
        }else{
            return name;
        }

    }

    public void setIndex(int index){
        this.index = index ;
    }

    public int getIndex(){
        return this.index;
    }

}
