package Windows;

import Components.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Window1 implements ActionListener
{
    JFrame frame;
    JPanel pan;
    Labels title, name_label, age_label, sex_label, Choice_Label;
    Fields name_field, age_field;
    Buttons butt;
    ButtonGroup grp1, grp2;
    Radios male, female;
    CheckBox[] checkBox = new CheckBox[8];
    String[] test = {"Complete Blood Test", "Urinalysis", "Thyroid Test",
            "Diabetes Test", "Sexually Transmitted Diseases",
            "Cholesterol Test", "Drug Test", "Allergy Test"};

    public Window1(){
        //Frame creation
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

        //Radio Buttons for gender
        male = new Radios("Male");
        male.addActionListener(this);
        female = new Radios("Female");
        female.addActionListener(this);
        grp1 = new ButtonGroup();
        grp1.add(male);
        grp1.add(female);
        male.setBounds(380,390,250,100);
        female.setBounds(630,390,250,100);
        frame.add(male);
        frame.add(female);

        //Panel with Choice CheckBox
        pan = new JPanel();
        pan.setLayout(new GridLayout(4,2));
        grp2 = new ButtonGroup();
        for (int i=0; i<=7; i++){
            checkBox[i] = new CheckBox(test[i]);
            checkBox[i].addActionListener(this);
            grp2.add(checkBox[i]);
            pan.add(checkBox[i]);
        }
        pan.setBounds(380,490,900,300);
        frame.add(pan);

        //Proceed Button
        butt = new Buttons("Proceed");
        butt.setBounds(1100,350,300,100);
        butt.addActionListener(this);
        frame.add(butt);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==butt){
            if (Objects.equals(name_field.getText(), "") || Objects.equals(age_field.getText(),"")){
                JOptionPane.showMessageDialog(null, "Fill the Details", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            else {
                System.out.println(name_field.getText());
                System.out.println(age_field.getText());
                if (male.isSelected())
                    System.out.println("Male");
                else if (female.isSelected())
                    System.out.println("Female");
                if (checkBox[0].isSelected()){
                    Complete_Blood_Test_Window cbc = new Complete_Blood_Test_Window();
                } else if (checkBox[1].isSelected()) {
                    Urinalysis_Window uw = new Urinalysis_Window();
                } else if (checkBox[2].isSelected()) {
                    Thyroid_Test_Window ttw = new Thyroid_Test_Window();
                } else if (checkBox[3].isSelected()) {
                    Diabetes_Test_Window dtw = new Diabetes_Test_Window();
                } else if (checkBox[4].isSelected()) {
                    STD_Test_Window std = new STD_Test_Window();
                } else if (checkBox[5].isSelected()) {
                    Cholesterol_Test_Window ctw = new Cholesterol_Test_Window();
                } else if (checkBox[6].isSelected()) {
                    Drug_Test_Window dtw = new Drug_Test_Window();
                } else if (checkBox[7].isSelected()) {
                    Allergy_Test_Window atw = new Allergy_Test_Window();
                }
                frame.dispose();
            }
        }

    }
}
