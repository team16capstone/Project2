package team16.project.shapes;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

import javax.media.opengl.GL2;

import team16.project.animation.Animation;
import team16.project.animation.Bounce;
import team16.project.animation.MotionPath;
import team16.project.animation.Rotate;
import team16.project.animation.Tail;


public class Wave extends Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private float nsize;
	private int xpos;
	private int ypos;
	private int height;
	private int width;
	private int thickness;
	Color rgb = Color.blue;
	private Animation waveAnimation = new Animation(new Rotate(false,false,false,0),new Bounce(false,0),new MotionPath(false, new Point[1000]), new Tail(false,this));
	
	public Wave(int x, int y,int width, int height, int size, Color rGB2, int thickness, Rotate rotate, Bounce bounce){
		super("wave");
		this.width = width;
		this.height = height;
		nsize = (((float)size)/(float)200) * (float)height;
		xpos = x;
		ypos = height-y;
		if(rGB2.getRGB() != -1)
		rgb = rGB2;
		this.thickness = thickness;
		if(rotate!=null)
			waveAnimation.setRotateData(rotate);

		waveAnimation.setBounce(bounce);
	}
	public void drawWave(GL2 gl2, float angle){
		waveAnimation.doAnimations(gl2, this, angle);
	    gl2.glColor3f((float)rgb.getRed()/(float)255, (float)rgb.getGreen()/(float)255, (float)rgb.getBlue()/(float)255);
	    gl2.glLineWidth((float)thickness);
	    float ypoint = ypos + nsize/15/2*20;
	    
	    //FIRST WAVE
		gl2.glBegin(GL2.GL_LINE_LOOP);
	    for(float i = 0.0f; i < 2.1f; i += 0.1f){
			gl2.glVertex3d(xpos - nsize/3 +(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint -= (float)nsize/15f;
	    }
	    for(float i = 2.1f; i > 0.0f; i -= 0.1f){
			gl2.glVertex3d(xpos - nsize/3+(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint += (float)nsize/15f;
	    }
		gl2.glEnd();
		
		//SECOND WAVE
		gl2.glBegin(GL2.GL_LINE_LOOP);
	    for(float i = 0.0f; i < 2.1f; i += 0.1f){
			gl2.glVertex3d(xpos+(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint -= (float)nsize/15f;
	    }
	    for(float i = 2.1f; i > 0.0f; i -= 0.1f){
			gl2.glVertex3d(xpos+(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint += (float)nsize/15f;
	    }
		gl2.glEnd();
		
		//THIRD WAVE
		gl2.glBegin(GL2.GL_LINE_LOOP);
	    for(float i = 0.0f; i < 2.1f; i += 0.1f){
			gl2.glVertex3d(xpos + nsize/3+(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint -= (float)nsize/15f;
	    }
	    for(float i = 2.1f; i > 0.0f; i -= 0.1f){
			gl2.glVertex3d(xpos + nsize/3+(nsize*Math.sin(i * Math.PI)/6),ypoint,0);
			ypoint += (float)nsize/15f;
	    }
		gl2.glEnd();
	}


	public int getX()
	{
		return xpos;
	}
	public int getY()
	{
		return ypos;
	}
	public float getSize()
	{
		return (float)nsize*(float)5/(float)height*(float)200/(float)2.5;
	}
	public float getWidth()
	{
		return width;
	}
	public float getHeight()
	{
		return height;
	}
	public void setXY(int x, int y){
		xpos = x;
		ypos = y;
	}
	public Animation getAnimation(){
		return waveAnimation;
	}
	
	@Override
	public void setRGB(Color c) {
		rgb = c;
	}
	
	@Override
	public Color getRGB() {
		return rgb;
	}

	@Override
	public void setTrail(Shape s) {
		waveAnimation.setTail(new Tail(true,this));
	}

	@Override
	public Tail getTail() {
		return waveAnimation.getTail();
	}
	
	@Override
	public void removeAnim() {
		if(waveAnimation!=null)
		waveAnimation.turnOff();
	}
	
	@Override
	public Boolean getFilled() {
		return false;
	}

	@Override
	public int getThickness() {
		return thickness;
	}
	
	@Override
	public void drawWithTail(GL2 gl2, float angle,int x, int y, int index, Color background) {
		
	}
	
	@SuppressWarnings("unused")
	private Color fade(Color c, int i){
		c = new Color((float)c.getRed()/(float)255,(float)c.getGreen()/(float)255,(float)c.getBlue()/(float)255,(float)i/(float)10);
		return c;
	}
}
