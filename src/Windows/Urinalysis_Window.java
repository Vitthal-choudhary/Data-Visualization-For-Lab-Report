package Windows;

import Components.Buttons;
import Components.Fields;
import Components.Labels;
import JDBC.Urinalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Urinalysis_Window implements ActionListener
{
    JFrame root;
    Labels[] Attributes = new Labels[9];
    String[] l1 = {"COLOR URINE", "PROTEIN URINE", "GLUCOSE URINE IRIS", "KETONE URINE",
            "BILIRUBIN URINE", "NITRITE URINE", "LEUKOCYTE ESTERASE URINE",
            "UROBILINOGEN URINE", "PH URINE"};
    Fields[] Your_Result = new Fields[9];
    JPanel p1, p2;
    GridLayout layout = new GridLayout(9,1);
    Buttons button;

    public Urinalysis_Window(){
        root = new JFrame("Lab Assist");
        root.getContentPane().setBackground(Color.orange);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setExtendedState(JFrame.MAXIMIZED_BOTH);
        root.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title
        Labels title = new Labels("Urinalysis", 30);
        title.setBounds(450,0,500,100);
        root.add(title);

        // Labels for attributes
        p1 = new JPanel();
        p1.setBackground(Color.orange);
        p1.setLayout(layout);
        layout.setVgap(8);
        for (int i=0; i<=8; i++){
            Attributes[i] = new Labels(l1[i],30);
            p1.add(Attributes[i]);
        }
        p1.setBounds(20,110,500,650);
        root.add(p1);

        //Entry Fields
        p2 = new JPanel();
        p2.setBackground(Color.orange);
        p2.setLayout(layout);
        for (int i=0; i<=8; i++){
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
        if (e.getSource()==button){
            String[] a = new String[7];
            float b,c;
            for (int j = 0; j<=6; j++){
                a[j] = Your_Result[j].getText();
            }
            b = Float.parseFloat(Your_Result[7].getText());
            c = Float.parseFloat(Your_Result[8].getText());
            new Urinalysis(a,b,c);
            root.dispose();
            new Final_Window();
        }
    }
}