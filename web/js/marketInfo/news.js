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

$("#l1").text(json[0]['title']);
$("#l2").text(json[1]['title']);
$("#l3").text(json[2]['title']);
$("#l4").text(json[3]['title']);
$("#l5").text(json[4]['title']);
$("#l1").attr("href", json[0]['url']);
$("#l2").attr("href", json[1]['url']);
$("#l3").attr("href", json[2]['url']);
$("#l4").attr("href", json[3]['url']);
$("#l5").attr("href", json[4]['url']);
$("#lt1").text(json[0]['time']);
$("#lt2").text(json[1]['time']);
$("#lt3").text(json[2]['time']);
$("#lt4").text(json[3]['time']);
$("#lt5").text(json[4]['time']);

$("#r1").text(json[5]['title']);
$("#r2").text(json[6]['title']);
$("#r3").text(json[7]['title']);
$("#r4").text(json[8]['title']);
$("#r5").text(json[9]['title']);
$("#r1").attr("href", json[5]['url']);
$("#r2").attr("href", json[6]['url']);
$("#r3").attr("href", json[7]['url']);
$("#r4").attr("href", json[8]['url']);
$("#r5").attr("href", json[9]['url']);
$("#rt1").text(json[5]['time']);
$("#rt2").text(json[6]['time']);
$("#rt3").text(json[7]['time']);
$("#rt4").text(json[8]['time']);
$("#rt5").text(json[9]['time']);