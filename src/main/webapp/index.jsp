<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Test</title>

    <!-- CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/form-elements.css">
    <link rel="stylesheet" href="/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="/imgs/favicon.png">

</head>

<body ng-app="myApp">

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Login</strong> Test</h1>
                    <div class="description">
                        <p>
                            This is a test login form made with Java spring.
                            Download it on <a href="https://github.com/tw-toc/test" target="_blank"><strong>Github</strong></a>!
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                    </div>
                    <div class="form-bottom" ng-controller="LoginForm">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="userName" ng-model="userName" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="pwd" ng-model="pwd" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn" style="width: 45%;" ng-click="submit()"/>Sign in</button>
                            <button class="btn" style="float: right;width: 45%;" ng-click="register()"/>Register</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>Follow me:</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#">
                            Weixin
                        </a>
                        <a class="btn btn-link-2" href="#">
                            QQ
                        </a>
                        <a class="btn btn-link-2" href="#">
                            Blog
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Javascript -->
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<!-- <script src="/js/scripts.js"></script> -->

<!--[if lt IE 10]>
<script src="/js/placeholder.js"></script>
<![endif]-->
<script src="/js/angular.min.js"></script>

<script>
angular.module("myApp", []).controller("LoginForm", function($scope,$http) {

    $scope.resetInfo=function() {
        $scope.userName="";
        $scope.pwd="";
    }

    $scope.submit=function() {

        var url ="/login/" + $scope.userName + "/" + $scope.pwd;

        $http.post(url).then(function(data) {
            console.log(data.data);
            if(data.data) {
               window.location.href= 'users.jsp';
            } else{
               //window.location.href= 'error.html';
            }
        });
    }
});
</script>
<div class="backstretch" style="left: 0px; top: 0px; margin: 0px; padding: 0px; height: 691px; width: 1289px; z-index: -999999; position: fixed;">
    <img src="/imgs/1.jpg" style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1289px; height: 859.333px; max-height: none; max-width: none; z-index: -999999; left: 0px; top: -84.1667px;">
</div>
</body>
</html>
