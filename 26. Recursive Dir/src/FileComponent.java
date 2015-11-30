import java.util.Iterator;

public abstract class FileComponent {
	public void add(FileComponent fileComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(FileComponent fileComponent) {
		throw new UnsupportedOperationException();
	}
	public FileComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}

	public abstract Iterator<FileComponent> createIterator();
 
	public void print() {
		throw new UnsupportedOperationException();
	}
}
