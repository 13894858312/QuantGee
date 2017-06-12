var accountID;
var collectedStock;

//回测参数
var stockPoolType;
var stockCodes = [];

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
				alert(data);
				collectedStock = JSON.parse(data);
			},
			error: function(data) {
				alert("error");
			}
		});
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

$('.selectpicker').selectpicker({
	style: 'btn-info',
	size: 4
});