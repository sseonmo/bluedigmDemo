
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!doctype html>
<html>
	<head>
		<title>Manager</title>
	</head>

	<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>
	
	<script>
	function fn_formSubmit(){
		document.form1.submit();	
	}
	</script>
	
	<body>
		<div> 
            	<div>
					<div>
						<div>번호</div>
						<div>날짜</div>
						<div>아이디</div>
						<div>
							<input id="chkall" name="chkall" title="모두선택" onclick="fnCheckAll()" type="checkbox">
						</div>
						<div class="listTitle">리스트 타이틀</div>
					</div> 
					 
					<c:if test="${listview.size()==0}">
						<div class="listBody height200">
						</div>
					</c:if>
					
					<form role="form" id="form2" name="form2"  method="post" action="chkDelete">
					<c:forEach var="listview" items="${listview}" varStatus="status">
						<c:url var="link" value="crudRead">
							<c:param name="crno" value="${listview.crno}" />
						</c:url>
					
						<div class="listBody">
							<div><c:out value="${listview.crdate}"/></div>
							<div><c:out value="${listview.usernm}"/></div>
							<div title="<c:out value="${listview.crtitle}"/>">
								<input type="checkbox" name="checkRow" value="<c:out value="${listview.crno}"/>"/> &nbsp;
								<a href="${link}"><c:out value="${listview.crtitle}"/></a>
							</div>
						</div>
					</c:forEach>
					</form>	
					
					<br/>
					<form role="form" id="form1" name="form1"  method="post">
				    
						<div>
							<div>
							 	<label>
							 		<input type="checkbox" name="searchType" value="adminName" <c:if test="${fn:indexOf(manager.searchType, 'adminName')!=-1}">checked="checked"</c:if>/>
		                        	이름
		                        </label>
							 	<label>
							 		<input type="checkbox" name="searchType" value="adminEmail" <c:if test="${fn:indexOf(manager.searchType, 'adminEmail')!=-1}">checked="checked"</c:if>/>
		                        	이메일
		                        </label>
		                   </div>
		                   <div>
	                                <input placeholder="Search..." type="text" name="searchKeyword" value='<c:out value="${manager.searchKeyword}"/>' >
	                                <span class="input-group-btn">
	                                <button onclick="fn_formSubmit()">
	                                    <i></i>
	                                </button>
	                            </span>
	                       </div>
						</div>
					</form>	
            	</div>    
            </div>		
		 
	
	</body>

</html>




