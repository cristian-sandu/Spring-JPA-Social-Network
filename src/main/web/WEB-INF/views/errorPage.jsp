<%--
  Created by IntelliJ IDEA.
  User: ipanasenco
  Date: 12/2/2016
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oops!</title>
</head>
<body>
<p style="text-align: center;">
    <img src="${pageContext.request.contextPath}/resources/images/error.png" alt=""
         width="770"
         height="466"/></p>
<h1 style="text-align: center;">OOPS!</h1>
<h3 style="text-align: center;">It seems to be a bad request</h3>
<p style="text-align: center;">We&nbsp;can get u back to&nbsp;<a href="${pageContext.request.contextPath}/login">Login
    Page</a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/npm.js"></script>
</html>
