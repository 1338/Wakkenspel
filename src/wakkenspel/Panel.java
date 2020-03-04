package wakkenspel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * JPanel class
 * @version 0.0.1
 * @author Max van der Sluis
 */
public class Panel extends JPanel {
    /**
     * Long version numbering
     * @author      Max van der Sluis
     * @since       0.0.1
     * @see			java.io.Serializable
	 */
	public static final long serialVersionUID = 1L;
	
	/**
	 * Map of buttons
	 * @since 1L
	 * @author Max van der Sluis
	 * @see HashMap
	 * @see JButton
	 */
	Map<String, JButton> Buttons = new HashMap<>();
	/**
	 * Map of Labels
	 * @since 0.0.1
	 * @author Max van der Sluis
	 * @see HashMap
	 * @see JLabel
	 */
	Map<String, JLabel> Labels = new HashMap<>();
	/**
	 * Map of Textfields
	 * @since 0.0.1
	 * @author Max van der Sluis
	 * @see HashMap
	 * @see JTextField
	 */
	Map<String, JTextField> TextFields = new HashMap<>();
	/**
	 * Array of dice
	 * @since 0.0.1
	 * @author Max van der Sluis
	 * @see Dice
	 */
	Dice[] Dices = new Dice[12];
	/**
	 * X amount of dice to roll
	 * @since 0.0.1
	 * @author Max van der Sluis
	 */
	public int rollInt;
	
	/**
	 * Creates an button the lazy way
	 * @param text text
	 * @param x x coord
	 * @param y y coord
	 * @param w width
	 * @param h height
	 * @return JButton
	 * @see javax.swing.JButton
	 * @since 0.0.1
	 * @author Max van der Sluis
	 */
    public JButton LazyButton(String text, int x, int y, int w, int h) {
		JButton temp = new JButton(text);
		temp.setBounds(x, y, w, h);
		temp.addActionListener(new buttonHandler());
		return temp;
	}
	/**
	 * Creates an label the lazy way
	 * @param text text
	 * @param x x coord
	 * @param y y coord
	 * @param w width
	 * @param h height
	 * @return JLabel
	 * @see javax.swing.JLabel
	 * @since 0.0.1
	 * @author Max van der Sluis
	 */
	public JLabel LazyLabel(String text, int x, int y, int w, int h) {
		JLabel temp = new JLabel(text);
		temp.setBounds(x, y, w, h);
		return temp;
	}
	
	/**
	 * Creates an JTextField the lazy way
	 * @param text text
	 * @param x x coord
	 * @param y y coord
	 * @param w width
	 * @param h height
	 * @return JTextField
	 * @see javax.swing.JTextField
	 * @since 0.0.1
	 * @author Max van der Sluis
	 */
	public JTextField LazyTextField(String text, int x, int y, int w, int h) {
		JTextField temp = new JTextField(text);
		temp.setBounds(x, y, w, h);
		return temp;
	}
	/**
	 * Lazy add all
	 * @author Max van der Sluis
	 * @since 0.0.1
	 */
    public void addAll() {
    	for(String key: Buttons.keySet()) {
    		add(Buttons.get(key));
    	}
    	for(String key: Labels.keySet()) {
    		add(Labels.get(key));
    	}
    	for(String key: TextFields.keySet()) {
    		add(TextFields.get(key));
    	}
    }
    /**
     * The panel
     * @author Max van der Sluis
     * @since 0.0.1
     * @see javax.swing.JPanel
     */
    public Panel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        
        //Create JButtons
        Buttons.put("roll", LazyButton("Roll Dice", 255,290, 100, 25));
        Buttons.put("guess", LazyButton("Guess", 255, 370, 100, 25));
        Buttons.put("reset", LazyButton("Reset", 255, 410, 100, 25));
        Buttons.put("solve", LazyButton("Solve", 255, 450, 100, 25));
        Buttons.put("help", LazyButton("Help", 50, 534, 100, 25));
        
        //Create textFields
        TextFields.put("amount", LazyTextField("", 215,290,30,30));
        TextFields.put("ping", LazyTextField("", 215,370,30,30));
        TextFields.put("bear", LazyTextField("", 215,410,30,30));
        TextFields.put("hole", LazyTextField("", 215,450,30,30));
        TextFields.put("guesses", LazyTextField("0", 555,370,30,30));
        TextFields.put("guessesRight", LazyTextField("0", 555,410,30,30));
        TextFields.put("guessesWrong", LazyTextField("0", 555,450,30,30));
        
        //Create JLabels
        Labels.put("amount", LazyLabel("Amount of dice.", 20, 290, 100, 25));
        Labels.put("guessPing", LazyLabel("Guess the amount of pinguins.", 20, 370, 200, 25));
        Labels.put("guessPolar", LazyLabel("Guess the amount of polarbears", 20, 410, 200, 25));
        Labels.put("guessHole", LazyLabel("Guess the amount of holes", 20, 450, 200, 25));
        Labels.put("guesses", LazyLabel("number of guesses.", 400, 370, 200, 25));
        Labels.put("guessesRight", LazyLabel("Correct guesses.", 400, 410, 200, 25));
        Labels.put("guessesWrong", LazyLabel("Wrong guesses.", 400, 450, 200, 25));
        Labels.put("madeBy", LazyLabel("Made by Max van der Sluis", 200, 534, 200, 25));
        
        //adding 12 dice
        for(int i = 0; i < 12; i++) {
        	Dices[i] = new Dice();
        	add(Dices[i]);
        }
        // Adding elements to Panel
        addAll();
        
        TextFields.get("guesses").setEditable(false);
        TextFields.get("guessesRight").setEditable(false);
        TextFields.get("guessesWrong").setEditable(false);
        Buttons.get("guess").setEnabled(false);
        Buttons.get("solve").setEnabled(false);
        Buttons.get("reset").setEnabled(false);
        

    }
    /**
     * Do x amount of rolls
     * @author Max van der Sluis
     * @since 0.0.1
     * @param rollInt rollInt
     */
    public void roll(int rollInt){
    	this.rollInt = rollInt;
        //enabling Buttons guess, solve & reset.
        //disabling roll
        //disable editing amount input field.
    	Buttons.get("guess").setEnabled(true);
        Buttons.get("solve").setEnabled(true);
        Buttons.get("reset").setEnabled(true);
        Buttons.get("roll").setEnabled(false);
        TextFields.get("amount").setEditable(false);
        for(int i = 0; i < this.rollInt; i++) {
        	Dices[i].rollDice();
        }
        repaint();
    }
    /**
     * buttonHanlder
     * @author rootshell
     * @since 0.0.2
     */
    class buttonHandler implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		switch(e.getActionCommand()) {
    		case "Roll Dice":
    			String amountString = TextFields.get("amount").getText();
    			TextFields.get("amount").setEditable(false);
    			TextFields.get("ping").setEditable(true);
    			TextFields.get("ping").setText("");
    			TextFields.get("bear").setEditable(true);
    			TextFields.get("bear").setText("");
    			TextFields.get("hole").setEditable(true);
    			TextFields.get("hole").setText("");
    			try {
    				rollInt = Integer.parseInt(amountString);
    				if(rollInt < 3 || rollInt > 12) {
    					JOptionPane.showMessageDialog(null, "Please enter a number from 3 to 12");
    				}else {
    					roll(rollInt);
    				}
    			}catch(NumberFormatException ex) {
    				TextFields.get("amount").setText("");
                    JOptionPane.showMessageDialog(null, "Please enter a number from 3 to 12");
    			}
    		break;
    		case "Reset":
    			reset();
    		break;
    		case "Help":
    			JOptionPane.showMessageDialog(null, "Press guess to check if your answer is correct.");
                JOptionPane.showMessageDialog(null,"Press solve to automatically solve the game (this gets you 5 wrong guesses.");
                JOptionPane.showMessageDialog(null,"Press reset to empty the playing field.");
                JOptionPane.showMessageDialog(null,"A dot in the middle means that there's a hole there.");
                JOptionPane.showMessageDialog(null,"Polar bears like to go near holes.");
                JOptionPane.showMessageDialog(null,"Pinguings dont like to go near Polar bears");
            break;
    		case "Guess":
    			TextFields.get("guesses").setText(Integer.toString(Integer.parseInt(TextFields.get("guesses").getText()) + 1));
    			int[] values = getValues();
    			int count = 0;
    			if(values[0] == Integer.parseInt(TextFields.get("hole").getText())) {
    				count += 1;
    			}
    			if(values[1] == Integer.parseInt(TextFields.get("bear").getText())) {
    				count += 1;
    			}
    			if(values[2] == Integer.parseInt(TextFields.get("ping").getText())) {
    				count += 1;
    			}
    			if(count != 3) {
    				TextFields.get("guessesWrong").setText(Integer.toString(Integer.parseInt(TextFields.get("guessesWrong").getText())+1));
    			} else {
    				TextFields.get("guessesRight").setText(Integer.toString(Integer.parseInt(TextFields.get("guessesRight").getText())+1));
    			}
    		break;
    		case "Solve":
    			int solve = JOptionPane.showConfirmDialog(null,"Do you want to solve this game? WARNING pressing yes will get you 5 wrong guesses.","Solution",JOptionPane.YES_NO_OPTION);
    			if(solve == 0) {
    				TextFields.get("guessesWrong").setText(Integer.toString(Integer.parseInt(TextFields.get("guessesWrong").getText())+5));
    				int[] solveValues = getValues();
    				TextFields.get("hole").setText(Integer.toString(solveValues[0]));
    				TextFields.get("bear").setText(Integer.toString(solveValues[1]));
    				TextFields.get("ping").setText(Integer.toString(solveValues[2]));
    			}
    			break;
    		}
    	}
    }
    /**
     * Gets counts all values and returns them
     * @author rootshell
     * @since 0.0.2
     * @return int[]
     */
    public int[] getValues() {
    	int[] values = new int[3];
    	for(int i = 0; i < rollInt; i++) {
    		values[0] += Dices[i].getHoles();
    		values[1] += Dices[i].getBears();
    		values[2] += Dices[i].getPinguins();
    	}
    	return values;
    }
    /**
     * Resets all needed values and Dice
     * @author rootshell
     * @since 0.0.2
     */
    public void reset() {
    	for(int i = 0; i < Dices.length; i++) {
			Dices[i].reset();
		}
		Buttons.get("guess").setEnabled(false);
		Buttons.get("solve").setEnabled(false);
		Buttons.get("reset").setEnabled(false);
		Buttons.get("roll").setEnabled(true);
		TextFields.get("amount").setEditable(true);
		TextFields.get("amount").setText("");
		TextFields.get("ping").setEditable(false);
		TextFields.get("ping").setText("");
		TextFields.get("bear").setEditable(false);
		TextFields.get("bear").setText("");
		TextFields.get("hole").setEditable(false);
		TextFields.get("hole").setText("");
		repaint();
    }
    /**
     * paint the panel/game
     * @author Max van der Sluis
     * @since 0.0.1
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(0, 275, 800, 450);

        g.setColor(Color.CYAN);
        g.fillRect(0, 530, 800, 35);

        g.setColor(new Color(44,47,51));
        g.setFont(new Font("SansSerif", Font.BOLD, 25));
        g.drawString("Het Wakkenspel", 300, 30);
        int tempX = 115;
        int tempY = 70;
        //Paint the dice
        for(int i = 0; i < rollInt; i++) {
            if(i == 6) { // rollInt starts from 1 and i starts from 0, resets X
        		tempX = 115;
        		tempY = 150;
            }
        	Dices[i].drawDice(g, tempX, tempY);
            tempX += 100;
        }
    }
}