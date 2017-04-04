<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body bgcolor="black" style="color: white">
<div class="generic-container">
    <h1 style="text-align: center;">OOPS!</h1>
    <div class="authbar">
        <center><span>Dear <strong><span style="color: lime">${loggedinuser}</span></strong>, You are not authorized to access this page.</span>
            <span
                    class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span></center>
    </div>

    <div style="margin-left: 9%"><img src="${pageContext.request.contextPath}/resources/images/access_denied.jpg" alt=""
                                      width="90%"
                                      height="85%" style="border-radius: 10%" align="center"/>
    </div>
</div>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/npm.js"></script>
</body>
</html>