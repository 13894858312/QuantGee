<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<title>个人中心</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../../css/ucenter/main.css">
		<link rel="stylesheet" type="text/css" href="../../css/ucenter/style.css" />
		<script type="text/javascript" src="../../jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../../js/ucenter/ucenter.js"></script>

		<link rel="stylesheet" href="../../js/ucenter/sweetalert/sweetalert.css" />
		<!--<link rel="stylesheet" href="../../css/sweet-alert.css" />-->
		<script type="text/javascript" src="../../js/ucenter/sweetalert/sweetalert.min.js"></script>
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
			<div>
				<div class="logintext" style="float: right;margin-left: 10px;">
					<a id="la" style="color: rgba(0, 0, 0, 0.6);font-weight: 400;cursor: hand;"></a>
				</div>
				<span id="username" style="
				    float: right;
				    margin-left: 10px;
				    margin-top: 24px;
				    font-size: 20px;
				"></span>
				<div class="logimg" style="float: right;">
					<img src="../../images/headlogin.png">
				</div>
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
					<li class="nav-btn person_sel" data-id="focus" data-title="我的自选">
						<a onclick="changePanel('myStock')">我的自选</a>
					</li>
					<li class="nav-btn receive" data-id="focus" data-title="我的策略">
						<a onclick="changePanel('myStrategy')">我的策略</a>
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
						<a onclick="changePanel('accountSetting')">帐号信息</a>
					</li>
				</ul>

			</div>

			<div class="right_content fr">

				<div id="myStock" class="data_panel ta-parent-box" data-taid="wdzx_hq" data-fid="wdzx_djall" style="display: block;">

					<table class="codename fl">
						<thead>
							<tr style="border: 1px solid #e4f2ff;">
								<th style="width:120px"><span class="type">股票名称</span></th>
								<th style="width:120px"><span class="type">股票代码</span></th>
								<th class="table_sort" style="width:70px"><i></i><span>当前</span></th>
								<th style="width:137px" class="table_sort"><i></i><span>涨跌幅</span></th>
							</tr>
						</thead>
						<tbody id="table1">
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
						<tbody id="table2">
						</tbody>
					</table>
					<table class="colums hide">
						<thead>
							<tr style="border: 1px solid #e4f2ff;">
								<th class="table_sort" style="width:110px;"><i></i><span>昨日收盘价</span></th>
								<th class="table_sort"><i></i><span>今日开盘价</span></th>
								<th class="table_sort"><i></i><span>最高价</span></th>
								<th class="table_sort"><i></i><span>最低价</span></th>
								<th class="table_sort"><i></i><span>换手率</span></th>
							</tr>
						</thead>
						<tbody id="table3">
						</tbody>
					</table>

					<table class="fr operate">
						<thead>
							<tr>
								<th class="arr_r" style="width: 50px ; height: 50px;"><i id="next" onclick="changecolumns()"></i>
								</th>
							</tr>
						</thead>
						<tbody id="table4">
						</tbody>
					</table>

				</div>

			</div>

			<div id="myStrategy" class="data_panel" style="display: none;">
				<table class="codename fl">
					<thead>
						<tr style="border: 1px solid #e4f2ff;">
							<th style="width:120px"><span class="type">策略名称</span></th>
							<th style="width:120px"><span class="type">策略类型</span></th>
							<th class="table_sort" ><i></i><span>初始资金</span></th>
							<th style="width:137px" class="table_sort"><i></i><span>排除ST</span></th>
						</tr>
					</thead>
					<tbody id="table5">
					</tbody>
				</table>
				<table class="colums">
					<thead>
						<tr style="border: 1px solid #e4f2ff;">
							<th class="table_sort" style="width:110px;"><i></i><span>持有期</span></th>
							<th class="table_sort"><i></i><span>形成期</span></th>
							<th class="table_sort"><i></i><span>止损点</span></th>
							<th class="table_sort"><i></i><span>止盈点</span></th>
							<th class="table_sort"><i></i><span>持股比例</span></th>
						</tr>
					</thead>
					<tbody id="table2">
					</tbody>
				</table>
				<table class="colums hide">
					<thead>
						<tr style="border: 1px solid #e4f2ff;">
							<th class="table_sort" style="width:110px;"><i></i><span>持股数量</span></th>
							<th class="table_sort"><i></i><span>短周期N日均线</span></th>
							<th class="table_sort"><i></i><span>换股数量</span></th>
							<th class="table_sort"><i></i><span>训练天数</span></th>
							<th class="table_sort"><i></i><span>最近邻数量</span></th>
						</tr>
					</thead>
					<tbody id="table3">
					</tbody>
				</table>

				<table class="fr operate">
					<thead>
						<tr>
							<th class="arr_r" style="width: 50px ; height: 50px;"><i id="next" onclick="changecolumns()"></i>
							</th>
						</tr>
					</thead>
					<tbody id="table4">
					</tbody>
				</table>
			</div>

			<div id="accountSetting" class="right_bar_tit" style="display: none;float: left;width: 902px;">
				<!--<div>
            <label style="font-size: 30px; font-weight: 100; width: 64px;margin-left: 16px; margin-right: 16px;">账号信息</label>
        </div>-->

				<div id="userInfo_accountID" style="margin-top: 20px;">
					<div style="text-align: center;width: 500px;margin:10px auto;">
						<label style="font-size: 16px; font-weight: 100; width: 64px;margin-left: 16px; margin-right: 16px;">账号</label>
						<input id="accountIDInfo" type="text" style="width: 300px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;" readonly="readonly" />
						<button style="margin-left: 20px; height: 39px; width: 64px;background-color: white;border: 1px solid white;"></button>
					</div>
					<div style="text-align: center;width: 500px;margin: 10px auto;">
						<label style="font-size: 16px; font-weight: 100; width: 64px;">用户昵称</label>
						<input id="usernameInfo" type="text" style="width: 300px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;" readonly="readonly">
						<button onclick="changeInfo('usernameInfo')" style="margin-left: 20px; height: 39px; width: 64px;background-color: white;border: 1px solid lightblue;border-radius: 6px;">
                    修改
                </button>
					</div>
					<div style="text-align: center;width: 500px;margin: 10px auto;">
						<label style="font-size: 16px; font-weight: 100; width: 64px;">手机号码</label>
						<input id="phoneNumber" type="text" style="width: 300px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;" readonly="readonly">
						<button onclick="changeInfo('phoneNumber')" style="margin-left: 20px; height: 39px; width: 64px;background-color: white;border: 1px solid lightblue;border-radius: 6px;">
                    修改
                </button>
					</div>
					<div style="text-align: center;width: 500px;margin:10px auto;">
						<label style="font-size: 16px; font-weight: 100; width: 64px;margin-left: 16px; margin-right: 16px;">密码</label>
						<input id="passwordInfo" type="password" style="width: 300px;margin-left:10px; border: 1px solid rgb(200,200,200);border-radius: 3px;height: 35px;" readonly="readonly">
						<button id="changePasswordBut" onclick="changePassword()" style="margin-left: 20px; height: 39px; width: 64px;background-color: white;border: 1px solid lightblue;border-radius: 6px;">
                    修改密码
                </button>
					</div>
					<div style="text-align: center;width: 500px;margin: 10px auto;">
						<button onclick="submitInfoChagnes()" id="changeInfoButton" class="button" style="margin-left: 20%; height: 39px; width: 50px;background-color: white;border: 1px solid lightblue;border-radius: 6px;display: none;">
                    提交
                </button>
					</div>
				</div>
			</div>

		</div>
	</body>

</html>