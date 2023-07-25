package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Taining1.board.BoardDTO;
import Taining1.impl.BoardDAO;

public class DeleteBoardController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt( request.getParameter("seq") );
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(dto);
		return "getBoardList.do";
	}
}
