
public class RemoteControlTest {
	public static void main(String [] args){
		Light 거실등 = new Light();
		GarageDoor 차고문 = new GarageDoor();
		
		LightOnCmd 거실등켜기 = new LightOnCmd(거실등);
		LightOffCmd 거실등끄기 = new LightOffCmd(거실등);
		DoorUpCmd 차고문올리기 = new DoorUpCmd(차고문);
		DoorDownCmd 차고문내리기 = new DoorDownCmd(차고문);
		
		RemoteController 리모콘 = new RemoteController();
		
		리모콘.setCommand(0, 거실등켜기);
		리모콘.setCommand(1,거실등끄기);
		리모콘.setCommand(2, 차고문올리기);
		리모콘.setCommand(3, 차고문내리기);
		
		리모콘.buttonPushed(0);
		리모콘.buttonPushed(1);
		리모콘.buttonPushed(2);
		리모콘.buttonPushed(3);
		
	}
}
