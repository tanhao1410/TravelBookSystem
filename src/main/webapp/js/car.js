$(document).ready(function(){
    showAdminContent();
    searchCars();

});

function searchCars(){

    while($("#CarTr").next()[0] != undefined){
        $("#CarTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/car",
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].carNum+"</td>";
                var td3 = "<td>"+data[i].price+"</td>";
                var td2 = "<td>"+data[i].cityName+"</td>";
                var td4 = "<td>"+"<a onclick=\"delCar(\'"+data[i].carNum+"\')\" >"+"删除</a></td>";
                var tr = "<tr>"+td1+td2+td3+td4+"</tr>";
                $("#CarTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function addCar() {
    var param = {
        carNum:$("#carNum").val(),
        cityName:$("#cityName").val(),
        price:parseInt($("#price").val())
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/car",
        data: JSON.stringify(param),
        contentType:"application/json;charset=utf-8",
        success: function(data) {
            searchCars()
        },
        error: function(data) {
            alert("添加失败！")
        }
    });
}

function delCar(carNum) {

    //删除航班
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/car/delete?id="+carNum,
        data : "",
        success : function(data) {
            searchCars();
            alert("删除成功");
            return;
        },
        error : function(data) {
            searchCars();
            alert("删除成功");
            return;
        }
    });

}

