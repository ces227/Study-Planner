<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 추가하기</title>

<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/jquery.js"></script>
<script src="resources/jsLib/jquery.ajaxQueue.js"></script>
<script src="resources/jsLib/jquery.autocomplete.js"></script>
<script src="resources/jsLib/jquery.bgiframe.min.js"></script>
<script src="resources/jsLib/insertgraph.js"></script>
<link href="resources/jsLib/jquery.autocomplete.css" rel="stylesheet"/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery.min.js"></script>

<script>
$(function() { 
	$("#add").click(function () { 

		var row = '<tr><td></td><td><input type="date" name="exam_date" class="form-control"></td>'+
		 '<td><input type="text" name="exam_name" class="form-control" width="60px" placeholder="시험 이름"></td>'+
		 '<td><input type="text" name="exam_subject" class="form-control" placeholder="시험 과목"></td>'+
		  '<td><input type="text" name="exam_grade" class="form-control" width="20px" placeholder="점수·등급"></td>'+
		  '<td><button class="btn btn-default" name="delStaff">삭제</button></td></tr>'; 
	
		  $("#addTable").append(row); 
		
	}); 
	
	$(document).on("click","button[name=delStaff]",function(){
        
        var trHtml = $(this).parent().parent();
         
        trHtml.remove(); //tr 테그 삭제
         
    });
});

</script>
<style type="text/css">

</style>
</head>
<body>
<header>

</header>

<c:if test="${detailCheck=='S'}">
	<script>
		alert("정보 수정에 성공했습니다!")	
	</script>
</c:if>
<c:if test="${detailCheck=='F'}">
	<script>
		alert("정보 수정에 실패했습니다")	
	</script>
</c:if>
<p>
<br>
<h3 class="text-center text-info">성적 추가하기</h3>
</p>
	<div id="login">
		<div class="container">
			<div id="login-row" class="row justify-content-center align-items-center">
<form action="" method="post">
<table id="addTable" style="margin-left: auto; margin-right: auto;">

<c:if test="${Ggraphempty=='True'}">
<h4 class="text-center text-info">데이터를 추가해주세요!</h4>
</c:if>
<tr height="30">
<td></td><td class="text-info">시험 날짜</td><td class="text-info">시험 이름</td><td class="text-info">시험 과목</td><td class="text-info">점수·등급</td>
</tr>

<c:forEach var="score" items="${Ggraph}">
<tr>
<td>
<input type="hidden" name="seq" value="${score.seq}" readonly="readonly" class="form-control">
</td>
<td>
<input type="date" name="exam_date" value="${score.exam_date}" class="form-control">
</td>
<td>
<input type="text" name="exam_name" value="${score.exam_name}" class="form-control" width="60px">
</td>
<td>
<input type="text" name="exam_subject" id="exam_subject" value="${score.exam_subject}" class="form-control">
</td>
<td>
<input type="text" name="exam_grade" value="${score.exam_grade}" class="form-control" width="20px">
</td>
<td>
<button class="btn btn-default" name="delStaff">삭제</button>
</td>
</tr>
</c:forEach>
<!-- 여기까지 -->

</table>

<br>
<button type="button" class="btn btn-info btn-md" id="add" style="margin-left: 50%;">추가</button>
<br>
<input type="submit" value="수정하기" class="btn btn-info btn-md">
</form>
			</div>
		</div>
	</div>
<br>
     
</body>
</html>