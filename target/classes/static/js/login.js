layui.use('layer', function(){ //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

    $("#login").click(function () {
        $.ajax({
            url: '/api/sso/api/login',
            type:'post',
            dataType:'json',
            data:{
                username:$("#username").val(),
                password:$("#password").val()
            },
            success:function (data) {
                if (data.meta.success){
                    localStorage.setItem("token",data.data.token);
                    location.href = "/index.html";
                }else{
                    layer.msg("用户信息不存在");
                }
            },
            error:function (error) {
                layer.msg("网络已断开了");
            }
        })
    })

});
