/**
 * Created by Administrator on 2017/6/7.
 */
function judgeLogin() {
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
        document.getElementById("la").innerHTML = "登录";
    }else{
        document.getElementById("la").innerHTML = "退出";
        document.getElementById("a5").href = "../../view/ucenter/user_center.jsp";
        document.getElementById("a5").style.color = "#000000";
        document.getElementById("a5").onmouseup = function () {
            document.getElementById("a5").style.color = "rgb(62, 196, 131)";
        }
        document.getElementById("a5").onmousedown = function () {
            document.getElementById("a5").style.color = "#000000";
        }
    }
}
function changewhole1() {
    var ha1 = document.getElementById("ha1");
    var a1 = document.getElementById("a1");
    a1.style.color = "rgb(62, 196, 131)";
    ha1.style.borderBottom = "2px solid rgb(62, 196, 131)";
    judgeLogin();
}
function changewhole2() {
    var ha2 = document.getElementById("ha2");
    var a2 = document.getElementById("a2");
    a2.style.color = "rgb(62, 196, 131)";
    ha2.style.borderBottom = "2px solid rgb(62, 196, 131)";
    judgeLogin();
}
function changewhole3() {
    var ha3 = document.getElementById("ha3");
    var a3 = document.getElementById("a3");
    a3.style.color = "rgb(62, 196, 131)";
    ha3.style.borderBottom = "2px solid rgb(62, 196, 131)";
    judgeLogin();
}
function changewhole4() {
    var ha4 = document.getElementById("ha4");
    var a4 = document.getElementById("a4");
    a4.style.color = "rgb(62, 196, 131)";
    ha4.style.borderBottom = "2px solid rgb(62, 196, 131)";
    judgeLogin();
}
function changewhole5() {
    var ha5 = document.getElementById("ha5");
    var a5 = document.getElementById("a5");
    a5.style.color = "rgb(62, 196, 131)";
    ha5.style.borderBottom = "2px solid rgb(62, 196, 131)";
}
function totheStockView() {
    var code = document.getElementById("inputStockCode");
    $.ajax({
        cache:false,
        async:false,
        url:'totheStock.action',
        type:'POST',
        dataType:'json',
        data:{
          stockCode: code.value
        },
        success:function (data) {
            window.location.href = '../../view/stock/theStock.jsp';
        },
        error:function (data) {
            alert("error")
        }
    });
}