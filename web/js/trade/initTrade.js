/**
 * Created by Administrator on 2017/6/12.
 */
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
    // swal("请先登录","","warning");
}else {
    var tradeInfoArray;
    var balance;
    $.ajax({
        type: 'POST',
        url: 'getUserTradeStockInfo.action',
        async: false,
        dataType: 'json',
        data:{
            accountID: accountID
        },
        success: function (data) {
            tradeInfoArray = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
    $.ajax({
        type: 'POST',
        url: 'getBalance.action',
        async: false,
        dataType: 'json',
        data:{
            accountID: accountID
        },
        success: function (data) {
            balance = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
    var money = document.getElementById("nowmoney");
    money.innerHTML = balance[0];
    if(tradeInfoArray.length>0){
        for(var i=0;i<tradeInfoArray.length;i++){
            var x = document.getElementById('st').insertRow(document.getElementById('st').rows.length);
            var stockName = x.insertCell(0);
            var stockCode = x.insertCell(1);
            var theNumOfStock = x.insertCell(2);
            var theValueOfStock = x.insertCell(3);
            var nowPrice = x.insertCell(4);
            var range = x.insertCell(5);
            var blank1 = x.insertCell(6);
            var blank2 = x.insertCell(7);
            stockName.innerHTML = tradeInfoArray[i]['stockName'];
            stockCode.innerHTML = tradeInfoArray[i]['stockCode'];
            theNumOfStock.innerHTML = tradeInfoArray[i]['holdNum'];
            theValueOfStock.innerHTML = tradeInfoArray[i]['initFund'];
            nowPrice.innerHTML = tradeInfoArray[i]['nowPrice'];
            range.innerHTML = tradeInfoArray[i]['yield'];
            blank1.innerHTML = "";
            blank2.innerHTML = "";
        }
    }

    var alltraderecords;
    $.ajax({
        type: 'POST',
        url: 'getAllTradeRecord.action',
        async: false,
        dataType: 'json',
        data:{
            accountID: accountID
        },
        success: function (data) {
            alltraderecords = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
    if(alltraderecords.length>0){
        for(var i=0;i<alltraderecords.length;i++){
            var x = document.getElementById('record').insertRow(document.getElementById('record').rows.length);
            var stockName = x.insertCell(0);
            var stockCode = x.insertCell(1);
            var action = x.insertCell(2);
            var theNumOfStock = x.insertCell(3);
            var tradePrice = x.insertCell(4);
            var tradeTime = x.insertCell(5);
            stockName.innerHTML = alltraderecords[i]['stockName'];
            stockCode.innerHTML = alltraderecords[i]['stockCode'];
            if(alltraderecords[i]['action'] == 0) {
                action.innerHTML = "买入";
            }else{
                action.innerHTML = "卖出";
            }
            theNumOfStock.innerHTML = alltraderecords[i]['numOfStock'];
            tradePrice.innerHTML = alltraderecords[i]['price'];
            tradeTime.innerHTML = alltraderecords[i]['time'];
        }
    }
}
