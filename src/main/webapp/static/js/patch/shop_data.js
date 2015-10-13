/**
 * Created by user on 2015/5/22.
 */
//消费总金额
var newOldData = new Array();/*[
    {
        label: '新客户',
        value: 60,//线下
        color: "#1abc9c"
    },
    {
        label: '老客户',
        value: 40,//线上
        color: "#f6d36b"
    }
];*/

//性别消费比例
var sexCountData = [

    {
        label: '男性%',
        value: 79,//男性
        color: "#1abc9c"
    },
    {
        label: '女性%',
        value: 21,//女性
        color: "#e97c4c"
    }
];

//客流量
//时间转化函数
var timeplus = 60 * 60 * 1000 * 12;
function gd(year, month, day) {
    return new Date(year, month, day).getTime() + timeplus;
}

var customerFlowData = [
    [gd(2015, 7, 1), 100], //(2015,3,1)日期 7.8客流 单位万
    [gd(2015, 7, 2), 200],
    [gd(2015, 7, 3), 100],
    [gd(2015, 7, 4), 200],
    [gd(2015, 7, 5), 100], //(2015,3,1)日期 7.8客流 单位万
    [gd(2015, 7, 6), 200],
    [gd(2015, 7, 7), 100],
    [gd(2015, 7, 8), 200],
    [gd(2015, 7, 9), 150]
];

var customerRateData = [
    [gd(2015, 7, 1), 50], //(2015,3,1)日期 7.8客流 单位万
    [gd(2015, 7, 2), 50],
    [gd(2015, 7, 3), 50],
    [gd(2015, 7, 4), 60],
    [gd(2015, 7, 5), 50], //(2015,3,1)日期 7.8客流 单位万
    [gd(2015, 7, 6), 50],
    [gd(2015, 7, 7), 50],
    [gd(2015, 7, 8), 60],
    [gd(2015, 7, 9), 40]
];


//消费业态
var consumeSearch = new Array();/*[
    {
        label: '现金',
        value: 1200,//娱乐
        color: "#e97542"
    },
    {
        label: '刷卡',
        value: 1300,//服饰
        color: "#e49d41"
    },
    {
        label: '支付宝',
        value: 890,//电玩
        color: "#f6d36b"
    },
    {
        label: '微信支付',
        value: 4500,//餐饮
        color: "#1abc9c"
    }
];*/
//商品分布
var productRange = [
    {
        label: '龙井',
        value: 100,
        color: "#42DCE9"
    }

];

//年龄分布
var ageRange = [
    {
        label: '20年龄段',
        value: 20,
        color: "#31cd73"
    },
    {
        label: '30年龄段',
        value: 40,
        color: "#1A7EBC"
    },
    {
        label: '40年龄段',
        value: 40,
        color: "#1abc9c"
    }
];


$(document).ready(function () {
    var merchantId = $("#merchantId").val();
    var date = $("#date").val();
    var type = $("#type").val();
    var dataBoxSum = $("#dataBoxSum").val();
    consumeSearch = [{
        label: '现金',
        value: 1340,
        color: "#e97542"
    },
    {
        label: '支付宝',
        value: 890,//电玩
        color: "#f6d36b"
    },
    {
        label: '微信支付',
        value: 450,//餐饮
        color: "#1abc9c"
    }];

    //if(dataBoxSum==0||dataBoxSum==null){
    //    productRange = null;
    //}

    var countSum = 0.00;

    //性别比例
    $.ajax({
        dataType: "json",
        url: "selectMerchantPaySexCount.do",
        data: {
            merchantId: merchantId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            var count = 0;
            for(var i=0;i<data.data.length;i++){
                count += data.data[i].id;
            }
            for(var i=0;i<data.data.length;i++){
                if(data.data[i].merchantname=="0"){
                    sexCountData[1] = {
                        label: '女性%',
                        value: ((data.data[i].id/count)*100).toFixed(2),//女性
                        color: "#f6d36b"
                    };
                }else if(data.data[i].merchantname=="1"){
                    sexCountData[0] = {
                        label: '男性%',
                        value: ((data.data[i].id/count)*100).toFixed(2),//男性
                        color: "#1abc9c"
                    };
                }
            }
        }
    });

    //年龄比例
    $.ajax({
        dataType: "json",
        url: "selectDataBoxToMonthAgeTypeByMerchantId.do",
        data: {
            merchantId: merchantId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            var count = 0;
            for(var i=0;i<data.data.length;i++){
                count += data.data[i].id;
            }
            for(var i=0;i<data.data.length;i++){
                if(data.data[i].itmeType=="15-20") {
                    ageRange[i] = {
                        label:  '15-20年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#42DCE9"
                    };
                }else if(data.data[i].itmeType=="20"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#31cd73"
                    };
                }else if(data.data[i].itmeType=="30"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#1A7EBC"
                    };
                }
                else if(data.data[i].itmeType=="40"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#1abc9c"
                    };
                }
                else if(data.data[i].itmeType=="50"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#e97542"
                    };
                }
                else if(data.data[i].itmeType=="60"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#f6d36b"
                    };
                }
                else if(data.data[i].itmeType=="70"){
                    ageRange[i] = {
                        label: data.data[i].itmeType + '年龄段',
                        value: ((data.data[i].id/count)*100).toFixed(2),
                        color: "#e49d41"
                    };
                }

            }
        }
    });


    //客流量和替代率
    $.ajax({
        dataType: "json",
        url: "selectShopDayUserCountByMerchantId.do",
        data: {
            merchantId: merchantId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            //var count = 0;
            //for(var i=0;i<data.data.length;i++){
            //    customerFlowData[i] = [gd(data.data[i].mobile, data.data[i].deviceno, data.data[i].ibeaconno), data.data[i].id];
            //}
            //for(var i=0;i<data.data1.length;i++){
            //    for(var n=0;n<data.data.length;n++){
            //        if(data.data[n].ibeaconno==data.data1[i].dataDay){
            //            customerRateData[i] = [gd(data.data1[i].dataYear, data.data1[i].dataMonth, data.data1[i].dataDay),((data.data1[i].amount/data.data[n].id)*100).toFixed(2)];
            //        }
            //    }
            //}
        }
    });


    //性别比例
    $.ajax({
        dataType: "json",
        url: "selectByUserNewAndOld.do",
        data: {
            merchantId: merchantId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            newOldData[0] = {
                label: '新客户',
                value: data.newCount.toFixed(2)-35,//线下
                color: "#1abc9c"
            };
            if((data.newCount==null||data.newCount==0)&&(dataBoxSum==null||dataBoxSum==0)) {
                newOldData[1] = {
                    label: '老客户',
                    value: 35,//线上
                    color: "#f6d36b"
                };
            }else{
                newOldData[0] = {
                    label: '新客户',
                    value: 65,//线下
                    color: "#1abc9c"
                };
                newOldData[1] = {
                    label: '老客户',
                    value: 35,//线上
                    color: "#f6d36b"
                };
            }
        }
    });


});