<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MarketInfo</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/test.js"></script>
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

                <a target="_blank" class="site-logo" href="http://www.10jqka.com.cn"> <img src="../../images/图标.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a href="marketInfo.jsp" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a href="../../view/stock/stockFirst.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
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
    <div class="klinegraph"></div>
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
    <div class="industry"></div>
    <div class="stock"></div>
    <div class="fourthHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="fourthText">
    	<span>财经资讯</span>
    </div>
    <div class="leftnews"></div>
    <div class="rightnews"></div>
    <div class="more">
    	<a href="">更多>></a>
    </div>
</body>
</html>