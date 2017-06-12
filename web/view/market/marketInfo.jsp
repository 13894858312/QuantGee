<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MarketInfo</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
	<script type="text/javascript" src="../../js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.autocomplete.js"></script>
	<link rel="Stylesheet" href="../../css/jquery.autocomplete.css" />
	<link rel="shortcut icon" href="../../images/logo20x20.png">
    <%--<script type="text/javascript" for="window" event="onload">--%>
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
    <style type="text/css">
        @import "../../css/market/market.css";
        @import "../../css/style.css";
        @import "../../css/market/loading.css";
    </style>
</head>
<body onload="changewhole1();">

        <div class="head">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href=""> <img src="../../images/quantgeelogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

			<div class="menu" id="ha1">
                <a class="menua" id="a1"  href="marketInfo.jsp">大盘行情</a>
            </div>
            <div class="menu" id="ha2">
                <a class="menua" id="a2" href="../../view/stock/stockFirst.jsp">个股信息</a>
            </div>
            <div class="menu" id="ha3">
                <a class="menua" id="a3" href="../../view/strategy/strategy.jsp">策略大全</a>
            </div>
            <div class="menu" id="ha4">
               	<a class="menua" id="a4" href="../../view/trade/trade.jsp">模拟交易</a>
            </div>
            <div class="menu" id="ha5">
                <a class="menua" id="a5" href="" >个人中心</a>
			</div>
			<div class="search bar7">
        		<!--<form>-->
            		<input id="inputStockCode" type="text" placeholder="请输入股票代码">
                    <script src="../../js/fuzzysearch.js"></script>
					<button onclick="totheStockView()"></button>
        		<!--</form>-->
    		</div>
			<div class="marketlog">
				<div class="logimg">
					<img src="../../images/headlogin.png"/>
				</div>
				<div class="logintext">
					<a id="la" href="../../view/ucenter/login.jsp" style="color: rgba(0, 0, 0, 0.6);font-weight: 400;cursor: hand;" ></a>
				</div>
			</div>	
        </div>
		<div class="hismarket">
			<div class="hismarkethead">
				<div class="hmtext">
					历史大盘
				</div>
				<div class="mkbutton">
					<div class="klinebutton" id="dkbutton" onclick="clickdkbutton();">
						日K线
					</div>
					<div class="klinebutton" id="wkbutton" onclick="clickwkbutton();">
						周K线
					</div>
					<div class="klinebutton" id="mkbutton" onclick="clickmkbutton();">
						月K线
					</div>
				</div>
			</div>
			<div class="kline" id="kline">
				<div class="spinner" id="spinner">
				  <div class="bounce1"></div>
				  <div class="bounce2"></div>
				  <div class="bounce3"></div>
				  <div class="bounce4"></div>
				  <div class="bounce5"></div>
				</div>
			</div>
			
			<div class="volume" id="volume"></div>
            <script src="../../js/marketInfo/KLine.js"></script>
		</div>
		<div class="realmarket">
			<div class="shangz">
				<div class="text">
					<div class="name">
						上证指数
					</div>
					<div class="code">
						1A0001
					</div>
				</div>
				<div class="info">
					<div class="data" id="yesclose"></div>
					<div class="data" id="highest"></div>
					<div class="data" id="todopen"></div>
					<div class="data" id="lowest"></div>
				</div>
                <div class="shangzgraph" id="shangzgraph"></div>
                <script src="../../js/marketInfo/realInfo.js"></script>
			</div>
			<div class="riseanddownStock" id="pie">
			<script src="../../js/marketInfo/risedowngraph.js"></script>
			</div>
		</div>
		<div class="news">
			<div class="newstext">
				<div class="newshead">
					<div class="nhname">新闻资讯</div>
				</div>
				<div class="zqcj">
					<div class="titleimg">
						<div class="num">1</div>
					</div>
					<div class="titletext">
						证券交易
					</div>
					<div class="newscontent">
						<li class="content">
							<a id="zqcj1">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="zqcj2">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="zqcj3">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
                        <script src="../../js/marketInfo/news.js"></script>
					</div>
				</div>
				<div class="gncj">
					<div class="titleimg">
						<div class="num">2</div>
					</div>
					<div class="titletext">
						国内财经
					</div>
					<div class="newscontent">
						<li class="content">
							<a id="gncj1">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="gncj2">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="gncj3">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
                        <script src="../../js/marketInfo/news.js"></script>
					</div>
				</div>
				<div class="mgwh">
					<div class="titleimg">
						<div class="num">3</div>
					</div>
					<div class="titletext">
						美股外汇
					</div>
					<div class="newscontent">
						<li class="content">
							<a id="mgwh1">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="mgwh2">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="mgwh3">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
                        <script src="../../js/marketInfo/news.js"></script>
					</div>
				</div>
			</div>
		</div>
</body>
</html>