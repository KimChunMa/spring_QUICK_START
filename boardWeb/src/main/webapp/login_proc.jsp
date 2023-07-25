<%@page import="Taining2.user.impl.UserDAO"%>
<%@page import="Taining2.user.UserDTO"%>
<%
	//1.정보 추출
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//2. DB
	UserDTO dto = new UserDTO();
	dto.setId(id); dto.setPassword(pw);
	
	UserDAO dao = new UserDAO();
	UserDTO login = dao.getUser(dto);
	
	if(login != null){
		response.sendRedirect("getBoardList.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
%>