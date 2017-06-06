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
	</head>

	<body>
		<div class="header fixed">

			<div class="w1200">

				<div class="hdlogo">

					<a target="_blank" class="site-logo" href="n"> <img src="../../images/theLogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

				</div>

				<div class="nav">

					<a href="../../view/market/marketInfo.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
					<a href="../../view/stock/stockFirst.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
					<a href="../../view/industry/industry.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">行业资讯</a>
					<a href="strategy.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
					<a href="../../view/trade/trade.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
					<a href="../../view/ucenter/user_center.jsp" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

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
		<div style="margin-left: 5%; margin-top: 1%; vertical-align: middle;">
			<img src="../../images/标签1.png" style="width: 80px;height: 50px;" />
			<span style="font-weight: bold; font-size: 18px; ">策略展示</span>
		</div>
		<div id=con>
			<ul id=tags>
				<li class=selectTag>
					<a onMouseover="selectTag('tagContent0',this)" href="javascript:void(0)">标签1</a>
				</li>
				<li>
					<A onMouseover="selectTag('tagContent1',this)" href="javascript:void(0)">标签2</a>
					<li>
						<li>
							<A onMouseover="selectTag('tagContent2',this)" href="javascript:void(0)">自适应宽度的标签</a>
						</li>
						<li>
							<A onMouseover="selectTag('tagContent3',this)" href="javascript:void(0)">自适应宽度</a>
						</li>
			</ul>
			<div id=tagContent>
				<div class=tagContent id=tagContent0>第一个标签</div>
				<div class="tagContent selectTag" id=tagContent1>第二个标签</div>
				<div class=tagContent id=tagContent2>第三个标签</div>
				<div class=tagContent id=tagContent3>第四个标签</div>
			</div>
		</div>
	</body>

</html>