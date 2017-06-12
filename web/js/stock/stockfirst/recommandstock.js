/**
 * Created by Administrator on 2017/6/12.
 */
var firstStock;
var secondStock;
var thirdStock;
var stockArray;
$.ajax({
    cache:false,
    async:false,
    url:'getRecommandStock.action',
    dataType:'json',
    type:'GET',
    success:function (data) {
        stockArray = JSON.parse(data);
    },
    error:function (data) {
        alert("error");
    }
});
firstStock = stockArray[0];
secondStock = stockArray[1];
thirdStock = stockArray[2];