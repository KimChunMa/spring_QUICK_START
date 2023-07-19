package Taining1.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taining1.board.BoardDTO;
import Taining1.board.BoardService;

@Service("boardSerivce")
public class BoardServicelmpl implements BoardService{

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		boardDao.insertBoard(dto);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		boardDao.updateBoard(dto);	
	}

	@Override
	public void deleteBoard(BoardDTO dto) {
		boardDao.deleteBoard(dto);
	}

	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		return boardDao.getBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDao.getBoardList();
	}
	
}
