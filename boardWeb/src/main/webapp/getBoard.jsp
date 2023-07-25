<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 글</title>
</head>
<body>
	<center>
		<h1> 글 상세 </h1>
		<a href="logout_proc.jsp">로그아웃</a>
		<hr>
		
		<form action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${board.seq}"/>
		<table board="1" cellpadding="0" cellspacting="0">
			<tr>
				<td bgcolor="orange" width="70"> 제목 </td>
				<td align="left"><input name="title" type="text" 
									value="${board.title}"/></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 작성자 </td>
				<td align="left"><input name="title" type="text" 
									value="${board.writer}"/></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 내용 </td>
				<td align="left"><textarea rows="10" cols="40" name="content"
				>${board.content}</textarea></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 등록일 </td>
				<td align="left">${board.regdate}</td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 조회수 </td>
				<td align="left">${board.cnt}</td>
			</tr>
			
			<tr>
				<td colspan="2" align="left">
					<input type="submit" value="글수정"/>
				</td>
			</tr>
		</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글 등록</a>
		<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>
		<a href="getBoardList.do">글 목록</a>
	</center>
</body>
</html>