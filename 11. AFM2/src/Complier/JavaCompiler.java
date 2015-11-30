package Complier;
import CompilerIngredient.*;

public class JavaCompiler extends MyCompiler{
	private CompilerIngredient ingredient;
	
	public JavaCompiler(){
		ingredient = new JavaCompilerIngredient();
	}
	@Override
	public void parse() {
		// TODO Auto-generated method stub
		ingredient.createParser().parse();
	}

	@Override
	public void scanner() {
		// TODO Auto-generated method stub
		ingredient.createScanner().scan();
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		ingredient.createCodeGenerator().generate();
	}

}
