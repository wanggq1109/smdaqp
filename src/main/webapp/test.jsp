<%@ page import="com.powerlong.support.websocket.InboundContainer" %>
<%@ page import="java.nio.CharBuffer" %>
<%--
  Created by IntelliJ IDEA.
  User: z8242_000
  Date: 2015/6/7
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="static/js/jquery-1.10.2.min.js"></script>
</head>
<body>
<div style="margin: 200px;border:1px solid #dedede;background: #fafafa; padding:15px  20px;line-height: 25px;">
    <%for (String sid : InboundContainer.getSessionList()) {%>
    <label style="width: 258px;display: inline-block;text-align: right"><%=sid%>
    </label>：
    <a href="javascript:void(0)" class="single" type="1">推送POS</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="single" type="2">推送WIFI</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="single" type="3">推送停车场</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="single" type="4">推送IBEACCN</a>&nbsp;&nbsp;<br/>
    <%}%>
    <hr/>
    <label style="width: 258px;display: inline-block;text-align: right">全部</label>：
    <a href="javascript:void(0)" class="all" type="1">推送POS</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="all" type="2">推送WIFI</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="all" type="3">推送停车场</a>&nbsp;&nbsp;
    <a href="javascript:void(0)" class="all" type="4">推送IBEACCN</a>&nbsp;&nbsp;<br/>
</div>
<script type="text/javascript">
    $("a.single").click(function () {
        $.get("notification.do", {
            is_all: false,
            msg_type: $(this).attr("type"),
            session: $.trim($(this).prev("label").text())
        });
    });
    $("a.all").click(function () {
        $.get("notification.do", {
            is_all: true,
            msg_type: $(this).attr("type"),
            session: $.trim($(this).prev("label").text())
        });
    });
</script>
</body>
</html>
