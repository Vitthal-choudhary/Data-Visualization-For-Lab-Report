package Windows;

import Components.Buttons;
import Components.Fields;
import Components.Labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cholesterol_Test_Window implements ActionListener
{
    JFrame root;
    Labels[] Attributes = new Labels[6];
    String[] l1 = {"TOTAL CHOLESTEROL", "LDL CHOLESTEROL", "HDL CHOLESTEROL", "TRIGLYCERIDES", "NON-HDL-C", "TG TO HDL RATIO"};
    Fields[] Your_Result = new Fields[6];
    JPanel p1, p2;
    GridLayout layout = new GridLayout(6,1);
    Buttons button;
    public Cholesterol_Test_Window(){
        root = new JFrame("Lab Assist");
        root.getContentPane().setBackground(Color.orange);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title
        Labels title = new Labels("Cholesterol Test", 30);
        title.setBounds(450,0,500,100);
        root.add(title);

        // Labels for attributes
        p1 = new JPanel();
        p1.setBackground(Color.orange);
        p1.setLayout(layout);
        layout.setVgap(8);
        for (int i=0; i<=5; i++){
            Attributes[i] = new Labels(l1[i],30);
            p1.add(Attributes[i]);
        }
        p1.setBounds(20,110,500,650);
        root.add(p1);

        //Entry Fields
        p2 = new JPanel();
        p2.setBackground(Color.orange);
        p2.setLayout(layout);
        for (int i=0; i<=5; i++){
            Your_Result[i] = new Fields();
            p2.add(Your_Result[i]);
        }
        p2.setBounds(550,110,500,650);
        root.add(p2);

        //Proceed Button
        button = new Buttons("Proceed");
        button.setBounds(1100,400,300,100);
        button.addActionListener(this);
        root.add(button);

        root.setLayout(null);
        root.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            for (int j = 0; j <= 5; j++) {
                System.out.println(Your_Result[j].getText());
            }
            root.dispose();
        }
    }
}
