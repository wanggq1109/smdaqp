<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<>
  
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
              <a class="item-index" id="item-0" href="/smdaqp/splus/index.do"><i class="fa fa-yen"></i> <span>收银机</span></a>
          </li>
          <li>
              <a href="/smdaqp/ibea/Ibeacon.do"><i class="fa fa-bullseye"></i> <span>定位</span></a>
          </li>
         
          <li>
              <a href="/smdaqp/splus/parking.do"><i class="fa fa-arrow-circle-up"></i> <span>停车场</span></a>
          </li>
<!--           <li >
              <a href="/smdaqp/splus/passenger.do"><i class="fa fa-users"></i> <span>客流</span></a>
          </li> -->
          <li >
              <a href="/smdaqp/data/dataReport.do"><i class="glyphicon glyphicon-eye-open"></i> <span>导视屏</span></a>
          </li>
           <li >
              <a href="/smdaqp/splus/wifi.do"><i class="glyphicon  glyphicon-signal"></i> <span>Wifi</span></a>
          </li>
          
          <li  class="active in-use">
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
    </div><!-- headerbar -->
    
    <div class="pageheader">
            <h2><i class="glyphicon glyphicon-user" style="padding: 4.5px 5.5px;" ></i>会员</h2>
            <div class="breadcrumb-wrapper">
                <span class="label">当前系统:</span>
                <ol class="breadcrumb">
                    <li><a <%--href="index_pl_shops.html"--%>>CRM S+</a></li>
                    <li class="active">会员</li>
                </ol>
            </div>
    </div>
    <form action="/smdaqp/User/userinfo.do" method="post">
      <div class="contentpanel">
          <div class="row">
              <div class="col-md-12">
                  <div class="panel panel-default">
                      <div class="panel-heading">
                          <%--<form class="form-horizontal clearfix" role="form">
							
                              <div class="form-group col-sm-3 col-md-3">
                                  <label for="mall-select" class="col-sm-4 control-label">Ibea设备号：</label>
                                  <div class="col-sm-8">
                                      <input type="text" class="form-control" id="shop-select" name="merchantname" placeholder="请选择商户" data-toggle="modal" data-target="#page-modal">
                                  </div>
                              </div>

                              <div class="form-group col-sm-3 col-md-3">
                                  <label for="shop-select" class="col-sm-4 control-label">手机号：</label>
                                  <div class="col-sm-8">
                                          <input type="text" class="form-control" id="shop-select" name="merchantname" placeholder="请选择商户" data-toggle="modal" data-target="#page-modal">
                                  </div>
                              </div>
                       	
                         </form>--%>
                         <input type="hidden" id="area" name="area"/>
                         <table>                          	
	                         <tr>
	                         	<%--<td>商场：</td><td><input type="text" id="mallId" name="mallId"/></td>
	                        	<td>&nbsp;</td>--%>
	                         	<td>会员：</td><td><input type="text" id="info" name="info" /></td>
	                         	<td>&nbsp;</td>
	                         	<td>&nbsp;&nbsp;车牌号：</td><td><input type="text" id="carnumber" name="carnumber"/></td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td><button type="submit" class="btn btn-primary col-sm-12">查询</button></td>
	                         </tr>
	                         <!--  <tr>	                         	
	                         	<td>注册时间：</td><td><input type="text" id="startTime" name="startTime"/></td>
	                         	<td>&nbsp;</td>
	                         	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;—&nbsp;&nbsp;</td>
	                         	<td><input type="text" id="endTime" name="endTime"/></td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td>&nbsp;&nbsp;</td>
	                         	<td><button type="submit" class="btn btn-primary col-sm-12">查询</button></td>
	                         </tr>-->
                         </table>
                      </div>
                      <div class="panel-body">
                          <div class="table-responsive">
                              <table class="table mb30">
                                  <colgroup>
                                  	  <col width="10%">
                                      <col width="5%">
                                      <col width="20%">
                                      <col width="20%">
                                      <col width="15%">
                                      <col width="10%">
                                      <col width="20%">
                                  </colgroup><thead>
                              <tr>      
                              	   <!-- <th style="text-align:center;">手机号</th> -->                            
                                  <th>姓名</th>
                                  <th>性别</th>
                                  <th>手机号</th>
                                  <th>车牌号</th>
                                  <th>注册时间</th>
                                  <th>注册来源</th>
                                  <th>商场贡献度</th>
                              </tr>
                              </thead>
                                  <tbody>
                                   <c:forEach items="${paginator.results}" var="resutl" varStatus="index">
		                          	      <tr>
		                          	     	  <td>${resutl.userName}</td>
		                          	     	  <c:if test="${resutl.sex=='1'}"><td>男</td></c:if>		                          	     	  
		                          	     	  <c:if test="${resutl.sex=='0'}"><td>女</td></c:if>		                          	     	  
		                          	     	  <td><a href="/smdaqp/smdaqpController/userInfo.do?mobile=${resutl.mobile}">${resutl.mobile}</a></td>
		                          	     	  <td>${resutl.plateNo}</td>
		                                      <td><fmt:formatDate value="${resutl.createdDate}" pattern="MM-dd HH:mm:ss" /></td>
		                                      <td>ios</td>
		                                      <td>${resutl.id}</td>
		                                  </tr>
                                    </c:forEach>
                                  </tbody>
                              </table>

                              <div class="col-sm-12 center-align">
                                  <ul class="pagination nomargin">
                                      <c:forEach items="${paginator.results}" var="resutl" varStatus="index">
                                          <c:if test="${ index.index<= (paginator.items/paginator.itemsPerPage) }" >
                                              <c:if test="${index.index == 0}" >
                                                  <c:if test="${paginator.page == 1}" >
                                                      <li class="disabled"><a><i class="fa fa-angle-left"></i></a></li>
                                                  </c:if>
                                                  <c:if test="${paginator.page != 1}" >
                                                      <li><a href="/smdaqp/User/userinfo.do?page=${paginator.page - 1}"><i class="fa fa-angle-left"></i></a></li>
                                                  </c:if>
                                              </c:if>
                                              <c:if test="${paginator.page == index.index + 1}" >
                                                  <li class="active"><a href="/smdaqp/User/userinfo.do?page=${paginator.page}">${index.index +1}</a></li>
                                              </c:if>
                                              <c:if test="${paginator.page != index.index +1}" >
                                                  <li><a href="/smdaqp/User/userinfo.do?page=${index.index+1}">${index.index +1}</a></li>
                                              </c:if>
                                              <c:if test="${(index.index +1) > (paginator.items/paginator.itemsPerPage)}" >
                                                  <c:if test="${(paginator.items/paginator.itemsPerPage) <= 1 || paginator.page >= (paginator.items/paginator.itemsPerPage) }" >
                                                      <li class="disabled"><a><i class="fa fa-angle-right"></i></a></li>
                                                  </c:if>
                                                  <c:if test="${paginator.page < (paginator.items/paginator.itemsPerPage)}" >
                                                      <li><a href="/smdaqp/User/userinfo.do?page=${paginator.page + 1}"><i class="fa fa-angle-right"></i></a></li>
                                                  </c:if>
                                              </c:if>
                                          </c:if>
                                      </c:forEach>
                                  </ul>
                              </div><!-- pager -->

                          </div><!-- table-responsive -->

                      </div><!-- panel-body -->
                  </div><!-- panel -->
              </div>
          </div>

      </div>
    </form>
  </div>
    <!-- mainpanel -->

  <!-- rightpanel -->
  
  
</section>

<script src="../static/js/jquery-1.10.2.min.js"></script>
<script src="../static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/modernizr.min.js"></script>

<script src="../static/js/toggles.min.js"></script>
<script src="../static/js/retina.min.js"></script>
<script src="../static/js/jquery.cookies.js"></script>
<script src="../static/js/custom.js"></script>

</body>
</html>

