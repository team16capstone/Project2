package team16.project.shapes;

import java.awt.Color;
import java.io.Serializable;

import javax.media.opengl.GL2;

import team16.project.animation.Tail;


public abstract class Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private String type;
	
	public Shape(String type){
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public abstract void setRGB(Color c);
	public abstract Color getRGB();
	public abstract void setTrail(Shape s);
	public abstract Tail getTail();
	public abstract void setXY(int x, int y);
	public abstract int getX();
	public abstract int getY();
	public abstract void removeAnim();
	public abstract float getWidth();
	public abstract float getHeight();
	public abstract float getSize();
	public abstract Boolean getFilled();
	public abstract int getThickness();
	public abstract void drawWithTail(GL2 gl2, float angle,int x, int y, int index, Color background);

	
}
