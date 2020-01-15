$(document).ready(function(){
    showAdminContent();
    searchFlights();

});

function searchFlights(){

    while($("#flightTr").next()[0] != undefined){
        $("#flightTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/flight",
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].flightNum+"</td>";
                var td2 = "<td>"+data[i].price+"</td>";
                var td3 = "<td>"+data[i].numSeats+"</td>";
                var td4 = "<td>"+data[i].fromCity+"</td>";
                var td5 = "<td>"+data[i].arivCity+"</td>";
                var td6 = "<td>"+"<a onclick=\"delFlight(\'"+data[i].flightNum+"\')\" >"+"删除</a></td>";
                var tr = "<tr>"+td1+td2+td3+td4+td5+td6+"</tr>";
                $("#flightTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function addFlight() {
    var param = {
        flightNum:$("#flightNum").val(),
        fromCity:$("#fromCity").val(),
        arivCity:$("#arivCity").val(),
        numSeats:parseInt($("#numSeats").val()),
        price:parseInt($("#price").val())
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/flight",
        data: JSON.stringify(param),
        contentType:"application/json;charset=utf-8",
        success: function(data) {
            searchFlights()
        },
        error: function(data) {
            alert("添加失败！")
        }
    });
}

function delFlight(flightNum) {

    //删除航班
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/flight/delete?id="+flightNum,
        data : "",
        success : function(data) {
            searchFlights();
            alert("删除成功");
            return;
        },
        error : function(data) {
            searchFlights();
            alert("删除成功");
            return;
        }
    });

}

