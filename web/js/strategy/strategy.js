var accountID;
var collectedStock;

//回测参数
var stockPoolType = 0;
var stockCodes = [];
var strategyType = 0;
var tag = 0;
//画图vo
var strategyBackTestingResult;
var abnormalReturnResult;

$(document).ready(function() {
	//判断当前登陆用户
	$.ajax({
		type: 'get',
		url: 'haveLogin.action',
		async: false,
		dataType: 'json',
		success: function(data) {
			accountID = JSON.parse(data)["accountID"];
		},
		error: function(data) {
			alert("error");
		}
	});

	if(accountID != "") {
		//获取收藏的股票
		$.ajax({
			type: 'get',
			url: 'getCollectStock.action',
			async: false,
			data: {
				accountID: accountID
			},
			dataType: 'json',
			success: function(data) {
				collectedStock = JSON.parse(data);
			},
			error: function(data) {
				alert("error");
			}
		});
	}else{
		$("#addMyStock").attr("disabled",true);
		$("#addMyAllStock").attr("disabled",true);
	}
})

function selectTag(showContent, selfObj) {
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var tagnum = tag.length;
	for(i = 0; i < tagnum; i++) {
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i = 0; j = document.getElementById("tagContent" + i); i++) {
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";

}

//$.getJSON("strategy.action", function(data) {
//	$.each(data.items, function(i, item) {
//		$("<img/>").attr("src", item.media.m).appendTo("#images");
//		if(i == 3) return false;
//	});
//})

function selectStrategyTag(showContent, selfObj) {
	//显示按钮
    var firstbutton = document.getElementById("firstbutton");
    var secondbutton = document.getElementById("secondbutton");
    var thirdbutton = document.getElementById("thirdbutton");
    var fourthbutton = document.getElementById("fourthbutton");
    if(showContent == "tagContent_str0" || showContent == "tagContent_str1") {
        firstbutton.style.backgroundColor = "#003366";
        firstbutton.style.color = "#FFFFFF";
        secondbutton.style.backgroundColor = "#FFFFFF";
        secondbutton.style.color = "#000000";
        thirdbutton.style.backgroundColor = "#FFFFFF";
        thirdbutton.style.color = "#000000";
        fourthbutton.style.backgroundColor = "#FFFFFF";
        fourthbutton.style.color = "#000000";
    }else{
        firstbutton.style.backgroundColor = "#003366";
        firstbutton.style.color = "#FFFFFF";
        secondbutton.style.backgroundColor = "#FFFFFF";
        secondbutton.style.color = "#000000";
        thirdbutton.style.backgroundColor = "#FFFFFF";
        thirdbutton.style.color = "#FFFFFF";
        fourthbutton.style.backgroundColor = "#FFFFFF";
        fourthbutton.style.color = "#FFFFFF";
    }
	// 操作标签
	var tag = document.getElementById("tip_tags").getElementsByTagName("li");
	var tagnum = tag.length;
	for(i = 0; i < tagnum; i++) {
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag_str";
	// 操作内容
	for(i = 0; j = document.getElementById("tagContent_str" + i); i++) {
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
	strategyType = parseInt(showContent.charAt(showContent.length - 1));
}

function selectPoolTag(showContent, selfObj) {
	var tag = document.getElementById("pool_tags").getElementsByTagName("li");
	var tagnum = tag.length;
	for(i = 0; i < tagnum; i++) {
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag_pool";
	for(i = 0; j = document.getElementById("pool_Content" + i); i++) {
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";
	if(showContent == "pool_Content1") {
		stockPoolType = 1;
		if(accountID != "") {
			var optionString = '';
			for(var i = 0; i < collectedStock.length; i++) {
				//				optionString += "<option value='000005'>" + collectedStock[i]['code'] + "</option>";
				optionString += "<option value='" + collectedStock[i]['code'] + "'>" + collectedStock[i]['code'] + "</option>";
			}

			$("#usertype").empty();
			$("#usertype").append(optionString);
			$("#usertype").append("<option value='000001'>000001</option>");
			$('#usertype').selectpicker('refresh');
		}
		document.getElementsByClassName("form-group")[0].style.display = "block";
		document.getElementById("selectedStock").style.display = "block";
	} else {
		stockPoolType = 0;
		document.getElementsByClassName("form-group")[0].style.display = "none";
		document.getElementById("selectedStock").style.display = "none";

	}
}

function addStock(code) {
	if($("#" + code).val() == "请先登陆") {
		sweetAlert("请先登陆!", "", "error");
		return false;
	}
	if($.inArray($("#" + code).val().toString(),stockCodes)){
		sweetAlert("已经添加该股票！","","error");
		return false;
	}
	if($("#" + code).val() != "") {
		stockCodes[stockCodes.length] = $("#" + code).val().toString();
	} else {
		sweetAlert("请选择股票！", "", "error");
	}
}

function addAllStock() {
	for(var i = 0; i < collectedStock.length; i++) {
		if(jQuery.inArray(collectedStock[i]['code'], stockCodes) == -1) {
			stockCodes[stockCodes.length] = collectedStock[i]['code'];
		}
	}
}

function backTest() {
	var baseYieldBlock;
	var backTestBlock;
	var startDate;
	var endDate;
	var initFund;
	var notST;
	var holdingPeriod;
	var returnPeriod;
	var stopLoss;
	var stopProfit;

	var ratio;

	tag = 1;
	var baseYieldBlocks =document.getElementsByClassName("baseYieldBlock");
	baseYieldBlock = baseYieldBlocks[strategyType].value;
	
	if(stockPoolType == 0) {
		backTestBlock = $("#backTestBlock").val();
	}

	var startTimes = document.getElementsByClassName("startDatepicker");
	startDate = startTimes[strategyType].value;

	var endTimes = document.getElementsByClassName("endDatepicker");
	endDate = endTimes[strategyType].value;

	var initFunds = document.getElementsByClassName("initFund");
	initFund = initFunds[strategyType].value;

	var holdingPeriods = document.getElementsByClassName("holdingPeriod");
	holdingPeriod = holdingPeriods[strategyType].value;

	var returnPeriods = document.getElementsByClassName("returnPeriod");
	returnPeriod = returnPeriods[strategyType].value;

	var stopLosses = document.getElementsByClassName("stopLoss");
	stopLoss = stopLosses[strategyType].value;

	var stopProfits = document.getElementsByClassName("stopProfit");
	stopProfit = stopProfits[strategyType].value;

	var notSTs = document.getElementsByClassName("notST");
	notST = notSTs[0].checked;

	var strategyBackTestInputVO;

	switch(strategyType) {
		case 0:
			var ratio = document.getElementsByClassName("ratio")[0].value;
			var isHoldingPeriodFixed = document.getElementsByClassName("isHoldingPeriodFixed")[0].value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
				'strategyBackTestInputVO.baseYieldBlocks': baseYieldBlock,
				'strategyBackTestInputVO.backTestBlock': backTestBlock,
				'strategyBackTestInputVO.stockCodes': stockCodes,
				'strategyBackTestInputVO.startDate': startDate,
				'strategyBackTestInputVO.endDate': endDate,
				'strategyBackTestInputVO.initFund': initFund,
				'strategyBackTestInputVO.notST': notST,
				'strategyBackTestInputVO.holdingPeriod': holdingPeriod,
				'strategyBackTestInputVO.returnPeriod': returnPeriod,
				'strategyBackTestInputVO.stopLoss': stopLoss,
				'strategyBackTestInputVO.stopProfit': stopProfit,
				'strategyBackTestInputVO.ratio': ratio,
				'strategyBackTestInputVO.isHoldingPeriodFixed': isHoldingPeriodFixed
			};
			break;
		case 1:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[0].value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
				'strategyBackTestInputVO.baseYieldBlocks': baseYieldBlock,
				'strategyBackTestInputVO.backTestBlock': backTestBlock,
				'strategyBackTestInputVO.stockCodes': stockCodes,
				'strategyBackTestInputVO.startDate': startDate,
				'strategyBackTestInputVO.endDate': endDate,
				'strategyBackTestInputVO.initFund': initFund,
				'strategyBackTestInputVO.notST': notST,
				'strategyBackTestInputVO.holdingPeriod': holdingPeriod,
				'strategyBackTestInputVO.returnPeriod': returnPeriod,
				'strategyBackTestInputVO.stopLoss': stopLoss,
				'strategyBackTestInputVO.stopProfit': stopProfit,
				'strategyBackTestInputVO.holdingStockNum': holdingStockNum,
				'strategyBackTestInputVO.isHoldingPeriodFixed': isHoldingPeriodFixed
			};
			break;
		case 2:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[1].value;
			var shortReturnPeriod = document.getElementById("shortReturnPeriod").value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
				'strategyBackTestInputVO.baseYieldBlocks': baseYieldBlock,
				'strategyBackTestInputVO.backTestBlock': backTestBlock,
				'strategyBackTestInputVO.stockCodes': stockCodes,
				'strategyBackTestInputVO.startDate': startDate,
				'strategyBackTestInputVO.endDate': endDate,
				'strategyBackTestInputVO.initFund': initFund,
				'strategyBackTestInputVO.notST': notST,
				'strategyBackTestInputVO.holdingPeriod': holdingPeriod,
				'strategyBackTestInputVO.returnPeriod': returnPeriod,
				'strategyBackTestInputVO.stopLoss': stopLoss,
				'strategyBackTestInputVO.stopProfit': stopProfit,
				'strategyBackTestInputVO.holdingStockNum': holdingStockNum,
				'strategyBackTestInputVO.shortReturnPeriod': shortReturnPeriod
			};
			break;
		case 3:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[2].value;
			var changeNumber = document.getElementById("changeNumber").value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
				'strategyBackTestInputVO.baseYieldBlocks': baseYieldBlock,
				'strategyBackTestInputVO.backTestBlock': backTestBlock,
				'strategyBackTestInputVO.stockCodes': stockCodes,
				'strategyBackTestInputVO.startDate': startDate,
				'strategyBackTestInputVO.endDate': endDate,
				'strategyBackTestInputVO.initFund': initFund,
				'strategyBackTestInputVO.notST': notST,
				'strategyBackTestInputVO.holdingPeriod': holdingPeriod,
				'strategyBackTestInputVO.returnPeriod': returnPeriod,
				'strategyBackTestInputVO.stopLoss': stopLoss,
				'strategyBackTestInputVO.stopProfit': stopProfit,
				'strategyBackTestInputVO.holdingStockNum': holdingStockNum,
				'strategyBackTestInputVO.changeNumber': changeNumber
			};
			break;
		case 4:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[3].value;
			var trainPeriod = document.getElementById("trainPeriod").value;
			var k = document.getElementById("k").value;
			var vectorLength = document.getElementById("vectorLength").value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
				'strategyBackTestInputVO.baseYieldBlocks': baseYieldBlock,
				'strategyBackTestInputVO.backTestBlock': backTestBlock,
				'strategyBackTestInputVO.stockCodes': stockCodes,
				'strategyBackTestInputVO.startDate': startDate,
				'strategyBackTestInputVO.endDate': endDate,
				'strategyBackTestInputVO.initFund': initFund,
				'strategyBackTestInputVO.notST': notST,
				'strategyBackTestInputVO.holdingPeriod': holdingPeriod,
				'strategyBackTestInputVO.returnPeriod': returnPeriod,
				'strategyBackTestInputVO.stopLoss': stopLoss,
				'strategyBackTestInputVO.stopProfit': stopProfit,
				'strategyBackTestInputVO.trainPeriod': trainPeriod,
				'strategyBackTestInputVO.k': k,
				'strategyBackTestInputVO.holdingStockNum': holdingStockNum,
				'strategyBackTestInputVO.vectorLength': vectorLength
			};
			break;
	}

	// var strategyBackTestingResult;
	if(strategyType == 0 || strategyType == 1) {
        $.ajax({
            type: 'post',
            url: 'getStrategyBackTesting.action',
//		url: 'test.action',
            async: false,
            data: strategyBackTestInputVO,
            dataType: 'json',
            success: function (data) {
                strategyBackTestingResult = JSON.parse(data);
            },
            error: function (data) {
                alert("error");
            }
        });

        $.ajax({
            type: 'post',
            url: 'getAbnormalReturnGraphInfo.action',
//		url: 'test.action',
            async: false,
            data: strategyBackTestInputVO,
            dataType: 'json',
            success: function (data) {
                abnormalReturnResult = JSON.parse(data);
            },
            error: function (data) {
                alert("error");
            }
        });
        drawCumulativeYield();
    }else{
        $.ajax({
            type: 'post',
            url: 'getStrategyBackTesting.action',
//		url: 'test.action',
            async: false,
            data: strategyBackTestInputVO,
            dataType: 'json',
            success: function (data) {
                strategyBackTestingResult = JSON.parse(data);
            },
            error: function (data) {
                alert("error");
            }
        });
        drawCumulativeYield();
    }
}

$('.selectpicker').selectpicker({
	style: 'btn-info',
	size: 4
});
//策略基准累计收益率
function drawCumulativeYield() {
    var firstbutton = document.getElementById("firstbutton");
    var secondbutton = document.getElementById("secondbutton");
    var thirdbutton = document.getElementById("thirdbutton");
    var fourthbutton = document.getElementById("fourthbutton");
    if(strategyType == 0 || strategyType == 1) {
        firstbutton.style.backgroundColor = "#003366";
        firstbutton.style.color = "#FFFFFF";
        secondbutton.style.backgroundColor = "#FFFFFF";
        secondbutton.style.color = "#000000";
        thirdbutton.style.backgroundColor = "#FFFFFF";
        thirdbutton.style.color = "#000000";
        fourthbutton.style.backgroundColor = "#FFFFFF";
        fourthbutton.style.color = "#000000";
    }else{
        firstbutton.style.backgroundColor = "#003366";
        firstbutton.style.color = "#FFFFFF";
        secondbutton.style.backgroundColor = "#FFFFFF";
        secondbutton.style.color = "#000000";
    }
    if(tag == 1) {
        var date = [];
        var yieldline = [];
        var baseline = [];
        for (var i = 0; i < strategyBackTestingResult['cumulativeYieldResultVO']['yieldData'].length; i++) {
            date.push(strategyBackTestingResult['cumulativeYieldResultVO']['yieldData'][i]['date']);
            yieldline.push(strategyBackTestingResult['cumulativeYieldResultVO']['yieldData'][i]['value']);
        }
        for (var i = 0; i < strategyBackTestingResult['cumulativeYieldResultVO']['baseYieldData'].length; i++) {
            baseline.push(strategyBackTestingResult['cumulativeYieldResultVO']['baseYieldData'][i]['value']);
        }
        var text = "基准年化收益率:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['baseAnnualRevenue']) + "%"
                    + "年化收益率:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['annualRevenue']) + "%"
                    + "alpha:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['alpha'])
                    + "beta:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['beta'])
                    + "夏普比率:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['sharpeRatio'])
                    + "最大回撤:" + String(strategyBackTestingResult['cumulativeYieldResultVO']['maxDrawdown']) + "%";
        var content = document.getElementById("testcontent");
        content.innerHTML = text;
        var myChart = echarts.init(document.getElementById('grapharea'));
        var option1 = {
            backgroundColor: '#FFFFFF',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            legend: {
                data: ['基准累积收益率', '策略累积收益率']
            },
            grid: {
                top: '10%',
                left: '5%',
                right: '3%',
                bottom: '11%'
            },
            xAxis: {
                type: 'category',
                data: date
            },
            yAxis: {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            series: [
                {
                    name: '基准累积收益率',
                    type: 'line',
                    data: baseline

                },
                {
                    name: '策略累积收益率',
                    type: 'line',
                    data: yieldline
                }
            ]
        };
        myChart.setOption(option1);
    }

}
//频率分布直方图
function drawYieldHistogram() {
    var firstbutton = document.getElementById("firstbutton");
    var secondbutton = document.getElementById("secondbutton");
    var thirdbutton = document.getElementById("thirdbutton");
    var fourthbutton = document.getElementById("fourthbutton");
    if(strategyType == 0 || strategyType == 1) {
        secondbutton.style.backgroundColor = "#003366";
        secondbutton.style.color = "#FFFFFF";
        firstbutton.style.backgroundColor = "#FFFFFF";
        firstbutton.style.color = "#000000";
        thirdbutton.style.backgroundColor = "#FFFFFF";
        thirdbutton.style.color = "#000000";
        fourthbutton.style.backgroundColor = "#FFFFFF";
        fourthbutton.style.color = "#000000";
    }else{
        secondbutton.style.backgroundColor = "#003366";
        secondbutton.style.color = "#FFFFFF";
        firstbutton.style.backgroundColor = "#FFFFFF";
        firstbutton.style.color = "#000000";
    }
    if(tag == 1){
        var group = [];
        var positive = [];
        var negative = [];
        for(var i=0;i<strategyBackTestingResult['yieldHistogramResultVO']['yieldHistogramData'].length;i++){
            group.push(String(strategyBackTestingResult['yieldHistogramResultVO']['yieldHistogramData'][i]['startRate']) +"%~" +
                    String(strategyBackTestingResult['yieldHistogramResultVO']['yieldHistogramData'][i]['endate']) + "%");
            positive.push(strategyBackTestingResult['yieldHistogramResultVO']['yieldHistogramData'][i]['positiveFrequency']);
            negative.push(strategyBackTestingResult['yieldHistogramResultVO']['yieldHistogramData'][i]['negativeFrequency']);
        }
        var text = "正收益周期数:" + String(strategyBackTestingResult['yieldHistogramResultVO']['positiveEarningNum'])
                    + "负收益周期数" + String(strategyBackTestingResult['yieldHistogramResultVO']['negativeEarningNum'])
                    +"赢率:" + String(strategyBackTestingResult['yieldHistogramResultVO']['winRate']) + "%";
        var content = document.getElementById("testcontent");
        content.innerHTML = text;
        var myChart = echarts.init(document.getElementById('grapharea'));
        var option1 = {
            backgroundColor: '#FFFFFF',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            legend: {
                data: ['正收益周期数', '负收益周期数']
            },
            grid: {
                top: '10%',
                left: '5%',
                right: '3%',
                bottom: '11%'
            },
            xAxis: {
                type: 'category',
                data: group
            },
            yAxis: {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            series: [
                {
                    name: '正收益周期数',
                    type: 'bar',
                    data: positive

                },
                {
                    name: '负收益周期数',
                    type: 'bar',
                    data: negative
                }
            ]
        };
        myChart.setOption(option1);
    }
}
//超额收益率图
function drawAbnormalReturn() {
    var firstbutton = document.getElementById("firstbutton");
    var secondbutton = document.getElementById("secondbutton");
    var thirdbutton = document.getElementById("thirdbutton");
    var fourthbutton = document.getElementById("fourthbutton");
    thirdbutton.style.backgroundColor = "#003366";
    thirdbutton.style.color = "#FFFFFF";
    secondbutton.style.backgroundColor = "#FFFFFF";
    secondbutton.style.color = "#000000";
    firstbutton.style.backgroundColor = "#FFFFFF";
    firstbutton.style.color = "#000000";
    fourthbutton.style.backgroundColor = "#FFFFFF";
    fourthbutton.style.color = "#000000";

    if(tag == 1){
        var date = [];
        var abnormalReturnData = [];
        if(abnormalReturnResult['isHoldingPeriodFixed']){
            //持有期不变
            for(var i=0;i<abnormalReturnResult['abnormalReturnLineVOS'].length;i++){
                abnormalReturnData.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['abnormalReturn']);
                date.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['returnPeriod']);
            }
            var text = "持有期:" + String(abnormalReturnResult['abnormalReturnLineVOS'][0]['holdingPeriod']) + "天"
                        + "最佳形成期:" + String(abnormalReturnResult['bestReturnPeriod']) + "天"
                        + "最优的超额收益率:" + String(abnormalReturnResult['bestAbnormalReturn']) + "%";
            var content = document.getElementById("testcontent");
            content.innerHTML = text;
        }else{
            //形成期不变
            for(var i=0;i<abnormalReturnResult['abnormalReturnLineVOS'].length;i++){
                abnormalReturnData.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['abnormalReturn']);
                date.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['holdingPeriod']);
            }
            var text = "形成期:" + String(abnormalReturnResult['abnormalReturnLineVOS'][0]['returnPeriod']) + "天"
                + "最佳持有期:" + String(abnormalReturnResult['bestHoldingPeriod']) + "天"
                + "最优的超额收益率:" + String(abnormalReturnResult['bestAbnormalReturn']) + "%";
            var content = document.getElementById("testcontent");
            content.innerHTML = text;
        }
        var myChart = echarts.init(document.getElementById('grapharea'));
        var option1 = {
            backgroundColor: '#FFFFFF',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            legend: {
                data: ['超额收益率']
            },
            grid: {
                top: '10%',
                left: '5%',
                right: '3%',
                bottom: '11%'
            },
            xAxis: {
                type: 'category',
                data: date
            },
            yAxis: {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            series: [
                {
                    name: '超额收益率',
                    type: 'line',
                    data: abnormalReturnData

                }
            ]
        };
        myChart.setOption(option1);
    }
}
//策略胜率图
function drawStategyWinRate() {
    var firstbutton = document.getElementById("firstbutton");
    var secondbutton = document.getElementById("secondbutton");
    var thirdbutton = document.getElementById("thirdbutton");
    var fourthbutton = document.getElementById("fourthbutton");
    fourthbutton.style.backgroundColor = "#003366";
    fourthbutton.style.color = "#FFFFFF";
    secondbutton.style.backgroundColor = "#FFFFFF";
    secondbutton.style.color = "#000000";
    firstbutton.style.backgroundColor = "#FFFFFF";
    firstbutton.style.color = "#000000";
    thirdbutton.style.backgroundColor = "#FFFFFF";
    thirdbutton.style.color = "#000000";

    if(tag == 1){
        var date = [];
        var abnormalReturnData = [];
        if(abnormalReturnResult['isHoldingPeriodFixed']){
            //持有期不变
            for(var i=0;i<abnormalReturnResult['abnormalReturnLineVOS'].length;i++){
                abnormalReturnData.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['stategyWinRate']);
                date.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['returnPeriod']);
            }
            var text = "持有期:" + String(abnormalReturnResult['abnormalReturnLineVOS'][0]['holdingPeriod']) + "天"
                + "最佳形成期:" + String(abnormalReturnResult['bestReturnPeriod']) + "天"
                + "最优的策略胜率:" + String(abnormalReturnResult['bestStategyWinRate']) + "%";
            var content = document.getElementById("testcontent");
            content.innerHTML = text;
        }else{
            //形成期不变
            for(var i=0;i<abnormalReturnResult['abnormalReturnLineVOS'].length;i++){
                abnormalReturnData.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['stategyWinRate']);
                date.push(abnormalReturnResult['abnormalReturnLineVOS'][i]['holdingPeriod']);
            }
            var text = "形成期:" + String(abnormalReturnResult['abnormalReturnLineVOS'][0]['returnPeriod']) + "天"
                + "最佳持有期:" + String(abnormalReturnResult['bestHoldingPeriod']) + "天"
                + "最优的策略胜率:" + String(abnormalReturnResult['bestStategyWinRate']) + "%";
            var content = document.getElementById("testcontent");
            content.innerHTML = text;
        }
        var myChart = echarts.init(document.getElementById('grapharea'));
        var option1 = {
            backgroundColor: '#FFFFFF',
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            legend: {
                data: ['策略胜率']
            },
            grid: {
                top: '10%',
                left: '5%',
                right: '3%',
                bottom: '11%'
            },
            xAxis: {
                type: 'category',
                data: date
            },
            yAxis: {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            series: [
                {
                    name: '策略胜率',
                    type: 'line',
                    data: abnormalReturnData

                }
            ]
        };
        myChart.setOption(option1);
    }
}