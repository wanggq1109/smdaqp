<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link rel="stylesheet" href="../static/css/bootstrap-datetimepicker.css">

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
          <li  class="active in-use">
              <a class="item-index" id="item-0" href="/smdaqp/splus/index.do"><i class="fa fa-yen"></i> <span>收银机</span></a></li>
          <li >
              <a href="/smdaqp/ibea/Ibeacon.do"><i class="fa fa-bullseye"></i> <span>定位</span></a>
          </li>
         
          <li>
              <a href="/smdaqp/splus/parking.do"><i class="fa fa-arrow-circle-up"></i> <span>停车场</span></a>
          </li>
       <!--    <li >
              <a href="/smdaqp/splus/passenger.do"><i class="fa fa-users"></i> <span>客流</span></a>
          </li> -->
          <li >
              <a href="/smdaqp/data/dataReport.do"><i class="glyphicon glyphicon-eye-open"></i> <span>导视屏</span></a>
          </li>
           <li >
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
	    <h2><i class="fa fa-yen" style="padding: 4.5px 5.5px;" ></i>收银机</h2>
	    <div class="breadcrumb-wrapper">
	        <span class="label">当前系统:</span>
	        <ol class="breadcrumb">
	            <li><a <%--href="index_pl_shops.html"--%>>CRM S+</a></li>
	            <li class="active">收银机</li>
	        </ol>
	    </div>
    </div>

	<form action="/smdaqp/splus/index.do" method="post">
      <div class="contentpanel">
          <div class="row">
              <div class="col-md-12">
                  <div class="panel panel-default">
                      <div class="panel-heading">

                          <form class="form-horizontal clearfix" role="form">
                            <div class="row">
                                <div class="form-group col-sm-3 col-md-3">
                                    <label for="mall-select" class="col-sm-4 control-label">商户</label>
                                    <div class="col-sm-8">
                                        <select class="form-control" id="mall-select" name="merchantname">
                                            <option value="">全部</option>
                                            <option value="实验商户" <c:if test="${dataBoxIndexVo.merchantname=='实验商户' }">selected='selected'</c:if>>实验商户 </option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group col-sm-6 col-md-6">
                                    <label class="col-sm-2 control-label " for="sum-start">时间</label>
                                    <div class="col-sm-4">
                                        <div class="input-group">
                                            <input type="text" class="form-control hasDatepicker"
                                            	id="datepicker-start" name="startTimeStr" data-provide="datepicker" 
                                            		data-date-format="yyyy-mm-dd hh:ii:ss" value="${dataBoxIndexVo.startTimeStr }">
                                          <!--  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
                                        </div>
                                    </div>
                                    <div class="col-sm-1" style="padding: 0;width: 12px;margin-top:6px;">
                                        --
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="input-group">
                                            <input type="text" class="form-control hasDatepicker"
                                            	id="datepicker-end" name="endTimeStr" data-provide="datepicker" 
                                            		data-date-format="yyyy-mm-dd hh:ii:ss" value="${dataBoxIndexVo.endTimeStr }">
                                        <!--    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> -->
                                        </div>
                                    </div>
                                </div>

                            </div>
                            
                            
                             <div class="row">
                                 <div class="form-group col-sm-3 col-md-3">
                                     <label for="user-search" class="col-sm-4 control-label">用户</label>
                                     <div class="col-sm-8">
                                         <input type="text" class="form-control" placeholder="消费者姓名或手机" name="consumer" id="user-search" value=${dataBoxIndexVo.consumer }>
                                     </div>
                                 </div>
                                 <div class="form-group col-sm-6 col-md-6">
                                     <label class="col-sm-2 control-label " for="sum-start">金额</label>
                                     <div class="col-sm-4">
                                         <input  onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" class="form-control col-sm-8" 
                                         id="sum-start"  name="minAmount" placeholder="请输入" value="${dataBoxIndexVo.minAmount }">
                                     </div>
                                     <div class="col-sm-1" style="padding: 0;width: 12px;margin-top: 6px;">
                                         --
                                     </div>
                                     <div class="col-sm-4">
                                         <input onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" class="form-control col-sm-8" 
                                         id="sum-end" name="maxAmount" placeholder="请输入" value="${dataBoxIndexVo.maxAmount }">
                                     </div>
                                 </div>

                                 <div class="col-sm-3  col-md-2">
                                     <button type="submit" class="btn btn-primary col-sm-12" style="">查询</button>
                                 </div>
                             </div>


                          </form>
                      </div>
                      <div class="panel-body">

                          <div class="col-md-12">
                              <h3 class="subtitle mt10 col-sm-3">POS数据列表</h3>
                          </div><!--col-md-12-->

                          <div class="table-responsive">
                              <table class="table mb30">
                                  <colgroup>
	                                  <col width="5%">
	                                  <col width="15%">
	                                  <col width="10%">
	                                  <col width="15%">
	                                  <col width="10%">
	                                  <col width="15%">
	                                  <col width="10%">
	                                  <col width="5%" align="center">
	                              </colgroup><thead>
                              <tr>
                                  <th>NO</th>
                                  <th>商户</th>
                                  <th>姓名</th>
                                  <th>手机号</th>
                                  <!-- <th>会员卡号</th> -->
                                  <th>消费金额</th>
                                  <th>消费时间</th>
                                  <th>会员级别</th>
                                  <th align="center">详情</th>
                              	</tr>
                              </thead>
                                  <tbody>
                                  <c:forEach items="${paginator.results}" var="resutl" varStatus="index">
                              		<tr>
	                                  <td>${index.index +1}</td>
	                                  <td><a href="/smdaqp/smdaqpController/shop.do?merchantId=${resutl.merchantid}">${resutl.merchantname}</a></td>
	                                  <td>${resutl.userName}</td>
	                                  <td><a href="/smdaqp/smdaqpController/userInfo.do?mobile=${resutl.mobile}">${resutl.mobile}</a></td>
	                                  <%-- <td>${resutl.memberNo}</td> --%>
	                                  <td>${resutl.totalamount}</td>
	                                  <td>${resutl.tsdateStr}</td>
	                                  <td>vip${resutl.mlevel}</td>
	                                  <td class="table-action" >
	                                  	<a href="" data-toggle="modal" data-target="#myModal_${index.index +1}_imgageurl"><i class="fa fa-pencil"></i></a>
	                                  </td>
	                                  
	                                  <div class="modal fade" id="myModal_${index.index +1}_imgageurl">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
									                <h4 class="modal-title" id="myModalLabel">客户消费详情</h4>
									            </div>
									            <div class="modal-body">
									               <div class="row">
									                   <div class="col-sm-10 col-sm-offset-1">
									                       <img src="http://10.254.1.57:8081/databox/${resutl.imageurl }" alt="消费小票"/>
									                   </div>
									               </div>
									            </div>
									            <div class="modal-footer">
									                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									            </div>
									        </div>
									     </div>
										</div>
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
                                                      <li><a href="/smdaqp/splus/index.do?page=${paginator.page - 1}"><i class="fa fa-angle-left"></i></a></li>
                                                  </c:if>
                                              </c:if>
                                              <c:if test="${paginator.page == index.index + 1}" >
                                                  <li class="active"><a href="/smdaqp/splus/index.do?page=${paginator.page}">${index.index +1}</a></li>
                                              </c:if>
                                              <c:if test="${paginator.page != index.index +1}" >
                                                  <li><a href="/smdaqp/splus/index.do?page=${index.index+1}">${index.index +1}</a></li>
                                              </c:if>
                                              <c:if test="${(index.index +1) > (paginator.items/paginator.itemsPerPage)}" >
                                                  <c:if test="${(paginator.items/paginator.itemsPerPage) <= 1 || paginator.page >= (paginator.items/paginator.itemsPerPage) }" >
                                                      <li class="disabled"><a><i class="fa fa-angle-right"></i></a></li>
                                                  </c:if>
                                                  <c:if test="${paginator.page < (paginator.items/paginator.itemsPerPage)}" >
                                                      <li><a href="/smdaqp/splus/index.do?page=${paginator.page + 1}"><i class="fa fa-angle-right"></i></a></li>
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
    </form>
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
<script src="../static/js/bootstrap-datetimepicker.min.js"></script>
<script src="../static/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="../static/js/modernizr.min.js"></script>

<script src="../static/js/toggles.min.js"></script>
<script src="../static/js/retina.min.js"></script>
<script src="../static/js/jquery.cookies.js"></script>
<script src="../static/js/custom.js"></script>

<script>
	$(function(){
		$("#datepicker-start").datetimepicker({
			language:  'zh-CN',
			format: 'yyyy-mm-dd hh:ii:ss'
		});
		$("#datepicker-end").datetimepicker({
			language:  'zh-CN',
			format: 'yyyy-mm-dd hh:ii:ss'
		});
	});

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

</body>
</html>
