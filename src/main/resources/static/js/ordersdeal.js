
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

function gel(id) { return document.getElementById(id); }
/**
  * @Author 牛家禾
  * @Date 2017/11/23 14:32
  * @Description 对于统计结果的获取
  */
function getsyummaryXY(dataall,ruleall,ruleID){
    var data = new Array();
    var rule_ID_POS = 0;

    var datajson = JSON.parse(dataall);
    var rulejson = JSON.parse(ruleall);

    var rulelist = gel("ruleselect");
    var optionArr = rulelist.getElementsByTagName("option");
    var len = optionArr.length;
    for(var i=0;i<len;i++){
        //将其对应序号的option删除
        rulelist.remove(optionArr[i]);
    }



    for(var k=0;k<rulejson.length;k++) {
        data[k] = new Array();
        data[k][0] = new Array();
        data[k][1] = new Array();
        data[k][2] = new Array();
    }

    for(var i=0;i<rulejson.length;i++){

        var opt = new Option(rulejson[i], rulejson[i]);
        rulelist.options.add(opt);

        if(rulejson[i] == ruleID){
            rule_ID_POS = i;
        }
    }

    rulelist.options[rule_ID_POS].selected = true;

    for(var i=0,l=datajson.length;i<l;i++) {
        for (var j=0;j<rulejson.length;j++){
            if (datajson[i].rule_id == rulejson[j]){

                var str = datajson[i].time_value;
                var rulestr = datajson[i].rule_id+"";

                data[j][0].push(str.substring(0,str.length-rulestr.length));
                data[j][1].push(datajson[i].item_order_count);
                data[j][2].push(datajson[i].item_order_amount);
                continue;
            }
        }
    }


    var series = new Array();
    /*for(var i=0;i<rulejson.length;i++)
    {
        series[2*i] = new Object();
        series[2*i+1] = new Object();
        series[2*i].name = 'Total count-rule'+i;
        series[2*i].data = data[i][1];

        series[2*i+1].name = 'Total price-rule'+i;
        series[2*i+1].data = data[i][2];
    }*/
    series[0] = new Object();
    series[1] = new Object();
    series[0].name = 'Total count-rule'+ruleID;
    series[0].data = data[rule_ID_POS][1];
    series[1].name = 'Total price-rule'+ruleID;
    series[1].data = data[rule_ID_POS][2];

    var dataall = new Object();
    dataall.series=series;
    dataall.dataX = data[rule_ID_POS][0];
    return dataall;
}


