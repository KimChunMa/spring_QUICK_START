package polymorphism;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {System.out.println("»ï¼º°´Ã¼»ý¼º");}
	
	public void setSpeaker(Speaker speaker) {this.speaker = speaker;
		System.out.println("»ï¼ºÆ¼ºñ set speaker");
	}

	public void setPrice(int price) {this.price = price;
		System.out.println("»ï¼ºÆ¼ºñ set price");
	}

	public void powerOn() {System.out.println("»ï¼º Àü¿ø Å°±â " + price);}
	
	public void powerOff() {System.out.println("»ï¼º Àü¿ø ²ô±â");}
	
	
	public void volumeUp() { speaker.volumeUp();}
	
	public void volumeDown() {speaker.volumeDown();}
}