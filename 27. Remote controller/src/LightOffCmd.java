
public class LightOffCmd implements Command{
	Light light;
	
	public LightOffCmd(Light l){light = l;}
	@Override
	public void execute() {
		light.off();
	}

}
