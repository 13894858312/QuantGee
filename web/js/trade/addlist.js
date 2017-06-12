/**
 * Created by Administrator on 2017/6/10.
 */
var balance;
function buyStock() {
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
            if (getTradeRetunResult(0)) {
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
                var info = "买入" + json['stockName'] + num.value + "股";
                swal("交易成功",info,"success");
                if(json.length>0){
                    for(var i=0;i<json.length;i++){
                        var money = document.getElementById("nowmoney");
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
                var info = "卖出" + json['stockName'] + num.value + "股";
                swal("交易成功",info,"success");
                if(json.length>0){
                    for(var i=0;i<json.length;i++){
                        var money = document.getElementById("nowmoney");
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
        balance = Number(returnResult[0]);
        result = true;
    }
    return result;
}