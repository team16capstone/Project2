package team16.project.animation;

import java.io.Serializable;

public class Rotate implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean d2D3D = false;
	private Boolean state = false;
	private Boolean direction = false;
	private int speed = 0;
	
	public Rotate(Boolean d2D3D, Boolean state, Boolean direction, int speed){
		this.d2D3D = d2D3D;
		this.state = state;
		this.direction = direction;
		this.speed = speed;
	}
	
	public Boolean getState(){
		return state;
	}
	
	public Boolean getDirection(){
		return direction;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setState(Boolean s){
		state = s;
	}
	
	public void setDirection(Boolean d){
		direction = d;
	}
	
	public void setSpeed(int s){
		speed = s;
	}
	
	public Boolean getd2D3D(){
		return d2D3D;
	}
	
	public void setd2D3D(Boolean d){
		d2D3D = d;
	}
}
