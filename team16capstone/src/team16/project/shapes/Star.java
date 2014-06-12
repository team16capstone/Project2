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


public class Star extends Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private float nsize;
	private int xpos;
	private int ypos;
	private int height;
	private int width;
	Color rgb = Color.green;
	boolean filled;
	int thickness;
	private Animation starAnimation = new Animation(new Rotate(false,false,false,0),new Bounce(false,0),new MotionPath(false, new Point[1000]), new Tail(false,this));
	public Star(int x, int y,int width, int height, int size, Color rGB2, boolean filled, int thickness, Rotate rotate,Bounce bounce){
		super("star");
		this.width = width;
		this.height = height;
		nsize = ((((float)size)/(float)200) * (float)height)/(float)3;
		xpos = x;
		ypos = height-y;
		if(rGB2.getRGB() != -1)
		rgb = rGB2;
		this.filled = filled;
		this.thickness = thickness;
		if(rotate!=null)
			starAnimation.setRotateData(rotate);

		starAnimation.setBounce(bounce);
	}
public void drawStar(GL2 gl2, float angle){

	starAnimation.doAnimations(gl2, this, angle);
    gl2.glColor3f((float)rgb.getRed()/(float)255, (float)rgb.getGreen()/(float)255, (float)rgb.getBlue()/(float)255);
    if (filled)
    {
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
    	gl2.glEnd();
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glVertex2d(xpos,ypos+3*nsize);					//point 3
    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
    	gl2.glVertex2d(xpos+3*nsize,ypos+0.75*nsize);		//point 5
    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
    	gl2.glEnd();
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
    	gl2.glVertex2d(xpos+2.1*nsize,ypos-3*nsize);		//point 7
    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
    	gl2.glEnd();
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
    	gl2.glVertex2d(xpos-2.1*nsize,ypos-3*nsize);		//point 9
    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
    	gl2.glEnd();
    	gl2.glBegin(GL2.GL_POLYGON);
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glEnd();
    }
    else
    {
    	gl2.glLineWidth((float)thickness);
    	gl2.glBegin(GL2.GL_LINE_LOOP);
    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
    	gl2.glVertex2d(xpos,ypos+3*nsize);					//point 3
    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
    	gl2.glVertex2d(xpos+3*nsize,ypos+0.75*nsize);		//point 5
    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
    	gl2.glVertex2d(xpos+2.1*nsize,ypos-3*nsize);		//point 7
    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
    	gl2.glVertex2d(xpos-2.1*nsize,ypos-3*nsize);		//point 9
    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
    	gl2.glEnd();
    }


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
		return nsize*3;
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
		return starAnimation;
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
		starAnimation.setTail(new Tail(true,this));
	}

	@Override
	public Tail getTail() {
		return starAnimation.getTail();
	}
	
	@Override
	public void removeAnim() {
		if(starAnimation!=null)
		starAnimation.turnOff();
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
	public void drawWithTail(GL2 gl2, float angle,int xpos, int ypos, int index, Color background) {
		if(starAnimation.getRotate().getState())
		if(starAnimation.getRotate().getd2D3D()){
    		gl2.glTranslatef((float)starAnimation.getTail().getTail()[index].getX(), (float)starAnimation.getTail().getTail()[index].getY(), 0);
    		if(starAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*starAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 1, -1, 0);
    		gl2.glTranslatef(-(float)starAnimation.getTail().getTail()[index].getX(), -(float)starAnimation.getTail().getTail()[index].getY(), 0);
		}
		else{
    		gl2.glTranslatef((float)starAnimation.getTail().getTail()[index].getX(), (float)starAnimation.getTail().getTail()[index].getY(), 0);
    		if(starAnimation.getRotate().getDirection()){
    			angle = angle*-1;
    		}
    		angle = angle*starAnimation.getRotate().getSpeed();
    		gl2.glRotatef(angle/10, 0, 0, 1);
    		gl2.glTranslatef(-(float)starAnimation.getTail().getTail()[index].getX(), -(float)starAnimation.getTail().getTail()[index].getY(), 0);
		}
		
	    gl2.glColor3f((float)((fade(rgb,background,(float)index)).getRed())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getGreen())/(float)255,
	    		(float)((fade(rgb,background,(float)index)).getBlue())/(float)255);
	    if (filled)
	    {
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
	    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
	    	gl2.glEnd();
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glVertex2d(xpos,ypos+3*nsize);					//point 3
	    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
	    	gl2.glVertex2d(xpos+3*nsize,ypos+0.75*nsize);		//point 5
	    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
	    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
	    	gl2.glEnd();
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
	    	gl2.glVertex2d(xpos+2.1*nsize,ypos-3*nsize);		//point 7
	    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
	    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
	    	gl2.glEnd();
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
	    	gl2.glVertex2d(xpos-2.1*nsize,ypos-3*nsize);		//point 9
	    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
	    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
	    	gl2.glEnd();
	    	gl2.glBegin(GL2.GL_POLYGON);
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
	    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
	    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
	    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glEnd();
	    }
	    else
	    {
	    	gl2.glLineWidth((float)thickness);
	    	gl2.glBegin(GL2.GL_LINE_LOOP);
	    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
	    	gl2.glVertex2d(xpos-0.75*nsize,ypos+0.75*nsize);	//point 2
	    	gl2.glVertex2d(xpos,ypos+3*nsize);					//point 3
	    	gl2.glVertex2d(xpos+0.75*nsize,ypos+0.75*nsize);	//point 4
	    	gl2.glVertex2d(xpos+3*nsize,ypos+0.75*nsize);		//point 5
	    	gl2.glVertex2d(xpos+1.25*nsize,ypos-0.6*nsize);		//point 6
	    	gl2.glVertex2d(xpos+2.1*nsize,ypos-3*nsize);		//point 7
	    	gl2.glVertex2d(xpos,ypos-1.25*nsize);				//point 8
	    	gl2.glVertex2d(xpos-2.1*nsize,ypos-3*nsize);		//point 9
	    	gl2.glVertex2d(xpos-1.25*nsize,ypos-0.6*nsize);		//point 10
	    	gl2.glVertex2d(xpos-3*nsize,ypos+0.75*nsize);		//point 1
	    	gl2.glEnd();
	    }
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
