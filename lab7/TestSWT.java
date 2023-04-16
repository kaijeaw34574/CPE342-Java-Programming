/* Find the boundary of the internal frame, 
 * and make the ball bouncing inside the frame correctly
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

public class TestSWT {

    private JFrame frame;
    
    private JTextField textField;

    public TestSWT() {
        initialize();
    }

    public void initialize() {
        // set up window 
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        // assign an internal frame inside the window 
        final JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
        internalFrame.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                textField.setText(internalFrame.toString());
            }           
        });
        internalFrame.setBounds(10, 55, 420, 200);
        frame.getContentPane().add(internalFrame);
        internalFrame.getContentPane().setLayout(null);
        // assign up a ball 
        Points p = new Points(10,10,2,Color.red);
        p.setBounds(p.getX(), p.getY(), p.getSize().height, p.getSize().width);
        internalFrame.getContentPane().add(p);
        final Circle cir = new Circle(0,0,20,Color.blue);
        cir.setBounds(cir.getX(), cir.getY(), cir.getDiameter(), cir.getDiameter());
        internalFrame.getContentPane().add(cir);
        internalFrame.setVisible(true);
        // assign GUI
        JPanel panel = new JPanel();
        panel.setBounds(10, 0, 414, 54);
        frame.getContentPane().add(panel);
        JLabel lblNewLabel = new JLabel("New label");
        panel.add(lblNewLabel);
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(25);
        textField.setText("here " + p.getLocation());
        // assign the ball bounce inside the internal frame
        ActionListener listener = new ActionListener() {
            int dx = 1;
            int dy = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension size = internalFrame.getSize();
                Insets insets = internalFrame.getInsets();
                
                int w = size.width - insets.left - insets.right;
                int h = size.height - insets.top - insets.bottom;
                
                if (cir.getX() + dx < 0 || cir.getX() + cir.getDiameter() + dx > w) {
                    dx = -dx;
                }
                if (cir.getY() + dy < 0 || cir.getY() + cir.getDiameter() + dy > h) {
                    dy = -dy;
                }
                cir.setLocation(cir.getX() + dx, cir.getY() + dy);
                }
            };
        Timer displayTimer = new Timer(50, listener);
        displayTimer.start();
    }   

    public static void main(String[] args) {
        new TestSWT();
    }
}
