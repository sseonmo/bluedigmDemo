
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


	<table>
		<colgroup>
			<col width='10%' />
			<col width='20%' />
			<col width='10%' />
			<col width='25%' />
			<col width='20%' />
			<col width='5%' />
		</colgroup>
		<thead>
			<tr>
				<th>그룹명</th> 
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listview" items="${listview}" varStatus="status">	
				<tr>
					<td class="center">${listview.ruleName}</td>
 					<td class="center"><a href="javascript:fn_UserRead('${listview.userId}');">${listview.userId}</a></td>
 					<td class="center"><a href="javascript:fn_UserRead('${listview.userId}');">${listview.userName}</a></td>
					<td class="center">${listview.userPhone}</td>
					<td class="center">${listview.userEmail}</td>
					<td><a href="javascript:fn_UserDelete('${listview.userId}');"><i>삭제</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
   
