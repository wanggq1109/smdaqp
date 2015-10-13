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

<body id="main-page" class="main-page detail-page">
<input id="mallId" name="mallId" type="hidden" value="${mallId}" >
<input id="date" name="date" type="hidden" value="${toMonth}" >
<input id="type" name="type" type="hidden" value="${type}" >

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

    <div class="mainpanel" >

        <div class="pageheader">
            <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
            <a href="/smdaqp/splus/index.do"><h2 id="mall-title"></h2></a>
            <div class="breadcrumb-wrapper">
                <span class="label">当前系统:</span>
                <ol class="breadcrumb">
                    <li><a href="/smdaqp/splus/index.do">CRM S+</a></li>
                    <li class="active">MALL</li>
                </ol>
            </div>
        </div>

        <div class="contentpanel">
            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel" >
                    <!--今日数据-->
                    <div class="row" id="cur-data-title">
                        <div class="col-sm-3 date-index">
                            <a href="mall.do?date=${toMonth}&type=-1&mallId=${mallId}"><span class="glyphicon glyphicon-chevron-left"></span></a>
                        </div>
                        <div class="col-sm-6  cur-data-date ">
                            <p>${toMonth}</p>
                        </div>
                        <div class="col-sm-3 date-index">
                            <a href="mall.do?date=${toMonth}&type=1&mallId=${mallId}"><span class="glyphicon glyphicon-chevron-right"></span></a>
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
                                    <span class="count"><em style="border-bottom:solid 34px #31cd73;"><i data-height="20">345</i></em></span>
                                    <span class="name" style="">WIFI</span>
                                </div>

                                <div class="col-sm-4 customer-status">
                                    <span class="count" ><em style="border-bottom:solid 80px #e97542;"><i data-height="40">${countBeancon}</i></em></span>
                                    <span class="name" style="">客流</span>
                                </div>
                                <div class="col-sm-4 customer-status">
                                    <span class="count"><em  style="border-bottom:solid 23px #3498db;"><i data-height="9">126</i></em></span>
                                    <span class="name" style="">车流</span>
                                </div>

                            </div><!--end row-->
                        </div>
                    </div><!--end row 客流情况 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel">
                    <!--row-->
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">
                            <h3 class="subtitle mb5"><span>已用车位<em>+29</em></span><span>车位负载<em>23.9%</em></span></h3>
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
                            <div class="col-sm-4">
                                <canvas id="salesChartA" width="80" height="80"></canvas>
                            </div>
                            <div class="col-sm-8 sales-info">
                                <input id="dataBoxPosmonitorSum" name="dataBoxPosmonitorSum" type="hidden" value="${dataBoxPosmonitorSum}" >
                                <h3>销售总额${dataBoxPosmonitorSum+1.5}万 <span class="glyphicon glyphicon-arrow-up"></span></h3>
                                <span>线上1.5万（订单数34）<em style="background-color:#e97542"></em></span>
                                <span>线下1340.00万 <em style="background-color: #1abc9c"></em></span>
                            </div>

                        </div><!--end cur-data-content-->

                        <div class="col-sm-12 cur-data-content">
                            <div class="col-sm-4">
                                <canvas id="salesChartB" width="80" height="80"></canvas>
                            </div>
                            <div class="col-sm-8 sales-info">
                                <h3>订单商家覆盖率 <span class="glyphicon glyphicon-arrow-up"></span></h3>
                                <span>已成交商家23（占比40.9%）<em style="background-color: #f6d36b;"></em></span>
                                <span >所有商家1 <em style="background-color: #1abc9c"></em></span>
                            </div>

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

                                <span id="sales-all">线上金额</span>
                                <span id="sales-online">线下金额</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12  col-md-12">
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



            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel">
                    <!--年龄分布-->
                    <div class="row cur-data" style="min-height: 350px;">
                        <div class="col-sm-12 cur-data-title">
                            <span>年龄分布</span>
                        </div>
                        <div class="col-sm-10 cur-data-content">
                            <div class="row ">
                                <div class="col-sm-6">
                                    <canvas id="age-range" width="160" height="160" style="width: 160px; height: 160px; margin-top: 12px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-3 col-sm-offset-2 sales-info user-cost-info">

                                    <span>15-20岁<em class="age-10"></em></span>
                                    <span>20岁<em class="age-20"></em></span>
                                    <span>30岁<em class="age-30"></em></span>
                                    <span>40岁<em class="age-40"></em></span>
                                    <span>50岁<em class="age-50"></em></span>
                                    <span>60岁<em class="age-60"></em></span>
                                    <span>70岁<em class="age-70"></em></span>
                                </div>
                            </div>
                        </div><!--end cur-data-content-->


                    </div><!--end row 特征指标 -->

                </div><!--end inner left panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel ">
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">

                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">

                                <span id="">消费年龄分布（人次）</span>

                            </div>
                        </div>
                    </div>
                    <div class="row active-flot-wrapper">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div id="age-stack-flot" style="width: 100%; height:268px;"></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel">
                    <!--性别比例-->
                    <div class="row cur-data" style="min-height: 350px;">
                        <div class="col-sm-12 cur-data-title">
                            <span>性别比例</span>
                        </div>
                        <div class="col-sm-10 cur-data-content">
                            <div class="row ">
                                <div class="col-sm-6">
                                    <canvas id="sex-range" width="160" height="160" style="width: 160px; height: 160px; margin-top: 12px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-3 col-sm-offset-2 sales-info user-cost-info">

                                    <span>男<em class="em-blue"></em></span>
                                    <span>女<em class="em-red"></em></span>
                                </div>
                            </div>
                        </div><!--end cur-data-content-->


                    </div><!--end row 特征指标 -->

                </div><!--end inner left panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel ">
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">
                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">
                                <span class="span-green">男(人次)</span>
                                <span class="span-red">女(人次)</span>
                            </div>
                        </div>
                    </div>
                    <div class="row active-flot-wrapper">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div id="sex-stack-flot" style="width: 100%; height:268px;"></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel">
                    <!--性别比例-->
                    <div class="row cur-data" style="min-height: 350px;">
                        <div class="col-sm-12 cur-data-title">
                            <span>新老客户比例</span>
                        </div>
                        <div class="col-sm-10 cur-data-content">
                            <div class="row ">
                                <div class="col-sm-6">
                                    <canvas id="new-old-range" width="160" height="160" style="width: 160px; height: 160px; margin-top: 12px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-3 col-sm-offset-2 sales-info user-cost-info">

                                    <span>新客户<em class="em-blue"></em></span>
                                    <span>老客户<em class="em-yellow"></em></span>
                                </div>
                            </div>
                        </div><!--end cur-data-content-->


                    </div><!--end row 特征指标 -->

                </div><!--end inner left panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel ">
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">
                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">
                                <span class="span-green">新客户(人次)</span>
                                <span class="span-yellow">老客户(人次)</span>
                            </div>
                        </div>
                    </div>
                    <div class="row active-flot-wrapper">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div id="new-old-stack-flot" style="width: 100%; height:268px;"></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel">
                    <!--性别比例-->
                    <div class="row cur-data" style="min-height: 350px;">
                        <div class="col-sm-12 cur-data-title">
                            <span>付款方式</span>
                        </div>
                        <div class="col-sm-10 cur-data-content">
                            <div class="row ">
                                <div class="col-sm-6">
                                    <canvas id="pay-range" width="160" height="160" style="width: 160px; height: 160px; margin-top: 12px;">
                                    </canvas>
                                </div>
                                <div class="col-sm-3 col-sm-offset-2 sales-info user-cost-info">
                                    <span>现金<em class="em-red"></em></span>
                                </div>
                            </div>
                        </div><!--end cur-data-content-->


                    </div><!--end row 特征指标 -->

                </div><!--end inner left panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel ">
                    <div class="row cur-stop-data">
                        <div class="col-sm-6">
                        </div>
                        <div class="col-sm-6">
                            <div class="lable-info pull-right">
                                <span class="span-red">现金</span>
                            </div>
                        </div>
                    </div>
                    <div class="row active-flot-wrapper">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div id="pay-stack-flot" style="width: 100%; height:268px;"></div>
                                </div>
                            </div><!--panel -->
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end inner-right -panel-->
            </div> <!--end -row-->

            <div class="row">
                <div class="col-sm-3 col-md-3 inner-left-panel use-rage-left">
                    <!--APP使用热度-->
                    <div class="row cur-data" style="min-height: 335px;">
                        <div class="col-sm-12 cur-data-title">
                            <span>APP使用热度</span>
                        </div>
                        <div class="col-sm-12  cur-data-content">
                            <div class="row app-info">
                                <div class="col-sm-3 app-info-title">搜索</div>
                                <div class="col-sm-7">
                                    <div class="progress progress-mall-info">
                                        <div style="width: 62%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                                    </div>
                                </div>
                                <div calss="col-sm-2 app-info-count">0.5万</div>
                            </div><!--end row-->
                            <div class="row app-info">
                                <div class="col-sm-3 app-info-title">问一问</div>
                                <div class="col-sm-7">
                                    <div class="progress progress-mall-info">
                                        <div style="width: 78%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                                    </div>
                                </div>
                                <div calss="col-sm-2 app-info-count">0.7万</div>
                            </div><!--end row-->
                            <div class="row app-info">
                                <div class="col-sm-3 app-info-title">新增积分</div>
                                <div class="col-sm-7">
                                    <div class="progress progress-mall-info">
                                        <div style="width: 55%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                                    </div>
                                </div>
                                <div calss="col-sm-2 app-info-count">0.5万</div>
                            </div><!--end row-->
                        </div><!--end cur-data-content-->

                    </div><!--end row APP使用热度 -->


                </div><!--end inner-left-panel-->
                <div class="col-sm-9 col-md-9 inner-right-panel">
                    <div class="col-sm-4">
                        <div class="use-rage">
                            <canvas id="use-rage-search" width="210" height="210">

                            </canvas>
                            <div class="use-rage-info">
                                <h3>搜索</h3>
                                <h3>16060</h3>
                                <p>累计获取16060</p>
                                <p>问一问4500</p>
                            </div>
                            <div class="use-rage-label label-1" id="label-1-1">
                                娱乐2500
                                <span></span>
                            </div>
                            <div class="use-rage-label label-2" id="label-1-2">
                                服饰2600
                                <span></span>
                            </div>
                            <div class="use-rage-label label-3" id="label-1-3">
                                电玩1560
                                <span></span>
                            </div>
                            <div class="use-rage-label label-4" id="label-1-4">
                                餐饮9500
                                <span></span>
                            </div>
                            <div class="h-line">  </div>
                        </div>

                    </div>
                    <div class="col-sm-4">
                        <div class="use-rage">
                            <canvas id="use-rage-ask" width="210" height="210">

                            </canvas>
                            <div class="use-rage-info">
                                <h3>问一问</h3>
                                <h3>7500</h3>
                                <p>搜索4500</p>
                                <p>其他3000</p>
                            </div>
                            <div class="use-rage-label label-1" id="label-2-1">
                                娱乐1100
                                <span></span>
                            </div>
                            <div class="use-rage-label label-2" id="label-2-2">
                                服饰1100
                                <span></span>
                            </div>
                            <div class="use-rage-label label-3" id="label-2-3">
                                电玩680
                                <span></span>
                            </div>
                            <div class="use-rage-label label-4" id="label-2-4">
                                餐饮4620
                                <span></span>
                            </div>

                            <div class="h-line">  </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="use-rage use-rage-last">
                            <canvas id="use-rage-new" width="210" height="210">

                            </canvas>
                            <div class="use-rage-info">
                                <h3>新增积分</h3>
                                <h3>7890</h3>
                                <p>累计获取7890</p>
                                <p>累计消耗4500</p>
                            </div>
                            <div class="use-rage-label label-1" id="label-3-1">
                                娱乐1200
                                <span></span>
                            </div>
                            <div class="use-rage-label label-2" id="label-3-2">
                                服饰1300
                                <span></span>
                            </div>
                            <div class="use-rage-label label-3" id="label-3-3">
                                电玩890
                                <span></span>
                            </div>
                            <div class="use-rage-label label-4" id="label-3-4">
                                餐饮4500
                                <span></span>
                            </div>

                        </div>

                    </div>
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

