package Complier;

import CompilerIngredient.*;

public class CCompiler extends MyCompiler{
	private CompilerIngredient ingredient;
	
	public CCompiler(){
		ingredient = new CCompilerIngredient();
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
