/**
 * Created by PC on 2017/6/14.
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
	
	 $('#inputStockCode').autocomplete(stock,{width:195,cacheLength: 5,scroll:false}).result(function(event, data, formatted) {
    });
    $('#searchStock').autocomplete(stock,{width:215,cacheLength: 5,scroll:false}).result(function(event, data, formatted) {
    });
});