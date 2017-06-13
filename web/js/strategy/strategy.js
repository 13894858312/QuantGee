var accountID;
var collectedStock;

//回测参数
var stockPoolType = 0;
var stockCodes = [];
var strategyType = 0;

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
		alert("hh");
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
	if($("#" + code).val() != "") {
		stockCodes[stockCodes.length] = $("#" + code).val();
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
			alert(ratio);
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
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
				'strategyBackTestInputVO.ratio': ratio
			};
			break;
		case 1:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[0].value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
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
				'strategyBackTestInputVO.holdingStockNum': holdingStockNum
			};
			break;
		case 2:
			var holdingStockNum = document.getElementsByClassName("holdingStockNum")[1].value;
			var shortReturnPeriod = document.getElementById("shortReturnPeriod").value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
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
			var trainPeriod = document.getElementById("trainPeriod").value;
			var k = document.getElementById("k").value;
			var vectorLength = document.getElementById("vectorLength").value;
			strategyBackTestInputVO = {
				'strategyBackTestInputVO.stockPoolType': stockPoolType,
				'strategyBackTestInputVO.strategyType': strategyType,
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
				'strategyBackTestInputVO.vectorLength': vectorLength
			};
			break;
	}

//			alert(notST);
//	$.ajax({
//		type: 'post',
//		url: 'getStrategyBackTesting.action',
////		url: 'test.action',
//		async: false,
//		data: strategyBackTestInputVO,
//		dataType: 'json',
//		success: function(data) {
//			alert(data);
//		},
//		error: function(data) {
//			alert("error");
//		}
//	});
}

$('.selectpicker').selectpicker({
	style: 'btn-info',
	size: 4
});