<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<title>Common Code Page</title>
<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/resources/js/jquery-ui.custom.js" type="text/javascript"></script>
<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>

<link href="/resources/css/ui.dynatree.css" rel="stylesheet" type="text/css">
<script src="/resources/js/jquery.dynatree.min.js"
	type="text/javascript"></script>

<!-- Add code to initialize the tree when the document is loaded: -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#tree").dynatree({
			initAjax: {
	            url: "/api/sample/selectCommonCode",
	            data: { mode: "funnyMode" }
            },
			onActivate : function(node) {
				// A DynaTreeNode object is passed to the activation handler
				// Note: we also get this event, if persistence is on, and the page is reloaded.
				alert("You activated " + node.data.title);
			},
			persist : true,
			children : [ // Pass an array of nodes.
			{
				title : "Item 1"
			}, {
				title : "Folder 2",
				isFolder : true,
				children : [ {
					title : "Sub-item 2.1"
				}, {
					title : "Sub-item 2.2"
				} ]
			}, {
				title : "Item 3"
			} ]
		});

		$("#apiSample").on('click', function() {

			$.ajax({
				url : '/api/sample',
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					$('#resultArea').html(JSON.stringify(data));
				}
			})

		});
	});
</script>
</head>
<body>
	<div>Common Code</div>
	<div>
		<ul>
			<li><a href="#none" id="apiSample">api/sample</a></li>
		</ul>
	</div>
	<br>
	<div>Result Area</div>
	<div id="tree"></div>
</body>
</html>




