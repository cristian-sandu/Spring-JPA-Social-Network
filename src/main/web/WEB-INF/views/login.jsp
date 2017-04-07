<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.png">

    <link href="/resources/css/app.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.css" type="text/css" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">

    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>


    <script>
        $().ready(function () {
            $("#card").flip({
                trigger: 'manual'
            });
        });


        $(".signup_link").click(function () {

            $(".signin_form").css('opacity', '0');
            $(".signup_form").css('opacity', '100');


            $("#card").flip(true);

            return false;
        });

        $("#unflip-btn").click(function () {

            $(".signin_form").css('opacity', '100');
            $(".signup_form").css('opacity', '0');

            $("#card").flip(false);

            return false;

        });
    </script>

</head>

<body class="main">

<div class="login-screen"></div>
<div class="login-center">
    <div class="container min-height" style="margin-top: 20px;">
        <div class="row">
            <div class="col-xs-4 col-md-offset-8">
                <div class="login" id="card">
                    <div class="front signin_form">
                        <p>Login to Your Account</p>


                        <c:url var="loginUrl" value="/login"/>

                        <form class="login-form" action="${loginUrl}"
                              method="post">


                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>

                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>


                            <div class="form-group">
                                <div class="input-group">
                                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                    <input type="text" id="username" name="username"
                                           placeholder="Username" class="form-control" required/>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="input-group">

                                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder="Password" required/>
                                </div>
                            </div>


                            <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"/>Remember me</label>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                            <div class="form-group sign-btn">
                                <input type="submit" class="btn" value="Log in">
                                <p><a href="#" class="forgot">Can't access your account?</a></p>
                                <p><strong>New to USM_Social_Network?</strong><br><a href="#" id="flip-btn"
                                                                                     class="signup signup_link">Sign up
                                    for a new
                                    account</a></p>
                            </div>


                            <div class="back signup_form" style="opacity: 0;">
                                <p>Sign Up for Your New Account</p>
                                <form class="login-form">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Username">
                                            <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-user"></i>
                                      </span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" class="form-control">
                                            <span class="input-group-btn"><button type="button"
                                                                                  class="btn btn-cyan"><span
                                                    class="fa fa-refresh"></span></button></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="password" class="form-control" placeholder="Confirm Password">
                                            <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-lock"></i>
                                      </span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="email" class="form-control" placeholder="Email">
                                            <span class="input-group-addon">
                                          <i class="glyphicon glyphicon-envelope"></i>
                                      </span>
                                        </div>
                                    </div>

                                    <div class="form-group sign-btn">
                                        <input type="submit" class="btn" value="Sign up">
                                        <br><br>
                                        <p>You have already Account So <a href="#" id="unflip-btn" class="signup">Log
                                            in</a></p>
                                    </div>
                                </form>
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Flip/1.0.18/jquery.flip.js"></script>

</body>
</html>