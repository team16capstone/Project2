package team16.project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class EffectToolbar extends JPanel{
	private static final long serialVersionUID = 1L;

	/**All components of File Toolbar*/
	private JToolBar bar = new JToolBar();
	private JCheckBox rotate = new JCheckBox("Rotate");
	private JCheckBox motionPath = new JCheckBox("Motion Path");
	private JButton animate = new JButton("Animate");
	
	private FlowLayout effectLayout = new FlowLayout();
	

	public EffectToolbar()
	{
		effectLayout.setAlignment(FlowLayout.LEFT);
		this.setLayout(effectLayout);

		/**Dimensions of current screen to ensure consistent Icon ratio*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenSize.getWidth();
		Double height = screenSize.getHeight();
		width = width/30;
		height = height/30;
		height.intValue();
		
		/**Set the toolbar horizontal*/
		bar.setOrientation(0);

		/**add all the buttons to the toolbar*/
		bar.add(rotate);
		rotate.setActionCommand("rotate");
		bar.add(motionPath);
		motionPath.setActionCommand("motionPath");
		bar.add(animate);
		animate.setActionCommand("animate");

		/**add toolbar to the panel*/
		add(bar);
		bar.setAlignmentX(0);
		this.setAlignmentX(0);

		
		
	}
	public void addListeners(ActionListener a){
		rotate.addActionListener(a);
		motionPath.addActionListener(a);
		animate.addActionListener(a);

	}
}
