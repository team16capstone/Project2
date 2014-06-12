package team16.project;

import java.awt.Color;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;

import team16.project.animation.Bounce;
import team16.project.animation.Rotate;
import team16.project.shapes.Circle;
import team16.project.shapes.Cross;
import team16.project.shapes.Shape;
import team16.project.shapes.Square;
import team16.project.shapes.Star;
import team16.project.shapes.Wave;

public class Glistener implements GLEventListener{
    float angle = 0;
    private Shape shapes[] = new Shape[100];
    private Shape undoShape[] = new Shape[100];
    GLJPanel canvas;
    Color back = Color.white;
    boolean pause = false;
    boolean once = false;
    int i= 0,tailCounter = 0;
	public Glistener(GLJPanel canvas) {
		this.canvas = canvas;
		back = Color.white;
		}

	@Override
	public void display(GLAutoDrawable glautodrawable) {
//	    this.update();
	    this.render(glautodrawable);
	    
	    

	    }

    private void render(GLAutoDrawable drawable) {
    	if(pause && !once)
    		return;
    	if(once)
    		once = false;
    	
        GL2 gl2 = drawable.getGL().getGL2();
		gl2.glClearColor((float)back.getRed()/(float)255, (float)back.getGreen()/(float)255, (float)back.getBlue()/(float)255,(float)1);
    	gl2.glClear(GL.GL_DEPTH_BUFFER_BIT | GL.GL_COLOR_BUFFER_BIT);


        for(int i = 0; shapes[i] != null; i++)
        { 
        	gl2.glLoadIdentity();
            if(shapes[i].getType().equals("square"))
            	((Square)shapes[i]).drawSquare(gl2, angle);
            else if(shapes[i].getType().equals("circle"))
            	((Circle)shapes[i]).drawCircle(gl2, angle);
            else if(shapes[i].getType().equals("cross"))
            	((Cross)shapes[i]).drawCross(gl2, angle);
            else if(shapes[i].getType().equals("star"))
            	((Star)shapes[i]).drawStar(gl2, angle);
            else if(shapes[i].getType().equals("wave"))
            	((Wave)shapes[i]).drawWave(gl2, angle);

            	if(shapes[i].getTail().getState()){
                    if(tailCounter == 3){
                    	shapes[i].getTail().update(shapes[i].getX(), shapes[i].getY());
                    }
            		for(int j = 9; j>=0;j--){
            	    	gl2.glLoadIdentity();

                        if(shapes[i].getType().equals("square"))
                        	((Square)shapes[i]).drawWithTail(gl2, angle, (int)shapes[i].getTail().getTail()[j].getX(), (int)shapes[i].getTail().getTail()[j].getY(), j, back);
                        else if(shapes[i].getType().equals("circle"))
                        	((Circle)shapes[i]).drawWithTail(gl2, angle, (int)shapes[i].getTail().getTail()[j].getX(), (int)shapes[i].getTail().getTail()[j].getY(), j, back);
                        else if(shapes[i].getType().equals("cross"))
                        	((Cross)shapes[i]).drawWithTail(gl2, angle, (int)shapes[i].getTail().getTail()[j].getX(), (int)shapes[i].getTail().getTail()[j].getY(), j, back);
                        else if(shapes[i].getType().equals("star"))
                        	((Star)shapes[i]).drawWithTail(gl2, angle, (int)shapes[i].getTail().getTail()[j].getX(), (int)shapes[i].getTail().getTail()[j].getY(), j, back);
                        else if(shapes[i].getType().equals("wave"))
                        	((Wave)shapes[i]).drawWithTail(gl2, angle, (int)shapes[i].getTail().getTail()[j].getX(), (int)shapes[i].getTail().getTail()[j].getY(), j, back);
            		}
            	}
        }
        	angle += 0.1;
        	if(tailCounter<3)
        		tailCounter++;
        	else
        		tailCounter = 0;
    }
      
    @SuppressWarnings("unused")
	private void update() {

    }

	@Override
	public void dispose(GLAutoDrawable glautodrawable) {
	}

	@Override
	public void init(GLAutoDrawable glautodrawable) {
		
	}

	@Override
	public void reshape(GLAutoDrawable glautodrawable, int x, int y, int width,
			int height) {
		this.setup( glautodrawable.getGL().getGL2(), width, height );
	}
	
	private void setup(GL2 gl2, int width, int height) {
		gl2.glClearColor(255, 255, 255,1);
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();
        gl2.glOrthof( 0.0f, width, 0.0f, height,-height,height);
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();

	}
	
	public void addShape(int x, int y,int width, int height, String type, int size, Color rGB, boolean filled, int thickness, Rotate rotate, Bounce bounce){
		
		int a = 0;
		for(int i = 0;shapes[i]!=null;i++)
		{
			a = i+1;
		}
		System.out.println("Adding " + type +" to position " + a);
		if(type.equals("square"))
			shapes[a] = new Square(x,y,width,height,size,rGB,filled,thickness,rotate,bounce);
		else if(type.equals("circle"))
			shapes[a] = new Circle(x,y,width,height,size,rGB,filled,thickness,rotate,bounce);
		else if(type.equals("cross"))
			shapes[a] = new Cross(x,y,width,height,size,rGB,thickness,rotate,bounce);
		else if(type.equals("wave"))
			shapes[a] = new Wave(x,y,width,height,size,rGB,thickness,rotate,bounce);
		else if(type.equals("star"))
			shapes[a] = new Star(x,y,width,height,size,rGB,filled,thickness,rotate,bounce);
	}
	
	public void reset(View view)
	{
		shapes = new Shape[100];
		undoShape = new Shape[100];
//		back = Color.white;
		view.setShapeColor(Color.white);
		view.setBackColor(Color.white);
	}
	
	public void undo(){
		int a = 0, b = 0;
		for(int i = 0;shapes[i]!=null;i++)
		{
			a = i+1;
		}
		if (a > 0)
		{
			for(int i = 0;undoShape[i]!=null;i++)
			{
				b = i+1;
			}
			undoShape[b] = shapes[a-1];
			shapes[a-1] = null;	
		}
	}
	
	public void redo(){
		int a = 0, b = 0;
		for(int i = 0;shapes[i]!=null;i++)
		{
			a = i+1;
		}
		if(undoShape[0]!=null)
		{
			for(int i = 99;undoShape[i]==null;i--)
			{
				b = i-1;
			}
				shapes[a] = undoShape[b];
				undoShape[b] = null;
		}
	}
	public Shape[] getShapes(){
		return shapes;
	}
	
	public void setShapes(Shape[] shapes){
		this.shapes = shapes;
	}
	
	public void loadShape(Square shape){
		this.shapes[0] = (Square)shape;
	}
	
	public void setBack(Color c){
		back = c;
	}
	
	public void setPause(boolean p){
		pause = p;
	}
	
	public boolean getPause(){
		return pause;
	}
	
	public void setOnce(){
		once = true;
	}
}
