var accountID;
var collectedStock

$(document).ready(function() {
	$.ajax({
		type: 'get',
		url: 'haveLogin.action',
		async: false,
		dataType: 'json',
		success: function(data) {
			accountID = JSON.parse(data);
		},
		error: function(data) {
			alert("error");
		}
	});
	if(accountID != "") {
		$.ajax({
			type: "get",
			url: "getCollectStock.action",
			async: false,
			data: {
				accountID: accountID["accountID"]
			},
			dataType: 'json',
			success: function(data) {
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
		document.getElementsByClassName("form-group")[0].style.display = "block";
		document.getElementById("selectedStock").style.display = "block";
	} else {
		document.getElementsByClassName("form-group")[0].style.display = "none";
		document.getElementById("selectedStock").style.display = "none";

	}
}

$('.selectpicker').selectpicker({
	style: 'btn-info',
	size: 4
});