/**
 * Created by Administrator on 2017/5/15.
 */
dochart(1);
function getKlineDate(num) {
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
    for(var i=0;i<json.length;i+=num){
        klineDate.push(json[i]['date']);
    }
    return klineDate;
}
function getKlineBar(num) {
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
    for(var i=0;i<json.length;i+=num){
        var temp = [];
        temp.push(json[i]['open']);
        temp.push(json[i]['close']);
        temp.push(json[i]['low']);
        temp.push(json[i]['high']);
        klineBar.push(temp);
    }
    return klineBar;
}
function getMA5(num) {
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

    for(var i=0;i<json.length;i+=num){
        klineMA5.push(json[i]['value']);
    }
    return klineMA5;
}
function getMA10(num) {
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

    for(var i=0;i<json.length;i+=num){
        klineMA10.push(json[i]['value']);
    }
    return klineMA10;
}
function getMA20(num) {
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

    for(var i=0;i<json.length;i+num){
        klineMA20.push(json[i]['value']);
    }
    return klineMA20;
}
function getVolume(num) {
    var volume = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getVolume.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json.length;i+=num){
        volume.push(json[i]['value']);
    }
    return volume;
}
function dochart(num) {
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
        data: getKlineDate(num)
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
            data: getKlineBar(num)

        },
        {
            name: 'MA5',
            type: 'line',
            data: getMA5(num),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA10',
            type: 'line',
            data: getMA10(num),
            smooth: true,
            lineStyle: {
                normal: {opacity: 0.5}
            }
        },
        {
            name: 'MA20',
            type: 'line',
            data: getMA20(num),
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
            data: getKlineDate(num)
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
            // {
            //     name: '跌',
            //     type: 'bar',
            //     data: []
            //
            // },
            {
                name: '成交量',
                type: 'bar',
                data: getVolume(num)
            }
        ]
    };
myChart1.setOption(option1);
myChart2.setOption(option2);
echarts.connect([myChart1,myChart2]);
}