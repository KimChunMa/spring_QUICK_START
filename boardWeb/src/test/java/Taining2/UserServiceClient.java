package Taining2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import Taining2.user.UserDTO;
import Taining2.user.UserService;

public class UserServiceClient {
	public static void main(String[] args) {
		//Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. lookup
		UserService userService = (UserService) container.getBean("userSerivce");
		
		UserDTO dto = new UserDTO();
		dto.setId("test2");
		dto.setPassword("test1234");
		dto.setName("홍길동");
		dto.setRole("일반");
		//userService.insertUser(dto);	
		System.out.println("확인: "+userService.getUser(dto).toString());
		
		//userService.error();
		
		container.close();
	}
}
