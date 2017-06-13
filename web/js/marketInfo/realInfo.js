/**
 * Created by Administrator on 2017/6/3.
 */
doshchart();
setInterval(doshchart, 120000);
function doshchart() {
    var realdata;
    $.ajax({
        cache:false,
        async:false,
        url:'getRealSHData.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            realdata = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    $("#yesclose").text("昨收:" + String(realdata['preclose']));
    $("#todopen").text("今开:" + String(realdata['openNum']));
    $("#highest").text("最高:" + String(realdata['high']));
    $("#lowest").text("最低:" + String(realdata['low']));
    var realDate = [];
    var realPrice = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getRealSH.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json['times'].length;i++){
        realDate.push(json['times'][i]);
    }
    for(var i=0;i<json['nowPrice'].length;i++){
        realPrice.push(json['nowPrice'][i]);
    }
    var shChart = echarts.init(document.getElementById('shangzgraph'));
    var option = {
        backgroundColor: '#FFFFFF',
        tooltip: {
            trigger: 'axis'
            // axisPointer: {
            //     type: 'cross'
            // }
        },
        legend: {
            data: ['现价']
        },
        grid: {
            top:'10%',
            left: '5%',
            right: '3%',
            bottom: '11%'
        },
        xAxis: {
            show:true,
            type: 'category',
            data: realDate
        },
        yAxis: {
            scale: true,
            splitArea: {
                show: true
            }
        },
        series: [
            {
                name: '现价',
                type: 'line',
                data: realPrice

            }
        ]
    };
    shChart.setOption(option);
}
