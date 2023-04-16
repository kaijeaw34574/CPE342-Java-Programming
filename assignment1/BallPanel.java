/* BallPanel.java
 * 
 *  This code defines and extends the JPanel class
 *  to creates a graphical interface that displays the balls and allows the user to interact with them
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import javax.swing.JPanel;          // Hold and organize other GUI components 
import java.util.ArrayList;         // The class implements a dynamic array
import java.awt.event.MouseAdapter; // Provides information about the mouse event
import java.awt.event.MouseEvent;   
import java.awt.Color;              // Represent colors in the RGB color space
import java.awt.Graphics;           // Drawing on a graphical user interface (GUI)

public class BallPanel extends JPanel {
    
    // Used to store all the balls that are created
    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public BallPanel() {
        // Set up a mouse listener to handle clicks
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Left click creates a new ball at the mouse position with a random speed and color
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Mouse click event to set the x and y coordinate of the new ball's position
                    // Random between -5 and 4 to set the change in x and y coordinate of the new ball's position
                    // Random generated RGB values to set the color of the new ball
                    Ball ball = new Ball(e.getX(), e.getY(), (int) (Math.random() * 10) - 5, (int) (Math.random() * 10) - 5, 
                                new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
                    balls.add(ball);
                } 
                // Right click removes the oldest ball from the frame
                else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (balls.size() > 0) {
                        balls.remove(0);
                    }
                }
            }
        });

        // The ball positions will be updated and the panel will be repainted approximately 30 times per second
        new javax.swing.Timer(30, (e) -> {
            // Loops iterate over each ball in a collection of balls and move each one
            for (Ball ball : balls) {
                ball.move();
                // Checks if the ball collides with any of the walls of the panel
                // If a collision occurs, the ball's direction is reversed to simulate bouncing
                if (ball.getX() < 10 || ball.getX() > getWidth() - 10) {
                    ball.dx = -ball.dx;
                }
                if (ball.getY() < 10 || ball.getY() > getHeight() - 10) {
                    ball.dy = -ball.dy;
                }
            }
            // Repaint the panel to update the ball positions
            repaint();
        }).start();
    }

    // Ensures that each ball is drawn on the panel in the correct position and with the correct appearance
    public void paintComponent(Graphics g) {
        // Clear any previous drawing from the panel
        super.paintComponent(g);
        // Draw each ball
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }
}
