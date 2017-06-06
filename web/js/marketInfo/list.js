/**
 * Created by Administrator on 2017/6/3.
 */
var intervalTime = 180000;
var taskId;
alert("success");
ajax();
setInterval(ajax,intervalTime);
function ajax() {
    var industryUp;
    $.ajax({
        cache:false,
        async:false,
        url:"riseIndustryList.action",
        type:"GET",
        dataType:'json',
        success:function (data) {
            industryUp = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $("#irise11").text(industryUp[0]['name']);
    $("#irise21").text(industryUp[1]['name']);
    $("#irise31").text(industryUp[2]['name']);
    $("#irise41").text(industryUp[3]['name']);
    $("#irise51").text(industryUp[4]['name']);
    $("#irise61").text(industryUp[5]['name']);
    $("#irise71").text(industryUp[6]['name']);
    $("#irise81").text(industryUp[7]['name']);
    $("#irise91").text(industryUp[8]['name']);
    $("#irise101").text(industryUp[9]['name']);
    $("#irise12").text(industryUp[0]['increaseRate']);
    $("#irise22").text(industryUp[1]['increaseRate']);
    $("#irise32").text(industryUp[2]['increaseRate']);
    $("#irise42").text(industryUp[3]['increaseRate']);
    $("#irise52").text(industryUp[4]['increaseRate']);
    $("#irise62").text(industryUp[5]['increaseRate']);
    $("#irise72").text(industryUp[6]['increaseRate']);
    $("#irise82").text(industryUp[7]['increaseRate']);
    $("#irise92").text(industryUp[8]['increaseRate']);
    $("#irise102").text(industryUp[9]['increaseRate']);
    $("#irise13").text(industryUp[0]['topName']);
    $("#irise23").text(industryUp[1]['topName']);
    $("#irise33").text(industryUp[2]['topName']);
    $("#irise43").text(industryUp[3]['topName']);
    $("#irise53").text(industryUp[4]['topName']);
    $("#irise63").text(industryUp[5]['topName']);
    $("#irise73").text(industryUp[6]['topName']);
    $("#irise83").text(industryUp[7]['topName']);
    $("#irise93").text(industryUp[8]['topName']);
    $("#irise103").text(industryUp[9]['topName']);

    var industryDown;
    $.ajax({
        cache:false,
        async:false,
        url:"downIndustryList.action",
        type:"GET",
        dataType:'json',
        success:function (data) {
            industryDown = JSON.parse(data);
        },
        error:function (data) {
            alert("error")
        }
    });
    $("#idown11").text(industryDown[0]['name']);
    $("#idown21").text(industryDown[1]['name']);
    $("#idown31").text(industryDown[2]['name']);
    $("#idown41").text(industryDown[3]['name']);
    $("#idown51").text(industryDown[4]['name']);
    $("#idown61").text(industryDown[5]['name']);
    $("#idown71").text(industryDown[6]['name']);
    $("#idown81").text(industryDown[7]['name']);
    $("#idown91").text(industryDown[8]['name']);
    $("#idown101").text(industryDown[9]['name']);
    $("#idown12").text(industryDown[0]['increaseRate']);
    $("#idown22").text(industryDown[1]['increaseRate']);
    $("#idown32").text(industryDown[2]['increaseRate']);
    $("#idown42").text(industryDown[3]['increaseRate']);
    $("#idown52").text(industryDown[4]['increaseRate']);
    $("#idown62").text(industryDown[5]['increaseRate']);
    $("#idown72").text(industryDown[6]['increaseRate']);
    $("#idown82").text(industryDown[7]['increaseRate']);
    $("#idown92").text(industryDown[8]['increaseRate']);
    $("#idown102").text(industryDown[9]['increaseRate']);
    $("#idown13").text(industryDown[0]['topName']);
    $("#idown23").text(industryDown[1]['topName']);
    $("#idown33").text(industryDown[2]['topName']);
    $("#idown43").text(industryDown[3]['topName']);
    $("#idown53").text(industryDown[4]['topName']);
    $("#idown63").text(industryDown[5]['topName']);
    $("#idown73").text(industryDown[6]['topName']);
    $("#idown83").text(industryDown[7]['topName']);
    $("#idown93").text(industryDown[8]['topName']);
    $("#idown103").text(industryDown[9]['topName']);

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
}

