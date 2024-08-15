import javax.swing.*;
import java.awt.*;


public class Window1
{
    Window1(){
        JFrame frame = new JFrame("Lab Assist");
        frame.getContentPane().setBackground(Color.orange);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));      // For top icon logo

        Labels title = new Labels("Lab Assist", 30);
        title.setBounds(450,0,500,100);
        frame.add(title);

        Labels name_label = new Labels("Name", 30);
        name_label.setBounds(30,150,300,100);
        frame.add(name_label);

        Labels age_label = new Labels("Age", 30);
        age_label.setBounds(30,270,300,100);
        frame.add(age_label);

        Labels sex_label = new Labels("Sex", 30);
        sex_label.setBounds(30,390,300,100);
        frame.add(sex_label);

        Labels Choice_Label = new Labels("Testing For :", 30);
        Choice_Label.setBounds(30,510,300,100);
        frame.add(Choice_Label);

        frame.add(new Panels());

        frame.setLayout(null);

        frame.setVisible(true);
    }

}
