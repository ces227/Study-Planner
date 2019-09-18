<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 작성</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		// ** 게시글 목록으로 이동 - 버튼 클릭시 상세보기화면에 있던 페이지, 검색옵션, 키워드 값을 가지로 목록으로 이동
		$("#btnList").click(function(){
			location.href="http://localhost:9090/green/board/list?curPage=${curPage}&searchOption=${searchOption}&keyword=${keyword}";
		});
		
		$("#btnSave").click(function(){
			if(title==""){
				alert("제목을 입력하세요");
				document.form1.title.focus();
				return;
			}
			if(content==""){
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			document.form1.submit();
		});
	});
</script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


</head>
<body>
<form name="form1" method="post" action="insert">
	<div align="center">
		제목 	<input name="title" id="title" size="80">
		<!-- 작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> -->
	</div>
	<div align="center">
		내용	<textarea name="content" id="content" rows="4" cols="80"></textarea>
	</div>
	<div align="center">
		이름
		<input name=writer id="writer" value="${dto.userName}">
	</div>
	<div style="width:650px; text-align:center;">
		<!-- 게시물번호를 hidden으로 처리 -->
		<input type="submit" value="등록" class="btn btn-info btn-md">
		<button type="button" id="btnList" class="btn btn-info btn-md">목록</button>
		<button type="reset" class="btn btn-info btn-md">취소</button>
	</div>
</form>
</body>
</html>








