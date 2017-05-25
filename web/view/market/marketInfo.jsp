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
        function s3(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            first.style.backgroundColor="#e0eee0";
            first.style.borderLeft="6px solid #000";
            second.style.backgroundColor="#ffffff";
            second.style.borderLeft="6px solid #ffffff";
            third.style.backgroundColor="#ffffff";
            third.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="block";
            graph2.style.display="none";
            graph3.style.display="none";
        }
        function s5(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            second.style.backgroundColor="#e0eee0";
            second.style.borderLeft="6px solid #000";
            first.style.backgroundColor="#ffffff";
            first.style.borderLeft="6px solid #ffffff";
            third.style.backgroundColor="#ffffff";
            third.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="none";
            graph2.style.display="block";
            graph3.style.display="none";
        }
        function s7(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            third.style.backgroundColor="#e0eee0";
            third.style.borderLeft="6px solid #000";
            second.style.backgroundColor="#ffffff";
            second.style.borderLeft="6px solid #ffffff";
            first.style.backgroundColor="#ffffff";
            first.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="none";
            graph2.style.display="none";
            graph3.style.display="block";
        }
    </script>
    <style type="text/css">
        @import "../../css/market/market.css";
        @import "../../css/style1.css";
    </style>
</head>
<body>
    <div class="header fixed">

        <div class="w1200">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href="http://www.10jqka.com.cn"> <img src="../../images/图标.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">板块资讯</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
                <a href="../../view/ucenter/user_center.html" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

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
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80;height: 50;"/>
    </div>
    <div class="firstText">
    	<span>大盘数据</span>
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
    	<span class="SZI-text">深圳指数</span>
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
    <div class="graph-SSE"></div>
	<div class="graph-SZI"></div>
	<div class="graph-SZ300"></div>
</body>
</html>