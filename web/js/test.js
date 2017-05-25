/**
 * Created by Administrator on 2017/5/17.
 */
    function test() {
    $.ajax({
        url:"ajax.action",
        type:'GET',
        dataType:'json',
        success:function (data) {
            alert(data);
        },
        error:function (data) {
            alert("error");
        }
    })
}