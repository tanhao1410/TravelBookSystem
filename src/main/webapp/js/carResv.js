//查询航班
function searchCar(){

    while($("#flightTr").next()[0] != undefined){
        $("#flightTr").next().remove();
    }
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/car/getCarByParam?cityName="+$("#cityName").val()+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            for(var i =0;i <data.length;i ++){
                //创建一行
                var td1 = "<td>"+data[i].carNum+"</td>";
                var td2 = "<td>"+data[i].price+"</td>";
                var td5 = "<td>"+data[i].cityName+"</td>";
                var td6 = "<td>"+"<a onclick=\"resevCar(\'"+data[i].carNum+"\')\" >"+"预约</a></td>";
                var tr = "<tr>"+td1+td2+td5+td6+"</tr>";
                $("#flightTr").after(tr);
            }
        },
        error : function(data) {
            console.info(data);
        }
    });
}

function resevCar(carNum) {

    var custName = getQueryVariable("custName")
    //发起预约
    $.ajax({
        type : "GET",
        dataType : "json",
        url : "/reservation/car?custName="+custName+"&carNum="+carNum+"&date="+$("#date").val(),
        data : "",
        success : function(data) {
            searchCar();
            alert("成功预约");
            return;
        },
        error : function(data) {
            searchCar();
            alert("成功预约");
            return;
        }
    });

}
$(document).ready(function(){

    showAdminContent();

});
