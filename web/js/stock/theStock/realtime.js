/**
 * Created by Administrator on 2017/6/11.
 */
var json;
$.ajax({
    cache:false,
    async:false,
    url:'getRealTimeInfo.action',
    type:'GET',
    dataType:'json',
    success:function (data) {

    },
    error:function (data) {
        alert("error");
    }

})