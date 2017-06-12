/**
 * Created by Administrator on 2017/6/12.
 */
var firstStock;
var secondStock;
var thirdStock;
var stockArray;
$.ajax({
    cache:false,
    async:false,
    url:'getRecommandStock.action',
    dataType:'json',
    type:'GET',
    success:function (data) {
        alert(data);
        stockArray = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
firstStock = stockArray[0];
secondStock = stockArray[1];
thirdStock = stockArray[2];

drawChart(firstStock, "firstrecommand");
drawChart(secondStock, "secondrecommand");
drawChart(thirdStock, "thirdrecommand");
function drawChart(stockCode, idname) {
    var dataInfo;
    $.ajax({
        cache:false,
        async:false,
        url:'getTheRealStockDateInfo.action',
        dataType:'json',
        type:'POST',
        data:{
            stockCode:stockCode
        },
        success:function (data) {
            dataInfo = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    if(idname == "firstrecommand"){
        $("#name1").text(dataInfo['stockName']);
        $("#code1").text(dataInfo['code']);
        $("#yesclose1").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen1").text("今开:" + String(dataInfo['openNum']));
        $("#highest1").text("最高:" + String(dataInfo['high']));
        $("#lowest1").text("最低:" + String(dataInfo['low']));
    }else if(idname == "secondrecommand"){
        $("#name2").text(dataInfo['stockName']);
        $("#code2").text(dataInfo['code']);
        $("#yesclose2").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen2").text("今开:" + String(dataInfo['openNum']));
        $("#highest2").text("最高:" + String(dataInfo['high']));
        $("#lowest2").text("最低:" + String(dataInfo['low']));
    }else{
        $("#name3").text(dataInfo['stockName']);
        $("#code3").text(dataInfo['code']);
        $("#yesclose3").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen3").text("今开:" + String(dataInfo['openNum']));
        $("#highest3").text("最高:" + String(dataInfo['high']));
        $("#lowest3").text("最低:" + String(dataInfo['low']));
    }
    var realInfo;
    $.ajax({
        cache:false,
        async:false,
        url:'getStockReal.action',
        dataType:'json',
        type:'POST',
        data:{
            stockCode:stockCode
        },
        success:function (data) {
            realInfo = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    var realDate = [];
    for(var i=0;i<realInfo['times'].length;i++){
        realDate.push(realInfo['times'][i]);
    }
    var realPrice = [];
    for(var i=0;i<realInfo['nowPrice'].length;i++){
        realPrice.push(realInfo['nowPrice'][i]);
    }
    var chart = echarts.init(document.getElementById(idname));
    var option = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis'
            // axisPointer: {
            //     type: 'cross'
            // }
        },
        legend: {
            data: ['现价']
        },
        grid: {
            top:'10%',
            left: '5%',
            right: '3%',
            bottom: '11%'
        },
        xAxis: {
            show:true,
            type: 'category',
            data: realDate
        },
        yAxis: {
            scale: true,
            splitArea: {
                show: true
            }
        },
        series: [
            {
                name: '现价',
                type: 'line',
                data: realPrice

            }
        ]
    };
    chart.setOption(option);
}


