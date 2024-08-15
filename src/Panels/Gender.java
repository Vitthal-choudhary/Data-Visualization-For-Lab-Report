package Panels;

import Components.Radios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gender extends JPanel implements ActionListener
{
    Radios male, female;

    public Gender(){
        male = new Radios("Male");
        male.addActionListener(this);

        female = new Radios("Female");
        female.addActionListener(this);

        ButtonGroup grp = new ButtonGroup();
        grp.add(male);
        grp.add(female);

        male.setBounds(0,0,250,100);
        female.setBounds(250,0,250,100);
        this.add(male);
        this.add(female);

        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()=="Male"){
            System.out.println("Male");
        } else if (e.getSource() == "Female") {
            System.out.println("Female");
        }
    }
}