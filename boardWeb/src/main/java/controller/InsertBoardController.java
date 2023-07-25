package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Taining1.board.BoardDTO;
import Taining1.impl.BoardDAO;

public class InsertBoardController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title); dto.setWriter(writer); dto.setContent(content);
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		return "getBoardList.do";
	}
}
