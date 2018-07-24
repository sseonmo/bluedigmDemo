
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
		<div>
			<ul>
				<li><a href="#none" id="apiSample">api/sample</a></li>
			</ul>
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
		});
	</script>
</html>




