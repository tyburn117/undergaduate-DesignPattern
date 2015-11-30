
interface Image {
	public void showImage();
}

class RealImage implements Image{
	private String 파일명 = null;
	
	public RealImage(final String FILENAME){
		파일명 = FILENAME;
		loadImageFromDisk();
	}
	
	@Override
	public void showImage() {
		// TODO Auto-generated method stub
		System.out.println("Showing " + 파일명 );
	}
	public void loadImageFromDisk(){
		long sum = 0;
		for(int i = 0 ; i < 100000; i++){
			for(int j = 0 ; j < 300000 ; j++){
				sum++;
			}
		}
			
		System.out.println("load complete, loopNum: "+sum);
		
		
	}
}

class ProxyImage implements Image{
	private String 파일명 = null;
	private Image image = null;
	
	public ProxyImage(final String FILENAME){
		파일명 = FILENAME;
	}
	@Override
	public void showImage() {
		// TODO Auto-generated method stub
		if(image == null) image = new RealImage(파일명);
		image.showImage();
	}
	
	
}
public class ProxyExample{
	
	public static void main(String [] args){
		final Image IMAGE1 = new ProxyImage("사진1");
		final Image IMAGE2 = new ProxyImage("사진2");
		
		IMAGE1.showImage();
		IMAGE1.showImage();
		
		IMAGE2.showImage();
		IMAGE2.showImage();
		
	}
}
