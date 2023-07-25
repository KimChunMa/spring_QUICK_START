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
	
	//����
	public void insertBoard(BoardDTO dto) {
		System.out.println("�μ�Ʈ");
		try {
			ps = conn.prepareStatement(BOARD_INSERT);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//글 수정
	public void updateBoard(BoardDTO dto) {
		System.out.println("updateBoard");
		try {
			ps = conn.prepareStatement(BOARD_UPDATE);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getContent());
			ps.setInt(3,dto.getSeq());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {}
	}	
	
	//글 삭제
	public void deleteBoard(BoardDTO dto) {
		System.out.println("deleteBoard");
		try {
			ps = conn.prepareStatement(BOARD_DELETE);
			ps.setInt(1,dto.getSeq());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {}
	}	
	
	//게시판 얻기
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("DAO getBoard");
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
		finally {}
		return null;
	}
	
	//전체 게시판
	public List<BoardDTO> getBoardList(){
		System.out.println("getBoardList");
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			ps = conn.prepareStatement(BOARD_LIST);
			rs=ps.executeQuery();
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
		finally {}
		return list;
	}
	
	
}
