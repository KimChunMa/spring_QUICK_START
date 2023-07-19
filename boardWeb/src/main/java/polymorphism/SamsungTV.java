package polymorphism;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {System.out.println("�Ｚ��ü����");}
	
	public void setSpeaker(Speaker speaker) {this.speaker = speaker;
		System.out.println("�ＺƼ�� set speaker");
	}

	public void setPrice(int price) {this.price = price;
		System.out.println("�ＺƼ�� set price");
	}

	public void powerOn() {System.out.println("�Ｚ ���� Ű�� " + price);}
	
	public void powerOff() {System.out.println("�Ｚ ���� ����");}
	
	
	public void volumeUp() { speaker.volumeUp();}
	
	public void volumeDown() {speaker.volumeDown();}
}