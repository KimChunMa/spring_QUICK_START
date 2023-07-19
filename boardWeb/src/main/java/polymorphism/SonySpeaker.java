package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {System.out.println("소니 생성");}
	
	public void volumeUp() {System.out.println("소니스피커 볼륨업");}
	public void volumeDown() {System.out.println("소니스피커 볼륨다운");}
	
}
