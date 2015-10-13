<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../static/images/favicon.png" type="image/png">

    <title>CRM S+</title>

    <link href="../static/css/style.default.css" rel="stylesheet">
    <link href="../static/css/jquery.datatables.css" rel="stylesheet">

    <link href="../static/css/patch/patchnew.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../static/js/html5shiv.js"></script>
    <script src="../static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body id="main-page" class="main-page detail-page">
<input id="merchantId" name="merchantId" type="hidden" value="${dataBoxPosmonitorData.merchantid}" >
<input id="date" name="date" type="hidden" value="${toMonth}" >
<input id="type" name="type" type="hidden" value="${type}" >
<input id="dataBoxSum" name="dataBoxSum" type="hidden" value="${dataBoxSum}" >

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

    <div class="mainpanel">

        <div class="pageheader ">
            <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
            <a href="/smdaqp/splus/index.do"><h2 id="mall-title"></h2></a>
            <div class="breadcrumb-wrapper">
                <span class="label">当前系统:</span>
                <ol class="breadcrumb">
                    <li><a href="/smdaqp/splus/index.do">CRM S+</a></li>
                    <li class="active">${dataBoxPosmonitorData.merchantname}</li>
                </ol>
            </div>
        </div>

        <div class="contentpanel">

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" style="background-color: #fff;">
                    <!--今日数据-->
                    <div class="row" id="cur-data-title">
                        <div class="col-sm-3 date-index">
                            <a href="shop.do?date=${toMonth}&type=-1&merchantId=${dataBoxPosmonitorData.merchantid}"><span class="glyphicon glyphicon-chevron-left"></span></a>
                        </div>
                        <div class="col-sm-6  cur-data-date">
                            <p>${toMonth}</p>
                        </div>
                        <div class="col-sm-3 date-index">
                            <a href="shop.do?date=${toMonth}&type=1&merchantId=${dataBoxPosmonitorData.merchantid}"><span class="glyphicon glyphicon-chevron-right"></span></a>
                        </div>
                        <!--
                        <div class="col-sm-5">
                            <h2 id="cur-user"></h2>
                        </div>
                        -->  <div class="row">
                        <div class="col-sm-6 col-sm-offset-3" style="text-align: center">
                            <span id="btn-month-view">月</span>
                            <span id="btn-day-view">日</span>
                        </div>
                    </div>
                    </div><!--end row 今日数据 -->

                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel" >
                    <div class="row" id="cur-shop-title" style="margin-top: 20px;">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">${dataBoxPosmonitorData.merchantname}</h4>

                                <div class="row shop-summary">
                                    <div class="col-sm-3"><em>业态：</em><span>休闲餐饮</span></div>
                                    <div class="col-sm-3"><em>计租面积：</em><span>120平米</span></div>
                                    <div class="col-sm-3"><em>签约时间：</em><span>2015年01月</span></div>
                                    <div class="col-sm-3"><em>铺位号：</em><span>0001</span></div>
                                    <div class="col-sm-3"><em>租金方式：</em><span>提成租金</span></div>
                                    <div class="col-sm-3"><em>本账期应收金额：</em><span><a href="http://pd.powerlong.com/bis/bs-info-rent2!input.action?id=402834e53faea62c013fb7796e220a1f&bisProjectId=6D7E1C7AFAFB43E986670A81CF436598">12.00</a></span></div>
                                    <div class="col-sm-3"><em>物管费：</em><span>150元</span></div>
                                </div>

                            </div>

                        </div>

                    </div><!--end row 今日数据 -->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel use-rage-left">
                    <!--消费总金额-->
                    <div class="row cur-data">
                        <div class="col-sm-12 cur-data-title">
                            <span>消费总金额 : ${dataBoxSum+450+890}</span>
                        </div>
                        <div class="col-sm-10  cur-data-content">
                            <div class="row">
                                <div class="col-sm-4 col-sm-offset-2 customer-status">
                                    <span class="count"><em style="border-bottom:solid 35px #BDBDBD;"><i data-height="20">1609.0</i></em></span>
                                    <span class="name" style="">${monthStr1}</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em style="border-bottom:solid 95px #1ABC9C;"><i data-height="20">${dataBoxSum+450+890}</i></em></span>
                                    <span class="name" style="">${toMonth}</span>
                                </div>

                            </div>
                        </div>

                    </div><!--end row 消费总金额 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel">
                    <!--row-->
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="col-sm-12 cur-data-content count-rage">
                                <div class="col-sm-5 col-sm-offset-1">
                                    <canvas id="consume-search" width="210" height="210" style="width: 210px; height: 210px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-4 col-sm-offset-2 sales-info consume-info">
                                    <h3>支付方式 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                    <span>现金（1340.0）<em class="em-red"></em></span>
                                    <span>支付宝（890.0）<em class="em-yellow"></em></span>
                                    <span>微信支付（450.0） <em class="em-blue"></em></span>
                                </div>
                                <div class="h-line">  </div>
                            </div><!--end cur-data-content-->

                        </div>
                        <div class="col-sm-6">
                            <div class="col-sm-12 cur-data-content count-rage">
                                <div class="col-sm-5 col-sm-offset-1">
                                    <canvas id="product-range" width="210" height="210" style="width: 210px; height: 210px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-4 col-sm-offset-2 sales-info consume-info">
                                    <h3>商品销售比例<!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                    <span>${(dataBoxSum==0.00||dataBoxSum==null)?"":"龙井"}<em class="age-10"></em></span>
                                </div>
                                <div class="h-line">  </div>
                            </div><!--end cur-data-content-->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" >
                    <!--消费总人数-->
                    <div class="row cur-data">
                        <div class="col-sm-12 cur-data-title">
                            <span>消费总人数 : 123</span>
                        </div>
                        <div class="col-sm-12">
                            <em style="font-style: normal;display: inline-block;margin-left: 22px;margin-top:6px;font-size: 16px;color:#333;">客单价：<i style="font-style: normal;">
                            <c:if test="${count==0}">
                                12
                            </c:if>
                            <c:if test="${count!=0}">
                                ${dataBoxSum/count}
                            </c:if>
                            </i></em>
                        </div>
                        <div class="col-sm-10  cur-data-content" id="today-data">
                            <div class="row">
                                <div class="col-sm-4 col-sm-offset-2 customer-status">
                                    <span class="count"><em style="border-bottom:solid 50px #BDBDBD;"><i data-height="20">5</i></em></span>
                                    <span class="name" style="">${monthStr1}</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em style="border-bottom:solid 90px #1ABC9C;"><i data-height="20">123</i></em></span>
                                    <span class="name" style="">${toMonth}</span>
                                </div>
                            </div><!--end row-->

                        </div>
                    </div><!--end row 消费总人数 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="row cur-data-content count-rage">
                                <div class="col-sm-6">
                                    <canvas id="age-range" width="200" height="200" style="width: 200px; height: 200px;margin-top: 12px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-3 col-sm-offset-3 sales-info user-cost-info">
                                    <h3>年龄分布<!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                    <span>15-20岁<em class="age-10"></em></span>
                                    <span>20岁<em class="age-20"></em></span>
                                    <span>30岁<em class="age-30"></em></span>
                                    <span>40岁<em class="age-40"></em></span>
                                    <span>50岁<em class="age-50"></em></span>
                                    <span>60岁<em class="age-60"></em></span>
                                    <span>70岁<em class="age-70"></em></span>
                                </div>
                            </div>

                            <div class="h-line">  </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="col-sm-12 cur-data-content count-rage">
                                <div class="col-sm-4" style="text-align: center">
                                    <canvas id="new-old" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                    </canvas>
                                    <div style="text-align: center">新老客户比例</div>
                                </div>
                                <div class="col-sm-4" style="text-align: center">
                                    <canvas id="sex-count" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                    </canvas>
                                    <div style="text-align: center">性别消费比例</div>
                                </div>
                                <div class="col-sm-3 col-sm-offset-1 sales-info user-cost-info">
                                    <h3>比例统计 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                    <span>男性<em class="em-blue"></em></span>
                                    <span>女性<em class="em-red"></em></span>
                                    <span>新客户<em class="em-blue"></em></span>
                                    <span>老客户<em class="em-yellow"></em></span>
                                </div>

                            </div><!--end cur-data-content-->

                        </div>
                    </div>
                    <!--row-->

                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" style=" min-height: 320px;">

                    <!--总客流量-->
                    <div class="row cur-data">
                        <div class="col-sm-12 cur-data-title">
                            <span>总客流量 : ${countBeancon} / 提袋率 :
                                <c:if test="${count==0}">
                                    3.09%
                                </c:if>
                                <c:if test="${count!=0}">
                                    ${tidailu}%
                                </c:if>
                                </span>
                        </div>
                        <div class="col-sm-10  cur-data-content" >
                            <div class="row">
                                <div class="col-sm-4 col-sm-offset-2 customer-status">
                                    <span class="count"><em style="border-bottom:solid 1px #BDBDBD;"><i data-height="20">
                                        <c:if test="${countTraffic1==0}">
                                            0%
                                        </c:if>
                                        <c:if test="${countTraffic1!=0}">
                                            0.79%
                                        </c:if></i></em></span>
                                    <span class="name" style="">${monthStr1}</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em style="border-bottom:solid 2px #1ABC9C;"><i data-height="20">
                                        <c:if test="${countBeancon==0}">
                                            3.09%
                                        </c:if>
                                        <c:if test="${countBeancon!=0}">
                                            3.09%
                                        </c:if></i></em></span>
                                    <span class="name" style="">${toMonth}</span>
                                </div>
                            </div><!--end row-->
                        </div>
                    </div><!--end row 总客流量 -->
                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel" >
                    <!--row-->

                    <div class="row cur-stop-data">
                        <div class="col-sm-6">

                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">
                                <span id="c-flow">客流</span>
                                <span id="c-flow-blue">提袋率</span>
                            </div>
                        </div>
                    </div> <!--end row -->
                    <div class="row">
                        <div class="col col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div id="customer-flow-flot" style="width: 100%; height:238px; "></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->

                </div><!--end inner-right -panel-->
            </div> <!--end -row-->




        </div> <!-- contentpanel -->

    </div><!-- mainpanel -->

</section>


<script src="../static/js/jquery-1.10.2.min.js"></script>
<script src="../static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/modernizr.min.js"></script>
<script src="../static/js/jquery.sparkline.min.js"></script>
<script src="../static/js/toggles.min.js"></script>
<script src="../static/js/retina.min.js"></script>
<script src="../static/js/jquery.cookies.js"></script>

<script src="../static/js/flot/flot.min.js"></script>
<script src="../static/js/flot/flot.resize.min.js"></script>
<script src="../static/js/morris.min.js"></script>
<script src="../static/js/raphael-2.1.0.min.js"></script>

<script src="../static/js/flot/jshashtable-2.1.js"></script>
<script src="../static/js/flot/flot.resize.min.js"></script>
<script src="../static/js/flot/jquery.flot.time.js"></script>
<script src="../static/js/flot/flot.pie.min.js"></script>
<script src="../static/js/flot/jquery.flot.stack.js"></script>
<script src="../static/js/flot/jquery.flot.symbol.js"></script>
<script src="../static/js/flot/jquery.flot.axislabels.js"></script>
<script src="../static/js/flot/jquery.numberformatter-1.2.3.min.js"></script>
<script src="../static/js/flot/jquery.flot.tooltip.js"></script>

<script src="../static/js/jquery.datatables.min.js"></script>
<script src="../static/js/chosen.jquery.min.js"></script>

<script src="../static/js/patch/Chart.js"></script>
<!--
<script src="js/custom.js"></script>
<script src="js/dashboard.js"></script>
-->
<script src="../static/js/custom.js"></script>
<script src="../static/js/patch/shop_data.js"></script>
<script src="../static/js/patch/shop.js"></script>

</body>
</html>



