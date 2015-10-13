/**
 * Created by user on 2015/1/4.
 */
$(document).ready(function(){

    function gd(year,month,day){
        return new Date(year,month,day).getTime();
    }

    var data1 = [
        [gd(2015, 0, 1), 16522.10], [gd(2015, 0, 2), 17402.14], [gd(2015, 0, 3), 16073.77], [gd(2015, 0, 4), 16649.69],
        [gd(2015, 0, 5), 15991.19], [gd(2015, 0, 6), 15998.76], [gd(2015, 0, 7), 15989.90], [gd(2015, 0, 8), 16830.31],
        [gd(2015, 0, 9), 17484.81], [gd(2015, 0, 10), 17496.58], [gd(2015,0, 11), 18721.64], [gd(2015, 0, 12), 16984.76],
        [gd(2015, 0, 13), 16522.10], [gd(2015, 0, 14), 17402.14], [gd(2015, 0, 15), 16073.77], [gd(2015, 0, 16), 16649.69],
        [gd(2015, 0, 17), 15991.19], [gd(2015, 0, 18), 15998.76], [gd(2015, 0, 19), 15989.90], [gd(2015,0,20), 16830.31],
        [gd(2015, 0, 21), 17484.81], [gd(2015, 0, 22), 17496.58], [gd(2015, 0, 23), 18721.64], [gd(2015, 0, 24), 16984.76],
        [gd(2015, 0, 25), 16522.10], [gd(2015, 0, 26), 17402.14], [gd(2015,0, 27), 16073.77], [gd(2015, 0, 28), 16649.69],
        [gd(2015,0, 29), 17402.14], [gd(2015,0,30), 16073.77]
    ];
    var datasetSales = [
        { label: "2015年1月销售额", data: data1,color: "#1CAF9A"}
    ];


    var options={
        series: {
            lines: {
                show: true,
                fill: true,
                lineWidth: 1,
                fillColor: {
                    colors: [ { opacity: 0.5 },
                        { opacity: 0.3 }
                    ]
                }
            },
            points: {
                show: true
            },
            shadowSize: 0
        },
        legend: {
            position: 'nw'
        },
        grid: {
            hoverable: true,
            clickable: true,
            borderColor: '#ddd',
            borderWidth: 1,
            labelMargin: 10,
            backgroundColor: '#fff'
        },
        yaxis: {
            color: '#eee',
            axisLabel: "日销售额",
            axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Verdana, Arial',
            axisLabelPadding: 3,
            tickFormatter: function (v, axis) {
                return $.formatNumber(v, { format: "#,###", locale: "cn" });
            }
        },
        xaxis: {
            mode: "time",
            tickSize: [1, "day"],
            tickLength: 1,
            min: new Date(2015, 0, 2),
            max: new Date(2015, 0, 31),
            axisLabel: "2015年1月",
            axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Verdana, Arial',
            axisLabelPadding: 10,
            color: '#eee'
        }
    };

    var previousPoint = null, previousLabel = null;
   // var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

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
                   var year= new Date(x).getFullYear();
                    var month = parseInt(new Date(x).getMonth())+1;
                    var day=new Date(x).getDate();
                    //console.log(item);

                    if (item.seriesIndex == 0) {
                        showTooltip(item.pageX,
                            item.pageY,
                            color,
                                "<strong>" + item.series.label + "</strong><br>" + year +"年 "+month+"月 "+day + " : <strong>" + y + "</strong>(RMB)");
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
        }).appendTo("body").fadeIn(200);};


    $.plot($("#basicflot"),datasetSales,options);
    $("#basicflot").UseTooltip();

});
