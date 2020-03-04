package wakkenspel;

import javax.swing.*;
import java.awt.*;

/**
 * Dice class
 * @author Max van der Sluis
 * @since 0.0.1
 */
public class Dice extends JPanel {
	/**
     * Long version numbering
     * @author      Max van der Sluis
     * @since       0.0.1
     * @see			java.io.Serializable
	 */
	public static final long serialVersionUID = 1L;
	/**
	 * How many dots on the Dice
	 * @since 0.0.1
	 * @author Max van der Sluis
	 * @see Dice
	 */
	public int side;
	public int[] diceResult = new int[3];

    /**
     * Draws dice
     * @param g Graphics
     * @param x coord
     * @param y coord
     * @author Max van der Sluis
     * @since 0.0.1
     */
    public void drawDice(Graphics g, int x, int y) {
        //paint dice background
        if (this.side >=1) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(x, y, 70, 70, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, 70, 70, 25, 25);
            if(this.side == 1 || this.side == 3 || this.side == 5) {
            	g.fillOval((x+30), (y+30), 10, 10);
            }
            if(this.side > 1 ) {
            	g.fillOval((x+15), (y+15), 10, 10);
                g.fillOval((x+45), (y+45), 10, 10);
            }
            if(this.side > 3) {
                g.fillOval((x+15), (y+45), 10, 10);
                g.fillOval((x+45), (y+15), 10, 10);
            }
            if(this.side == 6) {
                g.fillOval((x+15), (y+30), 10, 10);
                g.fillOval((x+45), (y+30), 10, 10);
            }
        }
    }
    /**
     * Roll the dice (the +1 is because int starts from 0
     * @since 0.0.1
     * @author Max van der Sluis
     * @see java.lang.Math
     */
    public void rollDice() {
        this.side = (int) (6 * Math.random() + 1);
    	//Holes
    	if(side == 1 || side == 3 || side == 5) {
    		this.diceResult[0] = 1;
    	}else {
    		this.diceResult[0] = 0;
    	}
    	//Bears
    	if(side == 3) {
    		diceResult[1] = 2;
    	} else if(side == 5) {
    		diceResult[1] = 4;
    	} else {
    		diceResult[1] = 0;
    	}
    	//pinguins
        if (side == 2) {
            diceResult[2] = 2;
        } else if (side == 4) {
        	diceResult[2] = 4;
        } else if (side == 6) {
        	diceResult[2] = 6;
        } else {
        	diceResult[2] = 0;
        }
    }

    /**
     * Return the results for current dice roll
     * @return Array of int[holes, bears, penguins]
     */
    public int getHoles() {
    	return diceResult[0];
    }
    public int getBears() {
    	return diceResult[1];
    }
    public int getPinguins() {
    	return diceResult[2];
    }

    public void reset() {
    	this.side = 0;
    }

}