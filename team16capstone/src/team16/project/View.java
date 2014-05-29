package team16.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import team16.project.animation.Bounce;
import team16.project.animation.Rotate;

import com.jogamp.opengl.util.FPSAnimator;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
    
    private Menu menu = new Menu();
    private FileToolbar fileToolbar = new FileToolbar();
    private EditToolbar editToolbar = new EditToolbar();
	private Color shapeColor = new Color(1.0f,1.0f,1.0f);
	private Rotate rotate = new Rotate(false,false,false,0);
    private BorderLayout bLayout = new BorderLayout();
    int currentColor[] = new int[3];
    GLProfile glprofile = GLProfile.getDefault();
    GLCapabilities glcapabilities = new GLCapabilities( glprofile );
    GLJPanel canvas = new GLJPanel( glcapabilities );
    Glistener gl = new Glistener(canvas);
    MyMouseListener ml = new MyMouseListener(this,canvas);
    MyMouseMotionListener mml = new MyMouseMotionListener(this,canvas);
    Bounce bounce = new Bounce(false,1);
    /**FOR GRAPHICS*/
    View(Model model) {
    	this.setLayout(bLayout);


        FPSAnimator animator = new FPSAnimator(canvas,60, true);
        
        //JButton button = new JButton("button");
        setJMenuBar(menu);
        this.getContentPane().add(fileToolbar, BorderLayout.NORTH);
        this.getContentPane().add(editToolbar, BorderLayout.WEST);
        
//        int w = (Toolkit.getDefaultToolkit().getScreenSize().width) - (Toolkit.getDefaultToolkit().getScreenSize().width*4/100);
//        int h = (Toolkit.getDefaultToolkit().getScreenSize().height) - (Toolkit.getDefaultToolkit().getScreenSize().height*18/100);
//		gljpanel.setSize(w, h);
        canvas.setBackground(Color.white);
        this.getContentPane().add(canvas, BorderLayout.CENTER);
        
        this.setTitle("Team 16 - Zener Card Animation Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        canvas.addGLEventListener(gl);
        canvas.addMouseListener(ml);
        canvas.addMouseMotionListener(mml);
        animator.start();
        canvas.setBackground(Color.white);
    }
    

	void reset() {
    }
    
   
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
   
    void addMenuListener(ActionListener t) {
    	menu.addItemListener(t);
    }
    
    void addToolbarListener(ActionListener t) {
    	fileToolbar.addListeners(t);
    	editToolbar.addListeners(t);
    }
    
   
    public Glistener getGlistener()
    {
    	return gl;
    }
    
    public MyMouseListener getMyMouseListener(){
    	return ml;
    }
    
    public Rotate getRotate()
    {
    	Rotate r = new Rotate(rotate.getd2D3D(),rotate.getState(),rotate.getDirection(),rotate.getSpeed());
		return r;
    }
    
    public void setRotate(Rotate t)
    {
		rotate = t;
		fileToolbar.setRotateColor(t.getState());
    }
    
    public Bounce getBounce()
    {
    	Bounce b = new Bounce(bounce.getBounce(),bounce.getSpeed());
		return b;
    }
    
    public void setBounce(Bounce b)
    {
    	bounce = b;
		fileToolbar.setBounceColor(b.getBounce());
    }

    public Color getShapeColor(){
    	return shapeColor;
    }
    
    public void setShapeColor(Color c){
    	shapeColor = c;
    	fileToolbar.setColor(c);
    }


	public void setBackColor(Color color) {
		gl.setBack(color);
    	fileToolbar.setBackColor(color);		
	}
	
	public Color getBackColor() {
    	return fileToolbar.getBackColor();		
	}
	
	public void setPause(boolean p) {
    	fileToolbar.setPause(p);		
	}
	
	public void setRecPause(boolean p) {
    	fileToolbar.setRecPauseColor(p);		
	}
	public void setRecord(boolean p) {
    	fileToolbar.setRecord(p);		
	}
	
	public void setMotion(boolean p){
		fileToolbar.setMotionPathColor(p);
	}
	
	public MyMouseMotionListener getMMListener(){
		return mml;
	}
}

