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
function getDayData() {
    $.ajax({
        cache: false,
        async: false,
        url: 'dayKline.action',
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
            right: '1%',
            bottom: '5%'
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
}
