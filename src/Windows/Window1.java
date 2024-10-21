package Windows;

import Components.*;
import JDBC.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Window1 implements ActionListener, Patient
{
//    Add_to_Patient subject = new Add_to_Patient();
    JFrame frame;
    JPanel pan;
    Labels title, name_label, age_label, sex_label, Choice_Label, patient_id_label;
    Fields name_field, age_field, patient_id_field;
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
        name_label.setBounds(30,150,200,60);
        frame.add(name_label);

        //age label
        age_label = new Labels("Age", 30);
        age_label.setBounds(30,270,200,60);
        frame.add(age_label);

        //sex label
        sex_label = new Labels("Sex", 30);
        sex_label.setBounds(30,390,200,60);
        frame.add(sex_label);

        //choice label
        Choice_Label = new Labels("Testing For", 30);
        Choice_Label.setBounds(30,510,200,60);
        frame.add(Choice_Label);

        // Patient ID label
        patient_id_label = new Labels("Patient ID", 30);
        patient_id_label.setBounds(800, 150, 200, 60);
        frame.add(patient_id_label);

        //name field
        name_field = new Fields();
        name_field.setBounds(380,150,300,60);
        frame.add(name_field);

        //age field
        age_field = new Fields();
        age_field.setBounds(380,270,300,60);
        frame.add(age_field);

        // Patient ID field
        patient_id_field = new Fields();
        patient_id_field.setBounds(1020, 150, 300, 60);
        frame.add(patient_id_field);

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
                String name = name_field.getText();
                String gender = "", test = "";
                int age = Integer.parseInt(age_field.getText());
                int id = Integer.parseInt(patient_id_field.getText());
                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                if (checkBox[0].isSelected()){
                    test = "Complete Blood Test";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Complete_Blood_Test_Window();
                } else if (checkBox[1].isSelected()) {
                    test = "Urinalysis";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Urinalysis_Window();
                } else if (checkBox[2].isSelected()) {
                    test = "Thyroid Test";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Thyroid_Test_Window();
                } else if (checkBox[3].isSelected()) {
                    test = "Diabetes";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Diabetes_Test_Window();
                } else if (checkBox[4].isSelected()) {
                    test = "Sexually Transmitted Disease";
                    patient.Add_Patient(id, name,age,gender,test);
                    new STD_Test_Window();
                } else if (checkBox[5].isSelected()) {
                    test = "Cholesterol Test";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Cholesterol_Test_Window();
                } else if (checkBox[6].isSelected()) {
                    test = "Drug Test";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Drug_Test_Window();
                } else if (checkBox[7].isSelected()) {
                    test = "Allergy Test";
                    patient.Add_Patient(id, name,age,gender,test);
                    new Allergy_Test_Window();
                }
                frame.dispose();
            }
        }
    }
}