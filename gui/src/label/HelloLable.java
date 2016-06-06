package label;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloLable {
	public static void main(String[] args)throws Exception{
		JFrame jframe=new JFrame("hello swing");
		JLabel jlabel=new JLabel("A label");
		jframe.add(jlabel);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jframe.setSize(300, 100);
	jframe.setVisible(true);
	TimeUnit.SECONDS.sleep(10);
	SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			jlabel.setText("hey! this is Different");
		}
	});
  
  
	}

}
