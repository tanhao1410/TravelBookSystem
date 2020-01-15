function flightManagerPage(){
    window.location.href="/flight.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}
//进入出租车管理页面
function carManagerPage(){
    window.location.href="/car.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}

//进入旅馆管理页面
function hotelManagerPage(){
    window.location.href="/hotel.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}

//进入航班预约页面
function flightPage(){
    window.location.href="/flightResv.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}
//进入出租车预约页面
function carResvPage(){
    window.location.href="/carResv.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}

//进入宾馆预约页面
function hotelResvPage(){
    window.location.href="/hotelResv.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}

function custManagerPage(){
    window.location.href="/index.html?custName="+getQueryVariable("custName")+"&type="+getQueryVariable("type");
}

function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

function showAdminContent(){
    $(".admin").show();
}