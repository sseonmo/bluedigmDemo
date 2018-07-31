<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
//Ajax로 첫 화면의 데이터 호출
//화면 먼저 보이고 데이터를 불러야 사용자가 덜 답답해 함
$(document).ready(function(){
	init();
	
	//버튼 클릭시
	$("#btn_add").click(function() {
		goInsert();
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
}

function goInsert() {
	if($("#menuName").val() == "") {
		alert('<spring:message code="NotEmpty.menu.menuName"/>');
		$("#menuName").focus();
		return;
	}

	if($("#popup_sw").is(":checked")) {
		$("#menuUrl").val( "popup:" + $.trim($("#tmp_menuUrl").val()) );
	} else {
		$("#menuUrl").val( $.trim($("#tmp_menuUrl").val()) );
	}
	
	var param = $("#menu").serialize();
	$.post("/cm/authorization/menu/insertAction.ajax", param, function(data) {
		$("#menuAttribute").html(data);
	});
}
</script>

                  <header><spring:message code='label.menu.attribute.text' /></header>
                  <div class="boxContent">
					<c:if test="${resultMsg != null}">
					<p class="<c:if test="${returnMsg == 'SUCCESS'}">infom</c:if><c:if test="${returnMsg == 'FAIL'}">caution</c:if>">${resultMsg}</p>
					</c:if>

					<form:form name="menu" commandName="menu" method="post">
					<input id="menuNo" name="menuNo" value="${menu.menuId}" type="hidden" />
					<input id="upMenuNo" name="upMenuNo" value="${prntMenuId}" type="hidden" />
					<input id="menuDepth" name="menuDepth" value="${menuDepth}" type="hidden" />
					<input id="menuOrder" name="menuOrder" value="${menuOrder}" type="hidden" />
					<input id="menuUrl" name="menuUrl" value="${menu.menuUrl}" type="hidden" />

		            <table class="modif">
		            <colgroup>
			            <col width="20%">
			            <col width="80%">
		            </colgroup>
			            <tr>
			               <th><label><strong>*</strong><spring:message code="label.menu.isfolder.text"/></label></th>
			               <td>
			                  <input id="disYn_Y" name="disYn" value="true" type="radio" />
		                  		<spring:message code="label.menu.isfolder.Y.text"/>&nbsp;&nbsp;
			                  <input id="disYn_N" name="disYn" value="false" type="radio" />
		                  		<spring:message code="label.menu.isfolder.N.text"/>
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
			               <th><label><spring:message code="label.menu.viewPath.text"/></label></th>
			               <td>
			                  <input id="tmp_menuUrl" name="tmp_menuUrl" value="${menu.menuUrl}" placeholder="<spring:message code="label.menu.viewPath.text"/>" maxlength="255" size="50" />
			                  <input id="popup_sw" type="checkbox" /> Popup
			                  <form:errors path="menuUrl" class="caution"/>
			               </td>
			            </tr>
			            <tr>
			               <th><label><spring:message code="label.menu.description.text"/></label></th>
			               <td>
			                  <textarea id="menuExpl" name="menuExpl" placeholder="<spring:message code="label.menu.description.text"/>" cols="42" rows="5">${menu.menuExpl}</textarea>
			               </td>
			            </tr>
		            </table>
		            </form:form>
		            <!--e : 등록table-->
		            
		            <c:if test="${menu == null}">
		            <a href="#" id="btn_add" class="button"><span><spring:message code="label.add"/></span></a>
		            </c:if>
		            <c:if test="${menu != null}">
		            <a href="#" id="btn_update" class="button"><span><spring:message code="label.update"/></span></a>
		            <a href="#" id="btn_delete" class="button"><span><spring:message code="label.delete"/></span></a>
		            </c:if>
                  </div>
