/**
 * Created by Administrator on 2017/5/17.
 */
    function test() {
    $.ajax({
        url:"ajax.action",
        type:'GET',
        dataType:'json',
        success:function (data) {
            var str;
            var json = eval(data);
            for (var i=0; i<json.length;i++){
                for(var key in json[i]){
                    alert("key == " + key + " ;value == " + json[i][key]);
                }
            }
        },
        error:function (data) {
            alert("error");
        }
    })
}
