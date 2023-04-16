/* The program show a stack of student.
 * 
 * Created Pornthep Sangthongkhamsuk ID: 63070503431 
 */

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class StackDisplay extends JFrame {
    
    private Stack<Student> stack;

    public StackDisplay(Stack<Student> stack) {
        this.stack = stack;
        setTitle("Stack Display");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        int x = 50;
        int y = 50;
        for (Student student : stack) {
            g.drawString(student.toString(), x, y);
            y += 20;
        }
    }
}
