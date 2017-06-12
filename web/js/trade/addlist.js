/**
 * Created by Administrator on 2017/6/10.
 */
function addrow() {
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

        var stockCode = document.getElementById("inputstcode");
        var num = document.getElementById("inputnumofcode");
        if(stockCode.value == null || num.value == null){
            swal("请输入完整信息","","warning");
        }else{
            if(getTradeRetunResult(0)){

                var json;
                $.ajax({
                    cache: false,
                    async: false,
                    type: 'POST',
                    url: 'getTheStockTradeInfo.action',
                    data: {
                        accountID: accountID,
                        stockCode: stockCode.value
                    },
                    dataType: 'json',
                    success: function (data) {
                        json = JSON.parse(data);
                    },
                    error: function (data) {
                        alert("error")
                    }
                });

                var money = document.getElementById("nowmoney");
                //HoldingStockvo里面暂时没有现价
                // if ((Number(money.textContent) - (json['nowPrice'] * Number(num.value))) > 0) {
                    var info = "买入" + json['stockName'];
                    swal("交易成功",info,"success");
                    var x = document.getElementById('st').insertRow(document.getElementById('st').rows.length);
                    var stockName = x.insertCell(0);
                    var stockCode = x.insertCell(1);
                    var theNumOfStock = x.insertCell(2);
                    var theValueOfStock = x.insertCell(3);
                    var nowPrice = x.insertCell(4);
                    var range = x.insertCell(5);
                    var deletedo = x.insertCell(6);
                    stockName.innerHTML = json['stockName'];
                    stockCode.innerHTML = json['stockCode'];
                    theNumOfStock.innerHTML = json['holdNum'];
                    theValueOfStock.innerHTML = json['initFund'];
                    nowPrice.innerHTML = json['nowPrice'];
                    range.innerHTML = json['yield'];
                    deletedo.innerHTML = "<img src='../../images/deletebutton.png' />";
                    deletedo.style.textAlign = "right";
                    deletedo.style.cursor = "hand";
                    // deletedo.onclick = function () {
                    //     if(getTradeRetunResult(1))
                    //     document.getElementById('st').deleteRow(x.rowIndex)
                    //     money.innerHTML = Number(money.textContent) + (json['trade'] * Number(num.value));
                    // }
                    money.innerHTML = Number(money.textContent) - (json[''] * Number(num.value));
                // } else {
                //     swal("您的资产不足以购买","","warning");
                // }

            }else{
                swal("交易失败","","error")
            }
        }

    }
}
function getTradeRetunResult(addordelete) {
    var stockCode = document.getElementById("inputstcode");
    var num = document.getElementById("inputnumofcode");
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
            alert(data);
            returnResult = JSON.parse(data);
        },
        error: function (data) {
            alert("error")
        }
    });
    var result;
    if(returnResult[0] == "success"){
        result = true;
    }else{
        result = false;
    }
    return result;
}