package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Taining1.board.BoardDTO;
import Taining1.impl.BoardDAO;

public class GetBoardController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt( request.getParameter("seq") );
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		dto.setSeq(seq);
		dto = dao.getBoard(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("board", dto);
		return "getBoard";
	}
}
