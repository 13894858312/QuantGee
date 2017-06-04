/**
 * Created by Administrator on 2017/6/3.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:"risedownList.action",
    type:"GET",
    dataType:'json',
    success:function (data) {
        json = JSON.parse(data);
    },
    error:function (data) {
        alert("error")
    }
});
var name = json['stockName'];
$("#irise11").text(name);