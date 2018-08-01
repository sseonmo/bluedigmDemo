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
		
		$("#btnAddCommonCode").click(function(){
		      // Sample: add an hierarchic branch using code.
		      // This is how we would add tree nodes programatically
		      var activeNode = $("#commonCodeTree").dynatree("getActiveNode");
				
				if(activeNode.childList != null) {
					$("#btnRegisterCommonCode").css("display", "block");
					$("#btnModifyCommonCode").css("display", "none");
					$("#inputCommonCode input").val("");
					$("#inputUserInfo input").val("");
					
					if(activeNode.data.title == "root") {
						$("#inputCommonGroupCode input").val("");
						$("#inputCommonCode input").attr("readOnly", "readOnly");
					} else {
						$("#inputCommonGroupCode input").attr("readOnly", "readOnly");
					}
				}
		});
		
		$("#btnRegisterCommonCode").click(function(){
			var activeNode = $("#commonCodeTree").dynatree("getActiveNode");
			if(activeNode.data.title == "root") {
				commonGroupCode.register();
			} else {
				commonCode.register();
			}

			$("#btnRegisterCommonCode").css("display", "none");
			$("#btnModifyCommonCode").css("display", "block");
		});
		
		$("#btnModifyCommonCode").click(function(){
			var activeNode = $("#commonCodeTree").dynatree("getActiveNode");
			if(activeNode.childList != null) {
				commonGroupCode.modify();
			} else {
				commonCode.modify();
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
		$('#commonCodeTable input').each(function (index, value) { 
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
	<div id="commonCodeContent" style="float: left;">
		<form id="commonCodeForm" >
		<table id="commonCodeTable" style="border: 1px solid black;">
			<thead id="inputCommonGroupCode">
				<tr>
					<th></th>
					<td><input type="hidden" id="grpCdId"/></td>
				</tr>
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
			</thead>
			<thead id="inputCommonCode">
				<tr>
					<th></th>
					<td><input type="hidden" id="cdId"/></td>
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
			</thead>
			<thead id="inputUserInfo">
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
			</thead>
		</table>
		<input type="button" id="btnAddCommonCode" value="추가"/>
		<input type="submit" id="btnRegisterCommonCode" style="display:none;" value="등록"/>
		<input type="button" id="btnModifyCommonCode" value="수정"/>
		<input type="button" id="btnRemoveCommonCode" value="삭제"/>
		</form>
	</div>
</body>
</html>




