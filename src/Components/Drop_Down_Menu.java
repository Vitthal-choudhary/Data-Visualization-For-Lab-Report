package Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drop_Down_Menu implements ActionListener
{
    public JComboBox<String> comboBox;
    public Drop_Down_Menu(){
        String[] test = {"Complete Blood Test", "Urinalysis", "Thyroid Test",
                "Diabetes Test", "Common Viral Fevers", "Sexually Transmitted Diseases",
                "Cholesterol Test", "Sputum Culture", "Drug Test", "Allergy Test"};

        comboBox = new JComboBox<String>(test);
        comboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
