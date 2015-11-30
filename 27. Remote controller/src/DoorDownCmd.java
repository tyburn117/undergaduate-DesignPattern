
public class DoorDownCmd implements Command{
	GarageDoor door;
	
	public DoorDownCmd(GarageDoor door){this.door = door;}
	@Override
	public void execute() {
		door.up();
	}

}
