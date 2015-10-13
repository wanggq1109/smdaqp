/**
 * Created by user on 2015/1/15.
 */

$(document).ready(function(){
    var maxCount=7;
   $(".item-index").on("click",function(event){
       event.preventDefault();

       //$current_use=$(".leftpanelinner>ul li").find(".in-use");
       //limit the max count of pages;
       var pageCount=$(".pageheader>ul>li").length;
       if(pageCount<maxCount){
           //control the li item status;
           $this=$(this);

           //判读页面的使用状态
           if(!$this.parent().hasClass("active")){

               var itemId=$this.attr("id");
               var targetTabItem="#tab-"+itemId;
              // var inUse;//使用inUse监测打开的页面

               $(".leftpanelinner>ul li").removeClass("active nav-active");
               $this.parent().addClass("active").closest("li.nav-parent").addClass("active nav-active").closest("ul").css("display","block");

               //判读页面的使用状态
               if(!$this.parent().hasClass("in-use") && !$this.parent().hasClass("load-fail")){
                   //标注当前的页面使用状态--in-use; 使用in-use判断页面的加载情况  - 当shown.bs.tab时，如果in-use没有in-use标注，加载新页面，页面加载后给item-id 加入in-use标记
                  // $this.parent().addClass("in-use");-----------这一步放到shown-bs.tab事件--加载页面完成后添加。

                   //add new tab item
                   //<li class="active"><a href="#home" role="tab" data-toggle="tab">Home</a><span class="glyphicon glyphicon-th-list"></span></li> #home

                   //构造tab
                   var newTabItem=[
                       '<li class=""><a id="tab-',
                       itemId,
                       '" class="item ',
                       itemId,
                       '" href="#content-',
                       itemId,
                       '" role="tab" data-toggle="tab">',
                       $this.text() ,
                       '</a><span class="glyphicon  glyphicon-remove"></span></li>'
                   ];

                   $newTab=$(newTabItem.join(""));

                   /*构造tab-content;
                   <div role="tabpanel" class="tab-pane active keep-alive content-item item-0" id="content-item-0">
                        <div class="content-item-wrapper">首页待定</div>
                   </div><!--content-item-0 -->
                    */
                   var newContentItem=[
                        '<div role="tabpanel" class="tab-pane fade content-item ',
                        itemId,
                       '" id="content-',
                        itemId,
                       '">',
                      // '<div class="content-item-wrapper">',
                      // itemId,这里当tab-content 页面呈现时，加载内容插入这里
                      // '</div>',
                       '</div><!--content-item-0 -->'
                   ];

                   $newContent=$(newContentItem.join(""));

                   $(".pageheader>ul li").removeClass("active");
                   $newTab.appendTo(".pageheader>ul");
                   $newContent.appendTo(".contentpanel>.tab-content");

                   //打开tab-content页面
                   $(targetTabItem).tab("show");

                   pageCount+=1;

               }// end if hasClass("in-use")
               else{
                   //切换至对应的Tab并Active
                   $(".pageheader>ul li").removeClass("active nav-active");

                   //打开tab-content页面
                   $(targetTabItem).tab("show");
                  // alert("in use!");
               }
           } //end if hasClass("active")
           else{
               //alert("active !");
           }
       }//end if pageCount<maxCount
       else{
           if($(this).parent().hasClass("in-use") || $(this).parent().hasClass("load-fail")) {
               //切换至对应的Tab并Active
               $(".pageheader>ul li").removeClass("active nav-active");
               //打开tab-content页面
               var itemId=$(this).attr("id");
               var targetTabItem="#tab-"+itemId;
               $(targetTabItem).tab("show");
           }else{
               alert("最多打开7个页面，请先关闭不需要用的页面");
           }
       }//end if pageCount<maxCount
   });
});

//tab-item联动---左侧导航栏 + ajax 加载新页面
$(document).ready(function(){
    $('.mainpanel').on('shown.bs.tab','a[data-toggle="tab"]', function (e) {
        var curTab= e.target; // newly activated tab
        //var formerTab= e.relatedTarget // previous active tab
        var curTabId=$(curTab).attr("id");

        //联动---左侧导航栏
        var theId=curTabId.split("-")[2];
        var navItemId="#item-"+theId;
        var $navItem=$(navItemId).parent();

        if($navItem.hasClass("in-use")){
            if(!$navItem.hasClass("active")) {
                //alert("创建后 联动激活左侧目录!");
                $(".leftpanelinner>ul li").removeClass("active nav-active");
                $(navItemId).parent().addClass("active").closest("li.nav-parent").addClass("active nav-active").closest("ul").css("display", "block");
            }//end if hasClass("in-acive")

        }//end if hasClass("in-use")
        else{
            if(!$navItem.hasClass("active")) {
                //alert("创建时 联动激活左侧目录!");
                $(".leftpanelinner>ul li").removeClass("active nav-active");
                $(navItemId).parent().addClass("active").closest("li.nav-parent").addClass("active nav-active").closest("ul").css("display", "block");
            }//end if hasClass("in-acive")
            else{
               // alert("新创建时 不用重新激活左侧目录");//这里代码生产环境时删除！！！
            }
            //加载新页面
            //标注当前的页面使用状态--in-use; 使用in-use判断页面的加载情况  - 当shown.bs.tab时，如果in-use没有in-use标注，加载新页面，页面加载后给item-id 加入in-use标记
            // $this.parent().addClass("in-use");-----------这一步放到shown-bs.tab事件--加载页面完成后添加。
            //alert("标注当前的页面使用状态--in-use;");

            //ajax-loader;
            $("#ajax-loader").fadeIn();
            var urlLoad=$(navItemId).attr("href");
            $.get(urlLoad,function(data,s){
                //console.log("#content-item-"+theId);
                $("#content-item-"+theId).append(data);
                //cancel ajax-loader;
                $("#ajax-loader").fadeOut();
                //标注in-use状态；
                $navItem.addClass("in-use");
            }).error(
              function(){
                  //cancel ajax-loader;
                  $("#ajax-loader").fadeOut();
                  //先设计成自动关闭标签页面
                  $("#content-item-"+theId).empty().append("<h1>加载失败</h1>");
                  $navItem.addClass("load-fail");
              }
            );//error-end

        }//end if hasClass("in-active")

    });
});

//清除页面元素 ---记得检查页面标记，恢复初始状态
$(document).ready(function(){
    $('.mainpanel').on('click','span.glyphicon-remove', function (e) {
        var removeTargetId=$(this).parent().find("a").attr("id");
        var removeTarget="item-"+removeTargetId.split("-")[2];
        alert(removeTarget);
        removeTargetElements(removeTarget);


    });
    //removeTarget ---- .item-id
    function removeTargetElements(removeTarget){
        var $navRemoveTarget=$(("#tab-")+removeTarget).parent();
        var $contentRemoveTarget=$(("#content-")+removeTarget);
        //页面切换至前一个打开页面
        $($navRemoveTarget).prev().find("a.item").tab("show");
        //删除页面元素
        $navRemoveTarget.remove();
        $contentRemoveTarget.remove();
        //左侧导航初始化；
        $("#"+removeTarget).parent().removeClass("in-use load-fail");
        //页面计数--改成新建页面时 $(".pageheader>ul>li").length来判断
    }
});


