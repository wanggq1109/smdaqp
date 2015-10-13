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

  <link href="../static/css/patch/patch.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="../static/js/html5shiv.js"></script>
  <script src="../static/js/respond.min.js"></script>
  <![endif]-->
</head>

<body id="main-page" class="main-page">
<input id="merchantId" name="merchantId" type="hidden" value="${dataBoxPosmonitorData.merchantid}" >

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

  <div class="mainpanel" >

    <div class="pageheader">
    <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
        <a href="index.html"><h2 id="mall-title"></h2></a>
    </div>
    
    <div class="contentpanel">
        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" >
                <!--今日数据-->
                <div class="row" id="cur-data-title">
                    <div class="col-sm-6  cur-data-date">
                        <p>${dataBoxPosmonitorData.merchantname}</p>
                        <span>${toMonth}</span>
                    </div>
                    <div class="col-sm-5">
                        <h2 id="cur-user"></h2>
                    </div>
                </div><!--end row 今日数据 -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel" >

            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" >
                <!--消费总人数-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>消费总人数</span>
                    </div>
                    <div class="col-sm-10  cur-data-content" id="today-data">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-4 customer-status">
                            <span class="count"><em style="border-bottom:solid ${count>100?count/10:count}px #31cd73;"><i data-height="20">${count}</i></em></span>
                            <!--  <span class="name" style="">WIFI</span>  -->
                        </div>

                    </div><!--end row-->
                </div>
                </div><!--end row 消费总人数 -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
                <!--row-->
                <div class="row">
                    <div class="col-sm-6">
                        <div class="col-sm-12 cur-data-content count-rage">
                            <div class="col-sm-5 col-sm-offset-1">
                                <canvas id="flow-count" width="180" height="180" style="width: 180px; height: 180px;"></canvas>
                            </div>
                            <div class="col-sm-5 col-sm-offset-1 sales-info">
                                <h3>销售总额${appPayData1+dataBoxSum} <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <span>线上${appPayData1}<em class="em-red"></em></span>
                                <span>线下${dataBoxSum} <em class="em-blue"></em></span>
                            </div>
                            <div class="h-line">  </div>
                        </div><!--end cur-data-content-->

                    </div>
                    <div class="col-sm-6">
                        <div class="col-sm-12 cur-data-content count-rage">
                            <div class="col-sm-5 col-sm-offset-1">
                                <canvas id="sex-count" width="180" height="180" style="width: 180px; height: 180px;"></canvas>
                            </div>
                            <div class="col-sm-5 col-sm-offset-1 sales-info">
                                <h3>性别消费比例<!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <c:forEach var="dataBoxPosmonitor" items="${dataBoxPosmonitors}" >
                                    <c:if test="${dataBoxPosmonitor.merchantname=='0'}">
                                        <span>女性${dataBoxPosmonitor.id}人次<em class="em-yellow"></em></span>
                                    </c:if>
                                    <c:if test="${dataBoxPosmonitor.merchantname=='1'}">
                                        <span>男性${dataBoxPosmonitor.id}人次<em class="em-yellow"></em></span>
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="h-line">  </div>
                        </div><!--end cur-data-content-->
                    </div>
                </div>
                <!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" style=" min-height: 320px;">

                <!--总客流量-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>总客流量</span>
                    </div>
                    <div class="col-sm-10  cur-data-content" >
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4 customer-status">
                                <span class="count"><em style="border-bottom:solid ${(countTraffic>100)?(countTraffic>1000?countTraffic/100:countTraffic)/10:countTraffic*10}px #e97542;"><i data-height="20">${countTraffic}</i>人</em></span>
                                <!--  <span class="name" style="">WIFI</span>  -->
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

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel use-rage-left">
                <!--消费总金额-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>消费总金额</span>
                    </div>
                    <div class="col-sm-10  cur-data-content">
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4 customer-status">
                                <span class="count"><em style="border-bottom:solid ${(payCount>100)?(payCount>1000?payCount/100:payCount)/10:payCount}px #31cd73;"><i data-height="10">${payCount}</i>万</em></span>
                                <!--  <span class="name" style="">WIFI</span>  -->
                            </div>

                        </div><!--end row-->
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
                                <h3>业态消费 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>

                            </div>
                            <div class="h-line">  </div>
                        </div><!--end cur-data-content-->

                    </div>

                    <div class="col-sm-6">
                        <div class="col-sm-12 cur-data-content count-rage">
                            <div class="col-sm-5 col-sm-offset-1">
                                <canvas id="age-range" width="210" height="210" style="width: 210px; height: 210px;">
                                </canvas>
                            </div>
                            <div class="col-sm-4 col-sm-offset-2 sales-info consume-info">
                                <h3>年龄分布<!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <c:forEach var="databoxItemtype" items="${databoxItemtypes}" >
                                    <span>${databoxItemtype.itmeType}岁段 （${(databoxItemtype.id/countAge)*100}%）<em class="age-${databoxItemtype.itmeType}"></em></span>
                                </c:forEach>
                                    <!--<span>15-20岁段 （5%）<em class="age-10"></em></span>
                                    <span>20岁段 （20%）<em class="age-20"></em></span>
                                    <span>30岁段 （20%）<em class="age-30"></em></span>
                                    <span>40岁段 （20%）<em class="age-40"></em></span>
                                    <span>50岁段 （10%）<em class="age-50"></em></span>
                                    <span>60岁段 （10%）<em class="age-60"></em></span>
                                    <span>70岁段 （5%）<em class="age-70"></em></span>-->
                            </div>
                            <div class="h-line">  </div>
                        </div><!--end cur-data-content-->
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
<script src="../static/js/custom.js"></script>
<script src="../static/js/dashboard.js"></script>
-->
<script src="../static/js/custom.js"></script>
<script src="../static/js/patch/shop_data.js"></script>
<script src="../static/js/patch/shop.js"></script>

</body>
</html>

