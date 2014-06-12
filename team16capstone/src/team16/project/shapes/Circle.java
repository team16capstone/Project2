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


public class Circle extends Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int width;
	private int height;
	private int thickness;
	private int size;
	Color rgb = Color.yellow;
	boolean filled = true;
	private Animation circleAnimation = new Animation(new Rotate(false,false,false,0),new Bounce(false,0), new MotionPath(false, new Point[1000]), new Tail(false,this));
	public Circle(int x, int y, int width,int height, int size, Color rGB2, boolean filled, int thickness, Rotate rotate, Bounce bounce){
		super("circle");
		this.x = x;
		this.y = height - y;
		this.width = width;
		this.height = height;
		this.size = size;
		this.filled = filled;
		if(rGB2.getRGB() != -1)
		rgb = rGB2;
		this.thickness = thickness;
		if(rotate!=null)
		circleAnimation.setRotateData(rotate);

		circleAnimation.setBounce(bounce);
	}
	
    public void drawCircle(GL2 gl2, float angle)
    {
    	circleAnimation.doAnimations(gl2, this, angle);
        gl2.glColor3f((float)rgb.getRed()/(float)255, (float)rgb.getGreen()/(float)255, (float)rgb.getBlue()/(float)255);

    	float theta = (float) (2 * 3.1415926 / (100)); 
    	float tangetial_factor = (float) (Math.tan(theta));//calculate the tangential factor 
    	float radial_factor = (float) (Math.cos(theta));//calculate the radial factor 
    	float xx = (float)size / (float)210 * height;//we start at angle = 0 
    	float yy = 0; 
    	gl2.glLineWidth(1f);
        if (filled)
        	gl2.glBegin(GL2.GL_POLYGON);
        else
        {
        	gl2.glLineWidth((float)thickness);
        	gl2.glBegin(GL2.GL_LINE_LOOP);
        }
    	for(int ii = 0; ii < 100; ii++) 
    	{ 
    		gl2.glVertex3f(xx + x, yy + y,0);//output vertex 

    		float tx = -yy; 
    		float ty = xx; 

    		xx += tx * tangetial_factor; 
    		yy += ty * tangetial_factor; 

    		xx *= radial_factor; 
    		yy *= radial_factor; 
    	} 
    	gl2.glEnd();
    }
	
		public int getX()
		{
			return x;
		}
		public int getY()
		{
			return y;
		}
		public float getSize()
		{
			return (float)size/210*height;
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
			this.x = x;
			this.y = y;
		}
		public Animation getAnimation(){
			return circleAnimation;
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
			circleAnimation.setTail(new Tail(true,this));
		}

		@Override
		public Tail getTail() {
			return circleAnimation.getTail();
		}

		@Override
		public void removeAnim() {
			if(circleAnimation!=null)
			circleAnimation.turnOff();
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
			if(circleAnimation.getRotate().getState()){
	    		gl2.glTranslatef((float)circleAnimation.getTail().getTail()[index].getX(), (float)circleAnimation.getTail().getTail()[index].getY(), 0);
	    		if(circleAnimation.getRotate().getDirection()){
	    			angle = angle*-1;
	    		}
	    		angle = angle*circleAnimation.getRotate().getSpeed();
	    		gl2.glRotatef(angle/10, 1, -1, 0);
	    		gl2.glTranslatef(-(float)circleAnimation.getTail().getTail()[index].getX(), -(float)circleAnimation.getTail().getTail()[index].getY(), 0);
			}
			
			
		    gl2.glColor3f((float)((fade(rgb,background,(float)index)).getRed())/(float)255,
		    		(float)((fade(rgb,background,(float)index)).getGreen())/(float)255,
		    		(float)((fade(rgb,background,(float)index)).getBlue())/(float)255);
	    	float theta = (float) (2 * 3.1415926 / (100)); 
	    	float tangetial_factor = (float) (Math.tan(theta));//calculate the tangential factor 
	    	float radial_factor = (float) (Math.cos(theta));//calculate the radial factor 
	    	float xx = (float)size / (float)210 * height;//we start at angle = 0 
	    	float yy = 0; 
	    	gl2.glLineWidth(1f);
	        if (filled)
	        	gl2.glBegin(GL2.GL_POLYGON);
	        else
	        {
	        	gl2.glLineWidth((float)thickness);
	        	gl2.glBegin(GL2.GL_LINE_LOOP);
	        }
	    	for(int ii = 0; ii < 100; ii++) 
	    	{ 
	    		gl2.glVertex3f(xx + x, yy + y,0);//output vertex 

	    		float tx = -yy; 
	    		float ty = xx; 

	    		xx += tx * tangetial_factor; 
	    		yy += ty * tangetial_factor; 

	    		xx *= radial_factor; 
	    		yy *= radial_factor; 
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
