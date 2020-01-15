function init() {

    myTrvel();

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

var canvas;
var scene;
var stage;
function myTrvel() {

    //清空所有的节点



    canvas = document.getElementById('canvas');
    stage = new JTopo.Stage(canvas);
    scene = new JTopo.Scene();
    stage.mode = "select";
    scene.mode = "select";
    stage.add(scene);

    var nodes = scene.childs;
    for(var i = 0;i < nodes.length;i ++){
        scene.remove(nodes[i]);
    }

    var custName = getQueryVariable("custName");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/reservation/mytravel?custName=" + custName,
        data: "",
        success: function (data) {

            //有几个航班就是几根线

            var j = 0;
            for(var i =0;i <data.length;i ++){
                //先看城市节点有没有已经生成，如果生成的话，不用在画
                var fromNode = createNodeById(data[i].fromCity,j++);
                var arivNode = createNodeById(data[i].arivCity,j++);
                newLink(fromNode,arivNode,data[i].flightNum);
            }


        },
        error: function (data) {

            console.info(data)
        }
    });


}

$(document).ready(function(){

    showAdminContent();
   init();

});

function createNodeById(id,i){
    var nodes = scene.childs;
    for(var i = 0;i < nodes.length;i ++){
        if(nodes[i].id == id){
            return nodes[i];
        }
    }
    var node = new JTopo.Node(id);
    node.id = id;

    node.setLocation(50+100*i, 26);
    node.fontColor = "0,0,0";
    scene.add(node);
    return node;
}

// 简单连线
function newLink(nodeA, nodeZ, text, dashedPattern){
    var link = new JTopo.Link(nodeA, nodeZ, text);
    link.lineWidth = 3; // 线宽
    //link.dashedPattern = dashedPattern; // 虚线
    link.bundleOffset = 60; // 折线拐角处的长度
    link.bundleGap = 20; // 线条之间的间隔
    link.textOffsetY = 3; // 文本偏移量（向下3个像素）
    link.strokeColor = '0,200,255';
    link.fontColor = "0,0,0";
    link.arrowsRadius = 10;
    scene.add(link);
    return link;
}