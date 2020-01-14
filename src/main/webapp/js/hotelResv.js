//查询宾馆
function searchHotel(){

    while($("#hotelTr").next()[0] != undefined){
        $("#hotelTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/hotel/getHotelByParam?cityName="+$("#city").val()+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].hotelName+"</td>";
                var td2 = "<td>"+data[i].price+"</td>";
                var td4 = "<td>"+data[i].numRooms+"</td>";
                var td6 = "<td>"+"<a onclick=\"resevHotel(\'"+data[i].hotelName+"\')\" >"+"预约</a></td>";
                var tr = "<tr>"+td1+td2+td4+td6+"</tr>";
                $("#hotelTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function resevHotel(hotelName) {

    var custName = getQueryVariable("custName")
    //发起预约
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/reservation/hotel?custName="+custName+"&hotelName="+hotelName+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            searchHotel();
            alert("成功预约");
            return;
        },
        error : function(data) {
            searchHotel();
            alert("成功预约");
            return;
        }
    });

}

