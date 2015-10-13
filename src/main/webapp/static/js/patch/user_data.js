$(document).ready(function () {
    var userId = $("#userId").val();
    var mobile = $("#mobile").val();

    $.ajax({
        dataType : "json",
        url : "searchDataBoxToMonthData.do",
        data : {userId:userId},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                var myArray = new Array();
                myArray[0] = gd(data.data[i].dataYear, data.data[i].dataMonth, data.data[i].dataDay);
                myArray[1] = data.data[i].amount;
                userCostData[i] = myArray ;
            }
        }
    });

    $.ajax({
        dataType : "json",
        url : "searchDataBoxToMonthItemTypeData.do",
        data : {mobile:mobile},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                if(data.data[i].itemTypeName=="娱乐") {
                    userCostSearch[i] = {label: data.data[i].itemTypeName, value: data.data[i].amount, color: "#e97542"};
                    $("div.col-sm-4.col-sm-offset-2.sales-info.user-cost-info").find("span").eq(0).text("娱乐 ("+data.data[i].amount+")");
                }else if(data.data[i].itemTypeName=="服饰"){
                    userCostSearch[i] = {label: data.data[i].itemTypeName, value: data.data[i].amount, color: "#e49d41"};
                    $("div.col-sm-4.col-sm-offset-2.sales-info.user-cost-info").find("span").eq(1).text("服饰 ("+data.data[i].amount+")");
                }else if(data.data[i].itemTypeName=="电玩"){
                    userCostSearch[i] = {label: data.data[i].itemTypeName, value: data.data[i].amount, color: "#f6d36b"};
                    $("div.col-sm-4.col-sm-offset-2.sales-info.user-cost-info").find("span").eq(2).text("电玩 ("+data.data[i].amount+")");
                }else{
                    userCostSearch[i] = {label: data.data[i].itemTypeName, value: data.data[i].amount, color: "#1abc9c"};
                    $("div.col-sm-4.col-sm-offset-2.sales-info.user-cost-info").find("span").eq(3).text("餐饮 ("+data.data[i].amount+")");
                }
            }
            //userCostSearch = data.data;
        }
    });

    $.ajax({
        dataType : "json",
        url : "selectCountTimeOnShopData.do",
        data : {mobile:mobile},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                wifiData[i] = [i,data.data[i].residenceTime] ;
                wifiTick[i] = [i,data.data[i].shopName];
            }
        }
    });



    $.ajax({
        dataType : "json",
        url : "selectTrafficShopByUser.do",
        data : {mobile:mobile},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                var dataEnter = new Array();
                var dataLeave = new Array();
                $.ajax({
                    dataType : "json",
                    url : "selectTrafficShopByUserTime.do",
                    data : {
                            shopId:data.data[i].shopId,
                            mobile:mobile
                            },
                    async:false,
                    success : function(dataTime) {
                        for(var n=0;n<dataTime.data.length;n++) {
                            dataEnter[n] = [gd(dataTime.data[n].dataYear, dataTime.data[n].dataMonth, dataTime.data[n].dataDay), timeTrans(dataTime.data[n].enterTime)];
                            dataLeave[n] = [gd(dataTime.data[n].dataYear, dataTime.data[n].dataMonth, dataTime.data[n].dataDay), timeTrans(dataTime.data[n].leaveTime)];
                        }
                    }
                });
                if(i==0) {
                    enter_shopDataSet[i] = {
                        label: data.data[i].shopName,
                        data: dataEnter,
                        points: {symbol: "triangle"}
                    };
                    leave_shopDataSet[i] = {
                        label: data.data[i].shopName,
                        data: dataLeave,
                        points: {symbol: "triangle"}
                    };
                }else{
                    enter_shopDataSet[i] = {
                        label: data.data[i].shopName,
                        data: dataEnter
                    };
                    leave_shopDataSet[i] = {
                        label: data.data[i].shopName,
                        data: dataLeave
                    };
                }
            }
        }
    });

    $.ajax({
        dataType : "json",
        url : "selectParkingUserPayTypeCount.do",
        data : {mobile:mobile},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                if(data.data[i].payType=="0") {
                    parkingPay[i] = {
                        label: '现金(%)',
                        value: (data.data[i].payable / data.countPay).toFixed(2) * 100,
                        color: "#e97542"
                    };
                    $("div.col-sm-4.col-sm-offset-3.sales-info.user-cost-info").find("span").eq(0).text("现金 ("+(data.data[i].payable / data.countPay).toFixed(2) * 100+"%)");
                }else if(data.data[i].payType=="1") {
                    parkingPay[i] = {
                        label: '支付宝(%)',
                        value: (data.data[i].payable / data.countPay).toFixed(2) * 100,
                        color: "#e49d41"
                    };
                    $("div.col-sm-4.col-sm-offset-3.sales-info.user-cost-info").find("span").eq(1).text("支付宝 ("+(data.data[i].payable / data.countPay).toFixed(2) * 100+"%)");
                }else if(data.data[i].payType=="2") {
                    parkingPay[i] = {
                        label: '微信(%)',
                        value: (data.data[i].payable / data.countPay).toFixed(2) * 100,
                        color: "#f6d36b"
                    };
                    $("div.col-sm-4.col-sm-offset-3.sales-info.user-cost-info").find("span").eq(2).text("微信 ("+(data.data[i].payable / data.countPay).toFixed(2) * 100+"%)");
                }else if(data.data[i].payType=="3") {
                    parkingPay[i] = {
                        label: '银联刷卡(%)',
                        value: (data.data[i].payable / data.countPay).toFixed(2) * 100,
                        color: "#1CAF9A"
                    };
                    $("div.col-sm-4.col-sm-offset-3.sales-info.user-cost-info").find("span").eq(3).text("银联刷卡 ("+(data.data[i].payable / data.countPay).toFixed(2) * 100+"%)");
                }
            }


            for(var i=0;i<data.parkingDetailsEnter.length;i++){
                inSearch[i] = {
                    label: data.parkingDetailsEnter[i].entryPlace,
                    value: data.parkingDetailsEnter[i].id,
                    color: "#e97542"
                };
            }

            for(var i=0;i<data.parkingDetailsLeave.length;i++){
                outSearch[i] = {
                    label: data.parkingDetailsLeave[i].leavePlace,
                    value: data.parkingDetailsLeave[i].id,
                    color: "#3"+(i+2)+"cd7"+(i+3)
                };
            }
        }
        //出入口


    });


    $.ajax({
        dataType : "json",
        url : "selectScreenvideoCoutent.do",
        data : {mobile:mobile},
        async:false,
        success : function(data) {
            for(var i=0;i<data.data.length;i++) {
                var advDataCount = new Array();
                $.ajax({
                    dataType : "json",
                    url : "selectScreenvideoCoutentCount.do",
                    data : {mobile:mobile,content:data.data[i].content},
                    async:false,
                    success : function(dataCount) {
                        for(var n=0;n<dataCount.data.length;n++) {
                            advDataCount[n] = [gd(parseInt(dataCount.data[n].touchid), parseInt(dataCount.data[n].url), parseInt(dataCount.data[n].mobile)), dataCount.data[n].id];
                        }
                    }
                });
                advDataSet[i] = { label: data.data[i].content, data: advDataCount}
            }
        }
    });

});

/**
 * Created by user on 2015/5/22.
 */
//消费总金额
var flowCountData = [
    {
        label: '线下（万）',
        value: 98,//线下
        color: "#1abc9c"
    },
    {
        label: '线上（万）',
        value: 12,//线上
        color: "#e97c4c"
    }
];

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
        color: "#f6d36b"
    }
];

//pos消费金额
//时间转化函数
var timeplus = 60 * 60 * 1000 * 12;
function gd(year, month, day) {
    return new Date(year, month+1, day).getTime()+timeplus;
}

var userCostData = new Array();

//消费业态
var userCostSearch = new Array();
//年龄分布
var ageRange = [
    {
        label: '15-20年龄段',
        value: 5,
        color: "#42DCE9"
    },
    {
        label: '20年龄段',
        value: 20,
        color: "#31cd73"
    },
    {
        label: '30年龄段',
        value: 20,
        color: "#1A7EBC"
    },
    {
        label: '40年龄段',
        value: 20,
        color: "#1abc9c"
    },
    {
        label: '50年龄段',
        value: 10,
        color: "#e97542"
    },
    {
        label: '60年龄段',
        value: 10,
        color: "#f6d36b"
    },
    {
        label: '70年龄段',
        value: 5,//
        color: "#e49d41"
    }
];

//Wifi Data
var wifiData = new Array(); //[[0, 11],[1, 15],[2, 25],[3, 24],[4, 13],[5, 18],[6,55],[7,20],[8,7],[9,7]]; //[a,b] a,序列， b,分钟
var wifiTick = new Array(); //[[0, "KFC"], [1, "coco"], [2, "必胜客"], [3, "Bla"],[4, "Blas"], [5, "bls"],[6, "Bla"],[7, "Blas"], [8, "bls"],[9, 'MC']];//[a,b] a序列，b 分钟

//parking-pay

var parkingPay = new Array();/*[
    {
        label: '现金(%)',
        value: 20,//娱乐
        color: "#e97542"
    },
    {
        label: '支付宝(%)',
        value: 20,//服饰
        color: "#e49d41"
    },
    {
        label: '微信(%)',
        value: 20,//电玩
        color: "#f6d36b"
    },
    {
        label: '银联刷卡(%)',
        value: 40,//电玩
        color: "#1CAF9A"
    }


];*/
var inSearch = new Array()/* [
    {
        label: '入口A(次）',
        value: 20,//娱乐
        color: "#e97542"
    },
    {
        label: '入口B(次）',
        value: 5,//服饰
        color: "#e49d41"
    },
    {
        label: '入口C(次）',
        value: 5,//电玩
        color: "#f6d36b"
    }
];*/
var outSearch = new Array()/*[
    {
        label: '出口A(次）',
        value: 5,//娱乐
        color: "#31cd73"
    },
    {
        label: '出口B(次）',
        value: 5,//服饰
        color: "#1A7EBC"
    },
    {
        label: '出口C(次）',
        value: 20,//电玩
        color: "#1abc9c"
    }
];*/

//enter shop
function timeTrans(time){
   // time='0:00';
    var time_array=time.split(":");
    var h=parseInt(time_array[0]);
    var m=parseInt(time_array[1]);
    return h*60+m;
}

//进入离开一样的数据结构，请自行组织
var enterShop = [
    [gd(2015, 3, 1), timeTrans("9:15")], //(2015,3,1)日期 时间
    [gd(2015, 3, 2),timeTrans("10:15")],
    [gd(2015, 3, 3), timeTrans("11:15")],
    [gd(2015, 3, 4), timeTrans("11:45")],
    [gd(2015, 3, 5), timeTrans("12:15")],
    [gd(2015, 3, 6),timeTrans("13:15")],
    [gd(2015, 3, 7),timeTrans("14:15")],
    [gd(2015, 3, 8), timeTrans("15:15")],
    [gd(2015, 3, 9), timeTrans("16:15")]
];
var enterShop2 = [
    [gd(2015, 3, 1), timeTrans("11:15")], //(2015,3,1)日期 时间
    [gd(2015, 3, 2),timeTrans("12:15")],
    [gd(2015, 3, 3), timeTrans("13:15")],
    [gd(2015, 3, 4), timeTrans("14:45")],
    [gd(2015, 3, 5), timeTrans("15:15")],
    [gd(2015, 3, 6),timeTrans("16:15")],
    [gd(2015, 3, 7),timeTrans("17:15")],
    [gd(2015, 3, 8), timeTrans("18:15")],
    [gd(2015, 3, 9), timeTrans("19:15")]
];
var data1 =enterShop;

var data2 =enterShop2;
var enter_shopDataSet = new Array();/*[
    { label: "KFC", data: data1, points: { symbol: "triangle"} },
    { label: "必胜客", data: data2 }
];*/
var leave_shopDataSet = new Array();/* [
    { label: "KFC", data: data1, points: { symbol: "triangle"} },
    { label: "必胜客", data: data2 }
];*/

//广告
var adv_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额人次
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
    [gd(2015, 3, 9), 0],
    [gd(2015, 3, 9), 122],
    [gd(2015, 3, 10), 0],
    [gd(2015, 3, 11), 0],
    [gd(2015, 3, 12), 0],
    [gd(2015, 3, 13), 35],
    [gd(2015, 3, 14), 90],
    [gd(2015, 3, 15), 122],
    [gd(2015, 3, 16), 188],
    [gd(2015, 3, 17), 222],
    [gd(2015, 3, 18), 243],
    [gd(2015, 3, 19),366],
    [gd(2015, 3, 20), 662],
    [gd(2015, 3, 21), 288],
    [gd(2015, 3, 22), 109],
    [gd(2015, 3, 23), 400],
    [gd(2015, 3, 24), 155],
    [gd(2015, 3, 25), 197],
    [gd(2015, 3, 26), 0],
    [gd(2015, 3, 27), 44],
    [gd(2015, 3, 28), 0],
    [gd(2015, 3, 29), 90],
    [gd(2015, 3, 30), 188]
];
var product_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额200
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
    [gd(2015, 3, 9), 0],
    [gd(2015, 3, 9), 122],
    [gd(2015, 3, 10), 0],
    [gd(2015, 3, 11), 0],
    [gd(2015, 3, 12), 0],
    [gd(2015, 3, 13), 35],
    [gd(2015, 3, 14), 90],
    [gd(2015, 3, 15), 122],
    [gd(2015, 3, 16), 188],
    [gd(2015, 3, 17), 222],
    [gd(2015, 3, 18), 243],
    [gd(2015, 3, 19),366],
    [gd(2015, 3, 20), 662],
    [gd(2015, 3, 21), 288],
    [gd(2015, 3, 22), 109],
    [gd(2015, 3, 23), 400],
    [gd(2015, 3, 24), 155],
    [gd(2015, 3, 25), 197],
    [gd(2015, 3, 26), 0],
    [gd(2015, 3, 27), 44],
    [gd(2015, 3, 28), 0],
    [gd(2015, 3, 29), 90],
    [gd(2015, 3, 30), 188]
];
var product_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额200
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
    [gd(2015, 3, 9), 0],
    [gd(2015, 3, 9), 122],
    [gd(2015, 3, 10), 0],
    [gd(2015, 3, 11), 0],
    [gd(2015, 3, 12), 0],
    [gd(2015, 3, 13), 35],
    [gd(2015, 3, 14), 90],
    [gd(2015, 3, 15), 122],
    [gd(2015, 3, 16), 188],
    [gd(2015, 3, 17), 222],
    [gd(2015, 3, 18), 243],
    [gd(2015, 3, 19),366],
    [gd(2015, 3, 20), 662],
    [gd(2015, 3, 21), 288],
    [gd(2015, 3, 22), 109],
    [gd(2015, 3, 23), 400],
    [gd(2015, 3, 24), 155],
    [gd(2015, 3, 25), 197],
    [gd(2015, 3, 26), 0],
    [gd(2015, 3, 27), 44],
    [gd(2015, 3, 28), 0],
    [gd(2015, 3, 29), 90],
    [gd(2015, 3, 30), 188]
];
var other_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额200
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
    [gd(2015, 3, 9), 0],
    [gd(2015, 3, 9), 122],
    [gd(2015, 3, 10), 0],
    [gd(2015, 3, 11), 0],
    [gd(2015, 3, 12), 0],
    [gd(2015, 3, 13), 35],
    [gd(2015, 3, 14), 90],
    [gd(2015, 3, 15), 122],
    [gd(2015, 3, 16), 188],
    [gd(2015, 3, 17), 222],
    [gd(2015, 3, 18), 243],
    [gd(2015, 3, 19),366],
    [gd(2015, 3, 20), 662],
    [gd(2015, 3, 21), 288],
    [gd(2015, 3, 22), 109],
    [gd(2015, 3, 23), 400],
    [gd(2015, 3, 24), 155],
    [gd(2015, 3, 25), 197],
    [gd(2015, 3, 26), 0],
    [gd(2015, 3, 27), 44],
    [gd(2015, 3, 28), 0],
    [gd(2015, 3, 29), 90],
    [gd(2015, 3, 30), 188]
];

var advDataSet = new Array();/* [
    { label: "广告", data: adv_data},
    { label: "商品", data: product_data },
    { label: "其他", data:other_data }
];*/








