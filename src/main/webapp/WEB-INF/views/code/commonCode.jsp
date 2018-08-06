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
table { display:block; table-layout:fixed; border-collapse:collapse; word-break:break-all; width:100%; height:100%; } 
th, td { border:1px solid grey; padding: 0 6px 0 2px; align:center; }
tbody tr:hover { background:grey; }
thead { width:100%; }
tbody { overflow:auto; width:100%; max-height:95%; }
input { width:100%; }
.modify { background:yellow; }
.register { background:green; }
.check { background:blue; }
.click { background:black; }
</style>

<link href="/resources/css/ui.dynatree.css" rel="stylesheet"
	type="text/css">
<script src="/resources/js/jquery.dynatree.min.js"
	type="text/javascript"></script>

<!-- Add code to initialize the tree when the document is loaded: -->
<script type="text/javascript">

	var insertedCnt = 0;
	var updatedCnt = 0;
	var deletedCnt = 0;

	$(document).ready(function() {
		
		// 공통 그룹 코드 리스트 바인딩
		commonGroupCode.searchList();
		
		// 추가 버튼 클릭 시
		$(".btnAddCode").click(function() {
			if($(this).attr("id") == "btnAddComGrpCd") {
				bindComGrpCdList();
			} 
			if($(this).attr("id") == "btnAddComCd") {
				if(validRelativeGrpCd()) {
					bindComCdList();
				}
			}
		});
		
		// 삭제 버튼 클릭 시
		$(".btnRemoveCode").click(function(){
			if($(this).attr("id") == "btnRemoveComGrpCd") {
				$("#listCommonGroupCode input[name=checkCode]:checked").each(function (index) {  
					$(this).closest("tr").addClass("remove");
					$(this).closest("tr").hide();
			    });  
			}
			if($(this).attr("id") == "btnRemoveComCd") {
				if(validRelativeGrpCd()) {
					$("#listCommonCode input[name=checkCode]:checked").each(function (index) {  
						$(this).closest("tr").addClass("remove");
						$(this).closest("tr").hide();
				    });  
				}
			}
		});
		
		// 저장 버튼 클릭 시
		$(".btnStoreCode").click(function() {
			var params = [];
			insertedCnt = 0;
			updatedCnt = 0;
			deletedCnt = 0;
			
			if($(this).attr("id") == "btnStoreComGrpCd") {
				////////////////////////////// 등록
				$('#listCommonGroupCode .register').each(function (index, value) { 
					var register = new Object();
					$(this).find("input").each(function (index, value2) { 
						register[value2.id] = value2.value;
					});
					params.push(register);
				});
				if(params.length > 0) {
					commonGroupCode.registerList(params);
				}
				
				////////////////////////////// 수정
				$('#listCommonGroupCode .modify').each(function (index, value) { 
					var modify = new Object();
					$(this).find("input").each(function (index, value2) { 
						modify[value2.id] = value2.value;
					});
					commonGroupCode.modify(modify);
				});
				
				////////////////////////////// 삭제
				params = [];
				$("#listCommonGroupCode .remove").each(function (index, value) {
					params.push($(this).find("#grpCdId").val());
				});
				if(params.length > 0) {
					commonGroupCode.remove(params);
				}
				
				alert("등록: " + insertedCnt + " 수정: " + updatedCnt + " 삭제: " + deletedCnt);
				location.reload();
			}
			
			if($(this).attr("id") == "btnStoreComCd") {
				if(validRelativeGrpCd()) {
					////////////////////////////// 등록
					$('#listCommonCode .register').each(function (index, value) { 
						var register = new Object();
						$(this).find("input").each(function (index, value2) { 
							register[value2.id] = value2.value;
						});
						params.push(register);
					});
					if(params.length > 0) {
						commonCode.registerList(params);
					}
					
					////////////////////////////// 수정
					$('#listCommonCode .modify').each(function (index, value) { 
						var modify = new Object();
						$(this).find("input").each(function (index, value2) { 
							modify[value2.id] = value2.value;
						});
						commonCode.modify(modify);
					});
					
					////////////////////////////// 삭제
					params = [];
					$("#listCommonCode .remove").each(function (index, value) {
						params.push($(this).find("#cdId").val());
					});
					if(params.length > 0) {
						commonCode.remove(params);
					}

					alert("등록: " + insertedCnt + " 수정: " + updatedCnt + " 삭제: " + deletedCnt);
					location.reload();
				} 
			}
		});
		
	 });
	
	// 공통 그룹 코드 테이블 행 클릭 시
	$(document).on("click","#listCommonGroupCode tr", function() {
		$("#listCommonGroupCode tr").removeClass("click");
		$(this).addClass("click");
		$("#listCommonCode").html("");
		
		var grpCdId = $(this).find("#grpCdId").val();
		if(grpCdId != null && grpCdId != "") {
			commonCode.searchListByGrpCd(grpCdId);
			$("#relativeGrpCdId").html($(this).find("#grpCdId").val());
			$("#relativeGrpCd").html($(this).find("#grpCd").val());
			$("#relativeGrpCdNm").html($(this).find("#grpCdNm").val());
		}
	});
	
	// 최상위 체크박스 클릭 시
	$(document).on("click","input[name=checkAll]", function() {
		var table = $(this).closest("table").find("input[name=checkCode]");
        if($(this).is(":checked")) {
        	table.prop("checked", true);
        } else {
        	table.prop("checked", false);
        }
    	table.change();
	});
	
	// 코드 체크박스 클릭 시 
	$(document).on("change","input[name=checkCode]", function() {
        if($(this).is(":checked")) {
        	$(this).closest("tr").addClass("check");
        } else {
        	$(this).closest("tr").removeClass("check");
        }
	});
	
	// 공통 코드 사용 여부 클릭 시
	$(document).on("click","#cdUseYn", function() {
        if($(this).is(":checked")) {
        	$(this).prop("checked", true);
        	$(this).val("true");
        } else {
        	$(this).prop("checked", false);
        	$(this).val("false");
        }
	});
	
	// input에서 focus가 빠졌을 시
	$(document).on("input","#listCommonGroupCode input, #listCommonCode input",function() {
		var thisTr = $(this).closest("tr");
        
		if($(this).attr("initial") != "" && $(this).val() != $(this).attr("initial")) {
        	thisTr.addClass("modify");
        } else{
        	thisTr.removeClass("modify");
        }
	});

	var commonGroupCode = {
			
		searchList: function() {
			$.ajax({
				url: "/api/commonCode/searchCommonGroupCodeList",
				type: "GET",
				dataType: "json",
				success: function(data) {
					commonGroupCodeList = data;
					console.log(commonGroupCodeList);
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
		
		registerList: function(params) {
			jQuery.ajaxSettings.traditional = true;
			console.log(params);
			$.ajax({
				url: "/api/commonCode/registerCommonGroupCodeList",
				data: JSON.stringify(params),
				type: "POST",
				dataType: "json",
				contentType:'application/json; charset=utf-8',
			    async: false,
				success: function(data) {
					insertedCnt = data;
				}
			});
		}
		,
		
		modify: function(params) {
			$.ajax({
				url: "/api/commonCode/modifyCommonGroupCode",
				data: params, 
				type: "POST",
				dataType: "json",
			    async: false,
				success: function(data) {
					if(data == 1) {
						updatedCnt++;	
					}
				}
			});
		}
		,
		
		remove: function(params) {
			// ajax 배열 통신을 위한 jquery 직렬화 옵션 세팅 
			jQuery.ajaxSettings.traditional = true;

			$.ajax({
				url: "/api/commonCode/removeCommonGroupCodeList",
				data: { "grpCdIdList" : params }, 
				type: "POST",
				dataType: "json",
			    async: false,
				success: function(data) {
					deletedCnt = data;
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
				}).done(bindComCdList);
			}
			,
			
			registerList: function(params) {
				$.ajax({
					url: "/api/commonCode/registerCommonCodeList",
					data: JSON.stringify(params),
					type: "POST",
					dataType: "json",
					contentType:'application/json; charset=utf-8',
				    async: false,
					success: function(data) {
						console.log(data);
						insertedCnt = data;
					}
				});
			}
			,
			
			modify: function(params) {
				$.ajax({
					url: "/api/commonCode/modifyCommonCode",
					data: params, 
					type: "POST",
					dataType: "json",
				    async: false,
					success: function(data) {
						if(data == 1) {
							updatedCnt++;	
						}
					}
				});
			}
			,
			
			remove: function(params) {
				jQuery.ajaxSettings.traditional = true;

				$.ajax({
					url: "/api/commonCode/removeCommonCodeList",
					data: { "cdIdList" : params }, 
					type: "POST",
					dataType: "json",
					success: function(data) {
						deletedCnt = data;
					}
				});
			}
			
		}
	
	// 공통 코드 버튼 그룹 클릭 시
	function validRelativeGrpCd() {
		if($("#relativeGrpCd").text() == "") {
			alert("그룹 코드를 선택해 주세요.");
			return false;
		}
		return true;
	}
	
	function bindComGrpCdList(data) {
		var html = "";
		
		if(data == null) {
			data = [{ classValue: "register", grpCdId : "", grpCd : "", grpCdNm : "", grpCdExplnatn : ""}];
		} 
		$.each(data, function(index, item){ 
			if(item.grpCdId == null) 		{ item.grpCdId = ""; 		}
			if(item.grpCd == null)  		{ item.grpCd = ""; 			}
			if(item.grpCdNm == null) 		{ item.grpCdNm = ""; 		}
			if(item.grpCdExplnatn == null) 	{ item.grpCdExplnatn = ""; 	}
			if(item.classValue == null) 	{ item.classValue = ""; 	}
			
			html += "<tr class='" + item.classValue + "'>"
				 +		"<td>"
				 +			"<input type='checkbox' name='checkCode' id='grpCdId' value='" + item.grpCdId + "' initial='" + item.grpCdId + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCd' name='grpCd' value='" + item.grpCd + "' initial='" + item.grpCd + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCdNm' name='grpCdNm' value='" + item.grpCdNm + "' initial='" + item.grpCdNm + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='grpCdExplnatn' name='grpCdExplnatn' value='" + item.grpCdExplnatn + "' initial='" + item.grpCdExplnatn + "' />"
				 +		"</td>"
				 +	"</tr>";
		});
		
		$('#listCommonGroupCode').prepend(html);
	}
	
	function bindComCdList(data) {
		var html = "";
		
		if(data == null) {
			data = [{ classValue: "register", grpCdId : $("#relativeGrpCdId").text(), cdId : "", cd : "", cdNm : "", cdExplnatn : "", cdOrdNum : "", cdUseYn : "", fefrncCd : "" }];
		} 
		$.each(data, function(index, item){ 
			if(item.grpCdId == null) 	{ item.grpCdId = ""; 	}
			if(item.cdId == null) 		{ item.cdId = ""; 		}
			if(item.cd == null)  		{ item.cd = ""; 		}
			if(item.cdNm == null) 		{ item.cdNm = ""; 		}
			if(item.cdExplnatn == null) { item.cdExplnatn = ""; }
			if(item.cdOrdNum == null)  	{ item.cdOrdNum = ""; 	}
			if(item.cdUseYn == null) 	{ item.cdUseYn = ""; 	}
			if(item.fefrncCd == null) 	{ item.fefrncCd = ""; 	}
			if(item.classValue == null) { item.classValue = ""; }
			
			html += "<tr class='" + item.classValue + "'>"
				 +		"<td>"
				 +			"<input type='hidden' id='grpCdId' name='grpCdId' value='" + item.grpCdId + "' />"
				 +			"<input type='checkbox' name='checkCode' id='cdId' value='" + item.cdId + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='cd' name='cd' value='" + item.cd + "' initial='" + item.cd + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='cdNm' name='cdNm' value='" + item.cdNm + "' initial='" + item.cdNm + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='cdExplnatn' name='cdExplnatn' value='" + item.cdExplnatn + "' initial='" + item.cdExplnatn + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='cdOrdNum' name='cdOrdNum' value='" + item.cdOrdNum + "' initial='" + item.cdOrdNum + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input type='checkbox' id='cdUseYn' name='cdUseYn' ";
							 if(item.cdUseYn == true) {
								 html += "checked";
							 }
			html +=	 		" value='" + item.cdUseYn + "' initial='" + item.cdUseYn + "' />"
				 +		"</td>"
				 +		"<td>"
				 +			"<input id='fefrncCd' name='fefrncCd' value='" + item.fefrncCd + "' initial='" + item.fefrncCd + "' />"
				 +		"</td>"
				 +	"</tr>";
		});
		
		$('#listCommonCode').prepend(html);
	}
	
</script>
</head>
<body>
	<div class="areaBody" id="areaHeaderText" style="text-align: center; width: 100%; height:10vh; margin:auto; border:1px solid black;">
		<h1>공통 코드 관리</h1>
	</div>
	<div class="areaBody" id="areaSearchCode" style="text-align: center; width: 100%; height:5vh; border:1px solid black;">
		<select style="width:200px;">
			<option>공통 그룹 코드</option>
			<option>공통  코드</option>
		</select>
		<select style="width:200px;">
			<option></option>
		</select>
		<input style="width:200px;" />
		<button>검색</button>
	</div>
	<div class="areaBody" id="areaCommonGroupCode" style="float: left; width: 49.5%; height:80vh; border:1px solid black;">
		<div id="headerCommonGroupCode" style="width:100%; height:5%;">
			<h3 style="float:left; margin:3px;">공통 그룹 코드</h3>
			<div class="btnGroup" id="btnGroupComGrpCd" style="float:right; margin:6px;">
				<button class="btnAddCode" id="btnAddComGrpCd">추가</button>
				<button class="btnStoreCode" id="btnStoreComGrpCd">저장</button>
				<button class="btnRemoveCode" id="btnRemoveComGrpCd">삭제</button>
			</div>
		</div>
		<div id="contentCommonGroupCode" style="display:inline-block; width:100%; height:90%;">
			<form id="formCommonGroupCode">
				<table id="tableCommonGroupCode">
					<colgroup>
					    <col width="3%" />
					    <col width="15%" />
					    <col width="40%" />
					    <col width="42%" />
				  	</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll" /></th>
							<th>그룹 코드값</th>
							<th>그룹 코드명</th>
							<th>설명</th>
						</tr>
					</thead>
						<tbody id="listCommonGroupCode">
						</tbody>
				</table>
			</form>
		</div>
	</div>
	<div class="areaBody" id="areaCommonCode" style="float: right; width: 49.5%; height:80vh; border:1px solid black;">
		<div id="headerCommonCode" style="width:100%; height:5%;">
			<h3 style="float:left; margin:3px;">공통 코드[ <span id="relativeGrpCdId" style="visibility:hidden;"></span><span id="relativeGrpCd"></span> - <span id="relativeGrpCdNm"></span> ]</h3>
			<div class="btnGroup" id="btnGroupComCd" style="float:right; margin:6px;">
				<button class="btnAddCode" id="btnAddComCd">추가</button>
				<button class="btnStoreCode" id="btnStoreComCd">저장</button>
				<button class="btnRemoveCode" id="btnRemoveComCd">삭제</button>
			</div>
		</div>
		<div id="contentCommonCode" style="display:inline-block; width:100%; height:90%;">
			<form id="formCommonCode">
				<table id="tableCommonCode">
					<colgroup>
					    <col width="3%" />
					    <col width="10%" />
					    <col width="30%" />
					    <col width="35%" />
					    <col width="6%" />
					    <col width="6%" />
					    <col width="10%" />
				  	</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll" /></th>
							<th>코드값</th>
							<th>코드명</th>
							<th>설명</th>
							<th>정렬 번호</th>
							<th>사용 여부</th>
							<th>참조코드</th>
						</tr>
					</thead>
						<tbody id="listCommonCode">
						</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>




