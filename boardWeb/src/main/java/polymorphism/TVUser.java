package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�
		TV tv = (TV)factory.getBean("tv"); 
		tv.volumeUp();
		
		//3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
	}
}