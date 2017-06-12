/**
 * Created by Administrator on 2017/6/12.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:'getMKRBInfo.action',
    type:'GET',
    dataType:'json',
    success:function (data) {
        json = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
$("#macdcontent").text(json['macdAnalysis']);
$("#rsicontent").text(json['rsiAnalysis']);
$("#kdjcontent").text(json['kdjAnalysis']);
$("#bollcontent").text(json['bollAnalysis']);
