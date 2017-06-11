/**
 * Created by Administrator on 2017/6/11.
 */
$(function() {
    var stock = [];
    $.ajax({
        cache:false,
        async:false,
        url:'getBOLLKlineInfo.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            kline = JSON.parse(data);
        }
    });
    test.push("Core");
    var data = "Core Selectors Attributes Traversing Manipulation CSS Events Effects Ajax Utilities".split(" ");

    $('#keyword').autocomplete(test).result(function(event, data, formatted) {
        alert(test);
    });
});