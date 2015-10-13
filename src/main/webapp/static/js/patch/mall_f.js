/**
 * Created by user on 2015/4/8.
 */

$(document).ready(function(){

    //sales Chart A
    var salesChartA_data=[

        {
            value : 98,
            color : "#1abc9c"
        },
        {
            value: 12,
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
            value : 79,
            color : "#1abc9c"
        },
        {
            value: 21,
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

    jQuery('#sparkline').sparkline([4,2,2,6,4,3,4,3,2,7,9,6,1], {
        type: 'bar',
        barWidth:'17px',
        height:'140px',
        barSpacing:'3px',
        barColor: '#e49d41'
    });
});

//flot

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

        var datasetP = [
           // { label: "每月用户到场频率", data: data1 }
            { label: "WIFI使用",data: data1 },
            {
                label: "WIFI使用预测",
                data:data1_p,
                color:"#8bebb4",
                lines: {
                        show: true,
                        fill: true,
                        fillColor: "rgba(46, 204, 113, 0.1)"
                        }
            },
            {
                label: "场内客流",
                data:data2,
                color:"#e97542",
                lines: {
                    show: true,
                    fill: false

                }
            },
            {
                label: "场内客流预测",
                data:data2_p,
                color:"#f5c0a9",
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
                    fillColor: "rgba(46, 204, 113, 0.2)"
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
            colors: ["#2ecc71", "#0022FF"]
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
