import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
    private JLabel f_pol;
    private JLabel s_pol;
    private JLabel result;
    private JTextField f_pol_tf;
    private JTextField s_pol_tf;
    private JTextField result_tf;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;
    private JButton derivative;
    private JButton integration;
    private JFrame frame;

    public Interface() {
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        frame = new JFrame("Polynomial Calculator");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        f_pol = new JLabel("First Polynomial");
        f_pol.setFont(timesNewRoman);
        f_pol.setBounds(50, 20, 150, 20);
        frame.getContentPane().add(f_pol);

        s_pol = new JLabel("Second Polynomial");
        s_pol.setFont(timesNewRoman);
        s_pol.setBounds(200, 20, 150, 20);
        frame.getContentPane().add(s_pol);

        f_pol_tf = new JTextField();
        f_pol_tf.setFont(timesNewRoman);
        f_pol_tf.setBounds(50, 50, 150, 20);
        frame.getContentPane().add(f_pol_tf);

        s_pol_tf = new JTextField();
        s_pol_tf.setFont(timesNewRoman);
        s_pol_tf.setBounds(200, 50, 150, 20);
        frame.getContentPane().add(s_pol_tf);

        addition = new JButton("Addition");
        addition.setFont(timesNewRoman);
        addition.setBounds(50, 80, 100, 20);
        frame.getContentPane().add(addition);

        subtraction = new JButton("Subtraction");
        subtraction.setFont(timesNewRoman);
        subtraction.setBounds(150, 80, 100, 20);
        frame.getContentPane().add(subtraction);

        multiplication = new JButton("Multiplication");
        multiplication.setFont(timesNewRoman);
        multiplication.setBounds(250, 80, 100, 20);
        frame.getContentPane().add(multiplication);

        division = new JButton("Division");
        division.setFont(timesNewRoman);
        division.setBounds(50, 110, 100, 20);
        frame.getContentPane().add(division);

        derivative = new JButton("Derivative");
        derivative.setFont(timesNewRoman);
        derivative.setBounds(150, 110, 100, 20);
        frame.getContentPane().add(derivative);

        integration = new JButton("Integration");
        integration.setFont(timesNewRoman);
        integration.setBounds(250, 110, 100, 20);
        frame.getContentPane().add(integration);

        result = new JLabel("Result");
        result.setFont(timesNewRoman);
        result.setBounds(50, 140, 150, 20);
        frame.getContentPane().add(result);

        result_tf = new JTextField();
        result_tf.setFont(timesNewRoman);
        result_tf.setBounds(100, 140, 250, 20);
        frame.getContentPane().add(result_tf);

        frame.pack();
        frame.setVisible(true);


        addition.addActionListener(this);
        subtraction.addActionListener(this);
        multiplication.addActionListener(this);
        division.addActionListener(this);
        derivative.addActionListener(this);
        integration.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addition || e.getSource() == subtraction ||
                e.getSource() == multiplication || e.getSource() == division ||
                e.getSource() == derivative || e.getSource() == integration) {

            String fPolynomial = f_pol_tf.getText();
            String sPolynomial = s_pol_tf.getText();


            if (!Polynomial.isValidPolynomialFormat(fPolynomial) || !Polynomial.isValidPolynomialFormat(sPolynomial)) {
                result_tf.setText("Error: Invalid format");
                return;
            }


            Polynomial p1 = Polynomial.build(fPolynomial);
            Polynomial p2 = Polynomial.build(sPolynomial);

            if (e.getSource() == addition) {
                Polynomial result = Operations.addition(p1, p2);
                result_tf.setText(result.toString());
            } else if (e.getSource() == subtraction) {
                Polynomial result = Operations.subtraction(p1, p2);
                result_tf.setText(result.toString());
            } else if (e.getSource() == multiplication) {
                Polynomial result = Operations.multiplication(p1, p2);
                result_tf.setText(result.toString());
            } else if (e.getSource() == division) {
                try {
                    Polynomial[] result = Operations.division(p1, p2);
                    String resultStr = "Quotient: " + result[0].toString() + ", " +
                            "Remainder: " + result[1].toString();
                    result_tf.setText(resultStr);
                } catch (IllegalArgumentException ex) {
                    result_tf.setText("Error: " + ex.getMessage());
                }
            } else if (e.getSource() == derivative) {
                Polynomial result = Operations.derivative(p1);
                result_tf.setText(result.toString());
            } else if (e.getSource() == integration) {
                Polynomial result = Operations.integration(p1);
                result_tf.setText(result.toString());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface());
    }
}
