<%@page import="Taining1.impl.BoardDAO"%>
<%@page import="Taining1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int seq = Integer.parseInt( request.getParameter("seq"));
	
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();
	dto.setSeq(seq);
	dto = dao.getBoard(dto);
	
	dto.setTitle(title); dto.setContent(content);
	dao.updateBoard(dto);
	
	response.sendRedirect("getBoardList.jsp");
%>