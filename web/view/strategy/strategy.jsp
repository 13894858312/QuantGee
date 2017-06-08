<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Strategy</title>
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
		<script type="text/javascript" src="../../jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../../js/strategy/strategy.js"></script>
		<link rel="stylesheet" href="../../css/style.css" />
		<link rel="stylesheet" href="../../css/strategy/strategy.css" />
		<link rel="stylesheet" href="../../css/strategy/new.css" />

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
			<div class="menu" id="ha3" style="border-bottom: 2px solid rgb(62, 196, 131);">
				<a class="menua" id="a3" href="../../view/strategy/strategy.jsp" style="color: rgb(62, 196, 131);">策略大全</a>
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
					<img src="../../images/headlogin.png">
				</div>
				<div class="logintext">
					<a href="../../view/ucenter/login.jsp" style="color: rgba(0, 0, 0, 0.6);font-weight: 400;cursor: hand;">登录</a>
				</div>
			</div>
		</div>
		<div id="strategybar">
			<div class="hmtext">策略讲解</div>
		</div>
		<div id=con>
			<ul id=tags>
				<li class=selectTag>
					<a onMouseover="selectTag('tagContent0',this)" href="javascript:void(0)">动量策略</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent1',this)" href="javascript:void(0)">均值回归</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent2',this)" href="javascript:void(0)">xx策略</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent3',this)" href="javascript:void(0)">xx策略</a>
				</li>
			</ul>
			<div id=tagContent>
				<div class="tagContent selectTag" id=tagContent0>
					价格动量是指价格变化的速度，或一段时间内价格的变化率。正的价格动量告诉我们，某只股票买家数量正在不断增加，目前需求超过供应；相反，负的价格动量则告诉我们股票的卖家数量正显著增加，供应超过需求。 在一般情况下，我们预期表现最好的股票将会继续表现强劲，而表现最差的将继续表现不佳。用通俗的话来讲就是“追涨杀跌”。
					<br /> 策略具体操作：
					<br /> ①确定目标股票池作为交易对象的范围。
					<br /> ②选定一个时间长度作为股票收益率评价期，通常称为投资组合的形成期或排名期。
					<br /> ③计算形成期各样本股票的收益率。
					<br /> ④根据形成期各样本股票的收益率的大小，对目标股票池所有股票进行升序、降序排列，然后等分成若干组，其中收益率最大的一组称为赢家组合，收益率最小的一组称为输家组合。（要求分成5组，取收益率前20%）
					<br /> ⑤形成期之后，再选一个时间长度，作为赢家组合的持有期限。
					<br /> ⑥连续或间隔一段时期，不断重复 ②-⑤行为。<br /> ⑦评价。计算动量策略各持有期的回报率均值。
					<br />
				</div>
				<div class=tagContent id=tagContent1>
				</div>
				<div class=tagContent id=tagContent2>第三个标签</div>
				<div class=tagContent id=tagContent3>第四个标签</div>
			</div>
		</div>
		
		<div id="strategybar">
			<div class="hmtext">策略演示</div>
		</div>

		<div id=con_str>
			<ul id=tags_str>
				<li class=selectTag_str>
					<a onMouseover="selectStrategyTag('tagContent_str0',this)" href="javascript:void(0)">动量策略</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag('tagContent_str1',this)" href="javascript:void(0)">均值回归</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag('tagContent_str2',this)" href="javascript:void(0)">xx策略</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag('tagContent_str3',this)" href="javascript:void(0)">xx策略</a>
				</li>
			</ul>
			<div id=tagContent_str>
				<div class="tagContent_str selectTag_str" id=tagContent_str0>
					<table id="paramChoose">
						<tr>
							<th>Header</th>
						</tr>
						<tr>
							<td>Data</td>
						</tr>
					</table>
				</div>
				<div class=tagContent_str id=tagContent_str1>
				</div>
				<div class=tagContent_str id=tagContent_str2>第三个标签</div>
				<div class=tagContent_str id=tagContent_str3>第四个标签</div>
			</div>
		</div>

		
	</body>

</html>