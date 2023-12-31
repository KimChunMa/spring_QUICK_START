package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다
		TV tv = (TV)factory.getBean("tv"); 
		tv.volumeUp();
		
		//3. Spring 컨테이너를 종료한다.
		factory.close();
	}
}
