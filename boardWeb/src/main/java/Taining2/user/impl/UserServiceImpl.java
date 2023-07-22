package Taining2.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Taining2.user.UserDTO;
import Taining2.user.UserService;

@Service("userSerivce")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void insertUser(UserDTO dto) {
		userDAO.InsertUser(dto);
	}

	@Override
	public UserDTO getUser(UserDTO dto) {
		System.out.println("Dao실행전");
		return userDAO.getUser(dto);
	}	
	
	@Override
	public void error() {
		throw new IllegalArgumentException("ill어쩌구");
	}
}
