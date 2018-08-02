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

<style>  
table { display:block; table-layout:fixed; border-collapse:collapse; width:100%; height:100%; } 
th, td { border:1px solid grey; }
thead { width:100%; }
tbody { display:block; overflow:auto; width:100%; max-height:95%; }
</style>

<link href="/resources/css/ui.dynatree.css" rel="stylesheet"
	type="text/css">
<script src="/resources/js/jquery.dynatree.min.js"
	type="text/javascript"></script>

<!-- Add code to initialize the tree when the document is loaded: -->
<script type="text/javascript">

	$(document).ready(function() {
		// 공통 그룹 코드 리스트 바인딩
		commonGroupCode.searchList();
		
		// 공통 그룹 코드 추가 버튼 클릭 시
		$("#btnAddComGrpCd").click(function(){
			bindComGrpCdList();
		});
		
		// 공통 그룹 코드 삭제 버튼 클릭 시
		$("#btnDeleteComGrpCd").click(function(){
			var delGrpCdIdList = [];
			$("input[name=chkGrpCd]:checked").each(function (index) {  
				delGrpCdIdList.push($(this).val());  
		    });  
			commonGroupCode.delete(delGrpCdIdList);
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
			}).done(bindComGrpCdList);
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
		,
		
		register: function() {
			var params = '';
			$('#commonCodeTable input').each(function (index, value) { 
				params += '"' + $(this).attr('id') + '" : "' + $(this).val() + '" ,';
			});
			params = params.slice(0, -1);
			$.ajax({
				url: "/api/commonCode/registerCommonGroupCode",
				data: { 
					"grpCdId" : "TEST",
					"grpCd" : $("#grpCd").val(),
					"grpCdNm" : $("#grpCdNm").val(),
					"grpCdExplnatn" : $("#grpCdExplnatn").val(),
					"corId" : "AYEON",
					"morId" : "AYEON"
				}, 
				type: "POST",
				dataType: "json",
				success: function(data) {
					console.log(data);
				    var activeNode = $("#commonCodeTree").dynatree("getActiveNode");
					var childNode = activeNode.addChild({
						key: "TEST",
					    title: $("#grpCdNm").val(),
					    isFolder: true
					});
				}
			});
		}
		,
		
		modify: function() {
			var params = '';
			$('#commonCodeTable input').each(function (index, value) { 
				params += '"' + $(this).attr('id') + '" : "' + $(this).val() + '" ,';
			});
			params = params.slice(0, -1);
			$.ajax({
				url: "/api/commonCode/modifyCommonGroupCode",
				data: { 
					"grpCdId" : $("#grpCdId").val(),
					"grpCd" : $("#grpCd").val(),
					"grpCdNm" : $("#grpCdNm").val(),
					"grpCdExplnatn" : $("#grpCdExplnatn").val(),
					"corId" : "AYEON",
					"morId" : "AYEON"
				}, 
				type: "POST",
				dataType: "json",
				success: function(data) {
					console.log(data);
				}
			});
		}
		,
		
		delete: function(grpCdIdList) {
			// ajax 배열 통신을 위한 jquery 직렬화 옵션 세팅 
			jQuery.ajaxSettings.traditional = true;

			$.ajax({
				url: "/api/commonCode/deleteCommonGroupCode",
				data: { "grpCdIdList" : grpCdIdList }, 
				type: "POST",
				dataType: "json",
				success: function(data) {
					$.each(grpCdIdList, function(index, item) {
						console.log(item);
						$("#"+item).closest("tr").remove();
					});
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
			,
			
			register: function() {
				var params = '';
				$('#commonCodeTable input').each(function (index, value) { 
					params += '"' + $(this).attr('id') + '" : "' + $(this).val() + '" ,';
				});
				params = params.slice(0, -1);
				$.ajax({
					url: "/api/commonCode/registerCommonCode",
					data: { 
						"grpCdId" : $("#grpCdId").val(),
						"cd" : $("#cd").val(),
						"cdId" : "TEST",
						"cdNm" : $("#cdNm").val(),
						"cdExplnatn" : $("#cdExplnatn").val(),
						"corId" : "AYEON",
						"morId" : "AYEON"
					}, 
					type: "POST",
					dataType: "json",
					success: function(data) {
						console.log(data);
					    //$("#commonCodeTree").dynatree("getTree").reload();
					    var activeNode = $("#commonCodeTree").dynatree("getActiveNode");
						var childNode = activeNode.addChild({
							key: "TEST",
						    title: $("#cdNm").val(),
						});
					    $("#commonCodeTree").dynatree("getTree").selectKey("TEST");
					}
				});
			}
			,
			
			modify: function() {
				var params = '';
				$('#commonCodeTable input').each(function (index, value) { 
					params += '"' + $(this).attr('id') + '" : "' + $(this).val() + '" ,';
				});
				params = params.slice(0, -1);
				$.ajax({
					url: "/api/commonCode/modifyCommonCode",
					data: { 
						"grpCdId" : $("#grpCdId").val(),
						"cd" : $("#cd").val(),
						"cdId" : $("#cdId").val(),
						"cdNm" : $("#cdNm").val(),
						"cdExplnatn" : $("#cdExplnatn").val(),
						"corId" : "AYEON",
						"morId" : "AYEON"
					}, 
					type: "POST",
					dataType: "json",
					success: function(data) {
						console.log(data);
					}
				});
			}
		}
	
	function bindComGrpCdList(data) {
		var html = "";
		
		if(data == null) {
			data = [{ grpCdId : "", grpCd : "", grpCdNm : "", grpCdExplnatn : ""}];
		} 
		$.each(data, function(index, item){ 
			if(item.grpCdId == null) 		{ item.grpCdId = ""; 		}
			if(item.grpCd == null)  		{ item.grpCd = ""; 			}
			if(item.grpCdNm == null) 		{ item.grpCdNm = ""; 		}
			if(item.grpCdExplnatn == null) 	{ item.grpCdExplnatn = ""; 	}
			
			html += "<tr>"
				 +		"<td>"
				 +			"<input type='checkbox' name='chkGrpCd' id='" + item.grpCdId + "' value='" + item.grpCdId + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCd' value='" + item.grpCd + "'/>"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCdNm' value='" + item.grpCdNm + "'/>"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCdExplnatn' value='" + item.grpCdExplnatn + "'/>"
				 +		"</td>"
				 +	"</tr>";
		});
		
		$('#listCommonGroupCode').prepend(html);
	}
	
</script>
</head>
<body>
	<div id="areaHeaderText" style="text-align: center; width: 100%; height:10vh; margin:auto; border:1px solid black;">
		<h1>공통 코드 관리</h1>
	</div>
	<div id="areaSearchCode" style="text-align: center; width: 100%; height:5vh; border:1px solid black;">
		<select style="width:200px;">
			<option>공통 그룹 코드</option>
			<option>공통  코드</option>
		</select>
		<select style="width:200px;">
			<option></option>
		</select>
		<input />
		<button>검색</button>
	</div>
	<div id="areaCommonGroupCode" style="float: left; width: 49.5%; height:80vh; border:1px solid black;">
		<div id="headerCommonGroupCode" style="width:100%; height:5%";>
			<h3 style="float:left; margin:3px;">공통 그룹 코드</h3>
			<div class="btnGroup" style="float:right; margin:6px;">
				<button id="btnAddComGrpCd">추가</button>
				<button>저장</button>
				<button id="btnDeleteComGrpCd">삭제</button>
			</div>
		</div>
		<div id="tableCommonGroupCode" style="display:inline-block; width:100%; height:90%;">
			<table>
				<colgroup>
				    <col width="5%" />
				    <col width="15%" />
				    <col width="40%" />
				    <col width="40%" />
			  	</colgroup>
				<thead>
					<tr>
						<th>선택</th>
						<th>그룹 코드값</th>
						<th>그룹 코드명</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody id="listCommonGroupCode">
				</tbody>
			</table>
		</div>
	</div>
	<div id="areaCommonCode" style="float: right; width: 49.5%; height:80vh; border:1px solid black;">
		<div id="headerCommonCode">
			<h3 style="float:left; margin:3px;">공통 코드</h3>
			<div class="btnGroup" style="float:right; margin:6px;">
				<button>추가</button>
				<button>저장</button>
				<button>삭제</button>
			</div>
		</div>
		<div id="tableCommonGroupCode">
			<table>
				<thead>
					<tr>
						<th>선택</th>
						<th>코드값</th>
						<th>코드명</th>
						<th>설명</th>
						<th>정렬 번호</th>
						<th>사용 여부</th>
						<th>참조 코드</th>
					</tr>
				</thead>
				<tbody id="listCommonCode">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>




