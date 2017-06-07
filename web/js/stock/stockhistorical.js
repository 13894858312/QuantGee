/**
 * Created by Administrator on 2017/6/6.
 */
dochart();
function getKlineDate(num) {
    var klineDate = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getStock.action',
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
        url:'getStock.action',
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
        url:'stockMA5.action',
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
        url:'stockMA10.action',
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
        url:'stockMA20.action',
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
        url:'stockVolume.action',
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
    var myChart1 = echarts.init(document.getElementById('daykline'));
    var myChart2 = echarts.init(document.getElementById('weekkline'));
    var myChart3 = echarts.init(document.getElementById("monthkline"));
    var myChart4 = echarts.init(document.getElementById("dayvolume"));
    var myChart5 = echarts.init(document.getElementById("weekvolume"));
    var myChart6 = echarts.init(document.getElementById("monthvolume"));

    var option1 = {
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
            right: '4%',
            bottom: '11%'
        },
        xAxis: {
            show:false,
            type: 'category',
            data: getKlineDate(1)
        },
        yAxis: {
            // show:false,
            // position:'right',
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
            }
            // {
            //     show: true,
            //     type: 'slider',
            //     y: '90%',
            //     start: 50,
            //     end: 100
            // }
        ],
        series: [
            {
                name: '日K',
                type: 'candlestick',
                data: getKlineBar(1)

            },
            {
                name: 'MA5',
                type: 'line',
                data: getMA5(1),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: getMA10(1),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA20',
                type: 'line',
                data: getMA20(1),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            }
            // {
            //     name: '涨',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '跌',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '成交量',
            //     type: 'line',
            //     data: []
            //
            // }
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
            right: '4%',
            bottom: '11%'
        },
        xAxis: {
            show:false,
            type: 'category',
            data: getKlineDate(5)
        },
        yAxis: {
            // show:false,
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
                data: getKlineBar(5)

            },
            {
                name: 'MA5',
                type: 'line',
                data: getMA5(5),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: getMA10(5),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA20',
                type: 'line',
                data: getMA20(5),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            }
            // {
            //     name: '涨',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '跌',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '成交量',
            //     type: 'line',
            //     data: []
            //
            // }
        ]
    };
    var option3 = {
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
            right: '4%',
            bottom: '11%'
        },
        xAxis: {
            show:false,
            type: 'category',
            data: getKlineDate(20)
        },
        yAxis: {
            // show:false,
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
                data: getKlineBar(20)

            },
            {
                name: 'MA5',
                type: 'line',
                data: getMA5(20),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: getMA10(20),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA20',
                type: 'line',
                data: getMA20(20),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            }
            // {
            //     name: '涨',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '跌',
            //     type: 'bar',
            //     data: []
            //
            // },
            // {
            //     name: '成交量',
            //     type: 'line',
            //     data: []
            //
            // }
        ]
    };
    var option4 = {
        backgroundColor: '#FFFFFF',
        xAxis: [
            {
                show:false,
                type: 'category',
                data: getKlineDate(1),
                axisPointer: {
                    type: 'line',
                    show:true,
                    label:{
                        show:false
                    },
                    tooltip:false
                }


            }
        ],
        grid:{
            top:'10%',
            left: '5%',
            right: '5%',
            bottom:'5%'
        },
        yAxis: [
            {
                type: 'value',
                name: '成交量',
                // min: 2100,
                // max: 2300,
                // interval: 40,
                scale: true,
                axisPointer:{
                    type:'line',
                    show:true
                }
                // axisTick:{
                //     show:false
                // }
            }
        ],
        dataZoom: [
            {
                type: 'inside',
                start: 50,
                end: 100
            }
        ],
        series: [
            {
                name: '成交量',
                type: 'bar',
                data: getVolume(1)
            }
        ]
    };
    var option5 = {
        backgroundColor: '#FFFFFF',
        xAxis: [
            {
                show:false,
                type: 'category',
                data: getKlineDate(5),
                axisPointer: {
                    type: 'line',
                    show:true,
                    label:{
                        show:false
                    },
                    tooltip:false
                }
            }
        ],
        grid:{
            top:'10%',
            left: '5%',
            right: '5%',
            bottom:'5%'
        },
        yAxis: [
            {
                type: 'value',
                name: '成交量',
                // min: 2100,
                // max: 2300,
                // interval: 40,
                scale: true,
                axisPointer:{
                    type:'line',
                    show:true
                }
            }
        ],
        series: [
            {
                name: '成交量',
                type: 'bar',
                data: getVolume(5)
            }
        ]
    };
    var option6 = {
        backgroundColor: '#FFFFFF',
        xAxis: [
            {
                show:false,
                type: 'category',
                data: getKlineDate(20),
                axisPointer: {
                    type: 'line',
                    show:true,
                    label:{
                        show:false
                    },
                    tooltip:false
                }
            }
        ],
        grid:{
            top:'10%',
            left: '5%',
            right: '5%',
            bottom:'5%'
        },
        yAxis: [
            {
                type: 'value',
                name: '成交量',
                // min: 2100,
                // max: 2300,
                // interval: 40,
                scale: true,
                axisPointer:{
                    type:'line',
                    show:true
                }
            }
        ],
        series: [
            {
                name: '成交量',
                type: 'bar',
                data: getVolume(20)
            }
        ]
    };
    myChart1.setOption(option1);
    myChart2.setOption(option2);
    myChart3.setOption(option3);
    myChart4.setOption(option4);
    myChart5.setOption(option5);
    myChart6.setOption(option6);
    // myChart2.setOption(option2);
    // echarts.connect([myChart1,myChart2]);
    echarts.connect([myChart1,myChart4]);
    echarts.connect([myChart2,myChart5]);
    echarts.connect([myChart3,myChart6]);
}