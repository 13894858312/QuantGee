/**
 * Created by Administrator on 2017/5/17.
 */
var myChart = echarts.init(document.getElementById('graph-SSE'));
option = {
	backgroundColor:'#FFFFFF',
    tooltip: {
        trigger: 'item'
    },
    legend: {
        data:['最高气温']
    },
    grid:{
    	left:'2%',
    	right:'2%'
    },
    xAxis:  {
    	show: false,
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日','1','2','3']
    },
    yAxis: {
    	show:false,
        type: 'value',
        axisLabel: {
            formatter: '{value} °C'
        }
    },
    series: [
        {
            name:'最高气温',
            type:'line',
            data:[11, 11, 15, 13, 12, 13, 10],
//          markPoint: {
//              data: [
//                  {type: 'max', name: '最大值'},
//                  {type: 'min', name: '最小值'}
//              ]
//          },
            markLine: {
            	itemStyle:{
            		normal:{
            			label:{
            				show:'start'
            			}
            		}
            	},
            	symbol: 'none',
                data: [
                     [{coord:['周一',13]},{coord:['3',13]}]
                ]
            }
       },
//      {
//          name:'最低气温',
//          type:'line',
//          data:[1, -2, 2, 5, 3, 2, 0],
//          markPoint: {
//              data: [
//                  {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
//              ]
//          },
//          markLine: {
//              data: [
//                  {type: 'average', name: '平均值'},
//                  [{
//                      symbol: 'none',
//                      x: '90%',
//                      yAxis: 'max'
//                  }, {
//                      symbol: 'circle',
//                      label: {
//                          normal: {
//                              position: 'start',
//                              formatter: '最大值'
//                          }
//                      },
//                      type: 'max',
//                      name: '最高点'
//                  }]
//              ]
//          }
//      }
    ]
};

myChart.setOption(option);