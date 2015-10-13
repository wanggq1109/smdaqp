<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

    <link href="../static/css/patch/patch.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../static/js/html5shiv.js"></script>
    <script src="../static/js/respond.min.js"></script>
    <![endif]-->
</head>

<body id="main-page" class="main-page">
<input id="mallId" name="mallId" type="hidden" value="${mallId}" >

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

    <div class="mainpanel" >

        <div class="pageheader">
            <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
            <a href="<%=basePath%>smdaqpController/index.do"><h2 id="mall-title"></h2></a>
        </div>

        <div class="contentpanel">
            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" >
                    <!--今日数据-->
                    <div class="row" id="cur-data-title">
                        <div class="col-sm-6  cur-data-date">
                            <p>今日数据</p>
                            <span>${toMonth}</span>
                        </div>
                        <div class="col-sm-5">
                            <h2 id="cur-timing">17:30</h2>
                        </div>
                    </div><!--end row 今日数据 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel" >

                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" >
                    <!--客流情况-->
                    <div class="row cur-data">
                        <div class="col-sm-12 cur-data-title">
                            <span>客流情况</span>
                        </div>
                        <div class="col-sm-10  cur-data-content" id="today-data">
                            <div class="row">
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em style="border-bottom:solid 20px #31cd73;"><i data-height="20">0</i>万</em></span>
                                    <span class="name" style="">WIFI</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count" ><em style="border-bottom:solid 20px #e97542;"><i data-height="20">0</i>万</em></span>
                                    <span class="name" style="">客流</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em  style="border-bottom:solid 20px #3498db;"><i data-height="20">0</i>万</em></span>
                                    <span class="name" style="">车流</span>
                                </div>
                            </div><!--end row-->
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div><!--end row 客流情况 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel">
                    <!--row-->
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">
                            <h3 class="subtitle mb5"><span>已用车位<em id="parkingCount">+142</em></span><span>车位负载<em id="parkingCountBili">35%</em></span></h3>
                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">
                                <span id="wifi">WIFI</span>
                                <span id="c-flow">客流</span>
                                <span id="car-flow">车流</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col  col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div id="customer-rate-flot" style="width: 100%; height:238px; "></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel">
                    <!--销售情况-->
                    <div class="row cur-data">
                        <div class="col-sm-12 cur-data-title">
                            <span>销售情况</span>
                        </div>

                        <div class="col-sm-12 cur-data-content">
                            <div class="col-sm-4 col-sm-offset-1">
                                <canvas id="salesChartA" width="80" height="80"></canvas>
                            </div>
                            <div class="col-sm-7 sales-info">
                                <h3>销售总额${amount+dataBoxPosmonitorSum}万 <span class="glyphicon glyphicon-arrow-up"></span></h3>
                                <span>线下${dataBoxPosmonitorSum}万 <em></em></span>
                                <span>线上${amount}万<em></em></span>
                            </div>

                        </div><!--end cur-data-content-->

                        <div class="col-sm-12 cur-data-content">
                            <div class="col-sm-4 col-sm-offset-1">
                                <!--<canvas id="salesChartB" width="80" height="80"></canvas>-->
                            </div>
                            <div class="col-sm-7 sales-info">
                                <!--<h3>订单商家覆盖率 <span class="glyphicon glyphicon-arrow-up"></span></h3>
                                <span>已成交商家62（占比21%）<em></em></span>
                                <span>所有商家300 <em></em></span>-->
                                <br>
                                <br>
                            </div>
``
                        </div><!--end cur-data-content-->


                    </div><!--end row 销售情况 -->
                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel" >
                    <!--row-->
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">

                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">

                                <span id="sales-all">线下金额</span>
                                <span id="wifi">线上金额</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col  col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div id="sales-flot" style="width: 100%; height:238px; "></div>
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

<script src="../static/js/patch/mall_data.js"></script>
<script src="../static/js/patch/mall.js"></script>

</body>
</html>

