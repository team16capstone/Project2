package team16.project;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.awt.GLJPanel;

import team16.project.animation.MotionPath;

public class MyMouseMotionListener implements MouseMotionListener{
	View view;
	GLJPanel canvas;
	boolean recordPath = false;
	MotionPath mp;
	int i = 0;
	
	public MyMouseMotionListener(View view, GLJPanel canvas){
		this.view = view;
		this.canvas = canvas;
		mp = new MotionPath(false, new Point[1000]);
//		view.addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(recordPath){
			if(!view.ml.getrP()){
				mp = new MotionPath(false, new Point[1000]);
			}
			view.ml.setrP(true);
			if(mp.getPath()[0] == null){
				mp.getPath()[0] = new Point(e.getPoint().x,e.getPoint().y);
				i=1;
			}
				if(recordPath && (mp.getPath()[i-1].x != e.getPoint().x && mp.getPath()[i-1].y != e.getPoint().y) && i < 1000){
						mp.getPath()[i] = new Point(e.getPoint().x,canvas.getHeight() - e.getPoint().y);
						i++;
				}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void setRP(Boolean b){
		recordPath = b;
	}
	
	public Boolean getRP(){
		return recordPath;
	}
	
	public MotionPath getMP(){
		return mp;
	}

}
