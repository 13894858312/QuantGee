<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<title>个人中心</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../../css/ucenter/main.css">
		<link rel="stylesheet" type="text/css" href="../../css/style.css" />
		<script type="text/javascript" src="../../jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../../js/ucenter/ucenter.js"></script>
	</head>

	<body>
		<div class="head">

			<div class="hdlogo">

				<a target="_blank" class="site-logo" href=""> <img src="../../images/quantgeelogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

			</div>

			<div class="menu" id="ha1">
				<a class="menua" id="a1" href="../../view/market/marketInfo.jsp" target="_self">大盘行情</a>
			</div>
			<div class="menu" id="ha2">
				<a class="menua" id="a2" href="../../view/stock/stockFirst.jsp" target="_self">个股信息</a>
			</div>
			<div class="menu" id="ha3">
				<a class="menua" id="a3" href="../../view/strategy/strategy.jsp">策略大全</a>
			</div>
			<div class="menu" id="ha4">
				<a class="menua" id="a4" href="../../view/trade/trade.jsp" target="_blank">模拟交易</a>
			</div>
			<div class="menu" id="ha5" style="border-bottom: 2px solid rgb(62, 196, 131);">
				<a class="menua" id="a5" href="../../view/ucenter/user_center.jsp" target="_blank" style="color: rgb(62, 196, 131);">个人中心</a>
			</div>
		</div>
		<div class="info_panel day">
			<div class="control">
				<h1 class="person_pic"><a href="user_center.html" target="_blank"><i></i></a><span id="page-title">我的自选</span>
        </h1>
				<div class="infos">
					<p>成功的投资在本质上是内在的独立自主的结果。</p>
				</div>
			</div>
		</div>

		<div class="lay_out control">
			<div class="left_bar">
				<ul class="inner ta-parent-box" data-taid="wdzx_dh1" data-fid="wdzx_djall">
					<li class="nav-btn person_sel" data-id="zixuan" data-title="我的自选">
						<a href="user_center.jsp">我的自选</a>
					</li>
					<li class="nav-btn receive" data-id="focus" data-title="我的策略">
						<a href="my_strategy.html">我的策略</a>
						<!--<button onclick="getSession()">点我</button>-->
					</li>
					<li class="nav-btn pconcern" data-id="collection" data-title="我的收藏">
						<a href="my_collection.html">我的收藏</a>
					</li>
				</ul>

				<hr>
				<ul class="outer ta-parent-box" data-taid="wdzx_dh2" data-fid="wdzx_djall">
					<li class="hqcenter">
						<a href="../../view/market/marketInfo.jsp" target="_blank">行情中心</a>
					</li>
					<li class="clcenter">
						<a href="../../view/strategy/strategy.jsp" target="_blank">策略中心</a>
					</li>
				</ul>

				<hr>

				<ul class="outer ta-parent-box" data-taid="wdzx_dh2" data-fid="wdzx_djall">
					<li class="map">
						<a href="account_settings.html">帐号信息</a>
					</li>
				</ul>

			</div>

			<div class="right_content fr">

				<div class="data_panel ta-parent-box" data-taid="wdzx_hq" data-fid="wdzx_djall">

					<table class="codename fl">
						<thead>
							<tr style="border: 1px solid #e4f2ff;">
								<th style="width:120px"><span class="type">股票名称</span></th>
								<th style="width:120px"><span class="type">股票代码</span></th>
								<th class="table_sort" style="width:70px"><i></i><span>当前</span></th>
								<th style="width:137px" class="table_sort"><i></i><span>涨跌幅</span></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="stockCurrentVOS">
								<tr>
									<td>
										<a target="_blank"><s:property value="name" /></a>
									</td>
									<td>
										<a target="_blank"><s:property value="code" /></a>
									</td>
									<td><s:property value="trade" /></td>
									<td><s:property value="changePercent" /></td>
									<%--<td><i class="uarr"></i></td>--%>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<table class="colums">
						<thead>
							<tr style="border: 1px solid #e4f2ff;">
								<th class="table_sort" style="width:110px;"><i></i><span>成交量(手)</span></th>
								<th class="table_sort"><i></i><span>成交额</span></th>
								<th class="table_sort"><i></i><span>市值</span></th>
								<th class="table_sort"><i></i><span>市盈率</span></th>
								<th class="table_sort"><i></i><span>市净率</span></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="stockCurrentVOS">
								<tr>
									<td><s:property value="volume" /></td>
									<td><s:property value="amount" /></td>
									<td><s:property value="mktcap" /></td>
									<td><s:property value="per" /></td>
									<td><s:property value="pb" /></td>
 								</tr>
							</s:iterator>
						</tbody>
					</table>
					<table class="colums hide" >
						<thead>
							<tr style="border: 1px solid #e4f2ff;">
								<th class="table_sort" style="width:110px;"><i></i><span>昨日收盘价</span></th>
								<th class="table_sort"><i></i><span>今日开盘价</span></th>
								<th class="table_sort"><i></i><span>最高价</span></th>
								<th class="table_sort"><i></i><span>最低价</span></th>
								<th class="table_sort"><i></i><span>换手率</span></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="stockCurrentVOS">
								<tr>
									<td><s:property value="settlement" /></td>
									<td><s:property value="open" /></td>
									<td><s:property value="high" /></td>
									<td><s:property value="low" /></td>
									<td><s:property value="turnover" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>

					<table class="fr operate">
						<thead>
							<tr>
								<th class="arr_r" style="width: 50px ; height: 50px;"><i id="next" onclick="changecolumns()"></i></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>

				</div>

			</div>
		</div>
	</body>

</html>