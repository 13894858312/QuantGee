/**
 * Created by Administrator on 2017/6/9.
 */
$.ajax({
    cache:false,
    async:false,
    url:'getStockCurrentVO.action',
    type:'GET',
    dataType:'json',
    success:function (data) {
         var content = JSON.parse(data);
        $("#hsname").text(content['stockName']);
        $("#hscode").text(content['code']);
        if(content['per']>=0){
            var mer = document.getElementById("hsiearn");
            mer.style.color = "rgb(207,25,74)";
        }else{
            var mer = document.getElementById("hsiearn");
            mer.style.color = "rgb(62, 196, 131)";
        }
        $("#hsiearn").text(content['per']);
        if(content['pb']>=0){
            var mb = document.getElementById("hsiclean");
            mb.style.color = "rgb(207,25,74)";
        }else{
            var mb = document.getElementById("hsiclean");
            mb.style.color = "rgb(62, 196, 131)";
        }
        $("#hsiclean").text(json['pb']);
    },
    error:function (data) {
        alert("error")
    }
});

dochart();
function showrow(obj) {
    var rowborder = document.getElementsByClassName("row");
    for(var i=0;i<rowborder.length;i++){
        rowborder[i].style.borderRight = "2px solid #FFFFFF";
    }
    var row = document.getElementById(obj.id);
    row.style.borderRight = "2px solid #C0C0C0";
}
function getId(obj) {
    var a = document.getElementById(obj.id);
    return a.textContent;
}
function changeChart(aid) {
    // var obj = document.getElementById('r1c1a');
    var stockName = getId(aid);
    $.ajax({
        cache:false,
        async:false,
        type:'POST',
        url:'getWebStockName.action',
        dataType:'json',
        data:{
            stockName:stockName
        },
        success:function (data) {
        },
        error:function (data) {
            alert("error")
        }
    });
    $.ajax({
        cache:false,
        async:false,
        url:'getStockCurrentVO.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            setInfo(data);
        },
        error:function (data) {
            alert("error")
        }
    });

    dochart();
}

function setInfo(data) {
    var content = JSON.parse(data);
    $("#hsname").text(content['stockName']);
    $("#hscode").text(content['code']);
    if(content['per']>=0){
        var mer = document.getElementById("hsiearn");
        mer.style.color = "rgb(207,25,74)";
    }else{
        var mer = document.getElementById("hsiearn");
        mer.style.color = "rgb(62, 196, 131)";
    }
    $("#hsiearn").text(content['per']);
    if(content['pb']>=0){
        var mb = document.getElementById("hsiclean");
        mb.style.color = "rgb(207,25,74)";
    }else{
        var mb = document.getElementById("hsiclean");
        mb.style.color = "rgb(62, 196, 131)";
    }
    $("#hsiclean").text(json['pb']);
}

var klineDate = [];
var klineBar = [];
var klineMA5 = [];
var klineMA10 = [];
var klineMA20 = [];
var volume = [];
var json;
function getDayKline() {
    klineDate = [];
    klineBar = [];
    klineMA5 = [];
    klineMA10 = [];
    klineMA20 = [];
    volume = [];
    $.ajax({
        cache: false,
        async: false,
        url: 'getStockKline.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            json = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
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
    getDayKline();
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
            data: ['日K', 'MA5', 'MA10', 'MA20','成交量']
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
                name: '日K',
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
