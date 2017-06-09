<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>账号登录</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/ucenter/main.css">
    <link rel="stylesheet" href="../../css/ucenter/login.css">

    <link rel="shortcut icon" href="../../images/logo20x20.png">

    <style type="text/css">
        @import "../../css/market/market.css";
        @import "../../css/style.css";
    </style>

    <%--<!-- Style -->--%>
    <%--<link rel="stylesheet" href="../../css/index/style.css">--%>

    <script type="text/javascript" src="../../jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/ucenter/login.js"></script>

</head>

<body>
<div class="head">

    <div class="hdlogo">

        <a target="_blank" class="site-logo" href=""> <img src="../../images/quantgeelogo.png" title="MyQuantGee" alt="MyQuantGee"></a>

    </div>

    <div class="menu" id="ha1">
        <a class="menua" id="a1"  href="../../index.jsp">返回首页</a>
    </div>
    <div class="menu" id="ha2">
        <a class="menua" id="a2" href="../../view/market/marketInfo.jsp">进入大盘</a>
    </div>
</div>
<div id="showcasebg">
    <div class="loginbox" id="loginbox">
        <h1>账号登录</h1>
        <form action="login" onsubmit="return validate_login_form()" method="post">
            <input type="text" id="login_userName" name="accountVO.accountID" maxlength="20" onfocus=temp(this)
                   onblur="if(this.value=='') {this.value='请输入帐号';this.style.color='#fff';}" value="请输入帐号"/>
            <p id="login_username_tip"></p>
            <input type="password" id="login_password" name="accountVO.password" placeholder="请输入密码"/>
            <p id="login_password_tip"></p>
            <input type="submit" id="login_submit" class="submit" value="登录"
                   style="width:252px;height: 48px;font-size: 20px;text-align: center;background: #3EC483;"/>
        </form>
        <div class="forget">
            <a id="register1">免费注册</a><span></span>
            <a href="account/ForgetPassword" target="_parent">忘记密码</a>
        </div>
        <input type="hidden" id="returnUrl" value="/">
    </div>

    <div class="registbox" id="registbox">
        <img src="../../images/back.png" onclick="returnLogin()"/>
        <h1>账号注册</h1>

        <form action="register" onsubmit="return validate_register_form()" method="post">
            <input type="text" id="register_userName" name="accountVO.accountID" maxlength="20" onfocus=temp(this)
                   onblur="if(this.value=='') {this.value='请输入帐号';this.style.color='#fff';}" value="请输入帐号"/>
            <p id="register_username_tip"></p>
            <input type="password" id="register_password" name="accountVO.password" placeholder="请输入密码"/>
            <p id="register_password_tip"></p>
            <input type="password" id="register_password_confirm" placeholder="请确认密码"/>
            <p id="register_password_confirm_tip"></p>
            <input type="text" id="register_phoneNumber" name="accountVO.phoneNumber" maxlength="32"
                   onfocus="if(this.value=='请输入手机号码') {this.value='';}this.style.color='#000';"
                   onblur="if(this.value=='') {this.value='请输入手机号码';this.style.color='#fff';}" value="请输入手机号码"/>
            <p id="register_phone_tip"></p>
            <input type="submit" id="register_submit" class="submit" value="注册"
                   style="width:252px;height: 48px; margin-bottom: 0px ; font-size: 20px;text-align: center;background: #3EC483;"/>
        </form>
    </div>

    <div id="image_1" class="showcase" style="background-color:#5bc4f2; ">
        <div class="showarea">
            <img src="../../images/login_background.png" alt="" style="float:left;">
        </div>
    </div>

</div>
</body>

</html>