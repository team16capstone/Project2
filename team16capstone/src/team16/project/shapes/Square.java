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


public class Square extends Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private float nsize;
	private int xpos;
	private int ypos;
	private int width;
	private int height;
	Color rgb = Color.black;
	boolean filled;
	int thickness;
	private Animation squareAnimation = new Animation(new Rotate(false,false,false,0),new Bounce(false,0),new MotionPath(false, new Point[1000]), new Tail(false,this));
	public Square(int x, int y, int width, int height, int size, Color rGB2, boolean filled, int thickness, Rotate rotate, Bounce bounce){
		super("square");
		this.width = width;
		this.height = height;
		nsize = (((float)size)/(float)200) * (float)height;
		xpos = x;
		ypos = height-y;
		if(rGB2.getRGB() != -1)
		rgb = rGB2;
		this.filled = filled;
		this.thickness = thickness;

		if(rotate!=null)
			squareAnimation.setRotateData(rotate);

		squareAnimation.setBounce(bounce);
	}
public void drawSquare(GL2 gl2, float angle){

	squareAnimation.doAnimations(gl2, this, angle);
    gl2.glColor3f((float)rgb.getRed()/(float)255, (float)rgb.getGreen()/(float)255, (float)rgb.getBlue()/(float)255);
    if (filled)
    	gl2.glBegin(GL2.GL_QUADS);
    else
    {
    	gl2.glLineWidth((float)thickness);
    	gl2.glBegin(GL2.GL_LINE_LOOP);
    }
	gl2.glVertex2d(xpos-nsize,ypos-nsize);
	gl2.glVertex2d(xpos+nsize,ypos-nsize);
	gl2.glVertex2d(xpos+nsize,ypos+nsize);
	gl2.glVertex2d(xpos-nsize,ypos+nsize);
	gl2.glVertex2d(xpos-nsize,ypos-nsize);
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
		return nsize;
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
		return squareAnimation;
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
		squareAnimation.setTail(new Tail(true,this));
	}

	@Override
	public Tail getTail() {
		return squareAnimation.getTail();
	}
	
	@Override
	public void removeAnim() {
		if(squareAnimation!=null)
		squareAnimation.turnOff();
	}
	
	@Override
	public Boolean getFilled() {
		return filled;
	}

	@Override
	public int getThickness() {
		return thickness;
	}
	
	@Override
	public void drawWithTail(GL2 gl2, float angle,int x, int y, int index, Color background) {
		if(squareAnimation.getRotate().getState())
		if(squareAnimation.getRotate().getd2D3D()){
    		gl2.glTranslatef((float)squareAnimation.getTail().getTail()[index].getX(), (float)squareAnimation.getTail().getTail()[index].getY(), 0);
    		if(squareAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*squareAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 1, -1, 0);
    		gl2.glTranslatef(-(float)squareAnimation.getTail().getTail()[index].getX(), -(float)squareAnimation.getTail().getTail()[index].getY(), 0);
		}
		else{
    		gl2.glTranslatef((float)squareAnimation.getTail().getTail()[index].getX(), (float)squareAnimation.getTail().getTail()[index].getY(), 0);
    		if(squareAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*squareAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 0, 0, 1);
    		gl2.glTranslatef(-(float)squareAnimation.getTail().getTail()[index].getX(), -(float)squareAnimation.getTail().getTail()[index].getY(), 0);
		}
		
//		squareAnimation.doAnimations(gl2, this, angle);
		gl2.glEnable(GL2.GL_COLOR_MATERIAL_PARAMETER);
	    gl2.glColor3f((float)((fade(rgb,background,(float)index)).getRed())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getGreen())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getBlue())/(float)255);
	    if (filled)
	    	gl2.glBegin(GL2.GL_QUADS);
	    else
	    {
	    	gl2.glLineWidth((float)thickness);
	    	gl2.glBegin(GL2.GL_LINE_LOOP);
	    }
		gl2.glVertex2d(x-nsize,y-nsize);
		gl2.glVertex2d(x+nsize,y-nsize);
		gl2.glVertex2d(x+nsize,y+nsize);
		gl2.glVertex2d(x-nsize,y+nsize);
		gl2.glVertex2d(x-nsize,y-nsize);
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
