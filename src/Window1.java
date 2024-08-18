import Components.Fields;
import Components.Labels;
import Panels.Gender;
import Panels.Tests_Choice;

import javax.swing.*;
import java.awt.*;


public class Window1
{
    JFrame frame;
    Labels title, name_label, age_label, sex_label, Choice_Label;
    Fields name_field, age_field;

    Window1(){
        frame = new JFrame("Lab Assist");
        frame.getContentPane().setBackground(Color.orange);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));      // For top icon logo

        //title
        title = new Labels("Lab Assist", 30);
        title.setBounds(450,0,500,100);
        frame.add(title);

        //name label
        name_label = new Labels("Name", 30);
        name_label.setBounds(30,150,300,100);
        frame.add(name_label);

        //age label
        age_label = new Labels("Age", 30);
        age_label.setBounds(30,270,300,100);
        frame.add(age_label);

        //sex label
        sex_label = new Labels("Sex", 30);
        sex_label.setBounds(30,390,300,100);
        frame.add(sex_label);

        //choice label
        Choice_Label = new Labels("Testing For :", 30);
        Choice_Label.setBounds(30,510,300,100);
        frame.add(Choice_Label);

        //name field
        name_field = new Fields();
        name_field.setBounds(380,150,500,100);
        frame.add(name_field);

        //age field
        age_field = new Fields();
        age_field.setBounds(380,270,500,100);
        frame.add(age_field);

        Gender panel = new Gender();
        panel.setBounds(380,390,500,100);
        frame.add(panel);

        Tests_Choice t = new Tests_Choice();
        t.setBounds(380,480,850,300);
        frame.add(t);

        frame.setLayout(null);

        frame.setVisible(true);
    }

}
