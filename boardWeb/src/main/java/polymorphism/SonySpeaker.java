package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {System.out.println("�Ҵ� ����");}
	
	public void volumeUp() {System.out.println("�ҴϽ���Ŀ ������");}
	public void volumeDown() {System.out.println("�ҴϽ���Ŀ �����ٿ�");}
	
}
