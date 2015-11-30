
public class LightOnCmd implements Command{
	Light light;
	
	public LightOnCmd(Light l){light = l;}
	@Override
	public void execute() {
		light.on();
	}

}
