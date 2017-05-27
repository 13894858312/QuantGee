<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	 <meta charset="UTF-8">
    <title>StockFirst</title>
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
    <script src="../../js/test.js"></script>
    <style type="text/css">
    	@import "../../css/style.css";
    	@import "../../css/stock/firstStock.css";
    </style>
</head>
<body>
		<div class="header fixed">

        <div class="w1200">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href="http://www.10jqka.com.cn"> <img src="../../images/图标.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a href="../../view/market/marketInfo.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a href="stockFirst.jsp" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a href="../../view/industry/industry.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
                <a href="../../view/iStrategy/iStrategy.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
                <a href="../../view/trade/trade.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
                <a href="../../view/ucenter/user_center.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

            </div>

            <div class="login-box">

                <a href="../../view/ucenter/login.html" target="_blank">登录</a>

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
    	<span>个股排行</span>
    </div>
    <div class="stockBar">
    		<span class="all">全部股票</span>
    		<span class="sszA">上证A股</span>
    		<span class="sziA">深证A股</span>
    		<span class="sme">中小板</span>
    		<span class="startup">创业板</span>
    </div>
    <div class="tableContent">
    	
    </div>
    <div class="secondHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="secondText">
    	<span>今日推荐</span>
    </div>
    <div class="firRec">
    	<div class="sszhead">
    	</div>
    	<span class="SSE-text">A股</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="secRec">
    	<div class="szihead">
    	</div>
    	<span class="SZI-text">B股</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="thirdRec">
    	<div class="szhead">
    	</div>
    	<span class="SZ300-text">C股</span>
    	<span class="ssz1">25428.50</span>
    	<span class="ssz2">0.10%</span>
    	<span class="ssz3">25.35</span>
    </div>
    <div class="graph-SSE" style="position: absolute;left: 8%;top: 138%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="graph-SZI" style="position: absolute;left: 36%;top: 138%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="graph-SZ300" style="position: absolute;left: 64%;top: 138%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div class="search">
		<input type="text" class="lefttext" placeholder="股票代码/股票名称"/>
		<i class="submit" onclick="test()"></i>
	</div>
	
</body>
</html>
