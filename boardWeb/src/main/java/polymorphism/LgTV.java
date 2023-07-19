package polymorphism;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {System.out.println("lg객체");}
	public void powerOn() {System.out.println("Lg 전원 키기");}
	public void powerOff() {System.out.println("Lg 전원 끄기");}
	public void volumeUp() {speaker.volumeUp();}
	public void volumeDown() {speaker.volumeDown();}
}
