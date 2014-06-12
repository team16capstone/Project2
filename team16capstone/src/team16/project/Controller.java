package team16.project;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import team16.project.animation.Bounce;
import team16.project.animation.Rotate;
import team16.project.shapes.Shape;

public class Controller{
	
	int object = 0;
	int xpoints[];
	int ypoints[];
	boolean direction;
	boolean dimension;
	boolean bounce;
	boolean recPause = false;
	int speed = 1;
	int bspeed = 1;
	View view;
	JFileChooser fileChooser = new JFileChooser();
	Record record;
	
	Controller(Model model, View view) {
		this.view = view;
    	view.addWindowListener(new WindowListener(){
    	
			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				record.setStop();
				record.initFolder();
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				record.setStop();
				record.initFolder();
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}
    		
    	});
		record = new Record(view.canvas);
		MenuListener ml = new MenuListener(view);
		ToolbarListener tl = new ToolbarListener(view);
        view.addMenuListener(ml);
        view.addMouseListener(null);
        view.addToolbarListener(tl);
	}
    
    class ToolbarListener implements ActionListener {
        View view;
    	public ToolbarListener(View view) {
    		this.view = view;
        }

		public void actionPerformed(ActionEvent e) {
            try {
            	if (e.getActionCommand().matches("new"))
                {
                	view.getGlistener().reset(view);
                }
            	else if (e.getActionCommand().matches("open"))
                {
                	doLoad();
                }
            	else if (e.getActionCommand().matches("save"))
                {
                	doSave();
                }
            	else if (e.getActionCommand().matches("record"))
                {
            		doRecord("startRecord");
                }
            	else if (e.getActionCommand().matches("recPause"))
                {
            		doRecord("recPause");
                }
            	else if (e.getActionCommand().matches("stopRecord"))
                {
            		doRecord("stopRecord");
                }
            	else if (e.getActionCommand().matches("exportMP4"))
                {
            		doRecord("exportMP4");
                }
            	else if (e.getActionCommand().matches("square"))
                {
            		doProcessing("square");
                }
            	else if (e.getActionCommand().matches("circle"))
                {
            		doProcessing("circle");
                }
            	else if (e.getActionCommand().matches("star"))
                {
            		doProcessing("star");
                }
            	else if (e.getActionCommand().matches("cross"))
                {
            		doProcessing("cross");
                }
            	else if (e.getActionCommand().matches("wave"))
                {
            		doProcessing("wave");
                }
            	else if (e.getActionCommand().matches("rotate"))
                {
            		direction = false;

            		if(view.getRotate().getState())
            			view.setRotate(new Rotate(false,false,direction,0));
            		else
            		{
            			doRotate();
            		}
                }
            	else if (e.getActionCommand().matches("motionBounce"))
                {
            		doBounce();
                }
            	else if (e.getActionCommand().matches("motionPath"))
                {
            		doMotionPath();
                }
            	else if (e.getActionCommand().matches("motionTail"))
                {
            		doMotionTrail();
                }
            	else if (e.getActionCommand().matches("pause"))
                {
            		doPause();
                }
            	else if (e.getActionCommand().matches("color"))
                {
            		chooseColor();
                }
            	else if (e.getActionCommand().matches("backColor"))
                {
            		chooseBackground();
                }
            	else if (e.getActionCommand().matches("undo"))
                {
            		view.gl.undo();
                }
            	else if (e.getActionCommand().matches("redo"))
                {
            		view.gl.redo();
                }
            } catch (NumberFormatException nfex) {
            }
        }
    }
    
    class MenuListener implements ActionListener {
        View view;

    	public MenuListener(View view) {
    		this.view = view;
		}
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().matches("New"))
                {
                	view.getGlistener().reset(view);
                }
                else if (e.getActionCommand().matches("Save Project"))
                {
                	doSave();
                }
                else if (e.getActionCommand().matches("Open Project"))
                {
                	doLoad();
                }
                else if (e.getActionCommand().matches("Record"))
                {
                	doRecord("startRecord");
                }
                else if (e.getActionCommand().matches("Pause Recording"))
                {
                	doRecord("recPause");
                }
                else if (e.getActionCommand().matches("Stop Recording"))
                {
                	doRecord("stopRecord");
                }
                else if (e.getActionCommand().matches("Export To MP4"))
                {
                	doRecord("exportMP4");
                }
                else if (e.getActionCommand().matches("Exit"))
                {
                	System.exit(0);
                }
                else if (e.getActionCommand().matches("Square"))
                {
            		doProcessing("square");
                }
                else if (e.getActionCommand().matches("Circle"))
                {
            		doProcessing("circle");
                }
                else if (e.getActionCommand().matches("Star"))
                {
            		doProcessing("star");
                }
                else if (e.getActionCommand().matches("Cross"))
                {
            		doProcessing("cross");
                }
                else if (e.getActionCommand().matches("Wave"))
                {
            		doProcessing("wave");
                }
            	else if (e.getActionCommand().matches("Rotate"))
                {
            		direction = false;

            		if(view.getRotate().getState())
            			view.setRotate(new Rotate(false,false,direction,0));
            		else
            		{
            			doRotate();
            		}
                }
            	else if (e.getActionCommand().matches("Bounce"))
                {
            		doBounce();
                }
            	else if (e.getActionCommand().matches("Motion Path"))
                {
            		doMotionPath();
                }
            	else if (e.getActionCommand().matches("Motion Trail"))
                {
            		doMotionTrail();
                }
            	else if (e.getActionCommand().matches("Pause"))
                {
            		doPause();
                }
            	else if (e.getActionCommand().matches("Shape Color"))
                {
            		chooseColor();
                }
            	else if (e.getActionCommand().matches("Background Color"))
                {
            		chooseBackground();
                }
            	else if (e.getActionCommand().matches("Undo"))
                {
            		view.gl.undo();
                }
            	else if (e.getActionCommand().matches("Redo"))
                {
            		view.gl.redo();
                }
            }
            catch (NumberFormatException nfex) {
            	System.out.println("Number Format Exception Thrown");
            }
        }
    }
    
    public void doProcessing(String shape){
    	int tmpSize = Integer.parseInt(JOptionPane.showInputDialog("Please enter a size value from 1 to 100 (Recomended 10)"));
    	while(tmpSize > 100 || tmpSize < 1)
    		tmpSize = Integer.parseInt(JOptionPane.showInputDialog("INPUT NOT VALID! Please enter a size value from 1 to 100 (Recomended 10)"));
    	if(tmpSize < 1 || tmpSize > 100)
    		return;
    	else
    	{
        	view.ml.setActive(true);
        	view.ml.setType(shape);
        	view.ml.setSize(tmpSize);
        	view.ml.setBounce(view.getBounce());
        	int tmpFilled = 1;
        	if(!shape.equals("cross") && !shape.equals("wave"))
        	tmpFilled = (JOptionPane.showOptionDialog(null, "Would you like this " + shape + " to be filled?","Shape Colour Fill",JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE, null, null, 1));
        	if(tmpFilled == 0)
        		view.ml.setFilled(true);
        	else
        	{
        		view.ml.setFilled(false);
            	int tmpThick = Integer.parseInt(JOptionPane.showInputDialog("Please enter a line thickness value from 1 to 10"));
            	while(tmpThick > 10 || tmpThick < 1)
            		tmpThick = Integer.parseInt(JOptionPane.showInputDialog("INPUT NOT VALID! Please enter a line thickness value from 1 to 10"));
            	if(tmpThick < 1 || tmpThick > 10)
            		return;
            	else
            	{
            		view.ml.setThickness(tmpThick);
            	}
        	}
        		
    	}
    }
    
	public void doRotate(){
    	Object[] option = {"2D",
        "3D"};
		int n1 = JOptionPane.showOptionDialog(null,
				"What type of rotation would you like to use?",
				"Rotation Dimension",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				option,
				option[1]);
		if(n1 == 0)
			dimension = false;
		else
			dimension = true;
    	
		Object[] options = {"Clockwise",
        "Anti-Clockwise"};
		int n = JOptionPane.showOptionDialog(null,
				"What direction would you like the shape to rotate?",
				"Rotation Direction",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		if(n == 0)
			direction = true;
   	
    	speed = Integer.parseInt(JOptionPane.showInputDialog("Please enter a rotation speed from 1 to 500"));
    	while(speed > 500 || speed < 1)
    		speed = Integer.parseInt(JOptionPane.showInputDialog("INPUT NOT VALID! Please enter a rotation speed from 1 to 500"));
    	if(speed < 1 || speed > 500)
    		return;
    	else
    	{
    		view.setRotate(new Rotate(dimension,true,direction,speed));
    	}
    }
    
    public void doSave(){
    	int a = fileChooser.showSaveDialog(view);
    	if (a == JFileChooser.APPROVE_OPTION) {
	    	        File file = fileChooser.getSelectedFile();
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(view.getGlistener().getShapes());
				out.writeObject(view.getBackColor());
				out.close();
			} catch (FileNotFoundException fn) {
				fn.printStackTrace();
			} catch (IOException nf) {
				nf.printStackTrace();
			}
    	}
    }
    
    public void doLoad(){
    	int a = fileChooser.showOpenDialog(view);
    	if (a == JFileChooser.APPROVE_OPTION) {
		    	        File file = fileChooser.getSelectedFile();
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				try {
					view.getGlistener().setShapes((Shape[])in.readObject());
					view.setBackColor((Color)in.readObject());
					in.close();
				} catch (ClassNotFoundException fn) {
					fn.printStackTrace();
				}
			} catch (FileNotFoundException nf) {
				nf.printStackTrace();
			} catch (IOException fnf) {
				fnf.printStackTrace();
			}
	    }
    }
    
    public void doBounce(){
		if(view.getBounce().getBounce())
			view.setBounce(new Bounce(false,0));
		else
		{
			bspeed = Integer.parseInt(JOptionPane.showInputDialog("Please enter a bounce speed from 1 to 10"));
	    	while(bspeed > 10 || bspeed < 1)
	    		bspeed = Integer.parseInt(JOptionPane.showInputDialog("INPUT NOT VALID! Please enter a bounce speed from 1 to 10"));
	    	if(bspeed < 1 || bspeed > 10)
	    		return;
	    	else
	    	{
				view.setBounce(new Bounce(true,bspeed));
	    	}
		}
    }
    
    public void doRecord(String stage){
    	if (stage.matches("startRecord")){
    		record.resetI();
    		view.setRecord(true);
    		System.out.println("Starting Record");
    		record.initFolder();
			record.stop = false;
    		record.saveImg(view.canvas);
    	} else if (stage.matches("recPause")){
    		doPause();
    		if(!recPause){
    			view.setRecPause(true);
    			record.stop = true;
    			recPause = true;
    		}
    		else{
    			recPause = false;
    			view.setRecPause(false);
    			record.stop = false;
        		record.saveImg(view.canvas);
        		}
    	} else if (stage.matches("stopRecord")){
    		view.setRecord(false);
    		System.out.println("Stopping Record");
    		record.stop = true;
    	} else if (stage.matches("exportMP4")){
    		System.out.println("Exporting to MP4");
    		record.exportMovie();
    	}
    }
    
    private void doPause(){
		if(view.getGlistener().getPause()){
        	view.getGlistener().setPause(false);
        	view.setPause(false);
		}
    	else
    	{
        	view.getGlistener().setPause(true);
        	view.setPause(true);
    	}
    }
    
    public int getLastShapePosition(){
		int a = 0;
		for(int i = 0;view.getGlistener().getShapes()[i]!=null;i++)
		{
			a = i+1;
		}
		return a-1;
    }
    
	private void doMotionPath() {
		if(getLastShapePosition()>=0){
			view.setMotion(true);
			view.getMMListener().setRP(true);
		}
	}
	
    public void doMotionTrail() {
    	if(getLastShapePosition()>=0)
    		view.getGlistener().getShapes()[getLastShapePosition()].getTail().toggleTail();
	}
    
    public void chooseColor(){
    	Color a = JColorChooser.showDialog(view, "Choose Shape Colour", Color.white);
    	if(a != null)
    	view.setShapeColor(a);
    }
    
    public void chooseBackground(){
    	Color a = JColorChooser.showDialog(view, "Choose Shape Colour", Color.white);
    	if(a != null)
    	view.setBackColor(a);
    }

}
