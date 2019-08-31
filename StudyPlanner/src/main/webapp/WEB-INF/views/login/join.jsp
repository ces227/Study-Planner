<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/inCheck1.js"></script>
<script>

function check(){
	
	if (pCheck== true && p2Check==true && idcheck==true){
		return true;
	} else {
		alert('아이디와 패스워드를 확인해 주세요!');
		return false;
	}	
}

function idDupCheck() {
	
	if (idcheck==false) return ;
	var url='idcheck?id='+$('#id').val();
	window.open(url,"_blank"
		,"toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=450,height=300");
};

//???

$(function() {
	$('#id').change(function() {
		document.getElementById('idDupcheck').disabled="disabled";
	})
});

</script>
</head>
<body>
<h3 align="center">회원가입</h3>
<hr style="border-style:dotted">
<div align="center">
<form action="studentInsert" method="post">
<table>
	<tr>
		<td>id</td>
		<td><input type="text" id="id" name="id" placeholder="aaa@aaa.aa">
		<input type="button" value="ID 중복확인" onclick="idDupCheck()"><br>
		<span id="idMessage"></span>
		</td>
	</tr>
	<tr>
		<td>password</td>
		<td><input type="password" id="password" name="password"><br>
			<span id="pMessage"></span>
		</td>
	</tr>
	<tr>
		<td>password2</td>
		<td><input type="password" id="password2" name="password2"><br>
			<span id="p2Message"></span>
		</td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type="text" id="name" name="name" value="홍길동">
		</td>
	</tr>
	<tr>
		<td>level</td>
		<td>
			<select name="lev" id="lev">
				<option value="A">공시생</option>
				<option value="B">대학생</option>
				<option value="C">중·고생</option>
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="reset" value="재작성">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="가입하기" disabled="disabled" id="idDupcheck" onclick="return check()">
		</td>
	</tr>
	<tr>
		<td></td>
		<td align="center">
			<input type="button" value="홈으로" onclick="location.href='home'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>