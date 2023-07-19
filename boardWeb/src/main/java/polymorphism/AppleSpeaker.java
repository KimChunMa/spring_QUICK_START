package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("局敲 按眉 积己");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("局敲 家府 诀 ");
	}

	@Override
	public void volumeDown() {
		System.out.println("局敲 家府 促款 ");
	}
	
}
