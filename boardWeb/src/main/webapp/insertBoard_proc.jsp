<%@page import="Taining1.impl.BoardDAO"%>
<%@page import="Taining1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardDTO dto = new BoardDTO();
	dto.setTitle(title); dto.setWriter(writer); dto.setContent(content);
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(dto);
	
	response.sendRedirect("getBoardList.jsp");
%>