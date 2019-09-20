<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Line_Controls_Chart</title>
 
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <!-- google charts -->
       <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  </head>
  <body>
 
    <h4>사이트 방문자 성별 현황 그래프</h4>
<c:forEach var="kkkk" items="${graphData}" varStatus="vs">
	<input type="hidden" id="seq${vs.index}" value="${kkkk.seq}">
	<input type="hidden" id="exam_date${vs.index}" value="${kkkk.exam_date}">
    <input type="hidden" id="exam_name${vs.index}" value="${kkkk.exam_name}">	
    <input type="hidden" id="exam_subject${vs.index}" value="${kkkk.exam_subject}">	
    <input type="hidden" id="exam_grade${vs.index}" value="${kkkk.exam_grade}">	
</c:forEach>
    <div id="Line_Controls_Chart">
   <select name="">
   <c:forEach var="s" items="${subject}">
    <option value="${s.exam_subject}" id=>${s.exam_subject}</option>
   </c:forEach>
</select>
      <!-- 라인 차트 생성할 영역 -->
          <div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
      <!-- 컨트롤바를 생성할 영역 -->
          <div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
     </div>
 
  </body>
 
  <script>
 
  var chartDrowFun = {
 
    chartDrow : function(){
        var chartData = '';
 
        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat     = 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount    = 10;
 
 
        function drawDashboard() {
 
          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          var subject =[];
          var unique_subject =[];
          var grade= []; //점수 데이터
          var date =[]; //날짜데이터
          var unique_date =[]; //중복없는 날짜 데이터
          
          for(var i = 0; i < ${size}; i++){
        	  subject[i]=''+$('#exam_subject'+i).val();
          }
          $.each(subject, function(i, el){
        		if($.inArray(el, unique_subject) === -1) unique_subject.push(el);
        		});
          
          data.addColumn('datetime' , '날짜');
          for (var i = 0; i < unique_subject.length ; i++) {
          data.addColumn('number',unique_subject[i]);
		}
          
 
 
          for(var i = 0; i < ${size}; i++){ 
        	  grade[i] = ($('#exam_grade'+i).val()) * 1;
          	  var tmpdate = ''+$('#exam_date'+i).val();
          	  
          	  var yyyy = tmpdate.substr(0,4);
          	  var mm = tmpdate.substr(5,2);
          	  var dd = tmpdate.substr(8,2);                        
          	  var com_ymd = new Date(yyyy, mm-1, dd);
          	  date[i] = com_ymd;
          }
          $.each(date, function(i, el){
      		if($.inArray(el, unique_date) === -1) unique_date.push(el);
      		});

          
          
          for (var data_count = 0 ; data_count < ${size}; data_count++ ){   //전체 데이터for문
          	var dataRow = new Array(unique_subject+1); //넣어줄 데이터
          	for (var i = 0; i < dataRow.length; i++) {
          		dataRow[i]=null;
			}
          	console.log(dataRow);
        	dataRow[0]= date[data_count]; //0번지에 날짜
        		for (var j = 0; j < unique_subject.length; j++) {
        	  		if(subject[data_count]==unique_subject[j]){
        		  		dataRow[j+1]=grade[data_count];
        	  	}
			}
          	console.log(dataRow);
          	console.log("@@@@@@@@@@");
          	data.addRow(dataRow);
          }
          
          
          
          for (var tmp = 0 ; i < unique_subject.length+1 ; i++){
        	  dataRow[tmp]=null;
          }
        	  dataRow[0]=data[i];
        	  

          
 
 
            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height          : 500,
                              width              : '100%',
                              legend          : { position: "top", textStyle: {fontSize: 13}},
                              pointSize        : 5,
                              tooltip          : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis              : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']}}
                                                                },textStyle: {fontSize:12}},
                vAxis              : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation        : {startup: true,duration: 1000,easing: 'in' },
                annotations    : {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });
 
            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 80},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });
 
            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);
 
            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);
 
        }
          google.charts.setOnLoadCallback(drawDashboard);
 
      }
    }
 
$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
  chartDrowFun.chartDrow(); //chartDrow() 실행
});
  </script>
</html>


