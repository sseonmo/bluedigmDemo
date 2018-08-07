
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<title>User</title>
<style type="text/css">
body{
	font-family:Arial, Helvetica, sans-serif;
	margin:0 auto;
}
a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
a:visited {
	color: #666;
	font-weight:bold;
	text-decoration:none;
}
a:active,
a:hover {
	color: #bd5a35;
	text-decoration:underline;
}


table a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
table a:active,
table a:hover {
	color: #bd5a35;
	text-decoration:underline;
}
table {
	font-family:Arial, Helvetica, sans-serif;
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	margin:20px;
	border:#ccc 1px solid;

	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;

	-moz-box-shadow: 0 1px 2px #d1d1d1;
	-webkit-box-shadow: 0 1px 2px #d1d1d1;
	box-shadow: 0 1px 2px #d1d1d1;
}
table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;

	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
	background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
}
table th:first-child{
	text-align: left;
	padding-left:20px;
}
table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table tr{
	text-align: center;
	padding-left:20px;
}
table tr td:first-child{
	text-align: left;
	padding-left:20px;
	border-left: 0;
}
table tr td {
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table tr:last-child td{
	border-bottom:0;
}
table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}

</style>		
		<style>
			.outerDiv
			{
				background-color: #006699;
				color: #fff;
				height: 800px;
				width: 1800px;
				margin: 0px auto;
				padding: 5px;
			}
			.leftDiv
			{
				background-color: #efefef;
				color: #000;
				height: 800px;
				width: 30%;
				float: left;
			}
			.rightDiv
			{
				background-color: #efefef;
				color: #000;
				height: 800px;
				width: 68%;
				float: right;
			}			
		</style>		
	</head>




    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>사용자 관리</title>
    
	<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/resources/js/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>
	
<script>
var selectedNode = null;

$(function(){
	
	User.userList();
  
});

var User = {

        // 개발자 list search
        userList: function () {
			
        	$.ajax({
            	url: "/system/user/userViewList",
        		type:"GET", 
            	data: { }    	
            }).success(function(result){
           			$("#userList").html(result);
           			console.log(result);
        		}    		
            );
    	}
	}

function chkInputValue(id, msg){
	if ( $.trim($(id).val()) == "") {
		alert(msg+"을(를) 입력해주세요.");
		$(id).focus();
		return false;
	}
	return true;
}


function fn_addUserSave(){
	if ( ! chkInputValue("#userId", "아이디")) return false;
	if ( ! chkInputValue("#userName", "이름")) return false;
	if ( $("#userId").val() === ""){
		if ( ! chkInputValue("#userPassword", "패스워드")) return false;
		if ( ! chkInputValue("#userPassword2", "패스워드 확인")) return false;
		if ( $("#userPassword").val() !== $("#userPassword2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
	
	var formData = $("#form1").serialize();
	$.ajax({
		url: "/api/user/userSave",
		type:"POST", 
		data : formData,
	}).done(saveResult);
}

function saveResult(result){
	
	var ruleId = $("input[type=radio][name=ruleId]:checked").val();
	var userId = $("#userId").val();
	
	$.ajax({
		url: "/api/user/userRuleSave", 
		type:"POST", 
		data : {ruleId:ruleId, userId:userId},
		success: function(result){
			User.userList();
			alert("저장되었습니다.");
		}
	})
		
}

function fn_chkUserId(){
	
	var userId = $("#userId").val();
	
	if ( ! chkInputValue("#userId", "아이디")) return false;
	$.ajax({
		url: "/api/user/chkUserId", 
		type:"POST", 
		data : {userId: userId},
		success: function(result){
			if ($.trim(result) == 0) {
				alert("사용가능한 아이디입니다.");
			} else{
				alert("사용중인 아이디입니다.");
			}
		},
		error:function(){
                alert("에러입니다");
        }
	})		
}

function fn_UserRead(userId){
	$.ajax({
		url: "/api/user/userRead", 
		type:"GET",
		data : {userId:userId},
		dataType: "json",
		success: function(result){
			console.log(result);
			$("#userId").val(result.userId);	
		    $("#userId").attr("readonly",true);
			$("#userName").val(result.userName);
			$("#userEmail").val(result.userEmail);
			$("#userPhone").val(result.userPhone);
			$('input:radio[name="ruleId"][value="' + result.ruleId + '"]').prop("checked", true);
			$("#pwDiv").hide("");

		}
	})		
}


function fn_UserDelete(userId){
    if(!confirm("삭제 하시겠습니까?")) return;

	$.ajax({
		url: "/api/user/userDelete", 
		type:"POST", 
		data : {userId:userId},
		success: function(result){
			User.userList();
			alert("삭제되었습니다.");
		}
	})		
}

</script>    
</head>

<body style="text-align: center;">

<div class="outerDiv">
    <!-- Modal -->
    <div class="leftDiv" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <form id="form1" name="form1">
	        <table>
	        	<caption>사용자 등록 수정 및 관리</caption>
	        	<thead>
	        		<tr>
	        			<th></th>
	        		</tr>
	        	</thead>
				
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text"  id="userId" name="userId" maxlength="20" value="">
	                        <button type="button"  onclick="fn_chkUserId()">중복 확인</button>
	                    </td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="userName" name="userName" maxlength="20" value=""></td>
					</tr>
					<tr id="pwTr_1">
						<th>패스워드</th>
						<td><input type="password" id="userPassword" name="userPassword" maxlength="20" value=""></td>
					</tr>
					<tr id="pwTr_2">
						<th>패스워드 확인</th>
						<td><input type="password" id="userPassword2" name="userPassword2" maxlength="20" value=""></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" id="userEmail" name="userEmail" maxlength="50" value=""></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" id="userPhone" name="userPhone" maxlength="15" value=""></td>
					</tr>
					<tr>
						<th>권한 그룹 선택</th>
						<td>
							<label><input name="ruleId" id="ruleId_1" type="radio" checked="checked" value="1">관리자</label>
						 	<label><input name="ruleId" id="ruleId_2" type="radio"  value="2">사용자_1</label>
						 	<label><input name="ruleId" id="ruleId_3" type="radio"  value="3">사용자</label>
					 	</td>
					</tr>
					
				</tbody>
	        </table>
		</form>
		<div >
	    	<button type="button" onclick="fn_addUserSave()">저장</button>
	        <button type="button"  data-dismiss="modal" id="close">취소</button>
	    </div>
    </div>    
        
        
        
	<div class="rightDiv" id="userList">
	</div>

</div>
        
</body>

</html>
