package Taining1;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import Taining1.board.BoardDTO;
import Taining1.board.BoardService;

public class BoardServiceClient {
	public static void main(String[] args) {
		//Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. lookup
		BoardService boardService = (BoardService) container.getBean("boardSerivce");
		
		//3.글 등록 기능 테스트
		
		 BoardDTO dto = new BoardDTO(); 
		 dto.setTitle("임시제목"); dto.setWriter("홍길동");
		 dto.setContent("임시내용.."); 
		 boardService.insertBoard(dto);
		dto.setSeq(3); 
		System.out.println(boardService.getBoard(dto));
		 
		//4.글 검색
		List<BoardDTO> list = boardService.getBoardList();
		for(BoardDTO board : list) {
			System.out.println(board.toString());
			System.out.println();
		}
		
		
	}
}
