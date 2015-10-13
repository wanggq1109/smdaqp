<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  <link rel="shortcut icon" href="images/favicon.png" type="image/png">

  <title>CRM S+</title>

  <link href="../static/css/style.default.css" rel="stylesheet">
  <link href="../static/css/jquery.datatables.css" rel="stylesheet">

  <link href="../static/css/patch/patch.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body id="main-page" class="main-page detail-page">

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>
<section>

  <div class="mainpanel screen">
	<input type="hidden" value=${data} id="data" ></input>
	<input type="hidden" id="data2" value=${data2} ></input>
	<input type="hidden" id="data3" value=${data3} ></input>
	<input type="hidden" id="tick" value=${tick}></input>
	<input type="hidden" id="tick2" value=${tick2}></input>
	<input type="hidden" id="tick3" value=${tick3}></input>
	<input type="hidden" id="date" value="${date}"/>
    <div class="pageheader ">
    <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
        <a href="/smdaqp/splus/index.do"><h2 id="mall-title"></h2></a>
        <div class="breadcrumb-wrapper">
            <span class="label">当前系统:</span>
            <ol class="breadcrumb">
                <li><a href="/smdaqp/splus/index.do">CRM S+</a></li>
                <li class="active">导视屏</li>
            </ol>
        </div>
    </div>
    
    <div class="contentpanel">

        <div class="row">
            <div class="col-sm-4 col-md-4 inner-left-panel" style="background-color: #fff;">
                <!--今日数据-->
                <div class="row" id="cur-data-title" style="margin-top: 20px;padding-bottom: 20px;">
                    <div class="col-sm-3 date-index">
                        <a href="/smdaqp/data/dataReport.do?date=${date}&type=pre"><span class="glyphicon glyphicon-chevron-left"></span></a>
                    </div>
                    <div class="col-sm-6  cur-data-date ">
                        <p>${date}</p>
                    </div>
                    <div class="col-sm-3 date-index">
                        <a href="/smdaqp/data/dataReport.do?date=${date}&type=next"><span class="glyphicon glyphicon-chevron-right"></span></a>
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

        <div class="row screen-info">
            <div class="col-sm-12 col-md-12" >
                <!--导视标题-->
                <div class="row cur-data">
                    <div class="col-sm-6 cur-data-title">
                        <span>导视屏1</span>
                        <em>位置 : <i>门口</i></em>
                        <em>健康度 : <i class="i-blue">良好</i></em>
                        <em>客流 : <i>${zeroStream}</i></em>
                        <em>版本号 : <i>V1.0</i></em>
                    </div>
                    <div class="col-sm-6">
                        <div class="lable-info pull-right">
                            <span id="car-flow">点击数 （单位:次）</span>
                        </div>
                    </div>
                </div><!--end row 导视标题 -->

                <div class="row">
                    <div class="col  col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div id="screen-flot" style="width: 100%; height:238px; "></div>
                            </div>
                        </div><!--panel -->
                    </div>
                </div>
            </div><!--end inner-left-panel-->

        </div> <!--end -row-->

        <div class="row screen-info">
        <div class="col-sm-12 col-md-12" >
            <!--导视标题-->
            <div class="row cur-data">
                <div class="col-sm-6 cur-data-title">
                    <span>导视屏2</span>
                    <em>位置 : <i>总经理办公室</i></em>
                    <em>健康度 : <i class="i-blue">良好</i></em>
                    <em>客流 : <i>${threeStream}</i></em>
                    <em>版本号 : <i>V1.0</i></em>
                </div>
                <div class="col-sm-6">
                    <div class="lable-info pull-right">
                        <span id="c-flow">点击数 （单位:次）</span>
                    </div>
                </div>
            </div><!--end row 导视标题 -->

            <div class="row">
                <div class="col  col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div id="screen-flot-2" style="width: 100%; height:238px; "></div>
                        </div>
                    </div><!--panel -->
                </div>
            </div>
        </div><!--end inner-left-panel-->

    </div> <!--end -row-->



        <div class="row screen-info">
            <div class="col-sm-12 col-md-12" >
                <!--导视标题-->
                <div class="row cur-data">
                    <div class="col-sm-6 cur-data-title">
                        <span>点击总计</span>

                        <em>健康度 : <i class="i-blue">良好</i></em>
                        <em>客流 : <i>${total}</i></em>

                    </div>
                    <div class="col-sm-6">
                        <div class="lable-info pull-right">
                            <span id="c-flow-2">点击数 （单位:次）</span>
                        </div>
                    </div>
                </div><!--end row 导视标题 -->

                <div class="row">
                    <div class="col  col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div id="screen-flot-3" style="width: 100%; height:238px; "></div>
                            </div>
                        </div><!--panel -->
                    </div>
                </div>
            </div><!--end inner-left-panel-->

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
<script src="../static/js/custom.js"></script>
<script src="../static/js/dashboard.js"></script>
-->
<script src="../static/js/custom.js"></script>
<script src="../static/js/patch/screen_data.js"></script>
<script src="../static/js/patch/screen_info.js"></script>
</body>
</html>

