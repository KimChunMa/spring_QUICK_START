package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Taining1.board.BoardDTO;
import Taining1.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> boardList = dao.getBoardList();
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}
	
}
