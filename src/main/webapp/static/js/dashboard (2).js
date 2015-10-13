$(document).ready(function(){
    new Morris.Donut({
        element: 'donut-chart2',
        data: [
            {label: "BlaBla 商品", value: 30},
            {label: "奶茶没有奶", value: 20},
            {label: "奶茶没有茶", value: 20},
            {label: "不能刷卡", value: 20},
            {label: "等待时间长", value: 10}
        ],
        colors: ['#D9534F','#1CAF9A','#428BCA','#5BC0DE','#428BCA']
    });
});