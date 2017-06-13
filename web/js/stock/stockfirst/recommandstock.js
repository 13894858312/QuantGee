/**
 * Created by Administrator on 2017/6/12.
 */
var firstStock;
var secondStock;
var thirdStock;
var stockArray;
$.ajax({
    cache:false,
    async:false,
    url:'getRecommandStock.action',
    dataType:'json',
    type:'GET',
    success:function (data) {
        stockArray = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
firstStock = stockArray[0];
secondStock = stockArray[1];
thirdStock = stockArray[2];

drawChart(firstStock, "firstrecommand");
drawChart(secondStock, "secondrecommand");
drawChart(thirdStock, "thirdrecommand");
function drawChart(stockCode, idname) {
    var dataInfo;
    $.ajax({
        cache:false,
        async:false,
        url:'getTheRealStockDateInfo.action',
        dataType:'json',
        type:'POST',
        data:{
            stockCode:stockCode
        },
        success:function (data) {
            dataInfo = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    if(idname == "firstrecommand"){
        $("#name1").text(dataInfo['stockName']);
        $("#code1").text(dataInfo['code']);
        $("#yesclose1").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen1").text("今开:" + String(dataInfo['openNum']));
        $("#highest1").text("最高:" + String(dataInfo['high']));
        $("#lowest1").text("最低:" + String(dataInfo['low']));
    }else if(idname == "secondrecommand"){
        $("#name2").text(dataInfo['stockName']);
        $("#code2").text(dataInfo['code']);
        $("#yesclose2").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen2").text("今开:" + String(dataInfo['openNum']));
        $("#highest2").text("最高:" + String(dataInfo['high']));
        $("#lowest2").text("最低:" + String(dataInfo['low']));
    }else{
        $("#name3").text(dataInfo['stockName']);
        $("#code3").text(dataInfo['code']);
        $("#yesclose3").text("昨收:" + String(dataInfo['preclose']));
        $("#todopen3").text("今开:" + String(dataInfo['openNum']));
        $("#highest3").text("最高:" + String(dataInfo['high']));
        $("#lowest3").text("最低:" + String(dataInfo['low']));
    }
    var realInfo;
    $.ajax({
        cache:false,
        async:false,
        url:'getStockReal.action',
        dataType:'json',
        type:'POST',
        data:{
            stockCode:stockCode
        },
        success:function (data) {
            realInfo = JSON.parse(data);
        },
        error:function (data) {
            alert("error");
        }
    });
    var realDate = [];
    var realPrice = [];
    var open = [];
    for(var i=0;i<realInfo['times'].length;i++){
        realDate.push(realInfo['times'][i]);
        open.push(realInfo['nowPrice'][0]);
    }
    for(var i=0;i<realInfo['nowPrice'].length;i++){
        realPrice.push(realInfo['nowPrice'][i]);
    }
    var chart = echarts.init(document.getElementById(idname));
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
    chart.setOption(option);
}


