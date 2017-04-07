<%--
  Created by IntelliJ IDEA.
  User: Cristin
  Date: 18-Mar-17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.png">

    <link href="/resources/css/app.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">

    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>

</head>
<body>
<div class="graphic-container">
    <div class="alert-danger">
        Hello_Muthafucker_Your_Name_Is&nbsp;==>&nbsp;&nbsp; <sec:authentication property="principal.username"/>
    </div>
    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
        <a href="#"> You_Are_ADMIN_OR_DBA</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
        <a href="#"> You_Are_ADMIN_OR_USER</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <a href="#">YOU_ARE_ADMIN</a>
    </sec:authorize>
</div>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/npm.js"></script>
</body>
</html>