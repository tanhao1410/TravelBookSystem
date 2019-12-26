
$(document).ready(function(){
    $("#register").click(function (e) {
        addCust();
    });

    $("#enter").click(function (e) {
        enter();
    });

})

function enter() {

    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/customer/"+$("#custName").val(),
        data : "",
        success : function(data) {
          if(data.password == $("#password").val()){
              window.location.href="/index.html?custName="+$("#custName").val();
          }else{
              alert("密码错误！")
          }

        },
        error : function(data) {
            console.info(data);
        }
    });
}


function addCust() {
    var param = {
        custName:$("#custName").val(),
        password:$("#password").val()
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/customer",
        data: JSON.stringify(param),
        contentType:"application/json;charset=utf-8",
        success: function(data) {
            alert("注册成功")
            window.location.href="/index.html?custName="+$("#custName").val();
        },
        error: function(data) {
            alert("注册失败！")
        }
    });
}