package CompilerIngredient;

import CodeGenerator.*;
import Parser.*;
import Scanner.*;

public class CCompilerIngredient implements CompilerIngredient {

	@Override
	public Parser createParser() {
		return new CParser();
	}

	@Override
	public Scanner createScanner() {
		// TODO Auto-generated method stub
		return new CScanner();
	}

	@Override
	public CodeGenerator createCodeGenerator() {
		// TODO Auto-generated method stub
		return new CCodeGenerator();
	}

}
