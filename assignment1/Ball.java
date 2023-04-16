/* Ball.java
 *  
 *  This code defines a simple Ball class that can be used in a graphical program 
 *  to create and move a ball object in a graphical interface
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import java.awt.Color;    // Represent colors in the RGB color space
import java.awt.Graphics; // Drawing on a graphical user interface (GUI)

public class Ball {
    
    public int x;        // The x and y coordinate of the ball's position on the screen
    public int y;           
    public int dx;       // The change in x and y coordinate of the ball's position per frame update
    public int dy;          
    public Color color ; // The color of the ball

    // Store the position, speed, and color of the ball
    public Ball(int x, int y, int dx, int dy, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    // Update the position of the ball based on its speed
    public void move() {
        x += dx;
        y += dy;
    }

    // Draws an oval with the ball's position as the center and the ball's color
    public void draw(Graphics g) {
        g.setColor(color);
        // x and y is 10 are used to sets the center of the oval
        // 20 specify the width and height to make the oval appear as a circle around the ball
        g.fillOval(x - 10, y - 10, 20, 20);
    }

    // Return the x positions of the ball
    public int getX() {
        return x;
    }

    // Return the y positions of the ball
    public int getY() {
        return y;
    }
}
