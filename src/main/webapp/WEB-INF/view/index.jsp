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

    <title>user</title>

    <link href="../static/css/style.default.css" rel="stylesheet">
    <link href="../static/css/jquery.datatables.css" rel="stylesheet">

    <link href="../static/css/patch/patch.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../static/js/html5shiv.js"></script>
    <script src="../static/js/respond.min.js"></script>
    <![endif]-->
</head>

<body id="main-page">

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

    <div class="mainpanel" >

        <div class="pageheader">
            <!--  <h2><i class="fa fa-home"></i>MALL 3.0 <span></span></h2>-->
            <a href="<%=basePath%>smdaqpController/mall.do"><h2 id="mall-title"></h2></a>
        </div>

        <div class="contentpanel">
            <div class="row user">

                <div class="col-sm-1 user-photo">
                    <img class="pull-right" src="../static/images/patch/m.png"/>
                </div>
                <div class="col-sm-3">
                    <div class="row">
                        <span id="user-name">用户名称</span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star user-level"></span>
                        <span class="glyphicon glyphicon-star-empty user-level" ></span>
                        <span class="glyphicon glyphicon-star-empty user-level"></span>
                    </div>
                    <div class="row user-group">
                        <span>女</span><span>汉族</span><span>30岁</span><span>白领</span><em>辣妈群</em>

                    </div>
                    <div class="row user-location">
                        <span class="glyphicon glyphicon-map-marker"></span>
                        <span>徐家汇</span>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div  class="user-more" id="user-bought">
                        <h3>贡献客单价</h3>
                        <p>
                            <span class="fa fa-cny">73.00元</span>
                        </p>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div  class="user-more" id="user-activity">
                        <h3>活跃度</h3>
                        <p>
                            <span>68</span>
                        </p>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div  class="user-more" id="user-pay-level">
                        <h3>购买力<span class="glyphicon glyphicon-info-sign"></span></h3>
                        <p>
                            <span class="fa fa-cny">2960元</span>
                        </p>
                        <div class="tooltip top" role="tooltip">
                            <div class="tooltip-arrow"></div>
                            <div class="tooltip-inner">
                                购买力=月消费排名+(收入-月消费）/收入
                            </div>
                        </div>
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
                            <p class="bg-light"><span>家庭角色</span>母亲</p>
                            <p class=""><span>受教育程度</span>大学</p>
                            <p class="bg-light"><span>地址</span>徐汇区某某小区</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="bg-light"><span>婚姻史</span>已婚</p>
                            <p class=""><span>是否有子女</span>1</p>
                            <p class="bg-light"><span>车</span>奥迪Q5-沪A 27666</p>
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
                                <dt><span></span>朋友关联度</dt>
                                <dd>79%</dd>
                            </dl>
                        </div>
                        <div class="use-rage-label pet-info " id="pet-info-2">
                            <dl>
                                <dt><span></span>偏好商家</dt>
                                <dd>COACH</dd>
                                <dd>BOSS 丽婴房</dd>
                                <dd>星巴克 KFC</dd>
                                <dt><span></span>偏好类型</dt>
                                <dd>购物 就餐 美容</dd>
                            </dl>
                        </div>
                        <div class="use-rage-label pet-info" id="pet-info-3">
                            <dl>
                                <dt><span></span>参与意愿</dt>
                                <dd>PET置入大屏80%</dd>

                                <dt><span></span>来场时间</dt>
                                <dd>假期或者周末</dd>
                                <dd class="dd-note">平均逗留时间90分钟</dd>
                                <dd class="dd-note">累计场外访问时间18小时</dd>
                            </dl>
                        </div>
                        <div class="use-rage-label pet-info" id="pet-info-4">
                            <dl>
                                <dt><span></span>偏好优惠</dt>
                                <dd>优惠券使用率82%</dd>

                                <dt><span></span>偏好的广告</dt>
                                <dd>母婴类活动优惠券</dd>

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
                        <canvas id="use-rage-search" width="250" height="250">

                        </canvas>
                        <div class="use-rage-info">
                            <h4>消费水平</h4>
                            <h3>3000-4000</h3>
                            <p>收入范围8000-10000</p>
                        </div>
                        <div class="use-rage-label label-4" id="label-1-4">
                            <dl>
                                <dt> <span></span>餐饮</dt>
                                <dd>上海人家</dd>
                                <dd>湘满楼</dd>
                            </dl>

                        </div>
                        <div class="use-rage-label label-1" id="label-1-1">
                            <dl>
                                <dt> <span></span>娱乐</dt>
                                <dd>麦乐迪KTV</dd>
                                <dd>游乐城堡</dd>
                            </dl>

                        </div>
                        <div class="use-rage-label label-3" id="label-1-3">
                            <dl>
                                <dt> <span></span>母婴育儿</dt>
                                <dd>丽婴房</dd>
                                <dd>BALABALA</dd>
                            </dl>

                        </div>
                        <div class="use-rage-label label-2" id="label-1-2">
                            <dl>
                                <dt><span></span>美容服务</dt>
                                <dd>沙宣美发沙龙</dd>
                                <dd>玛莎美容</dd>
                            </dl>
                        </div>
                    </div>
                    <!--end row-->
                </div><!--end panel-->
            </div> <!--end -row-->

            <div class="row">

                <div class="col-sm-12 user-info-panel">
                    <!--row-->
                    <div class="row user-info">
                        <div class="user-info-title">
                            <span>辣妈群特征</span>
                        </div>
                    </div>
                    <!--end row-->
                    <!--row-->
                    <div class="row user-group-note">
                        <div class="col-group-note" id="group-note-1">
                            <p>经常光顾各种<em>母婴店</em></p>
                        </div>
                        <div class="col-group-note" id="group-note-2">
                            <p class="cart"></p>
                            <p>经常搜索/购买时尚孩子用品和母亲用品</p>
                            <p>分享育儿经验 </p>
                            <p>经常购买保健用品或者美容服务用品、时尚服饰等</p>

                        </div>
                        <div class="col-group-note" id="group-note-3">
                            <p>经常在<em>母婴类</em>相关群组进行问一问的人</p>
                        </div>
                        <div class="col-group-note" id="group-note-4">
                            <p class="groups-urse"></p>
                            <p>经常在母婴类店铺相关 广场内容点赞，分享，评论的人</p>
                        </div>
                        <div class="col-group-note" id="group-note-5">
                            <p>进行在<em>美容店</em>进行消费</p>
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

<script src="../static/js/patch/index.js"></script>

</body>
</html>

