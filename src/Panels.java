import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panels extends JPanel implements ActionListener
{
    public Panels(){
        this.setBounds(350,150,500,460);
        this.setBackground(Color.orange);

        Fields name_field = new Fields();
        name_field.setBounds(0,0,500,100);
        this.add(name_field);

        Fields age_field = new Fields();
        age_field.setBounds(0,120,500,100);
        this.add(age_field);

        Radios male = new Radios("Male");
        male.setBounds(0,240,200,100);

        Radios female = new Radios("Female");
        female.setBounds(200,240,200,100);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        this.add(male);
        this.add(female);

        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()=="Male")
            System.out.println("Male");
        else if (e.getSource() == "Female") {
            System.out.println("Female");
        }
    }
}
