/**
 * Created by Administrator on 2017/6/5.
 */
var intervalTime = 180000;
var taskId;
ajax();
setInterval(ajax,intervalTime);
function ajax() {
    var stockUp;
    $.ajax({
        cache:false,
        async:false,
        url:"upStockList.action",
        type:"GET",
        dataType:'json',
        success:function (data) {
            stockUp = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $("#srise11").text(stockUp[0]['name']);
    $("#srise21").text(stockUp[1]['name']);
    $("#srise31").text(stockUp[2]['name']);
    $("#srise41").text(stockUp[3]['name']);
    $("#srise51").text(stockUp[4]['name']);
    $("#srise61").text(stockUp[5]['name']);
    $("#srise71").text(stockUp[6]['name']);
    $("#srise81").text(stockUp[7]['name']);
    $("#srise91").text(stockUp[8]['name']);
    $("#srise101").text(stockUp[9]['name']);
    $("#srise111").text(stockUp[10]['name']);
    $("#srise121").text(stockUp[11]['name']);
    $("#srise131").text(stockUp[12]['name']);
    $("#srise141").text(stockUp[13]['name']);
    $("#srise151").text(stockUp[14]['name']);
    $("#srise12").text(stockUp[0]['increaseRate']);
    $("#srise22").text(stockUp[1]['increaseRate']);
    $("#srise32").text(stockUp[2]['increaseRate']);
    $("#srise42").text(stockUp[3]['increaseRate']);
    $("#srise52").text(stockUp[4]['increaseRate']);
    $("#srise62").text(stockUp[5]['increaseRate']);
    $("#srise72").text(stockUp[6]['increaseRate']);
    $("#srise82").text(stockUp[7]['increaseRate']);
    $("#srise92").text(stockUp[8]['increaseRate']);
    $("#srise102").text(stockUp[9]['increaseRate']);
    $("#srise112").text(stockUp[10]['increaseRate']);
    $("#srise122").text(stockUp[11]['increaseRate']);
    $("#srise132").text(stockUp[12]['increaseRate']);
    $("#srise142").text(stockUp[13]['increaseRate']);
    $("#srise152").text(stockUp[14]['increaseRate']);
    $("#srise13").text(stockUp[0]['nowPrice']);
    $("#srise23").text(stockUp[1]['nowPrice']);
    $("#srise33").text(stockUp[2]['nowPrice']);
    $("#srise43").text(stockUp[3]['nowPrice']);
    $("#srise53").text(stockUp[4]['nowPrice']);
    $("#srise63").text(stockUp[5]['nowPrice']);
    $("#srise73").text(stockUp[6]['nowPrice']);
    $("#srise83").text(stockUp[7]['nowPrice']);
    $("#srise93").text(stockUp[8]['nowPrice']);
    $("#srise103").text(stockUp[9]['nowPrice']);
    $("#srise113").text(stockUp[10]['nowPrice']);
    $("#srise123").text(stockUp[11]['nowPrice']);
    $("#srise133").text(stockUp[12]['nowPrice']);
    $("#srise143").text(stockUp[13]['nowPrice']);
    $("#srise153").text(stockUp[14]['nowPrice']);

    var stockDown;
    $.ajax({
        cache:false,
        async:false,
        url:"downStockList.action",
        type:"GET",
        dataType:'json',
        success:function (data) {
            stockDown = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $("#sdown11").text(stockDown[0]['name']);
    $("#sdown21").text(stockDown[1]['name']);
    $("#sdown31").text(stockDown[2]['name']);
    $("#sdown41").text(stockDown[3]['name']);
    $("#sdown51").text(stockDown[4]['name']);
    $("#sdown61").text(stockDown[5]['name']);
    $("#sdown71").text(stockDown[6]['name']);
    $("#sdown81").text(stockDown[7]['name']);
    $("#sdown91").text(stockDown[8]['name']);
    $("#sdown101").text(stockDown[9]['name']);
    $("#sdown111").text(stockDown[10]['name']);
    $("#sdown121").text(stockDown[11]['name']);
    $("#sdown131").text(stockDown[12]['name']);
    $("#sdown141").text(stockDown[13]['name']);
    $("#sdown151").text(stockDown[14]['name']);
    $("#sdown12").text(stockDown[0]['increaseRate']);
    $("#sdown22").text(stockDown[1]['increaseRate']);
    $("#sdown32").text(stockDown[2]['increaseRate']);
    $("#sdown42").text(stockDown[3]['increaseRate']);
    $("#sdown52").text(stockDown[4]['increaseRate']);
    $("#sdown62").text(stockDown[5]['increaseRate']);
    $("#sdown72").text(stockDown[6]['increaseRate']);
    $("#sdown82").text(stockDown[7]['increaseRate']);
    $("#sdown92").text(stockDown[8]['increaseRate']);
    $("#sdown102").text(stockDown[9]['increaseRate']);
    $("#sdown112").text(stockDown[10]['increaseRate']);
    $("#sdown122").text(stockDown[11]['increaseRate']);
    $("#sdown132").text(stockDown[12]['increaseRate']);
    $("#sdown142").text(stockDown[13]['increaseRate']);
    $("#sdown152").text(stockDown[14]['increaseRate']);
    $("#sdown13").text(stockDown[0]['nowPrice']);
    $("#sdown23").text(stockDown[1]['nowPrice']);
    $("#sdown33").text(stockDown[2]['nowPrice']);
    $("#sdown43").text(stockDown[3]['nowPrice']);
    $("#sdown53").text(stockDown[4]['nowPrice']);
    $("#sdown63").text(stockDown[5]['nowPrice']);
    $("#sdown73").text(stockDown[6]['nowPrice']);
    $("#sdown83").text(stockDown[7]['nowPrice']);
    $("#sdown93").text(stockDown[8]['nowPrice']);
    $("#sdown103").text(stockDown[9]['nowPrice']);
    $("#sdown113").text(stockDown[10]['nowPrice']);
    $("#sdown123").text(stockDown[11]['nowPrice']);
    $("#sdown133").text(stockDown[12]['nowPrice']);
    $("#sdown143").text(stockDown[13]['nowPrice']);
    $("#sdown153").text(stockDown[14]['nowPrice']);
}