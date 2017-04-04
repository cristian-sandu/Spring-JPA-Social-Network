<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.png">

    <link href="/resources/css/app.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">

    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
</head>
<body>
<div class="generic-container">

    <div class="alert alert-success lead">
        ${success}
    </div>

    <span class="well floatRight">
			Go to <a href="<c:url value='/userlist' />">Users List</a>
		</span>
</div>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/npm.js"></script>
</body>

</html>