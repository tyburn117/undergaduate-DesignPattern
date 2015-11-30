package CompilerIngredient;

import CodeGenerator.*;
import Parser.*;
import Scanner.*;

public class JavaCompilerIngredient implements CompilerIngredient {

	@Override
	public Parser createParser() {
		// TODO Auto-generated method stub
		return new JavaParser();
	}

	@Override
	public Scanner createScanner() {
		// TODO Auto-generated method stub
		return new JavaScanner();
	}

	@Override
	public CodeGenerator createCodeGenerator() {
		// TODO Auto-generated method stub
		return new JavaCodeGenerator();
	}

}
