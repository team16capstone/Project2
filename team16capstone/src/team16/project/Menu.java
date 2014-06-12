package team16.project;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1L;

	/**File Menu Components*/
	private JMenu file = new JMenu("File");
	private JMenuItem nNew = new JMenuItem("New");
	private JMenuItem openProject = new JMenuItem("Open Project");
	private JMenuItem saveProject = new JMenuItem("Save Project");
	private JMenu exportMovie = new JMenu("Export");
	private JMenuItem exportMP4 = new JMenuItem("Export To MP4");
	private JMenuItem exit = new JMenuItem("Exit");

	/**Edit Menu Components*/
	private JMenu edit = new JMenu("Edit");
	private JMenu coloring = new JMenu("Coloring");
	private JMenuItem shapeColor = new JMenuItem("Shape Color");
	private JMenuItem backgroundColor = new JMenuItem("Background Color");
	private JMenuItem undo = new JMenuItem("Undo");
	private JMenuItem redo = new JMenuItem("Redo");
	private JMenuItem pause = new JMenuItem("Pause");
	
	/**Insert Menu Components*/
	private JMenu insert = new JMenu("Insert");
	private JMenuItem circle = new JMenuItem("Circle");
	private JMenuItem cross = new JMenuItem("Cross");
	private JMenuItem square = new JMenuItem("Square");
	private JMenuItem star = new JMenuItem("Star");
	private JMenuItem wave = new JMenuItem("Wave");

	/**Effects Menu Components*/
	private JMenu effects = new JMenu("Effects");
	private JMenuItem rotate = new JMenuItem("Rotate");
	private JMenuItem bounce = new JMenuItem("Bounce");
	private JMenuItem motionPath = new JMenuItem("Motion Path");
	private JMenuItem motionTrail = new JMenuItem("Motion Trail");

	/**Recording Menu Components*/
	private JMenu recording = new JMenu("Recording");
	private JMenuItem record = new JMenuItem("Record");
	private JMenuItem pauseRecording = new JMenuItem("Pause Recording");
	private JMenuItem stopRecording = new JMenuItem("Stop Recording");
	
    public Menu() {
    	/**Add File Menu*/
    	exportMovie.add(exportMP4);
    	file.add(nNew);
    	file.add(openProject);
    	file.add(saveProject);
    	file.addSeparator();
    	file.add(exportMovie);
    	file.addSeparator();
    	file.add(exit);
    	this.add(file);
    	
    	/**Add Edit Menu*/
    	coloring.add(shapeColor);
    	coloring.add(backgroundColor);
    	edit.add(coloring);
    	edit.addSeparator();
    	edit.add(undo);
    	edit.add(redo);
    	edit.addSeparator();
    	edit.add(pause);
    	this.add(edit);
    	
    	/**Add Insert Menu*/
    	insert.add(circle);
    	insert.add(cross);
    	insert.add(square);
    	insert.add(star);
    	insert.add(wave);
    	this.add(insert);
    	
    	/**Add Effects Menu*/
    	effects.add(rotate);
    	effects.add(bounce);
    	effects.add(motionPath);
    	effects.add(motionTrail);
    	this.add(effects);

    	/**Add Recording Menu*/
    	recording.add(record);
    	recording.add(pauseRecording);
    	recording.add(stopRecording);
    	this.add(recording);
    	
    	/**Add File Menu Shortcuts*/
    	file.setMnemonic('F');
    	nNew.setMnemonic('N');
    	openProject.setMnemonic('O');
    	saveProject.setMnemonic('S');
    	exportMovie.setMnemonic('E');
    	exportMP4.setMnemonic('P');
    	exit.setMnemonic('X');

    	/**Add Edit Menu Shortcuts*/
    	edit.setMnemonic('E');
    	coloring.setMnemonic('C');
    	shapeColor.setMnemonic('S');
    	backgroundColor.setMnemonic('B');
    	undo.setMnemonic('U');
    	redo.setMnemonic('R');
    	pause.setMnemonic('P');
    	
    	/**Add Insert Menu Shortcuts*/
    	insert.setMnemonic('I');
    	circle.setMnemonic('C');
    	cross.setMnemonic('R');
    	square.setMnemonic('Q');
    	star.setMnemonic('S');
    	wave.setMnemonic('W');
    	
    	/**Add Effects Menu Shortcuts*/
    	effects.setMnemonic('S');
    	rotate.setMnemonic('R');
    	bounce.setMnemonic('B');
    	motionPath.setMnemonic('P');
    	motionTrail.setMnemonic('T');
    	
    	/**Add Recording Menu Shortcuts*/
    	recording.setMnemonic('R');
    	record.setMnemonic('R');
    	pauseRecording.setMnemonic('P');
    	stopRecording.setMnemonic('S');

    }

    void addItemListener(ActionListener t) {
    	nNew.addActionListener(t);
    	openProject.addActionListener(t);
    	saveProject.addActionListener(t);
    	exportMP4.addActionListener(t);
    	exit.addActionListener(t);
    	shapeColor.addActionListener(t);
    	backgroundColor.addActionListener(t);
    	undo.addActionListener(t);
    	redo.addActionListener(t);
    	pause.addActionListener(t);
    	circle.addActionListener(t);
    	cross.addActionListener(t);
    	square.addActionListener(t);
    	star.addActionListener(t);
    	wave.addActionListener(t);
    	rotate.addActionListener(t);
    	bounce.addActionListener(t);
    	motionPath.addActionListener(t);
    	motionTrail.addActionListener(t);
    	record.addActionListener(t);
    	pauseRecording.addActionListener(t);
    	stopRecording.addActionListener(t);
    }
}
