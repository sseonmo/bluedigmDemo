
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
		<title>Hello HTML</title>
	</head>
	<body>
		<div> Demo</div>
		<br>
		<div>
			<div> 메뉴</div>
			<div>
				<input type="button" id="viewCode" value="공통코드"/>
				<input type="button" id="viewMenu" value="메뉴"/>
			</div>

			<br>
			<div>RestController Call</div>
			<input type="button" id="apiSample" value="RestController Call" />

			<br><br>
			<div>서버 메세지처리</div>
			<div><input type="button" id="messageTest" value="ExceptionHtml"/></div>

			<br>
			<div> 사용자 예외처리</div>
			<div>
				<input type="button" id="exceptionHtml" value="ExceptionHtml"/>
				<input type="button" id="exceptionHtml2" value="ExceptionHtml2"/>
				<input type="button" id="exceptionJson" value="ExceptionJson"/>
			</div>

			<br>
			<div> mybatis - handler</div>
			<div>
				<input type="button" id="booleanHeadler" value="boolean headler"/>  convert - select( Y / N => true/false ) / insert( true/false => Y / N )
			</div>

			<br>
			<div> xssFilter</div>
			<div>
				<input type="text" id="xssFilterText" placeholder="xss filter" value="<script>alert('@@@')</script>"/><input type="button" id="xssFilterBtn" value="GO"/>
				<br>
				<br>
				<div>
					xss filter result
					<ul>
						<li><input type="text" id="xssResultInput" placeholder="xss filter" /></li>
						<li id="xssResultP1"></li>
						<li id="xssResultP2"></li>
					</ul>
				</div>
			</div>

			<br>
			<div> 로그인 사용자 정보 </div>
			<div>
				<input type="button" id="loginUserInfo" value="loginUserInfo"/>
			</div>
		</div>
		<br>
		<div>Result Area</div>
		<div id="resultArea">

		</div>
	</body>

	<script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js" ></script>
	<script>

		$(document).ready(function(){

			$("#apiSample").on('click', function() {

				$.ajax({
					url:'/api/sample',
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#resultArea').html(JSON.stringify(data));
					}
				})
			});

			$("#messageTest").on('click', function() {

				$.ajax({
					url:'/api/sample/messageTest',
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#resultArea').html(data);
					}
				})
			});

			$("#exceptionHtml").on('click', function() {
				location.href = "/system/sample/exceptionHtml";
			});
			$("#exceptionHtml2").on('click', function() {
				location.href = "/system/sample/exceptionHtml2";
			});

			$("#exceptionJson").on('click', function() {

				$.ajax({
					url:'/api/sample/exceptionJson',
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#resultArea').html(JSON.stringify(data));
					}
				})
			});

			$("#booleanHeadler").on('click', function() {

				$.ajax({
					url:'/api/sample/booleanHandlerTest',
					type:'POST',
					dataType:'json',
					success:function(data){
						$('#resultArea').html(JSON.stringify(data));
					}
				})
			});


			$("#viewCode").on('click', function() {
				location.href = "/system/commonCode";
			});
			$("#viewMenu").on('click', function() {
				location.href = "/system/menu/menu";
			});

			$("#xssFilterBtn").on('click', function() {

				$.ajax({
					url:'/api/sample/xssFilter',
					type:'GET',
					data : { testText : $("#xssFilterText").val() },
					dataType:'json',
					success:function(data){
						$("#xssResultP1").html(data);
						$("#xssResultP2").text(data);
						$("#xssResultInput").val($("#xssResultP1").html());

					}
				})

			});

			$("#loginUserInfo").on('click', function() {
				$.ajax({
					url:'/api/sample/loginUserInfo',
					type:'GET',
					dataType:'json',
					success:function(data){
						$('#resultArea').html(JSON.stringify(data));
					}
				})
			});


		});
	</script>
</html>




