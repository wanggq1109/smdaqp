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

  <title>LIST</title>

  <link href="../static/css/style.default(3).css" rel="stylesheet">
  <link href="../static/css/jquery.datatables(3).css" rel="stylesheet">

  <link href="../static/css/patch/patch(3).css" rel="stylesheet">
  <style>
  	.tooltip{min-width:120px; overflow:hidden;}
  </style>
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body id="main-page" class="main-page">

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
                <!--今日数据
                <div class="row" id="cur-data-title">
                    <div class="col-sm-6  cur-data-date">
                        <p>今日数据</p>
                        <span>2015-04-10</span>
                    </div>
                    <div class="col-sm-5">
                        <h2 id="cur-timing">17:30</h2>
                    </div>
                </div>--><!--end row 今日数据 -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel" >

            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel all-rage-left" >
                <!--今日数据-->
                <div class="row" id="all-data-title">
                    <div class="col-sm-6  cur-data-date">
                        <p>今日数据</p>
                        <span>${date}</span>
                    </div>
                    <div class="col-sm-5">
                        <h2 id="cur-timing">${time}</h2>
                    </div>
                </div><!--end row 今日数据 -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
                <!--row-->
                    <div class="col-sm-12  cur-data-content" id="today-data">
                        <div class="row">
                            <div class="col-sm-3 customer-status customer-status-all">
                                <span class="count"><em style="border-bottom:solid ${Guanggao.cnt}px #f9243f;"><i data-height="20">${Guanggao.cnt}</i>K</em></span>
                                <span class="name" style="">广告</span>
                            </div>
                            <div class="col-sm-3 customer-status customer-status-all">
                                <span class="count" ><em style="border-bottom:solid ${PinPai.cnt}px #ffb53e;"><i data-height="76">${PinPai.cnt}</i>K</em></span>
                                <span class="name" style="">品牌</span>
                            </div>
                            <div class="col-sm-3 customer-status customer-status-all">
                                <span class="count" ><em style="border-bottom:solid ${HuoDong.cnt}px #1ebfae;"><i data-height="68">${HuoDong.cnt}</i>K</em></span>
                                <span class="name" style="">活动</span>
                            </div>
                            <div class="col-sm-3 customer-status customer-status-all">
                                <span class="count" ><em style="border-bottom:solid ${DiTu.cnt}px #30a5ff;"><i data-height="40">${DiTu.cnt}</i>K</em></span>
                                <span class="name" style="">地图</span>
                            </div>
                        </div><!--end row-->
                    </div>

                <!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel ad-rage-left">
                <!--广告情况-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>广告情况</span>
                    </div>
                    <div class="col-sm-12  cur-data-content">
                       <div class="row ad-info">
                           <div class="col-sm-1 ad-info-title">日</div>
                           <div class="col-sm-9">
                               <div class="progress progress-mall-info">
                                   <div style="width: ${Guanggao.daycnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success ad-bar-success"></div>
                               </div>
                           </div>
                           <div calss="col-sm-2 ad-info-count">${Guanggao.daycnt}K</div>
                       </div><!--end row-->
                        <div class="row ad-info">
                            <div class="col-sm-1 ad-info-title">月</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${Guanggao.weekcnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success ad-bar-success"></div>
                                </div>
                            </div>
                            <div calss="col-sm-2 brand-info-count">${Guanggao.weekcnt}K</div>
                        </div><!--end row-->
                        <div class="row ad-info">
                            <div class="col-sm-1 ad-info-title">年</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${Guanggao.cnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success ad-bar-success"></div>
                                </div>
                            </div>
                            <div calss="col-sm-2 ad-info-count">${Guanggao.cnt}K</div>
                        </div><!--end row-->
                    </div><!--end cur-data-content-->

                </div><!--end row -->
                
                
            </div><!--end inner-left-panel-->
            
            
            
            <div class="col-sm-9 col-md-9 inner-right-panel" >          
            	<div class="row">
            		<c:forEach var="guanggaoitem" items="${GuanggaoList}" >
            			<div class="col-sm-1 customer-status customer-status-t">
                    		<span class="count"><em style="border-bottom:solid ${guanggaoitem.cnt}px #f26c57;"><i data-height="120">${guanggaoitem.cnt}</i>K</em></span>
                        	<c:choose>
                        	<c:when  test="${fn:length(guanggaoitem.content)>5}">  
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${guanggaoitem.content}">${fn:substring(guanggaoitem.content,0,5)}...</span>
    						</c:when> 
    						<c:otherwise>
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${guanggaoitem.content}">${guanggaoitem.content}</span>
    						</c:otherwise>
    						</c:choose>
                        </div>  
            		</c:forEach>					                      
                </div><!--end row-->
            </div><!--end inner-right -panel-->
        </div><!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel use-rage-left brand-rage-left">
                <!--品牌热度-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>品牌热度</span>
                    </div>
                    <div class="col-sm-12  cur-data-content">
                       <div class="row brand-info">
                           <div class="col-sm-1 brand-info-title">日</div>
                           <div class="col-sm-9">
                               <div class="progress progress-mall-info">
                                   <div style="width: ${PinPai.daycnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success brand-bar-success"></div>
                               </div>
                           </div>
                           <div class="col-sm-2 brand-info-count">${PinPai.daycnt}K</div>
                       </div><!--end row-->
                        <div class="row brand-info">
                            <div class="col-sm-1 brand-info-title">月</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${PinPai.weekcnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success brand-bar-success"></div>
                                </div>
                            </div>
                            <div class="col-sm-2 brand-info-count">${PinPai.weekcnt}K</div>
                        </div><!--end row-->
                        <div class="row brand-info">
                            <div class="col-sm-1 brand-info-title">年</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${PinPai.cnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success brand-bar-success"></div>
                                </div>
                            </div>
                            <div calss="col-sm-2 brand-info-count">${PinPai.cnt}K</div>
                        </div><!--end row-->
                    </div><!--end cur-data-content-->

                </div><!--end row -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel">
           
                        <div class="row" >
                         <c:forEach var="pinpaiitem" items="${PinPaiList}" >
                            <div class="col-sm-1 customer-status customer-status-t">
                                <span class="count"><em style="border-bottom:solid ${pinpaiitem.cnt}px #faaa53;"><i data-height="120">${pinpaiitem.cnt}</i>K</em></span>
                            <c:choose>
                        	<c:when  test="${fn:length(pinpaiitem.content)>5}">  
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${pinpaiitem.content}">${fn:substring(pinpaiitem.content,0,5)}...</span>
    						</c:when> 
    						<c:otherwise>
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${pinpaiitem.content}">${pinpaiitem.content}</span>
    						</c:otherwise>
    						</c:choose>                                    
                            </div>
                         </c:forEach>	   
                        </div><!--end row-->
            
            
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->

        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel activity-rage-left">
                <!--活动情况-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>活动情况</span>
                    </div>
                    <div class="col-sm-12  cur-data-content">
                       <div class="row activity-info">
                           <div class="col-sm-1 activity-info-title">日</div>
                           <div class="col-sm-9">
                               <div class="progress progress-mall-info">
                                   <div style="width: ${HuoDong.daycnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success activity-bar-success"></div>
                               </div>
                           </div>
                           <div calss="col-sm-2 activity-info-count">${HuoDong.daycnt}K</div>
                       </div><!--end row-->
                        <div class="row activity-info">
                            <div class="col-sm-1 activity-info-title">月</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${HuoDong.weekcnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success activity-bar-success"></div>
                                </div>
                            </div>
                            <div calss="col-sm-2 activity-info-count">${HuoDong.weekcnt}K</div>
                        </div><!--end row-->
                        <div class="row activity-info">
                            <div class="col-sm-1 activity-info-title">年</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${HuoDong.cnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success activity-bar-success"></div>
                                </div>
                            </div>
                            <div calss="col-sm-2 activity-info-count">${HuoDong.cnt}K</div>
                        </div><!--end row-->
                    </div><!--end cur-data-content-->

                </div><!--end row -->

            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel ">
            
                        <div class="row">
                           <c:forEach var="huodongitem" items="${HuoDongList}" >
                            <div class="col-sm-1 customer-status customer-status-t">
                                <span class="count"><em style="border-bottom:solid ${huodongitem.cnt*10}px #1ebfae;"><i data-height="120">${huodongitem.cnt}</i>K</em></span>
                               <c:choose>
                        	<c:when  test="${fn:length(huodongitem.content)>5}">  
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${huodongitem.content}">${fn:substring(huodongitem.content,0,5)}...</span>
    						</c:when> 
    						<c:otherwise>
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${huodongitem.content}">${huodongitem.content}</span>
    						</c:otherwise>
    						</c:choose> 
    						 </div>
                         </c:forEach>	
                        </div><!--end row-->
            </div><!--end inner-right -panel-->
        </div> <!--end -row-->


        <div class="row">
            <div class="col-sm-3 col-md-3 inner-left-panel map-rage-left">
                <!--地图情况-->
                <div class="row cur-data">
                    <div class="col-sm-12 cur-data-title">
                        <span>地图情况</span>
                    </div>
                    <div class="col-sm-12  cur-data-content">
                       <div class="row map-info">
                           <div class="col-sm-1 map-info-title">日</div>
                           <div class="col-sm-9">
                               <div class="progress progress-mall-info">
                                   <div style="width: ${DiTu.daycnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success map-bar-success"></div>
                               </div>
                           </div>
                           <div class="col-sm-2 map-info-count">${DiTu.daycnt}K</div>
                       </div><!--end row-->
                        <div class="row map-info">
                            <div class="col-sm-1 map-info-title">月</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${DiTu.weekcnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success map-bar-success"></div>
                                </div>
                            </div>
                            <div class="col-sm-2 map-info-count">${DiTu.weekcnt}K</div>
                        </div><!--end row-->
                        <div class="row map-info">
                            <div class="col-sm-1 map-info-title">年</div>
                            <div class="col-sm-9">
                                <div class="progress progress-mall-info">
                                    <div style="width: ${DiTu.cnt}%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success map-bar-success"></div>
                                </div>
                            </div>
                            <div class="col-sm-2 map-info-count">${DiTu.cnt}K</div>
                        </div><!--end row-->
                    </div><!--end cur-data-content-->

                </div><!--end row -->


            </div><!--end inner-left-panel-->
            <div class="col-sm-9 col-md-9 inner-right-panel ">
            
                        <div class="row">
                           <c:forEach var="dituitem" items="${DiTuList}" >
                            <div class="col-sm-1 customer-status customer-status-t" alt="${dituitem.content}">
                                <span class="count"><em style="border-bottom:solid ${dituitem.cnt}px #faaa53;"><i data-height="120">${dituitem.cnt}</i>K</em></span>
  							<c:choose>
                        	<c:when  test="${fn:length(dituitem.content)>5}">  
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${dituitem.content}">${fn:substring(dituitem.content,0,5)}...</span>
    						</c:when> 
    						<c:otherwise>
    							<span class="name" style="" data-toggle="tooltip" data-placement="top" title="${dituitem.content}">${dituitem.content}</span>
    						</c:otherwise>
    						</c:choose> </div>
                         </c:forEach>	
                        </div><!--end row-->
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

<script src="../static/js/patch/list.js"></script>
<script>
$(document).ready(function(){
	 $('[data-toggle="tooltip"]').tooltip();
});
</script>

</body>
</html>

