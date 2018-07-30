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

<link href="/resources/css/ui.dynatree.css" rel="stylesheet"
	type="text/css">
<script src="/resources/js/jquery.dynatree.min.js"
	type="text/javascript"></script>

<!-- Add code to initialize the tree when the document is loaded: -->
<script type="text/javascript">
	
	var commonGroupCodeList;

	$(document).ready(function() {
		
		$("#commonCodeTree").dynatree({
			initAjax: {
	            url: "/api/commonCode/selectCommonGroupCodeList",
	            data: {
	            	key: "root",
	            	mode: "all"
	            }
		    },
			onActivate : function(node) {
			}
		});
		
	});
	
	var commonGroupCode = {
		searchList: function() {
			$.ajax({
				url: "/api/commonCode/selectCommonGroupCodeList",
				type: "GET",
				dataType: "json",
				success: function(data) {
					return data;
				}
			});
		}
	}
	
	function convertToTreeType(data) {
		
	}
	
</script>
</head>
<body>
	<div>Common Code</div>
	<div id="commonCodeTree"></div>
	<div id="commonCodeForm"></div>
</body>
</html>




