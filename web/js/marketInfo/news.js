/**
 * Created by Administrator on 2017/6/3.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:'getnews.action',
    type:'GET',
    dataType:'json',
    success:function (data) {
        json = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
$("#zqcj1").text(json[0]['title']);
$("#zqcj2").text(json[1]['title']);
$("#zqcj3").text(json[2]['title']);
$("#zqcj1").attr("href", json[0]['url']);
$("#zqcj2").attr("href", json[1]['url']);
$("#zqcj3").attr("href", json[2]['url']);
