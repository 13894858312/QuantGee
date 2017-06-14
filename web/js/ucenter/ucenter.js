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
			document.getElementById("la").innerHTML = "退出";
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
				if(collectedStock != "") {
					for(var i = 0; i < collectedStock.length; i++) {
						var stockName = collectedStock[i]['stockName'];
						var code = collectedStock[i]['code'];
						var trade = collectedStock[i]['trade'];
						var changePercent = collectedStock[i]['changePercent'];
						var tr = $("<tr><td><a onclick='totheStockView()' target='_blank'>" + stockName + "</a></td>" +
							"<td><a class='inputStockCode' onclick='totheStockView()' target='_blank'>" + code + "</a></td>" +
							"<td>" + trade + "</td><td>" + changePercent + "</td></tr>");
						tr.appendTo("#table1");
						var volume = collectedStock[i]['volume'];
						var amount = collectedStock[i]['amount'];
						var mktcap = collectedStock[i]['mktcap'];
						var per = collectedStock[i]['per'];
						var pb = collectedStock[i]['pb'];
						var tr = $("<tr><td>" + volume + "</td><td>" + amount + "</td>" +
							"<td>" + mktcap + "</td><td>" + per + "</td><td>" + pb + "</td></tr>");
						tr.appendTo("#table2");
						var settlement = collectedStock[i]['settlement'];
						var open = collectedStock[i]['open'];
						var high = collectedStock[i]['high'];
						var low = collectedStock[i]['low'];
						var turnover = collectedStock[i]['turnover'];
						var tr = $("<tr><td>" + settlement + "</td><td>" + open + "</td>" +
							"<td>" + high + "</td><td>" + low + "</td><td>" + turnover + "</td></tr>");
						tr.appendTo("#table3");

						var but = $("<tr><th class='arr_r' style='width : 50px ; height : 50px;'><i id='next' onclick='deleteCollectedStock(" + i + ")' style='background-position : -243px -882px;'></i></th></tr>")
						but.appendTo("#table4");
					}
				}
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

function changePanel(panelName) {
	document.getElementById("myStock").style.display = "none";
	document.getElementById("myStrategy").style.display = "none";
	document.getElementById("accountSetting").style.display = "none";
	document.getElementById(panelName).style.display = "block";
}

function changeInfo(infoField) {
	document.getElementById(infoField).removeAttribute("readonly");
	document.getElementById(infoField).focus();
	document.getElementById("changeInfoButton").style.display = "block";
}

function submitInfoChagnes() {
	var accountVO = {
		'userVO.accountID': document.getElementById("accountIDInfo").value,
		'userVO.userName': document.getElementById("usernameInfo").value,
		'userVO.phoneNumber': document.getElementById("phoneNumber").value
	};
	$.ajax({
		type: 'post',
		url: 'updateUserInfo.action',
		async: false,
		data: {
			'userVO.accountID': document.getElementById("accountIDInfo").value,
			'userVO.userName': document.getElementById("usernameInfo").value,
			'userVO.phoneNumber': document.getElementById("phoneNumber").value
		},
		dataType: 'json',
		success: function(data) {
			userInfo = JSON.parse(data);
			swal("修改成功！", "", "success");
			document.getElementById("accountIDInfo").value = userInfo["accountID"];
			document.getElementById("accountIDInfo").readOnly = "readonly";
			document.getElementById("usernameInfo").value = userInfo["userName"];
			document.getElementById("usernameInfo").readOnly = "readonly";
			document.getElementById("phoneNumber").value = userInfo["phoneNumber"];
			document.getElementById("phoneNumber").readOnly = "readonly";
			document.getElementById("changeInfoButton").style.display = "none";
		},
		error: function(data) {
			alert("error");
		}
	});
}

function changePassword() {
	if(document.getElementById("changePasswordBut").innerHTML == "修改密码") {
		swal({
				title: "验证用户",
				text: "请输入原密码",
				type: "input",
				inputType: "password",
				showCancelButton: true,
				closeOnConfirm: false,
				animation: "slide-from-top",
				inputPlaceholder: "请输入原密码"
			},
			function(inputValue) {
				if(inputValue === false) return false;

				if(inputValue === "") {
					swal.showInputError("请输入原密码");
					return false
				}

				$.ajax({
					type: "post",
					url: "checkAccount.action",
					async: false,
					data: {
						'accountVO.accountID': accountID,
						'accountVO.password': inputValue

					},
					dataType: 'json',
					success: function(data) {
						if(data == "success") {
							swal("验证成功！", "", "success");
							document.getElementById("changePasswordBut").innerHTML = "确认修改";
							document.getElementById("passwordInfo").removeAttribute("readonly");
							document.getElementById("passwordInfo").focus();
						} else {
							swal("验证失败！", "", "error");
						}
					},
					error: function(data) {
						swal("失败", "貌似出错了。重试一下", "error");
					}
				});
			});
	} else {

		if(document.getElementById("passwordInfo").value == "") {
			swal("请输入新密码！", "", "error");
			return false;
		}

		$.ajax({
			type: "post",
			url: "modifyPassword.action",
			async: false,
			data: {
				'accountVO.accountID': accountID,
				'accountVO.password': document.getElementById("passwordInfo").value
			},
			dataType: 'json',
			success: function(data) {
				if(data == "success") {
					document.getElementById("changePasswordBut").innerHTML = "修改密码";
					document.getElementById("passwordInfo").readOnly = "readonly";
					document.getElementById("passwordInfo").value = "";
					swal("修改成功！", "", "success");
				} else {
					swal("修改失败！", "", "error");
				}
			},
			error: function(data) {
				swal("失败", "貌似出错了。重试一下", "error");
			}
		});
	}
}

function deleteCollectedStock(i) {
	swal({
			title: "确定删除吗？",
			text: "你将删除该收藏股票！",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "确定删除！",
			closeOnConfirm: false
		},
		function() {
			var code = document.getElementsByClassName("inputStockCode")[i].innerHTML;
			$.ajax({
				type: "post",
				url: "deleteCollectedStock.action",
				async: false,
				data: {
					'stockCollectInputVO.userID': accountID,
					'stockCollectInputVO.code': code

				},
				dataType: 'json',
				success: function(data) {
					if(data == "success") {
						$.ajax({
							type: "post",
							url: "getCollectStock.action",
							async: false,
							data: {
								'accountID': accountID,

							},
							dataType: 'json',
							success: function(data) {
								collectedStock = JSON.parse(data);
								$("#table1").empty();
								$("#table2").empty();
								$("#table3").empty();
								$("#table4").empty();
								if(collectedStock != "") {
									for(var i = 0; i < collectedStock.length; i++) {
										var stockName = collectedStock[i]['stockName'];
										var code = collectedStock[i]['code'];
										var trade = collectedStock[i]['trade'];
										var changePercent = collectedStock[i]['changePercent'];
										var tr = $("<tr><td><a onclick='totheStockView()' target='_blank'>" + stockName + "</a></td>" +
											"<td><a class='inputStockCode' onclick='totheStockView()' target='_blank'>" + code + "</a></td>" +
											"<td>" + trade + "</td><td>" + changePercent + "</td></tr>");
										tr.appendTo("#table1");
										var volume = collectedStock[i]['volume'];
										var amount = collectedStock[i]['amount'];
										var mktcap = collectedStock[i]['mktcap'];
										var per = collectedStock[i]['per'];
										var pb = collectedStock[i]['pb'];
										var tr = $("<tr><td>" + volume + "</td><td>" + amount + "</td>" +
											"<td>" + mktcap + "</td><td>" + per + "</td><td>" + pb + "</td></tr>");
										tr.appendTo("#table2");
										var settlement = collectedStock[i]['settlement'];
										var open = collectedStock[i]['open'];
										var high = collectedStock[i]['high'];
										var low = collectedStock[i]['low'];
										var turnover = collectedStock[i]['turnover'];
										var tr = $("<tr><td>" + settlement + "</td><td>" + open + "</td>" +
											"<td>" + high + "</td><td>" + low + "</td><td>" + turnover + "</td></tr>");
										tr.appendTo("#table3");

										var but = $("<tr><th class='arr_r' style='width : 50px ; height : 50px;'><i id='next' onclick='deleteCollectedStock(" + i + ")' style='background-position : -243px -882px;'></i></th></tr>")
										but.appendTo("#table4");
									}
								}
							},
							error: function(data) {
								alert("error");
							}
						});
						swal("删除成功！", "", "success");
					} else {
						swal("删除失败！", "", "error");
					}
				},
				error: function(data) {
					swal("失败", "貌似出错了。重试一下", "error");
				}
			});
		});
}

function logout() {
	$.ajax({
		type: "post",
		url: "logout.action",
		async: false,
		data: {
			'accountVO.accountID': accountID,
			'accountVO.password': inputValue

		},
		dataType: 'json',
		success: function(data) {
			if(data == "success") {
				swal("验证成功！", "", "success");
				document.getElementById("changePasswordBut").innerHTML = "确认修改";
				document.getElementById("passwordInfo").removeAttribute("readonly");
				document.getElementById("passwordInfo").focus();
			} else {
				swal("验证失败！", "", "error");
			}
		},
		error: function(data) {
			swal("失败", "貌似出错了。重试一下", "error");
		}
	});
}