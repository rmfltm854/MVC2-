<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function check(){
		if(document.del.password.value == ""){
			alert("비밀번호를 입력하십시오!!!");
		}else{
			document.del.submit();
		}
	}
</script>
<%@include file="/layout/header.jsp" %>
<div align="center">
	<form action="/MyHome/member/delete.me" method="post" name = "del">
		<table border="1">
			<tr>
				<th>${login.id }님의 비밀번호 확인</th>
			</tr>
			<tr>
				<td>
					<input type="password" name = "password" placeholder="비밀번호 확인">
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="탈퇴" onclick="javascript:check()">
					<input type="button" onclick="location.href='/MyHome/member/myPage.jsp'" value="돌아가기">				
				</td>
			</tr>
		</table>
	</form>
</div>


<%@include file="/layout/footer.jsp" %>