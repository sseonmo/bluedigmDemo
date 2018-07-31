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

	$(document).ready(function() {
		
		$("#commonCodeTree").dynatree({
			rootVisible: true,
	        initAjax: {
	        	url: "/api/commonCode/searchCommonGroupCodeList"
	        },
	        onActivate : function(node) {
	        	console.log(node);
	        	bindTable(node.data.originObject);
	        },
	        onLazyRead: function(node){
	        	node.appendAjax({
	        		url: "/api/commonCode/searchCommonCodeListByGrpCd",
	               	data: {
	               		"grpCdId": node.data.key
	                }
	            });
	        }
	    });
	      
	 });
	
	var commonGroupCode = {
			
		searchList: function() {
			$.ajax({
				url: "/api/commonCode/searchCommonGroupCodeList",
				type: "GET",
				dataType: "json",
				success: function(data) {
					console.log(data);
				}
			});
		}
		,
		
		searchDetail: function(grpCdId) {
			$.ajax({
				url: "/api/commonCode/searchCommonGroupCodeDetail",
				data: { "grpCdId" : grpCdId },
				type: "GET",
				dataType: "json",
				success: function(data) {
					console.log(data);
				}
			});
		}
		
	}
	
	var commonCode = {
			
			searchListByGrpCd: function(grpCdId) {
				$.ajax({
					url: "/api/commonCode/searchCommonCodeListByGrpCd",
					data: { "grpCdId" : grpCdId },
					type: "GET",
					dataType: "json",
					success: function(data) {
						console.log(data);
					}
				});
			}
		}
	
	// dynatree 타입으로 변환
	function convertToTreeType(key, title, data) {
		console.log(JSON.stringify(convertedJson));
		var convertedJson = new Array();
		var convertedData = null;
		
		data.forEach(function(item) {
			convertedData = {
					"key" : item[key],
					"title" : item[title]
			}
			convertedJson.push(convertedData);
		});
		
		return JSON.stringify(convertedJson);
	}
	
	function bindTable(data) {
		$('input').each(function (index, value) { 
			$(this).val(data[$(this).attr('id')]);
		});

		if(data.hasOwnProperty("grpCdObject")) {
			$("#grpCd").val(data.grpCdObject.grpCd);
			$("#grpCdNm").val(data.grpCdObject.grpCdNm);
			$("#grpCdExplnatn").val(data.grpCdObject.grpCdExplnatn);
		}
	}
	
</script>
</head>
<body>
	<div>Common Code</div>
	<div id="commonCodeTree" style="float: left;"></div>
	<div id="commonCodeForm" style="float: left;">
		<table style="border: 1px solid black;">
			<tr>
				<th>그룹코드값</th>
				<td><input id="grpCd"/></td>
			</tr>
			<tr>
				<th>그룹코드이름</th>
				<td><input id="grpCdNm"/></td>
			</tr>
			<tr>
				<th>그룹코드설명</th>
				<td><input id="grpCdExplnatn"/></td>
			</tr>
			<tr>
				<th>코드값</th>
				<td><input id="cd"/></td>
			</tr>
			<tr>
				<th>코드이름</th>
				<td><input id="cdNm"/></td>
			</tr>
			<tr>
				<th>코드설명</th>
				<td><input id="cdExplnatn"/></td>
			</tr>
			<tr>
				<th>코드정렬번호</th>
				<td><input id="cdOrdNum"/></td>
			</tr>
			<tr>
				<th>코드사용여부</th>
				<td><input id="cdUseYn"/></td>
			</tr>
			<tr>
				<th>생성자</th>
				<td><input id="corId"/></td>
			</tr>
			<tr>
				<th>생성 일시</th>
				<td><input id="crtDt"/></td>
			</tr>
			<tr>
				<th>수정자</th>
				<td><input id="morId"/></td>
			</tr>
			<tr>
				<th>수정 일시</th>
				<td><input id="mdfDt"/></td>
			</tr>
		</table>
	</div>
</body>
</html>




