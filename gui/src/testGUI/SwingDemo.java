package testGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public  class SwingDemo extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jlabel1, jlabel2;
	JButton jbutton;

	SwingDemo() {
		super("GUIӦ�ó���");
		jlabel1 = new JLabel("һ��swing ��GUIӦ�ó���", JLabel.CENTER);
		jlabel2 = new JLabel("");
		jbutton = new JButton("����ʱ��");
		jbutton.addActionListener(this);
		getContentPane().add(jlabel1, BorderLayout.NORTH);
		getContentPane().add(jlabel2, BorderLayout.CENTER);
		getContentPane().add(jbutton, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		Calendar c = Calendar.getInstance();
		if (e.getSource() == jbutton) {
			jlabel2.setText("����ʱ���ǣ�" + c.get(Calendar.HOUR_OF_DAY) + "ʱ" + c.get(Calendar.MINUTE) + "��");
		}

	}

	public static void main(String[] args) throws Exception {
		JFrame jframe = new SwingDemo();
		jframe.setSize(200, 100);
		jframe.setVisible(true);
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TimeUnit.SECONDS.sleep(10);
	}
	
}