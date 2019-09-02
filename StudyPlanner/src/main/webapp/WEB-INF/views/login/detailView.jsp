<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/inCheck1.js"></script>
</head>
<body>
<h3>회원 상세 정보</h3>
<!-- 테스트용 수정하기 -->
<form action="studentUpdate" method="post">
<table>

<tr height="40"><td>I D</td>
	<td><input type="text" name="id" value="${student.id}" readonly="readonly"></td></tr>
	
<tr height="40"><td>인증여부</td>
	<td>
		<c:when test="${student.lev=='1'}">
			<input type="text" name="seq" value="이메일 인증 완료" readonly="readonly">
		</c:when>
		<c:otherwise>
			<input type="text" name="seq" value="이메일 인증 미완료" readonly="readonly">
		</c:otherwise>
	</td>
</tr>

	
<tr height="40"><td>Password</td>
	<td><input type="password" name="password" id="password" value="${student.password}"><br>
	<span id="pMessage"></span></td>
</tr>

<tr height="40"><td>Password2</td>
	<td><input type="password" name="password2" id="password2" value="${student.password}"><br>
	<span id="p2Message"></span></td>
</tr>

	
<tr height="40"><td>Name</td>
	<td><input type="text" name="name" value="${student.name}"></td></tr>
	
<tr height="40"><td>회원</td>
	<td>
	<c:choose>
		<c:when test="${student.lev=='A'}">
			<select name="lev">
				<option value="A" selected="selected">공시생</option>
				<option value="B">대학생</option>
				<option value="C">중고생</option>
			</select>
		</c:when>
		<c:when test="${student.lev=='B'}">
			<select name="lev">
				<option value="A">공시생</option>
				<option value="B" selected="selected">대학생</option>
				<option value="C">중고생</option>
			</select>
		</c:when>
		<c:when test="${student.lev=='C'}">
			<select name="lev">
				<option value="A">공시생</option>
				<option value="B">대학생</option>
				<option value="C" selected="selected">중고생</option>
			</select>
		</c:when>
	</c:choose>
	</td>
</tr>

<tr><td></td>
	<td><br><input type="submit" value="Submit">
            <input type="reset" value="Reset"></td>	
</table>
</form>
<br>
     
</body>
</html>