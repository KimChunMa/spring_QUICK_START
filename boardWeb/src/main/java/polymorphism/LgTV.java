package polymorphism;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {System.out.println("lg��ü");}
	public void powerOn() {System.out.println("Lg ���� Ű��");}
	public void powerOff() {System.out.println("Lg ���� ����");}
	public void volumeUp() {speaker.volumeUp();}
	public void volumeDown() {speaker.volumeDown();}
}
