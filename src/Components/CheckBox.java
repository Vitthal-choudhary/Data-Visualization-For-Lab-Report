package Components;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox
{
    public CheckBox(String title){
        this.setText(title);
        this.setBackground(Color.orange);
        this.setFont(new Font("Verdana", Font.PLAIN, 25));
    }
}
