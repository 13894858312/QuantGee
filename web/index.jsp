<%--
  Created by IntelliJ IDEA.
  User: Mark.W
  Date: 2017/5/5
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%--<head>--%>
  <%--<meta charset="UTF-8">--%>
  <%--<title>FirstPage</title>--%>
  <%--<style type="text/css">--%>
    <%--@import url("css/firstPage.css");--%>
  <%--</style>--%>
  <%--<script>--%>
      <%--function s1(x) {--%>
          <%--x.style.backgroundColor = "#cfcfcf";--%>
          <%--x.style.borderTop = "5px solid #000000";--%>
      <%--}--%>
      <%--function s2(x) {--%>
          <%--x.style.backgroundColor = "transparent";--%>
          <%--x.style.borderTop = "5px solid transparent";--%>
      <%--}--%>
  <%--</script>--%>
<%--</head>--%>
<%--<body background="images/首页.jpg" style="background-repeat:no-repeat ;--%>
    <%--background-size: 100% 100%;--%>
    <%--background-attachment: fixed;">--%>
<%--<div class="box">--%>
  <%--<div class="bar">--%>
    <%--<div class="item1" onmouseover="s1(this)" onmouseout="s2(this)">--%>
      <%--<a href="view/market/marketInfo.jsp">大盘行情</a>--%>
    <%--</div>--%>
    <%--<div class="item2" onmouseover="s1(this)" onmouseout="s2(this)">--%>
      <%--<a href="">个股信息</a>--%>
    <%--</div>--%>
    <%--<div class="item3" onmouseover="s1(this)" onmouseout="s2(this)">--%>
      <%--<a href="">板块资讯</a>--%>
    <%--</div>--%>
  <%--</div>--%>
  <%--<div class="text-left">--%>
    <%--<span class="left">My</span>--%>
  <%--</div>--%>
  <%--<div class="text-right">--%>
    <%--<span class="right">QuantGee</span>--%>
  <%--</div>--%>


<%--</div>--%>
<%--</body>--%>
<head>
    <title>test</title>
    <script src="jquery-3.2.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function getJson() {
            $.ajax({
                url:'ajax.action',
                dataType:'json',
                type:'get',
                data:'string',
                success:function (data) {
                    alert(success + data);
                },
                error:function (data) {
                    alert(error + data);
                }
            })
        }
    </script>
</head>
<body>
    <input type="button" value="json" onclick="getJson()">
</body>
</html>