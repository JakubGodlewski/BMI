package com.godlewski.jakub;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JLabel lblWeight = new JLabel("Weight [kg]: ");
    private JLabel lblHeight = new JLabel("Height [cm]: ");
    private JLabel lblBMI = new JLabel("BMI: ");
    private JLabel lblResult = new JLabel("Result: ");
    private JTextField tfWeight = new JTextField(20);
    private JTextField tfHeight = new JTextField(20);
    private JTextField tfBMI = new JTextField(20);
    private JTextField tfResult = new JTextField(20);
    private JButton btnCalculate = new JButton("Calculate");
    double height;
    double weight;
    double bmi;
    String result;

    public MainPanel() {
        super(new GridBagLayout());
        GridBagConstraints gbcPosition = new GridBagConstraints();
        JPanel panelFields = new JPanel(new GridBagLayout());
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 0;
        panelFields.add(lblWeight, gbcPosition);
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 1;
        panelFields.add(lblHeight, gbcPosition);
        gbcPosition.gridx = 1;
        gbcPosition.gridy = 0;
        panelFields.add(tfWeight, gbcPosition);
        gbcPosition.gridx = 1;
        gbcPosition.gridy = 1;
        panelFields.add(tfHeight, gbcPosition);

        JPanel panelButton = new JPanel(new GridBagLayout());
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 0;
        panelButton.add(btnCalculate, gbcPosition);
        btnCalculate.addActionListener(x -> calculate());

        JPanel panelResult = new JPanel(new GridBagLayout());
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 0;
        panelResult.add(lblBMI, gbcPosition);
        gbcPosition.gridx = 1;
        gbcPosition.gridy = 0;
        panelResult.add(tfBMI, gbcPosition);
        tfBMI.setEditable(false);
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 1;
        panelResult.add(lblResult, gbcPosition);
        gbcPosition.gridx = 1;
        gbcPosition.gridy = 1;
        panelResult.add(tfResult, gbcPosition);
        tfResult.setEditable(false);

        JPanel panelMain = new JPanel(new GridBagLayout());
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 0;
        panelMain.add(panelFields, gbcPosition);
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 1;
        panelMain.add(panelButton, gbcPosition);
        gbcPosition.gridx = 0;
        gbcPosition.gridy = 2;
        panelMain.add(panelResult, gbcPosition);

        add(panelMain);
    }

    private double calculate()
    {
        if(!tfHeight.getText().matches("\\d+")||!tfWeight.getText().matches("\\d+([.]\\d+)?"))
        {
            JOptionPane.showMessageDialog(null, "Invalid values!");
        }
        else
        {
            height = Double.parseDouble(tfHeight.getText());
            weight = Double.parseDouble(tfWeight.getText());
            bmi = weight/Math.pow(height/100, 2);
            bmi*=100;
            bmi = Math.round(bmi);
            bmi/=100;
            tfBMI.setText(String.valueOf(bmi));

            if(bmi<=15)
            {
                result = "very severely underweight";
            }
            else if(bmi>15 && bmi<=16)
            {
                result = "severely underweight";
            }
            else if(bmi>16 && bmi<=18.5)
            {
                result = "underweight";
            }
            else if(bmi>18.5 && bmi<=25)
            {
                result = "normal (healthy weight)";
            }
            else if(bmi>25 && bmi<=30)
            {
                result = "overweight";
            }
            else if(bmi>30 && bmi<=35)
            {
                result = "obese class I (moderately obese)";
            }
            else if(bmi>35 && bmi<=40)
            {
                result = "obese class II (severely obese)";
            }
            else
            {
                result = "obese class III (very severely obese)";
            }

            tfResult.setText(result);
        }
        return 0;
    }
}
