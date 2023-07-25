package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Taining2.user.UserDTO;
import Taining2.user.impl.UserDAO;

public class LoginController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//1.정보 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//2. DB
		UserDTO dto = new UserDTO();
		dto.setId(id); dto.setPassword(pw);
		
		UserDAO dao = new UserDAO();
		UserDTO login = dao.getUser(dto);
		
		if(login != null){return "getBoardList.do";}
		else{return "login";} 
	}
}
