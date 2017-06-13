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
    seriesdata.push(json['rateNums'][i]);
}
var myChart = echarts.init(document.getElementById('pie'));
var option1 = {
    backgroundColor: '#FFFFFF',
    tooltip: {
        trigger: 'item'
    },
    grid:{
        left:'0%',
        right:'0%',
        top:'0%',
        bottom:'0%'
    },
    xAxis : [
        {
            show:false,
            type : 'category',
            data : ['跌停', '-10%~-6%', '-6%~-4%', '-4%~-2%','-2%~0','0~2%','2%~4%','4%~6%','6%~10%','涨停']
        }
    ],
    yAxis : [
        {
            show:false,
            type : 'value'
        }
    ],
    series : [
        {
            name:'涨跌分布',
            type:'bar',
            itemStyle: {
                normal: {
                    color: function(param) {
                        // build a color map as your need.
                        var colorList = [
                            '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                            '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                            '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                        ];
                        return colorList[param.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: '{b}\n{c}'
                    }
                }
            },
            label: {
                show: true,
                position: 'top',
                formatter: '{b}\n{c}'
            },
            data:seriesdata
        }
    ]
};
myChart.setOption(option1);