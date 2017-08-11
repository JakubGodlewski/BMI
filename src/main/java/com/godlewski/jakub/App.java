package com.godlewski.jakub;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("BMI");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new MainPanel());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }
}
