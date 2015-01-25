import java.awt.*;
import java.awt.event.*;
//import java.util.*;
//import java.util.Timer;

import javax.swing.*;

class ConundrumGUI extends JFrame implements ActionListener, KeyListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel topRow,bottomRow,middleRow;
	
	JMenuBar jb;
	JMenu file;
	JMenuItem MHelp, MInfo, MExit, MSound;
	JButton  btnClear,btnGo;
	JLabel[] lblChar = new JLabel[9];
	JLabel[] lblChar2 = new JLabel[9];
//	JButton btnGo;
	//JScrollPane scrresults;
	//int letters_entered = 0;
	static JTextField txtShuffled,txtSolution;
	Font l = new Font("University Roman", Font.PLAIN, 14);
	Font g = new Font("Industria", Font.PLAIN, 96);
	static Font h = new Font("Industria", Font.ITALIC, 50);
	static Font i = new Font("Industria", Font.PLAIN, 96);
	static Font j = new Font("Comic Sans", Font.PLAIN, 36);
	static Font k = new Font("Times New Roman", Font.PLAIN, 56);
	String a,b;
	public ConundrumGUI() {
		
		//setSize();
		setLayout(new GridLayout(3, 1));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//Conundrum cn = new Conundrum();
		
		topRow = new JPanel(new GridLayout(1,1));
		topRow.setBackground(Color.lightGray);
		bottomRow = new JPanel(new GridLayout(1,1));
		bottomRow.setBackground(Color.gray);
		middleRow = new JPanel(new GridLayout(1,2));
				
		jb = new JMenuBar();
		file = new JMenu("File");
		
		
		btnClear = new JButton("Back");
		btnClear.setBorder(new RoundedBorder(20));
		btnClear.setForeground(Color.blue);
		btnClear.setFont(h);
		btnClear.addActionListener(this);
		
		
		btnGo = new JButton("Start");
		btnGo.setBorder(new RoundedBorder(20));
		btnGo.setForeground(Color.blue);		
		btnGo.setFont(h);		
		btnGo.addActionListener(this);
		
		//System.out.println("Shuffled Word: " + Conundrum.getShuffledWord());
		txtShuffled = new JTextField();
		txtShuffled.setBackground(Color.lightGray);
		txtShuffled.setHorizontalAlignment(JTextField.CENTER);
		txtShuffled.setFont(i);
		
		txtSolution = new JTextField();
		txtSolution.setBackground(Color.gray);
		txtSolution.setHorizontalAlignment(JTextField.CENTER);
		txtSolution.setFont(i);
		
		
		for (int i = 0; i < 9; i++) {
			lblChar[i] = new JLabel("");
			lblChar[i].setFont(g);
			lblChar[i].setBackground(Color.lightGray);
			lblChar[i].setHorizontalAlignment(SwingConstants.CENTER);
			topRow.add(lblChar[i]);
		}
		
		for (int i = 0; i < 9; i++) {
			lblChar2[i] = new JLabel("");
			lblChar2[i].setFont(g);
			lblChar2[i].setBackground(Color.gray);
			lblChar2[i].setHorizontalAlignment(SwingConstants.CENTER);
			bottomRow.add(lblChar2[i]);
		}
		
		add(topRow);
		
		add(middleRow);
		add(bottomRow);
		
		
		
		
		//topRow.add(txtShuffled);
		//bottomRow.add(txtSolution);
		middleRow.add(btnClear);
		middleRow.add(btnGo);
		
		
		
		
		
		
		
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

	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == MHelp) {
			txtSolution.setBackground(Color.green);
			txtSolution.setForeground(Color.black);
			txtSolution.setFont(l);
			txtSolution.setText("HELP"
					+ "\n"
					+ "Press the 'Start' to generate a random nine letter conundrum."
					+ "\n"
					+ "Once you have solved it, press the 'Reveal' button to reveal the answer."
					+ "\n"
					+ "If you were correct, give it another shot!"
					+ "\n"
					+ "Press the clear button to start again, and then the 'Back' button to exit"
					+ "\n"
					+ "the conundrum round.");
		}

		if (e.getSource() == MInfo) {
			txtSolution.setBackground(Color.yellow);
			txtSolution.setForeground(Color.black);
			txtSolution.setFont(l);
			txtSolution.setText("INFO"
					+ "\n"
					+ "'Countdown Solver' is a product of Daman Inc.  "
					+ "\n"
					+ "â€œUnconcerned, Unawareâ€�" +
					"\n" +
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

		if (e.getSource() == MSound){
			if (CountdownProgram.playMusic){
				CountdownProgram.playMusic = false;
				Noise.stop();
			}
			else if (!CountdownProgram.playMusic){
				CountdownProgram.playMusic();
				CountdownProgram.playMusic = true;
			}
		}
		

		if (e.getSource() == MExit) {
			System.exit(0);
		}
		
		if (e.getSource() == btnClear){
			if(btnClear.getText().equals("Back")){
				CountdownProgram prog = new CountdownProgram();
				prog.setTitle("Countdown");
				prog.setVisible(true);
				prog.setSize(1000, 450);
				prog.getMessage();
				prog.script.setBackground(Color.gray);
				prog.script.setText("");
				this.dispose();
			}
			
			else if(btnClear.getText().equals("Clear")){
//				txtShuffled.setText("");
//				txtSolution.setText("");
				for (int i = 0 ; i < 9; i ++){
					lblChar[i].setText("");
					lblChar2[i].setText("");
				}
				btnGo.setText("Start");
			}
			if (CountdownProgram.playMusic){
			CountdownProgram.playMusic = false;
			Noise.stop();
			CountdownProgram.playMusic();
			}
			btnClear.setText("Back");
		}
		
		if (e.getSource() == btnGo){
			if (btnGo.getText().equals("Start")){
			
//			Conundrum c = new Conundrum();
			a = Conundrum.getTargetWord();
			b = Conundrum.getShuffledWord();
			//txtSolution.setText(a);
			for (int i = 0 ; i < 9; i ++){
				lblChar[i].setText(b.substring(i, i+1).toUpperCase());
			}
			//txtShuffled.setText(b.toUpperCase());
			btnGo.setText("Reveal");
			}
			
			else if(btnGo.getText().equals("Reveal")){
				System.out.println("Asjadhsa");
				//txtSolution.setText(a.toUpperCase());
				for (int i = 0 ; i < 9; i ++){
					lblChar2[i].setText(a.substring(i, i+1).toUpperCase());
				}
				btnClear.setText("Clear");
			}
		}
		
//		else if (e.getSource() == btnGo && btnGo.getText().equals("Reveal")){
//			
//				//txtSolution.setText(a);
//				System.out.println("asasas");
//			
//		}
			}
		
	}

		
