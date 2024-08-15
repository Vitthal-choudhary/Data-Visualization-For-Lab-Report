import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Radios extends JRadioButton implements ActionListener
{
    Radios(String text){
        this.addActionListener(this);
        this.setBackground(Color.orange);
        this.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.setText(text);

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
