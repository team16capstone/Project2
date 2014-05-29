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


public class Cross extends Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private float nsize;
	private int xpos;
	private int ypos;
	private int thickness;
	private int height;
	private int width;
	Color rgb = Color.red;
	private Animation crossAnimation = new Animation(new Rotate(false,false,false,0),new Bounce(false, 0),new MotionPath(false, new Point[1000]), new Tail(false,this));

	public Cross(int x, int y,int width, int height, int size, Color rGB2, int thickness, Rotate rotate,Bounce bounce){
		super("cross");
		this.width = width;
		this.height = height;
		nsize = (((float)size)/(float)200) * (float)height;
		xpos = x;
		ypos = height-y;
		if(rGB2.getRGB() != -1)
		rgb = rGB2;
		this.thickness = thickness;
		if(rotate!=null)
		crossAnimation.setRotateData(rotate);
		
		crossAnimation.setBounce(bounce);
		
	}
public void drawCross(GL2 gl2, float angle){
	crossAnimation.doAnimations(gl2, this, angle);
    gl2.glColor3f((float)rgb.getRed()/(float)255, (float)rgb.getGreen()/(float)255, (float)rgb.getBlue()/(float)255);
    gl2.glLineWidth((float)thickness);
	gl2.glBegin(GL2.GL_LINE_LOOP);
	gl2.glVertex3d(xpos,ypos,0);
	gl2.glVertex3d(xpos,ypos-nsize,0);
	gl2.glVertex3d(xpos,ypos+nsize,0);
	gl2.glVertex3d(xpos,ypos,0);
	gl2.glVertex3d(xpos-nsize,ypos,0);
	gl2.glVertex3d(xpos+nsize,ypos,0);
	gl2.glVertex3d(xpos,ypos,0);
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
		return crossAnimation;
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
		crossAnimation.setTail(new Tail(true,this));
	}

	@Override
	public Tail getTail() {
		return crossAnimation.getTail();
	}
	
	@Override
	public void removeAnim() {
		if(crossAnimation!=null)
		crossAnimation.turnOff();
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
