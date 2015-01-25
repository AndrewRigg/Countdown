import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class CountdownProgram extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar jb;
	JMenu file;
	JMenuItem MHelp, MInfo, MExit, MSound;
	JPanel welcome;
	JPanel middle;
	JLabel script;
	JPanel topLeft;
	JPanel topRight;
	JPanel bottom;
	JButton numbers;
	JButton letters;
	JButton conundrum;
	JLabel[] flash1 = new JLabel[121];
	JLabel[] flash2 = new JLabel[121];
	JLabel[] flash3 = new JLabel[9];
	static String str;
	static int a;
	Label[] marquee = new Label[digits];
	final static int digits = 9;
	Font f = new Font("Arial", Font.BOLD, 36);
	Font g = new Font("Indutria", Font.ITALIC, 100);
	Font j = new Font("Times New Roman", Font.ITALIC, 100);
	Font h = new Font("Serif", Font.ITALIC, 36);
	Font l = new Font("University Roman", Font.PLAIN, 14);
	Font i = new Font("Indutria", Font.ITALIC, 50);
	char[] rotate = { 'C', 'O', 'U', 'N', 'T', 'D', 'O', 'W', 'N' };
	Color[] rainbow = { Color.red, Color.orange, Color.yellow, Color.green,
			Color.blue, Color.magenta, Color.gray, Color.cyan, Color.pink };
	Color[] rainbow2 = { Color.green, Color.black, Color.magenta, Color.orange,
			Color.yellow, Color.blue, Color.cyan, Color.pink, Color.gray, };
	Color flash1Cols;
	Color flash2Cols;
	private int counter;
	public static boolean playMusic = true;

	public CountdownProgram() {

		setLayout(new GridLayout(3, 1));

		welcome = new JPanel(new GridLayout(1, 11));
		// welcome.setBackground(Color.lightGray);

		topLeft = new JPanel(new GridLayout(11, 11));
		topLeft.setBackground(Color.lightGray);

		for (int i = 0; i < flash1.length; i++) {
			flash1[i] = new JLabel("", JLabel.CENTER);
			flash1[i].setBackground(Color.lightGray);
			flash1[i].setOpaque(true);
			topLeft.add(flash1[i]);
		}
		flash1[0].setBackground(Color.blue);
		flash1[12].setBackground(Color.blue);
		flash1[24].setBackground(Color.blue);
		flash1[36].setBackground(Color.blue);
		flash1[48].setBackground(Color.blue);
		flash1[60].setBackground(Color.blue);
		flash1[70].setBackground(Color.blue);
		flash1[80].setBackground(Color.blue);
		flash1[90].setBackground(Color.blue);
		flash1[100].setBackground(Color.blue);
		flash1[110].setBackground(Color.blue);

		welcome.add(topLeft);

		for (int j = 0; j < digits; j++) {
			marquee[j] = new Label("", JLabel.CENTER);
			marquee[j].setBackground(Color.lightGray);
			marquee[j].setForeground(Color.darkGray);
			marquee[j].setFont(g);
			welcome.add(marquee[j]);
		}

		topRight = new JPanel(new GridLayout(11, 11));
		topRight.setBackground(Color.lightGray);

		for (int k = 0; k < flash2.length; k++) {
			flash2[k] = new JLabel("", JLabel.CENTER);
			flash2[k].setBackground(Color.lightGray);
			flash2[k].setOpaque(true);
			topRight.add(flash2[k]);
		}
		flash2[10].setBackground(Color.blue);
		flash2[20].setBackground(Color.blue);
		flash2[30].setBackground(Color.blue);
		flash2[40].setBackground(Color.blue);
		flash2[50].setBackground(Color.blue);
		flash2[60].setBackground(Color.blue);
		flash2[72].setBackground(Color.blue);
		flash2[84].setBackground(Color.blue);
		flash2[96].setBackground(Color.blue);
		flash2[108].setBackground(Color.blue);
		flash2[120].setBackground(Color.blue);
		welcome.add(topRight);

		middle = new JPanel(new GridLayout(1, 3));

		script = new JLabel("", SwingConstants.CENTER);
		script.setBackground(Color.gray);
		script.setFont(h);
		script.setOpaque(true);

		numbers = new JButton();
		numbers.setForeground(Color.blue);
		numbers.setBorder(new RoundedBorder(20));
		numbers.setFont(i);
		numbers.setOpaque(true);
		numbers.addActionListener(this);
		numbers.setText("Numbers");

		letters = new JButton();
		letters.setForeground(Color.blue);
		letters.setBorder(new RoundedBorder(20));
		letters.setFont(i);
		letters.setOpaque(true);
		letters.addActionListener(this);
		letters.setText("Letters");

		conundrum = new JButton();
		conundrum.setForeground(Color.blue);
		conundrum.setBorder(new RoundedBorder(20));
		conundrum.setFont(i);
		conundrum.setOpaque(true);
		conundrum.addActionListener(this);
		conundrum.setText("Conundrum");

		middle.add(numbers);
		middle.add(letters);
		middle.add(conundrum);

		bottom = new JPanel(new GridLayout(1, 9));

		for (int i = 0; i < flash3.length; i++) {
			flash3[i] = new JLabel("", JLabel.CENTER);
			flash3[i].setBackground(rainbow[i]);
			flash3[i].setForeground(rainbow2[i]);
			flash3[i].setText("" + rotate[i]);
			flash3[i].setOpaque(true);
			flash3[i].setFont(j);
			bottom.add(flash3[i]);
		}

		jb = new JMenuBar();
		file = new JMenu("File");

		MHelp = new JMenuItem("Help");
		MHelp.addActionListener(this);
		MInfo = new JMenuItem("Info");
		MInfo.addActionListener(this);
		MExit = new JMenuItem("Exit");
		MExit.addActionListener(this);
		MSound = new JMenuItem("Sound");
		MSound.addActionListener(this);

		file.add(MSound);
		file.add(MHelp);
		file.add(MInfo);
		file.add(MExit);

		jb.add(file);
		setJMenuBar(jb);

		add(welcome);
		add(middle);
		add(script);
		// add(bottom); // Beware untabbing this and tabbing out the line above
		// may make the app look garish and cheap!
	}

	public void shift() {
		for (int i = 0; i < digits - 1; i++) {
			marquee[i].setText(marquee[i + 1].getText());
		}
		marquee[digits - 1].setText(" ");

	}

	public void shift3() {
		Color col = flash3[0].getBackground();
		Color col2 = flash3[8].getForeground();
		for (int j = 0; j < flash3.length - 1; j++) {
			flash3[j].setBackground(flash3[j + 1].getBackground());
		}
		flash3[8].setBackground(col);
		for (int k = flash3.length - 1; k > 0; k--) {

			flash3[k].setForeground(flash3[k - 1].getForeground());
		}
		flash3[0].setForeground(col2);
	}

	public void shift2() {

		for (int j = 0; j < 11; j++) {
			flash1Cols = flash1[11 * j + 10].getBackground();
			for (int k = 10; k > 0; k--) {
				flash1[11 * j + k].setBackground(flash1[(11 * j + k) - 1]
						.getBackground());
			}
			flash1[11 * j].setBackground(flash1Cols);
		}

		for (int j = 0; j < 11; j++) {
			flash2Cols = flash2[11 * j].getBackground();
			for (int k = 0; k < 10; k++) {
				flash2[11 * j + k].setBackground(flash2[11 * j + k + 1]
						.getBackground());
			}
			flash2[11 * j + 10].setBackground(flash2Cols);
		}
	}

	public void getMessage() {
		str = "Countdown         ";

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			public void run() {

				if (counter == str.length() + 1) {
					counter = 0;
				}
				if (counter < str.length()) {
					shift();
					shift2();
					shift3();
					marquee[digits - 1].setText(str.substring(counter,
							counter + 1));
				}
				counter++;
			}
		}, 0, 1 * 200);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == MHelp) {
			script.setBackground(Color.green);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("<html>HELP<br>This application is designed to allow you to simulate "
					+ "and solve the different rounds in the popular gameshow 'Countdown'. "
					+ "It has comprehensive solutions to each of the numbers rounds, letters round and conundrum examples.  "
					+ "Just select the button of the round you want to attempt; help options are available in each section.");
		}

		if (e.getSource() == MInfo) {
			script.setBackground(Color.yellow);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("<html>INFO<br>'Countdown' is educationa product of CHEW Enterprises.  "
					+ "The purpose of this product is to provide the user with a tool for<br> "
					+ "accurately solving the popular UK television "
					+ "show 'Countdown'.<br>For other products by this maker please visit the "
					+ "website at www.CountDownSolver.com.  To contact the maker of "
					+ "this product please email  AndrewJRigg@googlemail.com.  Thank "
					+ "you for using this product. <html>");
		}

		if (e.getSource() == MSound){
			if (playMusic){
				playMusic = false;
				Noise.stop();
			}
			else if (!playMusic){
				playMusic();
				playMusic = true;
			}
		}
		
		if (e.getSource() == numbers) {
			CountdownGUI3 countdown = new CountdownGUI3();
			countdown.setTitle("Countdown Solver");
			countdown.setSize(1000, 450);
			countdown.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == letters) {
			WordsGUI w = new WordsGUI();
			w.setSize(1000, 450);
			w.setTitle("Countdown Words");
			w.setVisible(true);
			this.setVisible(false);
		}
		
		if (e.getSource() == conundrum) {
			ConundrumGUI w = new ConundrumGUI();
			w.setSize(1000, 450);
			w.setTitle("Countdown Conundrum");
			w.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == MExit) {
			System.exit(0);
		}
	}

	static void playMusic() {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			public void run() {
				Noise.playSound("Countdown-start.wav");
				//playMusic = true;
				playLoopMusic();
				timer.cancel();
			}
		}, 0);

	}

	public static void playLoopMusic() {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (playMusic) {
					Noise.playSound("Countdown-repeat.wav");
				}
			}
		}, 0, 1 * 10600);
	}


	public static void main(String[] args) {
		CountdownProgram prog = new CountdownProgram();
		prog.setTitle("Countdown");
		prog.setVisible(true);
		prog.setSize(1000, 450);
		prog.getMessage();
		prog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		playMusic();
	}
	
}