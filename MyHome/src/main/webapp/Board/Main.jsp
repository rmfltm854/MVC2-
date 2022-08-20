<%@page import="board.boarddao.Boarddao"%>
<%@page import="board.boarddto.Boarddto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 다시 선언해주세요. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩 홈페이지에서 css 붙여넣기 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<hr/>

<%-- 테이블 태그는 표 형식으로 데이터를 화면에 출력해줍니다.
tr태그(table row)로 세로 줄(row) 개수를, td태그(table data)로 컬럼 개수를 제어합니다. 
th태그(table header)는 첫 번쨰 로우에 사용해 컬럼만 강조합니다. --%>
<!-- 화면을 예쁘게 꾸미고 싶으시면, https://getbootstrap.kr/에 접속하신 다음, 시작을 누르고
 -->
<table class="table table-hover">
	<tr><!-- 3 * 4형태로 만들어보겠습니다. -->
		<th>글번호</th>
		<th>글제목</th>
		<th>글쓴이</th>
		<th>쓴날짜</th>
	</tr>
	<!-- tr태그(로우개수)가 글 개수만큼 있어야 하므로, tr태그가 반복의 대상임 -->
	<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.bnum }</td>
			<td><a href="/MyHome/board/show.board">
				${board.bsubject }</a>
			</td>
			<td>${board.bwriter }</td>
			<td>${board.bdate }</td>
		</tr>
	</c:forEach>
</table><br>
<!-- 글쓰기 버튼을 만들어서 BoardForm.jsp와 연결해주세요. -->
<a class="btn btn-primary" href="/MyHome/board/createform.board">글쓰기</a>

</body>
</html>