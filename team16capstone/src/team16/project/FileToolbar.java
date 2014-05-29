package team16.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class FileToolbar extends JPanel{
	private static final long serialVersionUID = 1L;
	private FlowLayout fileLayout = new FlowLayout();

	/**All components of File Toolbar*/
	private JToolBar bar = new JToolBar();
	private JButton nNew = new JButton();
	private JButton open = new JButton();
	private JButton save = new JButton();
	private JButton record = new JButton();
	private JButton recPause = new JButton();
	private JButton stopRecord = new JButton();
	private JButton exportMP4 = new JButton();
	
	/**All components of Effects*/
	private JButton rotate = new JButton();
	private JButton motionBounce = new JButton();
	private JButton motionPath = new JButton();
	private JButton motionTail = new JButton();
	private JButton pause = new JButton("Pause Animation");

	private JButton backColor = new JButton("Background Colour");
	private JButton color = new JButton("Shape Colour");
	private JButton undo = new JButton("Undo");
	private JButton redo = new JButton("Redo");
	
	public FileToolbar()
	{
		fileLayout.setAlignment(FlowLayout.LEFT);
		this.setLayout(fileLayout);

		/**Dimensions of current screen to ensure consistent Icon ratio*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenSize.getWidth();
		Double height = screenSize.getHeight();
		width = width/30;
		height = height/30;
		int h = height.intValue();
		
		/**Set the toolbar horizontal*/
		bar.setOrientation(0);

		/**add all the buttons to the toolbar*/
		bar.add(nNew);
		nNew.setActionCommand("new");
		bar.add(open);
		open.setActionCommand("open");
		bar.add(save);
		save.setActionCommand("save");
		bar.add(record);
		record.setActionCommand("record");
		bar.add(recPause);
		recPause.setActionCommand("recPause");
		bar.add(stopRecord);
		stopRecord.setActionCommand("stopRecord");
		bar.add(exportMP4);
		exportMP4.setActionCommand("exportMP4");
		
		bar.addSeparator();
		
		bar.add(rotate);
		rotate.setBackground(Color.LIGHT_GRAY);
		rotate.setActionCommand("rotate");
		bar.add(motionBounce);
		motionBounce.setActionCommand("motionBounce");
		bar.add(motionPath);
		motionPath.setActionCommand("motionPath");
		bar.add(motionTail);
		motionTail.setActionCommand("motionTail");

		bar.addSeparator();
		
		bar.add(pause);
		pause.setActionCommand("pause");
		
		bar.addSeparator();

		bar.add(backColor);
		backColor.setActionCommand("backColor");
		bar.add(color);
		color.setActionCommand("color");
		
		bar.addSeparator();

		bar.add(undo);
		undo.setActionCommand("undo");
		bar.add(redo);
		redo.setActionCommand("redo");
		
		/**add toolbar to the panel*/
		add(bar);
		bar.setAlignmentX(0);
		this.setAlignmentX(0);
		
		/**Set all icons*/
		try {
		    Image tmpNew = ImageIO.read(getClass().getResource("/res/new.jpg"));
		    ImageIcon newIcon = new ImageIcon(tmpNew.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    nNew.setIcon(newIcon);

		    Image tmpOpen = ImageIO.read(getClass().getResource("/res/open.jpg"));
		    ImageIcon openIcon = new ImageIcon(tmpOpen.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    open.setIcon(openIcon);

		    Image tmpSave = ImageIO.read(getClass().getResource("/res/save.jpg"));
		    ImageIcon saveIcon = new ImageIcon(tmpSave.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    save.setIcon(saveIcon);

		    Image tmpRecord = ImageIO.read(getClass().getResource("/res/rec.jpg"));
		    ImageIcon recIcon = new ImageIcon(tmpRecord.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    record.setIcon(recIcon);
		    
		    Image tmpRecPause = ImageIO.read(getClass().getResource("/res/recPause.jpg"));
		    ImageIcon recPauseIcon = new ImageIcon(tmpRecPause.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    recPause.setIcon(recPauseIcon);

		    Image tmpStopRec = ImageIO.read(getClass().getResource("/res/stop.jpg"));
		    ImageIcon stopRecIcon = new ImageIcon(tmpStopRec.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    stopRecord.setIcon(stopRecIcon);

		    Image tmpMP4 = ImageIO.read(getClass().getResource("/res/mp4.jpg"));
		    ImageIcon mp4Icon = new ImageIcon(tmpMP4.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    exportMP4.setIcon(mp4Icon);

		    Image tmpRotate = ImageIO.read(getClass().getResource("/res/rotate.jpg"));
		    ImageIcon rotateIcon = new ImageIcon(tmpRotate.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    rotate.setIcon(rotateIcon);
		    
		    Image tmpBounce = ImageIO.read(getClass().getResource("/res/bounce.jpg"));
		    ImageIcon bounceIcon = new ImageIcon(tmpBounce.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    motionBounce.setIcon(bounceIcon);
		    
		    Image tmpPath = ImageIO.read(getClass().getResource("/res/path.jpg"));
		    ImageIcon pathIcon = new ImageIcon(tmpPath.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    motionPath.setIcon(pathIcon);
		    
		    Image tmpTail = ImageIO.read(getClass().getResource("/res/tail.jpg"));
		    ImageIcon tailIcon = new ImageIcon(tmpTail.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    motionTail.setIcon(tailIcon);
		    
		  } catch (IOException ex) {
		  }
		
		
	}
	public void addListeners(ActionListener a){
		nNew.addActionListener(a);
		open.addActionListener(a);
		save.addActionListener(a);
		record.addActionListener(a);
		recPause.addActionListener(a);
		stopRecord.addActionListener(a);
		exportMP4.addActionListener(a);
		rotate.addActionListener(a);
		motionBounce.addActionListener(a);
		motionPath.addActionListener(a);
		motionTail.addActionListener(a);
		pause.addActionListener(a);
		backColor.addActionListener(a);
		color.addActionListener(a);
		undo.addActionListener(a);
		redo.addActionListener(a);
	}
	
	public void setColor(Color c){
		color.setBackground(c);
		color.setOpaque(true);
		color.setBorderPainted(false);
	}
	
	public void setBackColor(Color c){
		backColor.setBackground(c);
		backColor.setOpaque(true);
		backColor.setBorderPainted(false);
	}
	public Color getBackColor(){
		return backColor.getBackground();
	}
	
	public void setRotateColor(Boolean b){
		if(b)
			turnOn(rotate);
		else
			turnOff(rotate);
	}
	
	public void setRecordColor(Boolean b){
		if(b)
			turnOn(rotate);
		else
			turnOff(rotate);
	}
	
	public void setRecPauseColor(Boolean b){
		if(b)
		{
			turnOn(recPause);
			turnOff(record);			
		}
		else
		{
			turnOff(recPause);
			turnOn(record);			
		}

	}
	
	public void setBounceColor(Boolean b){
		if(b)
			turnOn(motionBounce);
		else
			turnOff(motionBounce);
	}
	
	public void setMotionPathColor(Boolean b){
		if(b)
			turnOn(motionPath);
		else
			turnOff(motionPath);
	}
	
	public void setPause(Boolean p){
		if(p)
			turnOn(pause);
		else
			turnOff(pause);
	}
	
	public void setRecord(Boolean p){
		if(p)
			turnOn(record);
		else
			turnOff(record);
	}
	
	public void turnOn(JButton b){
		b.setBackground(Color.YELLOW);
		b.setOpaque(true);
		b.setBorderPainted(false);
	}
	
	public void turnOff(JButton b){
		b.setBackground(Color.LIGHT_GRAY);
		b.setOpaque(true);
		b.setBorderPainted(true);
	}
}
