function buttonInit(){

    $("#register")[0].onclick = function(){
        //

        var custName = $("#custName").val();
        var custPass = $("#custPass").val();

        var param = {

        };

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/customer",
            data: JSON.stringify(param),
            contentType:"application/json;charset=utf-8",
            success: function(data) {
                alert("注册成功")
            },
            error: function(data) {
                console.info(data)
                return;
            }
        });
        //

    }

    $("#enter")[0].onclick = function(){

    }

}
