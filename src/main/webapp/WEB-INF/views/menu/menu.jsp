
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
	<head>
		<title>Menu</title>
	</head>

	<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>
	
	<link href="/resources/css/ui.dynatree.css" rel="stylesheet" type="text/css">
	<script src="/resources/js/jquery.dynatree.min.js" type="text/javascript"></script>
	
	<script>
	var selectNode = null;
	
  	$(function(){
		$("#tree").dynatree({
			children: <c:out value="${treeView}" escapeXml="false"/>,
			onActivate: TreeActivate
		});
		
	    $("#tree").dynatree("getRoot").visit(function(node){
	        node.expand(true);
	    });
		fn_menuNew();
	});
 
	
	function TreeActivate(node) {
		selectNode = node;
	    
	    if (selectNode==null || selectNode.data.key==0) return;
	    
	    $.ajax({
	        url: "/api/menu/menuRead",
	        cache: false,
	        type: "GET",
	        data: { menuId : selectNode.data.key }        
	    }).done(acceptData)
	    .fail(function(request, status, error){ console.log("code:"+request.status+"\n"+"request:"+request.responseText+"\n"+"error:"+error) })

	    

	
	
 	    /* $.ajax({
	        url: "/api/menu/menuRead",
	        cache: false,
	        type: "GET",
	        data: { menuId : selectNode.data.key }        
		    },
		    success: function(data){
		    	acceptData;
		    },
		    error: function(request, status, error){
		    	//console.log("code:"+request.status+"\n"+"request:"+request.responseText+"\n"+"error:"+error);
		    },
		    complete : function () {   
		    	acceptData;
		    }

	    }); */
	    
	
	}

	function acceptData(data){
	    $("#menuId").val(data.menuId);
	    $("#menuName").val(data.menuName);
    	$("#menuUrl").val(data.menuUrl);
    	$("#menuExpl").val(data.menuExpl);
    	
		$('input:radio[name="displayYn"][value="' + data.displayYn + '"]').prop('checked', true);

	}

	function fn_menuNew(){
	    $('#menuId').val('');
	    $('#menuName').val('');
    	$('#menuUrl').val('');
    	$('#menuExpl').val('');

		$('input:radio[name="displayYn"][value="Y"]').prop('checked', true);
	}
	
	
	function fn_menuDelete(value){
	    if (selectNode==null){
	    	alert("삭제할것을  선택해주세요.");
	    	return;
	    }
	    if (selectNode.childList){
	    	alert("하위가 있는것은 삭제 불가합니다.");
	    	return;
	    }
	    
	    if(!confirm("삭제하시겠습니까?")) return;
	    $.ajax({
	    	url: "/api/menu/menuDelete",
	    	type: "POST",
	    	cache: false,
	    	data: { menuId : selectNode.data.key }    	
	    }).done(acceptDataDelete)
	    .fail(function(request, status, error){ console.log("code:"+request.status+"\n"+"request:"+request.responseText+"\n"+"error:"+error) })
	    
	}

	function acceptDataDelete(data){
		alert("삭제하였습니다.");
		selectNode.remove();		
		selectNode = null;
		fn_menuNew();
	}

	function fn_menuSave(){
		if($("#menuName").val() == ""){
			alert("메뉴명을 입력해주세요.");
			return;
		}
		var pid=null;
	    if (selectNode!=null) 
	    	
	    	pid=selectNode.data.key;

	    if (!confirm("저장하시겠습니까?")) return;

	    $.ajax({
	    	url: "/api/menu/menuSave",
	    	cache: false,
	    	type: "POST",
	    	data: { menuId:$("#menuId").val(), menuName:$("#menuName").val(), prntMenuId: pid,
	    		menuUrl:$("#menuUrl").val(), menuExpl:$("#menuExpl").val(),
	    		displayYn : $("input:radio[name=displayYn]:checked").val() }
	    				
	    }).done(acceptDataSave)
	    .fail(function(request, status, error){ console.log("code:"+request.status+"\n"+"request:"+request.responseText+"\n"+"error:"+error) })
	    
	}

	function acceptDataSave(data){
		if (selectNode!==null && selectNode.data.key===data.menuId) {
			selectNode.data.title=data.menuName;
			selectNode.render();
		} else {
			addNode(data.menuId, data.menuName);
		}
		
		alert("저장되었습니다.");
	}

	function addNode(nodeNo, nodeTitle){
		var node = $("#tree").dynatree("getActiveNode");
		if (!node) node = $("#tree").dynatree("getRoot");
		var childNode = node.addChild({key: nodeNo, title: nodeTitle});
		node.expand() ;
		node.data.isFolder=true;
		node.tree.redraw();
	}
	</script>
	
	<body>
           	<div style="border-right: 1px solid #CCC; height: 500px;float:left;width:340px;height:254px;border:1px solid #CCC;border-top:2px solid #CCC;border-right:none;padding:15px;overflow-y:auto;" >
                   <div style="max-height:400px; overflow:auto;" >
			    	<div id="tree" style="height: 200px;">
					</div>
            		<button style="color: #fff; background-color: #337ab7;border-color: #2e6da4;" onclick="fn_menuNew()" >메뉴 추가</button>
				</div>
			</div>
			
		<input name="menuId" id="menuId" type="hidden" value="">
			
			<div style="border-right: 1px solid #CCC; height: 500px;float:left;width:340px;height:254px;border:1px solid #CCC;border-top:2px solid #CCC;border-right:none;padding:15px;overflow-y:auto;" >
			<table>
				<caption class="hide-caption">메뉴정보</caption>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				
				<tbody>
					<tr>
						<th scope="row">메뉴명</th>
						<td>
							<input name="menuName" id="menuName" type="text" maxlength="100" value="" >
						</td>
					</tr>
					<tr>
						<th scope="row">메뉴경로</th>
						<td>
			 				<input name="menuUrl" id="menuUrl" type="text" maxlength="100" value="" >
						</td>
					</tr>
					<tr>
						<th scope="row">메뉴설명</th>
						<td style="min-height: 1px;">
			 				<textArea name="menuExpl" id="menuExpl" type="text" maxlength="1000" value="" ></textArea>
						</td>
					</tr>
					<tr>
						<th scope="row">사용여부</th>
						<td>
							<label><input name="displayYn" id="displayYn" type="radio" checked="checked" value="Y">사용함</label>
						 	<label><input name="displayYn" id="displayYn" type="radio" value="N">사용안함</label>
						</td>
					</tr>
				
			</table>
			<div style="margin-bottom: 15px;">
	           	<button style="color: #fff; background-color: #337ab7;border-color: #2e6da4;" onclick="fn_menuSave()" >저장</button>
	           	<button style="color: #fff; background-color: #337ab7;border-color: #2e6da4;" onclick="fn_menuDelete()" >삭제</button>
			</div>			
		</div>
	</tbody>
			
            	
            	
            	
            	<!-- <div style="float: center;" >
                    <div style="padding: 15px;">
			            
		                <input name="menuId" id="menuId" type="hidden" value="">
			            <div style="margin-bottom: 15px;">
			            	<label>그룹명</label>
			            	<div style="position: relative;min-height: 1px;padding-right: 15px; padding-left: 15px;" >
				 				<input name="menuName" id="menuName" type="text" maxlength="100" value="" >
			            	</div>
						</div>
			            <div style="margin-bottom: 15px;">
			            	<label>메뉴경로</label>
			            	<div style="position: relative;min-height: 1px;padding-right: 15px; padding-left: 15px;" >
				 				<input name="menuUrl" id="menuUrl" type="text" maxlength="100" value="" >
			            	</div>
						</div>
			            <div style="margin-bottom: 15px;">
			            	<labe>메뉴 설명</label>
			            	<div style="position: relative;min-height: 1px;padding-right: 15px; padding-left: 15px;" >
				 				<input name="menuExpl" id="menuExpl" type="text" maxlength="100" value="" >
			            	</div>
						</div>
						<div style="margin-bottom: 15px;">
			            	<label>사용여부</label>
			            	<div style="position: relative;min-height: 1px;padding-right: 15px; padding-left: 15px;" >
							 	<label><input name="displayYn" id="displayYn" type="radio" checked="checked" value="Y">사용함</label>
							 	<label><input name="displayYn" id="displayYn" type="radio" value="N">사용안함</label>
			            	</div>
						</div>
						
						<div style="margin-bottom: 15px;">
			            	<button style="color: #fff; background-color: #337ab7;border-color: #2e6da4;" onclick="fn_menuSave()" >저장</button>
			            	<button style="color: #fff; background-color: #337ab7;border-color: #2e6da4;" onclick="fn_menuDelete()" >삭제</button>
						</div>
						
				    </div>    
				</div> -->	
	</body>

</html>




