<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Taining1.impl.BoardDAO"%>
<%@page import="Taining1.board.BoardDTO"%>
<%
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();
	List<BoardDTO> boardlist = dao.getBoardList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1> 글 목록</h1>
		<h3> 테스트님 환영합니다 <a href="login_proc.jsp">Log out</a></h3>
		
		<!-- 검색 -->
		<form action="getBoardList.jsp" method="post"></form>
			<table board="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
						<input name="searchKeyword" type="text"/>
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="10" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="100">제목</th>
				<th bgcolor="orange" width="100">작성자</th>
				<th bgcolor="orange" width="100">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			
			<% for(BoardDTO board : boardlist){ %>
				<tr>
					<td> <%= board.getSeq() %> </td>
					<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq()%>"> 
									 <%= board.getTitle() %></a>  </td>
					<td><%= board.getWriter() %></td>
					<td><%= board.getRegdate() %></td>
					<td><%= board.getCnt() %></td>
				</tr>
			<% } %>
		</table>
		<br>
		
		<a href="insertBoard.jsp">새글 등록</a>
		
	</center>
</body>
</head>
</html>