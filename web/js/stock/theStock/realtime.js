/**
 * Created by Administrator on 2017/6/11.
 */

drawRealImg();
setInterval(drawRealImg,120000);
function drawRealImg() {
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getRealTimeInfo.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    var date = [];
    var price = [];
    var open = [];
    for(var i=0;i<json['times'].length;i++){
        date.push(json['times'][i]);
        open.push(json['nowPrice'][0]);
    }
    for(var i=0;i<json['nowPrice'].length;i++){
        price.push(json['nowPrice'][i]);
    }
    var myChart = echarts.init(document.getElementById("tsrealtime"));
    var option = {
        title:{
            text:'分时图',
            left:'40%',
            top:'0%',
            textStyle:{
                fontWeight:100,
                fontSize:12,
                fontFamile:'Arial, Verdana, sans-serif'
            }
        },
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            top:'10%',
            left: '0%',
            right: '0%',
            bottom: '5%'
        },
        xAxis:  {
            show:false,
            type: 'category',
            data: date
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
                data:price,
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
    myChart.setOption(option);
    setRealContent();
}
function setRealContent() {
    var content;
    $.ajax({
        cache: false,
        async: false,
        url: 'getRealCurrentInfo.action',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            content = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
    $("#tsr1").text(content['settlement']);
    if (content['open'] != null) {
        $("#tsr2").text(content['open']);
    }else {
        $("#tsr2").text("----");
    }
    $("#tsr3").text(content['low']);
    $("#tsr4").text(content['high']);
    $("#tsr5").text(String(content['turnover'])+"%");
    $("#tsr6").text(content['per']);
    $("#tsr7").text(content['pb']);
    $("#tsr8").text(String(content['volume'])+"万");
    $("#tsr9").text(String(content['amount'])+"万");
    $("#tsr10").text(String(content['mktcap'])+"亿");
    // if(content['trade']>0){
    //     var temp = document.getElementById("#tsrrdata");
    //     temp.style.color = "rgb(207,25,74)";
    // }else{
    //     var temp = document.getElementById("#tsrrdata");
    //     temp.style.color = "rgb(62, 196, 131)";
    // }
    $("#tsrrdata").text(String(content['changePercent'])+"%");
    $("#tsnprice").text(content['trade']);
}