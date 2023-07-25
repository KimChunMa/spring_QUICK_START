package Taining1;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import Taining1.board.BoardDTO;
import Taining1.board.BoardService;

public class BoardServiceClient {
	public static void main(String[] args) {
		//Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. lookup
		BoardService boardService = (BoardService) container.getBean("boardSerivce");
		
		//3.�� ��� ��� �׽�Ʈ
		
		 BoardDTO dto = new BoardDTO(); 
		 dto.setTitle("�ӽ�����"); dto.setWriter("ȫ�浿");
		 dto.setContent("�ӽó���.."); 
		 boardService.insertBoard(dto);
		dto.setSeq(3); 
		System.out.println(boardService.getBoard(dto));
		 
		//4.�� �˻�
		List<BoardDTO> list = boardService.getBoardList();
		for(BoardDTO board : list) {
			System.out.println(board.toString());
			System.out.println();
		}
		
		
	}
}
