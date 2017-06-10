<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MarketInfo</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
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
                <a class="menua" id="a2" href="../../view/stock/stockFirst.jsp" target="_blank">个股信息</a>
            </div>
            <div class="menu" id="ha3">
                <a class="menua" id="a3" href="../../view/strategy/strategy.jsp" target="_blank">策略大全</a>
            </div>
            <div class="menu" id="ha4">
               	<a class="menua" id="a4" href="../../view/trade/trade.jsp" target="_blank">模拟交易</a>
            </div>
            <div class="menu" id="ha5">
                <a class="menua" id="a5" href="../../view/ucenter/user_center.jsp" target="_blank">个人中心</a>
			</div>
			<div class="search bar7">
        		<!--<form>-->
            		<input id="inputStockCode" type="text" placeholder="请输入股票代码">
					<button onclick="totheStockView()"></button>
        		<!--</form>-->
    		</div>
			<div class="marketlog">
				<div class="logimg">
					<img src="../../images/headlogin.png"/>
				</div>
				<div class="logintext">
					<a href="../../view/ucenter/login.jsp" style="color: rgba(0, 0, 0, 0.6);font-weight: 400;cursor: hand;" >登录</a>
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
					<div class="data">昨收:3140.32</div>
					<div class="data">涨跌幅:10.12%</div>
					<div class="data">今开:3132.12</div>
					<div class="data">涨跌:3140.32</div>
				</div>
                <div class="shangzgraph" id="shangzgraph"></div>
                <%--<script src="../../js/marketInfo/realInfo.js"></script>--%>
			</div>
			<div class="shenz">
				<div class="text">
					<div class="name">
						深证指数
					</div>
					<div class="code">
						399001
					</div>
				</div>
				<div class="info">
					<div class="data">昨收:3140.32</div>
					<div class="data">涨跌幅:10.12%</div>
					<div class="data">今开:3132.12</div>
					<div class="data">涨跌:3140.32</div>
				</div>
			</div>
			<div class="chuangy">
				<div class="text">
					<div class="name">
						创业板指
					</div>
					<div class="code">
						399006
					</div>
				</div>
				<div class="info">
					<div class="data">昨收:3140.32</div>
					<div class="data">涨跌幅:10.12%</div>
					<div class="data">今开:3132.12</div>
					<div class="data">涨跌:3140.32</div>
				</div>
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
    <!--<div class="firstHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="firstText">
    	<span>实时大盘</span>
    </div>
    <div class="SSE">
    	<div class="sszhead">
    	</div>
    	<span class="SSE-text">上证指数</span>
    	<span class="ssz1" id="ssedata">25428.50</span>
    	<span class="ssz2" id="sserange">0.10%</span>
    	<span class="ssz3" id="sseprice">25.35</span>
        <div class="top"></div>
    </div>
    <div class="SZI">
    	<div class="szihead">
    	</div>
    	<span class="SZI-text">深证指数</span>
    	<span class="ssz1" id="szidata">25428.50</span>
    	<span class="ssz2" id="szirange">0.10%</span>
    	<span class="ssz3" id="sziprice">25.35</span>
    </div>
    <div class="SZ300">
    	<div class="szhead">
    	</div>
    	<span class="SZ300-text">创业板指</span>
    	<span class="ssz1" id="szdata">25428.50</span>
    	<span class="ssz2" id="szrange">0.10%</span>
    	<span class="ssz3" id="szprice">25.35</span>
    </div>
    <div id="graph-SSE" style="background-color:#FFFFFF;position: absolute;left: 8%;top: 37%;width: 25%;height: 25%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div id="graph-SZI" style="background-color:#FFFFFF;position: absolute;left: 36%;top: 37%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
	<div id="graph-SZ300" style="background-color:#FFFFFF;position: absolute;left: 64%;top: 37%;width: 25%;height: 40%;background-color: #FFFFFF;border: 1px solid #000000;"></div>
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
    <div class="fourthHead">
    	<img src="../../images/标签1.png" class="imageHead" style="width: 80px;height: 50px;"/>
    </div>
    <div class="fourthText">
    	<span>财经资讯</span>
    </div>
    <div class="leftnews">
    	<table class="leftnewsTable">
    		<tbody class="leftBody">
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="l1">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="lt1">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="l2">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="lt2">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="l3">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="lt3">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="l4">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="lt4">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="l5">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="lt5">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			
    		</tbody>
    	</table>
    </div>
    <div class="rightnews">
    	<table class="rightnewsTable">
    		<tbody class="rightBody">
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="r1">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="rt1">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="r2">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="rt2">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="r3">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="rt3">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="r4">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="rt4">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    			<tr>
    				<td class="newsContent">
    					<a href="" style="color: #000000;" id="r5">mvnmvnmvnmvnmvnm</a>
    				</td>
    				<td class="timeContent" id="rt5">2016-10-19</td>
    				<td style="width: 10px;"></td>
    			</tr>
    		</tbody>
    	</table>
    </div>
	<script type="text/javascript" src="../../js/marketInfo/news.js"></script>-->
</body>
</html>