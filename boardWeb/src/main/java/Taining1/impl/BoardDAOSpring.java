package Taining1.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import Taining1.board.BoardDTO;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport{
	private final String Insert = "insert into board(seq,title,writer,content) "
								+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String Update = "update board set title=?,content=? where seq=?";
	
	private final String Delete = "delete board where seq=?";
	
	private final String Get = "select * from board where seq=?";
	
	private final String List = "select * from board order by seq desc";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public void insertBoard(BoardDTO dto) {
		System.out.println("Spring JDBC 기능 insert");	
		getJdbcTemplate().update(Insert,dto.getTitle(), dto.getWriter(), dto.getContent());
	}
	
	public void updateBoard(BoardDTO dto) {
		System.out.println("Spring JDBC 기능 update");	
		getJdbcTemplate().update(Update,dto.getTitle(), dto.getWriter(), dto.getContent());
	}
	
	public void deleteBoard(BoardDTO dto) {
		System.out.println("Spring JDBC 기능 delete");	
		getJdbcTemplate().update(Delete,dto.getSeq());
	}
	
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("Spring JDBC 기능 get");	
		Object[] args = {dto.getSeq()};
		return getJdbcTemplate().queryForObject(Get, args,new BoardRowMapper());
	}
	
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("Spring JDBC 기능 List");	
		return getJdbcTemplate().query(List, new BoardRowMapper());
	}
	

	public class BoardRowMapper implements RowMapper<BoardDTO>{
		@Override
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDTO board = new BoardDTO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegdate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			return board;
		}
		

	}
}


