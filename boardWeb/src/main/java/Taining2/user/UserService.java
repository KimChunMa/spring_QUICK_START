package Taining2.user;

public interface UserService {
	//����
	void insertUser(UserDTO dto);
	
	//����
	UserDTO getUser(UserDTO dto);
	
	void error();
}