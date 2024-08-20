package Components;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton
{
    public Buttons(String text){
        this.setText(text);
        this.setFont(new Font("Verdana", Font.PLAIN, 25));
        this.setBackground(Color.black);
        this.setForeground(Color.pink);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFocusable(false);
    }
}
