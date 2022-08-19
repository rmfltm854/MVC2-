<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function check(f) {
		//alert(f.id.value);
		//document.input.id.value = "김민준";
		if(f.id.value == ""){
			alert("ID를 입력하십시오!");
			f.id.focus();
		}else if(f.password.value == ""){
			alert("PW를 입력하십시오!");
			f.password.focus();
		}else{
			f.submit();
		}
	}
</script>
<%@ include file="/layout/header.jsp" %>
	<div align="center">
		<form action="/MyHome/login/check.do" method="post" name="input">
			<table>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" value="${id }">
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<th align="right" colspan="2">
						<span class="ckid">
							<c:choose>
								<c:when test="${check }">
									<input type="checkbox" name="ckid" value="true" checked="checked">
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="ckid" value="true">
								</c:otherwise>
							</c:choose>	
							<font class="ckid_text">아이디 기억하기</font>
						</span>
						<input type="button" value="Login" onclick="javascript:check(input)">
					</th>
				</tr>
			</table>
		</form>
	</div>		
<%@ include file="/layout/footer.jsp" %>