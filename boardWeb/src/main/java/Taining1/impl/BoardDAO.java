package Taining1.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import Taining1.board.BoardDTO;
import Taining1.util.JDBCUtill;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
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
	
	public void insertBoard(BoardDTO dto) {
		System.out.println("인설트");
		try {
			conn=JDBCUtill.getConnection();
			ps = conn.prepareStatement(BOARD_INSERT);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
	}
	
	public void updateBoard(BoardDTO dto) {
		System.out.println("수정");
		try {
			conn=JDBCUtill.getConnection();
			ps = conn.prepareStatement(BOARD_INSERT);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getWriter());
			ps.setString(3,dto.getContent());
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {JDBCUtill.close(ps, conn);}
	}	
	
	
	
}
