<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Form **</title>
<style type="text/css">
    @import url("csslib/login.css");
</style>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/login.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<div id="login">
		<div class="container">
			<div id="login-row" class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
					 <img src="resources/image/banana2.gif" id="logo">
						<form id="login-form" class="form" action="login" method="post">
							<h3 class="text-center text-info">스터디플래너</h3>
							<div class="form-group">
								<!--          이메일 @도메인 처리하는 것에 대해 생각해봐야함                                     -->
								<!--          맵퍼 +                                      -->
								<label for="username" class="text-info">Email:</label><br>
								<input type="text" name="id" id="id" class="form-control">
								<tr><span id=iMessage></span></td>
							</div>
							<div class="form-group">
								<!--          비밀번호 처리하는 것에 대해 생각해봐야함                                     -->
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password" class="form-control">
								<tr><span id=pMessage></span></td>
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info">
									<span>이메일 기억하기</span>
									<span>
										<input id="remember-me" name="remember-me" type="checkbox">
									</span>
								</label><br>
								</div>
							
							<input type="submit" name="submit" disabled="disabled" id='loginDisabled' class="btn btn-info btn-md" value="로그인">
							<input type="button" class="btn btn-info btn-md" onclick="location.href='termsf'" value="회원가입">
							<div id="register-link" class="text-right">
								<a href="find_pw_form" class="text-info" id="find_pw_btn">비밀번호 찾기</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>