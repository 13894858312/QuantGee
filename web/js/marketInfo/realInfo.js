/**
 * Created by Administrator on 2017/6/3.
 */
doshchart();
function doshchart() {
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
            data: getSHRealDate()
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
                type: 'candlestick',
                data: getSHRealPrice()

            }
        ]
    };
    shChart.setOption(option);
}
function getSHRealDate() {
    var realDate = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getRealSHDate.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            alert(data);
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    for(var i=0;i<json.length;i++){
        realDate.push(json[i]);
    }
    return realDate;
}
function getSHRealPrice() {
    var realPrice = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getRealSHPrice.action',
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
        realPrice.push(json[i]);
    }
    return realPrice;
}
