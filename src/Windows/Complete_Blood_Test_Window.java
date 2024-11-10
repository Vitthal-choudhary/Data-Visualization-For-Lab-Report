package Windows;

import Components.*;
import JDBC.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Complete_Blood_Test_Window implements ActionListener
{
    JFrame root;
    Labels[] Attributes = new Labels[10];
    String[] l1 = {"WBC", "RBC", "HAEMOGLOBIN", "HEMATOCRIT", "MCV",
                    "MCH", "MCHC", "RDW-CV", "PLATELET COUNT", "MPV"};
    Fields[] Your_Result = new Fields[10];
    JPanel p1, p2;
    GridLayout layout = new GridLayout(10,1);
    Buttons button;
    public Complete_Blood_Test_Window()
    {
        root = new JFrame("Lab Assist");
        root.getContentPane().setBackground(Color.orange);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Labels title = new Labels("CBC Test", 30);
        title.setBounds(450,0,500,100);
        root.add(title);

        // Labels for attributes
        p1 = new JPanel();
        p1.setBackground(Color.orange);
        p1.setLayout(layout);
        layout.setVgap(8);
        for (int i=0; i<=9; i++){
            Attributes[i] = new Labels(l1[i],30);
            p1.add(Attributes[i]);
        }
        p1.setBounds(20,110,300,650);
        root.add(p1);

        //Entry Fields
        p2 = new JPanel();
        p2.setBackground(Color.orange);
        p2.setLayout(layout);
        for (int i=0; i<=9; i++){
            Your_Result[i] = new Fields();
            p2.add(Your_Result[i]);
        }
        p2.setBounds(450,110,500,650);
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
        float[] arr = new float[10];
        if (e.getSource()==button){
            for (int j = 0; j<=9; j++){
                arr[j] = Float.parseFloat(Your_Result[j].getText());
            }
            new Blood_test(arr);
            root.dispose();
            new Final_Window();
        }
    }
}
