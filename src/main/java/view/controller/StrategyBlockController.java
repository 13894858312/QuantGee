package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * 控制输入股票名称小单元的controller
 * Created by wangxue on 2017/3/29.
 */
public class StrategyBlockController {

    @FXML private Button button;
    @FXML private TextField name;
    @FXML private Label label;

    private boolean isAdd;

    @FXML
    private void option(){

        if(isAdd){
            //新增一行输入框
        }else{
            //删除本行

        }

    }

    @FXML
    private void selectText(){
        name.selectAll();
    }

    public void setAdd() {
        isAdd = true;
        button.setText("新增");
    }

    public void setDelete(){
        isAdd = false;
        button.setText("删除");
    }

    public String getBlockName(){

        String name = this.name.getText().trim();

        if(name==null || name.equals("") || name.isEmpty()){
            return null;
        }else{
            return name;
        }

    }

    public void setBlock(){
        label.setText("板块");
    }

    public void setStock(){
        label.setText("股票");
    }
}
