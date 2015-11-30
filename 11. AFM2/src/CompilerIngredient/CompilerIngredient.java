package CompilerIngredient;

import Parser.*;
import Scanner.*;
import CodeGenerator.*;
public interface CompilerIngredient {
	public Parser createParser();
	public Scanner createScanner();
	public CodeGenerator createCodeGenerator();
}
