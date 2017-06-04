<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>MarketInfo</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/test.js"></script>
    <script type="text/javascript" for="window" event="onload">
        <%--var reftime = 3000;//默认每隔10秒向后台发送请求--%>
        <%--var taskId;--%>
        <%--if(document.readyState == "complete"){--%>
            <%--myStart();--%>
        <%--}--%>
        <%--//页面加载完毕调用此函数--%>
        <%--function myStart(){--%>
            <%--loadData();--%>
            <%--taskId = setInterval(loadData,reftime);//每隔reftime调用loadData方法刷新页面--%>
        <%--}--%>
        <%--function loadData(){--%>
            <%--$.ajax({--%>
                <%--type: "GET",--%>
                <%--url: "ajax.action",--%>
                <%--dataType: "json",--%>
                <%--success: function(data){--%>
                    <%--alert(data);--%>
                <%--},--%>
                <%--error:function (data) {--%>
                    <%--alert(error);--%>
                <%--}--%>
            <%--});--%>
        <%--}--%>
    <%--</script>--%>
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
        @import "../../css/market/market.css";
        @import "../../css/style.css";
    </style>
</head>
<body>
    <div class="header fixed">

        <div class="w1200">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href=""> <img src="../../images/theLogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a href="marketInfo.jsp" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a href="../../view/stock/stockFirst.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a href="../../view/industry/industry.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
                <a href="../../view/strategy/strategy.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
                <a href="../../view/trade/trade.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
                <a href="../../view/ucenter/user_center.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

            </div>

            <div class="login-box">

                <a href="../../view/ucenter/login.jsp" target="_self">登录</a>

            </div>

            <div class="logined_box hide fr">

                <a href="http://stock.10jqka.com.cn/my/" target="_blank" id="J_username" style="background-position: 100% 40px;">linhanzi</a>

                <span>|</span>

                <a href="javascript:;" id="header_logined_out" target="_self" class="homeloginout">退出</a>

            </div>

        </div>

    </div>
    <div class="firstHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="firstText">
    	<span>实时大盘</span>
    </div>
    <div class="SSE">
    	<div class="sszhead">
    	</div>
    	<span class="SSE-text">上证指数</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="SZI">
    	<div class="szihead">
    	</div>
    	<span class="SZI-text">深证指数</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="SZ300">
    	<div class="szhead">
    	</div>
    	<span class="SZ300-text">沪深300</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="graph-SSE" style="position: absolute;left: 8%;top: 37%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="graph-SZI" style="position: absolute;left: 36%;top: 37%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="graph-SZ300" style="position: absolute;left: 64%;top: 37%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="secondHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="secondText">
    	<span>历史大盘</span>
    </div>
    <div class="historyHead">
    	<div class="historyimg"></div>
    	<span class="hhead">往期大盘</span>
    </div>
    <div class="klinegraph" id="kline"></div>
    <div class="volume" id="volumeBar"></div>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript" src="../../js/marketInfo/KLine.js"></script>
    <div class="thirdHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="thirdText">
    	<span>个股行情</span>
    </div>
    <div class="leftrange">
    	<span class="leftrangehead">行业涨跌榜</span>
    </div>
    <div class="rightrange">
    	<span class="rightrangehead">个股涨跌榜</span>
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
    <div class="stock-left">
    	<table class="stockTable">
    		<thead class="stockHead">
    			<tr>
                    <th style="width:75px;font-weight: 100;" align="center">股票</th>
                    <th style="width:65px;font-weight: 100;" align="center">涨幅</th>
                    <th style="width:90px;font-weight: 100;" align="center">现价</th>
                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
                    <th style="width: 10px;"></th>
                </tr>
    		</thead>
    		<tbody class="stockBody-rise">
    			<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise11" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise12">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise13">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise21" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise22">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise23">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise31" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise32">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise33">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise41" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise42">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise43">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise51" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise52">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise53">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise61" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise62">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise63">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise71" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise72">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise73">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise81" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise82">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise83">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise91" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise92">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise93">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise101" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise102">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise103">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise111" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise112">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise113">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise121" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise122">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise123">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise131" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise132">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise133">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise141" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise142">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise143">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-rise-td1">
            			<a id="srise151" href="">东方电热</a>
            		</td>
                    <td class="stockBody-rise-td2" id="srise152">10.14%</td>
                    <td class="stockBody-rise-td3" id="srise153">3.91</td>
                    <td class="stockBody-rise-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
    		</tbody>
    	</table>
    </div>
    <div class="stock-right">
    	<table class="stockTable">
    		<thead class="stockHead">
    			<tr>
                    <th style="width:75px;font-weight: 100;" align="center">股票</th>
                    <th style="width:65px;font-weight: 100;" align="center">涨幅</th>
                    <th style="width:90px;font-weight: 100;" align="center">现价</th>
                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
                    <th style="width: 10px;"></th>
                </tr>
    		</thead>
    		<tbody class="stockBody-down">
    			<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown11" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown12">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown13">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown21" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown22">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown23">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown31" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown32">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown33">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown41" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown42">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown43">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown51" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown52">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown53">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown61" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown62">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown63">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown71" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown72">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown73">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown81" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown82">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown83">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown91" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown92">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown93">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown101" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown102">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown103">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown111" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown112">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown113">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown121" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown122">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown123">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown131" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown132">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown133">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown141" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown142">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown143">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
            	<tr>
            		<td class="stockBody-down-td1">
            			<a id="sdown151" href="">东方电热</a>
            		</td>
                    <td class="stockBody-down-td2" id="sdown152">10.14%</td>
                    <td class="stockBody-down-td3" id="sdown153">3.91</td>
                    <td class="stockBody-down-td4">
                    	<a style="margin-left: 25px;" href="">
                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
                    	</a>
                    </td>
                    <th style="width: 10px;"></th>
            	</tr>
    		</tbody>
    	</table>
    </div>
    <script type="text/javascript" src="../../js/marketInfo/list.js"></script>
    <div class="fourthHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="fourthText">
    	<span>财经资讯</span>
    </div>
    <div class="leftnews"></div>
    <div class="rightnews"></div>
    <div class="more">
    	<a href="" onclick="test()">更多>></a>
    </div>
</body>
</html>