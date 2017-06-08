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
	<script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/marketInfo/headcontroller.js"></script>
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
        		<form>
            		<input type="text" placeholder="请输入股票代码">
            		<button type="submit"></button>
        		</form>
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
  				<div class="row" id="row1">
  					<div class="column1"><a>万家文化</a></div>
  					<div class="column2">10.03</div>
  					<div class="column3">10.75</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>继峰股份</a></div>
  					<div class="column2">10.03</div>
  					<div class="column3">15.80</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>恒为科技</a></div>
  					<div class="column2">10.02</div>
  					<div class="column3">22.40</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>华钰矿业</a></div>
  					<div class="column2">10.02</div>
  					<div class="column3">22.29</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>同达创业</a></div>
  					<div class="column2">10.02</div>
  					<div class="column3">25.37</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>华脉科技</a></div>
  					<div class="column2">10.01</div>
  					<div class="column3">23.73</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>上海洗霸</a></div>
  					<div class="column2">10.01</div>
  					<div class="column3">40.24</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>元成股份</a></div>
  					<div class="column2">10.00</div>
  					<div class="column3">30.31</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  				<div class="row">
  					<div class="column1"><a>艾艾精工</a></div>
  					<div class="column2">9.99</div>
  					<div class="column3">30.28</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div> 
  				<div class="row">
  					<div class="column1"><a>日播时尚</a></div>
  					<div class="column2">9.99</div>
  					<div class="column3">18.06</div>
  					<div class="column4">
  						<img src="../../images/addbutton.png" />
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="graph">
  			<div class="graphhead">
  				<div class="nemeandcode">
  					<div class="name">万家文化</div>
  					<div class="code">600576</div>
  				</div>
  				<div class="stockInfo">
  					<span style="color: rgb(207,25,74);">市盈率:10.19%</span>
  					<span style="color: rgb(62, 196, 131);">市净率:13.14%</span>
  				</div>
  			</div>
  			<div class="kline" id="kline"></div>
  			<div class="volume" id="volume"></div>
  			<script src="../../js/marketInfo/KLine.js"></script>
  		</div>
  	</div>
    <!--<div class="rightrange">
    	<span class="rightrangehead">个股涨跌榜</span>
    </div>
    <div class="data"></div>
    <div class="search"></div>
	    <div class="stock-left">
	    	<table class="stockTable">
	    		<thead class="stockHead">
	    			<tr>
	                    <th style="width:75px;font-weight: 100;" align="center">股票</th>
	                    <th style="width:65px;font-weight: 100;" align="center">涨幅</th>
	                    <th style="width:90px;font-weight: 100;" align="center">现价</th>
	                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
	                    <th style="width: 10px;"></th>
	                </tr>
	    		</thead>
	    		<tbody class="stockBody-rise">
	    			<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise11" href="javascript:void(0)" onmouseover="showdatasr11()">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise12">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise13">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise21" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise22">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise23">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise31" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise32">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise33">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise41" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise42">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise43">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise51" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise52">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise53">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise61" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise62">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise63">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise71" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise72">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise73">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise81" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise82">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise83">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise91" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise92">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise93">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise101" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise102">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise103">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise111" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise112">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise113">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise121" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise122">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise123">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise131" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise132">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise133">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise141" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise142">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise143">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-rise-td1">
	            			<a id="srise151" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-rise-td2" id="srise152">10.14%</td>
	                    <td class="stockBody-rise-td3" id="srise153">3.91</td>
	                    <td class="stockBody-rise-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	    		</tbody>
	    	</table>
	    </div>
	    <div class="stock-right">
	    	<table class="stockTable">
	    		<thead class="stockHead">
	    			<tr>
	                    <th style="width:75px;font-weight: 100;" align="center">股票</th>
	                    <th style="width:65px;font-weight: 100;" align="center">涨幅</th>
	                    <th style="width:90px;font-weight: 100;" align="center">现价</th>
	                    <th style="width:60px;font-weight: 100;" align="right">加自选</th>
	                    <th style="width: 10px;"></th>
	                </tr>
	    		</thead>
	    		<tbody class="stockBody-down">
	    			<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown11" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown12">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown13">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown21" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown22">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown23">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown31" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown32">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown33">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown41" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown42">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown43">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown51" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown52">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown53">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown61" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown62">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown63">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown71" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown72">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown73">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown81" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown82">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown83">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown91" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown92">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown93">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown101" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown102">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown103">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown111" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown112">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown113">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown121" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown122">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown123">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown131" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown132">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown133">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown141" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown142">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown143">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	            	<tr>
	            		<td class="stockBody-down-td1">
	            			<a id="sdown151" href="">东方电热</a>
	            		</td>
	                    <td class="stockBody-down-td2" id="sdown152">10.14%</td>
	                    <td class="stockBody-down-td3" id="sdown153">3.91</td>
	                    <td class="stockBody-down-td4">
	                    	<a style="margin-left: 25px;" href="">
	                    		<img src="http://i.thsi.cn/images/q/plus_logo.png" />
	                    	</a>
	                    </td>
	                    <th style="width: 10px;"></th>
	            	</tr>
	    		</tbody>
	    	</table>
	    </div>
    <script type="text/javascript" src="../../js/stock/stockupdown.js"></script>
    <div class="stockInfo" id="si1"></div>
    <div class="stockInfo2" id="si2"></div>
        <script type="text/javascript" src="../../js/stock/someInfo.js"></script>
    <div class="news">
    	<div class="newshead">
    		<span class="newsText">个股财经新闻</span>
    	</div>
    	<div class="leftcontent"></div>
    	<div class="rightcontent"></div>
    </div>-->
</body>
</html>
