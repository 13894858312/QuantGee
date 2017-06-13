<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
		<meta charset="UTF-8">
    <title>Trade</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
    <script src="../../js/trade/addlist.js"></script>
	<!--<script type="text/javascript" src="../../js/jquery-1.4.2.min.js"></script>-->
	<script type="text/javascript" src="../../js/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="../../js/sweet-alert.min.js"></script>
	<link rel="stylesheet" href="../../css/sweet-alert.css">
	<link rel="Stylesheet" href="../../css/jquery.autocomplete.css" />
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
                <a class="menua" id="a1"  href="../../view/market/marketInfo.jsp">大盘行情</a>
            </div>
            <div class="menu" id="ha2">
                <a class="menua" id="a2" href="../../view/stock/stockFirst.jsp">个股信息</a>
            </div>
            <div class="menu" id="ha3">
                <a class="menua" id="a3" href="../../view/strategy/strategy.jsp">策略大全</a>
            </div>
            <div class="menu" id="ha4">
               	<a class="menua" id="a4" href="trade.jsp">模拟交易</a>
            </div>
            <div class="menu" id="ha5">
                <a class="menua" id="a5" href="">个人中心</a>
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
					<a id="la" href="../../view/ucenter/login.jsp" style="color: rgba(0, 0, 0, 0.6);font-weight: 400;cursor: hand;" >登录</a>
				</div>
			</div>	
    </div>
    <div class="datahelper">
    	<div class="datahelperhead">
    		<div class="dhheantext">
    			数据助手
    		</div>
    		<input id="inputstcode" type="text" placeholder="请输入股票代码">
    		<div class="check" onclick="getCheck()">查询</div>
    	</div>
    	<div class="graph">
    		<div class="kimgandindex">
    			<div class="kimg" id="kline"></div>
	    			<div class="realanddata">
	    				<div class="realdatahead">
		    				<div class="resulttext0" id="resulttext0">上证指数</div>
							<div class="resultdata0" id="resultdata0">1A0001</div>
		    			</div>
		    			<div class="realdata">
		    				<div class="resulttext">预测明日价格:</div>
							<div class="resultdata" id="resultdata1">-----</div>
		    			</div>
		    			<div class="realdata">
		    				<div class="resulttext">预测明日涨跌幅:</div>
							<div class="resultdata" id="resultdata2">-----</div>
		    			</div>
		    			<div class="realdata">
		    				<div class="resulttext">历史误差率:</div>
							<div class="resultdata" id="resultdata3">-----</div>
		    			</div>
	    			</div>
    			</div>
    		</div>
    	</div>
    		
    		<div class="indexhead">
    				<div class="indexbutton">
    					<div class="mkrbbutton" id="MACDbutton" onclick="clickMACDbutton()">
							MACD
						</div>
						<div class="mkrbbutton" id="KDJbutton" onclick="clickKDJbutton()">
							KDJ
						</div>
						<div class="mkrbbutton" id="RSIbutton" onclick="clickRSIbutton()">
							RSI
						</div>
						<div class="mkrbbutton" id="BOLLbutton" onclick="clickBOLLbutton()">
							BOLL
						</div>
	    			</div>
    			</div>
    			<div class="idneximg" id="index"></div>
    			<script src="../../js/trade/tradeIndex.js"></script>
    <div class="testtradehead">
    	<div class="testheadtext">
    		<div class="text">持仓交易</div>
    		<input class="stinput" id="stname" type="text" placeholder="请输入股票代码">
    		<input class="stinput" id="stnum" type="text" placeholder="请输入购股数">
    		<div class="nowmoneytext">余额:</div>	
    		<div class="nowmoney" id="nowmoney">100000</div>
    		<!--<div class="buy" onclick="addrow()">买入</div>-->
    	</div>
    </div>
    <div class="stocktable">
    	<table class="st" id="st">
    		<tr>
    			<th class="stth">股票名称</th>
    			<th class="stth">股票代码</th>
    			<th class="stth">持仓股数</th>
    			<th class="stth">初始投入</td>
    			<th class="stth">最新价</th>
    			<th class="stth">收益率</th>
    			<th class="add"><div class="tdbutton" id="buybutton" onclick="buyStock()">买入</div></th>
    			<th class="delete"><div class="tdbutton" id="sellbutton" onclick="sellStock()">卖出</div></th>
    		</tr>
    	</table>
    </div>
    <div class="recordtext">
    	<div class="testheadtext">
    		<div class="text">交易记录</div>
    	</div>
    </div>
    <div class="traderecordtable">
    	<table class="st" id="record">
    		<tr>
    			<td class="stth">股票名称</td>
    			<td class="stth">股票代码</td>
    			<td class="stth">买入/卖出</td>
    			<td class="stth">股数</td>
    			<td class="stth">交易价格</td>
    			<td class="stth">交易时间</td>
    		</tr>
    	</table>
    </div>
        <script type="text/javascript" src="../../js/trade/initTrade.js"></script>
</body>
</html>
