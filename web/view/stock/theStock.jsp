<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
		<meta charset="UTF-8">
    <title>TheStock</title>
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
	<script src="../../echarts.js"></script>
	<script src="../../jquery-3.2.1.min.js"></script>
    <style type="text/css">
    	@import "../../css/style.css";
    	@import "../../css/stock/theStock.css";
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
	<div class="firstarea">
		<div class="nameAndsearch">
			<div class="nameInfo">
				<div class="name">
					<span id="sname">浦发银行</span>
				</div>
				<div class="code">
					<span id="scode">600020</span>
				</div>
				<div class="nowprice">
					<span id="sprice">￥34.61</span>
				</div>
				<div class="range-price-add">
					<div class="range">
						<span id="srange">0.03%</span>
					</div>
					<div class="rangeprice">
						<span id="srprice">+0.02</span>
					</div>
					<div class="addimg">
						<a href="javascript:void(0)" onclick="">
							<img src="http://i.thsi.cn/images/q/plus_logo.png"/>
						</a>
						<span id="simgtext" style="margin-left: 5px;">加自选</span>
					</div>
				</div>
			</div>
			<div class="searcharea"></div>
		</div>
		<div class="stockInfo">
			<div class="openandclose">
				<div class="octext">
					<div class="ctext">
						<span>昨日收盘价</span>
					</div>
					<div class="otext">
						<span>今日开盘价</span>
					</div>
				</div>
				<div class="ocnum">
					<div class="num">
						<span id="closenum">￥34.45</span>
					</div>
					<div class="num">
						<span id="opennum">￥34.45</span>
					</div>
				</div>
			</div>
			<div class="highandlow">
				<div class="octext">
					<div class="ctext">
						<span>最高价</span>
					</div>
					<div class="otext">
						<span>最低价</span>
					</div>
				</div>
				<div class="ocnum">
					<div class="num">
						<span id="highnum">￥34.45</span>
					</div>
					<div class="num">
						<span id="lownum">￥34.45</span>
					</div>
				</div>
			</div>
			<div class="volumeandnum">
				<div class="octext">
					<div class="ctext">
						<span>成交量</span>
					</div>
					<div class="otext">
						<span>成交额</span>
					</div>
				</div>
				<div class="ocnum">
					<div class="num">
						<span id="volume">￥34.45</span>
					</div>
					<div class="num">
						<span id="volumenum">￥34.45</span>
					</div>
				</div>
			</div>
			<div class="other">
				<div class="octext">
					<div class="ctext">
						<span>换手率</span>
					</div>
					<div class="otext">
						<span>市盈率</span>
					</div>
				</div>
				<div class="ocnum">
					<div class="num">
						<span id="changerate">￥34.45</span>
					</div>
					<div class="num">
						<span id="marketrate">￥34.45</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="realtimearea">
		<div class="realdata">
			
		</div>
		<div class="realprice">
			
		</div>
		<div class="realvolume">
			
		</div>
		<div class="predicttextarea">
			<div class="predicttext">
				<span>股票预测</span>
			</div>
		</div>
		<div class="predictarea">
			
		</div>
	</div>
	<div class="historicalarea">
		<div class="buttonarea">
			<div class="klinebutton" style="background-color: #6C7B8B;color: #FFFFFF;">
				日K
			</div>
			<div class="klinebutton" style="background-color: #FFFFFF;color: #000000;">
				周K
			</div>
			<div class="klinebutton" style="background-color: #FFFFFF;color: #000000;">
				月K
			</div>
		</div>
		<div class="klinearea">
			
		</div>
		<div class="historicalvolumearea">
			
		</div>
		<div class="indexarea">
			<div class="indexbutton" style="background-color: #6C7B8B;color: #FFFFFF;">
				MACD
			</div>
			<div class="indexbutton" style="background-color: #FFFFFF;color: #000000;">
				KDJ
			</div>
			<div class="indexbutton" style="background-color: #FFFFFF;color: #000000;">
				RSI
			</div>
			<div class="indexbutton" style="background-color: #FFFFFF;color: #000000;">
				BOLL
			</div>
		</div>
		<div class="indexgrapharea"></div>
	</div>
	<div class="stockanalysisarea">
		<div class="analysistext">
			<div class="atext">
				<span>股票分析</span>
			</div>
		</div>
		<div class="MACDarea">
			<div class="indextext">
				<span>MACD</span>
			</div>
		</div>
		<div class="KDJarea">
			<div class="indextext">
				<span>KDJ</span>
			</div>
		</div>
		<div class="RSIarea">
			<div class="indextext">
				<span>RSI</span>
			</div>
		</div>
		<div class="BOLLarea">
			<div class="indextext">
				<span>BOLL</span>
			</div>
		</div>
	</div>
</body>
</html>
