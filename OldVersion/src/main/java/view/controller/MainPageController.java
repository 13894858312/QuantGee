package view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DateCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.calculation.DataCalculation;
import logicService.DataCalculationService;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import javafx.scene.control.Tooltip;
import javafx.util.Callback;
import vo.MarketInfoVO;
import vo.StockVO;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class MainPageController{

    private DataCalculationService dataCalculationService;

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

    private final LocalDate MIN = LocalDate.of(2005,2,2);
    private final LocalDate MAX = LocalDate.of(2014,4,29);

    private final Callback<DatePicker, DateCell> dayCellFactory =
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate Item,  boolean empty) {
                            super.updateItem(Item, empty);

                            if (Item.isBefore(MIN) || Item.isAfter(MAX)||
                                    Item.getDayOfWeek().equals(DayOfWeek.SATURDAY) || Item.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                                setDisable(true);
                                setStyle("-fx-background-color: #999999;");
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

    public static MainPageController mainPageController;

    public static MainPageController getInstance(){
        if (mainPageController == null){
            mainPageController = new MainPageController();
        }
        return mainPageController;
    }

    public MainPageController(){

        dataCalculationService = new DataCalculation();

    }

    @FXML
    private void closeStage(){
        System.exit(0);
    }

    @FXML
    private void showMarketInfo(){

        LocalDate localDate = this.date.getValue();

        MarketInfoVO marketInfoVO = dataCalculationService.getMarketInfo(Helper.localDateToDate(localDate));

        if(marketInfoVO==null){
            showMessage("无数据");
            return;
        }

        FXMLLoader rootLoader = new FXMLLoader();

        try{

            rootLoader.setLocation(getClass().getResource("/fxml/MarketInfo.fxml"));
            Pane root = rootLoader.load();
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(root);

        } catch (IOException e){
            e.printStackTrace();
        }

        MarketInfoController marketInfoController = rootLoader.getController();
        marketInfoController.init(marketInfoVO);

    }

    @FXML
    private void showSearchShares(){

        LocalDate start = start_1.getValue();
        LocalDate end = end_1.getValue();

        if(end.isBefore(start)||end.equals(start)){
            showMessage("结束时间不应早于开始时间");
            return;
        }

        Date startDate = Helper.localDateToDate(start);
        Date endDate = Helper.localDateToDate(end);

        String input = num_1.getText().trim();
        InputState inputState = Helper.checkInputState(input);

        StockVO stockVO ;

        if(inputState == InputState.NAME){
            stockVO = dataCalculationService.getStockInfoByName(input,startDate,endDate);
        }else if(inputState == InputState.NUM){
            stockVO = dataCalculationService.getStockInfoByCode(input,startDate,endDate);
        }else{
            showMessage("请输入股票代码/名称");
            return;
        }

        if(stockVO == null){
            showMessage("无数据");
            return;
        }

        FXMLLoader rootLoader = new FXMLLoader();

        try{

            rootLoader.setLocation(getClass().getResource("/fxml/SearchShares.fxml"));
            Pane root = rootLoader.load();
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(root);

        } catch (IOException e){
            e.printStackTrace();
        }

        SearchSharesController searchSharesController = rootLoader.getController();
        searchSharesController.init(stockVO,startDate,endDate);

    }

    @FXML
    private void showCompareShares(){


        LocalDate start = start_2.getValue();
        LocalDate end = end_2.getValue();

        if(end.isBefore(start)||end.equals(start)){
            showMessage("结束时间不应早于开始时间");
            return;
        }

        Date startDate = Helper.localDateToDate(start);
        Date endDate = Helper.localDateToDate(end);

        String input_0 = num_2_0.getText();
        String input_1 = num_2_1.getText();

        StockVO stockVO_0 ;
        InputState inputState_0 = Helper.checkInputState(input_0);

        if(inputState_0 == InputState.NAME){
            stockVO_0 = dataCalculationService.getStockInfoByName(input_0,startDate,endDate);
        }else if(inputState_0 == InputState.NUM){
            stockVO_0 = dataCalculationService.getStockInfoByCode(input_0,startDate,endDate);
        }else{
            showMessage("请输入股票代码/名称");
            return;
        }

        StockVO stockVO_1 ;
        InputState inputState_1 = Helper.checkInputState(input_1);

        if(inputState_1 == InputState.NAME){
            stockVO_1 = dataCalculationService.getStockInfoByName(input_1,startDate,endDate);
        }else if(inputState_1 == InputState.NUM){
            stockVO_1 = dataCalculationService.getStockInfoByCode(input_1,startDate,endDate);
        }else{
            showMessage("请输入股票代码/名称");
            return;
        }

        if(stockVO_0 == null || stockVO_1 == null){
            showMessage("无数据");
            return;
        }

        FXMLLoader rootLoader = new FXMLLoader();

        try{

            rootLoader.setLocation(getClass().getResource("/fxml/CompareShares.fxml"));
            Pane root = rootLoader.load();
            rightPane.getChildren().clear();
            rightPane.getChildren().addAll(root);

        } catch (IOException e){
            e.printStackTrace();
        }

        CompareSharesController compareSharesController = rootLoader.getController();
        compareSharesController.init(stockVO_0,stockVO_1,startDate,endDate);

    }

    /*
    迭代二新增
     */
    @FXML
    private void showStrategyInputDialog(){

        try{
            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(getClass().getResource("/fxml/StrategyInput.fxml"));
            Pane root = rootLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.centerOnScreen();
            stage.initOwner(MainController.getStage());
            stage.show();

            StrategyInputController strategyInputController = rootLoader.getController();
            strategyInputController.init(this);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    //设置DatePicker的时间
    public void setDatePicker(){
        date.setDayCellFactory(dayCellFactory);
        date.setValue(MIN);
        start_1.setDayCellFactory(dayCellFactory);
        start_1.setValue(MIN);
        end_1.setDayCellFactory(dayCellFactory);
        end_1.setValue(MAX);
        start_2.setDayCellFactory(dayCellFactory);
        start_2.setValue(MIN);
        end_2.setDayCellFactory(dayCellFactory);
        end_2.setValue(MAX);
    }

    public void showMessage(String str){

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

        dialog.setAlwaysOnTop(true);
        dialog.centerOnScreen();
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.setResizable(false);
        dialog.show();

        return;

    }

    public void showRightPane(Pane root){
        rightPane.getChildren().clear();
        rightPane.getChildren().addAll(root);
    }

}
