/**
 * Created by Administrator on 2017/6/10.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:'getIndex.action',
    type:'GET',
    dataType:'json',
    success:function (data) {
        json = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
var date = [];
function drawMACD() {

    var myChart = echarts.init(document.getElementById("index"));

}
function drwaKDJ() {
    
}
function drawRSI() {
    
}
function drawBOLL() {
    
}
function clickMACDbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#003366";
    MACDbutton.style.color = "#FFFFFF";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
}
function clickKDJbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#003366";
    KDJbutton.style.color = "#FFFFFF";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
}
function clickRSIbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#003366";
    RSIbutton.style.color = "#FFFFFF";
    BOLLbutton.style.backgroundColor = "#FFFFFF";
    BOLLbutton.style.color = "#000000";
}
function clickBOLLbutton() {
    var MACDbutton = document.getElementById("MACDbutton");
    var KDJbutton = document.getElementById("KDJbutton");
    var RSIbutton = document.getElementById("RSIbutton");
    var BOLLbutton = document.getElementById("BOLLbutton");
    MACDbutton.style.backgroundColor = "#FFFFFF";
    MACDbutton.style.color = "#000000";
    KDJbutton.style.backgroundColor = "#FFFFFF";
    KDJbutton.style.color = "#000000";
    RSIbutton.style.backgroundColor = "#FFFFFF";
    RSIbutton.style.color = "#000000";
    BOLLbutton.style.backgroundColor = "#003366";
    BOLLbutton.style.color = "#FFFFFF";
}