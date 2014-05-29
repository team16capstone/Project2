package team16.project;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.media.opengl.awt.GLJPanel;

import team16.project.animation.Bounce;
import team16.project.animation.MotionPath;
import team16.project.shapes.Circle;
import team16.project.shapes.Cross;
import team16.project.shapes.Shape;
import team16.project.shapes.Square;
import team16.project.shapes.Star;
import team16.project.shapes.Wave;

public class MyMouseListener implements MouseListener{
	View view;
	GLJPanel canvas;
	String type;
	boolean active;
	boolean rotate;
	boolean filled;
	int thickness;
	int size;
	Color rgb = new Color(0.0f,0.0f,0.0f);
	Bounce bounce;
	Boolean rP = false;

	public MyMouseListener(View view, GLJPanel canvas2) {
		this.view = view;
		this.canvas = canvas2;
		type = "";
		active = false;
		rotate = false;
		filled = false;
		thickness = 1;
		size = 1;
		bounce = new Bounce(false,1);
//		view.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getPoint().x;
		int y = arg0.getPoint().y;		
		if(active){
			active = false;
			view.getGlistener().addShape(x,y,canvas.getSize().width,canvas.getSize().height,type,size,view.getShapeColor(),filled,thickness,view.getRotate(),view.getBounce());
			if(view.getGlistener().getPause())
			view.getGlistener().setOnce();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(rP && view.getMMListener().getRP()){
			view.getMMListener().setRP(false);
			for(int az = 0; az < 1000; az++){
				if(view.getMMListener().getMP().getPath()[az]!=null){
				}
			}
			if(rP && !view.getMMListener().getRP() && view.getGlistener().getShapes()[0]!=null){
				view.setMotion(false);
				rP = false;
				switch (getShape()){
				case "circle":
					((Circle)getLastShape()).getAnimation().setMotionPath(new MotionPath(true, view.getMMListener().getMP().getPath()));
					((Circle)getLastShape()).getAnimation().getMotionPath().setMax();
				break;
				case "square":
					((Square)getLastShape()).getAnimation().setMotionPath(new MotionPath(true, view.getMMListener().getMP().getPath()));
					((Square)getLastShape()).getAnimation().getMotionPath().setMax();
				break;
				case "star":
					((Star)getLastShape()).getAnimation().setMotionPath(new MotionPath(true, view.getMMListener().getMP().getPath()));
					((Star)getLastShape()).getAnimation().getMotionPath().setMax();
				break;
				case "cross":
					((Cross)getLastShape()).getAnimation().setMotionPath(new MotionPath(true, view.getMMListener().getMP().getPath()));
					((Cross)getLastShape()).getAnimation().getMotionPath().setMax();
				break;
				case "wave":
					((Wave)getLastShape()).getAnimation().setMotionPath(new MotionPath(true, view.getMMListener().getMP().getPath()));
					((Wave)getLastShape()).getAnimation().getMotionPath().setMax();
				break;
				}
				rP = false;
			}
		}

	}
	
	public void setActive(boolean active){
		this.active = active;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setSize(int size){
		this.size = size;
	}

	public void setFilled(boolean filled){
		this.filled = filled;
	}
	public void setThickness(int thickness){
		this.thickness = thickness;
	}
	public void setBounce(Bounce bounce){
		this.bounce = bounce;
	}	
	
	
	public String getShape(){
		if(view.getGlistener().getShapes()[getLastShapePosition()].getType().equals("cross"))
			return "cross";
		else if(view.getGlistener().getShapes()[getLastShapePosition()].getType().equals("circle"))
			return "circle";
		else if(view.getGlistener().getShapes()[getLastShapePosition()].getType().equals("square"))
			return "square";
		else if(view.getGlistener().getShapes()[getLastShapePosition()].getType().equals("star"))
			return "star";
		else
			return "wave";
		}
	
	public Shape getLastShape(){
		return view.getGlistener().getShapes()[getLastShapePosition()];
	}
	
    public int getLastShapePosition(){
		int a = 0;
		for(int i = 0;view.getGlistener().getShapes()[i]!=null;i++)
		{
			a = i+1;
		}
		return a-1;
    }
    
    public void setrP(Boolean b){
    	rP = b;
    }
    
    public Boolean getrP(){
    	return rP;
    }
}