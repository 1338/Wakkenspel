package wakkenspel;

import javax.swing.*;

/**
 * Startup method
 * @author Max van der Sluis
 * @since 0.0.1
 * @see javax.swing.JFrame
 */
public class StartUp extends JFrame {

	/**
	 * Current version
	 * @author Max van der Sluis
	 * @since 0.0.1
	 */
	public static final String version = "0.0.2";
    /**
     * @author      Max van der Sluis
     * @since       0.0.1
     * @see			java.io.Serializable
	 */
	public static final long serialVersionUID = 1L;

	/**
	 * Main method
	 * @param args []String
	 * @author Max van der Sluis
	 * @since 0.0.1
	 */
	public static void main(String args[]){
        JFrame frame = new StartUp();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wakkenspel | Versie " + version);
        JPanel panel = new Panel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

}