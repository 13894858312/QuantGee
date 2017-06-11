/**
 * Created by Administrator on 2017/6/10.
 */
/**
 * Created by Administrator on 2017/6/10.
 */
dochart();
var klineDate = [];
var klineBar = [];
var klineMA5 = [];
var klineMA10 = [];
var klineMA20 = [];
var volume = [];
var json;

var date = [];
//macd
var diffdata = [];
var deadata = [];
var macddata = [];

//kdj
var kdata = [];
var ddata = [];
var jdata = [];

//rsi
var rsi6data = [];
var rsi12data = [];
var rsi24data = [];

//boll
var middata = [];
var updata = [];
var lowdata = [];
function getDayData() {
    $.ajax({
        cache: false,
        async: false,
        url: 'getdkInfo.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            json = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
}
function getKline() {
    klineDate = [];
    klineBar = [];
    klineMA5 = [];
    klineMA10 = [];
    klineMA20 = [];
    volume = [];
    getDayData();
    for (var i = 0; i < json['kLine'].length; i++) {
        klineDate.push(json['kLine'][i]['date']);
    }
    for (var i = 0; i < json['kLine'].length; i++) {
        var temp = [];
        temp.push(json['kLine'][i]['open']);
        temp.push(json['kLine'][i]['close']);
        temp.push(json['kLine'][i]['low']);
        temp.push(json['kLine'][i]['high']);
        klineBar.push(temp);
    }
    for (var i = 0; i < json['ma5'].length; i++) {
        klineMA5.push(json['ma5'][i]['value']);
    }
    for (var i = 0; i < json['ma10'].length; i++) {
        klineMA10.push(json['ma10'][i]['value']);
    }
    for (var i = 0; i < json['ma20'].length; i++) {
        klineMA20.push(json['ma20'][i]['value']);
    }
    for (var i = 0; i < json['volume'].length; i++) {
        volume.push(json['volume'][i]['value']);
    }
}
function dochart() {
    getKline();
    var myChart1 = echarts.init(document.getElementById('kline'));
    var option1 = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['candle', 'MA5', 'MA10', 'MA20']
        },
        grid: {
            top:'10%',
            left: '8%',
            right: '0%',
            bottom: '2%'
        },
        xAxis: {
            show:false,
            type: 'category',
            data: klineDate
        },
        yAxis: {
            scale: true,
            splitArea: {
                show: true
            }
        },
        dataZoom: [
            {
                type: 'inside',
                start: 75,
                end: 100
            }
        ],
        series: [
            {
                name: 'candle',
                type: 'candlestick',
                data: klineBar

            },
            {
                name: 'MA5',
                type: 'line',
                data: klineMA5,
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: klineMA10,
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA20',
                type: 'line',
                data: klineMA20,
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: '成交量',
                type: 'line',
                data: []

            }
        ]
    };
    myChart1.setOption(option1);
}


function setData() {
    var json1;
    date = [];
//macd
    diffdata = [];
    deadata = [];
    macddata = [];

//kdj
    kdata = [];
    ddata = [];
    jdata = [];

//rsi
    rsi6data = [];
    rsi12data = [];
    rsi24data = [];

//boll
    middata = [];
    updata = [];
    lowdata = [];
    $.ajax({
        cache:false,
        async:false,
        url:'getTradeIndex.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json1 = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json1['diff'].length;i++){
        date.push(json1['diff'][i]['date']);
    }
    for(var i=0;i<json1['diff'].length;i++){
        diffdata.push(json1['diff'][i]['value']);
    }
    for(var i=0;i<json1['dea'].length;i++){
        deadata.push(json1['dea'][i]['value']);
    }
    for(var i=0;i<json1['macd'].length;i++){
        macddata.push(json1['macd'][i]['value']);
    }
    for(var i=0;i<json1['k'].length;i++){
        kdata.push(json1['k'][i]['value']);
    }
    for(var i=0;i<json1['d'].length;i++){
        ddata.push(json1['d'][i]['value']);
    }
    for(var i=0;i<json1['j'].length;i++){
        jdata.push(json1['j'][i]['value']);
    }
    for(var i=0;i<json1['rsi6'].length;i++){
        rsi6data.push(json1['rsi6'][i]['value']);
    }
    for(var i=0;i<json1['rsi12'].length;i++){
        rsi12data.push(json1['rsi12'][i]['value']);
    }
    for(var i=0;i<json1['rsi24'].length;i++){
        rsi24data.push(json1['rsi24'][i]['value']);
    }
    for(var i=0;i<json1['mid'].length;i++){
        middata.push(json1['mid'][i]['value']);
    }
    for(var i=0;i<json1['up'].length;i++){
        updata.push(json1['up'][i]['value']);
    }
    for(var i=0;i<json1['low'].length;i++){
        lowdata.push(json1['low'][i]['value']);
    }
}
drawMACD();
function drawMACD() {
    setData();
    var myChart = echarts.init(document.getElementById("index"));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:['diff','dea','macd']
        },
        grid: {
            top:'15%',
            left: '6%',
            right: '3%',
            bottom: '11%'
        },
        xAxis:  {
            boundaryGap: true,
            type: 'category',
            data: date
        },
        yAxis: {
            type: 'value',
            splitArea: {
                show: true
            },
            scale:true
        },
        series: [
            {
                name:'diff',
                type:'line',
                data:diffdata
            },
            {
                name:'dea',
                type:'line',
                data:deadata
            },
            {
                name:'macd',
                type:'bar',
                data:macddata
            }
        ]
    };
    myChart.setOption(option);
}
function drwaKDJ() {
    setData();
    var myChart = echarts.init(document.getElementById("index"));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:['k','d','j']
        },
        grid: {
            top:'15%',
            left: '8%',
            right: '0%',
            bottom: '11%'
        },
        xAxis:  {
            boundaryGap: true,
            type: 'category',
            data: date
        },
        yAxis: {
            type: 'value',
            splitArea: {
                show: true
            },
            scale:true
        },
        series: [
            {
                name:'k',
                type:'line',
                data:kdata
            },
            {
                name:'d',
                type:'line',
                data:ddata
            },
            {
                name:'j',
                type:'line',
                data:jdata
            }
        ]
    };
    myChart.setOption(option);
}
function drawRSI() {
    setData();
    var myChart = echarts.init(document.getElementById("index"));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:['rsi6','rsi12','rsi24']
        },
        grid: {
            top:'15%',
            left: '8%',
            right: '3%',
            bottom: '11%'
        },
        xAxis:  {
            boundaryGap: true,
            type: 'category',
            data: date
        },
        yAxis: {
            type: 'value',
            splitArea: {
                show: true
            },
            scale:true
        },
        series: [
            {
                name:'rsi6',
                type:'line',
                data:rsi6data
            },
            {
                name:'rsi12',
                type:'line',
                data:rsi12data
            },
            {
                name:'rsi24',
                type:'line',
                data:rsi24data
            }
        ]
    };
    myChart.setOption(option);
}
function getKlineBar() {
    var kline;
    var klinebar = [];
    $.ajax({
        cache:false,
        async:false,
        url:'getBOLLKlineInfo.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            kline = JSON.parse(data);
        }
    });
    for(var i=0;i<kline['kLine'].length;i++){
        var temp = [];
        temp.push(kline['kLine'][i]['open']);
        temp.push(kline['kLine'][i]['close']);
        temp.push(kline['kLine'][i]['low']);
        temp.push(kline['kLine'][i]['high']);
        klinebar.push(temp);
    }
    return klinebar;
}
function drawBOLL() {
    setData();
    var myChart = echarts.init(document.getElementById("index"));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:['日k','mid','up','low']
        },
        grid: {
            top:'15%',
            left: '8%',
            right: '0%',
            bottom: '11%'
        },
        xAxis:  {
            type: 'category',
            data: date
        },
        yAxis: {
            type: 'value',
            boundaryGap: true,
            splitArea: {
                show: true
            },
            scale:true
        },
        series: [
            {
                name:'日k',
                type:'candlestick',
                data:getKlineBar()
            },
            {
                name:'mid',
                type:'line',
                data:middata
            },
            {
                name:'up',
                type:'line',
                data:updata
            },
            {
                name:'low',
                type:'line',
                data:lowdata
            }
        ]
    };
    myChart.setOption(option);
}
function clickMACDbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#003366";
    MACDbutton.style.color = "#FFFFFF";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
    drawMACD();
}
function clickKDJbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#003366";
    KDJbutton.style.color = "#FFFFFF";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
    drwaKDJ();
}
function clickRSIbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#003366";
    RSIbutton.style.color = "#FFFFFF";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
    drawRSI();
}
function clickBOLLbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#003366";
    BOLLbutton.style.color = "#FFFFFF";
    drawBOLL();
}
function getCheck() {
    var temp;
    var stockCode = document.getElementById("inputstcode");
    $.ajax({
        cache:false,
        async:false,
        type:'POST',
        url:'getSTCodeInfo.action',
        data:{
            stockCode: stockCode.value
        },
        dataType:'json',
        success:function (data) {
            temp = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    dochart();
    $.ajax({
        cache:false,
        async:false,
        type:'GET',
        url:'getPredictResult.action',
        dataType:'json',
        success:function (data) {
            temp = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $("#resultdata1").text(temp['predictTomorrowPrice']);
    $("#resultdata2").text(temp['predictTomorrowIncrease']);
    $("#resultdata3").text(temp['historyDeviation']);
    drawMACD();
}