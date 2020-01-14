function init() {

    //myTrvel();

    while ($("#myTr").next()[0] != undefined) {
        $("#myTr").next().remove();
    }

    var custName = getQueryVariable("custName");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/reservation/myResvs?custName=" + custName,
        data: "",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                //创建一行
                var td1 = "<td>" + data[i].type + "</td>";
                var td2 = "<td>" + data[i].name + "</td>";
                var td5 = "<td>" + data[i].price + "</td>";
                var td3 = "<td>" + data[i].cityName + "</td>";
                var td4 = "<td>" + data[i].date + "</td>";
                var td6 = "<td>" + "<a onclick=\"canselResv(\'" + data[i].name + "\',\'" + data[i].type + "\',\'" +data[i].date +"\')\" >" + "取消预约</a></td>";
                var tr = "<tr>" + td1 + td2 + td5 + td3 + td4 + td6 + "</tr>";
                $("#myTr").after(tr);
            }
        },
        error: function (data) {
            console.info(data);
        }
    });


}

//取消预约
function canselResv(name, type,date) {

    var custName = getQueryVariable("custName")

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/reservation/cancel?custName=" + custName + "&type=" + type +"&name="+name+"&date="+date,
        data: "",
        success: function (data) {
            init();
            alert("成功取消");
            return;
        },
        error: function (data) {
            init();
            alert("成功取消");
            return;
        }
    });

}

function myTrvel() {

    var canvas = document.getElementById('canvas');
    var stage = new JTopo.Stage(canvas);
    var scene = new JTopo.Scene();
    stage.mode = "select";
    scene.mode = "select";
    stage.add(scene);

}

init();