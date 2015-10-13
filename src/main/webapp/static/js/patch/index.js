/**
 * Created by user on 2015/4/9.
 */

$(document).ready(function(){
    var useRage_search=[

        {
            label:'娱乐',
            value : 500,//娱乐
            color : "#f6d36b"
        },
        {
            label:'美容服务品',
            value : 2000,//服饰
            color : "#1abc9c"
        },

        {
            label:'母婴育儿',
            value : 890,//电玩
            color : "#e97542"
        },


        {
            label:'餐饮',
            value: 1000,//餐饮
            color:"#e49d41"
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

});
