package Taining1.board;

import java.util.List;

public interface BoardService {
	
	//����
	void insertBoard(BoardDTO dto);

	//������Ʈ
	void updateBoard(BoardDTO dto);

	//����
	void deleteBoard(BoardDTO dto);

	//�� ��
	BoardDTO getBoard(BoardDTO dto);
	//��� ��
	List<BoardDTO> getBoardList();

}