/**
 * Created by Administrator on 2017/5/17.
 */
    function getJson() {
        $.post(
            "/struts2/getjsons.action",{},function(returnedData,status)
            {
                if("success"==status)
                {
                    alert(returnedData);
                }
            }
        )
    }