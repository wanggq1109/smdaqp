/**
 * Created by user on 2015/1/15.
 */
/*
页面modal一次只做一件事情
策略1： 随页面建造而建造，消失而消失，为每个打开页面缓存独立的作用域，同时建造处理全局的modal
策略2： 针对每个页面只对应一个modal,不做内容缓存，同时建造处理全局的modal
 */

/* 目前在处理hidden.bs.modal时，没有把页面modal统一处理，考虑到后期可能对每个的处理方式不一样，暂且保留单独处理的方式*/

$(document).ready(function(){
    //对能触发modal的地方加入*-modal-trigger, 当点击时为此trigger加入一个特殊的trigger-now类， 当完成显示时记得清除trigger-now
    $(".contentpanel").on("click",'[data-toggle="modal"]',function(e){
       $(this).addClass("trigger-now");
        //对del操作加入del-target标记
       if($(this).hasClass("data-op-del")){
           $(this).addClass("del-target");
       }
    });

    //page form modal--show
    $("#page-form-modal").on('shown.bs.modal', function (e) {
        // do something...
        $this=$(this);
        var $trigger=$(".trigger-now");
        var dataUrl=$trigger.attr("data-url");

        $("#modal-ajax-loader").fadeIn();
        if(undefined==dataUrl){
            dataUrl="404.html"
        }
        $.get(dataUrl,function(data,s){
            //;
            $("#modal-ajax-loader").fadeOut("fast");
            $this.find(".modal-body").empty().append(data);
            //标注in-use状态；
        }).error(
            function(){
                //cancel ajax-loader;
                $("#modal-ajax-loader").fadeOut("fast");
                //先设计成自动关闭标签页面
                $this.find(".modal-body").empty().append("<h1>加载失败</h1>");
            }
        );//error-end

        //加载结束后清除.trigger-now--移到关闭时处理
    });
    //关闭时清空modal;不缓存
    $("#page-form-modal").on('hidden.bs.modal', function (e) {
        $this=$(this);
        $this.find(".modal-body").empty();
        var $trigger=$(".trigger-now");
        console.log($trigger.get(0));
        if($trigger.get(0)) {
            $trigger.removeClass("trigger-now");
        }
    });

    //page modal
    $("#page-modal").on('shown.bs.modal', function (e) {
        $this=$(this);
        // do something...
        var $trigger=$(".trigger-now");
        //   alert($trigger.attr("class"));
        var pageUrl=$trigger.attr("data-url");
        //  alert(delUrl);
        var pageData=$trigger.attr("data-ctrl");//

        $("#modal-ajax-loader").fadeIn();
        if(undefined==pageUrl){
           pageUrl="404.html"
        }

        $.post(pageUrl,pageData,function(data,s){
            if(s=="success"){ //这里的判断根据服务器策略实施
                $("#modal-ajax-loader").fadeOut("fast");
                $this.find(".modal-body").empty().append(data);
            }else{
                var alertData="<h1>加载失败</h1>";
                $("#modal-ajax-loader").fadeOut("fast");
                $("#page-modal").find(".modal-body").empty().append(alertData);
            }
        }).error(
            function(){
                var alertData="<h1>删除失败</h1>";
                $("#modal-ajax-loader").fadeOut("fast");
                $("#page-modal").find(".modal-body").empty().append(alertData);
            }
        );//error-end

        //加载结束后清除.trigger-now
        //$trigger.removeClass("trigger-now");
    });

    $("#page-modal").on('hidden.bs.modal', function (e) {
        $("#page-modal").find(".modal-body").empty()
        var $trigger=$(".trigger-now");
        console.log($trigger.get(0));
        if($trigger.get(0)){
            $trigger.removeClass("trigger-now");
        }
    });
    //alert modal---alert modal采用另一种方式，即错误由错误源报出，并构造alert内容，触发$("#alert-modal").modal.show()展示
    $("#alert-modal").on('shown.bs.modal', function (e) {
        // do something...
        var $trigger=$(".trigger-now");
       // alert($trigger.attr("class"));

        //对页面删除操作做统一处理---需要反复确认逻辑
        if($trigger.hasClass("del-target")){
           // var delUrl=$trigger.attr("href");
           // var delData=$trigger.attr("data-ctrl");//利用data-ctrl获取要删除的内容；
            var alertDelData=[
              '<h1>确认删除？</h1>',
              '<input type="button" class="btn btn-danger" href="" id="del-confirm" value="删除">'
            ].join("");

           $("#alert-modal").find(".modal-body").empty().append(alertDelData);

        }//end if 对页面删除操作做统一处理
        else{
            $trigger.removeClass("trigger-now");
        }
        //加载结束后清除.trigger-now --这里逻辑加入到 alert-del事件处理后处理 ---并在modal关闭时重新确认一次
      //$trigger.removeClass("trigger-now");
    });// end alert modal---alert modal

    $("#alert-modal").on('hidden.bs.modal', function (e) {
            $this=$(this);
            $this.find(".modal-body").empty();
            var $trigger=$(".trigger-now");
            console.log($trigger.get(0));
            if($trigger.get(0)){
                $trigger.removeClass("trigger-now del-target");
            }
    });
});

$(document).ready(function(){
    //为 alert-del注册事件
    $("body").on("click","#del-confirm",function(e){
        e.preventDefault();
        var $trigger=$(".trigger-now");
        var delUrl=$trigger.attr("data-url");
       // alert(delUrl);
        var delData=$trigger.attr("data-ctrl");//利用data-ctrl获取要删除的内容；

        $.post(delUrl,delData,function(data,s){

            if(s=="success"){ //这里的判断根据服务器策略实施
              // alert("ie 8 对modal hide无效，暂不测试");
               console.log("del success");
                $("#alert-modal").modal("hide");
                $trigger.closest("tr").fadeOut().remove();
            }else{
                var alertData="<h1>删除失败</h1>";
                $("#alert-modal").find(".modal-body").empty().append(alertData);
            }
        }).error(
            function(){
                var alertData="<h1>删除失败</h1>";
                $("#alert-modal").find(".modal-body").empty().append(alertData);
            }
        );//error-end
    });//end  为 alert-del注册事件
});

