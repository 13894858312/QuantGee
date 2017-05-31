<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
		<meta charset="UTF-8">
    <title>Strategy</title>
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

                <a target="_blank" class="site-logo" href="n"> <img src="../../images/theLogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a href="../../view/market/marketInfo.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a href="../../view/stock/stockFirst.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a href="../../view/industry/industry.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
                <a href="strategy.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
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
    <div class="firstHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="firstText">
    	<span>策略展示</span>
    </div>
    <div class="strategyBar">
    	<span class="firStr">策略1</span>
    	<span class="secStr">策略2</span>
    	<span class="thirdStr">策略3</span>
    	<span class="fouStr">策略4</span>
    </div>
    <div class="sin"></div>
    <div class="sinput"></div>
    <div class="yield"></div>
    <div class="extra"></div>
    <div class="strwin"></div>
    <div class="distribute"></div>
</body>
</html>
