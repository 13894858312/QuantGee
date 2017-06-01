<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>个人中心</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/ucenter/main.css">
</head>

<body>
<div class="header">
    <div class="control">
				<span class="p_center fl">
            <a href="/marketInfo.html" class="logo">
            	<img src="../../images/ucenter/logo.png" width="134px" height="48px"/>
            </a>
            <a href="my.html" target="_self" class="person">个人中心</a>
        </span>
        <div class="hd_right fr">
            <div class="loginedbox">
                <a id="J_username" class="sns_username dib freshIcon" name="accountVO.accountID"><s:property
                        value="accountVO.accountID"/> </a>
                <span class="boundary dib">|</span>
                <a class="c_login dib homeloginout" target="_self" id="header_logined_out" action="logout">退 出</a>
            </div>
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
            <li class="nav-btn person_sel" data-id="zixuan" data-title="我的自选">
                <a href="user_center.html">我的自选</a>
            </li>
            <li class="nav-btn receive" data-id="focus" data-title="我的策略">
                <a href="my_strategy.html">我的策略</a>
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
                <a target="_blank">策略中心</a>
            </li>
        </ul>

        <hr>

        <ul class="outer ta-parent-box" data-taid="wdzx_dh2" data-fid="wdzx_djall">
            <li class="map">
                <a href="account_settings.html">帐号信息</a>
            </li>
        </ul>

        <div class="framebox hot_stock ta-parent-box" data-taid="wdzx_rmgp" data-fid="wdzx_djall">
            <div class="wrap ta-scroll-box" data-scroll-taid="wdzx_llhotstock" id="wdzx-rmgp">
                <h2>上涨股票</h2>
            </div>
            <table>
                <thead>
                <tr>
                    <th>公司</th>
                    <th>涨幅</th>
                    <th>趋势</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="testStrings">
                    <tr>
                        <td>
                            <a target="_blank"><s:property /> </a>
                        </td>
                        <td>1</td>
                        <td><i class="uarr"></i></td>
                    </tr>
                </s:iterator>

                    <tr>
                        <td>
                            <a target="_blank">ddd</a>
                        </td>
                        <td>1</td>
                        <td><i class="uarr"></i></td>
                    </tr>
                    <tr>
                        <td>
                            <a target="_blank">eee</a>
                        </td>
                        <td>1</td>
                        <td><i class="uarr"></i></td>
                    </tr>
                    <tr>
                        <td>
                            <a target="_blank">fff</a>
                        </td>
                        <td>1</td>
                        <td><i class="uarr"></i></td>
                    </tr>
                    <tr>
                        <td>
                            <a target="_blank">ggg</a>
                        </td>
                        <td>1</td>
                        <td><i class="uarr"></i></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="right_content fr">
        <div class="flash_panel clearfix ta-parent-box" data-taid="wdzx_hq" data-fid="wdzx_djall">
            <div class="shangz item">
                <span class="single_flash" data-code="hs_1A0001">上证指数</span>
                <div class="detailnum">
                    <span class="freshval">--</span>
                    <label>
                        <span>--</span>
                        <span>--</span>
                    </label>
                </div>
            </div>
            <div class="shenz item">
                <span class="single_flash" data-code="hs_399001">深证指数</span>
                <div class="detailnum">
                    <span class="freshval">--</span>
                    <label>
                        <span>--</span>
                        <span>--</span>
                    </label>
                </div>
            </div>
            <div class="chuangye item">
                <span class="single_flash" data-code="hs_399006">创业指数</span>
                <div class="detailnum">
                    <span class="freshval">--</span>
                    <label>
                        <span>--</span>
                        <span>--</span>
                    </label>
                </div>
            </div>
            <div class="section fr">
                <div class="wrapSel">
                    <input id="search_input" value="添加自选股" class="addStock">
                    <i class="search"></i>
                    <ul class="autocompleteMine hide"></ul>
                </div>
            </div>
        </div>

        <div class="data_panel ta-parent-box" data-taid="wdzx_hq" data-fid="wdzx_djall">

            <table class="codename fl">
                <thead>
                <tr>
                    <th style="width:120px"><span class="type">全部</span></th>
                    <th class="table_sort" style="width:67px"><i></i><span>当前价</span></th>
                    <th style="width:137px" class="table_sort"><i></i><span>涨跌幅</span></th>
                    <th class="arr_l"><i onselectstart="return false;"></i></th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <table class="colums">
                <thead>
                <tr>
                    <th class="table_sort" style="width:110px;"><i></i><span>成交量(手)</span></th>
                    <th class="table_sort"><i></i><span>成交额</span></th>
                    <th class="table_sort"><i></i><span>市值</span></th>
                    <th class="table_sort"><i></i><span>换手率</span></th>
                    <th class="table_sort"><i></i><span>市盈率</span></th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <table class="colums hide">
                <thead>
                <tr>
                    <th>昨收</th>
                    <th>今开</th>
                    <th>最高</th>
                    <th>最低</th>
                    <th>振幅</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <table class="fr operate">
                <thead>
                <tr>
                    <th class="arr_r"><i onselectstart="return false;"></i></th>
                    <th><i class="fresh"></i></th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <p class="expand">
                <span class="nomore hide">没有更多</span>
                <span class="my-fund hide"
                      onclick="window.open('http://fund.10jqka.com.cn/zixuan/index.html')">自选基金</span>
            </p>
            <div class="loading hide"><img src="http://i.thsi.cn/images/ucenter/website/loading.gif"></div>
        </div>

        <div class="stocklist">
            <div class="head clearfix">
                <ul class="tab-box">
                    <!-- <li class="active" load-type="all">
                <a href="###">全部</a>
            </li>-->
                    <li load-type="sc" class="active">
                        <a class="ta-own-box" data-taid="wdzx_xxsc" data-fid="wdzx_xxall,wdzx_djall" href="###">新闻资讯</a>
                    </li>
                    <li load-type="sd">
                        <a class="ta-own-box" data-taid="wdzx_xxsd" data-fid="wdzx_xxall,wdzx_djall" href="###">策略论坛</a>
                    </li>
                </ul>
            </div>
            <div class="tab-container">
                <!-- <ul class="lists item" load-type="all">
        </ul>-->
                <ul class="item lists ta-parent-box" data-taid="wdzx_xxsc" data-fid="wdzx_xxall,wdzx_djall"
                    load-type="sc">
                    <li load-flag="loadmore" class="loadmore">正在加载...</li>
                </ul>
                <ul class="item lists hide ta-parent-box" data-taid="wdzx_xxsd" data-fid="wdzx_xxall,wdzx_djall"
                    load-type="sd">
                    <li load-flag="loadmore" class="loadmore">正在加载...</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>

</html>