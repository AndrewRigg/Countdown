import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelpWindow extends JFrame implements ActionListener {
	
		String content;
		String title;
		
		JPanel panMain;
		JTextField txtContent;
		
	HelpWindow(String c, String t){
		content = c;
		title = t;
		
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
