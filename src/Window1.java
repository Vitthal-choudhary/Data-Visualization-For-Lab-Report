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
    Radios male, female;
    CheckBox[] checkBox = new CheckBox[8];
    String[] test = {"Complete Blood Test", "Urinalysis", "Thyroid Test",
            "Diabetes Test", "Sexually Transmitted Diseases",
            "Cholesterol Test", "Drug Test", "Allergy Test"};

    Window1(){
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
        ButtonGroup grp = new ButtonGroup();
        grp.add(male);
        grp.add(female);
        male.setBounds(380,390,250,100);
        female.setBounds(630,390,250,100);
        frame.add(male);
        frame.add(female);

        //Panel with Choice CheckBox
        pan = new JPanel();
        pan.setLayout(new GridLayout(4,2));
        for (int i=0; i<=7; i++){
            checkBox[i] = new CheckBox(test[i]);
            checkBox[i].addActionListener(this);
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
                for (int i = 0; i <= 7; i++) {
                    if (checkBox[i].isSelected()) {
                        System.out.println(test[i]);
                    }
                }
                frame.dispose();
                Window2 win2 = new Window2();
            }
        }

    }
}
