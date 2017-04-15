package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import vo.BlockType;

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

    private BlockType blockType = BlockType.MAIN_BLOCK;

    @FXML
    private ToggleGroup RBs;

    /*
     * @return string 0=主板
     */
    public BlockType getBlockType(){
        return blockType;
    }

    @FXML
    private void choose0(){
        blockType = BlockType.MAIN_BLOCK;
    }

    @FXML
    private void choose1(){
        blockType = BlockType.STARTUP_BLOCK;
    }

    @FXML
    private void choose2(){
        blockType = BlockType.MIDDLE_SMALL_BLOCK;
    }

}
