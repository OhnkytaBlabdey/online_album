//图片轮播
let lock = 1;
let imageContent = $(".imagesContent").eq(0);
let left_arrow_box = $(".left_arrow_box").eq(0);
let right_arrow_box = $(".right_arrow_box").eq(0);

const move_value = 600;
const pre_margin_left = -600;//原有的margin
const pre_margin_right = -3000;

//按钮添加事件
left_arrow_box.mouseenter(function(){
    left_arrow_box.animate({opacity:"0.5"});
});
right_arrow_box.mouseleave(function(){
    right_arrow_box.animate({opacity:"0"});
});
right_arrow_box.mouseenter(function(){
    right_arrow_box.animate({opacity:"0.5"});
});
left_arrow_box.mouseleave(function(){
    left_arrow_box.animate({opacity:"0"});
});

right_arrow_box.click(function () {
    console.log("3");
    if(lock) {
        console.log("4");
        lock = 0;
        let now_margin = parseInt(imageContent.css("margin-left"));
        console.log(now_margin,1);
        now_margin -= move_value;
        imageContent.animate({'marginLeft': now_margin}, function () {
            if(now_margin == -3600){
                imageContent.stop().css("marginLeft",pre_margin_left);
            }
            lock = 1;
        });
    }else{
        return;
    }
});

left_arrow_box.click(function () {
    console.log("1");
    if (lock) {
        console.log("2");
        lock = 0;
        let now_margin = parseInt(imageContent.css("margin-left"));
        console.log(now_margin, 0);
        now_margin += move_value;

        imageContent.animate({'marginLeft': now_margin}, function () {
            if (now_margin == 0) {
                imageContent.stop().css("marginLeft", pre_margin_right);
            }
            lock = 1;
        });
    } else {
        return;
    }
});