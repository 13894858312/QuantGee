/**
 * Created by Administrator on 2017/6/10.
 */
function addrow() {
    var stockCode = document.getElementById("inputstcode");
    var num = document.getElementById("inputnumofcode");
    var json;
    $.ajax({
        cache:false,
        async:false,
        type:'POST',
        url:'getSTCodeInfo.action',
        data:{
            stockCode: stockCode.value
        },
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    var money = document.getElementById("nowmoney");
    if((Number(money.textContent)-(json['trade'] * Number(num.value))) > 0) {
        var x=document.getElementById('st').insertRow(document.getElementById('st').rows.length);
        var stockName=x.insertCell(0);
        var stockCode=x.insertCell(1);
        var theNumOfStock = x.insertCell(2);
        var theValueOfStock = x.insertCell(3);
        var nowPrice = x.insertCell(4);
        var range = x.insertCell(5);
        var deletedo = x.insertCell(6);
        stockName.innerHTML= json['stockName'];
        stockCode.innerHTML= json['code'];
        theNumOfStock.innerHTML = num.value;
        theValueOfStock.innerHTML = json['trade'] * Number(num.value);
        nowPrice.innerHTML = json['trade'];
        range.innerHTML = json['changePercent'];
        deletedo.innerHTML = "<img src='../../images/deletebutton.png' />";
        deletedo.style.textAlign = "right";
        deletedo.style.cursor = "hand";
        deletedo.onclick = function () {
            document.getElementById('st').deleteRow(x.rowIndex)
            money.innerHTML = Number(money.textContent) + (json['trade'] * Number(num.value));
        }
        money.innerHTML = Number(money.textContent) - (json['trade'] * Number(num.value));
    }else{
        alert("您的资产不足以购买")
    }
}