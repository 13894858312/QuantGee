<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	  <meta charset="UTF-8">
    <title>Industry</title>
    <script>
        function s1(x) {
            x.style.fontWeight = "bold";
            x.style.color = "#fff";
        }
        function s2(x) {
            x.style.fontWeight = "400";
            x.style.color = "#b7b7b7";
        }
    </script>
    <style type="text/css">
    	@import "../../css/style.css";
    	@import "../../css/industry/industry.css";
    </style>
</head>
<body>
	<div class="header fixed">

        <div class="w1200">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href=""> <img src="../../images/theLogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a href="../../view/market/marketInfo.jsp" onmouseover="s1(this)" target="_blank" onmouseout="s2(this)">大盘行情</a>
                <a href="../../view/stock/stockFirst.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a href="industry.jsp" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
                <a href="../../view/strategy/strategy.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
                <a href="../../view/trade/trade.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
                <a href="../../view/ucenter/user_center.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

            </div>

            <div class="login-box">

                <a href="../../view/ucenter/login.jsp" target="_blank">登录</a>

            </div>

            <div class="logined_box hide fr">

                <a href="http://stock.10jqka.com.cn/my/" target="_blank" id="J_username" style="background-position: 100% 40px;">linhanzi</a>

                <span>|</span>

                <a href="javascript:;" id="header_logined_out" target="_self" class="homeloginout">退出</a>

            </div>

        </div>

    </div>
    <div class="leftrange">
    	<span class="leftrangehead">行业涨跌榜</span>
    </div>
    <div class="industry-left">
    	<table class="industryTable">
            <thead class="industryHead">
                <tr>
                    <th style="width:75px;font-weight: 100;" align="center">行业</th>
                    <th style="width:65px;font-weight: 100;" align="center">涨幅</th>
                    <th style="width:90px;font-weight: 100;" align="center">领涨股</th>
                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
                    <th style="width: 10px;"></th>
                </tr>
            </thead>
            <tbody class="industryBody-rise">
            	<tr>
            		<td class="industryBody-rise-td1" >
            			<a id="irise11" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise12">9.9%</td>
                    <td class="industryBody-rise-td3" id="irise13">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise21" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise22">8%</td>
                    <td class="industryBody-rise-td3" id="irise23">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise31" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise32">8%</td>
                    <td class="industryBody-rise-td3" id="irise33">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise41" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise42">8%</td>
                    <td class="industryBody-rise-td3" id="irise43">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise51" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise52">8%</td>
                    <td class="industryBody-rise-td3" id="irise53">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise61" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise62">8%</td>
                    <td class="industryBody-rise-td3" id="irise63">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise71" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise72">8%</td>
                    <td class="industryBody-rise-td3" id="irise73">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise81" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise82">8%</td>
                    <td class="industryBody-rise-td3" id="irise83">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise91" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise92">8%</td>
                    <td class="industryBody-rise-td3" id="irise93">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise101" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise102">8%</td>
                    <td class="industryBody-rise-td3" id="irise103">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise111" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise112">8%</td>
                    <td class="industryBody-rise-td3" id="irise113">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise121" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise122">8%</td>
                    <td class="industryBody-rise-td3" id="irise123">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise131" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise132">8%</td>
                    <td class="industryBody-rise-td3" id="irise133">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise141" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise142">8%</td>
                    <td class="industryBody-rise-td3" id="irise143">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-rise-td1">
            			<a id="irise151" href="">电子信息</a>
            		</td>
                    <td class="industryBody-rise-td2" id="irise152">8%</td>
                    <td class="industryBody-rise-td3" id="irise153">中孚信息</td>
                    <td class="industryBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            </tbody>
        </table>
    </div>
    <div class="industry-right">
    	<table class="industryTable">
            <thead class="industryHead">
                <tr>
                    <th style="width:75px;font-weight: 100;" align="center">行业</th>
                    <th style="width:65px;font-weight: 100;" align="center">跌幅</th>
                    <th style="width:90px;font-weight: 100;" align="center">领跌股</th>
                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
                    <th style="width: 10px;"></th>
                </tr>
            </thead>
            <tbody class="industryBody-down">
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown11" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown12">8%</td>
                    <td class="industryBody-down-td3" id="idown13">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown21" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown22">8%</td>
                    <td class="industryBody-down-td3" id="idown23">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown31" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown32">8%</td>
                    <td class="industryBody-down-td3" id="idown33">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown41" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown42">8%</td>
                    <td class="industryBody-down-td3" id="idown43">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown51" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown52">8%</td>
                    <td class="industryBody-down-td3" id="idown53">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown61" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown62">8%</td>
                    <td class="industryBody-down-td3" id="idown63">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown71" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown72">8%</td>
                    <td class="industryBody-down-td3" id="idown73">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown81" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown82">8%</td>
                    <td class="industryBody-down-td3" id="idown83">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown91" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown92">8%</td>
                    <td class="industryBody-down-td3" id="idown93">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown101" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown102">8%</td>
                    <td class="industryBody-down-td3" id="idown103">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown111" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown112">8%</td>
                    <td class="industryBody-down-td3" id="idown113">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown121" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown122">8%</td>
                    <td class="industryBody-down-td3" id="idown123">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown131" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown132">8%</td>
                    <td class="industryBody-down-td3" id="idown133">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown141" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown142">8%</td>
                    <td class="industryBody-down-td3" id="idown143">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="industryBody-down-td1">
            			<a id="idown151" href="">电子信息</a>
            		</td>
                    <td class="industryBody-down-td2" id="idown152">8%</td>
                    <td class="industryBody-down-td3" id="idown153">中孚信息</td>
                    <td class="industryBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="../../js/stock/stockupdown.js"></script>
</body>
</html>
