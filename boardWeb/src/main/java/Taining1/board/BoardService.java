package Taining1.board;

import java.util.List;

public interface BoardService {
	
	//삽입
	void insertBoard(BoardDTO dto);

	//업데이트
	void updateBoard(BoardDTO dto);

	//삭제
	void deleteBoard(BoardDTO dto);

	//상세 글
	BoardDTO getBoard(BoardDTO dto);
	//모든 글
	List<BoardDTO> getBoardList();

}