var accountID;
var collectedStrategy;
var Stock;
var userInfo;

$(document).ready(function() {
//判断当前登陆用户
	$.ajax({
		type: 'get',
		url: 'haveLogin.action',
		async: false,
		dataType: 'json',
		success: function(data) {
			accountID = JSON.parse(data)["accountID"];
			document.getElementById("username").innerHTML = "欢迎，" + accountID + "!";
		},
		error: function(data) {
			alert("error");
		}
	});

	if(accountID[accountID] != "") {
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
//获取收藏的策略
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
//获取用户信息
		$.ajax({
			type: 'get',
			url: 'getUserInfo.action',
			async: false,
			data: {
				accountID: accountID
			},
			dataType: 'json',
			success: function(data) {
				alert(data);
				userInfo = JSON.parse(data);
				document.getElementById("accountIDInfo").value = userInfo["accountID"];
				document.getElementById("usernameInfo").value = userInfo["userName"];
				document.getElementById("phoneNumber").value = userInfo["phoneNumber"];
				
			},
			error: function(data) {
				alert("error");
			}
		});
	}
})

function changecolumns() {

	if(document.getElementById("next").style.backgroundPositionY == "-767px") {
		document.getElementsByClassName("colums")[0].style.display = "none";
		document.getElementsByClassName("colums hide")[0].style.display = "block";
		document.getElementById("next").style.backgroundPositionY = "-703px";
	} else {
		document.getElementsByClassName("colums")[0].style.display = "block";
		document.getElementsByClassName("colums hide")[0].style.display = "none";
		document.getElementById("next").style.backgroundPositionY = "-767px";
	}

}

function totheStockView() {
	var code = document.getElementById("inputStockCode");
	$.ajax({
		cache: false,
		async: false,
		url: 'totheStock.action',
		type: 'POST',
		dataType: 'json',
		data: {
			stockCode: code.innerText
		},
		success: function(data) {
			window.open('../../view/stock/theStock.jsp');
		},
		error: function(data) {
			alert("error")
		}
	});
}

function myStockPanel() {
	document.getElementById("myStock").style.display = "block";
	document.getElementById("myStrategy").style.display = "none";
	document.getElementById("accountSetting").style.display = "none";
}

function myStrategyPanel() {
	document.getElementById("myStock").style.display = "none";
	document.getElementById("myStrategy").style.display = "block";
	document.getElementById("accountSetting").style.display = "none";
}

function accountSettingPanel() {
	document.getElementById("myStock").style.display = "none";
	document.getElementById("myStrategy").style.display = "none";
	document.getElementById("accountSetting").style.display = "block";
}

function changeInfo(infoField){
	document.getElementById(infoField).removeAttribute("readonly");
	document.getElementById(infoField).focus();
	document.getElementById("changeInfoButton").style.display = "block";
}
