/**
 * Created by Administrator on 2017/5/15.
 */
dochart();
function getKlineDate() {
    var klineDate = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'candle-volume.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json.length;i++){
        klineDate.push(json[i]['date']);
    }
    return klineDate;
}
function getKlineBar() {
    var klineBar = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'candle-volume.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json.length;i++){
        var temp = [];
        temp.push(json[i]['open']);
        temp.push(json[i]['close']);
        temp.push(json[i]['low']);
        temp.push(json[i]['high']);
        klineBar.push(temp);
    }
    return klineBar;
}
function getMA5() {
    var klineMA5 = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'MA5.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });

    for(var i=0;i<json.length;i++){
        klineMA5.push(json[i]['value']);
    }
    return klineMA5;
}
function getMA10() {
    var klineMA10 = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'MA10.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });

    for(var i=0;i<json.length;i++){
        klineMA10.push(json[i]['value']);
    }
    return klineMA10;
}
function getMA20(data) {
    var klineMA20 = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'MA20.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });

    for(var i=0;i<json.length;i++){
        klineMA20.push(json[i]['value']);
    }
    return klineMA20;
}
function getRiseStock() {
    var numOfRiseStock = [];
    var json;
    // $.ajax({
    //     cache:false,
    //     async:false,
    //     url:
    // })
}
function dochart() {
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
        data: ['日K', 'MA5', 'MA10', 'MA20','涨','跌','成交量']
    },
    grid: {
    	top:'10%',
        left: '5%',
        right: '5%',
        bottom: '11%'
    },
    xAxis: {
    	show:false,
        type: 'category',
        data: getKlineDate()
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
            start: 50,
            end: 100
        },
        {
            show: true,
            type: 'slider',
            y: '90%',
            start: 50,
            end: 100
        }
    ],
    series: [
        {
            name: '日K',
            type: 'candlestick',
            data: getKlineBar()

        },
        {
            name: 'MA5',
            type: 'line',
            data: getMA5(),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA10',
            type: 'line',
            data: getMA10(),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA20',
            type: 'line',
            data: getMA20(),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
		{
            name: '涨',
            type: 'bar',
            data: []

        },
        {
            name: '跌',
            type: 'bar',
            data: []

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