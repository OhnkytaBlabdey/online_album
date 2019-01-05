//判断表单是否为空
let userName = document.getElementById("username");
let password = document.getElementById("password");
function isValid() {
    console.log(userName.value);
    console.log(password.value);
    if(userName.value == "" || password.value == "" || userName.value == " "|| password.value == " "){
        return false;
    }
    return true;
}

//获取焦点图片切换
let left_1 = $(".left_1").eq(0);
let left_2 = $(".left_2").eq(0);
let password_jq = $(password);

password_jq.focus(function () {
    left_1.css("visibility","hidden");
    left_2.css("visibility","visible");
})
password_jq.blur(function () {
    left_1.css("visibility","visible");
    left_2.css("visibility","hidden");
})
