package team16.project;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

public class Main {
	public static void main(String[] args) {
	    
        Model      model      = new Model();
        View       view       = new View(model);

        new Controller(model, view);
        
        /**Dimensions of current screen to ensure consistent Icon ratio*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenSize.getWidth();
		Double height = screenSize.getHeight();
		int h = height.intValue();
		int w = width.intValue();
		
        view.setExtendedState(Frame.MAXIMIZED_BOTH);
        view.setSize(w, h);
        view.setVisible(true);
	}

}
