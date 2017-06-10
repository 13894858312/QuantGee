<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
		<meta charset="UTF-8">
    <title>Trade</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
    <script src="../../js/trade/addlist.js"></script>
	<link rel="shortcut icon" href="../../images/logo20x20.png">
    <style type="text/css">
        @import "../../css/style.css";
        @import "../../css/trade/trade.css";
    </style>
</head>
<body onload="changewhole4()">
		<div class="head">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href=""> <img src="../../images/quantgeelogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

			<div class="menu" id="ha1">
                <a class="menua" id="a1"  href="../../view/market/marketInfo.jsp" target="_blank">大盘行情</a>
            </div>
            <div class="menu" id="ha2">
                <a class="menua" id="a2" href="../../view/stock/stockFirst.jsp" target="_blank">个股信息</a>
            </div>
            <div class="menu" id="ha3">
                <a class="menua" id="a3" href="../../view/strategy/strategy.jsp" target="_blank">策略大全</a>
            </div>
            <div class="menu" id="ha4">
               	<a class="menua" id="a4" href="trade/trade.jsp" target="_blank">模拟交易</a>
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
    <div class="datahelper">
    	<div class="datahelperhead">
    		<div class="dhheantext">
    			数据助手
    		</div>
    	</div>
    	<div class="graph">
    		<div class="kimgandindex">
    			<div class="kimg"></div>
    			<div class="indexhead">
    				<div class="indexbutton">
    					<div class="mkrbbutton">
							MACD
						</div>
						<div class="mkrbbutton">
							KDJ
						</div>
						<div class="mkrbbutton">
							RSI
						</div>
						<div class="mkrbbutton">
							BOLL
						</div>
	    			</div>
    			</div>
    			<div class="idneximg"></div>
    		</div>
    		<div class="realanddata">
    			<div class="realimg"></div>
    			<div class="realdata"></div>
    		</div>
    	</div>
    </div>
    <div class="testtradehead">
    	<div class="testheadtext">
    		<div class="text">持仓交易</div>
    		<div class="buy" onclick="addrow()">买入</div>
    	</div>
    </div>
    <div class="stocktable">
    	<table class="st" id="st">
    		<tr>
    			<td class="stth">股票名称</td>
    			<td class="stth">股票代码</td>
    			<td class="stth">持仓股数</td>
    			<td class="stth">持仓市值</td>
    			<td class="stth">最新价</th>
    			<td class="stth">日涨跌幅</td>
    			<td class="delete">操作</td>
    		</tr>
    	</table>
    </div>
    <div class="analysis">
		<div class="anahead">
			<div class="anaheadtext">股票预测</div>
		</div>
		<div class="analysisgraph"></div>
		<div class="analysisdata">
			<div class="resultl"></div>
			<div class="resultm"></div>
			<div class="resultr"></div>
		</div>
	</div>
</body>
</html>
