package Taining2.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import Taining2.user.UserDTO;
import utill.JDBCUtill;

@Repository("userDAO")
public class UserDAO {

	private final Connection conn = JDBCUtill.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private final String USER_GET = 
			"select * from users where id=? and password=?";
	private final String USER_INSERT = 
			"insert into users(id, password, name, role) values(?,?,?,?)";
	

	//삽입
	public void InsertUser(UserDTO dto) {
		System.out.println("인설트");
		try {
			System.out.println(dto);
			ps = conn.prepareStatement(USER_INSERT);
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getPassword());
			ps.setString(3,dto.getName());
			ps.setString(4,dto.getRole());
			ps.executeUpdate();
			System.out.println("삽입성공");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//get
	public UserDTO getUser(UserDTO dto) {
		System.out.println("[DAO]유저정보확인");
		
		try {
			ps = conn.prepareStatement(USER_GET);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			rs=ps.executeQuery();
			
				if(rs.next()) {
					UserDTO user = new UserDTO();
					user.setId(rs.getString("ID"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setName(rs.getString("NAME"));
					user.setRole(rs.getString("ROLE"));
					return user;
				}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
