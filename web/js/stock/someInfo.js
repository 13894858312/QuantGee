/**
 * Created by Administrator on 2017/6/5.
 */
var klinejson;
var ma5json;
var ma10json;
var ma20json;
function showdatasr11() {
    $.ajax({
        cache:false,
        async:false,
        url:'getStock.action',
        type:'POST',
        data:{
            stockCode: "000001"
        },
        dataType:'json',
        success:function (data) {
            klinejson = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $.ajax({
        cache:false,
        async:false,
        url:'stockMA5.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            ma5json = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $.ajax({
        cache:false,
        async:false,
        url:'stockMA10.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            ma10json = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $.ajax({
        cache:false,
        async:false,
        url:'stockMA20.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            ma20json = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });

    var myChart1 = echarts.init(document.getElementById('si2'));
    var option1 = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['日K', 'MA5', 'MA10', 'MA20']
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
        // dataZoom: [
        //     {
        //         type: 'inside',
        //         start: 50,
        //         end: 100
        //     },
        //     {
        //         show: true,
        //         type: 'slider',
        //         y: '90%',
        //         start: 50,
        //         end: 100
        //     }
        // ],
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
            }
        ]
    };
    myChart1.setOption(option1);
}
function getKlineDate() {
    var klineDate = [];
    for(var i=0;i<klinejson.length;i++){
        klineDate.push(klinejson[i]['date']);
    }
    return klineDate;
}
function getKlineBar() {
    var klineBar = [];
    for(var i=0;i<klinejson.length;i++){
        var temp = [];
        temp.push(klinejson[i]['open']);
        temp.push(klinejson[i]['close']);
        temp.push(klinejson[i]['low']);
        temp.push(klinejson[i]['high']);
        klineBar.push(temp);
    }
    return klineBar;
}
function getMA5() {
    var klineMA5 = [];
    for(var i=0;i<ma5json.length;i++){
        klineMA5.push(ma5json[i]['value']);
    }
    return klineMA5;
}
function getMA10() {
    var klineMA10 = [];
    for(var i=0;i<ma10json.length;i++){
        klineMA10.push(ma10json[i]['value']);
    }
    return klineMA10;
}
function getMA20(data) {
    var klineMA20 = [];
    for(var i=0;i<ma20json.length;i++){
        klineMA20.push(ma20json[i]['value']);
    }
    return klineMA20;
}