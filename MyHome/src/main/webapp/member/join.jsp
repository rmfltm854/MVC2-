
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	
<c:if test="${check }">
<script type="text/javascript">
	alert("회원가입성공.");
	location.href="/MyHome/";
</script>
</c:if>
<c:if test="${!check }">
<script type="text/javascript">
	alert("회원가입실패.");
	history.back();
</script>
</c:if>

		
	
