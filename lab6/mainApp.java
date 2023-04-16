/* The program converts temperature in format Java GUI
 * 
 * Creted by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import javax.swing.*;
import java.awt.event.*;
import MyThermometer.*;

public class mainApp extends JFrame implements ActionListener {
    /* set a variable */
    private JTextField inputTextField, outputTextField;
    private JLabel inputLabel;
    private JCheckBox checkBox;
    private JButton convertButton;
    private String inputTemp = "C";
    /* set the interface */
    public mainApp() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputTextField = new JTextField(10);
        outputTextField = new JTextField(10);
        outputTextField.setEditable(false);
        inputLabel = new JLabel("Input Temp - " + inputTemp);
        checkBox = new JCheckBox("Fahrenheit");
        checkBox.addActionListener(this);
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(inputTextField);
        panel.add(inputLabel);
        panel.add(checkBox);
        panel.add(convertButton);
        panel.add(outputTextField);

        add(panel);
        setVisible(true);
    }
    /* set the temperature conversion interface usage */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBox) {
            if (checkBox.isSelected()) {
                inputTemp = "F";
                inputLabel.setText("Input Temp - " + inputTemp);
            } 
            else {
                inputTemp = "C";
                inputLabel.setText("Input Temp - " + inputTemp);
            }
        } 
        else if (e.getSource() == convertButton) {
            try {
                MyThermometer t = new MyThermometer();
                double input = Double.parseDouble(inputTextField.getText());
                double output;
                if (inputTemp.equals("C")) {
                    t.setTempC(input);
                    output = t.readTempF();
                } 
                else {
                    t.setTempF(input);
                    output = t.readTempC();
                }
                outputTextField.setText(Double.toString(output));
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /* main function */
    public static void main(String[] args) {
        new mainApp();
    }
}
