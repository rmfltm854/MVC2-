<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%
	//session.removeAttribute("login");
	session.invalidate();//세션초기화...
	
	session = request.getSession();
	
	session.setAttribute("login", null);
	
	out.println("<script type='text/javascript'>");
	out.println("alert('로그아웃 되었습니다.');");
	out.println("location.href='/MyHome/';");
	out.println("</script>");
%>

--%>

<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href="/MyHome/";
</script>