//事件委托
let form = $("#form");
form.on("focus","input",function (event) {
    let target = $(event.target);
    target.css("border-style","solid").css("border-width","2px").css("border-color","orange");
})
form.on("blur","input",function (event) {
    let target = $(event.target);
    let target_id = target.attr("id");
    switch (target_id) {
        case "username":{
            checkUserName(target);
        }break;
        case "password":{
            checkPassword(target)
        }break;
        case "password_repeat":{
            checkPassword_repeat(target)
        }break;
        case "nickname":{
            checkNickname(target);
        }break;
        default:break;
    }
})

//判断用户名输入是否符合要求
function checkUserName(target) {
    let reg = new RegExp("^.{6,10}$");
    let target_temp = target[0];
    if(!reg.test(target_temp.value) || target_temp.value == ""){
        target.css("border-style","solid").css("border-width","3px").css("border-color","red");
    }else{
        target.css("border-style","solid").css("border-width","3px").css("border-color","green");
    }
}
//判断密码是否符合规范
function checkPassword(target){
    let reg = new RegExp("^.{6,10}$");
    let targe_temp = target[0];
    if(!reg.test(targe_temp.value) || targe_temp.value == ""){
        target.css("border-style","solid").css("border-width","3px").css("border-color","red");
    }else{
        target.css("border-style","solid").css("border-width","3px").css("border-color","green");
    }
}
//判断确认密码是否相同
function checkPassword_repeat(target) {
    let password_temp = $("#password");
    if(password_temp.value == target[0].value){
        target.css("border-style","solid").css("border-width","3px").css("border-color","red");
    }else{
        target.css("border-style","solid").css("border-width","3px").css("border-color","green");
    }
}

//判断昵称
function checkNickname(target) {
    let reg = new RegExp("^.{4,10}$");
    let target_temp = target[0];
    if(!reg.test(target_temp.value) || target_temp.value == ""){
        target.css("border-style","solid").css("border-width","3px").css("border-color","red");
    }else{
        target.css("border-style","solid").css("border-width","3px").css("border-color","green");
    }
}
