/**
 * Created by Administrator on 2017/6/9.
 */
dochart(1);
var klineDate = [];
var klineBar = [];
var klineMA5 = [];
var klineMA10 = [];
var klineMA20 = [];
var volume = [];
var json;
$.ajax({
    cache: false,
    async: false,
    url: 'totheStock.action',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
        json = JSON.parse(data);
    },
    error: function (data) {
        alert("error");
    }
});
$("#tsname").text(json['name']);
$("#tscode").text("(" + json['code'] + ")");
function getDayData() {
    $.ajax({
        cache: false,
        async: false,
        url: 'getStockDayKlineInfo.action',
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
function getWeekData() {
    $.ajax({
        cache: false,
        async: false,
        url: 'getStockWeekKlineInfo.action',
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
function getMonthData() {
    $.ajax({
        cache: false,
        async: false,
        url: 'getStockMonthKlineInfo.action',
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


function getKline(num) {
    klineDate = [];
    klineBar = [];
    klineMA5 = [];
    klineMA10 = [];
    klineMA20 = [];
    volume = [];
    if(num == 1){
        getDayData();
    }else if(num == 2){
        getWeekData();
    }else {
        getMonthData()
    }
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

function dochart(num) {
    getKline(num);
    var myChart1 = echarts.init(document.getElementById('kline'));
    var myChart2 = echarts.init(document.getElementById('volume'));
    var option1 = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['k线', 'MA5', 'MA10', 'MA20','成交量']
        },
        grid: {
            top:'10%',
            left: '5%',
            right: '3%',
            bottom: '11%'
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
            },
            {
                show: true,
                type: 'slider',
                y: '90%',
                start: 75,
                end: 100
            }
        ],
        series: [
            {
                name: 'k线',
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
    var option2 = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        // legend: {
        //     data: ['日K', 'MA5', 'MA10', 'MA20','涨','跌','成交量']
        // },
        grid: {
            top:'10%',
            left: '5%',
            right: '0%',
            bottom: '11%'
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
            },
            {
                show: false,
                type: 'slider',
                y: '90%',
                start: 75,
                end: 100
            }
        ],
        series: [
            {
                name: '成交量',
                type: 'bar',
                data: volume
            }
        ]
    };
    myChart1.setOption(option1);
    myChart2.setOption(option2);
    echarts.connect([myChart1,myChart2]);
}
function clickdkbutton() {
    var dkbutton = document.getElementById("dkbutton");
    var wkbutton = document.getElementById("wkbutton");
    var mkbutton = document.getElementById("mkbutton");
    dkbutton.style.backgroundColor = "#003366";
    dkbutton.style.color = "#FFFFFF";
    wkbutton.style.backgroundColor = "#FFFFFF";
    wkbutton.style.color = "#000000";
    mkbutton.style.backgroundColor = "#FFFFFF";
    mkbutton.style.color = "#000000";
    dochart(1);
}
function clickwkbutton() {
    var dkbutton = document.getElementById("dkbutton");
    var wkbutton = document.getElementById("wkbutton");
    var mkbutton = document.getElementById("mkbutton");
    dkbutton.style.backgroundColor = "#FFFFFF";
    dkbutton.style.color = "#000000";
    wkbutton.style.backgroundColor = "#003366";
    wkbutton.style.color = "#FFFFFF";
    mkbutton.style.backgroundColor = "#FFFFFF";
    mkbutton.style.color = "#000000";
    dochart(2);
}
function clickmkbutton() {
    var dkbutton = document.getElementById("dkbutton");
    var wkbutton = document.getElementById("wkbutton");
    var mkbutton = document.getElementById("mkbutton");
    dkbutton.style.backgroundColor = "#FFFFFF";
    dkbutton.style.color = "#000000";
    wkbutton.style.backgroundColor = "#FFFFFF";
    wkbutton.style.color = "#000000";
    mkbutton.style.backgroundColor = "#003366";
    mkbutton.style.color = "#FFFFFF";
    dochart(3);
}