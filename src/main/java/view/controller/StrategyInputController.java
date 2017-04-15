package view.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logic.calculation.StrategyCalculation;
import logicService.StrategyCalculationService;
import vo.StrategyInputVO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * 策略输入框
 * Created by wangxue on 2017/3/29.
 */
public class StrategyInputController {

    private StrategyCalculationService strategyCalculationService;

    @FXML private Pane root;

    @FXML private ScrollPane scrollPane;
    @FXML private AnchorPane leftPane;
    @FXML private VBox blockPane;

    @FXML private HBox hBox;
    @FXML private Label num;

    @FXML private DatePicker startPicker;
    @FXML private DatePicker endPicker;

    @FXML private TextField hold;
    @FXML private TextField make_TextField;
    @FXML private ChoiceBox make_ChoiceBox;

    @FXML private ChoiceBox strategyPicker;
    @FXML private ChoiceBox stockPool;

    @FXML private CheckBox chooseHold;
    @FXML private CheckBox chooseMake;

    @FXML private Label makeLabel;
    @FXML private Label holdLabel;

    @FXML private Label perLabel;
    @FXML private TextField perField;
    @FXML private Label perLabel1;

    private ArrayList<HBox> stocks;
    private ArrayList<StrategyStockController> strategyStockControllers;

    private StrategyBoardController strategyBoardController;

    private int count = 0;

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


    public StrategyInputController(){
        strategyCalculationService = new StrategyCalculation();
    }
    
    public void init(){
        //载入策略选择框
        strategyPicker.setItems(FXCollections.observableArrayList("动量策略","均值回归"));
        strategyPicker.setValue("动量策略");
        strategyPicker.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        if(newValue.equals(0))setDongLiangCeLue();
                        else if(newValue.equals(1))setJunZhiHuiGui();

                    }
                }
        );

        //载入形成期选择框(不可见)
        make_ChoiceBox.setItems(FXCollections.observableArrayList("5天","10天","20天"));
        make_ChoiceBox.setValue("5天");


        //载入股票池选项
        stockPool.setItems(FXCollections.observableArrayList("    所有股票","    选择板块","    选择股票"));
        stockPool.setValue("所有股票");
        stockPool.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        if(newValue.equals(0)){
                            setAllStocks();
                        }else if(newValue.equals(1)){
                            setChosenBlocks();
                        }else if(newValue.equals(2)){
                            setChosenStocks();
                        }

                    }
                }
        );

        //初始化左侧并设定全部股票
        stocks = new ArrayList<HBox>();
        strategyStockControllers = new ArrayList<StrategyStockController>();

        //设定时间选项
        startPicker.setDayCellFactory(dayCellFactory);
        startPicker.setValue(MIN);
        endPicker.setDayCellFactory(dayCellFactory);
        endPicker.setValue(MAX);

        //设定单选框浮标
        chooseHold.setSelected(true);
        chooseHold.setTooltip(new Tooltip("选为生成超额收益率关系图的数据"));
        chooseMake.setTooltip(new Tooltip("选为生成超额收益率关系图的数据"));

    }

    /*
    鼠标选择,删除内容
     */
    @FXML
    private void selectHoldText(){ hold.setText("");}

    @FXML
    private void selectMakeText(){
        make_TextField.setText("");
    }

    /*
    搜索
     */
    @FXML
    private void search(){

    }

    /*
    取消输入，关闭输入框
     */
    @FXML
    private void close(){
        ((Stage)root.getScene().getWindow()).close();
    }


    /*
    两个框只能选一个
     */
    @FXML
    private void chooseHoldFunc(){
        if(chooseHold.isSelected()){
            chooseMake.setSelected(false);
        }
    }

    @FXML
    private void chooseMakeFunc(){
        if(chooseMake.isSelected()){
            chooseHold.setSelected(false);
        }
    }

    /*
    选择动量策略（0）
     */
    private void setDongLiangCeLue(){

        //可视性更改
        make_ChoiceBox.setVisible(false);
        make_TextField.setVisible(true);

        chooseMake.setVisible(true);
        chooseHold.setVisible(true);

        makeLabel.setVisible(false);
        holdLabel.setVisible(false);

        perLabel.setVisible(true);
        perLabel1.setVisible(true);
        perField.setVisible(true);

        //数据清空
        hold.setText("请输入整数天");
        make_ChoiceBox.setValue("5天");

    }

    /*
    选择均值回归（1）
     */
    private void setJunZhiHuiGui(){

        //可视性更改
        make_TextField.setVisible(false);
        make_ChoiceBox.setVisible(true);

        chooseMake.setVisible(false);
        chooseHold.setVisible(false);

        makeLabel.setVisible(true);
        holdLabel.setVisible(true);

        perLabel.setVisible(false);
        perLabel1.setVisible(false);
        perField.setVisible(false);

        //数据清空
        chooseHold.setSelected(true);
        chooseMake.setSelected(false);
        hold.setText("请输入整数天");
        make_TextField.setText("请输入整数天");
    }

    /*
    股票池选项
     */
    private void setAllStocks(){

        leftPane.getChildren().clear();
        scrollPane.setDisable(true);

        //清空其他controller
        strategyBoardController = null;
        stocks = null;
        strategyStockControllers = null;
    }

    private void setChosenBlocks(){

        leftPane.getChildren().clear();
        scrollPane.setDisable(false);

        try{

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyBoard.fxml"));
            Pane root = fxmlLoader.load();
            leftPane.getChildren().add(root);

            strategyBoardController = fxmlLoader.getController();

        }catch (Exception e){
            e.printStackTrace();
        }

        //清空其他controller
        stocks = null;
        strategyStockControllers = null;

    }

    private void setChosenStocks(){

        leftPane.getChildren().clear();
        scrollPane.setDisable(false);
        showHBox();

        stocks = new ArrayList<HBox>();
        strategyStockControllers = new ArrayList<StrategyStockController>();


        //清空其他controller
        strategyBoardController = null;
    }

    public void addBlock(){

        count++;
        num.setText(Integer.toString(count));

    }

    public void deleteBlock() {

        count--;
        num.setText(Integer.toString(count));

    }

    private void showHBox(){

        hBox.setVisible(true);
        count = 0;
        num.setText(Integer.toString(count));

    }

    private void showMessage(String str){

        Stage dialog = new Stage();

        try{

            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource("/fxml/Dialog.fxml"));
            Pane root = rootLoader.load();
            dialog.setScene(new Scene(root));
            DialogController dialogController = rootLoader.getController();
            dialogController.setText(str);

        }catch (IOException e){
            e.printStackTrace();
        }

        dialog.centerOnScreen();
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setResizable(false);
        dialog.show();

        return;

    }

    /*
    得到全部数据并检查数据正确性
     */
    private StrategyInputVO getInput(){

        //所选时间要比MIN+形成期*1.5晚
        return null;
    }

}
