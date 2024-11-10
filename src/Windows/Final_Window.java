package Windows;

import Components.Labels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Final_Window extends JFrame
{
    public Final_Window(){
        this.setTitle("Lab Assist");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.orange);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
        this.setLayout(null);

        Labels title = new Labels("Lab Assist",30);
        title.setBounds(450,0,500,100);
        this.add(title);

        File file = new File("D:\\Data-Visualization-For-Lab-Report\\Report.txt");
        try {
            StringBuilder content = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                content.append(scanner.nextLine());
                content.append("\n");
            }
            scanner.close();
            JTextArea textArea = new JTextArea(content.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBounds(450,200,500,500);
            this.add(scrollPane);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }
}
