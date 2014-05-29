package team16.project.animation;

import java.io.Serializable;

import javax.media.opengl.GL2;

import team16.project.shapes.Circle;
import team16.project.shapes.Cross;
import team16.project.shapes.Shape;
import team16.project.shapes.Square;
import team16.project.shapes.Star;
import team16.project.shapes.Wave;

public class Animation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Bounce bounce;
	private MotionPath path;
	private Rotate rotate;
	private Tail tail;
	
	public Animation(Rotate rotate,Bounce bounce, MotionPath path, Tail tail){
		this.rotate = rotate;
		this.bounce = bounce;
		this.path = path;
		this.tail = tail;
	}
	
	public void setRotateData(Rotate rotate){
		this.rotate = rotate;
	}
	public void setBounce(Bounce bounce){
		this.bounce = bounce;
	}
	public void setMotionPath(MotionPath path){
		this.path = path;
	}
	public MotionPath getMotionPath(){
		return path;
	}
	
	public void setTail(Tail tail){
		this.tail = tail;
	}
	
	public Tail getTail(){
		return tail;
	}
	
	public void turnOff(){
		bounce.setActive(false);
		rotate.setState(false);
		path.setState(false);
		tail.setActive(false);
	}
	public void doAnimations(GL2 gl2, Shape shape, float angle){
		/**BOUNCE ANIMATION BEGINS HERE*/
		if(bounce.getBounce())
		{
			if(shape.getType().equals("square")){
				if(bounce.getbUp())
					if(bounce.getbRight())
						if(((Square)shape).getY()<((Square)shape).getHeight()-((Square)shape).getSize())
							if(((Square)shape).getX()<((Square)shape).getWidth()-((Square)shape).getSize())
								((Square)shape).setXY(((Square)shape).getX()+bounce.getSpeed(), ((Square)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(false);
					else
						if(((Square)shape).getY()<((Square)shape).getHeight()-((Square)shape).getSize())
							if(((Square)shape).getX()>0+((Square)shape).getSize())
								((Square)shape).setXY(((Square)shape).getX()-bounce.getSpeed(), ((Square)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(false);
				else
					if(bounce.getbRight())
						if(((Square)shape).getY()>0+((Square)shape).getSize())
							if(((Square)shape).getX()<((Square)shape).getWidth()-((Square)shape).getSize())
								((Square)shape).setXY(((Square)shape).getX()+bounce.getSpeed(), ((Square)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(true);
					else
						if(((Square)shape).getY()>0+((Square)shape).getSize())
							if(((Square)shape).getX()>0+((Square)shape).getSize())
								((Square)shape).setXY(((Square)shape).getX()-bounce.getSpeed(), ((Square)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(true);
			}
			else if(shape.getType().equals("cross")){
				if(bounce.getbUp())
					if(bounce.getbRight())
						if(((Cross)shape).getY()<((Cross)shape).getHeight()-((Cross)shape).getSize())
							if(((Cross)shape).getX()<((Cross)shape).getWidth()-((Cross)shape).getSize())
								((Cross)shape).setXY(((Cross)shape).getX()+bounce.getSpeed(), ((Cross)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(false);
					else
						if(((Cross)shape).getY()<((Cross)shape).getHeight()-((Cross)shape).getSize())
							if(((Cross)shape).getX()>0+((Cross)shape).getSize())
								((Cross)shape).setXY(((Cross)shape).getX()-bounce.getSpeed(), ((Cross)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(false);
				else
					if(bounce.getbRight())
						if(((Cross)shape).getY()>0+((Cross)shape).getSize())
							if(((Cross)shape).getX()<((Cross)shape).getWidth()-((Cross)shape).getSize())
								((Cross)shape).setXY(((Cross)shape).getX()+bounce.getSpeed(), ((Cross)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(true);
					else
						if(((Cross)shape).getY()>0+((Cross)shape).getSize())
							if(((Cross)shape).getX()>0+((Cross)shape).getSize())
								((Cross)shape).setXY(((Cross)shape).getX()-bounce.getSpeed(), ((Cross)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(true);
			}
			else if(shape.getType().equals("circle")){
				if(bounce.getbUp())
					if(bounce.getbRight())
						if(((Circle)shape).getY()<((Circle)shape).getHeight()-((Circle)shape).getSize())
							if(((Circle)shape).getX()<((Circle)shape).getWidth()-((Circle)shape).getSize())
								((Circle)shape).setXY(((Circle)shape).getX()+bounce.getSpeed(), ((Circle)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(false);
					else
						if(((Circle)shape).getY()<((Circle)shape).getHeight()-((Circle)shape).getSize())
							if(((Circle)shape).getX()>0+((Circle)shape).getSize())
								((Circle)shape).setXY(((Circle)shape).getX()-bounce.getSpeed(), ((Circle)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(false);
				else
					if(bounce.getbRight())
						if(((Circle)shape).getY()>0+((Circle)shape).getSize())
							if(((Circle)shape).getX()<((Circle)shape).getWidth()-((Circle)shape).getSize())
								((Circle)shape).setXY(((Circle)shape).getX()+bounce.getSpeed(), ((Circle)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(true);
					else
						if(((Circle)shape).getY()>0+((Circle)shape).getSize())
							if(((Circle)shape).getX()>0+((Circle)shape).getSize())
								((Circle)shape).setXY(((Circle)shape).getX()-bounce.getSpeed(), ((Circle)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(true);
			}
			else if(shape.getType().equals("wave")){
				if(bounce.getbUp())
					if(bounce.getbRight())
						if(((Wave)shape).getY()<((Wave)shape).getHeight()-((Wave)shape).getSize())
							if(((Wave)shape).getX()<((Wave)shape).getWidth()-((Wave)shape).getSize())
								((Wave)shape).setXY(((Wave)shape).getX()+bounce.getSpeed(), ((Wave)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(false);
					else
						if(((Wave)shape).getY()<((Wave)shape).getHeight()-((Wave)shape).getSize())
							if(((Wave)shape).getX()>0+((Wave)shape).getSize())
								((Wave)shape).setXY(((Wave)shape).getX()-bounce.getSpeed(), ((Wave)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(false);
				else
					if(bounce.getbRight())
						if(((Wave)shape).getY()>0+((Wave)shape).getSize())
							if(((Wave)shape).getX()<((Wave)shape).getWidth()-((Wave)shape).getSize())
								((Wave)shape).setXY(((Wave)shape).getX()+bounce.getSpeed(), ((Wave)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(true);
					else
						if(((Wave)shape).getY()>0+((Wave)shape).getSize())
							if(((Wave)shape).getX()>0+((Wave)shape).getSize())
								((Wave)shape).setXY(((Wave)shape).getX()-bounce.getSpeed(), ((Wave)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(true);
			}
			else if(shape.getType().equals("star")){
				if(bounce.getbUp())
					if(bounce.getbRight())
						if(((Star)shape).getY()<((Star)shape).getHeight()-((Star)shape).getSize())
							if(((Star)shape).getX()<((Star)shape).getWidth()-((Star)shape).getSize())
								((Star)shape).setXY(((Star)shape).getX()+bounce.getSpeed(), ((Star)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(false);
					else
						if(((Star)shape).getY()<((Star)shape).getHeight()-((Star)shape).getSize())
							if(((Star)shape).getX()>0+((Star)shape).getSize())
								((Star)shape).setXY(((Star)shape).getX()-bounce.getSpeed(), ((Star)shape).getY()+bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(false);
				else
					if(bounce.getbRight())
						if(((Star)shape).getY()>0+((Star)shape).getSize())
							if(((Star)shape).getX()<((Star)shape).getWidth()-((Star)shape).getSize())
								((Star)shape).setXY(((Star)shape).getX()+bounce.getSpeed(), ((Star)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(false);
						else
							bounce.setbUp(true);
					else
						if(((Star)shape).getY()>0+((Star)shape).getSize())
							if(((Star)shape).getX()>0+((Star)shape).getSize())
								((Star)shape).setXY(((Star)shape).getX()-bounce.getSpeed(), ((Star)shape).getY()-bounce.getSpeed());
							else
								bounce.setbRight(true);
						else
							bounce.setbUp(true);
			}
		}
		
		
		
		/**MOTION PATH ANIMATION BEGINS HERE*/
		if(path.getState() && !bounce.getBounce())
		{
			if(shape.getType().equals("circle")){
				((Circle)(shape)).setXY((int)(path.getPath()[path.getInc()].getX()), (int)(path.getPath()[path.getInc()].getY()));
				path.increment();
			}
			else if (shape.getType().equals("cross")){
				((Cross)(shape)).setXY((int)(path.getPath()[path.getInc()].getX()), (int)(path.getPath()[path.getInc()].getY()));
				path.increment();
			}
			else if (shape.getType().equals("square")){
				((Square)(shape)).setXY((int)(path.getPath()[path.getInc()].getX()), (int)(path.getPath()[path.getInc()].getY()));
				path.increment();
			}
			else if (shape.getType().equals("star")){
				((Star)(shape)).setXY((int)(path.getPath()[path.getInc()].getX()), (int)(path.getPath()[path.getInc()].getY()));
				path.increment();
			}
			else if (shape.getType().equals("wave")){
				((Wave)(shape)).setXY((int)(path.getPath()[path.getInc()].getX()), (int)(path.getPath()[path.getInc()].getY()));
				path.increment();
			}
		}
		
		
		
		
		
		/**ROTATION ANIMATION BEGINS HERE*/
		if (rotate.getState())
		{
			if(shape.getType().equals("square")){
				if(rotate.getd2D3D()){
		    		gl2.glTranslatef(((Square)shape).getX(), ((Square)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 1, -1, 0);
		    		gl2.glTranslatef(-((Square)shape).getX(), -((Square)shape).getY(), 0);
				}
				else{
		    		gl2.glTranslatef(((Square)shape).getX(), ((Square)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 0, 0, 1);
		    		gl2.glTranslatef(-((Square)shape).getX(), -((Square)shape).getY(), 0);
				}
			}
			else if(shape.getType().equals("cross")){
				if(rotate.getd2D3D()){
		    		gl2.glTranslatef(((Cross)shape).getX(), ((Cross)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 1, -1, 0);
		    		gl2.glTranslatef(-((Cross)shape).getX(), -((Cross)shape).getY(), 0);
				}
				else{
		    		gl2.glTranslatef(((Cross)shape).getX(), ((Cross)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 0, 0, 1);
		    		gl2.glTranslatef(-((Cross)shape).getX(), -((Cross)shape).getY(), 0);
				}
			}
			else if(shape.getType().equals("circle")){
	    		gl2.glTranslatef(((Circle)shape).getX(), ((Circle)shape).getY(), 0);
	    		if(rotate.getDirection()){
	    			angle = angle*-1;
	    		}
	    		angle = angle*rotate.getSpeed();
	    		gl2.glRotatef(angle/10, 1, -1, 0);
	    		gl2.glTranslatef(-((Circle)shape).getX(), -((Circle)shape).getY(), 0);
			}
			else if(shape.getType().equals("wave")){
				if(rotate.getd2D3D()){
		    		gl2.glTranslatef(((Wave)shape).getX(), ((Wave)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 0, -1, 0);
		    		gl2.glTranslatef(-((Wave)shape).getX(), -((Wave)shape).getY(), 0);
				}
				else{
		    		gl2.glTranslatef(((Wave)shape).getX(), ((Wave)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 0, 0, 1);
		    		gl2.glTranslatef(-((Wave)shape).getX(), -((Wave)shape).getY(), 0);
				}
			}
			else if(shape.getType().equals("star")){
				if(rotate.getd2D3D()){
		    		gl2.glTranslatef(((Star)shape).getX(), ((Star)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 1, -1, 0);
		    		gl2.glTranslatef(-((Star)shape).getX(), -((Star)shape).getY(), 0);
				}
				else{
		    		gl2.glTranslatef(((Star)shape).getX(), ((Star)shape).getY(), 0);
		    		if(rotate.getDirection()){
		    			angle = angle*-1;
		    		}
		    		angle = angle*rotate.getSpeed();
		    		gl2.glRotatef(angle/10, 0, 0, 1);
		    		gl2.glTranslatef(-((Star)shape).getX(), -((Star)shape).getY(), 0);
				}
			}
		}
		
		
	}
}
