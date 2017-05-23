<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MarketInfo</title>
    <script src="../../echarts.js"></script>
    <script src="../../jquery-3.2.1.min.js"></script>
    <script src="../../js/test.js"></script>
    <script>
        function s1(x) {
            x.style.fontWeight = "bold";
            x.style.color = "#fff";
        }
        function s2(x) {
            x.style.fontWeight = "400";
            x.style.color = "#b7b7b7";
        }
        function s3(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            first.style.backgroundColor="#e0eee0";
            first.style.borderLeft="6px solid #000";
            second.style.backgroundColor="#ffffff";
            second.style.borderLeft="6px solid #ffffff";
            third.style.backgroundColor="#ffffff";
            third.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="block";
            graph2.style.display="none";
            graph3.style.display="none";
        }
        function s5(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            second.style.backgroundColor="#e0eee0";
            second.style.borderLeft="6px solid #000";
            first.style.backgroundColor="#ffffff";
            first.style.borderLeft="6px solid #ffffff";
            third.style.backgroundColor="#ffffff";
            third.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="none";
            graph2.style.display="block";
            graph3.style.display="none";
        }
        function s7(x) {
            var first=document.getElementById("first");
            var second=document.getElementById("second");
            var third=document.getElementById("third");
            third.style.backgroundColor="#e0eee0";
            third.style.borderLeft="6px solid #000";
            second.style.backgroundColor="#ffffff";
            second.style.borderLeft="6px solid #ffffff";
            first.style.backgroundColor="#ffffff";
            first.style.borderLeft="6px solid #ffffff";
            var graph1=document.getElementById("gram");
            var graph2=document.getElementById("line");
            var graph3=document.getElementById("line1");
            graph1.style.display="none";
            graph2.style.display="none";
            graph3.style.display="block";
        }
    </script>
    <style type="text/css">
        @import "../../css/market/market.css";
        @import "../../css/style1.css";
    </style>
</head>
<body>
    <div class="header fixed">

        <div class="w1200">

            <div class="hdlogo">

                <a target="_blank" class="site-logo" href="http://www.10jqka.com.cn"> <img src="../../images/图标.png" title="MyQuantGee" alt="MyQuantGee"></a>

            </div>

            <div class="nav">

                <a onmouseover="s1(this)" onmouseout="s2(this)">大盘行情</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">个股信息</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">板块资讯</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">策略大全</a>
                <a onmouseover="s1(this)" onmouseout="s2(this)">模拟交易</a>
                <a href="../../view/ucenter/user_center.html" target="_blank" onmouseover="s1(this)" onmouseout="s2(this)">个人中心</a>

            </div>

            <div class="login-box">

                <a href="../../view/ucenter/login.html" target="_blank">登录</a>

            </div>

            <div class="logined_box hide fr">

                <a href="http://stock.10jqka.com.cn/my/" target="_blank" id="J_username" style="background-position: 100% 40px;">linhanzi</a>

                <span>|</span>

                <a href="javascript:;" id="header_logined_out" target="_self" class="homeloginout">退出</a>

            </div>

        </div>

    </div>
    <div class="container w1200">
        <div class="box">
            <div class="head-img">
                <img src="../../images/标签1.png" width="80" height="50">
            </div>
            <div class="head-text">
                大盘指数
            </div>
        </div>
            <div class="KLine">
                <div class="klineimg">
                    <img src="../../images/kline.png" width="67" height="67">
                </div>
                <div class="klinetext">
                    <h3 class="icons1">近期K线趋势</h3>
                    <p class="detail">
                        <span class="c-rise">最高点：0支</span>
                        <span class="c-fall">最低点：0支</span>
                        <span class="start">起始日期：</span>
                        <span class="d1"><input type="date"></span>
                        <span class="end">结束日期：</span>
                        <span class="d2"><input type="date"></span>
                        <span class="button"><button type="button" onclick="test()">查询</button></span>
                    </p>
                </div>
                <div class="klinegraph" id="kline"></div>
                <script type="text/javascript" src="../../js/KLine.js"></script>
            </div>
        <div class="box1">
            <div class="head-img">
                <img src="../../images/标签1.png" width="80" height="50">
            </div>
            <div class="head-text">
                大盘数据
            </div>
        </div>
        <div class="middle">
            <div class="hcharts clearfix">
                <div class="hcharts-left tab-hv-box">
                    <div class="hcharts-list">
                        <div class="hcharts-left tab-hav-box">
                            <div class="hcharts-list">
                                <div class="item tab-hv-trigger cur" id="first" onmouseover="s3(this)" style="background-color: #e0eee0;border-left: 6px solid #000">
                                    <h3 class="icons1" style="margin-left: 0px">涨跌分布</h3>
                                    <p class="detail">
                                        <span class="c-rise">上涨：0支</span>
                                        <span class="c-fall">下跌：0支</span>
                                    </p>
                                </div>
                                <div class="item tab-hv-trigger cur" id="second" onmouseover="s5(this)">
                                    <h3 class="icon2">涨跌停</h3>
                                    <p class="detail">
                                        <span class="c-rise">涨停：0支</span>
                                        <span class="c-fall">跌停：0支</span>
                                    </p>
                                </div>
                                <div class="item tab-hv-trigger cur" id="third" onmouseover="s7(this)">
                                    <h3 class="icon3">今日成交量</h3>
                                    <p class="detail">
                                        <span class="c-rise">买入：0手</span>
                                        <span class="c-fall">卖出：0手</span>
                                    </p>
                                </div>
                            </div>
                            <div class="hcharts-cont1" id="gram"></div>
                            <script type="text/javascript" src="../../js/gram.js"></script>
                            <div class="hcharts-cont2" id="line"></div>
                            <script type="text/javascript" src="../../js/line.js"></script>
                            <div class="hcharts-cont3" id="line1"></div>
                            <script type="text/javascript" src="../../js/line1.js"></script>
                            <div class="hcharts-right" id="">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="g1" id="g1"></div>
            <script type="text/javascript" src="../../js/g1.js"></script>
            <div class="g2" id="g2"></div>
            <script type="text/javascript" src="../../js/g2.js"></script>
            <div class="g3" id="g3"></div>
            <script type="text/javascript" src="../../js/g3.js"></script>
        </div>
        <div class="box2">
            <div class="head-img">
                <img src="../../images/标签1.png" width="80" height="50">
            </div>
            <div class="head-text">
                个股行情
            </div>
        </div>

        </div>

</body>
</html>