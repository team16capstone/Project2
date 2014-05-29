package team16.project;

import java.awt.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;

import javax.imageio.ImageIO;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFileChooser;


public class Record {
	protected int j = 0;
	protected boolean stop = false;
	BufferedImage image, img, next;
	Component component;
	File test;
	int i = 0;

	public Record(Component component){
		this.component = component;

	}
	public BufferedImage getScreenShot() {
		if(component.getWidth() > 0)
	      image = new BufferedImage(
	      component.getWidth(),
	      component.getHeight(),
	      BufferedImage.TYPE_INT_RGB
	      );
		else
		      image = new BufferedImage(
		    	      1,
		    	      1,
		    	      BufferedImage.TYPE_INT_RGB
		    	      );
		    component.paint( image.getGraphics() );
		    return image;
		  }
	public void saveImg(final GLJPanel canvas) {
		stop = false;
		Runnable task = new Runnable(){
			@Override
			public void run(){
	while(!stop){
//		try {
//			Thread.sleep(15);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		img = getScreenShot();
          try {
            // Save the Image as a PNG in a temp directory - Send later for processing
            ImageIO.write(img,"jpeg",new File("tmp/" + i + ".jpeg"));
          } catch(Exception e) {
            e.printStackTrace();
          }
          i++;
        }
	}
	}; new Thread(task, "Service Thread").start();
	}
	public void initFolder() {
		File folder = new File("tmp/");
	    File[] files = folder.listFiles();
	    if(files!=null) {
	        for(File f: files) {
	                f.delete();
	        }
	    }
	}
	public void exportMovie(){
		if(!haveMoreVideo()){
			return;
		}
		JFileChooser f = new JFileChooser();
		f.showSaveDialog(component);
		if(f.getSelectedFile()==null)
			return;
		j = 0;
		IMediaWriter encoder = ToolFactory.makeWriter(f.getSelectedFile().getPath()+".mp4");
		encoder.addVideoStream(0, 0, component.getWidth(), component.getHeight());
		
//		long startTime = System.nanoTime();
		while (haveMoreVideo()){
			image = getImage();
			encoder.encodeVideo(0, image, System.currentTimeMillis()+j*20, TimeUnit.MILLISECONDS);
		}
		encoder.close();
	}

	private BufferedImage getImage() {
		next = null;
		try {
			next = ImageIO.read(new File("tmp/" + j + ".jpeg"));
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			j++;
		}
		return next;
	}

	private boolean haveMoreVideo() {
		test = new File("tmp/" + j + ".jpeg");
		if (test.exists()){
			return true;
		} else {
			return false;
		}
	}
	
	public void setStop(){
		stop = true;
	}
	
	public void resetI(){
		i = 0;
	}
  

}
