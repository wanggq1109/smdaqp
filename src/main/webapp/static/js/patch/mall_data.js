/**
 * Created by user on 2015/5/22.
 */

//时间转化函数
var timeplus = 60 * 60 * 1000 * 12;
function gd(year, month, day) {
    return new Date(year, month, day).getTime() + timeplus;
}

//新老消费比例
var newOldData = [
    {
        label: '新客户',
        value: 60,//
        color: "#1abc9c"
    },
    {
        label: '老客户',
        value: 40,//
        color: "#f6d36b"
    }
];
//新老分布
var new_data = [
    [gd(2015, 7, 1), 200], //(2015,3,1)日期 消费金额人次
    [gd(2015, 7, 2), 300],
    [gd(2015, 7, 3), 232],
    [gd(2015, 7, 4), 142],
    [gd(2015, 7, 5), 200], //(2015,3,1)日期 消费金额人次
    [gd(2015, 7, 6), 300],
    [gd(2015, 7, 7), 232],
    [gd(2015, 7, 8), 142],
    [gd(2015, 7, 9), 142]
];
var old_data = [
    [gd(2015, 7, 1), 100], //(2015,3,1)日期 消费金额200
    [gd(2015, 7, 2), 100],
    [gd(2015, 7, 3), 132],
    [gd(2015, 7, 4), 142],
    [gd(2015, 7, 5), 100], //(2015,3,1)日期 消费金额200
    [gd(2015, 7, 6), 100],
    [gd(2015, 7, 7), 132],
    [gd(2015, 7, 8), 142],
    [gd(2015, 7, 9), 142]
];



//性别消费比例
var sexCountData =[
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

//性别分布
var men_data = [
    [gd(2015, 7, 1), 3],
    [gd(2015, 7, 2), 2],
    [gd(2015, 7, 3), 1],
    [gd(2015, 7, 4), 3],
    [gd(2015, 7, 5), 2],
    [gd(2015, 7, 6), 2],
    [gd(2015, 7, 7), 3],
    [gd(2015, 7, 8), 2],
    [gd(2015, 7, 9), 2]
];
var women_data = [

    [gd(2015, 7, 1), 3],
    [gd(2015, 7, 2), 2],
    [gd(2015, 7, 3), 2],
    [gd(2015, 7, 4), 1],
    [gd(2015, 7, 5), 4],
    [gd(2015, 7, 6), 4],
    [gd(2015, 7, 7), 1],
    [gd(2015, 7, 8), 4],
    [gd(2015, 7, 9), 4]
];

var sexDataSet = [
    { label: "男", data: men_data,color:"#1abc9c"},
    { label: "女", data: women_data,color:"#e97542"}
];


//新老客户分布
var new_data = [
    [gd(2015, 7, 1), 8],
    [gd(2015, 7, 2), 7],
    [gd(2015, 7, 3), 6],
    [gd(2015, 7, 4), 7],
    [gd(2015, 7, 5), 8],
    [gd(2015, 7, 6), 6],
    [gd(2015, 7, 7), 7],
    [gd(2015, 7, 8), 8],
    [gd(2015, 7, 9), 6]
];
var old_data = [
    [gd(2015, 7, 1), 5],
    [gd(2015, 7, 2), 5],
    [gd(2015, 7, 3), 3],
    [gd(2015, 7, 4), 2],
    [gd(2015, 7, 5), 1],
    [gd(2015, 7, 6), 4],
    [gd(2015, 7, 7), 2],
    [gd(2015, 7, 8), 1],
    [gd(2015, 7, 9), 4]

];

var newoldDataSet = [
    { label: "老客户", data:old_data,color:"#f6d36b"},
    { label: "新客户", data: new_data,color:"#1abc9c"}
];
var dataBoxPosmonitorSum = $("#dataBoxPosmonitorSum").val();

//消费业态
var payRange = [
    {
        label: '现金',
        value: 5000,//娱乐
        color: "#e97542"
    }/*,
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
    }*/
];

// 消费分布
var cash_data = [
    [gd(2015, 7, 1), 200], //(2015,3,1)日期 消费金额人次
    [gd(2015, 7, 2), 300],
    [gd(2015, 7, 3), 232],
    [gd(2015, 7, 4), 142],
    [gd(2015, 7, 5), 200], //(2015,3,1)日期 消费金额人次
    [gd(2015, 7, 6), 300],
    [gd(2015, 7, 7), 232],
    [gd(2015, 7, 8), 142],
    [gd(2015, 7, 9), 142]
];
var card_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额200
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
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

var alipay_data = [
    [gd(2015, 3, 1), 200], //(2015,3,1)日期 消费金额200
    [gd(2015, 3, 2), 300],
    [gd(2015, 3, 3), 232],
    [gd(2015, 3, 4), 142],
    [gd(2015, 3, 5), 665],
    [gd(2015, 3, 6), 355],
    [gd(2015, 3, 7), 355],
    [gd(2015, 3, 8), 533],
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
var payDataSet = [
    { label: "现金", data: cash_data,color:"#e97542"}
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
        value: 60,
        color: "#1A7EBC"
    },
    {
        label: '40年龄段',
        value: 20,
        color: "#1abc9c"
    }
];


var age_20_data = [
    [gd(2015, 7, 1), 1],
    [gd(2015, 7, 2), 3],
    [gd(2015, 7, 3), 3],
    [gd(2015, 7, 4), 2],
    [gd(2015, 7, 5), 1],
    [gd(2015, 7, 6), 3],
    [gd(2015, 7, 7), 2],
    [gd(2015, 7, 8), 2],
    [gd(2015, 7, 9), 2]
];

var age_30_data = [
    [gd(2015, 7, 1), 1],
    [gd(2015, 7, 2), 2],
    [gd(2015, 7, 3), 2],
    [gd(2015, 7, 4), 2],
    [gd(2015, 7, 5), 3],
    [gd(2015, 7, 6), 3],
    [gd(2015, 7, 7), 1],
    [gd(2015, 7, 8), 1],
    [gd(2015, 7, 9), 1]

];

var age_40_data = [
    [gd(2015, 7, 1), 1],
    [gd(2015, 7, 2), 2],
    [gd(2015, 7, 3), 1],
    [gd(2015, 7, 4), 2],
    [gd(2015, 7, 5), 3],
    [gd(2015, 7, 6), 3],
    [gd(2015, 7, 7), 4],
    [gd(2015, 7, 8), 2],
    [gd(2015, 7, 9), 4]

];

var ageDataSet = [
  { label: "20岁段", data: age_20_data,color:"#31cd73"},
    { label: "30岁段", data:age_30_data,color:"#1A7EBC"},
    { label: "40岁段", data:age_40_data,color:"#1abc9c"}
];



$(document).ready(function(){
    var mallId = $("#mallId").val();
    var date = $("#date").val();
    var type = $("#type").val();

    ////场内用户数
    //var data1 = new Array();
    ////客流
    //var data2 = new Array();
    ////车流
    //var data3 =new Array();
    //$.ajax({
    //    dataType: "json",
    //    url: "selectMallToMonthAllData.do",
    //    data: {
    //        mallId: mallId,
    //        date:date,
    //        type:type
    //    },
    //    async: false,
    //    success: function (data) {
    //        for(var i=0;i<data.wifiMaxGusts.length;i++){
    //            data1[i] = [gd(parseInt(data.wifiMaxGusts[i].maxAddress), parseInt(data.wifiMaxGusts[i].ip),parseInt(data.wifiMaxGusts[i].floor)),data.wifiMaxGusts[i].id];
    //        }
    //        for(var i=0;i<data.trafficMalls.length;i++){
    //            data2[i] = [gd(parseInt(data.trafficMalls[i].target), parseInt(data.trafficMalls[i].mallName),parseInt(data.trafficMalls[i].mallId)),data.trafficMalls[i].id];
    //        }
    //        for(var i=0;i<data.parkingUsers.length;i++){
    //            data3[i] = [gd(parseInt(data.parkingUsers[i].crmUser), parseInt(data.parkingUsers[i].mobile),parseInt(data.parkingUsers[i].plateNo)),data.parkingUsers[i].id];
    //        }
    //    }
    //});


    //性别比例
    $.ajax({
        dataType: "json",
        url: "selectMerchantPaySexCount.do",
        data: {
            mallId: mallId,
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
                //if(data.data[i].merchantname=="0"){
                //    sexCountData[1] = {
                //        label: '女性%',
                //        value: ((data.data[i].id/count)*100).toFixed(2),//女性
                //        color: "#f6d36b"
                //    };
                //}else if(data.data[i].merchantname=="1"){
                //    sexCountData[0] = {
                //        label: '男性%',
                //        value: ((data.data[i].id/count)*100).toFixed(2),//男性
                //        color: "#1abc9c"
                //    };
                //}
            }
        }
    });


    //年龄比例
    $.ajax({
        dataType: "json",
        url: "selectDataBoxToMonthAgeTypeByMerchantId.do",
        data: {
            mallId: mallId,
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
                //if(data.data[i].itmeType=="15-20") {
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#42DCE9"
                //    };
                //}else if(data.data[i].itmeType=="20"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#31cd73"
                //    };
                //}else if(data.data[i].itmeType=="30"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#1A7EBC"
                //    };
                //}
                //else if(data.data[i].itmeType=="40"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#1abc9c"
                //    };
                //}
                //else if(data.data[i].itmeType=="50"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#e97542"
                //    };
                //}
                //else if(data.data[i].itmeType=="60"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#f6d36b"
                //    };
                //}
                //else if(data.data[i].itmeType=="70"){
                //    ageRange[i] = {
                //        label: data.data[i].itmeType + '年龄段',
                //        value: ((data.data[i].id/count)*100).toFixed(2),
                //        color: "#e49d41"
                //    };
                //}

            }
        }
    });

    //新老用户
    $.ajax({
        dataType: "json",
        url: "selectByUserNewAndOld.do",
        data: {
            mallId: mallId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            newOldData[0] = {
                label: '新客户',
                value: 75,
                color: "#1abc9c"
            };
            if((data.newCount==null||data.newCount==0)) {
                newOldData[1] = {
                    label: '老客户',
                    value: 35,//线上
                    color: "#f6d36b"
                };
            }else{
                newOldData[1] = {
                    label: '老客户',
                    value: 35,//线上
                    color: "#f6d36b"
                };
            }
        }
    });



    //性别每天人数
    $.ajax({
        dataType: "json",
        url: "selectMerchantPaySexCountBySex.do",
        data: {
            mallId: mallId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            //var men_datas = new Array();
            //var vomen_datas = new Array();
            //for(var i=3;i<data.dataBoxPosmonitor1.length;i++){//男
            //    men_datas[i] = [gd(parseInt(data.dataBoxPosmonitor1[i].merchantid), parseInt(data.dataBoxPosmonitor1[i].merchantname),parseInt(data.dataBoxPosmonitor1[i].mallName)),data.dataBoxPosmonitor1[i].id];
            //}
            //men_datas[0]=[gd(2015, 6, 7), 1];
            //men_datas[1]=[gd(2015, 6, 8), 2];
            //men_datas[2]=[gd(2015, 6, 9), 2];
            //sexDataSet[0] = {label: "男", data: men_datas,color:"#1abc9c"};
            //
            //for(var i=0;i<data.dataBoxPosmonitor0.length;i++){//女
            //    vomen_datas[i] = [gd(parseInt(data.dataBoxPosmonitor0[i].merchantid), parseInt(data.dataBoxPosmonitor0[i].merchantname),parseInt(data.dataBoxPosmonitor0[i].mallName)),data.dataBoxPosmonitor0[i].id];
            //}
            //
            //sexDataSet[1] = { label: "女", data: vomen_datas,color:"#e97542"};
        }
    });


    ////新老用户
    //$.ajax({
    //    dataType: "json",
    //    url: "selectOldAndNewUserList.do",
    //    data: {
    //        mallId: mallId,
    //        date:date,
    //        type:type
    //    },
    //    async: false,
    //    success: function (data) {
    //        var old_datas = new Array();
    //        var new_datas = new Array();
    //        for(var i=0;i<data.databoxUser0.length;i++){//新
    //            if(data.databoxUser0[i].sex!=null) {
    //                new_datas[i] = [gd(parseInt(data.databoxUser0[i].sex), parseInt(data.databoxUser0[i].ide), parseInt(data.databoxUser0[i].email)), data.databoxUser0[i].id];
    //            }
    //        }
    //
    //        newoldDataSet[0] = { label: "新客户", data: new_datas,color:"#1abc9c"};
    //        for (var i = 0; i < data.databoxUser1.length; i++) {//老
    //            if (data.databoxUser1[i].sex != null) {
    //                old_datas[i] = [gd(parseInt(data.databoxUser1[i].sex), parseInt(data.databoxUser1[i].ide), parseInt(data.databoxUser1[i].email)), data.databoxUser1[i].id];
    //            }
    //        }
    //        newoldDataSet[1] = {label: "老客户", data: old_datas, color: "#f6d36b"};
    //
    //    }
    //});


    //年龄段用户列表
    $.ajax({
        dataType: "json",
        url: "selectDataBoxToMonthAgeList.do",
        data: {
            mallId: mallId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            //var age_30_datas = new Array();
            //var age_40_datas = new Array();
            //var age_20_datas = new Array();
            //var age_10_datas = new Array();
            //for(var i=0;i<data.databoxItemtype1.length;i++){//40
            //    if(data.databoxItemtype1[i].merchantid!=null) {
            //        age_40_datas[i] = [gd(parseInt(data.databoxItemtype1[i].merchantid), parseInt(data.databoxItemtype1[i].itmeType), parseInt(data.databoxItemtype1[i].itmeTypeName)), data.databoxItemtype1[i].id];
            //    }
            //}
            //ageDataSet[0] = { label: "40岁段", data:age_40_datas,color:"#1abc9c"};
            //for(var i=0;i<data.databoxItemtype0.length;i++){//30
            //    if(data.databoxItemtype0[i].merchantid!=null) {
            //        age_30_datas[i] = [gd(parseInt(data.databoxItemtype0[i].merchantid), parseInt(data.databoxItemtype0[i].itmeType), parseInt(data.databoxItemtype0[i].itmeTypeName)), data.databoxItemtype0[i].id];
            //    }
            //}
            //ageDataSet[1] = { label: "30岁段", data:age_30_datas,color:"#1A7EBC"};
            //for(var i=0;i<data.databoxItemtype2.length;i++){//30
            //    if(data.databoxItemtype2[i].merchantid!=null) {
            //        age_20_datas[i] = [gd(parseInt(data.databoxItemtype2[i].merchantid), parseInt(data.databoxItemtype2[i].itmeType), parseInt(data.databoxItemtype2[i].itmeTypeName)), data.databoxItemtype2[i].id];
            //    }
            //}
            //ageDataSet[1] = { label: "20岁段", data:age_20_datas,color:"#1A7EBC"};
            //for(var i=0;i<data.databoxItemtype3.length;i++){//30
            //    if(data.databoxItemtype3[i].merchantid!=null) {
            //        age_10_datas[i] = [gd(parseInt(data.databoxItemtype3[i].merchantid), parseInt(data.databoxItemtype3[i].itmeType), parseInt(data.databoxItemtype3[i].itmeTypeName)), data.databoxItemtype3[i].id];
            //    }
            //}
            //ageDataSet[1] = { label: "15-20岁段", data:age_10_datas,color:"#1A7EBC"};


        }
    });

    //支付方式
    var cash_datas = new Array();
    $.ajax({
        dataType: "json",
        url: "selectMallToMonthPayData.do",
        data: {
            mallId: mallId,
            date:date,
            type:type
        },
        async: false,
        success: function (data) {
            for(var i=0;i<data.dataBoxPosmonitors.length;i++){
                cash_datas[i] = [gd(parseInt(data.dataBoxPosmonitors[i].merchantid), parseInt(data.dataBoxPosmonitors[i].merchantname),parseInt(data.dataBoxPosmonitors[i].mallName)),data.dataBoxPosmonitors[i].totalSum*1000];
            }
          //  payDataSet[0] = { label: "现金", data: cash_datas,color:"#e97542"};
        }
    });

});
