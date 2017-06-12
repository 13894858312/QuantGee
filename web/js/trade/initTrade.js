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
    if(tradeInfoArray.length>0){
        for(var i=0;i<tradeInfoArray.length;i++){
            var x = document.getElementById('st').insertRow(document.getElementById('st').rows.length);
            var stockName = x.insertCell(0);
            var stockCode = x.insertCell(1);
            var theNumOfStock = x.insertCell(2);
            var theValueOfStock = x.insertCell(3);
            var nowPrice = x.insertCell(4);
            var range = x.insertCell(5);
            var deletedo = x.insertCell(6);
            stockName.innerHTML = json[i]['stockName'];
            stockCode.innerHTML = json[i]['stockCode'];
            theNumOfStock.innerHTML = json[i]['holdNum'];
            theValueOfStock.innerHTML = json[i]['initFund'];
            nowPrice.innerHTML = json[i]['nowPrice'];
            range.innerHTML = json[i]['yield'];
            // deletedo.innerHTML = "<img src='../../images/deletebutton.png' />";
            // deletedo.style.textAlign = "right";
            // deletedo.style.cursor = "hand";
            // deletedo.onclick = function () {
            //     if(getTradeRetunResult(1))
            //     document.getElementById('st').deleteRow(x.rowIndex)
            //     money.innerHTML = Number(money.textContent) + (json['trade'] * Number(num.value));
            // }
        }
    }
}