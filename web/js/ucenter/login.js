function register() {
    document.getElementById("test").innerHTML = "用户注册";
    var x = document.getElementById("loginbox");
    x.style.display = "none";
//  document.setTitle("用户注册");
    document.getElementById("registbox").style.display = "inherit";
}

function returnLogin() {
    document.getElementById("test").innerHTML = "用户登陆";
    var x = document.getElementById("registbox");
    x.style.display = "none";
    document.getElementById("loginbox").style.display = "inherit";
}

function validate_login_form() {
    var username = document.getElementById("login_userName");
    var username_tip = document.getElementById("login_username_tip");
    username_tip.innerHTML = "";
    var password = document.getElementById("login_password");
    var password_tip = document.getElementById("login_password_tip");
    password_tip.innerHTML = "";
    if (username.value == null || username.value == "" || username.value == "请输入帐号") {
        username_tip.innerHTML = "请输入帐号";
        username_tip.style.color = "red";
        username.focus();
        return false;
    }
    if (password.value == null || password.value == "" || password.value == "请输入密码") {
        password_tip.innerHTML = "请输入密码";
        password_tip.style.color = "red";
        password.focus();
        return false;
    }

}

function validate_register_form() {
    var username = document.getElementById("register_userName");
    var username_tip = document.getElementById("register_username_tip");
    username_tip.innerHTML = "";
    var password = document.getElementById("register_password");
    var password_tip = document.getElementById("register_password_tip");
    password_tip.innerHTML = "";
    var password_confirm = document.getElementById("register_password_confirm");
    var password_confirm_tip = document.getElementById("register_password_confirm_tip");
    password_confirm_tip.innerHTML = "";
    var phone = document.getElementById("register_phoneNumber");
    var phone_tip = document.getElementById("register_phone_tip");
    phone_tip.innerHTML = "";
    if (username.value == null || username.value == "" || username.value == "请输入帐号") {
        username_tip.innerHTML = "请输入帐号";
        username_tip.style.color = "red";
        username.focus();
        return false;
    }
    if (password.value == null || password.value == "" || password.value == "请输入密码") {
        password_tip.innerHTML = "请输入密码";
        password_tip.style.color = "red";
        password.focus();
        return false;
    }
    
    if(password.value != password_confirm.value){
    		password_confirm_tip.innerHTML = "两次密码不一致";
    		password_confirm_tip.style.color = "red";
    		password_confirm.focus();
    		return false;
    }
    
    if (phone.value == null || phone.value == "" || phone.value == "请输入手机号码") {
        phone_tip.innerHTML = "请输入手机号码";
        phone_tip.style.color = "red";
        phone.focus();
        return false;
    }

}


function temp(input) {
    if (input.value == '请输入帐号') {
        input.value = '';
    }
    input.style.color = '#000';
}