package team16.project.animation;

import java.awt.Point;
import java.io.Serializable;

public class MotionPath implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean active = false;
	private Boolean setPath = false;
	private Point[] path = new Point[1000];
	private Boolean direction = false;
	private int inc = 0;
	private Boolean incDir = true;
	int max = 0;
	
	
	public MotionPath(Boolean active, Point[] path){
		this.active = active;
		this.path = path;
	}
	
	public Boolean getSetPath(){
		return setPath;
	}
	public Boolean getState(){
		return active;
	}
	
	public Point[] getPath(){
		return path;
	}
	
	public Boolean getDirection(){
		return direction;
	}
	
	public void setState(Boolean s){
		active = s;
	}
	
	public void setPath(Point[] p){
		path = p;
		max = checkMax();
	}
	
	public void setDirection(Boolean d){
		direction = d;
	}
	
	public void increment(){
		
		if(incDir)
		{
			if(inc < max-1){
				inc++;
			}
			else{
				inc--;
				incDir = false;
			}
		}
		else{
			if(inc > 1){
				inc--;
			}
			else{
				inc++;
				incDir = true;
			}
		}
	}
	
	public int checkMax(){
		int ii = 0;
		if(path != null)
		for(int i = 0; path[i] != null && i < 999; i++){
			ii = i;
		}
		return ii;
	}
	
	public int getInc(){
		return inc;
	}
	
	public void setMax(){
		max = checkMax();
	}
}
