
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


/**
  * @Author 牛家禾
  * @Date 2017/11/23 14:32
  * @Description 对于统计结果的获取
  */
function getsyummaryXY(dataall,ruleall){
    var data = new Array();

    var datajson = JSON.parse(dataall);
    var rulejson = JSON.parse(ruleall);


    for(var k=0;k<rulejson.length;k++) {
        data[k] = new Array();
        data[k][0] = new Array();
        data[k][1] = new Array();
        data[k][2] = new Array();
    }
    for(var i=0,l=datajson.length;i<l;i++) {
        for (var j=0;j<rulejson.length;j++){
            if (datajson[i].rule_id == rulejson[j]){
                data[j][0].push(datajson[i].time_value);
                data[j][1].push(datajson[i].item_order_count);
                data[j][2].push(datajson[i].item_order_amount);
                continue;
            }
        }
    }
    return data;

}

