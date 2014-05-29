package team16.project.animation;

import java.io.Serializable;

public class Bounce implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean bounce;
	private Boolean bUp = true;
	private Boolean bRight = true;
	private int speed = 1;
	
	public Bounce(Boolean bounce, int speed){
		this.bounce = bounce;
		this.speed = speed;
	}
	
	public Boolean getBounce(){
		return bounce;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Boolean getbUp(){
		return bUp;
	}
	
	public Boolean getbRight(){
		return bRight;
	}
	
	public void setbUp(Boolean u){
		this.bUp = u;
	}
	public void setbRight(Boolean r){
		this.bRight = r;
	}
	
	public void setActive(Boolean b){
		bounce = b;
	}

}
