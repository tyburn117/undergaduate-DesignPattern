
public class DoorUpCmd implements Command{
	GarageDoor door;
	
	public DoorUpCmd(GarageDoor door){this.door = door;}
	@Override
	public void execute() {
		door.up();
	}

}
