package Panels;

import Components.CheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tests_Choice extends JPanel implements ActionListener
{
    CheckBox[] checkBox;
    String[] test;

    public Tests_Choice(){
        checkBox = new CheckBox[10];
        String[] test = {"Complete Blood Test", "Urinalysis", "Thyroid Test",
                "Diabetes Test", "Common Viral Fevers", "Sexually Transmitted Diseases",
                "Cholesterol Test", "Sputum Culture", "Drug Test", "Allergy Test"};
        for (int i=0; i<=9; i++){
            checkBox[i] = new CheckBox(test[i]);
            checkBox[i].addActionListener(this);
            this.add(checkBox[i]);
        }
        this.setLayout(new GridLayout(5,2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<=9; i++){
            if (checkBox[i].isSelected()){
                System.out.println(test[i]);
            }
        }

    }
}
