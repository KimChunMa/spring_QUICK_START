package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Taining1.board.BoardDTO;
import Taining1.impl.BoardDAO;

public class UpdateBoardController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt( request.getParameter("seq") );
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		
		BoardDAO dao = new BoardDAO();
		dto = dao.getBoard(dto);
		dto.setTitle(title); dto.setContent(content);
		dao.updateBoard(dto);
		return "getBoardList.do";
	}
}
