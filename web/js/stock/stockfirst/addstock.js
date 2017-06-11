/**
 * Created by Administrator on 2017/6/12.
 */
var stockName;
function firstAddStock() {
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
    }else{
        var json;
        $.ajax({
            type: 'post',
            url: 'getCollectStock.action',
            async: false,
            dataType: 'json',
            data:{
                accountID:accountID
            },
            success: function (data) {
                json = JSON.parse(data);
            },
            error: function (data) {
                alert("error");
            }
        });
        var tag = 0;
        for(var i=0;i<json.length;i++){
            if(stockName.textContent == json[i]['stockName']){
                swal("已收藏该股票","去看看别的股票吧");
                tag = 1;
                break;
            }
        }
        if(tag == 0){
            var result;
            $.ajax({
                cache:false,
                async:false,
                url:'addCollectedStock.action',
                type:'POST',
                dataType:'json',
                data:{
                    accountID:accountID,
                    stockName:stockName.textContent
                },
                success:function (data) {
                    result = JSON.parse(data);
                },
                error:function (data) {
                    alert("error");
                }
            });
            if(result[0] == "success"){
                swal("收藏成功","","success");
            }else{
                swal("收藏失败","","error");
            }
        }
    }
}
function getNamediv1() {
    stockName = document.getElementById("r1c1div");
    firstAddStock();
}
function getNamediv2() {
    stockName = document.getElementById("r2c1div");
    firstAddStock();
}
function getNamediv3() {
    stockName = document.getElementById("r3c1div");
    firstAddStock();
}
function getNamediv4() {
    stockName = document.getElementById("r4c1div");
    firstAddStock();
}
function getNamediv5() {
    stockName = document.getElementById("r5c1div");
    firstAddStock();
}
function getNamediv6() {
    stockName = document.getElementById("r6c1div");
    firstAddStock();
}
function getNamediv7() {
    stockName = document.getElementById("r7c1div");
    firstAddStock();
}
function getNamediv8() {
    stockName = document.getElementById("r8c1div");
    firstAddStock();
}
function getNamediv9() {
    stockName = document.getElementById("r9c1div");
    firstAddStock();
}
function getNamediv10() {
    stockName = document.getElementById("r10c1div");
    firstAddStock();
}