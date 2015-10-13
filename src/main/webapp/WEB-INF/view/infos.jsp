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
    <link rel="shortcut icon" href="images/favicon.png" type="image/png">

    <title>悦商CRM</title>

    <link href="../static/css/style.default.css" rel="stylesheet">
    <link href="../static/css/jquery.datatables.css" rel="stylesheet">

    <link href="../static/css/patch/patch6.css" rel="stylesheet">
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

            <a href="#"><h2 id="mall-title"></h2></a>
            <h2 id="mall-sub-title" class="pull-right">实时动态</h2>
        </div>

        <div class="contentpanel" id="mall-infos">
            <div class="row">

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/splus/index.do">
                        <div class="panel-heading" id="panel-cash">
                            <div class="stat">
                                <div class="row">

                                    <div class="col-xs-8">
                                        <div id="cash-title">
                                            <em class="info-icon info-icon-dollar"></em>
                                            <h3 class="stat-label">收银机</h3>
                                        </div>
                                        <dl>
                                        </dl>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="scaned-img">
                                            <img src="" alt="小票扫描">
                                        </div>
                                    </div> <!-- scanned data -->

                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/ibea/Ibeacon.do">
                        <div class="panel-heading" id="panel-loc">
                            <div class="stat">
                                <div class="row">

                                    <div class="col-xs-12">
                                        <div id="loc-title">
                                            <em class="info-icon info-icon-loc"></em> <h3 class="stat-label">定位</h3>
                                        </div>
                                    </div>
                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/splus/parking.do">
                        <div class="panel-heading" id="panel-parking">
                            <div class="stat">
                                <div class="row">

                                    <div class="col-xs-12">
                                        <div id="parking-title">
                                            <em class="info-icon info-icon-car"></em> <h3 class="stat-label">停车场</h3>
                                        </div>
                                    </div>
                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/data/dataReport.do">
                        <div class="panel-heading" id="panel-screen">
                            <div class="stat">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="screen-title">
                                            <em class="info-icon info-icon-screen"></em><h3 class="stat-label">导视屏</h3>
                                        </div>
                                    </div>
                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/splus/wifi.do">
                        <div class="panel-heading" id="panel-wifi">
                            <div class="stat">
                                <div class="row">

                                    <div class="col-xs-12">
                                        <div id="wifi-title">
                                            <em class="info-icon info-icon-wifi"></em> <h3 class="stat-label">WIFI</h3>
                                        </div>

                                    </div>
                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->

                <div class="col-sm-6 col-md-4">
                    <div class="panel panel-success panel-stat"  data-href="/smdaqp/User/userinfo.do">
                        <div class="panel-heading" id="panel-member">
                            <div class="stat">
                                <div class="row">

                                    <div class="col-xs-12">
                                        <div id="member-title">
                                            <em class="info-icon info-icon-member"></em><h3 class="stat-label">会员</h3>
                                        </div>
                                    </div>
                                </div><!-- row -->
                            </div><!-- stat -->
                        </div><!-- panel-heading -->
                    </div><!-- panel -->
                </div><!-- col-sm-6 -->



            </div> <!--end row-->

        </div> <!-- contentpanel -->

    </div><!-- mainpanel -->

</section>

<script src="../static/js/jquery-1.10.2.min.js"></script>
<script src="../static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/modernizr.min.js"></script>
<script src="../static/js/toggles.min.js"></script>
<script src="../static/js/retina.min.js"></script>
<script src="../static/js/jquery.cookies.js"></script>
<script type="text/javascript" src="../static/js/subscibe.js"></script>
<script type="text/javascript" src="../static/js/chosen.jquery.min.js"></script>
<!--
<script src="../static/js/custom.js"></script>
<script src="../static/js/dashboard.js"></script>
-->
<script type="text/javascript" src="../static/js/custom.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".panel-stat").on("click",function(e){
            var href=$(this).attr("data-href");
            console.log(href);
            location.href=href;
        });

        timeedout=false;

        function getMessage(data){
//            console.log("get message");
            var mess=data;
            if(data.data1){
                var pos =data.data1;
                var subtitle1 = pos.subtitle;
                var msg =pos.msg;
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    var info =  "";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em>用户：</dt>";
                    info += "<dd>" + infos[1] + "</dd>";
                    if(infos[2]){
                        info += "<dt>在" + infos[2] + " </dt>";
                    }
                    info +=  "<dd>消费" + infos[3] + "元</dd>" ;
                    $("#panel-cash dl").slideUp().html(info).slideDown();

                    var img =item.img;
                    $("#panel-cash img").slideUp().attr("src",img).slideDown();
                });
            }
            if(data.data2){
                var wifi =data.data2;
                var subtitle1 = wifi.subtitle;
                var msg =wifi.msg;
                var info="";
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    info += "<dl>";
                    info += "<dt><em class=\"mall-info-time\"> " + infos[0] +  " </em><em class=\"mall-device-type\">" + infos[1] + " </em></dt>";
                    info += "<dd>用户<em class=\"mall-info-user\">" + infos[2] + " </em>接入</dd>";
                    info += "</dl>";
                });
                $("#panel-wifi .col-xs-12").slideUp().append(info).slideDown();
            }
            if(data.data3){
                var park =data.data3;
                var subtitle1 = park.subtitle;
                var msg =park.msg;
                var info="";
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    info += "<dl>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em></dt>";
                    info += "<dd><em class=\"mall-info-car\">" + infos[1] + " </em>" + infos[2] + "</dd>";
                    info += "</dl>";
                });
                $("#panel-parking .col-xs-12").slideUp().append(info).slideDown();
            }
            if(data.data4){
                var ibc =data.data4;
                var subtitle1 = ibc.subtitle;
                var msg =ibc.msg;
                var info="";
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    info += "<dl>";
                    info +=  "<dt><em class=\"mall-info-time\">" + infos[0] + " </em> 用户：<em class=\"mall-info-user\">" + infos[1] + " </em></dt>";
                    info += "<dd> 进入" + infos[2] + "区域</dd>";
                    info += "</dl>";
                });
                $("#panel-loc .col-xs-12").slideUp().append(info).slideDown();
            }
            if(data.data5){
                var screen =data.data5;
                var msg =screen.msg;
                var info="";
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    info += "<dl>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em>" + infos[1] + "</dt>";
                    info += "<dd><em class=\"mall-shop-type\">" + infos[2] + " </em></dd>";
                    info += "</dl>";
                });
                $("#panel-screen .col-xs-12").slideUp().append(info).slideDown();
            }
            if(data.data6){
                var user =data.data6;
                var msg =user.msg;
                var info="";
                $.each(msg, function(i, item) {
                    var infos = item.content.split("#",-1);
                    info += "<dl>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + "</em>新注册会员:</dt>";
                    info += "<dd><em class=\"mall-info-user\">" + infos[1] + "</em></dd>";
                    info += "</dl>";
                });
                $("#panel-member .col-xs-12").slideUp().append(info).slideDown();
            }

/*
            $("#panel-2 h4").slideUp().html(mess['data2']).slideDown();
            $("#panel-3 h4").slideUp().html(mess['data3']).slideDown();
            $("#panel-4 h4").slideUp().html(mess['data4']).slideDown();
            $("#panel-5 h4").slideUp().html(mess['data5']).slideDown();
            $("#panel-6 h4").slideUp().html(mess['data6']).slideDown();*/
        //    timedout=true;
            /*
            var panel_1=$("#panel-1")
            var panel_2=$("#panel-2")
            var panel_3=$("#panel-3")
            var panel_4=$("#panel-4")
            var panel_5=$("#panel-5")
            var panel_6=$("#panel-6")
        */
        };
        function errorMessage(e){
            console.log("error--------------------------------------------");
         //   console.log(e);
        }
        var ajax;
        var heartBeat_func=function() {

            /*if(timeedout ==true){
                console.log("timeedout");
                ajax.abort();
                timeedout=false;
                heartBeat=setTimeout(heartBeat_func,5000);
            }else{
                ajax= $.ajax({
                    type:'get',
                    url:'/smdaqp/splus/getInfoData.do',
                    success:getMessage,
                    error: errorMessage,
                    complete: function(){
                        timeedout=false;
                        clearTimeout(heartBeat);
                        heartBeat=setTimeout(heartBeat_func,5000);
                    }
                   // datatype:"jsonp"
                });

                timeedout=true;

                heartBeat=setTimeout(heartBeat_func,5000);
            }*/
            ajax= $.ajax({
                type:'get',
                url:'/smdaqp/splus/getInfoData.do',
                success:getMessage,
                error: errorMessage,
                complete: function(){
                    timeedout=false;
//                    clearTimeout(heartBeat);
//                    heartBeat=setTimeout(heartBeat_func,5000);
                }
                // datatype:"jsonp"
            });
        };

        heartBeat_func();


        /*
        var json_obj = {

        } ;//JSON对象
        var json_str = JSON.stringify(json_obj); //将JSON对象转变成JSON格式的字符串

        $.post("", json_str, callback, "json");

        function callback(json){
            //  $('#response').html('code:'+json['status']['code'] + "\tmessage:" +json['status']['message'])
            console.log(json);
        }
        */
    });
</script>

</body>
</html>

