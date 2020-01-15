
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
              console.info(data);
              if(data.type == 0){
                  window.location.href="/index.html?custName="+$("#custName").val()+"&type=admin";
              }else{
                  window.location.href="/index.html?custName="+$("#custName").val()+"&type=normal";
              }

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
        password:$("#password").val(),
        type:1
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/customer",
        data: JSON.stringify(param),
        contentType:"application/json;charset=utf-8",
        success: function(data) {
            alert("注册成功")
            window.location.href="/index.html?custName="+$("#custName").val()+"&type=normal";
        },
        error: function(data) {
            alert("注册失败！")
        }
    });
}