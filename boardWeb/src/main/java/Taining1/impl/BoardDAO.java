package Taining1.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Taining1.board.BoardDTO;
import utill.JDBCUtill;

@Repository("boardDAO")
public class BoardDAO {
	private final Connection conn = JDBCUtill.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = 
			"insert into board(seq,title, writer, content) values( (select nvl(max(seq),0)+1 from board),?,?,? )";
	private final String BOARD_UPDATE = 
			"update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = 
			"delete board where seq=?";
	private final String BOARD_GET = 
			"select * from board where seq=?";
	private final String BOARD_LIST = 
			"select * from board order by seq desc";
	
	//삽입
	public void insertBoard(BoardDTO dto) {
		System.out.println("인설트");
		try {
			ps = conn.prepareStatement(BOARD_INSERT);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//업데이트
	public void updateBoard(BoardDTO dto) {
		System.out.println("수정");
		try {
			ps = conn.prepareStatement(BOARD_UPDATE);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
	}	
	
	//삭제
	public void deleteBoard(BoardDTO dto) {
		System.out.println("수정");
		try {
			ps = conn.prepareStatement(BOARD_DELETE);
			ps.setInt(1,dto.getSeq());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
	}	
	
	//상세글 조회
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("수정");
		try {
			ps = conn.prepareStatement(BOARD_GET);
			ps.setInt(1,dto.getSeq());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				return board;
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
		return null;
	}
	
	//전체 글 조회
	public List<BoardDTO> getBoardList(){
		System.out.println("전체출력");
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			ps = conn.prepareStatement(BOARD_LIST);
			rs=ps.executeQuery();
			System.out.println("오류안남");
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				list.add(board);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
		return list;
	}
	
	
}
