/**
  * @Author 牛家禾
  * @Date 2017/10/31 13:29
  * @Description 从JSON包数组中取出数据
  * getdataJSON为每笔交易金额数
  * getXJSON为每笔交易的日期
  */
function getdataJSON(dataall) {
    var data1 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].total_price);
    }
    return data1;
}
function getXJSON(dataall) {
    var data1 = new Array();
    var datajson = JSON.parse(dataall);
    for(var i=0,l=datajson.length;i<l;i++) {
        data1.push(datajson[i].order_time);
    }
    return data1;
}

/**
  * @Author 牛家禾
  * @Date 2017/10/31 13:31
  * @Description 从List中取出数据
  * 分别获得X轴数据
  * Y1：每天的交易金额总数
  * Y2：每天的交易金额笔数
  */
function getdataX(dataall) {
    var datasp1=eval("("+dataall+")");
    var dataX = new Array();
    for(var i=0,l=datasp1.length;i<l;i++)
    {
        dataX.push(datasp1[i][0]);

    }
    return dataX;
    
}
function getdataY1(dataall) {
    var datasp1=eval("("+dataall+")");
    var dataY = new Array();
    for(var i=0,l=datasp1.length;i<l;i++)
    {
        dataY.push(datasp1[i][1]);

    }
    return dataY;
}
function getdataY2(dataall) {
    var datasp1=eval("("+dataall+")");
    var dataY = new Array();
    for(var i=0,l=datasp1.length;i<l;i++)
    {
        dataY.push(datasp1[i][2]);

    }
    return dataY;
}


