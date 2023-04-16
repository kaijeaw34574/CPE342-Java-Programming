/* Main.java
 * 
 *  Sets up the basic framework for the Ball Bounce application
 *  creating a window and adding a panel to it where the bouncing balls will be animated
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import javax.swing.JFrame;  // Create and customize its properties for a window the application

public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Bounce");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Create an instance of the BallPanel class which contains the logic for animating the bouncing balls
        BallPanel panel = new BallPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
