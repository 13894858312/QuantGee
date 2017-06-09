/**
 * Created by Administrator on 2017/6/9.
 */
function showrow(obj) {
    var rowborder = document.getElementsByClassName("row");
    for(var i=0;i<rowborder.length;i++){
        rowborder[i].style.borderRight = "2px solid #FFFFFF";
    }
    var row = document.getElementById(obj.id);
    row.style.borderRight = "2px solid #C0C0C0";
}
function changeChart() {
    var obj = document.getElementById('r1c1a');
    var stockName = obj.text;
    $.ajax({
        cache:false,
        async:false,
        url:'getWebStockName.action',
        type:'POST',
        dataType:'json',
        data:{
            stockName:stockName
        },
        success:function (data) {
            alert(data)
        },
        error:function (data) {
            alert("error")
        }
    });

}