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
		<div class="header fixed">

			<div class="w1200">

				<div class="hdlogo">

					<a target="_blank" class="site-logo" href="n"> <img src="../../images/theLogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

				</div>

				<div class="nav">

					<a href="../../view/market/marketInfo.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
					<a href="../../view/stock/stockFirst.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
					<a href="../../view/industry/industry.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
					<a href="strategy.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
					<a href="../../view/trade/trade.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
					<a href="../../view/ucenter/user_center.jsp" target="_self" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

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
		<div id="strategybar">
			<img src="../../images/标签1.png" style="width: 80px;height: 50px;" />
			<span>策略讲解</span>
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

		<div id=con_str>
			<ul id=tags_str>
				<li class=selectTag_str>
					<a onMouseover="selectStrategyTag()('tagContent_str0',this)" href="javascript:void(0)">动量策略</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag()Tag('tagContent_str1',this)" href="javascript:void(0)">均值回归</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag()Tag('tagContent_str2',this)" href="javascript:void(0)">xx策略</a>
				</li>
				<li>
					<A onMouseover="selectStrategyTag()Tag('tagContent_str3',this)" href="javascript:void(0)">xx策略</a>
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

		<div class="hcharts-left">
			<div class="hcharts-list">
				<div class="item tab-hv-trigger">
					<h3 class="icons1">涨跌分布</h3>
					<p class="detail">
						<span class="c-rise">上涨：1978支</span>
						<span class="c-fall">下跌：835支</span>
					</p>
				</div>
				<div class="item tab-hv-trigger cur">
					<h3 class="icon2">涨跌停</h3>
					<p class="detail">
						<span class="c-rise">涨停：32支</span>
						<span class="c-fall">跌停：6支</span>
					</p>
				</div>
				<div class="item tab-hv-trigger">
					<h3 class="icon3">昨日涨停今日收益</h3>
					<p class="detail">
						<span class="c-rise">今收益：1.79%</span>
					</p>
				</div>
				<div class="item tab-hv-trigger">
					<h3 class="icon3">昨日涨停今日收益</h3>
					<p class="detail">
						<span class="c-rise">今收益：1.79%</span>
					</p>
				</div>
			</div>
			
			<div id=chartsContent >
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

	</body>

</html>