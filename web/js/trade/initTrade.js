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
        url: 'haveLogin.action',
        async: false,
        dataType: 'json',
        data:{
            accountID: accountID,
        },
        success: function (data) {
            tradeInfoArray = JSON.parse(data);
        },
        error: function (data) {
            alert("error");
        }
    });
    for (var i=0;i<tradeInfoArray.length;i++){

    }
}