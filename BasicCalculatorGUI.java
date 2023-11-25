import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculatorGUI extends JFrame implements ActionListener {
    // Create components
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;
    private double num1, num2, result;
    private char operator;

    // Constructor
    public BasicCalculatorGUI() {
        // Set frame properties
        this.setTitle("ALNS Calculator");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Create and configure text field
        textField = new JTextField();
        textField.setBounds(30, 30, 340, 40);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // Create and configure number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Create and configure operator buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        JButton[] operatorButtons = {addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton};
        for (JButton button : operatorButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
        }

        // Position the components
        numberButtons[1].setBounds(50, 100, 50, 50);
        numberButtons[2].setBounds(120, 100, 50, 50);
        numberButtons[3].setBounds(190, 100, 50, 50);
        numberButtons[4].setBounds(50, 170, 50, 50);
        numberButtons[5].setBounds(120, 170, 50, 50);
        numberButtons[6].setBounds(190, 170, 50, 50);
        numberButtons[7].setBounds(50, 240, 50, 50);
        numberButtons[8].setBounds(120, 240, 50, 50);
        numberButtons[9].setBounds(190, 240, 50, 50);
        numberButtons[0].setBounds(120, 310, 50, 50);

        addButton.setBounds(260, 100, 50, 50);
        subtractButton.setBounds(260, 170, 50, 50);
        multiplyButton.setBounds(260, 240, 50, 50);
        divideButton.setBounds(260, 310, 50, 50);
        equalButton.setBounds(330, 310, 50, 50);
        clearButton.setBounds(330, 100, 50, 50);

        // Add components to the frame
        this.add(textField);
        for (int i = 0; i < 10; i++) {
            this.add(numberButtons[i]);
        }
        this.add(addButton);
        this.add(subtractButton);
        this.add(multiplyButton);
        this.add(divideButton);
        this.add(equalButton);
        this.add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        BasicCalculatorGUI calculator = new BasicCalculatorGUI();
        calculator.setVisible(true);
    }
}
