<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 2017/6/6
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>QuantGee &mdash; 股票数据专家</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="股票数据系统quantgee" />
    <meta name="keywords" content="quantgee,股票,股票信息,模拟炒股,策略回测" />


    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="images/logo20x20.png">

    <link href="https://fonts.googleapis.com/css?family=Roboto+Mono:300,400" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/index/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/index/icomoon.css">
    <!-- Simple Line Icons -->
    <link rel="stylesheet" href="css/index/simple-line-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/index/bootstrap.css">
    <!-- Style -->
    <link rel="stylesheet" href="css/index/style.css">


    <!-- Modernizr JS -->
    <script src="js/index/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/index/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<header role="banner" id="fh5co-header">
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="navbar-header">
                    <!-- Mobile Toggle Menu Button -->
                    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                    <a class="navbar-brand" href="index.jsp">QuantGee</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#" data-nav-section="home"><span>网站首页</span></a></li>
                        <li><a href="#" data-nav-section="explore"><span>功能简介</span></a></li>
                        <li><a href="#" data-nav-section="aboutus"><span>关于我们</span></a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>

<section id="fh5co-home" data-section="home" style="background-image: url(images/full_image_3.png);" data-stellar-background-ratio="0.5">
    <div class="gradient"></div>
    <div class="container">
        <div class="text-wrap">
            <div class="text-inner">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center">
                        <h1 class="animate-box"><span> </span><br><span class="big">QuantGee</span> <br><span>您身边的股票数据专家</span> <br><br><br><br><span>code by RGXD from NJU in 2017</span><br></h1>
                        <h2 class="animate-box">source code ：<a href="https://github.com/13894858312/QuantGee" target="_blank" title="Free HTML5 Bootstrap Templates" class="fh5co-link">GITHUB</a></h2>
                        <div class="call-to-action">
                            <a href="view/market/marketInfo.jsp" class="demo animate-box">进入大盘</a>
                            <a href="view/ucenter/login.jsp" class="download animate-box">用户登录</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="fh5co-explore" data-section="explore">
    <div class="container">
        <div class="row">
            <div class="col-md-12 section-heading text-center">
                <h2 class="animate-box">主要功能</h2>
            </div>
        </div>
    </div>
    <div class="fh5co-project">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a>
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-1.jpeg);">
                                <div class="desc">
                                    <p>展示每日大盘实时信息，涨跌龙虎榜等投资信息。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>大盘行情</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a>
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-2.jpeg);">
                                <div class="desc">
                                    <p>提供单支股票信息，股票可加入收藏以便查看。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>个股信息</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a >
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-3.jpeg);">
                                <div class="desc">
                                    <p>提供最新鲜的股票相关资讯，供您投资参考。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>新闻资讯</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a>
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-4.jpeg);">
                                <div class="desc">
                                    <p>以历史数据计算您的策略收益率。支持自定义策略的分享与收藏。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>策略回测</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a >
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-5.jpeg);">
                                <div class="desc">
                                    <p>采用机器学习算法预测下一交易日的股票走势，助您一臂之力。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>股票预测</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="fh5co-portfolio animate-box">
                        <a >
                            <div class="portfolio-entry" style="background-image: url(images/portfolio-6.jpeg);">
                                <div class="desc">
                                    <p>实盘虚拟交易，锻炼您的投资技巧。</p>
                                </div>
                            </div>
                            <div class="portfolio-text text-center"><br>
                                <h3>模拟交易</h3>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="fh5co-aboutus" data-section="aboutus">
    <div id="fh5co-footer" role="contentinfo">
        <div class="container">
            <div class="row">
                <div class="animate-box col-md-6">
                    <h3 class="section-title">关于我们</h3>
                    <p>
                        王友运：151250150
                        <br>
                        卞纯源：151250002
                        <br>
                        王  雪：151250149
                        <br>
                        赵德宇：151250197
                    </p>

                </div>

                <div class="animate-box col-md-6">
                    <h3 class="section-title">联系方式</h3>
                    <ul class="contact-info">
                        <li><i class="icon-map"></i>江苏省 南京市 栖霞区 仙林大道163号</li>
                        <li><i class="icon-phone"></i>138 9485 8312</li>
                        <li><i class="icon-envelope"></i>151250150@smail.nju.edu.cn</li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"><br>
                    <p class="copy-right">&copy; 2017 王友运 卞纯源 王雪 赵德宇 All Rights Reserved. </p>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- jQuery -->
<script src="js/index/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/index/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/index/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/index/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="js/index/jquery.stellar.min.js"></script>
<!-- Counters -->
<script src="js/index/jquery.countTo.js"></script>
<!-- Main JS (Do not remove) -->
<script src="js/index/main.js"></script>

</body>

<body>

</body>
</html>
