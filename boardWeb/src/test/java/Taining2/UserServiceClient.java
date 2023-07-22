package Taining2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import Taining2.user.UserDTO;
import Taining2.user.UserService;

public class UserServiceClient {
	public static void main(String[] args) {
		//Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. lookup
		UserService userService = (UserService) container.getBean("userSerivce");
		
		UserDTO dto = new UserDTO();
		dto.setId("test2");
		dto.setPassword("test1234");
		dto.setName("ȫ�浿");
		dto.setRole("�Ϲ�");
		//userService.insertUser(dto);	
		System.out.println("Ȯ��: "+userService.getUser(dto).toString());
		
		//userService.error();
		
		container.close();
	}
}
