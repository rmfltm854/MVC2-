<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<!-- board라는 명칭으로 vo를 포워딩했고, 리스트가 아니므로 바로 처리 가능 -->
	<h1>${dto.bnum }번 글 조회</h1>
	<!-- value 속성은 해당 폼 자료 내부에 미리 기입되어있을 내용을 적을 수 잇습니다. -->
	글제목 : <input type="text" value="${dto.title }" readonly><br/>
	글쓴이 : <input type="text" value="${dto.writer }" readonly><br/>
	글번호 : <input type="text" value="${dto.bnum }" readonly><br/>
	<!-- textarea태그는 value 속성을 받지 못하므로 태그 사이에 미리 기입될 내용을 적어야 합니다. -->
	본문 : <textarea cols="50" rows="10">${dto.content }</textarea><br/>
	글쓴날짜 : <input type="text" value="${dto.regdate }" readonly><br/>
	<hr/>
	<!-- 현재 삭제하려는 대상이 post방식 접근만 허용하므로
	form의 제출버튼을 이용해 이동해야하고, 삭제시 글번호를 기준으로 삭제하므로
	hidden속성을 이용해 글번호를 같이 전달되도록 합니다. -->
	<form action="http://localhost:8181/JDBC_t/BoardDelete" method="post">
		<input type="hidden" name="bnum" value="${dto.bnum }">
		<input type="submit" value="삭제">
	</form>
	<form action="http://localhost:8181/JDBC_t/BoardUpdateForm" method="post">
		<input type="hidden" name="bnum" value="${dto.bnum }">
		<input type="submit" value="수정">
	</form>

</body>
</html>