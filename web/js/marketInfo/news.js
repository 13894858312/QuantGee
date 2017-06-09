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
$("#gncj1").text(json[3]['title']);
$("#gncj2").text(json[4]['title']);
$("#gncj3").text(json[5]['title']);
$("#gncj1").attr("href", json[3]['url']);
$("#gncj2").attr("href", json[4]['url']);
$("#gncj3").attr("href", json[5]['url']);
$("#mgwh1").text(json[6]['title']);
$("#mgwh2").text(json[7]['title']);
$("#mgwh3").text(json[8]['title']);
$("#mgwh1").attr("href", json[6]['url']);
$("#mgwh2").attr("href", json[7]['url']);
$("#mgwh3").attr("href", json[8]['url']);
$("#zqcj11").text(json[10]['title']);
$("#zqcj22").text(json[11]['title']);
$("#zqcj33").text(json[12]['title']);
$("#zqcj11").attr("href", json[10]['url']);
$("#zqcj22").attr("href", json[11]['url']);
$("#zqcj33").attr("href", json[12]['url']);
$("#gncj11").text(json[13]['title']);
$("#gncj22").text(json[14]['title']);
$("#gncj33").text(json[15]['title']);
$("#gncj11").attr("href", json[13]['url']);
$("#gncj22").attr("href", json[14]['url']);
$("#gncj33").attr("href", json[15]['url']);
$("#mgwh11").text(json[16]['title']);
$("#mgwh22").text(json[17]['title']);
$("#mgwh33").text(json[18]['title']);
$("#mgwh11").attr("href", json[16]['url']);
$("#mgwh22").attr("href", json[17]['url']);
$("#mgwh33").attr("href", json[18]['url']);
