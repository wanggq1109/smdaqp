/**
 * Created by user on 2015/5/22.
 */

//screen Data
//var screenTick = [[0, "广告1"], [1, "活动"], [2, "广告3"], [3, "作品展"],[4, "肯德基"], [5, "麦当劳"],[6, "广告4"],[7, "Blas"], [8, "功能1"],[9, '功能1']];//[a,b] a序列，b 名称
//var screenTick_2 = [[0, "广告1"], [1, "活动"], [2, "广告3"], [3, "作品展"],[4, "肯德基"], [5, "麦当劳"],[6, "广告4"],[7, "Blas"], [8, "功能1"],[9, '功能1']];//[a,b] a序列，b 名称
//var screenTick_3 = [[0, "广告1"], [1, "活动"], [2, "广告3"], [3, "作品展"],[4, "肯德基"], [5, "麦当劳"],[6, "广告4"],[7, "Blas"], [8, "功能1"],[9, '功能1']];//[a,b] a序列，b 名称
//var screenData = [[0, 11],[1, 15],[2, 25],[3, 24],[4, 13],[5, 18],[6,55],[7,20],[8,7],[9,7]]; //[a,b] a,序列， b,次数
//var screenData_2 = [[0, 11],[1, 15],[2, 25],[3, 24],[4, 13],[5, 18],[6,55],[7,20],[8,7],[9,7]]; //[a,b] a,序列， b,次数
//var screenData_3 = [[0, 11],[1, 15],[2, 25],[3, 24],[4, 13],[5, 18],[6,88],[7,20],[8,7],[9,7]]; //[a,b] a,序列， b,次数

var screenTick;
var screenTick_2;
var screenTick_3;
var screenData;
var screenData_2;
var screenData_3;

$(document).ready(function(){
	screenTick_3=eval('('+$("#tick").val()+')');
	
	screenTick=eval('('+$("#tick2").val()+')');

	screenTick_2=eval('('+$("#tick3").val()+')');

	screenData_3=eval('('+$("#data").val()+')');

	screenData=eval('('+$("#data2").val()+')');
	
	screenData_2=eval('('+$("#data3").val()+')');

});

