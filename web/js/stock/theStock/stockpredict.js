/**
 * Created by Administrator on 2017/6/11.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    type:'GET',
    url:'getPredictInfo.action',
    dataType:'json',
    success:function (data) {
      json = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});

var date = [];
var actual = [];
var predict = [];
for(var i=0;i<json['actualValues'].length;i++){
    date.push(json['actualValues'][i]['date'])
}
for(var i=0;i<json['actualValues'].length;i++){
    date.push(json['actualValues'][i]['value'])
}
for(var i=0;i<json['predictedValues'].length;i++){
    date.push(json['predictedValues'][i]['value'])
}
var myChart = echarts.init(document.getElementById("analysisgraph"));
var option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data:['实际走势','预测走势']
    },
    grid: {
        top:'13%',
        left: '5%',
        right: '0%',
        bottom: '11%'
    },
    xAxis:  {
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
            name:'实际走势',
            type:'line',
            data:actual
        },
        {
            name:'预测走势',
            type:'line',
            data:predict
        }
    ]
};
myChart.setOption(option);
// var resultdata1 = document.getElementById("resultdata1");
// var resultdata2 = document.getElementById("resultdata2");
// var resultdata3 = document.getElementById("resultdata3");
// if(json[])
$("#resultdata1").text(json['predictTomorrowPrice']);
$("#resultdata2").text(json['predictTomorrowIncrease']);
$("#resultdata3").text(json['historyDeviation']);