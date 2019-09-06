<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/csslib/index.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="resources/jsLib/index.js"></script>
   <title>Study Planner</title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li class='active'><a href='#'>Home</a></li>
   <li><a href='#'>캘린더</a></li>
   <li><a href='#'>그래프</a></li>
   <li><a href='http://localhost:9090/green/studentDetail' target="section">내 정보</a></li>
   <li><a href='http://www.career.go.kr/cnet/iframe/MajorDic.do?apiKey=8b3617461e2979d61e0ab5749928e610&gubun=univDic' target="section">학과 정보</a></li>
   <li><a href='http://localhost:9090/green/siteIntro' target="section">만든 사람들</a></li>
</ul>
<br>
<br>
<br>
</div>
<div class=clear_both></div>
<div class=main>
	<iframe name=section id=section frameborder="0" width="100%" height="1000px" marginwidth="0" marginheight="0"></iframe>
</div>
<div class=clear_both></div>
</body>
</html>
