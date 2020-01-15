//查询航班
function searchFlight(){

    while($("#flightTr").next()[0] != undefined){
        $("#flightTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/flight/getFlightByParam?fromCity="+$("#fromCity").val()+"&arivCity="+$("#arivCity").val()+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].flightNum+"</td>";
                var td2 = "<td>"+data[i].price+"</td>";
                var td5 = "<td>"+data[i].numSeats+"</td>";
                var td3 = "<td>"+data[i].fromCity+"</td>";
                var td4 = "<td>"+data[i].arivCity+"</td>";
                var td6 = "<td>"+"<a onclick=\"resevFlight(\'"+data[i].flightNum+"\')\" >"+"预约</a></td>";
                var tr = "<tr>"+td1+td2+td3+td4+td5+td6+"</tr>";
                $("#flightTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function resevFlight(flightNum) {

    var custName = getQueryVariable("custName")
    //发起预约
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/reservation/flight?custName="+custName+"&flightNum="+flightNum+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            searchFlight();
            alert("成功预约");
            return;
        },
        error : function(data) {
            searchFlight();
            alert("成功预约");
            return;
        }
    });

}

$(document).ready(function(){

    showAdminContent();

});