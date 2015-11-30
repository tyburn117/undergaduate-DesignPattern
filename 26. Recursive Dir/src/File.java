import java.util.Iterator;

public class File extends FileComponent implements Iteratable{

	private String name;
	
	public File (String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public Iterator<FileComponent> createIterator() {
		// TODO Auto-generated method stub
		return new NullIterator();
	}

	public void print(){
		System.out.println("        -- "+getName());
		
	}
}
