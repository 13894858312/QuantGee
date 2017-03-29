package view.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.StrategyInputVO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 策略输入框
 * Created by wangxue on 2017/3/29.
 */
public class StrategyInputController {

    @FXML private Pane root;

    @FXML private VBox stockPane;

    @FXML private Label num;

    @FXML private DatePicker startPicker;
    @FXML private DatePicker endPicker;

    @FXML private TextField hold;
    @FXML private TextField make_TextField;
    @FXML private ChoiceBox make_ChoiceBox;

    @FXML private ChoiceBox strategyPicker;
    @FXML private ChoiceBox stockPool;

    private boolean isTextField = true;

    private final LocalDate MIN = LocalDate.of(2005,2,2);
    private final LocalDate MAX = LocalDate.of(2014,4,29);

    private final Callback<DatePicker, DateCell> dayCellFactory =
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate Item, boolean empty) {
                            super.updateItem(Item, empty);

                            if (Item.isBefore(MIN) || Item.isAfter(MAX)){
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                            long p = ChronoUnit.DAYS.between(
                                    MIN, Item
                            );
                            setTooltip(new Tooltip(
                                    "You're about to stay for " + p + " days")
                            );
                        }
                    };
                }
            };

    public void init(){
        //载入策略选择框
        strategyPicker.setItems(FXCollections.observableArrayList("动量策略","均值回归"));
        strategyPicker.setValue(0);

        //载入形成期选择框(不可见)
        make_ChoiceBox.setItems(FXCollections.observableArrayList("5天","10天","20天"));
        make_ChoiceBox.setValue(0);

        //载入股票池选项
        stockPool.setItems(FXCollections.observableArrayList("所有股票","选择板块","选择股票"));
        stockPool.setValue(0);

        //设定全部股票


        //设定时间选项
        startPicker.setDayCellFactory(dayCellFactory);
        startPicker.setValue(MIN);
        endPicker.setDayCellFactory(dayCellFactory);
        endPicker.setValue(MAX);

    }

    @FXML
    private void selectHoldText(){
        hold.selectAll();
    }

    @FXML
    private void selectMakeText(){
        make_TextField.selectAll();
    }

    @FXML
    private void search(){

    }

    @FXML
    private void close(){
        ((Stage)root.getScene().getWindow()).close();
    }


    private void setMake_TextField(){

        if(isTextField)return;

        make_ChoiceBox.setVisible(false);
        make_TextField.setVisible(true);

        isTextField = true;

    }

    private void setMake_ChoiceBox(){

        if(!isTextField)return;

        make_TextField.setVisible(false);
        make_ChoiceBox.setVisible(true);

        isTextField = false;

    }

    private void setAllStocks(){

    }

    private void setChosenBlocks(){

    }

    private void setChosenStocks(){

    }

    private StrategyInputVO getInput(){

        //所选时间要比MIN+形成期*1.5晚
        return null;
    }

}
