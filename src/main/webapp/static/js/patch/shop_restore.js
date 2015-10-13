/**
 * Created by user on 2015/4/8.
 */


 $(document).ready(function(){

 //sales Chart A
 var flow_count_data=[
 {
 value : 98,
 color : "#1abc9c"
 },
 {
 value: 12,
 color:"#e97c4c"
 }
 ];


 var flow_count_options={
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

 var flow_count_ctx=document.getElementById("flow-count").getContext("2d");
 var flow_count = new Chart(flow_count_ctx).Pie(flow_count_data,flow_count_options);

 //sales Chart B
 var sex_count_data=[

 {
 value : 79,
 color : "#1abc9c"
 },
 {
 value: 21,
 color:"#f6d36b"
 }
 ];
 var sex_count_options={
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

 var sex_count_ctx=document.getElementById("sex-count").getContext("2d");
 var sex_count = new Chart(sex_count_ctx).Pie(sex_count_data,sex_count_options);

 jQuery('#sparkline').sparkline([4,2,2,6,4,3,4,3,2,7,9,6,1], {
 type: 'bar',
 barWidth:'17px',
 height:'140px',
 barSpacing:'3px',
 barColor: '#e49d41'
 });
 });




//flot--今日数据

$(document).ready(function(){
    if ($("#customer-rate-flot").find("canvas").get(0) == undefined) {
        // do something...
        //alert("create!!!");
//start
        //场内用户月均来场频率
        var timeplus=60*60*1000*12;
        function gd(year, month, day) {
            return new Date(year, month, day).getTime()+timeplus;
        }

        //场内用户数
        var data1 = [
            [gd(2015, 3, 1),10.2],
            [gd(2015, 3, 2),7.5],
            [gd(2015, 3, 3), 8],
            [gd(2015, 3, 4), 11.3],
            [gd(2015, 3, 5), 9],
            [gd(2015,3, 6), 8],
            [gd(2015,3, 7), 7.3],
            [gd(2015, 3, 8),7.2]
            //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        var data1_p = [
            [gd(2015, 3, 8),7.2],
            [gd(2015, 3, 9), 7.6],
            [gd(2015, 3, 10), 11],
            [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 18]
        ];

        //客流
        var data2 = [
            [gd(2015, 3, 1),8.6],
            [gd(2015, 3, 2),7],
            [gd(2015, 3, 3), 6.6],
            [gd(2015, 3, 4), 9.6],
            [gd(2015, 3, 5), 9.8],
            [gd(2015,3, 6), 7],
            [gd(2015,3, 7), 8.2],
            [gd(2015, 3, 8),7.8]
            //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        var data2_p = [
            [gd(2015, 3, 8),7.8],
            [gd(2015, 3, 9), 6.1],
            [gd(2015, 3, 10), 10],
            [gd(2015, 3, 11), 9]
            //[gd(2015, 3, 12), 18]
        ];
        //车流
        var data3 = [
            [gd(2015, 3, 1),3.2],
            [gd(2015, 3, 2),1.7],
            [gd(2015, 3, 3),1.46],
            [gd(2015, 3, 4),3.2],
            [gd(2015, 3, 5), 2.3],
            [gd(2015,3, 6), 1.7],
            [gd(2015,3, 7), 0.9],
            [gd(2015, 3, 8),1.6]
            //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        var data3_p = [
            [gd(2015, 3, 8),1.6],
            [gd(2015, 3, 9), 0.8],
            [gd(2015, 3, 10), 2.2],
            [gd(2015, 3, 11), 2]
            //[gd(2015, 3, 12), 18]
        ];

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
                    var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                    return monthNames[d.getMonth()]+d.getDate()+'日';
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
                max:12,
                tickFormatter: function (v, axis) {
                   // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v+"万";
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
                                "<strong>" + item.series.label + "</strong><br>" + monthNames[month] +date+'日'+ " : <strong>" + y + "</strong>(万)");
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
        // do something...
        //alert("create!!!");
//start
        //场内用户月均来场频率
        var timeplus=60*60*1000*12;
        function gd(year, month, day) {
            return new Date(year, month, day).getTime()+timeplus;
        }

        //销售金额
        var data1 = [
            [gd(2015, 3, 1),89.2],
            [gd(2015, 3, 2),78.5],
            [gd(2015, 3, 3), 68],
            [gd(2015, 3, 4), 64.3],
            [gd(2015, 3, 5), 92.4],
            [gd(2015,3, 6), 110],
            [gd(2015,3, 7), 87.3],
            [gd(2015, 3, 8),62.2]
            //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        var data1_p = [
            [gd(2015, 3, 8),62.2],
            [gd(2015, 3, 9), 81.6],
            [gd(2015, 3, 10), 78],
            [gd(2015, 3, 11), 90.7]

        //[gd(2015, 3, 12), 18]
    ];

        //线上金额
        var data2 = [
            [gd(2015, 3, 1),8.6],
            [gd(2015, 3, 2),7],
            [gd(2015, 3, 3), 6.6],
            [gd(2015, 3, 4), 11.6],
            [gd(2015, 3, 5), 9.8],
            [gd(2015,3, 6), 7],
            [gd(2015,3, 7), 8.2],
            [gd(2015, 3, 8),4.8]
            //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        var data2_p = [
            [gd(2015, 3, 8),4.8],
            [gd(2015, 3, 9), 8.1],
            [gd(2015, 3, 10), 4],
            [gd(2015, 3, 11), 12]
            //[gd(2015, 3, 12), 18]
        ];

        var datasetP = [
            // { label: "每月用户到场频率", data: data1 }
            { label: "总销售额",data: data1 },
            {
                label: "总销售额预测",
                data:data1_p,
                color:"#f4b79c",
                lines: {
                    show: true,
                    fill: true,
                    fillColor: "rgba(233, 117, 66, 0.08)"
                }
            },
            {
                label: "线上销售额",
                data:data2,
                color:"#2ecc71",
                lines: {
                    show: true,
                    fill: false

                }
            },
            {
                label: "线上销售额预测",
                data:data2_p,
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
                    var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                    return monthNames[d.getMonth()]+d.getDate()+'日';
                }
            },

            yaxis: {
                // axisLabel: "频率(次)",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:20,
                min:0,
                max:120,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v+"万";
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
                                "<strong>" + item.series.label + "</strong><br>" + monthNames[month] +date+'日'+ " : <strong>" + y + "</strong>(万)");
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

//flot--活跃用户量

$(document).ready(function(){
    if ($("#active-flot").find("canvas").get(0) == undefined) {
        // do something...
        //alert("create!!!");
//start
        //场内用户月均来场频率
        var timeplus=60*60*1000*12;
        function gd(year, month, day) {
            return new Date(year, month, day).getTime()+timeplus;
        }

        //活跃用户量
        var data1 = [
            [gd(2015, 2, 31), 8.9],

            [gd(2015, 3, 1),7.8],
            [gd(2015, 3, 2),7.5],
            [gd(2015, 3, 3), 6.8],
            [gd(2015, 3, 4), 9.6],
            [gd(2015, 3, 5), 9.8],
            [gd(2015,3, 6), 6.9],
            [gd(2015,3, 7), 6.3],
            [gd(2015, 3, 8),8.2],
            [gd(2015, 3, 9), 10.1]
           //    [gd(2015, 3, 9), 7.6],
            //    [gd(2015, 3, 10), 11],
            //    [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 8]
        ];
        /*
        var data1_p = [
            [gd(2015, 3, 8),7.2],
            [gd(2015, 3, 9), 7.6],
            [gd(2015, 3, 10), 11],
            [gd(2015, 3, 11), 9.7]
            //[gd(2015, 3, 12), 18]
        ];
*/


        var datasetP =[ { label: "活跃用户量",data: data1 }];
            // { label: "每月用户到场频率", data: data1 }

          /*  {
                label: "活跃用户量预测",
                data:data1_p,
                color:"#f5c0a9",
                lines: {
                    show: true,
                    fill: false,
                   // fillColor: "rgba(46, 204, 113, 0.1)"
                }
            },
            */



        var options = {
            series: {
                lines: {
                    show: true,
                    fill: false
                  //  fillColor: "rgba(46, 204, 113, 0.18)"
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
                    var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                    return monthNames[d.getMonth()]+d.getDate()+'日';
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
                max:12,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v+"万";
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
            colors: ["#e27c52", "#0022FF"]
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
                                "<strong>" + item.series.label + "</strong><br>" + monthNames[month] +date+'日'+ " : <strong>" + y + "</strong>(万)");
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

        $.plot($("#active-flot"), datasetP, options);
        $("#active-flot").UseTooltip();

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

/*
$(document).ready(function(e){
    var todayInterval= setInterval(function(){
        $.each($("#today-data i"),function(i,e){
           // console.log(parseFloat($(e).text()));
            var curVal=parseFloat($(e).text());

            var random=Math.random();
            var randomVal=parseFloat(random.toFixed(2));
         //   console.log(random);
            var pl= parseInt(random*10)%2==0? "+":"-";
            var newVal=null;
            var bottomWidth=parseInt($(this).attr("data-height"));
            console.log(bottomWidth);
            if(pl=="+"){
                newVal=Math.abs(curVal+randomVal);
                bottomWidth+=2;
            }else{
                newVal=Math.abs(curVal-randomVal);
                bottomWidth-=2;
            }

           console.log(bottomWidth);
            $(this).text(newVal.toFixed(1));
            $(this).closest("em").css("border-bottom-width",bottomWidth+'px');
        //    .closet("em").css("border-bottom-width",bottomWidth+'px');
        });
    },1000*2);

});
*/
/*
$(document).ready(function(e){
    var curDate=new Date();
  //  var cur_time=curDate.getHours()+":"+curDate.getMinutes(); //获取当前小时数(0-23)
    var min=parseInt(curDate.getMinutes());
    if(min>=10){
        cur_time=curDate.getHours()+ ":"+ min; //获取当前小时数(0-23)
    }else{
        cur_time=curDate.getHours()+":0"+ min; //获取当前小时数(0-23)
    }
    $("#cur-timing").text(cur_time);
   var timeInterval=setInterval(function(){
       var myDate=new Date();
       var min=parseInt(myDate.getMinutes());

        if(min>=10){
            cur_time=myDate.getHours()+ ":"+ min; //获取当前小时数(0-23)
        }else{
            cur_time=myDate.getHours()+":0"+ min; //获取当前小时数(0-23)
        }

       $("#cur-timing").text(cur_time);
   },1000*60);
});
*/