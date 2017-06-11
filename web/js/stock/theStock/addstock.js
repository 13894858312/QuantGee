/**
 * Created by Administrator on 2017/6/12.
 */
function addstock() {
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
        var stockname = document.getElementById("tsname");
        for(var i=0;i<json.length;i++){
            if(stockname.textContent == json[i]['stockName']){
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
                    stockName:stockname.textContent
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