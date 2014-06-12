package team16.project.animation;

import java.awt.Point;
import java.io.Serializable;

import team16.project.shapes.Shape;

public class Tail implements Serializable{
	private static final long serialVersionUID = 1L;
	Point[] tail = new Point[10];
	Boolean active = false;
	public Tail(Boolean active, Shape t){
		this.active = active;
		for(int i = 0;i<10;i++){
			tail[i] = new Point(t.getX(),t.getY());
			}
	}
	
	public Point[] getTail(){
		return tail;
	}
	
	public Boolean getState(){
		return active;
	}
	
	public void setActive(Boolean b){
		active = b;	
	}
	
	public void update(int x, int y){
		for(int i = 9; i > 0;i--){
			tail[i].setLocation(tail[i-1].getX(), tail[i-1].getY());
		}
		tail[0].setLocation(x, y);
	}
	
	public void toggleTail(){
		if(active)
			active = false;
		else
			active = true;
	}
}
