
/**
  * @Author 牛家禾
  * @Date 2017/10/31 13:29
  * @Description 从JSON包数组中取出数据
  * getdataJSON为每笔交易金额数
  * getXJSON为每笔交易的日期
  */
function getallOrdersX(dataall) {
    var data1 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].order_time.time);
    }
    return data1;
}
function getallOrdersY(dataall) {
    var data1 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].total_price);
    }
    return data1;
}



function getsummaryX(dataall) {
    var data1 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].time_value);
    }
    return data1;

}

function getsummaryY1(dataall) {
    var data1 = new Array();

    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].item_order_count);

    }
    return data1;
}
function getsummaryY2(dataall) {
    var data2 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data2.push(datajson[i].item_order_amount);

    }
    return data2;
}

