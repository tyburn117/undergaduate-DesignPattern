import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class ImageComponent extends JComponent{
	private Icon icon;
	
	public ImageComponent(Icon icon){
		this.icon = icon;
	}
	public void setIcon(Icon icon){
		this.icon = icon;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int w = icon.getIconWidth();
		int h = icon.getIconHeight();
		int x = (800 -w )/2;
		int y = (600-h)/2;
		icon.paintIcon(this, g, x, y);
	}
}

class ImageProxy implements Icon{
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
	
	public ImageProxy(URL url){
		imageURL = url;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		if(imageIcon != null)
			imageIcon.paintIcon(c, g, x, y);
		else{
			g.drawString("Loading CD cover, please wait...", x+300, y+190);
			if(!retrieving){
				retrieving = true;
				
				retrievalThread = new Thread(new Runnable(){
					public void run(){
						try{
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}

	@Override
	public int getIconWidth() {
		if(imageIcon != null)
			return imageIcon.getIconWidth();
		return 800;
	}

	@Override
	public int getIconHeight() {
		if(imageIcon != null)
			return imageIcon.getIconHeight();
		return 600;
	}
	
}



public class ImageProxyTestDrive {
	ImageComponent imageComponent; 
	JFrame frame = new JFrame("CD Cover Viewer");
	JMenuBar menuBar;
	JMenu menu;
	Hashtable<String,String> cds = new Hashtable<String, String>();
	public ImageProxyTestDrive() throws Exception{
		cds.put("Ambient: Music for Airpots", "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
		cds.put("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
		cds.put("Ima", "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
		cds.put("Karma", "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
		cds.put("MCMXC A.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
		cds.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
		cds.put("Selected Ambient Works, Vol.2", "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
	
		URL initialURL = new URL((String)cds.get("Selected Ambient Works, Vol.2"));
		menuBar = new JMenuBar();
		menu = new JMenu("Favorite CDs");
		menuBar.add(menu);
		
		frame.setJMenuBar(menuBar);
		
		for(Enumeration e = cds.keys(); e.hasMoreElements();){
			String name = (String)e.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			menu.add(menuItem);
			menuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					imageComponent.setIcon(new ImageProxy(getCDUrl(e.getActionCommand())));
					frame.repaint();
				}
				
			});
		}
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	URL getCDUrl(String name){
		try{return new URL((String)cds.get(name));}
		catch(MalformedURLException e){e.printStackTrace(); return null;}
	}
	public static void main(String [] args) throws Exception{
		ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
	}
}
