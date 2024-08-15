import javax.swing.*;
import java.awt.*;

public class Labels extends JLabel {
    Labels(String title, int size){
        this.setText(title);
        this.setFont(new Font("Verdana", Font.PLAIN, size));
        this.setBackground(Color.black);
        this.setForeground(Color.red);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
