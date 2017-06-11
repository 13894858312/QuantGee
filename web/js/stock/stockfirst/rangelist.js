/**
 * Created by Administrator on 2017/6/11.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:'upStockList.action',
    dataType:'json',
    type:'GET',
    success:function (data) {
        json = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
$("#r1c1div").text(json[0]['name']);
$("#r1c2div").text(json[0]['increaseRate']);
$("#r1c3div").text(json[0]['nowPrice']);
$("#r2c1div").text(json[1]['name']);
$("#r2c2div").text(json[1]['increaseRate']);
$("#r2c3div").text(json[1]['nowPrice']);
$("#r3c1div").text(json[2]['name']);
$("#r3c2div").text(json[2]['increaseRate']);
$("#r3c3div").text(json[2]['nowPrice']);
$("#r4c1div").text(json[3]['name']);
$("#r4c2div").text(json[3]['increaseRate']);
$("#r4c3div").text(json[3]['nowPrice']);
$("#r5c1div").text(json[4]['name']);
$("#r5c2div").text(json[4]['increaseRate']);
$("#r5c3div").text(json[4]['nowPrice']);
$("#r6c1div").text(json[5]['name']);
$("#r6c2div").text(json[5]['increaseRate']);
$("#r6c3div").text(json[5]['nowPrice']);
$("#r7c1div").text(json[6]['name']);
$("#r7c2div").text(json[6]['increaseRate']);
$("#r7c3div").text(json[6]['nowPrice']);
$("#r8c1div").text(json[7]['name']);
$("#r8c2div").text(json[7]['increaseRate']);
$("#r8c3div").text(json[7]['nowPrice']);
$("#r9c1div").text(json[8]['name']);
$("#r9c2div").text(json[8]['increaseRate']);
$("#r9c3div").text(json[8]['nowPrice']);
$("#r10c1div").text(json[9]['name']);
$("#r10c2div").text(json[9]['increaseRate']);
$("#r10c3div").text(json[9]['nowPrice']);
$.ajax({
    cache:false,
    async:false,
    url:'getWebStockName.action',
    dataType:'json',
    type:'POST',
    data:{
        stockCode: json[0]['code'],
        stockName: json[0]['name']
    },
    success:function (data) {
    },
    error:function (data) {
        alert("error");
    }
});