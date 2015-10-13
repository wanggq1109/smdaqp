<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

    <title>宝龙CRM系统</title>
    <link href="../static/css/style.default.css" rel="stylesheet">
    <link href="../static/css/stylepatch.css" rel="stylesheet">
    <link href="../static/css/jquery.datatables.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../static/js/html5shiv.js"></script>
    <script src="../static/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>
<div class="leftpanel">

    <div class="logopanel" style="height: 70px;padding: 15px;">
        <h1  style="font-size: 36px; margin-top: 6px;">CRM <span>S+</span></h1>
    </div><!-- logopanel -->

    <div class="leftpanelinner">

        <!-- This is only visible to small devices -->
        <!-- Small Device section
        <div class="visible-xs hidden-sm hidden-md hidden-lg">   
            <div class="media userlogged">
                <img alt="" src="images/photos/loggeduser.png" class="media-object">
                <div class="media-body">
                    <h4>John Doe</h4>
                    <span>"Life is so..."</span>
                </div>
            </div>
          
            <h5 class="sidebartitle actitle">Account</h5>
            <ul class="nav nav-pills nav-stacked nav-bracket mb30">
              <li><a href="profile.html"><i class="fa fa-user"></i> <span>Profile</span></a></li>
              <li><a href=""><i class="fa fa-cog"></i> <span>Account Settings</span></a></li>
              <li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
              <li><a href="signout.html"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
            </ul>
        </div> <!--small device-->
        <h5 class="sidebartitle">会员管理系统</h5>
        <ul class="nav nav-pills nav-stacked nav-bracket">
        <li >
              <a class="item-index" id="item-0" href="/smdaqp/splus/infos.do"><i class="fa fa-desktop"></i> <span>实时动态</span></a></li>
          <li >
          <li >
              <a class="item-index" id="item-0" href="/smdaqp/splus/index.do"><i class="fa fa-yen"></i> <span>收银机</span></a></li>
          <li >
              <a href="/smdaqp/ibea/Ibeacon.do"><i class="fa fa-bullseye"></i> <span>定位</span></a>
          </li>
          
          <li>
              <a href="/smdaqp/splus/parking.do"><i class="fa fa-arrow-circle-up"></i> <span>停车场</span></a>
          </li>
         <!--  <li >
              <a href="/smdaqp/splus/passenger.do"><i class="fa fa-users"></i> <span>客流</span></a>
          </li> -->
          <li >
              <a href="/smdaqp/data/dataReport.do"><i class="glyphicon glyphicon-eye-open"></i> <span>导视屏</span></a>
          </li>
          <li  class="active in-use">
              <a href="/smdaqp/splus/wifi.do"><i class="glyphicon  glyphicon-signal"></i> <span>Wifi</span></a>
          </li>
          <li >
              <a href="/smdaqp/User/userinfo.do"><i class="glyphicon glyphicon-user"></i> <span>会员</span></a>
          </li>
          <li >
              <a href="/smdaqp/smdaqpController/shop.do?merchantId=0012"><i class="fa fa-shopping-cart"></i> <span>实验室商户</span></a>
          </li>
          <li>
              <a href="/smdaqp/smdaqpController/mall.do?mallId=1"><i class="fa fa-table"></i> <span>商场运营概况</span></a>
          </li>
          
        </ul>
    </div><!-- leftpanelinner -->
</div><!-- leftpanel -->

<div class="mainpanel">

    <div class="headerbar clearfix">
        <!--
    <a class="menutoggle"><i class="fa fa-bars"></i></a>
        <div class="header-right">
          <ul class="headermenu">

            <li>
              <div class="btn-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                  <img src="images/photos/loggeduser.png" alt="" />
                 窦文涛
                  <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                  <li><a href="#"><i class="glyphicon glyphicon-cog"></i>账户设置</a></li>
                  <li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> 系统帮助</a></li>
                  <li><a href="signin.html"><i class="glyphicon glyphicon-log-out"></i>退出</a></li>
                </ul>
              </div>
            </li>

          </ul>
        </div>
      -->
    </div><!-- headerbar -->

    <div class="pageheader">


    </div>

</div>
<!-- mainpanel -->

<!-- rightpanel -->


</section>
<!--modal #page form modal-->
<div class="modal fade" id="page-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="ajax-loader" id="modal-ajax-loader"><img src="../static/images/loaders/loader10.gif" alt=""></div>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">请选择商户</h4>
            </div>
            <div class="modal-body">
                <div class="list-group">
                    <c:forEach items="${shopMap}" var="shop">
                        <a href="#" class="list-group-item active">${shop.value}</a>
                    </c:forEach>
                </div>
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

ChainedForeignKey
<script src="../static/js/jquery-1.10.2.min.js"></script>
<script src="../static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/modernizr.min.js"></script>

<script src="../static/js/toggles.min.js"></script>
<script src="../static/js/retina.min.js"></script>
<script src="../static/js/jquery.cookies.js"></script>
<script src="../static/js/custom.js"></script>

<script>
    $("#page-modal .list-group a").on('click',function(e){
        e.preventDefault();
        var $this=$(this);
        var selected_shop=$this.text();
        console.log(selected_shop);

        $this.closest(".list-group").children("a").removeClass("active");
        $this.addClass("active");
        $("#shop-select").val(selected_shop);
        $("#page-modal").modal('hide');

    });
    $("#brand-select-ul a").on("click",function(e){
        e.preventDefault();
        var selected_brand=$(this).text();
        $("#brand-select").val(selected_brand);
    });
</script>

<div class="row" id="iframe-show" style="position: absolute;top:0;left:0">
<div class=col-sm-12>
<div class="pageheader">
        <h2><i class="glyphicon  glyphicon-signal" style="padding: 4.5px 5.5px;"></i>WIFI</h2>
        <div class="breadcrumb-wrapper">
            <span class="label">当前系统:</span>
            <ol class="breadcrumb">
                <li><a href="/smdaqp/splus/index.do">CRM S+</a></li>
                <li class="active">WIFI</li>
            </ol>
        </div>
    </div>
</div>

    <div class="col-sm-12">
        <iframe src="http://192.168.120.242:8080/TDBI/" style="width:100%;height:800px;"></iframe>
    </div>
</div>
<script>
    $(document).ready(function(){
       var width=$("body").css("width");
        var height=$("body").css("height");
        $("#iframe-show").css({"width":width,"height":height,"background-color":"#f7f7f7","opacity":0.8});
    });
</script>

</body>
</html>

