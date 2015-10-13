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
<input id="mobile" name="mobile" type="hidden" value="${databoxUser.mobile}" >
<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

<div class="mainpanel" >

    <div class="pageheader ">
        <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
        <a href="http://10.254.1.57:8081/smdaqp/splus/index.do"><h2 id="mall-title"></h2></a>
        <div class="breadcrumb-wrapper">
            <span class="label">当前系统:</span>
            <ol class="breadcrumb">
                <li><a href="http://10.254.1.57:8081/smdaqp/splus/index.do">CRM S+</a></li>
                <li class="active"></li>
            </ol>
        </div>
    </div>

    <div class="contentpanel">
        <div class="row user">
            <div class="col-sm-1 user-photo">
                <img class="pull-right" src="../static/images/patch/m.png"/>
            </div>
            <div class="col-sm-3">
                <div class="row">
                    <p><span id="user-name">${databoxUser.userName}</span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star-empty user-level" ></span>
                        <span class="glyphicon glyphicon-star-empty user-level"></span>
                    </p>
                    <p><span>${toMonth}</span></p>
                </div>
                <div class="row user-group">
                    <span>${databoxUser.sex=='1'?'男':'女'}</span><span>汉族</span><span>${userAge}岁</span>
                </div>
                <div class="row user-location">
                    <span class="glyphicon glyphicon-map-marker"></span>
                    <span>${databoxUser.address}</span>
                </div>
            </div>
            <div class="col-sm-2">
                <div  class="user-more" id="user-activity">
                    <h3>总消费额</h3>
                    <p>
                        <span>${dataBoxCountVo.dataTotal}</span>
                    </p>
                </div>
            </div>

        </div> <!--end -row-->
        <div class="row">

            <div class="col-sm-12 user-info-panel">
                <!--row-->
                <div class="row user-info">
                    <div class="user-info-title">
                        <span>基本信息</span>
                    </div>
                </div>
                <!--end row-->
                <div class="row user-info-detail">
                    <div class="col-sm-6">
                        <p class="bg-light"><span>地址</span>${databoxUser.address}</p>
                    </div>
                    <div class="col-sm-6">
                        <p class="bg-light"><span>车</span>${parkingNo}</p>
                    </div>
                </div>
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->


        <div class="row">

            <div class="col-sm-8 user-info-panel" >
                <!--row-->
                <div class="row user-info">
                    <div class="user-info-title">
                        <span>PET个性标签</span>
                    </div>
                </div>
                <!--end row-->
                <div class="row pet">
                    <div class="use-rage-label pet-info" id="pet-info-1">
                        <dl>
                            <dt><span></span>消费习惯</dt>
                            <dd>热衷熟悉的著名品牌</dd>
                        </dl>
                    </div>
                    <div class="use-rage-label pet-info " id="pet-info-2">
                        <dl>
                            <dt><span></span>偏好商家</dt>
                            <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                <dd>${dataBoxItemTypeDataVo.merchantname}</dd>
                            </c:forEach>
                            <dt><span></span>偏好类型</dt>
                            <dd>
                                <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                    ${dataBoxItemTypeDataVo.itemTypeName}
                                </c:forEach>
                            </dd>
                        </dl>
                    </div>
                    <div class="use-rage-label pet-info" id="pet-info-3">
                        <dl>
                            <dt><span></span>来场时间</dt>
                            <dd>假期或者周末</dd>
                            <dd class="dd-note">平均逗留时间${avgTimeUser}分钟</dd>
                            <!--<dd class="dd-note">累计场外访问时间18小时</dd>-->
                        </dl>
                    </div>
                </div>
            </div><!--end panel-->

            <div class="col-sm-4 user-info-panel index-user-panel" >
                <!--row-->
                <div class="row user-info">
                    <div class="user-info-title">
                        <span>消费构成</span>
                    </div>

                </div>
                <div class="use-rage use-rage-index">
                    <canvas id="use-rage-search" width="220" height="220">
                    </canvas>
                    <div class="use-rage-label label-4" id="label-1-4">
                        <dl>
                            <dt> <span></span>餐饮</dt>
                            <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                <c:if test="${dataBoxItemTypeDataVo.itemTypeName=='餐饮'}">
                                    <dd>${dataBoxItemTypeDataVo.merchantname}</dd>
                                </c:if>
                            </c:forEach>
                        </dl>

                    </div>
                    <div class="use-rage-label label-1" id="label-1-1">
                        <dl>
                            <dt> <span></span>娱乐</dt>
                            <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                <c:if test="${dataBoxItemTypeDataVo.itemTypeName=='娱乐'}">
                                    <dd>${dataBoxItemTypeDataVo.merchantname}</dd>
                                </c:if>
                            </c:forEach>
                        </dl>

                    </div>
                    <div class="use-rage-label label-3" id="label-1-3">
                        <dl>
                            <dt> <span></span>电玩</dt>
                            <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                <c:if test="${dataBoxItemTypeDataVo.itemTypeName=='电玩'}">
                                    <dd>${dataBoxItemTypeDataVo.merchantname}</dd>
                                </c:if>
                            </c:forEach>
                        </dl>

                    </div>
                    <div class="use-rage-label label-2" id="label-1-2">
                        <dl>
                            <dt><span></span>服饰</dt>
                            <c:forEach var="dataBoxItemTypeDataVo" items="${dataBoxItemTypeDataVos}">
                                <c:if test="${dataBoxItemTypeDataVo.itemTypeName=='服饰'}">
                                    <dd>${dataBoxItemTypeDataVo.merchantname}</dd>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </div>
                </div>
                <!--end row-->
            </div><!--end panel-->

            <br>
            <br>
            <br>
            <br>
        </div> <!--end -row-->


        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" >
                <!--POS-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>POS</span>
                    </div>
                    <div class="col-sm-10  cur-data-content" id="today-data">
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-2 customer-status">
                                <span class="count"><em style="border-bottom:solid ${dataBoxCountVo.dataCount}px #31cd73;"><i data-height="20">${dataBoxCountVo.dataCount}</i>次</em></span>
                                <span class="name" style="">消费次数</span>
                            </div>
                            <div class="col-sm-4 customer-status">
                                <span class="count"><em style="border-bottom:solid 20px #1ABC9C;"><i data-height="20">${dataBoxCountVo.dataTotal}</i></em></span>
                                <span class="name" style="">消费金额</span>
                            </div>

                        </div><!--end row-->
                    </div>
                </div><!--end row 消费总人数 -->
            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
                <!--row-->
                <div class="row">
                    <div class="col-sm-8">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div id="user-cost-flot" style="width: 100%; height:238px; "></div>
                              </div>
                        </div>
                        <div class="h-line">  </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="col-sm-12 cur-data-content count-rage">
                            <div class="col-sm-6">
                                <canvas id="user-cost-search" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                </canvas>
                            </div>
                            <div class="col-sm-4 col-sm-offset-2 sales-info user-cost-info">
                                <h3>业态消费 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>

                            </div>

                        </div><!--end cur-data-content-->

                    </div>
                </div>
                <!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" style=" min-height: 320px;">

                <!--WIFI-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>WIFI</span>
                    </div>
                    <div class="col-sm-12  cur-data-content">
                    <c:forEach var="wifiMaxGust" items="${wifiMaxGusts}" >
                        <div class="row app-info">
                            <div class="col-sm-3 app-info-title">${wifiMaxGust.floor}楼</div>
                            <div class="col-sm-7">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${(wifiMaxGust.residenceTime/countTime)*100}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                                </div>
                            </div>
                            <div class="col-sm-2 app-info-count">
                                    ${wifiMaxGust.residenceTime}分钟
                            </div>
                        </div><!--end row-->
                    </c:forEach>

                    </div>
                </div><!--end row WIFI -->
            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel" >
                <!--row-->

                <div class="row cur-stop-data">
                    <div class="col-sm-6">

                    </div>
                    <div class="col-sm-6">
                        <div class="lable-info pull-right">
                            <span id="wifi"><a href="#" data-toggle="modal" data-target="#wifi-modal">更多...</a></span>
                        </div>
                    </div>
                </div> <!--end row -->
                <div class="row">
                    <div class="col  col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div id="wifi-stack-flot" style="width: 100%; height:238px; "></div>
                            </div>
                        </div><!--panel -->
                    </div>
                </div>
                <!--end row-->

            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel">
                <!--停车场-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>停车场</span>
                    </div>
                    <div class="col-sm-10  cur-data-content">
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4 customer-status parking">
                                <span class="count"><em style="border-bottom:solid 65px #31cd73;"><i data-height="20">${parkingTimecount}</i>分钟</em></span>
                                 <span class="name" style="">当月停车时间</span>
                            </div>

                        </div><!--end row-->
                    </div>

                </div><!--end row 停车场 -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
                <!--row-->
                <div class="row">
                    <div class="col-sm-4">
                        <div class="row cur-data-content count-rage">
                            <div class="col-sm-5">
                                <canvas id="parking-pay" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                </canvas>
                            </div>
                            <div class="col-sm-4 col-sm-offset-3 sales-info user-cost-info">
                                <h3>付费方式 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </div>

                        <div class="h-line">  </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="col-sm-12 cur-data-content count-rage">
                            <div class="col-sm-4" style="text-align: center">
                                <canvas id="in-search" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                </canvas>
                                <div style="text-align: center">入口</div>
                            </div>
                            <div class="col-sm-4" style="text-align: center">
                                <canvas id="out-search" width="160" height="160" style="width: 160px; height: 160px;margin-top: 12px;">
                                </canvas>
                                <div style="text-align: center">出口</div>
                            </div>
                            <div class="col-sm-3 col-sm-offset-1 sales-info user-cost-info">
                                <h3>出入口 <!--<span class="glyphicon glyphicon-arrow-up"></span>--></h3>
                                <c:forEach var="parkingDetailEnter" items="${parkingDetailsEnter}" >
                                     <span>${parkingDetailEnter.entryPlace}（${parkingDetailEnter.id}）<em class="em-red"></em></span>
                                </c:forEach>
                                <c:forEach var="parkingDetailLeave" items="${parkingDetailsLeave}" >
                                    <span>${parkingDetailLeave.leavePlace}（${parkingDetailLeave.id}）<em class="em-red"></em></span>
                                </c:forEach>

                            </div>

                        </div><!--end cur-data-content-->

                    </div>
                </div>
                <!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel">
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>入店统计</span>
                    </div>
                </div>

                <div class="row enter-tags">
                    <c:forEach var="trafficShop" items="${trafficShops}">
                        <div class="col-sm-4">
                            <span class="enter-tag">${trafficShop.shopName}</span>
                        </div>
                    </c:forEach>
                </div>

            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
                <!--row-->
                <div class="row" style="padding-top: 30px;">
                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-body">

                                <div id="shop-enter-flot" style="width: 100%; height:238px; "></div>
                            </div>
                        </div><!--panel -->
                    </div>
                    <div class="col col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">

                                <div id="shop-leave-flot" style="width: 100%; height:238px; "></div>
                            </div>
                        </div><!--panel -->
                    </div>
                </div>

                <!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel" style=" min-height: 320px;">

                <!--导视-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>导视统计</span>
                    </div>

                </div><!--end row WIFI -->
            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel" >
                <!--row-->
                <div class="row cur-stop-data">
                    <div class="col-sm-6">
                    </div>
                    <div class="col-sm-6">
                        <div class="lable-info pull-right">
                            <c:forEach var="screenvideo" items="${screenvideos}">
                                <span id="adv-stack">${screenvideo.content}</span>
                            </c:forEach>
                            <!-- <span id="product-stack">商品</span>
                                 <span id="adv-stack">广告</span>
                            <span id="other-stack">其他</span>  -->
                        </div>
                    </div>
                </div> <!--end row -->
                <div class="row">
                    <div class="col  col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div id="adv-stack-flot" style="width: 100%; height:238px; "></div>
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
<!--modal #page form modal-->
<div class="modal fade" id="wifi-modal">
    <div class="modal-dialog">
        <div class="modal-content">
          <!--  <div class="ajax-loader" id="modal-ajax-loader"><img src="images/loaders/loader10.gif" alt=""></div>-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">各商户 WIFI 使用情况</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>店铺名称</th>
                        <th>WIFI使用时长</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="wifiMaxGustShop" items="${wifiMaxGustsShop}" varStatus="status" >
                        <tr>
                            <th scope="row">${ status.index + 1}</th>
                            <td>${wifiMaxGustShop.shopName}</td>
                            <td>${wifiMaxGustShop.residenceTime}分钟</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <!--
                <button type="button" class="btn btn-primary">保存</button> -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--modal #page form modal-->
<!--modal #alert modal-->


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
<script src="../static/js/custom.js"></script>
<script src="../static/js/dashboard.js"></script>
-->
<script src="../static/js/custom.js"></script>
<script src="../static/js/patch/user_data.js"></script>
<script src="../static/js/patch/user_info.js"></script>

</body>
</html>

