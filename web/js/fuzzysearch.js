/**
 * Created by Administrator on 2017/6/11.
 */
$(function() {
    var stock = [];
    var json;
    $.ajax({
        cache:false,
        async:false,
        url:'getAllStock.action',
        type:'GET',
        dataType:'json',
        success:function (data) {
            json = JSON.parse(data);
        }
    });
    for(var i=0;i<json.length;i++){
        stock.push(json[i]);
    }

    $('#inputStockCode').autocomplete(stock,{width:200,max:5,cacheLength: 5,scroll: true}).result(function(event, data, formatted) {
    });
});