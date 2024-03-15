package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Interface extends JFrame{
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
        result_tf.setBounds(200, 140, 150, 20);
        frame.getContentPane().add(result_tf);

        frame.pack();
        frame.setVisible(true);


    }


}
