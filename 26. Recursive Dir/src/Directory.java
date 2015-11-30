import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FileComponent implements Iteratable {

	Iterator<FileComponent> iterator = null;
	ArrayList<FileComponent> fileComponents = new ArrayList<FileComponent>();
	String name;
	
	public void add(FileComponent fileComponent) {
		fileComponents.add(fileComponent);
	}
 
	public void remove(FileComponent fileComponent) {
		fileComponents.remove(fileComponent);
	}
 
	public FileComponent getChild(int i) {
		return fileComponents.get(i);
	}
	public Directory(String name){
		this.name = name;
		java.io.File dir = new java.io.File(name);
		java.io.File[] fileList = dir.listFiles();
		
		try{
			for(int i = 0 ; i < fileList.length; i++){
				java.io.File file = fileList[i];
				if(file.isFile())
					add(new File(file.getName()));
				else
					add(new Directory(file.getAbsolutePath()));	
			}
		}catch(Exception e){
			
		}
	}
	public String getName() {
		return name;
	}
	
	@Override
	public Iterator<FileComponent> createIterator() {
		if (iterator == null) {
			iterator = new CompositeIterator(fileComponents.iterator());
		}
		return iterator;
	}
	
	public void print(){
		System.out.println("\n" +"현재 폴더 : "+ getName());
		System.out.println("파일들------------------------------------------------");
		
		Iterator<FileComponent> iter = fileComponents.iterator();
		while(iter.hasNext()){
			FileComponent fileComponent = iter.next();
			fileComponent.print();
		}
	}
}
