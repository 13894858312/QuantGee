/**
 * Created by Administrator on 2017/6/10.
 */
function addrow() {
    var x=document.getElementById('st').insertRow(1);
    var stockName=x.insertCell(0);
    var stockCode=x.insertCell(1);
    var theNumOfStock = x.insertCell(2);
    var theValueOfStock = x.insertCell(3);
    var nowPrice = x.insertCell(4);
    var range = x.insertCell(5);
    var deletedo = x.insertCell(6);
    stockName.innerHTML="平安银行";
    stockCode.innerHTML="000001";
    theNumOfStock.innerHTML = "2000";
    theValueOfStock.innerHTML = "16800";
    nowPrice.innerHTML = "8.40";
    range.innerHTML = "-0.83%";
    deletedo.innerHTML = "<img src='../../images/addbutton.png' />";
    deletedo.style.textAlign = "right";
}