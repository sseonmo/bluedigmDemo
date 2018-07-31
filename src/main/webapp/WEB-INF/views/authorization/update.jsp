<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tag/ntels.tld" prefix="ntels" %>



<script type="text/javascript">
//Ajax로 첫 화면의 데이터 호출
//화면 먼저 보이고 데이터를 불러야 사용자가 덜 답답해 함
$(document).ready(function(){
	init();
	
	//버튼 클릭시
	$("#btn_update").click(function() {
		goUpdate();
	});
	$("#btn_delete").click(function() {
		goDelete();
	});
});

function init() {
	var tmp_disYn = "${menu.disYn}";

	if(tmp_disYn != "") {
		if(tmp_disYn == "true") {
			$("#disYn_Y").attr("checked", "true");
		} else
			$("#disYn_N").attr("checked", "true");
	} else {
		var param_disYn = "${disYn}";
		
		if(param_disYn == "true") {
			$("#disYn_Y").attr("checked", "true");
		} else
			$("#disYn_N").attr("checked", "true");
	}
	
	var tmp_menuUrl = "${menu.menuUrl}";
	if(tmp_menuUrl.indexOf("popup:") > -1) {
		$("#tmp_menuUrl").val( tmp_menuUrl.substring("popup:".length, tmp_menuUrl.length) );
		$("#popup_sw").attr("checked", true);
	} else {
		$("#popup_sw").attr("checked", false);
	}
	
	var addTitle = "${addTitle}";
	if(addTitle != "") {
		addNode();
	} else {
		updateNode();
	}
}

function addNode() {
	var addTitle = "${addTitle}";
	var addKey = "${addKey}";
	var adddisYn = "${adddisYn}";
	
	//alert(adddisYn);
	
	var node = $(tree).dynatree("getActiveNode");
	if(adddisYn == "true") {
		node.addChild({
			title: addTitle,
			key: addKey,
			disYn: adddisYn,
			activate: true
		});
	} else {
		node.addChild({
			title: addTitle,
			key: addKey,
			activate: true
		});
	}
}

function updateNode() {
	var node = $(tree).dynatree("getActiveNode");
	node.setTitle("${menu.menuName}");
}

function goUpdate() {
	if($("#menuName").val() == "") {
		alert("<spring:message code="NotEmpty.menu.menuName"/>");
		$("#menuName").focus();
		return;
	}

	if($("#popup_sw").is(":checked")) {
		$("#menuUrl").val( "popup:" + $.trim($("#tmp_menuUrl").val()) );
	} else {
		$("#menuUrl").val( $.trim($("#tmp_menuUrl").val()) );
	}

	var param = $("#menu").serialize();
	$.post("/cm/authorization/menu/updateAction.ajax", param, function(data) {
		$("#menuAttribute").html(data);
	});
}

function goDelete() {
	var node = $(tree).dynatree("getActiveNode");

	if(!node) {
		alert('<spring:message code="msg.need.select.menu.text"/>');
		return;
	}
	
	// 상위 메뉴 삭제 금지...
	if(node.data.key == "0")
		return;
	
	if(node.data.disYn)
		if(node.countChildren() > 0) {
			alert('<spring:message code="msg.need.select.submenu.text"/>');
			return;
		}
	
	if (!confirm('<spring:message code="label.confirm.delete" />'))
		return;

	var param = new Object();
	param.menuId = $("#menuId").val();
	$.post("/cm/authorization/menu/deleteAction.ajax", param, function(data) {
		$("#menuAttribute").html("<header><spring:message code='label.menu.attribute.text' /></header><div class='boxContent'><p class='infom'><spring:message code='label.alert.delete' /></p></div>");
	});
	
	node.remove();
}
</script>

					<c:if test="${resultMsg != null}">
					<p class="<c:if test="${returnMsg == 'SUCCESS'}">infom</c:if><c:if test="${returnMsg == 'FAIL'}">caution</c:if>">${resultMsg}</p>
					</c:if>
		
					<form:form name="menu" commandName="menu" method="post">
					<input id="menuId" name="menuId" value="${menu.menuId}" type="hidden" />
					<input id="prntMenuId" name="prntMenuId" value="${menu.prntMenuId}" type="hidden" />
					<input id="stepNo" name="stepNo" value="${menu.stepNo}" type="hidden" />
					<input id="menuOrder" name="menuOrder" value="${menu.menuOrder}" type="hidden" />
					<input id="disYn" name="disYn" value="${menu.disYn}" type="hidden" />
					<input id="menuUrl" name="menuUrl" value="${menu.menuUrl}" type="hidden" />
					
		            <table class="modif">
		            <colgroup>
			            <col width="20%">
			            <col width="80%">
		            </colgroup>
			            <tr>
			               <th><label><strong>*</strong><spring:message code="label.menu.disYn.text"/></label></th>
			               <td>
			                  <input id="disYn_Y" name="disYn_Y" value="true" type="radio" disabled/>
		                  		<spring:message code="label.menu.disYn.Y.text"/>&nbsp;&nbsp;
			                  <input id="disYn_N" name="disYn_N" value="false" type="radio" disabled/>
		                  		<spring:message code="label.menu.disYn.N.text"/>
			               </td>
			            </tr>
			            <tr>
			               <th><label><strong>*</strong><spring:message code="label.menu.menuName.text"/></label></th>
			               <td>
			                  <input id="menuName" name="menuName" value="${menu.menuName}" placeholder="<spring:message code="label.menu.menuName.text"/>" maxlength="30" size="50" />
			                  <form:errors path="menuName" class="caution"/>
			               </td>
			            </tr>
			            <tr>
			               <th><label><spring:message code="label.menu.menuUrl.text"/></label></th>
			               <td>
			                  <input id="tmp_menuUrl" name="tmp_menuUrl" value="${menu.menuUrl}" placeholder="<spring:message code="label.menu.menuUrl.text"/>" maxlength="255" size="50" />
			                  <input id="popup_sw" type="checkbox" /> Popup
			                  <form:errors path="menuUrl" class="caution"/>
			               </td>
			            </tr>
			            <tr>
			               <th><label><spring:message code="label.menu.menuExpl.text"/></label></th>
			               <td>
			                  <textarea id="menuExpl" name="menuExpl" placeholder="<spring:message code="label.menu.menuExpl.text"/>" cols="42" rows="5">${menu.menuExpl}</textarea>
			               </td>
			            </tr>
		            </table>
		            </form:form>
		            <!--e : 등록table-->
		            
		            <ntels:auth auth="${menuAuth}"><a href="#" id="btn_update" class="button"><span><spring:message code="label.update"/></span></a></ntels:auth>
		            <ntels:auth auth="${menuAuth}"><a href="#" id="btn_delete" class="button"><span><spring:message code="label.delete"/></span></a></ntels:auth>

