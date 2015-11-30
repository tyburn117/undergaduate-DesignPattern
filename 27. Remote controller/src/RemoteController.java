
public class RemoteController {
	Command[] commands;
	
	public RemoteController(){
		commands = new Command[10];
	}
	
	public void setCommand(int slot, Command cmd){
		commands[slot] = cmd;
	}
	public void buttonPushed(int slot){
		commands[slot].execute();
	}
}
