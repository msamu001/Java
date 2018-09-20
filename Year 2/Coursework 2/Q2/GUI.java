import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	private int guessNum, codeSize, turnCount;
	private CodeBreaker_AI ai;
	private Color[] colours;
	private JPanel topPanel;
	private JPanel numPanel;
	private JPanel keyPanel;
	private JPanel guessPanel;
	private JPanel bottomPanel;
	private JButton[] viewColours;
	private JButton[][] guessPegs;
	private JButton[][] keyPegs;
	private JButton next;
	private boolean userPlays;
	private boolean smartAI;
	private boolean gameOver;

	public GUI(int gn, int cs){
		gameMode();
		ai = new CodeBreaker_AI(); // Initialise AI
		guessNum = gn;
		codeSize = cs;
		turnCount = 0; 
		colours = new Color[]{Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.pink}; // Adds 6 the colours for the game to an array
		panelSetup();
		buttonSetup();
		windowSetup();
		setVisible(true);
	}
	
	private void gameMode(){ // Allow user to choose what game mode to play
		Object[] options = {"Codebreaker", "AI Naive", "AI Smart"}; // Changes the option names
		int dialog = JOptionPane.showOptionDialog(null, // Dialog box to allow user to select an option
			"Please select a game mode",
			"Mastermind",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.PLAIN_MESSAGE,
    		null,
    		options,
    		options[2]);
		
		if(dialog == JOptionPane.YES_OPTION){ // Allow user to play the game
			userPlays = true;
		}
		if(dialog == JOptionPane.NO_OPTION){ // Naive AI plays mastermind
			smartAI = false;
		}
		if(dialog == JOptionPane.CANCEL_OPTION){ // Smart AI plays mastermind
			smartAI = true;
		}
	}

	private void restartGame(){
		int dialog = JOptionPane.showConfirmDialog(null,
			"Would you like to play again?",
			"Play again",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);

		if(dialog == JOptionPane.YES_OPTION){ // Restarts the games by closing the window and reopening the GUI
			dispose();
			GUI gui = new GUI(10,4);
		}
		if(dialog == JOptionPane.NO_OPTION){ // Closes the window
			dispose();
		}
	}
	
	private void panelSetup(){
		topPanel = new JPanel();											// Initializes panel
		topPanel.setLayout(new FlowLayout());								// Organizes the button layout
		topPanel.setBorder(BorderFactory.createEmptyBorder(20,28,0,12));	// Adds a border for spacing, moved right slightly to make the design look flushed
		topPanel.setVisible(true);											// Allows user to see panel
		
		numPanel = new JPanel();											// Initializes panel
		numPanel.setLayout(new GridLayout(guessNum,1,0,10)); 				// Organizes the button layout and location
		numPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,0));	// Adds a border for spacing
		numPanel.setVisible(true);											// Allows user to see panel

		keyPanel = new JPanel();											// Initializes panel
		keyPanel.setLayout(new GridLayout(guessNum,codeSize,0,10));			// Organizes how the buttons will be layed out
		keyPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,40));	// Adds a border for spacing
		keyPanel.setPreferredSize(new Dimension(160, 400));					// Keeps size of buttons when screen is original size 
		keyPanel.setVisible(true);											// Allows user to see panel

		guessPanel = new JPanel();											// Initializes panel
		guessPanel.setLayout(new GridLayout(guessNum,codeSize, 0, 10));		// Organizes how the buttons will be layed out
		guessPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); // Adds a border for spacing
		guessPanel.setVisible(true);										// Allows user to see panel

		bottomPanel = new JPanel();											// Initializes panel
		bottomPanel.setLayout(new FlowLayout());							// Organizes how the buttons will be layed out
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,20,15,20)); // Adds a border for spacing
		bottomPanel.setVisible(true);										// Allows user to see panel
	}

	private void buttonSetup(){
		// Initialize buttons
		viewColours = new JButton[6];
		guessPegs = new JButton[guessNum][codeSize];
		keyPegs = new JButton[guessNum][codeSize];
		next = new JButton("Start");
		
		next.addActionListener(this); // Changes button from start to next
		bottomPanel.add(next); // Adds button to the bottom of the window
		
		for(int i = 0; i < 6; i++){ // Sets background of buttons to the corresponding colours
			viewColours[i] = new JButton();
			viewColours[i].setBackground(colours[i]);
			viewColours[i].setEnabled(false); // These buttons are only to show the user what colours they can select
			topPanel.add(viewColours[i]);
		}
		for(int i = 0; i < guessNum; i++){
			numPanel.add(new JLabel(String.valueOf(i+1),JLabel.CENTER)); // Adds numbers downs the left side of the window
			for(int j = 0; j < codeSize; j++){
				guessPegs[i][j] = new JButton();
				if(userPlays){
					guessPegs[i][j].addActionListener(new guessColour()); // Allows user to change the colours to guess the code
					if(i > 0){
						guessPegs[i][j].setEnabled(false);
					} else {
						guessPegs[i][j].setBackground(colours[0]);
					}
				}
				guessPanel.add(guessPegs[i][j]);

				keyPegs[i][j] = new JButton();
				if(!userPlays){
					keyPegs[i][j].addActionListener(new keyColour()); // Allows user to change button and interact with the AI
				}
				keyPegs[i][j].setEnabled(false); // Stops user from inputing response before the correct time
				keyPanel.add(keyPegs[i][j]);
			}
		}
	}
	
	private void windowSetup(){
		setLayout(new BorderLayout());
		setTitle("Mastermind"); 					// Name of window
		setDefaultCloseOperation(3); 				// Exit, Minimize, Maximise
		setMinimumSize(new Dimension(350, 500)); 	// Smallest size of window
		add(topPanel, "North"); 					// Adds colour bar to the top of the window
		add(numPanel, "West");						// Adds number labels to the left of the window
		add(guessPanel, "Center");					// Adds the guess panels
		add(keyPanel, "East");						// Adds the key to give responcesB
		add(bottomPanel, "South");
	}

	private class guessColour implements ActionListener{
		public int colourChk;

		private guessColour(){
			colourChk = 0;
		}

		public void actionPerformed(ActionEvent e){
			colourChk = (colourChk+1) % 6; // Increments each time it is clicked. Cycles through 6 colours
			((JButton)(e.getSource())).setBackground(colours[colourChk]); // Sets background colour when clicked			
		}
	}
	
	private class keyColour implements ActionListener{ // Adds functionality to the keyPegs. e.g. change peg from black to white
		public int colourChk;
		
		private keyColour(){
			colourChk = 0;
		}
		
		public void actionPerformed(ActionEvent e){
			colourChk = (colourChk+1) % 3; // Increments each time it is clicked. Cycles through 3 colours
			((JButton)(e.getSource())).setBackground(colourSlct(colourChk)); // Sets background colour when clicked			
		}
		
		private Color colourSlct(int i){ // Changes colour depending on input
			if(i==0){
				return Color.lightGray;
			}
			if(i==1){
				return Color.black;
			}
			else{
				return Color.white;
			}
		}
	}	

	public void actionPerformed(ActionEvent e){ // Adds functionality to the next button and progresses game
		if(turnCount == 10 && !userPlays){
			gameOver = true;
		}
		if(gameOver){ // Restarts game
			restartGame();
		}
		if(turnCount == 0){ // Changes the button from start to next
			next.setText("Next");
		}
		if(userPlays){ // Allow the user to play the game and gives back responces from the random code
			int[] userGuess = new int[codeSize];
			for(int j = 0; j < codeSize; j++) {
				guessPegs[turnCount][j].setEnabled(false); // Stops user from changing previos codes
				if(turnCount < 9){ // The next code can now be selected by the user
					guessPegs[turnCount+1][j].setBackground(colours[0]);
					guessPegs[turnCount+1][j].setEnabled(true);
				}
				for(int i = 0; i < colours.length; i++) { // Checks what colours the user selected
					if(guessPegs[turnCount][j].getBackground().equals(colours[i])){
						userGuess[j] = i;
					}
				}
			}
			int[] response = ai.calcResponce(userGuess); // Calculates how many blacks and white the user got
			for(int i = 0; i < response[0]; i++){ // Adds the blacks to the GUI
				keyPegs[turnCount][i].setBackground(Color.black);
			}
			for(int i = 0; i < response[1]; i++){ // Adds the white to the GUI
				keyPegs[turnCount][i].setBackground(Color.white);
			}
			if(response[0] == 4){ // Ends the game if the user wins
				JOptionPane.showConfirmDialog(null,
				"You Win",
				"Mastermind",
				JOptionPane.YES_OPTION,
				JOptionPane.PLAIN_MESSAGE);
				restartGame(); // Restarts the game
			}
			if(turnCount == 9){ // Ends the game if the user loses
				JOptionPane.showConfirmDialog(null,
				"You Lose",
				"Mastermind",
				JOptionPane.YES_OPTION,
				JOptionPane.PLAIN_MESSAGE);
				restartGame(); // Restarts the game
			}
		} else {
			int blackKey = 0;
			int whiteKey = 0;
			for(int j = 0; j < codeSize; j++){ // Interacts with the AI and changes the guess buttons accordingly
				int[] guess = ai.calcGuess(turnCount, smartAI);
				guessPegs[turnCount][j].setBackground(colours[guess[j]]);	// Shows the first guess of the AI
				keyPegs[turnCount][j].setBackground(Color.lightGray);		// Let the user know the buttons are ready
				keyPegs[turnCount][j].setEnabled(true);						// Activates button functionality
				
				if(turnCount > 0){ // Gets results from the user's input
					if(keyPegs[turnCount-1][j].getBackground().equals(Color.black)){ 
						blackKey++;
					}
					if(keyPegs[turnCount-1][j].getBackground().equals(Color.white)){
						whiteKey++;
					}
					keyPegs[turnCount-1][j].setEnabled(false); // Stops user from changing previous keys
					ai.addKey(blackKey,whiteKey); //Gives the AI information to computer the next guess
				}
			}
		}
		turnCount++;
	}
}