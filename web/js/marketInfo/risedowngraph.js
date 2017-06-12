/**
 * Created by Administrator on 2017/6/13.
 */
var json;
$.ajax({
    cache: false,
    async: false,
    url: 'getMarketRiseAndDown.action',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
        json = JSON.parse(data);
    },
    error: function (data) {
        alert("error");
    }
});
var seriesdata = [];
for(var i=0;i<json['rateNums'].length;i++){
    var obj = new Object();
    obj.value = json['rateNums'][i];
    if(i ==  0){
        obj.name = "跌停";
    }else if(i == 1){
        obj.name = "-10% ~ -5%";
    }else if(i == 2){
        obj.name = "-5% ~ 0";
    }else if(i == 3){
        obj.name = "0 ~ 5%";
    }else if(i == 4){
        obj.name = "5% ~ 10%";
    }else if(i == 5){
        obj.name = "涨停";
    }
    seriesdata.push(obj);
}
var myChart = echarts.init(document.getElementById('pie'));
var option1 = {
    backgroundColor: '#FFFFFF',
    tooltip: {
        trigger: 'item'
    },
    legend: {
        x : 'center',
        y : 'bottom',
        data: ['跌停', '-10% ~ -5%', '-5% ~ 0', '0 ~ 5%','5% ~ 10%','涨停']
    },
    series : [
        {
            type:'pie',
            radius : [40, 100],
            center : ['60%', '43%'],
            roseType : 'area',
            data:seriesdata
        }
    ]
};
myChart.setOption(option1);