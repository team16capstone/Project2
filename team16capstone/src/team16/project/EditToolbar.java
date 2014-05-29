package team16.project;

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

public class EditToolbar extends JPanel{
	private static final long serialVersionUID = 1L;

	/**All components of Edit Toolbar*/
	private JToolBar bar = new JToolBar();
	private JButton circle = new JButton();
	private JButton cross = new JButton();
	private JButton square = new JButton();
	private JButton star = new JButton();
	private JButton wave = new JButton();
	
	public EditToolbar()
	{
		this.setLayout(new FlowLayout());
		
		/**Dimensions of current screen to ensure consistent Icon ratio*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenSize.getWidth();
		Double height = screenSize.getHeight();
		width = width/30;
		height = height/30;
		int h = height.intValue();
		
		/**Set the toolbar vertical*/
		bar.setOrientation(1);
		
		/**add all the buttons to the toolbar*/
		bar.add(circle);
		circle.setActionCommand("circle");
		bar.add(cross);
		cross.setActionCommand("cross");
		bar.add(wave);
		wave.setActionCommand("wave");
		bar.add(square);
		square.setActionCommand("square");
		bar.add(star);
		star.setActionCommand("star");
		bar.addSeparator();
		

		/**add toolbar to the panel*/
		add(bar);
		
		/**Set all icons*/
		try {
		    Image tmpCircle = ImageIO.read(getClass().getResource("/res/circle.jpg"));
		    ImageIcon circleIcon = new ImageIcon(tmpCircle.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    circle.setIcon(circleIcon);
		    
		    Image tmpCross = ImageIO.read(getClass().getResource("/res/cross.jpg"));
		    ImageIcon crossIcon = new ImageIcon(tmpCross.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    cross.setIcon(crossIcon);
		    
		    Image tmpSquare = ImageIO.read(getClass().getResource("/res/square.jpg"));
		    ImageIcon squareIcon = new ImageIcon(tmpSquare.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    square.setIcon(squareIcon);
		    
		    Image tmpStar = ImageIO.read(getClass().getResource("/res/star.jpg"));
		    ImageIcon starIcon = new ImageIcon(tmpStar.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    star.setIcon(starIcon);
		    
		    Image tmpWave = ImageIO.read(getClass().getResource("/res/wave.jpg"));
		    ImageIcon waveIcon = new ImageIcon(tmpWave.getScaledInstance(h, h, Image.SCALE_AREA_AVERAGING));
		    wave.setIcon(waveIcon);
		} catch (IOException ex) {
		  }
	}
	
	public void addListeners(ActionListener a){
		circle.addActionListener(a);
		cross.addActionListener(a);
		square.addActionListener(a);
		star.addActionListener(a);
		wave.addActionListener(a);
	}
}
