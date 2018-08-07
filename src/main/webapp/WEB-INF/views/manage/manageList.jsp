
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<title>User</title>
<style>
  table {
    width: 80%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
    text-align: center;
  }
  th:nth-child(2n), td:nth-child(2n) {
    background-color: #bbdefb;
  }
  th:nth-child(2n+1), td:nth-child(2n+1) {
    background-color: #e3f2fd;
  }
</style>		
	</head>


    <title>사용자 관리</title>
    
	<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>
	
	<script>

	</script>    
</head>

<body>

	<table>
		<colgroup>
			<col width='5%' />
			<col width='20%' />
			<col width='10%' />
			<col width='25%' />
			<col width='20%' />
			<col width='5%' />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th> 
				<th>권한 그룹명</th>
				<th>사용자수</th>
				<th>권한 그룹 설명</th>
				<th>등록일시</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listview" items="${listview}" varStatus="status">	
				<tr>
					<td class="center">${status.index+1}</td>
 					<td class="center"><a href="javascript:fn_ManageRead('${listview.ruleId}');">${listview.ruleName}</a></td>
					<td class="center">${listview.ruleCount}</td>
					<td class="center">${listview.ruleExpl}</td>
					<td class="center">${listview.corDt}</td>
					<td><a href="javascript:fn_UserDelete('${listview.ruleId}');"><i>삭제</i></a></td>
				
				</tr>
			</c:forEach>
		</tbody>
	</table>
   
   
</body>

</html>
