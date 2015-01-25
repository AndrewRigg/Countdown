import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

/**
 * 'Countdown' Graphical User Interface using NewMethodTrees class.
 * 
 * @author Andrew Rigg
 * @author Cameron Craig
 * 
 */

public class CountdownGUI3 extends JFrame implements ActionListener {

	private static CountdownProgram prog = null;
	JLabel[] numbers = new JLabel[6];
	JButton[] num = new JButton[14];
	int[] counters = new int[14];
	JTextField target;
	public int[] variables = new int[7];
	JMenuBar jb;
	JMenu file;
	JMenuItem MHelp, MInfo, MExit, MExample;
	JLabel script;
	JButton clear;
	JLabel tile;
	JPanel panel0;
	JPanel panel1;
	JPanel panel2;
	JButton calculate;
	static int o = 0;
	Font f = new Font("Arial", Font.PLAIN, 80);
	Font g = new Font("Industria", Font.ITALIC, 50);
	Font h = new Font("Industria", Font.PLAIN, 120);
	Font i = new Font("Helvetica", Font.PLAIN, 100);
	Font j = new Font("Arial", Font.PLAIN, 56);
	Font k = new Font("Serif", Font.ITALIC, 36);
	Font l = new Font("University Roman", Font.PLAIN, 14);
	Font m = new Font("University Roman", Font.PLAIN, 20);
	Font nf = new Font("Industria", Font.PLAIN, 56);
	
	NewMethodTrees trial = new NewMethodTrees();
	
	static int intl;
	static Random generator = new Random();
	static int p;
	static int r;
	static int t = generator.nextInt(6);
	static int[] count = new int[14];
	int answerIndex = 0;

	public CountdownGUI3() {
		setLayout(new GridLayout(4, 1));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		panel0 = new JPanel(new GridLayout(1, 14));
		for (int i = 0; i < num.length; i++) {
			num[i] = new JButton();
			num[i].setBackground(Color.getHSBColor(2.5f, 1.1f, 3.6f));
			num[i].setFont(m);
			num[i].setBorder(new RoundedBorder(15));
			num[i].setOpaque(true);
			num[i].addActionListener(this);
			num[i].setText("" + (i + 1));
			panel0.add(num[i]);

		}
		num[10].setText("25");
		num[11].setText("50");
		num[12].setText("75");
		num[13].setText("100");

		panel1 = new JPanel(new GridLayout(1, 6));

		for (int i = 0; i < 6; i++) {
			numbers[i] = new JLabel("", JLabel.CENTER);
			numbers[i].setBackground(Color.lightGray);
			numbers[i].setFont(f);
			numbers[i].setBorder(new RoundedBorder(10));
			numbers[i].setOpaque(true);
			panel1.add(numbers[i]);
		}
		panel2 = new JPanel(new GridLayout(1, 3));
		panel2.setBackground(Color.lightGray);

		clear = new JButton("Back");
		clear.setFont(g);
		clear.setForeground(Color.blue);
		clear.setBorder(new RoundedBorder(20));
		clear.setOpaque(true);
		clear.addActionListener(this);
		panel2.add(clear);

		target = new JTextField();
		target.setBackground(Color.darkGray);
		target.setForeground(Color.red);
		target.setFont(h);
		target.setHorizontalAlignment(SwingConstants.CENTER);
		target.setOpaque(true);
		target.addActionListener(this);
		panel2.add(target);

		calculate = new JButton("Go");
		calculate.setFont(g);
		calculate.setForeground(Color.blue);
		calculate.setBorder(new RoundedBorder(20));
		calculate.setOpaque(true);
		calculate.addActionListener(this);
		panel2.add(calculate);

		script = new JLabel("", SwingConstants.CENTER);
		script.setBackground(Color.gray);
		script.setFont(j);
		script.setOpaque(true);

		jb = new JMenuBar();
		file = new JMenu("File");

		MHelp = new JMenuItem("Help");
		MHelp.addActionListener(this);
		MInfo = new JMenuItem("Info");
		MInfo.addActionListener(this);
		MExit = new JMenuItem("Exit");
		MExit.addActionListener(this);
		MExample = new JMenuItem("Example");
		MExample.addActionListener(this);

		file.add(MHelp);
		file.add(MInfo);
		file.add(MExit);
		file.add(MExample);

		jb.add(file);
		setJMenuBar(jb);

		add(panel0);
		add(panel1);
		add(panel2);
		add(script);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == MHelp) {
			script.setBackground(Color.green);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("<html>HELP<br>Enter 6 numbers into the 6 panes on the second row"
					+ " (a maximum of 4 large and 6 small from {1,2,3,4,5,6,7,8,9,10,25,50,75,100}) "
					+ "by clicking on the appropriate button.  "
					+ "Then type the three digit target number into the middle pane.  "
					+ "By pressing the 'GO' button, the solver will calculate the solution "
					+ "to the problem written in a concise mathematical form involving brackets.  "
					+ "If no solution is possible the solver will display the message that it "
					+ "has no solution.  To exit, go to the menu tab and click on 'Exit'. <html>");
		}

		if (e.getSource() == MInfo) {
			script.setBackground(Color.yellow);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("<html>INFO<br>'Countdown Solver' is a product of CHEW Enterprises.  "
					+ // CHEW enterprises for
					"The purpose of this product is to provide the user with a tool for "
					+ // (cheap example)
					"accurately solving the numbers round of the popular UK television "
					+ // Computing & Electronics
					"show 'Countdown'.<br>For other products by this maker please visit the "
					+ // Heriot Watt
					"website at www.CountDownSolver.com.  To contact the maker of "
					+ "this product please email  AndrewJRigg@googlemail.com.  Thank "
					+ "you for using this product. <html>");
		}

		if (e.getSource() == MExample) {
			trial.clearAnswers();
			clear.setText("Clear");
			script.setText("");
			script.setBackground(Color.gray);
			p = 100 + generator.nextInt(900);
			r = generator.nextInt(14);
			calculate.setFont(i);
			calculate.setText("GO");
			for (int j = 0; j < count.length; j++) {
				count[j] = 0;
			}
			for (int i = 0; i < 6; i++) {
				numbers[i].setText(num[r].getText());
				count[r]++;
				r = generator.nextInt(14);
				while (count[r] > 1) {
					r = generator.nextInt(14);
				}
				while (r > 9 && count[r] > 0) {
					r = generator.nextInt(14);
				}
			}
			target.setText("" + p);
		}

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == num[i] && o < 6) {
				clear.setText("Clear");
				script.setBackground(Color.gray);
				script.setText("");
				if (counters[i] < 2) {
					numbers[o].setText(num[i].getText());
					o++;
					counters[i]++;
					if (counters[i] == 2) {
						num[i].setEnabled(false);
					}
				}
			}
		}
		for (int i = 10; i < num.length; i++) {
			if (e.getSource() == num[i] && o < 6) {
				clear.setText("Clear");
				script.setBackground(Color.gray);
				script.setText("");
				if (counters[i] < 1) {
					numbers[o].setText(num[i].getText());
					o++;
					counters[i]++;
					if (counters[i] == 1) {
						num[i].setEnabled(false);
					}
				}
			}
		}
		if (!(numbers[5].getText().equals("")) && target.getText().equals("")) {
			calculate.setFont(k);
			calculate.setText("< Enter Target");
			for (int i = 0; i < num.length; i++) {
				num[i].setEnabled(false);
			}
		}
		if (e.getSource() == clear) {
			if (clear.getText().equals("Back")) {
				CountdownProgram prog = new CountdownProgram();
				prog.setTitle("Countdown");
				prog.setVisible(true);
				prog.setSize(1000, 450);
				prog.getMessage();
				prog.script.setBackground(Color.gray);
				prog.script.setText("");
				clear.setText("Clear");
				this.dispose();
			}
			if (CountdownProgram.playMusic){
			CountdownProgram.playMusic = false;
			Noise.stop();
			CountdownProgram.playMusic();
			}
			/*This section of code is what happens when the clear button is pressed
			 * in the numbers round - I think*/
			trial.clearAnswers();
			System.out.println("Answers cleared");
			clear.setText("Back");
			target.setText("");
//			calculate.setFont(k);
//			calculate.setText("Select Numbers");
			script.setText("");
			script.setBackground(Color.gray);
			for (int i = 0; i < 6; i++) {
				if (!(numbers[i].getText().equals(""))) {
					numbers[i].setText("");
					o = 0;
					for (int j = 0; j < num.length; j++) {
						counters[j] = 0;
						num[j].setEnabled(true);
					}
				}
			}
			answerIndex = 0;
			trial.clearAnswers();
		}

		if (e.getSource() == target) {
			clear.setText("Clear");
			script.setBackground(Color.gray);
			script.setText("");
			script.setFont(j);
//			calculate.setFont(i);
//			calculate.setText("GO");

		}

		if (e.getSource() == MExit) {
			System.exit(0);
		}

		if (e.getSource() == calculate) {
			clear.setText("Clear");
			script.setBackground(Color.gray);
			script.setForeground(Color.white);
			script.setText("");
			script.setFont(nf);
			double[] inputNumbers = new double[6];
			for (int i = 0; i < 6; i++) {
				if (!numbers[i].getText().equals("")) {
					inputNumbers[i] = Integer.parseInt(numbers[i].getText());
				} else
					script.setText("You must select six numbers");
			}
			if (inputNumbers.length == 6) {

				try {
					//CountDown8 c = new CountDown8(n, Integer.parseInt(target.getText()));
					//String s = c.calculate();
					
					if(answerIndex == 0){
					//trial.clearAnswers();
					trial.setInputVariables(inputNumbers,Integer.parseInt(target.getText()));
					trial.setVariable();
					trial.setTempVariable();
					trial.setOperator();
					trial.setTempOperator();
					trial.setBinTree("NewMethodTrees.txt");
					trial.setTempBinTree();
					trial.setOperate();
					}
					
					String ans = trial.getAnswer(answerIndex);
					
					script.setText(ans);
					answerIndex++;
					CountdownProgram.playMusic = false;
					Noise.stop();

					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {

						public void run() {
							Noise.playSound("Countdown-end.wav");
							timer.cancel();
						}

					}, 0);

				} catch (NumberFormatException ec) {
					target.setText("");
					script.setBackground(Color.gray);
					script.setText("You must enter a number");
				}

			}
			trial.clearAnswers();
		}
	}

	 public static void main (String [] args){
	 CountdownGUI3 countdown = new CountdownGUI3();
	 countdown.setTitle("Countdown Solver");
	 countdown.setSize(1000, 450);
	 countdown.setVisible(true);
	
	
	
	 countdown.addWindowListener(new WindowAdapter() {
	 public void windowClosing(WindowEvent e) {
	 System.exit(0);
	 }
	 });
	 }

}
