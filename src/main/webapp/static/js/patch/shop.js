/**
 * Created by user on 2015/4/8.
 */


$(document).ready(function () {

    //sales Chart A
    var new_old_data = newOldData;


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

    var new_old_count_ctx = document.getElementById("new-old").getContext("2d");
    var new_old_count = new Chart(new_old_count_ctx).Pie(new_old_data, new_old_count_options);

    //sales Chart B
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

    var sex_count_ctx = document.getElementById("sex-count").getContext("2d");
    var sex_count = new Chart(sex_count_ctx).Pie(sex_count_data, sex_count_options);
});


//flot--客流数据
$(document).ready(function () {
    if ($("#customer-flow-flot").find("canvas").get(0) == undefined) {
        // do something...
        //alert("create!!!");
//start
        //场内用户月均来场频率
        /*
        var timeplus = 60 * 60 * 1000 * 12;

        function gd(year, month, day) {
            return new Date(year, month, day).getTime() + timeplus;
        }
      */
        //客流量
        var data1 = customerFlowData;
        var data2=customerRateData;
        /*
         var data1_p = [
         [gd(2015, 3, 8),7.2],
         [gd(2015, 3, 9), 7.6],
         [gd(2015, 3, 10), 11],
         [gd(2015, 3, 11), 9.7]
         //[gd(2015, 3, 12), 18]
         ];
         */


        var datasetP = [
            { label: "客流量", data: data1 },
            {label:"提袋率",data:data2, yaxis: 2}
        ];
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
                    fill: true,
                    fillColor: "rgba(46, 204, 113, 0.1)"
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
                    var d = new Date(v);
                 //   var monthNames = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
                //    return monthNames[d.getMonth()] + d.getDate() + '日';
                    return d.getDate();
                }
            },

            yaxes:[ {
                axisLabel: "总客流量(人)",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize: 200,
                min: 0,
                max: 1000,
                tickFormatter: function (v, axis) {
                    // return $.formatNumber(v, { format: "#,###", locale: "us" });
                    return v + "人";
                }
            },{
                position: "right",
                axisLabel: "提袋率(%)",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3
            }],
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
            colors: ["#e27c52", "#3498db"]
        };

        var previousPoint = null, previousLabel = null;
        // var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        //var dayNames = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", '31'];
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
                        var date = new Date(x).getDate();
                        //console.log(item);
                    /*    showTooltip(item.pageX,
                            item.pageY,
                            color,
                                "<strong>" + item.series.label + "</strong><br>" + date + '日' + " : <strong>" + y + "</strong>(万)");
                                */
                        if (item.seriesIndex == 0) {
                         showTooltip(item.pageX,
                         item.pageY,
                         color,
                         "<strong>" + item.series.label + "</strong><br>" + date + '日'  + " : <strong>" + y + "</strong>(人)");
                         } else {
                         showTooltip(item.pageX,
                         item.pageY,
                         color,
                         "<strong>" + item.series.label + "</strong><br>" + date + '日'  + " : <strong>" + y + "</strong>(%)");
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

        $.plot($("#customer-flow-flot"), datasetP, options);
        $("#customer-flow-flot").UseTooltip();

// ene
    } //end if ($("customer-rate-flot")
});


//环状图
$(document).ready(function (e) {
    //consume_search

    var consume_search =consumeSearch;
    var consume_search_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout: 65,

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

    var consume_search_ctx = document.getElementById("consume-search").getContext("2d");
    var consume_search_donut = new Chart(consume_search_ctx).Doughnut(consume_search, consume_search_options);

    //age range

    var product_range =productRange;
    var product_range_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout: 65,

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

    var product_range_ctx = document.getElementById("product-range").getContext("2d");
    var product_range_donut = new Chart(product_range_ctx).Doughnut(product_range, product_range_options);


    var age_range =ageRange;
    var age_range_options = {
        //Boolean - Whether we should show a stroke on each segment
        segmentShowStroke: true,

        //String - The colour of each segment stroke
        segmentStrokeColor: "#fff",

        //Number - The width of each segment stroke
        segmentStrokeWidth: 3,

        //The percentage of the chart that we cut out of the middle.
        percentageInnerCutout: 65,

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
    var age_range_donut = new Chart(age_range_ctx).Doughnut(age_range, age_range_options);

});


