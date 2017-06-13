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
    var open = [];
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
        open.push(json['nowPrice'][0]);
    }
    for(var i=0;i<json['nowPrice'].length;i++){
        realPrice.push(json['nowPrice'][i]);
    }
    var shChart = echarts.init(document.getElementById('shangzgraph'));
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            top:'5%',
            left: '0%',
            right: '0%',
            bottom: '5%'
        },
        xAxis:  {
            show:false,
            type: 'category',
            data: realDate
        },
        yAxis: {
            show:false,
            type: 'value',
            boundaryGap: true,
            // splitArea: {
            //     show: false
            // },
            // splitLine:{
            //     show:true
            // },
            scale:true
        },
        series: [
            {
                name:'现价',
                type:'line',
                symbol:'none',
                data:realPrice,
                itemStyle : {
                    normal : {
                        lineStyle:{
                            color:'#579bf0'
                        }
                    }
                }
            },
            {
                name:'开盘价',
                type:'line',
                symbol:'none',
                data:open,
                itemStyle : {
                    normal : {
                        lineStyle: {
                            type: 'dashed',
                            width: '1',
                            color: '#bd3f3f'
                        }
                    }
                }
            }
        ]
    };
    shChart.setOption(option);
}
