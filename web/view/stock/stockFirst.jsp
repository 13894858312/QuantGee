<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	 <meta charset="UTF-8">
    <title>StockFirst</title>
	<script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
    <script type="text/javascript" src="../../js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.autocomplete.js"></script>
    <link rel="Stylesheet" href="../../css/jquery.autocomplete.css" />
	<%--<script src="../../js/stock/stockfirst/listcontroller.js"></script>--%>
	<link rel="shortcut icon" href="../../images/logo20x20.png">
    <!--<script src="../../js/stock/someInfo.js"></script>-->
    <style type="text/css">
    	@import "../../css/style.css";
		@import "../../css/stock/firstStock.css";
    </style>
</head>
<body onload="changewhole2()">
		<div class="head">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href=""> <img src="../../images/quantgeelogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

			<div class="menu" id="ha1">
                <a class="menua" id="a1"  href="../../view/market/marketInfo.jsp">大盘行情</a>
            </div>
            <div class="menu" id="ha2">
                <a class="menua" id="a2" href="stockFirst.jsp">个股信息</a>
            </div>
            <div class="menu" id="ha3">
                <a class="menua" id="a3" href="../../view/strategy/strategy.jsp">策略大全</a>
            </div>
            <div class="menu" id="ha4">
               	<a class="menua" id="a4" href="../../view/trade/trade.jsp">模拟交易</a>
            </div>
            <div class="menu" id="ha5">
                <a class="menua" id="a5" href="">个人中心</a>
			</div>
			<div class="search bar7">
            		<input id="inputStockCode" type="text" placeholder="请输入股票代码">
            		<button onclick="totheStockView()" type="submit"></button>
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
  	<div class="rangeandgraph">
  		<div class="range">
  			<div class="rangehead">
  				<div class="rangeheadtext">个股排行</div>
  			</div>
  			<div class="rangecontent">
  				<div class="row">
  					<div class="column">股票</div>
  					<div class="column">涨幅(%)</div>
  					<div class="column">现价</div>
  					<div class="column">加自选</div>
  				</div>
  				<div class="row" id="row1" onclick="showrow(this)">
  					<div class="column1" id="r1c1div" onclick="changeChart(this)"><a id="r1c1a"></a></div>
  					<div class="column2" id="r1c2div">10.03</div>
  					<div class="column3" id="r1c3div">10.75</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row2" onclick="showrow(this)">
  					<div class="column1" id="r2c1div" onclick="changeChart(this)"><a id="r2c1a"></a></div>
  					<div class="column2" id="r2c2div">10.03</div>
  					<div class="column3" id="r2c3div">15.80</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row3" onclick="showrow(this)">
  					<div class="column1" id="r3c1div" onclick="changeChart(this)"><a id="r3c1a"></a></div>
  					<div class="column2" id="r3c2div">10.02</div>
  					<div class="column3" id="r3c3div">22.40</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row4" onclick="showrow(this)">
  					<div class="column1" id="r4c1div" onclick="changeChart(this)"><a id="r4c1a"></a></div>
  					<div class="column2" id="r4c2div">10.02</div>
  					<div class="column3" id="r4c3div">22.29</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row5" onclick="showrow(this)">
  					<div class="column1" id="r5c1div" onclick="changeChart(this)"><a id="r5c1a"></a></div>
  					<div class="column2" id="r5c2div">10.02</div>
  					<div class="column3" id="r5c3div">25.37</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row6" onclick="showrow(this)">
  					<div class="column1" id="r6c1div" onclick="changeChart(this)"><a id="r6c1a"></a></div>
  					<div class="column2" id="r6c2div">10.01</div>
  					<div class="column3" id="r6c3div">23.73</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row7" onclick="showrow(this)">
  					<div class="column1" id="r7c1div" onclick="changeChart(this)"><a id="r7c1a"></a></div>
  					<div class="column2" id="r7c2div">10.01</div>
  					<div class="column3" id="r7c3div">40.24</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row8" onclick="showrow(this)">
  					<div class="column1" id="r8c1div" onclick="changeChart(this)"><a id="r8c1a"></a></div>
  					<div class="column2" id="r8c2div">10.00</div>
  					<div class="column3" id="r8c3div">30.31</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row" id="row9" onclick="showrow(this)">
  					<div class="column1" id="r9c1div" onclick="changeChart(this)"><a id="r9c1a"></a></div>
  					<div class="column2" id="r9c2div">9.99</div>
  					<div class="column3" id="r9c3div">30.28</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div> 
  				<div class="row" id="row10" onclick="showrow(this)">
  					<div class="column1" id="r10c1div" onclick="changeChart(this)"><a id="r10c1a"></a></div>
  					<div class="column2" id="r10c2div">9.99</div>
  					<div class="column3" id="r10c3div">18.06</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  			</div>
			<script src="../../js/stock/stockfirst/rangelist.js"></script>
  		</div>
  		<div class="graph">
  			<div class="graphhead">
  				<div class="nemeandcode">
  					<div class="sname" id="hsname">万家文化</div>
  					<div class="scode" id="hscode">600576</div>
  				</div>
  				<div class="stockInfo">
  					<span>市盈率:</span>
					<span id="hsiearn"></span>
  					<span>市净率:</span>
					<span id="hsiclean"></span>
  				</div>
  			</div>
  			<div class="kline" id="kline"></div>
  			<div class="volume" id="volume"></div>
            <script src="../../js/stock/stockfirst/listcontroller.js"></script>
  		</div>
  		<div class="todayrecommend">
  			<div class="trhead">
  				<div class="trheadtext">今日推荐</div>
  			</div>
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
							<a id="zqcj11">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="zqcj22">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="zqcj33">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
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
							<a id="gncj11">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="gncj22">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="gncj33">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
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
							<a id="mgwh11">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="mgwh22">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
						<li class="content">
							<a id="mgwh33">央行5月对三家政策性银行净增加抵押补充贷款476亿</a>
						</li>
                        <script src="../../js/marketInfo/news.js"></script>
					</div>
				</div>
			</div>
		</div>
  	</div>
</body>
</html>
