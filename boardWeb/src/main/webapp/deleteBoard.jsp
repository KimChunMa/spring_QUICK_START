<%@page import="Taining1.impl.BoardDAO"%>
<%@page import="Taining1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	int seq = Integer.parseInt( request.getParameter("seq"));

	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();

	dto.setSeq(seq);
	dao.deleteBoard(dto);
	
	response.sendRedirect("getBoardList.jsp");
%>