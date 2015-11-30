 
import java.util.Iterator;
  
public class NullIterator implements Iterator<FileComponent> {
   
	public FileComponent next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}
   
	
}
