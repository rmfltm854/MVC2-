<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function checkf(){
		if(document.check.title.value == ""){
			alert("제목을 입력하십시오!");
		}else if(document.check.writer.value == ""){
			alert("작성자를 입력하십시오!");
		}else if(document.check.content.value == ""){
			alert("내용을 입력하십시오!");
		}else{
			document.check.submit();
		}
	}
</script>
<!-- 부트스트랩 홈페이지에서 css 붙여넣기 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1 class="text-primary">글쓰기</h1>
	<form action="/MyHome/board/create.board" method="post" name = "check">
		<input type="text" name="title" placeholder="제목">
		<input type="text" name="writer" placeholder="글쓴이"><br>
		<!-- cols = 가로폭이 글씨 몇 자 기준인지, rows 세로폭이 엔터 몇 번인지 -->
		<textarea name="content" cols="50" rows="10"></textarea>
		<input type="button" value="글작성" onclick="javascript:checkf()">
		<input type="reset" value="초기화" onclick="document.check.reset()">
	</form>
</body>
</html>