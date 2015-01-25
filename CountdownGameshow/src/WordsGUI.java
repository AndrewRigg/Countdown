import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

class WordsGUI extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static CountdownProgram prog = null;
	HashMap<Integer, Character> l_c = new HashMap<Integer, Character>();
	HashMap<Integer, Character> l_v = new HashMap<Integer, Character>();
	JPanel toprow;
	JPanel middle;
	JPanel randombuttons;
	JMenuBar jb;
	JMenu file;
	JMenuItem MHelp, MInfo, MExit, MExample;
	JButton btnrcon, btnrvow, clear;
	JButton btncalc;
	JScrollPane scrresults;
	JLabel[] lblChar = new JLabel[9];
	int letters_entered = 0;
	static JTextArea script;
	Font l = new Font("University Roman", Font.PLAIN, 14);
	Font g = new Font("Industria", Font.PLAIN, 84);
	static Font h = new Font("Industria", Font.ITALIC, 50);
	static Font i = new Font("Sans Serif", Font.PLAIN, 44);
	static Font j = new Font("Comic Sans", Font.PLAIN, 36);
	static Font k = new Font("Times New Roman", Font.PLAIN, 56);
	
	public WordsGUI() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		
		setLayout(new GridLayout(3, 1));
		addKeyListener(this);

		toprow = new JPanel(new GridLayout(1, 10));
		toprow.setBackground(Color.lightGray);

		randombuttons = new JPanel(new GridLayout(2, 1));

		btnrcon = new JButton("C");
		btnrcon.addKeyListener(this);
		btnrcon.setFont(i);
		btnrcon.setBackground(Color.getHSBColor(2.5f, 1.1f, 3.6f));
		btnrcon.setBorder(new RoundedBorder(15));
		randombuttons.add(btnrcon);

		btnrvow = new JButton("V");
		btnrvow.addKeyListener(this);
		btnrvow.setFont(i);
		btnrvow.setBackground(Color.getHSBColor(2.5f, 1.1f, 3.6f));
		btnrvow.setBorder(new RoundedBorder(15));
		randombuttons.add(btnrvow);

		for (int i = 0; i < 9; i++) {
			lblChar[i] = new JLabel("");
			lblChar[i].setFont(g);
			lblChar[i].setHorizontalAlignment(SwingConstants.CENTER);
			toprow.add(lblChar[i]);
		}

		toprow.add(randombuttons);

		middle = new JPanel(new GridLayout(1, 2));

		clear = new JButton("Back");
		clear.setForeground(Color.blue);
		clear.setFont(h);
		clear.setBorder(new RoundedBorder(20));
		clear.addActionListener(this);
		clear.addKeyListener(this);

		btncalc = new JButton("Select Letters");
		btncalc.addActionListener(this);
		btncalc.setForeground(Color.blue);
		btncalc.setFont(h);
		btncalc.setBorder(new RoundedBorder(20));
		btncalc.setSize(800, 50);

		middle.add(clear);
		middle.add(btncalc);


		script = new JTextArea("Results will be displayed here\n");

		script = new JTextArea("Results will be displayed here \n");

		script.setBackground(Color.gray);
		script.setFont(h);
		script.setColumns(20);
		scrresults = new JScrollPane(script);

		btnrcon.addActionListener(this);
		btnrvow.addActionListener(this);

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

		add(toprow);
		add(middle);
		add(scrresults);
	}

	public void actionPerformed(ActionEvent e) {

		if (letters_entered == 8) {
			// btncalc.setEnabled(true);
			btncalc.setText("Find Words");
			btnrvow.setEnabled(false);
			btnrcon.setEnabled(false);
		} else {
			// btncalc.setEnabled(false);
			btnrvow.setEnabled(true);
			btnrcon.setEnabled(true);
		}

		if ((e.getSource() == btnrcon) && (letters_entered < 9)) {
			clear.setText("Clear");
			script.setBackground(Color.gray);
			script.setFont(h);
			script.setText("");
			char temp = Words.randomConsonant();
			lblChar[letters_entered].setText(Character.toUpperCase(temp) + "");
			Words.setLetters(temp);
			letters_entered++;
			Words.showLetters();
		}

		if ((e.getSource() == btnrvow) && (letters_entered < 9)) {
			clear.setText("Clear");
			script.setBackground(Color.gray);
			script.setFont(j);
			script.setText("");
			char temp = Words.randomVowel();
			lblChar[letters_entered].setText(Character.toUpperCase(temp) + "");
			Words.setLetters(temp);
			letters_entered++;			
			Words.showLetters();
		}

		if (e.getSource() == btncalc) {
			script.setText("");
			Words.swords.clear();
			Words.easyWordSearch();
			CountdownProgram.playMusic = false;
			Noise.stop();
			final Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					Noise.playSound("src/countdown/Countdown-end.wav");
					timer.cancel();
				}
			}, 0);
		}

		if (e.getSource() == MHelp) {
			clear.setText("Clear");
			script.setBackground(Color.green);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("HELP"
					+ "\n"
					+ "Enter letters into the top panel or press the "
					+ "\n"
					+ "buttons on the top right, 'C' for a random consonant or 'V' for a random vowel."
					+ "\n"
					+ "Once nine letters have been chosen, the 'Find Words button can be pressed to"
					+ "\n"
					+ "calculate the best words that can be created.  To clear your selection of letters"
					+ "\n" + "press the 'Clear' button.");
		}

		if (e.getSource() == MInfo) {
			clear.setText("Clear");
			script.setBackground(Color.yellow);
			script.setForeground(Color.black);
			script.setFont(l);
			script.setText("INFO"
					+ "\n"
					+ "'Countdown Solver' is a product of CHEW Enterprises.  "
					+ "\n"
					+ // CHEW enterprises for
					"The purpose of this product is to provide the user with a tool for "
					+ "\n"
					+ // (cheap example)
					"accurately solving the numbers round of the popular UK television "
					+ "\n"
					+ // Computing & Electronics
					"show 'Countdown'.  For other products by this maker please visit the "
					+ "\n"
					+ // Heriot Watt
					"website at www.CountDownSolver.com.  To contact the maker of "
					+ "\n"
					+ "this product please email  AndrewJRigg@googlemail.com.  Thank "
					+ "\n" + "you for using this product.");
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
				this.dispose();
			} else if (clear.getText().equals("Clear")) {
				if (CountdownProgram.playMusic){
				CountdownProgram.playMusic = false;
				Noise.stop();
				CountdownProgram.playMusic();
				}
				script.setBackground(Color.gray);
				script.setFont(j);
				script.setText("");
				for (int i = 0; i < 9; i++) {
					Words.clearLetters();
					lblChar[i].setText("");
					letters_entered = 0;
					clear.setText("Back");
					
				}
			}
		}
		
		if (e.getSource() == MExit) {
			System.exit(0);
			}
		
		if(e.getSource() == MExample){
			Random rand = new Random();
			clear.setText("Clear");
			int vowels = 3 + rand.nextInt(3);
			ArrayList<Integer> places = new ArrayList<Integer>();
			
			while(places.size() != vowels){
				int r =(rand.nextInt(10));
				if(!(places.contains(r))){
					places.add(r);
				}
			}
			
			
			
			for (int i = 0;i < 9;i++){
				lblChar[i].setText("");
			}
			Words.clearLetters();
			char temp;
			for(int j = 0;j<9;j++){
				if(places.contains(j)){
					temp = Words.randomVowel();
				}else{
					temp = Words.randomConsonant();
				}
				lblChar[j].setText(Character.toUpperCase(temp) + "");
				
				Words.setLetters(temp);
				//letters_entered++;
				Words.showLetters();
			}
			btncalc.setText("Find Words");
			System.out.println(vowels);
		}
		}


	public void keyPressed(KeyEvent k) {
		int location = k.getKeyCode();

		if (location == 8 && letters_entered > 0 && letters_entered < 10) {
			letters_entered--;
			lblChar[letters_entered].setText("");
			Words.removeLetter(letters_entered);
			// btncalc.setEnabled(false);
			btnrvow.setEnabled(true);
			btnrcon.setEnabled(true);
		}
		System.out.println(location + "letters:" + letters_entered);
	}

	public void keyTyped(KeyEvent k) {
		if (letters_entered >= 8) {
			// btncalc.setEnabled(true);
			btnrvow.setEnabled(false);
			btnrcon.setEnabled(false);
		} else {
			// btncalc.setEnabled(false);
			btncalc.setText("Find Words");
			btnrvow.setEnabled(true);
			btnrcon.setEnabled(true);
		}
		if (letters_entered != 9) {
			clear.setText("Clear");
			l_c = Words.getConsonants();
			l_v = Words.getVowels();
			char c = k.getKeyChar();
			for (int i = 0; i < 21; i++) {
				if (c == l_c.get(i)) {
					lblChar[letters_entered].setText(Character.toUpperCase(l_c
							.get(i)) + "");
					Words.addLetter(l_c.get(i));
					letters_entered++;
				}
			}

			for (int j = 0; j < 5; j++) {
				if (c == l_v.get(j)) {
					lblChar[letters_entered].setText(Character.toUpperCase(l_v
							.get(j)) + "");
					Words.addLetter(l_v.get(j));
					letters_entered++;
				}
			}
		}
		Words.showLetters();
	}

	public static void addSolution(String solution) {
		try {
			script.append(solution + "\n");
		} catch (NullPointerException e) {
			System.err.println("GUI is not running, cannot add to solutions list.");
		}
	}

	static void printSolutions() {

		
		ArrayList<String> solutions = Words.findBestWords(9);
		if(solutions.size() != 0){
		script.append("Best words:\n");
		for(int i = 0;i <=9;i++){
			try{
			script.append(i+1 + ". "+solutions.get(i)+"\n");
			}catch(IndexOutOfBoundsException e){
				
				System.err.println(e);
			}
		}
		System.out.println(solutions);
		}else{
			script.append("No Solutions");
		}
	}

	public static void main(String[] args) {
		// WordsGUI w = new WordsGUI();
		// w.setSize(1000, 450);
		// w.setTitle("Countdown Words");
		// w.setVisible(true);
		// w.addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });
		// System.out.println(Words.getDictionaryWord(2121));
	}

	public void keyReleased(KeyEvent e) {

	}
}
