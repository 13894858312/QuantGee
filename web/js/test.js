/**
 * Created by Administrator on 2017/5/17.
 */
    function test() {
    $.ajax({
        url:"ajax.action",
        type:'GET',
        dataType:'json',
        success:function (data) {
            var test = JSON.parse(data);
            var str1 = test[0];
            alert();
        },
        error:function (data) {
            alert("error");
        }
    })
}