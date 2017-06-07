/**
 * Created by Administrator on 2017/6/6.
 */
function changemouse() {
    var button1 = document.getElementById("daybutton");
    var button2 = document.getElementById("weekbutton");
    var button3 = document.getElementById("monthbutton");
    button1.style.cursor = "hand";
    button2.style.cursor = "hand";
    button3.style.cursor = "hand";
}
function showDayKline() {
    var kline1 = document.getElementById("daykline");
    var kline2 = document.getElementById("weekkline");
    var kline3 = document.getElementById("monthkline");
    var volume1 = document.getElementById("dayvolume");
    var volume2 = document.getElementById("weekvolume");
    var volume3 = document.getElementById("monthvolume");
    var button1 = document.getElementById("daybutton");
    var button2 = document.getElementById("weekbutton");
    var button3 = document.getElementById("monthbutton");
    kline1.style.display = "block";
    kline2.style.display = "none";
    kline3.style.display = "none";
    volume1.style.display = "block";
    volume2.style.display = "none";
    volume3.style.display = "none";
    button1.style.backgroundColor = "#6C7B8B";
    button1.style.color = "#FFFFFF";
    button2.style.backgroundColor = "#FFFFFF";
    button2.style.color = "#000000";
    button3.style.backgroundColor = "#FFFFFF";
    button3.style.color = "#000000";
}
function showWeekKline() {
    var kline1 = document.getElementById("daykline");
    var kline2 = document.getElementById("weekkline");
    var kline3 = document.getElementById("monthkline");
    var button1 = document.getElementById("daybutton");
    var button2 = document.getElementById("weekbutton");
    var button3 = document.getElementById("monthbutton");
    var volume1 = document.getElementById("dayvolume");
    var volume2 = document.getElementById("weekvolume");
    var volume3 = document.getElementById("monthvolume");
    kline1.style.display = "none";
    kline2.style.display = "block";
    kline3.style.display = "none";
    volume1.style.display = "none";
    volume2.style.display = "block";
    volume3.style.display = "none";
    button1.style.backgroundColor = "#FFFFFF";
    button1.style.color = "#000000";
    button2.style.backgroundColor = "#6C7B8B";
    button2.style.color = "#FFFFFF";
    button3.style.backgroundColor = "#FFFFFF";
    button3.style.color = "#000000";
}

function showMonthKline() {
    var kline1 = document.getElementById("daykline");
    var kline2 = document.getElementById("weekkline");
    var kline3 = document.getElementById("monthkline");
    var button1 = document.getElementById("daybutton");
    var button2 = document.getElementById("weekbutton");
    var button3 = document.getElementById("monthbutton");
    var volume1 = document.getElementById("dayvolume");
    var volume2 = document.getElementById("weekvolume");
    var volume3 = document.getElementById("monthvolume");
    kline1.style.display = "none";
    kline2.style.display = "none";
    kline3.style.display = "block";
    volume1.style.display = "none";
    volume2.style.display = "none";
    volume3.style.display = "block";
    button1.style.backgroundColor = "#FFFFFF";
    button1.style.color = "#000000";
    button2.style.backgroundColor = "#FFFFFF";
    button2.style.color = "#000000";
    button3.style.backgroundColor = "#6C7B8B";
    button3.style.color = "#FFFFFF";
}