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
import jdk.nashorn.internal.ir.Block;
import logic.calculation.StrategyCalculation;
import logicService.StrategyCalculationService;
import vo.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

/**
 * 策略输入框
 * Created by wangxue on 2017/3/29.
 */
public class StrategyInputController {

    private StrategyCalculationService strategyCalculationService;
    private MainPageController mainPageController;

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

    private StrategyType strategyType ;
    private boolean isHold ;
    private BlockType blockType ;

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
    
    public void init(MainPageController mainPageController){

        this.mainPageController = mainPageController;

        //载入策略选择框
        strategyPicker.setItems(FXCollections.observableArrayList("动量策略","均值回归"));
        strategyPicker.setValue("动量策略");

        strategyType = StrategyType.MOMENTUM_DRIVEN;

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
        stockPool.setItems(FXCollections.observableArrayList("所有股票","选择板块","选择股票"));
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
        isHold = true;
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

        StrategyInputVO strategyInputVO = getInput();
        //错误则结束
        if(strategyInputVO == null){return;}

        BackTestingResultVO backTestingResultVO = strategyCalculationService
                .getStrategyBackTestingGraphInfo(strategyType , strategyInputVO );
        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyCalculationService.getAbnormalReturnGraphInfo(strategyType , strategyInputVO , isHold);

        //没有返回值则弹出对话框并结束
        if(backTestingResultVO == null || strategyInputVO == null){
            showMessage("无结果");
            return;
        }

        //一切正常则显示策略界面
        showResult(backTestingResultVO , abnormalReturnGraphVO);

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
        isHold = true;
    }

    @FXML
    private void chooseMakeFunc(){
        if(chooseMake.isSelected()){
            chooseHold.setSelected(false);
        }
        isHold = false;
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

        perLabel.setText("持有比例");
        perLabel1.setVisible(true);
        perField.setText("");

        //数据清空
        hold.setText("请输入整数天");
        make_ChoiceBox.setValue("5天");

        //策略更改
        strategyType = StrategyType.MOMENTUM_DRIVEN;
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

        perLabel.setText("持有数量");
        perLabel1.setVisible(false);
        perField.setText("请输入整数");

        //数据清空
        chooseHold.setSelected(true);
        chooseMake.setSelected(false);
        hold.setText("请输入整数天");
        make_TextField.setText("请输入整数天");

        //策略修改
        strategyType = StrategyType.MEAN_REVERSION;

    }

    /*
    股票池选项
     */
    private void setAllStocks(){

        blockPane.getChildren().clear();
        scrollPane.setDisable(true);

        //清空其他controller
        strategyBoardController = null;
        stocks = null;
        strategyStockControllers = null;

    }

    private void setChosenBlocks(){

        blockPane.getChildren().clear();
        scrollPane.setDisable(false);

        try{

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyBoard.fxml"));
            Pane root = fxmlLoader.load();
            blockPane.getChildren().add(root);

            strategyBoardController = fxmlLoader.getController();

        }catch (Exception e){
            e.printStackTrace();
        }

        //清空其他controller
        stocks = null;
        strategyStockControllers = null;

    }

    private void setChosenStocks(){

        blockPane.getChildren().clear();
        scrollPane.setDisable(false);
        showHBox();

        stocks = new ArrayList<HBox>();
        strategyStockControllers = new ArrayList<StrategyStockController>();

        try{

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyStock.fxml"));

            HBox root = fxmlLoader.load();
            stocks.add(root);
            blockPane.getChildren().add(root);

            StrategyStockController controller = fxmlLoader.getController();
            controller.init(this);
            strategyStockControllers.add(controller);
            controller.setIndex(0);

        }catch (Exception e){
            e.printStackTrace();
        }

        //清空其他controller
        strategyBoardController = null;

    }

    public void addBlock(){

        count++;
        num.setText(Integer.toString(count));

        try{

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyStock.fxml") );
            HBox root = fxmlLoader.load();
            stocks.add(root);
            blockPane.getChildren().add(root);
            StrategyStockController controller = fxmlLoader.getController();
            controller.init(this);
            strategyStockControllers.add(controller);
            controller.setIndex(count);

        }catch (Exception e){
            e.printStackTrace();
        }

        showBlockPane();

    }
//待修改
    public void deleteBlock(int index) {

        count--;
        num.setText(Integer.toString(count));
        stocks.remove(index);

        //删除时需要重新设index和按钮
        for(int i = 0 ; i <= count ; i++ ){
            strategyStockControllers.get(i).setIndex(i);

            strategyStockControllers.get(i).setDelete();
        }

        showBlockPane();

    }

    /*
    删除后重显
     */
    private void showBlockPane(){
        blockPane.getChildren().clear();
        blockPane.getChildren().addAll(stocks);
    }

    /*
    选择输入股票时，显示当前计数
     */
    private void showHBox(){

        hBox.setVisible(true);
        count = 0;
        num.setText(Integer.toString(count));

    }

    /*
    弹出对话框
    @param 要显示的字符串
     */
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

        //股票池种类，0为全部，1为板块，2为股票
        int stockPoolType = stockPool.getSelectionModel().getSelectedIndex();

        LocalDate startLocalDate = startPicker.getValue();
        LocalDate endLocalDate = endPicker.getValue();
        if(startLocalDate.isAfter(endLocalDate)){
            showMessage("开始时间不应晚于结束时间");
            return null;
        }else if(strategyType == StrategyType.MEAN_REVERSION){
            int time = 0;
            int temp = make_ChoiceBox.getSelectionModel().getSelectedIndex();
            if(temp == 0){
                time = 8;
            }else if(temp == 1){
                time = 15;
            }else if(temp == 2){
                time = 30;
            }
            //所选时间要比MIN+形成期*1.5晚
            if(startLocalDate.isBefore(LocalDate.of(2005,2,2).plusDays(time))){
                showMessage("开始日期过早");
                return null;
            }
        }
        Date startDate = Helper.localDateToDate(startLocalDate);
        Date endDate = Helper.localDateToDate(endLocalDate);

        int holdInt;
        try{
            holdInt = new Integer(hold.getText().trim());
        }catch (Exception e) {
            //不是整数显示对话框
            showMessage("请输入整数持有期");
            return null;
        }
        double holdNum = 0;
        try{
            holdNum = new Double(perField.getText().trim());
        }catch (Exception e){
            showMessage("请输入合法数值");
            return null;
        }

        ///////

        if(strategyType == StrategyType.MOMENTUM_DRIVEN){
            //动量策略
            int makeInt;
            try{
                makeInt = new Integer(make_TextField.getText().trim());
            }catch (Exception e) {
                //不是整数显示对话框
                showMessage("请输入整数形成期");
                return null;
            }

            if( stockPoolType == 2)//选择股票
            {
                ArrayList<String> stockNames = getStockNames();
                if(stockNames == null){
                    return null;
                }
                return new StrategyInputVO(startDate , endDate , stockNames , holdInt , makeInt , holdNum/100);
            }else if( stockPoolType == 1)//选择板块
            {
                blockType = strategyBoardController.getBlockType();
                return  new StrategyInputVO(startDate , endDate , blockType , holdInt , makeInt ,holdNum/100 );
            }else//选择全部
            {
                return new StrategyInputVO(startDate , endDate , holdInt , makeInt , holdNum/100 );
            }

        }else{
            //均值回归
            int makeInt;
            if(make_ChoiceBox.getSelectionModel().getSelectedIndex() == 0){
                makeInt = 5;
            }else if(make_ChoiceBox.getSelectionModel().getSelectedIndex() == 1){
                makeInt = 10;
            }else{
                makeInt = 20;
            }

            if((int) holdNum != holdNum){
                //持有数量不是整数
                showMessage("请输入整数");
                return null;
            }

            if(stockPoolType == 2)//选择股票
            {
                ArrayList<String> stockNames = getStockNames();
                if(stockNames == null){
                    return null;
                }
                return new StrategyInputVO(startDate , endDate , stockNames , holdInt , makeInt , holdNum);

            }else if(stockPoolType == 1)//选择板块
            {
                blockType = strategyBoardController.getBlockType();
                return new StrategyInputVO(startDate , endDate , blockType , holdInt , makeInt , (int) holdNum);
            }else{
                return new StrategyInputVO(startDate , endDate , holdInt , makeInt ,(int) holdNum);
            }

        }

    }

    private ArrayList<String> getStockNames(){

        if(count < 100){
            showMessage("至少需要输入100支股票");
            return null;
        }

        ArrayList<String> stockNames = new ArrayList<>();
        for(int i = 0 ; i < count ; i++ ) {
            String name = strategyStockControllers.get(i).getBlockName();
            if(name == null){
                showMessage("请输入股票代码");
                return null;
            }
            stockNames.add(name);
        }
        return stockNames;

    }

    /*
    显示strategypane
     */
    private void showResult(BackTestingResultVO backTestingResultVO , AbnormalReturnGraphVO abnormalReturnGraphVO){

        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyPane.fxml"));
            Pane root = fxmlLoader.load();
            StrategyPaneController strategyPaneController = fxmlLoader.getController();

            strategyPaneController.init(backTestingResultVO , abnormalReturnGraphVO , isHold);
            mainPageController.showRightPane(root);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
