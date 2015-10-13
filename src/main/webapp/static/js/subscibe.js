var Server = {};
Server.socket = null;
Server.MSG_TYPE = {POS: "1", WIFI: "2", CAR_PARK: "3", IBEACON: "4",SCREEN:"5",USER:"6"};
function initServer() {
    var wsURL = 'ws://' + window.location.host + '/smdaqp/splus/subscibe.ws';
    if ('WebSocket' in window) {
        Server.socket = new WebSocket(wsURL);
    } else if ('MozWebSocket' in window) {
        Server.socket = new MozWebSocket(wsURL);
    } else {
        alert("浏览器不支持");
        return false;
    }
    // 断开重链
    Server.socket.onclose = function () {
        initServer();
    };
    // 接收到消息
    Server.socket.onmessage = function (message) {
        if (typeof message.data == "string") {// 如果发送的是字符串信息.
            var item = eval("(" + message.data + ")");
            switch (item.msgType + "") {
                case Server.MSG_TYPE.POS :// POS消息
                    // 刷新POS
                    var infos = item.content.split("#",-1);
                    var info =  "";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em>用户：</dt>";
                    info += "<dd>" + infos[1] + "</dd>";
                    if(infos[2]){
                        info += "<dt>在" + infos[2] + " </dt>";
                    }
                    info +=  "<dd>消费" + infos[3] + "元</dd>" ;

                    $("#panel-cash dl").slideUp().html(info).slideDown();
                    $("#panel-cash img").slideUp().attr("src",item.img).slideDown();
                    break;
                case Server.MSG_TYPE.WIFI: // WIFI消息
                    // 刷新WiFi
                    var infos = item.content.split("#",-1);
                    var info =  "";
                    info += "<dl style='display:none'>";
                    info += "<dt><em class=\"mall-info-time\"> " + infos[0] +  " </em><em class=\"mall-device-type\">" + infos[1] + " </em></dt>";
                    info += "<dd>用户<em class=\"mall-info-user\">" + infos[2] + " </em>接入</dd>";
                    info += "</dl>";

                    if($("#panel-wifi dl").length>2){
                        $("#panel-wifi dl").last().slideUp(function(){
                            $(this).remove();
                            $(info).insertAfter("#wifi-title").slideDown();
                        });
                    }else{
                        $(info).insertAfter("#wifi-title").slideDown();
                    }

                    break;
                case Server.MSG_TYPE.CAR_PARK: // CAR_PARK消息
                    // 刷新CAR_PARK
                    var infos = item.content.split("#",-1);
                    var info =  "";
                    info += "<dl style='display:none'>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em></dt>";
                    info += "<dd><em class=\"mall-info-car\">" + infos[1] + " </em>" + infos[2] + "</dd>";
                    info += "</dl>";

                    if($("#panel-parking dl").length>2){
                        $("#panel-parking dl").last().slideUp(function(){
                            $(this).remove();
                            $(info).insertAfter("#parking-title").slideDown();
                        });
                    }else{
                        $(info).insertAfter("#parking-title").slideDown();
                    }

                    break;
                case Server.MSG_TYPE.IBEACON: // IBEACON消息
                    // 刷新IBEACON
                    var infos = item.content.split("#",-1);
                    var info = "";
                    info += "<dl style='display:none'>";
                    info +=  "<dt><em class=\"mall-info-time\">" + infos[0] + " </em> 用户：<em class=\"mall-info-user\">" + infos[1] + " </em></dt>";
                    info += "<dd> 进入" + infos[2] + "区域</dd>";
                    info += "</dl>";

                    if($("#panel-loc dl").length>2){
                        $("#panel-loc dl").last().slideUp(function(){
                            $(this).remove();
                            $(info).insertAfter("#loc-title").slideDown();
                        });
                    }else{
                        $(info).insertAfter("#loc-title").slideDown();
                    }

                    break;
                case Server.MSG_TYPE.SCREEN: // IBEACON消息
                    // 刷新IBEACON

                    var infos = item.content.split("#",-1);
                    var info = "";
                    info += "<dl style='display:none'>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + " </em>";
                    if(typeof(infos[1])=="undefined"){
                        info +=  "&nbsp&nbsp</dt>";
                    }else{
                        info += infos[1] + "</dt>";
                    }
                    if(typeof(infos[2])=="undefined"){
                        info += "<dd><em class=\"mall-shop-type\">&nbsp&nbsp</em></dd>";
                    }else{
                        info += "<dd><em class=\"mall-shop-type\">" + infos[2] + " </em></dd>";
                    }
                    info += "</dl>";

                    if($("#panel-screen dl").length>2){
                        $("#panel-screen dl").last().slideUp(function(){
                            $(this).remove();
                            $(info).insertAfter("#screen-title").slideDown();
                        });
                    }else{
                        $(info).insertAfter("#screen-title").slideDown();
                    }

                    break;
                case Server.MSG_TYPE.USER: // IBEACON消息
                    // 刷新USER
                    var infos = item.content.split("#",-1);
                    var info = "";
                    info += "<dl style='display:none'>";
                    info += "<dt><em class=\"mall-info-time\">" + infos[0] + "</em>新注册会员:</dt>";
                    info += "<dd><em class=\"mall-info-user\">" + infos[1] + "</em></dd>";
                    info += "</dl>";

                    if($("#panel-member dl").length>2){
                        $("#panel-member dl").last().slideUp(function(){
                            $(this).remove();
                            $(info).insertAfter("#member-title").slideDown();
                        });
                    }else{
                        $(info).insertAfter("#member-title").slideDown();
                    }
                    break;
                default :
                    alert("未知错误，请刷新页面");
            }
        }
    };
}
initServer();
