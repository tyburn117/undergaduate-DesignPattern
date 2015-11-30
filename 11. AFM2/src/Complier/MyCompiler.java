package Complier;


import CompilerIngredient.*;
public abstract class MyCompiler {
	protected CompilerIngredient compilerIngredient;
	public void compile(){
		parse();
		scanner();
		generate();
		System.out.println("------ Done.");
	}
	public abstract void parse();
	public abstract void scanner();
	public abstract void generate();
}
