package list;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH=400;
	private static final int DEFAULT_HEIGHT=300;
	@SuppressWarnings("unused")
	private  JPanel listPanel;
	@SuppressWarnings("unused")
	private JList<String>wordList;
	@SuppressWarnings("unused")
	private JLabel label;
	@SuppressWarnings("unused")
	private JPanel buttonPanel;
	@SuppressWarnings("unused")
	private  ButtonGroup group;
	@SuppressWarnings("unused")
	private String prefix="The";
	@SuppressWarnings("unused")
	private String suffix="for jumps over the laze dog.";
	@SuppressWarnings("unused")
	public ListFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		String[] words={"quick","hungry","wild","silent","private","abstract","static","final"};
			}
	
	

}
