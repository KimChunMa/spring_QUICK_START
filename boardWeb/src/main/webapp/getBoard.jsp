<%@page import="Taining1.impl.BoardDAO"%>
<%@page import="Taining1.board.BoardDTO"%>
<%
	String seq = request.getParameter("seq");
	BoardDTO dto = new BoardDTO();
	dto.setSeq(Integer.parseInt(seq));
	
	BoardDAO dao = new BoardDAO();
	BoardDTO board = dao.getBoard(dto);
%>

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
		
		<form action="updateBoard_proc.jsp" method="post">
		<input name="seq" type="hidden" value="<%= board.getSeq()%>"/>
		<table board="1" cellpadding="0" cellspacting="0">
			<tr>
				<td bgcolor="orange" width="70"> 제목 </td>
				<td align="left"><input name="title" type="text" 
									value="<%= board.getTitle()%>"/></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 작성자 </td>
				<td align="left"><input name="title" type="text" 
									value="<%= board.getWriter() %>"/></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 내용 </td>
				<td align="left"><textarea rows="10" cols="40" name="content"
				><%= board.getContent() %></textarea></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 등록일 </td>
				<td align="left"><%= board.getRegdate() %></td>
			</tr>
			
			<tr>
				<td bgcolor="orange"> 조회수 </td>
				<td align="left"><%=board.getCnt() %></td>
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
		<a href="deleteBoard.jsp?seq=<%= board.getSeq() %>">글 삭제</a>
		<a href="getBoardList.jsp">글 목록</a>
	</center>
</body>
</html>