	
	import java.awt.*;
	import javax.swing.*;
	import java.awt.geom.*;
	import java.awt.event.*;
	import javax.swing.border.*;

	public class ChangeButtonShape {
	public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.getContentPane().setLayout(null);
	JLabel l=new JLabel("Name");
	final JTextField text=new JTextField(20);
	JButton button = new JButton("Go");
	//button.setBackground(Color.lightGray);
	l.setBounds(10,10,100,20);
	text.setBounds(100,10,180,20);
	button.setBounds(10,40,50,20);
	button.setBorder(new RoundedBorder(10));
	frame.add(l);
	frame.add(text);
	frame.add(button);

	button.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e){
	String st=text.getText();
	JOptionPane.showMessageDialog(null,"Hello "+st);
	    }
	});
	frame.setSize(300,150);
	frame.setVisible(true);
	}
	}
	class RoundedBorder implements Border {
	        int radius;
	        RoundedBorder(int radius) {
	            this.radius = radius;
	        }
	        public Insets getBorderInsets(Component c) {
	            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	        }
	        public boolean isBorderOpaque() {
	            return true;
	        }
	        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
	        }
	    }
