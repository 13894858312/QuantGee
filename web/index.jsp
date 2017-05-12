<%--
  Created by IntelliJ IDEA.
  User: Mark.W
  Date: 2017/5/5
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>MarketInfo</title>
  <script>
      function s1(x) {
          x.style.backgroundColor="#fff";
          x.style.borderLeft="6px solid #000";
      }

      function s2(x) {
          x.style="#f8f8f8";
          x.style.borderLeft="6px solid #f8f8f8";
      }
  </script>
  <style type="text/css">
    @import "style.css";
    @import "style1.css";
  </style>
</head>
<body>
<div class="header fixed">

  <div class="w1200">

    <div class="hdlogo">

      <a target="_blank" class="site-logo" href="http://www.10jqka.com.cn"> <img src="图标.png" title="MyQuantGee" alt="MyQuantGee"></a>

    </div>

    <div class="nav">

      <a data-type="hssc" class="arr-trigger">大盘行情</a>
      <a>个股信息</a>
      <a>板块资讯</a>
      <a>策略大全</a>
      <a data-type="bk" class="arr-trigger ">模拟交易</a>
      <a target="_blank" >个人中心</a>

    </div>

    <div class="login-box">

      <a target="_blank">登录</a>

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
    <div class="head">
      <h2>大盘行情</h2>
    </div>

    <div class="body">
      <div class="middle clearfix">
        <div class="hcharts-list0">

        </div>
        <div class="hcharts-list0-middle">

        </div>
        <div class="hcharts-list0-middle1">

        </div>

      </div>
      <div class="hcharts clearfix">
        <div class="hcharts-left tab-hv-box">
          <div class="hcharts-list">
            <div class="hcharts-left tab-hav-box">
              <div class="hcharts-list">
                <div class="item tab-hv-trigger cur" onmouseover="s1(this)" onmouseout="s2(this)">
                  <h3 class="icons1">涨跌分布</h3>
                  <p class="detail">
                    <span class="c-rise">上涨：0支</span>
                    <span class="c-fall">下跌：0支</span>
                  </p>
                </div>
                <div class="item tab-hv-trigger cur" onmouseover="s1(this)" onmouseout="s2(this)">
                  <h3 class="icon2">涨跌停</h3>
                  <p class="detail">
                    <span class="c-rise">涨停：0支</span>
                    <span class="c-fall">跌停：0支</span>
                  </p>
                </div>
                <div class="item tab-hv-trigger cur" onmouseover="s1(this)" onmouseout="s2(this)">
                  <h3 class="icon3">今日成交量</h3>
                  <p class="detail">
                    <span class="c-rise">买入：0手</span>
                    <span class="c-fall">卖出：0手</span>
                  </p>
                </div>
              </div>
              <div class="hcharts-cont">

              </div>
              <div class="hcharts-right">

              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>