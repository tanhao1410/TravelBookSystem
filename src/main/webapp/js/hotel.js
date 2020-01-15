$(document).ready(function(){
    showAdminContent();
    searchHotels();
});

function searchHotels(){

    while($("#HotelTr").next()[0] != undefined){
        $("#HotelTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/hotel",
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].hotelName+"</td>";
                var td3 = "<td>"+data[i].price+"</td>";
                var td2 = "<td>"+data[i].cityName+"</td>";
                var td4 = "<td>"+data[i].numRooms+"</td>";
                var td5 = "<td>"+"<a onclick=\"delHotel(\'"+data[i].hotelName+"\')\" >"+"删除</a></td>";
                var tr = "<tr>"+td1+td2+td3+td4+td5+"</tr>";
                $("#HotelTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function addHotel() {
    var param = {
        hotelName:$("#hotelName").val(),
        cityName:$("#cityName").val(),
        price:parseInt($("#price").val()),
        numRooms:parseInt($("#numRooms").val())
    };
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/hotel",
        data: JSON.stringify(param),
        contentType:"application/json;charset=utf-8",
        success: function(data) {
            searchHotels()
        },
        error: function(data) {
            alert("添加失败！")
        }
    });
}

function delHotel(hotelName) {

    //删除航班
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/hotel/delete?id="+hotelName,
        data : "",
        success : function(data) {
            searchHotels();
            alert("删除成功");
            return;
        },
        error : function(data) {
            searchHotels();
            alert("删除成功");
            return;
        }
    });

}

