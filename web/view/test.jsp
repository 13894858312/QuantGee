<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<html>
 <head>
 <title>AutoComplate</title>
      <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
     <script type="text/javascript" src="../js/jquery.autocomplete.js"></script>
      <link rel="Stylesheet" href="../css/jquery.autocomplete.css" />
      <script type="text/javascript">
          $(function() {
          var test = [];
          test.push("Core");
             var data = "Core Selectors Attributes Traversing Manipulation CSS Events Effects Ajax Utilities".split(" ");
 
             $('#keyword').autocomplete(test).result(function(event, data, formatted) {
                 alert(test);
             });
         });
     </script>
 </head>
 <body>
     <div>
         <input id="keyword" />
         <input id="getValue" value="GetValue" type="button" />
     </div>
 </body>
 </html>-->
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JQ利用jPages.js实现完美分页</title>
<script src="../jquery-3.2.1.min.js"></script>
<script src="../js/jPages.min.js"></script>
<script>
    /* when document is ready */
    $(function(){
    
        /* initiate the plugin */
        $("div.holder").jPages({
            containerID  : "st",
   first: '首页',
   last: '尾页',
   previous: '上页',
   next: '下页',
   perPage: 1
// startPage: 1,
// startRange: 2,
//  midRange: 3,
//  endRange: 2
// animation: 'wobble'
// keyBrowse: true
// callback    : function( pages, items){
      
//    $("#page-panel").html("当前页面:" + pages.current);
//    $("#page-pane2").html("页面总数:" + pages.count);
//    $("#page-pane3").html("总数量:" + items.count);
//     $("#page-pane4").html("每页数量:" + items.count/pages.count);


// }
        });
    
    });
</script>

</head>

<body>
 <table class="st" id="st">
    		<!--<tr>
    			<td class="stth">股票名称</td>
    			<td class="stth">股票代码</td>
    			<td class="stth">买入/卖出</td>
    			<td class="stth">股数</td>
    			<td class="stth">交易价格</td>
    			<td class="stth">交易时间</td>
    		</tr>-->
    	</table>
 
  
</ul>


<div class="holder" style="float:left"></div>
<!--<div style="float:left;margin: 15px 2px;">
<span id="page-panel"></span>
<span id="page-pane2"></span>
<span id="page-pane3"></span>
<span id="page-pane4"></span>-->
<!--</div>-->

 

</body>
</html>
