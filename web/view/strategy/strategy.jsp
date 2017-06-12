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
		<link rel="shortcut icon" href="../../images/logo20x20.png">
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

		<link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="../../bootstrap/bootstrap-select/css/bootstrap-select.css">
		<link rel="stylesheet" href="../../bootstrap/bootstrap-datepicler/css/bootstrap-datepicker.css" />
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">

		<script type="text/javascript" src="../../bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="../../bootstrap/bootstrap-select/js/bootstrap-select.js"></script>
		<script type="text/javascript" src="../../bootstrap/bootstrap-datepicler/js/bootstrap-datepicker.js"></script>

		<script type="text/javascript" src="../../js/strategy/strategy.js"></script>
		<link rel="stylesheet" href="../../css/style.css" />
		<link rel="stylesheet" href="../../css/strategy/strategy.css" />
		<!--<link rel="stylesheet" href="../../css/strategy/build.css" />-->

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
				<a class="menua" id="a4" href="../../view/trade/trade.jsp" target="_self">模拟交易</a>
			</div>
			<div class="menu" id="ha5">
				<a class="menua" id="a5" href="../../view/ucenter/user_center.jsp" target="_self">个人中心</a>
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
		<div class="strategybar">
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
					<A onMouseover="selectTag('tagContent2',this)" href="javascript:void(0)">双均线策略</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent3',this)" href="javascript:void(0)">羊驼策略</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent4',this)" href="javascript:void(0)">KNN机器学习策略</a>
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
					<h5>均值回归策略</h5> 均值回归（Mean Reversion），是在价格震荡中博取反弹的交易思路，它是基于Poterba和Summers（1987）首先提出的一种现象，如果要用一句话总结，那就是“跌下去的迟早要涨上来”。
					<br />均值回归的理论基于以下观测：价格的波动一般会以它的均线为中心。也就是说，当标的价格由于波动而偏离移动均线时，它将调整并重新归于均线。那么如果我们如果能捕捉偏离股价的回归，就可以从此获利。

					<br />根据均值回归的思路，我们认为一支股票的价格低于其均线越多的时候，它回归的可能性就越大。因此，我们可以以一支股票的价格与其均线的偏离程度作为评估标准，并选择买入该偏离度最高的股票。
					<br />如果用P代表现在的股价，用MA代表均线的价格，那么偏离度是 (MA-P)/MA

					<br />策略具体操作如下：
					<br />1.先决定好参数：选定股票池，以N日移动均线作为比价基准，按每B天为周期调换仓位，以及仓内持有的股票数量num_stocks。
					<br />2.在每个调仓日进行以下操作：
					<br /> （1）计算池内股票的N日移动均线；
					<br /> （2）计算池内所有股票价格与均线的偏离度；
					<br /> （3）选取偏离度最高的num_stocks支股票并进行调仓。
				</div>
				<div class=tagContent id=tagContent2>
					<h4>双均线策略</h4>
					双均线策略，通过建立m天移动均线，n天移动均线，则两条均线必有交点。若m>n，n天均线“上穿越”m天均线则为买入点，反之为卖出店。该策略基于不同天数均线的交叉点，抓住股票的强势和弱势时刻，进行交易。
					<br />
由时间短的均线在下方向上穿越时间长一点的均线，为“金叉”，反之为“死叉”。我们认为，双均线金叉的时候，表明股票很强势，反之很弱势。我们就在强势的时候买入，弱势的时候卖出。
<br />
在这里我们采用指数移动均线，指数移动平均和算术平均或者加权平均的主要区别在于指数移动平均需要进行一个迭代。
<br />
<img src="../../images/strategy/formula.jpg" />
<br />
其中pi表示前一天的收盘价，且 alpah =  (N-1)/(N+1)
<br />

策略具体操作如下：
<br />
在调仓日，同时对所有持仓股票进行判断，哪只金叉了就买入，死叉了就卖出。最大可以同时持有N只股票。
</div>
				<div class=tagContent id=tagContent3>第四个标签</div>
				<div class=tagContent id=tagContent4>第四个标签</div>
			</div>
		</div>

		<div class="strategybar">
			<div class="hmtext">策略演示</div>
		</div>

		<div id="createStockPool">
			<div id="tip">
				<span id="pool_tip">构造股票池</span>
				<ul id=pool_tags>
					<li class="selectTag_Pool">
						<a onclick="selectPoolTag('pool_Content0',this)" href="javascript:void(0)">按板块</a>
					</li>
					<li>
						<A onclick="selectPoolTag('pool_Content1',this)" href="javascript:void(0)">按股票</a>
					</li>
				</ul>
			</div>

			<div class="pool_Content" style="display: block;" id=pool_Content0>
				<span>选择板块</span>
				<select style="height: 40px; width: 100px; margin-left: 10px; background: #FFFFFF;">
					<option value="0">上证</option>
					<option value="1">深证</option>
					<option value="2">中小板</option>
					<option value="3">创业板</option>
				</select>
			</div>

			<div class="pool_Content" id=pool_Content1>
				<div style="height: 40px;">

					<span>选择股票</span>
					<input type="text" placeholder="请输入股票代码" style="
				    width: 250px;
				    margin-left: 15px;
				    border-radius: 6px;
				    border: 1px solid #999;
				    background: #FFFFFF;
				    transition: .3s linear;
				    height: 40px;
				">
					<button style="
				    width: 80px;
				    border-radius: 6px;
				    margin-left: 10px;
				    border: 1px solid #999;
				    background: #FFFFFF;
				    padding: 1px;
				    transition: .3s linear;
				    height: 40px;
				">添加</button>
				</div>

			</div>

		</div>

		<div class="form-group" style="
    margin-left: 15%;
    width: 70%;
    height: 40px;
    display: none;">
			<span style="
    float: left;
    margin-left: 100px;
    line-height: 40px;
    height: 40px;
    font-size: 18px;
	font-family: &quot;Roboto Mono &quot;, monospace;
    font-weight: 100;
    color: #000000;
    background: #FFFFFF;
">选择收藏</span>
			<div class="col-sm-4">
				<select id="usertype" name="usertype" class="selectpicker input-sm form-control" multiple data-live-search="true">
					<option value="0">000001</option>
					<option value="1">600001</option>
					<option value="2">321000</option>
					<option value="3">000123</option>
					<option value="4">300202</option>
					<option value="5">330123</option>
					<option value="6">124002</option>
					<option value="7">423300</option>
					<option value="8">240022</option>
					<option value="9">332003</option>
				</select>
			</div>

			<button style="
width: 80px;
				    border-radius: 6px;
				    margin-left: 10px;
				    border: 1px solid #999;
				    background: #FFFFFF;
				    padding: 1px;
				    transition: .3s linear;
				    height: 40px;				">添加</button>

			<button style="
width: 80px;
				    border-radius: 6px;
				    margin-left: 10px;
				    border: 1px solid #999;
				    background: #FFFFFF;
				    padding: 1px;
				    transition: .3s linear;
				    height: 40px;				">一键添加</button>
		</div>
		<div id="selectedStock" style="margin: 20px auto;display: none;width: 70%;">
			<div style="
			    /* width: 70%; */
			    margin-left: 100px;
			    border-radius: 6px;
			    border: 1px solid rgb(41,29,29);
			    background: #FFFFFF;
			    transition: .3s linear;
			    height: 300px;
			">
				<span style="
			    border-radius: 6px;
    float: left;
    margin-left: 10px;
    line-height: 40px;
    height: 40px;
    font-size: 18px;
    font-weight: 100;
    color: #000000;
    font-family: &quot; Roboto Mono &quot;, monospace;
    background: #FFFFFF;
">股票池</span> </div>

		</div>

		<div id=con_str>
			<span id="chooseStrategy">选择策略</span>
			<ul id=tip_tags>
				<li class=selectTag_str>
					<a onclick="selectStrategyTag('tagContent_str0',this)" href="javascript:void(0)">动量策略</a>
				</li>
				<li>
					<A onclick="selectStrategyTag('tagContent_str1',this)" href="javascript:void(0)">均值回归</a>
				</li>
				<li>
					<A onclick="selectStrategyTag('tagContent_str2',this)" href="javascript:void(0)">双均线策略</a>
				</li>
				<li>
					<A onclick="selectStrategyTag('tagContent_str3',this)" href="javascript:void(0)">羊驼策略</a>
				</li>
				<li>
					<A onclick="selectStrategyTag('tagContent_str4',this)" href="javascript:void(0)">KNN机器学习策略</a>
				</li>
			</ul>
			<div id=tagContent_str>
				<div class="tagContent_str selectTag_str" id=tagContent_str0>
					<form class="param">
						<table class="paramTable">
							<tr>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">开始时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="startTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">结束时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="endTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<div class="initFund">
										<label style="font-weight: 100; width: 64px;">初始资金</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingPeriod">
										<label style="font-weight: 100; width: 64px;">持有期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>

								<th>
									<div class="returnPeriod">
										<label style="font-weight: 100; width: 64px;">形成期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<input type="checkbox" name="category" value="今日话题" style="
									    width: 20px;
									    height: 20px;
									    margin: 0;
									    margin-top: 13px;
									    float: left;
									">
									<label style="font-weight: 100;width: 100px;height: 40px;line-height: 40px;/* margin-bottom: 20px; */">剔除ST股</label>

								</th>
							</tr>
							<tr>
								<th>
									<div class="ratio">
										<label style="font-weight: 100;width: 64px;">持股比例（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>
								<th>
									<div class="stopLoss">
										<label style="font-weight: 100;width: 64px;">止损点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div class="stopProfit">
										<label style="font-weight: 100;width: 64px;">止盈点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>

						</table>
					</form>
				</div>
				<div class=tagContent_str id=tagContent_str1>
					<form class="param">
						<table class="paramTable">
							<tr>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">开始时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="startTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">结束时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="endTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<div class="initFund">
										<label style="font-weight: 100; width: 64px;">初始资金</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingPeriod">
										<label style="font-weight: 100; width: 64px;">持有期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>

								<th>
									<div class="returnPeriod">
										<label style="font-weight: 100; width: 64px;">形成期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<input type="checkbox" name="category" style="
									    width: 20px;
									    height: 20px;
									    margin: 0;
									    margin-top: 13px;
									    float: left;
									">
									<label style="font-weight: 100;width: 100px;height: 40px;line-height: 40px;/* margin-bottom: 20px; */">剔除ST股</label>

								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingStockNum">
										<label style="font-weight: 100;width: 64px;">持股数量</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>
								<th>
									<div class="stopLoss">
										<label style="font-weight: 100;width: 64px;">止损点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div class="stopProfit">
										<label style="font-weight: 100;width: 64px;">止盈点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>

						</table>
					</form>
				</div>
				<div class=tagContent_str id=tagContent_str2>
					<form class="param">
						<table class="paramTable">
							<tr>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">开始时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="startTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">结束时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="endTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<div class="initFund">
										<label style="font-weight: 100; width: 64px;">初始资金</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingPeriod">
										<label style="font-weight: 100; width: 64px;">持有期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>

								<th>
									<div class="returnPeriod">
										<label style="font-weight: 100; width: 64px;">形成期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<input type="checkbox" name="category" style="
									    width: 20px;
									    height: 20px;
									    margin: 0;
									    margin-top: 13px;
									    float: left;
									">
									<label style="font-weight: 100;width: 100px;height: 40px;line-height: 40px;/* margin-bottom: 20px; */">剔除ST股</label>

								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingStockNum">
										<label style="font-weight: 100;width: 64px;">持股数量</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>
								<th>
									<div class="stopLoss">
										<label style="font-weight: 100;width: 64px;">止损点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div class="stopProfit">
										<label style="font-weight: 100;width: 64px;">止盈点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div id="shortReturnPeriod">
										<label style="font-weight: 100;width: 64px;">第二条N日均线</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>

						</table>
					</form>
				</div>
				<div class=tagContent_str id=tagContent_str3>
					<form class="param">
						<table class="paramTable">
							<tr>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">开始时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="startTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">结束时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="endTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<div class="initFund">
										<label style="font-weight: 100; width: 64px;">初始资金</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingPeriod">
										<label style="font-weight: 100; width: 64px;">持有期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>

								<th>
									<div class="returnPeriod">
										<label style="font-weight: 100; width: 64px;">形成期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<input type="checkbox" name="category" style="
									    width: 20px;
									    height: 20px;
									    margin: 0;
									    margin-top: 13px;
									    float: left;
									">
									<label style="font-weight: 100;width: 100px;height: 40px;line-height: 40px;/* margin-bottom: 20px; */">剔除ST股</label>

								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingStockNum">
										<label style="font-weight: 100;width: 64px;">持股数量</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>
								<th>
									<div class="stopLoss">
										<label style="font-weight: 100;width: 64px;">止损点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div class="stopProfit">
										<label style="font-weight: 100;width: 64px;">止盈点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div id="changeNumber">
										<label style="font-weight: 100;width: 64px;">换仓股票数量</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
						</table>
					</form>
				</div>
				<div class=tagContent_str id=tagContent_str4>
					<form class="param">
						<table class="paramTable">
							<tr>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">开始时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="startTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<span style="float: left; height: 35px; line-height: 35px;">结束时间</span>
									<div class="col-xs-12 col-sm-4">
										<div class="endTime" style="width: 100px;">
											<input class="datepicker form-control" type="text" />
										</div>
									</div>
									<script type="text/javascript">
										$('.datepicker').datepicker({
											weekStart: 1,
											color: 'red'
										});
									</script>
								</th>
								<th>
									<div class="initFund">
										<label style="font-weight: 100; width: 64px;">初始资金</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div class="holdingPeriod">
										<label style="font-weight: 100; width: 64px;">持有期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>

								<th>
									<div class="returnPeriod">
										<label style="font-weight: 100; width: 64px;">形成期</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<input type="checkbox" name="category" style="
									    width: 20px;
									    height: 20px;
									    margin: 0;
									    margin-top: 13px;
									    float: left;
									">
									<label style="font-weight: 100;width: 100px;height: 40px;line-height: 40px;/* margin-bottom: 20px; */">剔除ST股</label>

								</th>
							</tr>
							<tr>
								<th>
									<div class="ratio">
										<label style="font-weight: 100;width: 64px;">持股比例（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>

								</th>
								<th>
									<div class="stopLoss">
										<label style="font-weight: 100;width: 64px;">止损点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div class="stopProfit">
										<label style="font-weight: 100;width: 64px;">止盈点（％）</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
							<tr>
								<th>
									<div id="trainPeriod">
										<label style="font-weight: 100;width: 64px;">训练天数</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div id="k">
										<label style="font-weight: 100;width: 64px;">最邻近数量</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
								<th>
									<div id="vectorLength">
										<label style="font-weight: 100;width: 64px;">最邻近向量长度</label>
										<input type="number" style="width: 100px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;">
									</div>
								</th>
							</tr>
						</table>
					</form>

				</div>
			</div>

		</div>
		<div style="text-align: center; margin-top: 10px; height: 40px;">
			<button class="button">开始回测</button>
		</div>

		<div style="height: 100%;"></div>

	</body>

</html>