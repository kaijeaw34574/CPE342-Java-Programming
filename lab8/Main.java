/* The program stores student data with a stack method and can sort student data according to user requirements.
 * 
 * Created Pornthep Sangthongkhamsuk ID: 63070503431 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Stack;

public class Main extends JFrame {
    private Stack<Student> stack;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField gpaField;
    private JTextArea displayArea;

    public Main() {
        stack = new Stack<>();
        setTitle("Student Stack");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("GPA:"));
        gpaField = new JTextField();
        inputPanel.add(gpaField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    double gpa = Double.parseDouble(gpaField.getText());
                    Student student = new Student(id, firstName, lastName, gpa);
                    stack.push(student);
                    displayArea.append(student.toString() + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(pushButton);
    
        JButton popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.empty()) {
                    Student student = stack.pop();
                    displayArea.setText(displayArea.getText().replace(student.toString() + "\n", ""));
                }
            }
        });
        buttonPanel.add(popButton);
    
        JButton idSortButton = new JButton("Sort by ID");
        idSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(stack, new StudentComparator("id"));
                redrawStack();
            }
        });
        buttonPanel.add(idSortButton);
    
        JButton firstNameSortButton = new JButton("Sort by First Name");
        firstNameSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(stack, new StudentComparator("firstName"));
                redrawStack();
            }
        });
        buttonPanel.add(firstNameSortButton);
    
        JButton lastNameSortButton = new JButton("Sort by Last Name");
        lastNameSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(stack, new StudentComparator("lastName"));
                redrawStack();
            }
        });
        buttonPanel.add(lastNameSortButton);
    
        JButton gpaSortButton = new JButton("Sort by GPA");
        gpaSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(stack, new StudentComparator("gpa"));
                redrawStack();
            }
        });
        buttonPanel.add(gpaSortButton);
    
        displayArea = new JTextArea();
        displayArea.setEditable(false);
    
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    
        setVisible(true);
    }
    
    private void redrawStack() {
        StackDisplay stackDisplay = new StackDisplay(stack);
        stackDisplay.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}