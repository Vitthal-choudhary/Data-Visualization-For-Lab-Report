import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fields extends JTextField implements ActionListener
{
    public Fields(){
        this.setFont(new Font("Verdana",Font.ITALIC,15));
        this.setForeground(Color.GREEN);
        this.setBackground(Color.black);
        this.setCaretColor(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
