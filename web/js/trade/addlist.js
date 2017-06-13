/**
 * Created by Administrator on 2017/6/10.
 */
var balance;
var accountID;
var stockName;
function buyStock() {
    $.ajax({
        type: 'get',
        url: 'haveLogin.action',
        async: false,
        dataType: 'json',
        success: function (data) {
            accountID = JSON.parse(data)["accountID"];
        },
        error: function (data) {
            alert("error");
        }
    });
    if(accountID == ""){
        swal("请先登录","","warning");
    }else {
        var stockCode = document.getElementById("stname");
        var num = document.getElementById("stnum");
        if (stockCode.value == null || num.value == null) {
            swal("请输入完整信息", "", "warning");
        } else {
            if (getTradeRetunResult(0)) {
                var row1 = document.getElementById('st').rows.length;
                for(var i=row1-1;i>0;i--){
                    document.getElementById('st').deleteRow(i);
                }
                var row2 = document.getElementById('record').rows.length;
                for(var i=row2-1;i>0;i--){
                    document.getElementById('record').deleteRow(i);
                }
                var json;
                $.ajax({
                    cache: false,
                    async: false,
                    type: 'POST',
                    url: 'getUserTradeStockInfo.action',
                    data: {
                        accountID: accountID
                    },
                    dataType: 'json',
                    success: function (data) {
                        json = JSON.parse(data);
                    },
                    error: function (data) {
                        alert("error")
                    }
                });
                if(balance >= 0) {
                    var info = "买入" + stockName + num.value + "股";
                    swal("交易成功", info, "success");
                    var money = document.getElementById("nowmoney");
                    money.innerHTML = balance;
                    if (json.length > 0) {
                        for (var i = 0; i < json.length; i++) {
                            var x = document.getElementById('st').insertRow(document.getElementById('st').rows.length);
                            var stockName = x.insertCell(0);
                            var stockCode = x.insertCell(1);
                            var theNumOfStock = x.insertCell(2);
                            var theValueOfStock = x.insertCell(3);
                            var nowPrice = x.insertCell(4);
                            var range = x.insertCell(5);
                            var deletedo = x.insertCell(6);
                            money.innerHTML = balance;
                            stockName.innerHTML = json[i]['stockName'];
                            stockCode.innerHTML = json[i]['stockCode'];
                            theNumOfStock.innerHTML = json[i]['holdNum'];
                            theValueOfStock.innerHTML = json[i]['initFund'];
                            nowPrice.innerHTML = json[i]['nowPrice'];
                            range.innerHTML = json[i]['yield'];
                        }
                    }
                    var alltraderecords;
                    $.ajax({
                        type: 'POST',
                        url: 'getAllTradeRecord.action',
                        async: false,
                        dataType: 'json',
                        data: {
                            accountID: accountID
                        },
                        success: function (data) {
                            alltraderecords = JSON.parse(data);
                        },
                        error: function (data) {
                            alert("error");
                        }
                    });
                    if (alltraderecords.length > 0) {
                        for (var i = 0; i < alltraderecords.length; i++) {
                            var x = document.getElementById('record').insertRow(document.getElementById('record').rows.length);
                            var stockName = x.insertCell(0);
                            var stockCode = x.insertCell(1);
                            var action = x.insertCell(2);
                            var theNumOfStock = x.insertCell(3);
                            var tradePrice = x.insertCell(4);
                            var tradeTime = x.insertCell(5);
                            stockName.innerHTML = alltraderecords[i]['stockName'];
                            stockCode.innerHTML = alltraderecords[i]['stockCode'];
                            if (alltraderecords[i]['action'] == 0) {
                                action.innerHTML = "买入";
                            } else {
                                action.innerHTML = "卖出";
                            }
                            theNumOfStock.innerHTML = alltraderecords[i]['numOfStock'];
                            tradePrice.innerHTML = alltraderecords[i]['price'];
                            tradeTime.innerHTML = alltraderecords[i]['time'];
                        }
                    }
                }else{
                    swal("余额不足","","error");
                }
            }else{
                swal("交易失败","","error");
            }
        }
    }
}

function sellStock() {
    var accountID;
    $.ajax({
        type: 'get',
        url: 'haveLogin.action',
        async: false,
        dataType: 'json',
        success: function (data) {
            accountID = JSON.parse(data)["accountID"];
        },
        error: function (data) {
            alert("error");
        }
    });
    if(accountID == ""){
        swal("请先登录","","warning");
    }else {
        var stockCode = document.getElementById("stname");
        var num = document.getElementById("stnum");
        if (stockCode.value == null || num.value == null) {
            swal("请输入完整信息", "", "warning");
        } else {
            if (getTradeRetunResult(1)) {
                var row1 = document.getElementById('st').rows.length;
                for(var i=row1-1;i>0;i--){
                    document.getElementById('st').deleteRow(i);
                }
                var row2 = document.getElementById('record').rows.length;
                for(var i=row2-1;i>0;i--){
                    document.getElementById('record').deleteRow(i);
                }
                var json;
                $.ajax({
                    cache: false,
                    async: false,
                    type: 'POST',
                    url: 'getUserTradeStockInfo.action',
                    data: {
                        accountID: accountID
                    },
                    dataType: 'json',
                    success: function (data) {
                        json = JSON.parse(data);
                    },
                    error: function (data) {
                        alert("error")
                    }
                });
                    var info = "卖出" + stockName + num.value + "股";
                    swal("交易成功", info, "success");
                    var money = document.getElementById("nowmoney");
                    money.innerHTML = balance;
                    if (json.length > 0) {
                        for (var i = 0; i < json.length; i++) {
                            var x = document.getElementById('st').insertRow(document.getElementById('st').rows.length);
                            var stockName = x.insertCell(0);
                            var stockCode = x.insertCell(1);
                            var theNumOfStock = x.insertCell(2);
                            var theValueOfStock = x.insertCell(3);
                            var nowPrice = x.insertCell(4);
                            var range = x.insertCell(5);
                            var deletedo = x.insertCell(6);
                            money.innerHTML = balance;
                            stockName.innerHTML = json[i]['stockName'];
                            stockCode.innerHTML = json[i]['stockCode'];
                            theNumOfStock.innerHTML = json[i]['holdNum'];
                            theValueOfStock.innerHTML = json[i]['initFund'];
                            nowPrice.innerHTML = json[i]['nowPrice'];
                            range.innerHTML = json[i]['yield'];
                        }
                    }
                    var alltraderecords;
                    $.ajax({
                        type: 'POST',
                        url: 'getAllTradeRecord.action',
                        async: false,
                        dataType: 'json',
                        data: {
                            accountID: accountID
                        },
                        success: function (data) {
                            alltraderecords = JSON.parse(data);
                        },
                        error: function (data) {
                            alert("error");
                        }
                    });
                    if (alltraderecords.length > 0) {
                        for (var i = 0; i < alltraderecords.length; i++) {
                            var x = document.getElementById('record').insertRow(document.getElementById('record').rows.length);
                            var stockName = x.insertCell(0);
                            var stockCode = x.insertCell(1);
                            var action = x.insertCell(2);
                            var theNumOfStock = x.insertCell(3);
                            var tradePrice = x.insertCell(4);
                            var tradeTime = x.insertCell(5);
                            stockName.innerHTML = alltraderecords[i]['stockName'];
                            stockCode.innerHTML = alltraderecords[i]['stockCode'];
                            if (alltraderecords[i]['action'] == 0) {
                                action.innerHTML = "买入";
                            } else {
                                action.innerHTML = "卖出";
                            }
                            theNumOfStock.innerHTML = alltraderecords[i]['numOfStock'];
                            tradePrice.innerHTML = alltraderecords[i]['price'];
                            tradeTime.innerHTML = alltraderecords[i]['time'];
                        }
                    }
            }else{
                swal("交易失败","","error");
            }
        }
    }
}
function getTradeRetunResult(addordelete) {
    var stockCode = document.getElementById("stname");
    var num = document.getElementById("stnum");
    var returnResult;
    var nowPrice;
    $.ajax({
        cache: false,
        async: false,
        type: 'POST',
        url: 'getSTCodeInfo.action',
        data: {
            stockCode: stockCode.value
        },
        dataType: 'json',
        success: function (data) {
            nowPrice = JSON.parse(data);
        },
        error: function (data) {
            alert("error")
        }
    });
    $.ajax({
        cache: false,
        async: false,
        type: 'POST',
        url: 'getTradeActionResult.action',
        data: {
            tradeAction:addordelete,
            stockCode: stockCode.value,
            accountID:accountID,
            numOfStock:num.value,
            nowPrice: nowPrice['trade']
        },
        dataType: 'json',
        success: function (data) {
            returnResult = JSON.parse(data);
        },
        error: function (data) {
            alert("error")
        }
    });
    var result;
    if(returnResult[0] == "error"){
        result = false;
    }else{
        var money;
        $.ajax({
            cache: false,
            async: false,
            type: 'POST',
            url: 'getBalance.action',
            data: {
                accountID:accountID
            },
            dataType: 'json',
            success: function (data) {
                money = JSON.parse(data);
            },
            error: function (data) {
                alert("error")
            }
        });
        balance = money[0];
        stockName = returnResult[1];
        result = true;
    }
    return result;
}