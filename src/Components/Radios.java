package Components;

import javax.swing.*;
import java.awt.*;

public class Radios extends JRadioButton
{
    public Radios(String text){
        this.setBackground(Color.orange);
        this.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.setText(text);
    }
}
