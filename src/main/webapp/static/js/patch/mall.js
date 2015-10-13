/**
 * Created by user on 2015/4/8.
 */


 $(document).ready(function(){
 var dataBoxPosmonitorSum = $("#dataBoxPosmonitorSum").val();
 //sales Chart A
 var salesChartA_data=[

 {
 value : 5,
 color : "#1abc9c"
 },
 {
 value: 95,
 color:"#e97c4c"
 }
 ];
 var salesChartA_options={
 //Boolean - Whether we should show a stroke on each segment
 segmentShowStroke : true,

 //String - The colour of each segment stroke
 segmentStrokeColor : "#fff",

 //Number - The width of each segment stroke
 segmentStrokeWidth : 2,

 //Boolean - Whether we should animate the chart
 animation : true,

 //Number - Amount of animation steps
 animationSteps : 36,

 //String - Animation easing effect
 // animationEasing : "easeOutBounce",
 animationEasing : "easeOut",

 //Boolean - Whether we animate the rotation of the Pie
 animateRotate : true,

 //Boolean - Whether we animate scaling the Pie from the centre
 animateScale : false,

 //Function - Will fire on animation completion.
 onAnimationComplete : null
 };

 var salesChartA_ctx=document.getElementById("salesChartA").getContext("2d");
 var salesChartA = new Chart(salesChartA_ctx).Pie(salesChartA_data,salesChartA_options);

 //sales Chart B
 var salesChartB_data=[

 {
 value : 100,
 color : "#1abc9c"
 },
 {
 value: 0,
 color:"#f6d36b"
 }
 ];
 var salesChartB_options={
 //Boolean - Whether we should show a stroke on each segment
 segmentShowStroke : true,

 //String - The colour of each segment stroke
 segmentStrokeColor : "#fff",

 //Number - The width of each segment stroke
 segmentStrokeWidth : 2,

 //Boolean - Whether we should animate the chart
 animation : true,

 //Number - Amount of animation steps
 animationSteps : 36,

 //String - Animation easing effect
 // animationEasing : "easeOutBounce",
 animationEasing : "easeOut",

 //Boolean - Whether we animate the rotation of the Pie
 animateRotate : true,

 //Boolean - Whether we animate scaling the Pie from the centre
 animateScale : false,

 //Function - Will fire on animation completion.
 onAnimationComplete : null
 };

 var salesChartB_ctx=document.getElementById("salesChartB").getContext("2d");
 var salesChartB = new Chart(salesChartB_ctx).Pie(salesChartB_data,salesChartB_options);


 });



//flot--今日数据

$(document).ready(function(){
    if ($("#customer-rate-flot").find("canvas").get(0) == undefined) {
        // do something...
        //场内用户月均来场频率
        var timeplus=60*60*1000*12;
        function gd(year, month, day) {
            return new Date(year, month-1, day).getTime()+timeplus;
        }
        var mallId = $("#mallId").val();
        var date = $("#date").val();
        var type = $("#type").val();

        //场内用户数
        var data1 = new Array();
        //客流
        var data2 = new Array();
        //车流
        var data3 =new Array();
        $.ajax({
            dataType: "json",
            url: "selectMallToMonthAllData.do",
            data: {
                mallId: mallId,
                date:date,
                type:type
            },
            async: false,
            success: function (data) {
                ////for(var i=0;i<data.wifiMaxGusts.length;i++){
                ////    data1[i] = [gd(parseInt(data.wifiMaxGusts[i].maxAddress), parseInt(data.wifiMaxGusts[i].ip),parseInt(data.wifiMaxGusts[i].floor)),data.wifiMaxGusts[i].id];
                ////}
                //data1[data1.length] = [gd(2015,7, 11), 2.2];
                ////for(var i=0;i<data.ibeanconLogs.length;i++){
                ////    data2[i] = [gd(parseInt(data.ibeanconLogs[i].mobile), parseInt(data.ibeanconLogs[i].deviceno),parseInt(data.ibeanconLogs[i].ibeaconno)),data.ibeanconLogs[i].id/100];
                ////}
                //data2[data2.length] = [gd(2015, 6, 11),4.8];
                ////for(var i=0;i<data.parkingUsers.length;i++){
                ////    if(data.parkingUsers[i].crmUser!=null) {
                ////        data3[i] = [gd(parseInt(data.parkingUsers[i].crmUser), parseInt(data.parkingUsers[i].mobile), parseInt(data.parkingUsers[i].plateNo)), data.parkingUsers[i].id/100];
                ////    }
                ////}
                //data3[data3.length] = [gd(2015, 6, 11),0.8];

            }
        });
//start


        //场内用户数
        var data1 = [
            [gd(2015, 7, 1),6.9],
            [gd(2015, 7, 2),7.5],
            [gd(2015, 7, 3), 8],
            [gd(2015, 7, 4), 5.9],
            [gd(2015, 7, 5), 3.6],
            [gd(2015, 7, 6), 4.1],
            [gd(2015, 7, 7), 7.7],
            [gd(2015, 7, 8), 4],
            [gd(2015, 7, 9), 3]
        ];
        var data1_p = [
            [gd(2015, 7, 9),3],
            [gd(2015, 7, 10), 2.6],
            [gd(2015, 7, 11), 3],
            [gd(2015, 7, 12), 3.8]
            //[gd(2015, 3, 12), 18]
        ];
        //if(data1==null||data1.length==0||data1[0]==null){
        //    data1_p = new Array();
        //}
        //客流
        var data2 = [
            [gd(2015, 7, 1),8.6],
            [gd(2015, 7, 2),7],
            [gd(2015, 7, 3), 6.6],
            [gd(2015, 7, 4), 6.6],
            [gd(2015, 7, 5), 7.6],
            [gd(2015, 7, 6), 3.5],
            [gd(2015, 7, 7), 4.7],
            [gd(2015, 7, 8), 3],
            [gd(2015, 7, 9), 4]
        ];
        var data2_p = [
            [gd(2015, 7, 9),4],
            [gd(2015, 7, 10), 3.1],
            [gd(2015, 7, 11), 5],
            [gd(2015, 7, 12), 4]
            //[gd(2015, 3, 12), 18]
        ];
        //if(data2==null||data2.length==0||data2[0]==null){
        //    data2_p = new Array();
        //}
        //车流
        var data3 = [
            [gd(2015, 7, 1),3.2],
            [gd(2015, 7, 2),1.7],
            [gd(2015, 7, 3),1.46],
            [gd(2015, 7, 4),3.2],
            [gd(2015, 7, 5), 2.6],
            [gd(2015, 7, 6), 4.9],
            [gd(2015, 7, 7), 6.3],
            [gd(2015, 7, 8), 3],
            [gd(2015, 7, 9), 5]
        ];
        var data3_p = [
            [gd(2015, 7, 9),5],
            [gd(2015, 7, 10), 0.8],
            [gd(2015, 7, 11), 2.2],
            [gd(2015, 7, 12), 2]
            //[gd(2015, 3, 12), 18]
        ];
        //if(data3==null||data3.length==0||data3[1]==0){
        //    data3_p = new Array();
        //}
        //车流

        var datasetP = [
           // { label: "每月用户到场频率", data: data1 }
            { label: "WIFI使用",data: data1 },
            {
                label: "WIFI使用预测",
                data:data1_p,
                color:"#f5c0a9",
                lines: {
                        show: true,
                        fill: true,
                    fillColor: "rgba(46, 204, 113, 0.1)"
                        }
            },
            {
                label: "场内客流",
                data:data2,
                color:"#3fd07c",
                lines: {
                    show: true,
                    fill: false

                }
            },
            {
                label: "场内客流预测",
                data:data2_p,
                color:"#8bebb4",
                lines: {
                    show: true,
                    fill: false
                }
            },
            {
                label: "车流",
                data:data3,
                color:"#3498db",
                lines: {
                    show: true,
                    fill: false

                }
            },
            {
                label: "车流预测",
                data:data3_p,
                color:"#86c7f3",
                lines: {
                    show: true,
                    fill: false
                }
            }
        ];

        var options = {
            series: {
                lines: {
                    show: true,
                    fill: true,
                    fillColor: "rgba(46, 204, 113, 0.18)"
                },
                points: {
                    radius: 3,
                    fill: true,
                    show: true
                },
                shadowSize: 0
            },

            xaxis: {
                mode: "time",
                tickSize: [1, "day"],
                //tickLength:0,
                //axisLabel: "每月用户到场频率",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    var d=new Date(v);
                    //var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                    //return monthNames[d.getMonth()]+d.getDate()+'日';
                    return d.getDate();
                }
            },

            yaxis: {
               // axisLabel: "频率(次)",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:2,
                min:0,
                max:10,
                tickFormatter: function (v, axis) {
                   // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v+"百";
                }
            },

            legend: {
                show: false
              // noColumns: 0,
              //  labelBoxBorderColor: "#000000",
              //  position: "nw"
            },

            grid: {
                hoverable: true,

                borderWidth: 2,
                borderColor: "#eee"
              //  backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            },
            colors: ["#e97542", "#0022FF"]
        };

        var previousPoint = null, previousLabel = null;
       // var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
        $.fn.UseTooltip = function () {

            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();

                        var x = item.datapoint[0];
                        var y = item.datapoint[1];

                        var color = item.series.color;
                        var month = new Date(x).getMonth();
                        var date=new Date(x).getDate();
                        //console.log(item);
                        showTooltip(item.pageX,
                                    item.pageY,
                                    color,
                                "<strong>" + item.series.label + "</strong><br>" + monthNames[month] +date+'日'+ " : <strong>" + y + "</strong>(百)");
                        /*if (item.seriesIndex == 0) {
                            showTooltip(item.pageX,
                                item.pageY,
                                color,
                                    "<strong>" + item.series.label + "</strong><br>" + monthNames[month] + " : <strong>" + y + "</strong>(万)");
                        } else {
                            showTooltip(item.pageX,
                                item.pageY,
                                color,
                                    "<strong>" + item.series.label + "</strong><br>" + monthNames[month] + " : <strong>" + y + "</strong>(%)");
                        }
                        */
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });

        };

        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y - 40,
                left: x - 120,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }

        $.plot($("#customer-rate-flot"), datasetP, options);
        $("#customer-rate-flot").UseTooltip();

// ene
    } //end if ($("customer-rate-flot")
});
//flot--销售情况

$(document).ready(function(){
    if ($("#sales-flot").find("canvas").get(0) == undefined) {
        //场内用户月均来场频率
        var timeplus=60*60*1000*12;
        function gd(year, month, day) {
            return new Date(year, month-1, day).getTime()+timeplus;
        }
        // do something...
        //alert("create!!!");
        var data1 = new Array();
        var mallId = $("#mallId").val();
        var date = $("#date").val();
        var type = $("#type").val();
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
                //for(var i=0;i<data.dataBoxPosmonitors.length;i++){
                //    data1[i] = [gd(parseInt(data.dataBoxPosmonitors[i].merchantid), parseInt(data.dataBoxPosmonitors[i].merchantname),parseInt(data.dataBoxPosmonitors[i].mallName)),data.dataBoxPosmonitors[i].totalSum];
                //}
                //data1[data1.length] = [gd(2015, 6, 11),0.42];
            }
        });
//start


        //销售金额
        var data1 = [
            [gd(2015, 7, 1),6.2],
            [gd(2015, 7, 2),7.5],
            [gd(2015, 7, 3), 5],
            [gd(2015, 7, 4), 4.3],
            [gd(2015, 7, 5), 6.6],
            [gd(2015, 7, 6), 4.6],
            [gd(2015, 7, 7), 6.7],
            [gd(2015, 7, 8), 7],
            [gd(2015, 7, 9), 3]
        ];

        var data1_p = [
            [gd(2015, 7, 9),3],
            [gd(2015, 7, 10), 3.4],
            [gd(2015, 7, 11), 3.4],
            [gd(2015, 7, 12), 2.9]

        //[gd(2015, 3, 12), 18]
    ];
        if(data1.length==0){
            data1_p==new Array();
        }
        //线上金额
        var data2 = [
            [gd(2015,7, 1), 2],
            [gd(2015,7, 2), 1],
            [gd(2015, 7, 3),2],
            [gd(2015, 7, 4), 3],
            [gd(2015,7, 5), 2],
            [gd(2015,7, 6), 1],
            [gd(2015, 7, 7),2],
            [gd(2015, 7, 8), 3],
            [gd(2015, 7, 9), 2]
        ];
        var data2_p = [
            [gd(2015, 7, 9),2],
            [gd(2015, 7, 10), 1],
            [gd(2015, 7, 11), 3],
            [gd(2015, 7, 12), 2]
            //[gd(2015, 3, 12), 18]
        ];
        if(data1.length==0){
            data2_p==new Array();
            data2==new Array();
        }
        var datasetP = [
            // { label: "每月用户到场频率", data: data1 }
            { label: "线上售额",data: data2 },
            {
                label: "线上售额预测",
                data:data2_p,
                color:"#f4b79c",
                lines: {
                    show: true,
                    fill: true,
                    fillColor: "rgba(233, 117, 66, 0.08)"
                }
            },
            {
                label: "线下销售额",
                data:data1,
                color:"#2ecc71",
                lines: {
                    show: true,
                    fill: false

                }
            },
            {
                label: "线下销售额预测",
                data:data1_p,
                color:"#acf5cb",
                lines: {
                    show: true,
                    fill: false
                }
            }

        ];

        var options = {
            series: {
                lines: {
                    show: true,
                    fill: true,
                    fillColor: "rgba(233, 117, 66, 0.16)"
                },
                points: {
                    radius: 3,
                    fill: true,
                    show: true
                },
                shadowSize: 0
            },

            xaxis: {
                mode: "time",
                tickSize: [1, "day"],
                //tickLength:0,
                //axisLabel: "每月用户到场频率",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    var d=new Date(v);
                  //  var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                  //  return monthNames[d.getMonth()]+d.getDate()+'日';
                    return d.getDate();
                }
            },

            yaxis: {
                // axisLabel: "频率(次)",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:2,
                min:0,
                max:10,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v+"千";
                }
            },

            legend: {
                show: false
                // noColumns: 0,
                //  labelBoxBorderColor: "#000000",
                //  position: "nw"
            },

            grid: {
                hoverable: true,

                borderWidth: 2,
                borderColor: "#eee"
                //  backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            },
            colors: ["#e97542", "#64d691"]
        };

        var previousPoint = null, previousLabel = null;
        // var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
        $.fn.UseTooltip = function () {

            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();

                        var x = item.datapoint[0];
                        var y = item.datapoint[1];

                        var color = item.series.color;
                        var month = new Date(x).getMonth();
                        var date=new Date(x).getDate();
                        //console.log(item);
                        showTooltip(item.pageX,
                            item.pageY,
                            color,
                                "<strong>" + item.series.label + "</strong><br>" + monthNames[month] +date+'日'+ " : <strong>" + y + "</strong>(千)");
                        /*if (item.seriesIndex == 0) {
                         showTooltip(item.pageX,
                         item.pageY,
                         color,
                         "<strong>" + item.series.label + "</strong><br>" + monthNames[month] + " : <strong>" + y + "</strong>(万)");
                         } else {
                         showTooltip(item.pageX,
                         item.pageY,
                         color,
                         "<strong>" + item.series.label + "</strong><br>" + monthNames[month] + " : <strong>" + y + "</strong>(%)");
                         }
                         */
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });

        };

        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y - 40,
                left: x - 120,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }

        $.plot($("#sales-flot"), datasetP, options);
        $("#sales-flot").UseTooltip();

// ene
    } //end if ($("customer-rate-flot")
});




//app使用热度
$(document).ready(function(e){
    //useRage_search

    var useRage_search=[
        {
            label:'娱乐',
            value : 1200,//娱乐
            color : "#e97542"
        },
        {
            label:'服饰',
            value : 1300,//服饰
            color : "#e49d41"
        },
        {
            label:'电玩',
            value : 890,//电玩
            color : "#f6d36b"
        },
        {
            label:'餐饮',
            value: 4500,//餐饮
            color:"#1abc9c"
        }
    ];
    var useRage_search_options={
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke : true,

        //String - The colour of each segment stroke
        segmentStrokeColor : "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth : 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout : 65,

        //Boolean - Whether we should animate the chart
        animation : true,

        //Number - Amount of animation steps
        animationSteps : 36,

        //String - Animation easing effect
        animationEasing : "easeIn",

        //Boolean - Whether we animate the rotation of the Doughnut
        animateRotate : true,

        //Boolean - Whether we animate scaling the Doughnut from the centre
        animateScale : false,

        //Function - Will fire on animation completion.
        onAnimationComplete : null
    };

    var useRage_search_ctx=document.getElementById("use-rage-search").getContext("2d");
    var useRage_searchA = new Chart(useRage_search_ctx).Doughnut(useRage_search,useRage_search_options);

    //useRage_ask

    var useRage_ask=[
        {
            label:'娱乐',
            value : 1200,//娱乐
            color : "#e97542"
        },
        {
            label:'服饰',
            value : 1300,//服饰
            color : "#e49d41"
        },
        {
            label:'电玩',
            value : 890,//电玩
            color : "#f6d36b"
        },
        {
            label:'餐饮',
            value: 4500,//餐饮
            color:"#1abc9c"
        }
    ];
    var useRage_ask_options={
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke : true,

        //String - The colour of each segment stroke
        segmentStrokeColor : "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth : 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout : 65,

        //Boolean - Whether we should animate the chart
        animation : true,

        //Number - Amount of animation steps
        animationSteps : 36,

        //String - Animation easing effect
        animationEasing : "easeIn",

        //Boolean - Whether we animate the rotation of the Doughnut
        animateRotate : true,

        //Boolean - Whether we animate scaling the Doughnut from the centre
        animateScale : false,

        //Function - Will fire on animation completion.
        onAnimationComplete : null
    };

    var useRage_ask_ctx=document.getElementById("use-rage-ask").getContext("2d");
    var useRage_askA = new Chart( useRage_ask_ctx).Doughnut(useRage_ask,useRage_ask_options);

    //useRage_new

    var useRage_new=[
        {
            label:'娱乐',
            value : 1200,//娱乐
            color : "#e97542"
        },
        {
            label:'服饰',
            value : 1300,//服饰
            color : "#e49d41"
        },
        {
            label:'电玩',
            value : 890,//电玩
            color : "#f6d36b"
        },
        {
            label:'餐饮',
            value: 4500,//餐饮
            color:"#1abc9c"
        }
    ];
    var useRage_new_options={
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke : true,

        //String - The colour of each segment stroke
        segmentStrokeColor : "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth : 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout : 65,

        //Boolean - Whether we should animate the chart
        animation : true,

        //Number - Amount of animation steps
        animationSteps : 36,

        //String - Animation easing effect
        animationEasing : "easeIn",

        //Boolean - Whether we animate the rotation of the Doughnut
        animateRotate : true,

        //Boolean - Whether we animate scaling the Doughnut from the centre
        animateScale : false,

        //Function - Will fire on animation completion.
        onAnimationComplete : null
    };

    var useRage_new_ctx=document.getElementById("use-rage-new").getContext("2d");
    var useRage_newA = new Chart( useRage_new_ctx).Doughnut(useRage_new,useRage_new_options);
});

$(document).ready(function(){

    var age_range =ageRange;
    var age_range_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 2,

        //The percentage of the chart that we cut out of the middle.
       // percentageInnerCutout: 0,

        //Boolean - Whether we should animate the chart
        animation: true,

        //Number - Amount of animation steps
        animationSteps: 36,

        //String - Animation easing effect
        animationEasing: "easeIn",

        //Boolean - Whether we animate the rotation of the Doughnut
        animateRotate: true,

        //Boolean - Whether we animate scaling the Doughnut from the centre
        animateScale: false,

        //Function - Will fire on animation completion.
        onAnimationComplete: null
    };

    var age_range_ctx = document.getElementById("age-range").getContext("2d");
    var age_range_donut = new Chart(age_range_ctx).Pie(age_range, age_range_options);

    //年龄堆栈

    $(document).ready(function () {

        var dataset =ageDataSet;


        var options = {
            series: {
                stack:true,

                    lines: {
                      show: true,
                        fill:true
                    },
                    points: {
                       radius: 3,
                       fill: true,
                       show: true
                    }

            },



            xaxis: {
                mode: "time",
                tickSize: [1, "day"],
                tickLength: 0,
                //  axisLabel: "",
                //   axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                tickFormatter: function (v, axis) {
                    var d = new Date(v);
                    return d.getDate();
                }
            },
            yaxis: {
                // axisLabel: "Gold Price(USD)",
                // axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickFormatter: function (v, axis) {
                //    return v +'(人次）'
                    return v;
                }
            },
            /*
             {
             position: "right",
             axisLabel: "Change(%)",
             axisLabelUseCanvas: true,
             axisLabelFontSizePixels: 12,
             axisLabelFontFamily: 'Verdana, Arial',
             axisLabelPadding: 3
             }
             ]*/
            legend: {
                show:false,
                noColumns: 0,
                //    labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
                borderWidth: 2,
                borderColor: "#eee"
               // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            },
            colors: ['#1abc9c',"#e97542", "#e49d41",'#f6d36b']
        };

        function gd(year, month, day) {
            return new Date(year, month, day).getTime();
        }

        var previousPoint = null, previousLabel = null;
        //  var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

        $.fn.UseTooltip = function () {
            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();

                        var x = item.datapoint[0];
                        var y = item.datapoint[1];

                        var tString= item.series.label+':'+y;

                        var color = item.series.color;
                        //console.log(item);

                        if (item.seriesIndex == 0) {
                            showTooltip(item.pageX,item.pageY,color, "<strong>" +  tString + "</strong>");
                        } else {
                            showTooltip(item.pageX,item.pageY,color,"<strong>" +  tString + "</strong>");
                        }
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        };

        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y - 40,
                left: x-15 ,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }


        $.plot($("#age-stack-flot"), dataset, options);
        $("#age-stack-flot").UseTooltip();

    });

    //性别饼图
    var sex_count_data =sexCountData;
    var sex_count_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 2,

        //Boolean - Whether we should animate the chart
        animation: true,

        //Number - Amount of animation steps
        animationSteps: 36,

        //String - Animation easing effect
        // animationEasing : "easeOutBounce",
        animationEasing: "easeOut",

        //Boolean - Whether we animate the rotation of the Pie
        animateRotate: true,

        //Boolean - Whether we animate scaling the Pie from the centre
        animateScale: false,

        //Function - Will fire on animation completion.
        onAnimationComplete: null
    };

    var sex_count_ctx = document.getElementById("sex-range").getContext("2d");
    var sex_count = new Chart(sex_count_ctx).Pie(sex_count_data, sex_count_options);

    //性别堆栈

        var dataset =sexDataSet;

        var options = {
            series: {
                stack:true,
                lines: {
                    show: true,
                    fill:true
                },
                points: {
                    radius: 3,
                    fill: true,
                    show: true
                }

            },

            xaxis: {
                mode: "time",
                tickSize: [1, "day"],
                tickLength: 0,
                //  axisLabel: "",
                //   axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                tickFormatter: function (v, axis) {
                    var d = new Date(v);
                    return d.getDate();
                }
            },
            yaxis: {
                // axisLabel: "Gold Price(USD)",
                // axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickFormatter: function (v, axis) {
                    //    return v +'(人次）'
                    return v;
                }
            },
            /*
             {
             position: "right",
             axisLabel: "Change(%)",
             axisLabelUseCanvas: true,
             axisLabelFontSizePixels: 12,
             axisLabelFontFamily: 'Verdana, Arial',
             axisLabelPadding: 3
             }
             ]*/
            legend: {
                show:false,
                noColumns: 0,
                //    labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
                borderWidth: 2,
                borderColor: "#eee"
                // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            },
            colors: ['#1abc9c',"#e97542", "#e49d41",'#f6d36b']
        };

        function gd(year, month, day) {
            return new Date(year, month, day).getTime();
        }

        var previousPoint = null, previousLabel = null;
        //  var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

        $.fn.UseTooltip = function () {
            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();

                        var x = item.datapoint[0];
                        var y = item.datapoint[1];

                        var tString= item.series.label+':'+y;

                        var color = item.series.color;
                        //console.log(item);

                        if (item.seriesIndex == 0) {
                            showTooltip(item.pageX,item.pageY,color, "<strong>" +  tString + "</strong>");
                        } else {
                            showTooltip(item.pageX,item.pageY,color,"<strong>" +  tString + "</strong>");
                        }
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        };

        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y - 40,
                left: x-15 ,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }


        $.plot($("#sex-stack-flot"), dataset, options);
        $("#sex-stack-flot").UseTooltip();

    //新老分布

    var new_old_count_data =newOldData;
    var new_old_count_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 2,

        //Boolean - Whether we should animate the chart
        animation: true,

        //Number - Amount of animation steps
        animationSteps: 36,

        //String - Animation easing effect
        // animationEasing : "easeOutBounce",
        animationEasing: "easeOut",

        //Boolean - Whether we animate the rotation of the Pie
        animateRotate: true,

        //Boolean - Whether we animate scaling the Pie from the centre
        animateScale: false,

        //Function - Will fire on animation completion.
        onAnimationComplete: null
    };

    var new_old_count_ctx = document.getElementById("new-old-range").getContext("2d");
    var new_old_count = new Chart(new_old_count_ctx).Pie(new_old_count_data, new_old_count_options);

    //新老堆栈


        var dataset =newoldDataSet;

        var options = {
            series: {
                stack:true,
                lines: {
                    show: true,
                    fill:true
                },
                points: {
                    radius: 3,
                    fill: true,
                    show: true
                }

            },

            xaxis: {
                mode: "time",
                tickSize: [1, "day"],
                tickLength: 0,
                //  axisLabel: "",
                //   axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                tickFormatter: function (v, axis) {
                    var d = new Date(v);
                    return d.getDate();
                }
            },
            yaxis: {
                // axisLabel: "Gold Price(USD)",
                // axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickFormatter: function (v, axis) {
                    //    return v +'(人次）'
                    return v;
                }
            },
            /*
             {
             position: "right",
             axisLabel: "Change(%)",
             axisLabelUseCanvas: true,
             axisLabelFontSizePixels: 12,
             axisLabelFontFamily: 'Verdana, Arial',
             axisLabelPadding: 3
             }
             ]*/
            legend: {
                show:false,
                noColumns: 0,
                //    labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
                borderWidth: 2,
                borderColor: "#eee"
                // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            },
            colors: ['#1abc9c',"#e97542", "#e49d41",'#f6d36b']
        };

        function gd(year, month, day) {
            return new Date(year, month, day).getTime();
        }

        var previousPoint = null, previousLabel = null;
        //  var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

        $.fn.UseTooltip = function () {
            $(this).bind("plothover", function (event, pos, item) {
                if (item) {
                    if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                        previousPoint = item.dataIndex;
                        previousLabel = item.series.label;
                        $("#tooltip").remove();

                        var x = item.datapoint[0];
                        var y = item.datapoint[1];

                        var tString= item.series.label+':'+y;

                        var color = item.series.color;
                        //console.log(item);

                        if (item.seriesIndex == 0) {
                            showTooltip(item.pageX,item.pageY,color, "<strong>" +  tString + "</strong>");
                        } else {
                            showTooltip(item.pageX,item.pageY,color,"<strong>" +  tString + "</strong>");
                        }
                    }
                } else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        };

        function showTooltip(x, y, color, contents) {
            $('<div id="tooltip">' + contents + '</div>').css({
                position: 'absolute',
                display: 'none',
                top: y - 40,
                left: x-15 ,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }


        $.plot($("#new-old-stack-flot"), dataset, options);
        $("#new-old-stack-flot").UseTooltip();


    //支付方式

    var pay_count_data =payRange;
    var pay_count_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 2,

        //Boolean - Whether we should animate the chart
        animation: true,

        //Number - Amount of animation steps
        animationSteps: 36,

        //String - Animation easing effect
        // animationEasing : "easeOutBounce",
        animationEasing: "easeOut",

        //Boolean - Whether we animate the rotation of the Pie
        animateRotate: true,

        //Boolean - Whether we animate scaling the Pie from the centre
        animateScale: false,

        //Function - Will fire on animation completion.
        onAnimationComplete: null
    };

    var pay_count_ctx = document.getElementById("pay-range").getContext("2d");
    var pay_count = new Chart(pay_count_ctx).Pie(pay_count_data, pay_count_options);

    //支付方式堆栈
    var dataset =payDataSet;

    var options = {
        series: {
            stack:true,
            lines: {
                show: true,
                fill:true
            },
            points: {
                radius: 3,
                fill: true,
                show: true
            }

        },

        xaxis: {
            mode: "time",
            tickSize: [1, "day"],
            tickLength: 0,
            //  axisLabel: "",
            //   axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Verdana, Arial',
            axisLabelPadding: 10,
            tickFormatter: function (v, axis) {
                var d = new Date(v);
                return d.getDate();
            }
        },
        yaxis: {
            // axisLabel: "Gold Price(USD)",
            // axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Verdana, Arial',
            axisLabelPadding: 3,
            tickFormatter: function (v, axis) {
                //    return v +'(人次）'
                return v;
            }
        },
        /*
         {
         position: "right",
         axisLabel: "Change(%)",
         axisLabelUseCanvas: true,
         axisLabelFontSizePixels: 12,
         axisLabelFontFamily: 'Verdana, Arial',
         axisLabelPadding: 3
         }
         ]*/
        legend: {
            show:false,
            noColumns: 0,
            //    labelBoxBorderColor: "#000000",
            position: "nw"
        },
        grid: {
            hoverable: true,
            borderWidth: 2,
            borderColor: "#eee"
            // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
        },
        colors: ['#1abc9c',"#e97542", "#e49d41",'#f6d36b']
    };

    function gd(year, month, day) {
        return new Date(year, month, day).getTime();
    }

    var previousPoint = null, previousLabel = null;
    //  var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    $.fn.UseTooltip = function () {
        $(this).bind("plothover", function (event, pos, item) {
            if (item) {
                if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                    previousPoint = item.dataIndex;
                    previousLabel = item.series.label;
                    $("#tooltip").remove();

                    var x = item.datapoint[0];
                    var y = item.datapoint[1];

                    var tString= item.series.label+':'+y;

                    var color = item.series.color;
                    //console.log(item);

                    if (item.seriesIndex == 0) {
                        showTooltip(item.pageX,item.pageY,color, "<strong>" +  tString + "</strong>");
                    } else {
                        showTooltip(item.pageX,item.pageY,color,"<strong>" +  tString + "</strong>");
                    }
                }
            } else {
                $("#tooltip").remove();
                previousPoint = null;
            }
        });
    };

    function showTooltip(x, y, color, contents) {
        $('<div id="tooltip">' + contents + '</div>').css({
            position: 'absolute',
            display: 'none',
            top: y - 40,
            left: x-15 ,
            border: '2px solid ' + color,
            padding: '3px',
            'font-size': '9px',
            'border-radius': '5px',
            'background-color': '#fff',
            'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
            opacity: 0.9
        }).appendTo("body").fadeIn(200);
    }


    $.plot($("#pay-stack-flot"), dataset, options);
    $("#pay-stack-flot").UseTooltip();
});

