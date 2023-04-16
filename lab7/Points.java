/* Shapes of points
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Points extends JPanel {

    public Color color;

    public Points() {
        this(Color.blue);
        setLocation(0, 0);
        setSize(1, 1);
    }

    public Points(Color c) {
        color=c;
        setLocation(0, 0);
        setSize(1, 1);
    }

    public Points(int s) {
        this(Color.blue);
        setSize(s,s);
    }

    public Points(int x, int y) {
        this(Color.blue);
        setLocation(x, y);
    }

    public Points(int x, int y, int s) {
        this(x,y);
        setSize(s,s);
    }

    public Points(int x, int y, int s, Color c) {
        this( x, y, s);
        this.color = c;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.fillRect(0, 0, 1, 1);
    }
}
