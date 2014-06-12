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
	public void drawWithTail(GL2 gl2, float angle,int xpos, int ypos, int index, Color background) {

		if(waveAnimation.getRotate().getState())
		if(waveAnimation.getRotate().getd2D3D()){
    		gl2.glTranslatef((float)waveAnimation.getTail().getTail()[index].getX(), (float)waveAnimation.getTail().getTail()[index].getY(), 0);
    		if(waveAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*waveAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 0, -1, 0);
    		gl2.glTranslatef(-(float)waveAnimation.getTail().getTail()[index].getX(), -(float)waveAnimation.getTail().getTail()[index].getY(), 0);
		}
		else{
    		gl2.glTranslatef((float)waveAnimation.getTail().getTail()[index].getX(), (float)waveAnimation.getTail().getTail()[index].getY(), 0);
    		if(waveAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*waveAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 0, 0, 1);
    		gl2.glTranslatef(-(float)waveAnimation.getTail().getTail()[index].getX(), -(float)waveAnimation.getTail().getTail()[index].getY(), 0);
		}
		
//		waveAnimation.doAnimations(gl2, this, angle);
	    gl2.glColor3f((float)((fade(rgb,background,(float)index)).getRed())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getGreen())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getBlue())/(float)255);	    gl2.glLineWidth((float)thickness);
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
	
	private Color fade(Color sColor, Color bColor, float fraction)
	{
	    float r = calcFade((float)sColor.getRed(), (float)bColor.getRed(), (float)fraction/(float)10);
	    float g = calcFade((float)sColor.getGreen(), (float)bColor.getGreen(), (float)fraction/(float)10);
	    float b = calcFade((float)sColor.getBlue(), (float)bColor.getBlue(), (float)fraction/(float)10);
	    return new Color((float)r/(float)255, (float)g/(float)255, (float)b/(float)255);
	}

	private float calcFade(float d1, float d2, float fraction)
	{
		if(d1>d2)
			return (float)Math.abs(d1 - ((d1 - d2) * fraction));
		else
			return (float)Math.abs(d1 + ((d1 - d2) * fraction));
	}
	
}
