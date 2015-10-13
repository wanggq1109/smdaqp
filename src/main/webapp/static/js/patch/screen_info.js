/**
 * Created by user on 2015/4/8.
 */



//flot--use cost POS

$(document).ready(function(){
    if ($("#screen-flot").find("canvas").get(0) == undefined) {
        var data = screenData;
        var data_2=screenData_2;
        var data_3=screenData_3;
        var dataset = [{ label: " 导视屏点击统计", data: data, color: "#5482FF" }];
        var dataset2 = [{ label: " 导视屏点击统计", data: data_2, color: "#e97542" }];
        var dataset3 = [{ label: " 导视屏点击统计(总）", data: data_3, color: "#2ecc71" }];
        var ticks = screenTick;
        var ticks_2=screenTick_2;
        var ticks_3=screenTick_3;
        var options = {
            series: {
                bars: {
                    show: true
                }
            },
            bars: {
                align: "center",
                barWidth: 0.5
            },
            xaxis: {
             //   axisLabel: "商户",
            //    axisLabelUseCanvas: true,
              //  tickSize: [1, "day"],

                tickLength:0,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                ticks: ticks

            },
            yaxis: {
            //    axisLabel: "Average Temperature",
            //    axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:2,
                tickFormatter: function (v, axis) {
                 //   return v + "次";
                    return parseInt(v);
                }
            },
            legend: {
                noColumns: 0,
               // labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
               borderWidth: 2,
                borderColor: "#eee",
                backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            }
        };

        var options_2 = {
            series: {
                bars: {
                    show: true
                }
            },
            bars: {
                align: "center",
                barWidth: 0.5
            },
            xaxis: {
                //   axisLabel: "商户",
                //    axisLabelUseCanvas: true,
                //  tickSize: [1, "day"],

                tickLength:0,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                ticks: ticks_2

            },
            yaxis: {
                //    axisLabel: "Average Temperature",
                //    axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:5,
                tickFormatter: function (v, axis) {
                    //   return v + "次";
                    return parseInt(v);
                }
            },
            legend: {
                noColumns: 0,
                // labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
                borderWidth: 2,
                borderColor: "#eee",
                backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            }
        };
        var options_3 = {
            series: {
                bars: {
                    show: true
                }
            },
            bars: {
                align: "center",
                barWidth: 0.5
            },
            xaxis: {
                //   axisLabel: "商户",
                //    axisLabelUseCanvas: true,
                //  tickSize: [1, "day"],

                tickLength:0,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 10,
                ticks: ticks_3

            },
            yaxis: {
                //    axisLabel: "Average Temperature",
                //    axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 3,
                tickSize:5,
                tickFormatter: function (v, axis) {
                    //   return v + "次";
                    return parseInt(v);
                }
            },
            legend: {
                noColumns: 0,
                // labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: true,
                borderWidth: 2,
                borderColor: "#eee",
                backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
            }
        };



        function gd(year, month, day) {
            return new Date(year, month, day).getTime();
        }

        var previousPoint = null, previousLabel = null;

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

                        //console.log(item.series.xaxis.ticks[x].label);

                        showTooltip(item.pageX,
                            item.pageY,
                            color,
                                "<strong>"  + y + "</strong> (次）");
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
                left: x - 30,
                border: '2px solid ' + color,
                padding: '3px',
                'font-size': '9px',
                'border-radius': '5px',
                'background-color': '#fff',
                'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
                opacity: 0.9
            }).appendTo("body").fadeIn(200);
        }

        $.plot($("#screen-flot"), dataset, options);
        $.plot($("#screen-flot-2"), dataset2, options_2);
        $.plot($("#screen-flot-3"), dataset3, options_3);
        $("#screen-flot").UseTooltip();
        $("#screen-flot-2").UseTooltip();
        $("#screen-flot-3").UseTooltip();
    }

});
