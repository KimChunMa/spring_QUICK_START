package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("���� ��ü ����");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("���� �Ҹ� �� ");
	}

	@Override
	public void volumeDown() {
		System.out.println("���� �Ҹ� �ٿ� ");
	}
	
}
