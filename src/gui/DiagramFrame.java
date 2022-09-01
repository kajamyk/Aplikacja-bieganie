package gui;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DiagramFrame extends JFrame {
    private JPanel diagramPanel;

    public DiagramFrame(String timePeriod) {

        setContentPane(diagramPanel);
        setTitle("Diagram");
        setSize(600, 400);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
        JPanel drawDiagramPanel = new DrawDiagram(timePeriod);
        drawDiagramPanel.setBounds(20, 20, 600, 400);

        setLayout(new GridLayout());
        diagramPanel.add(drawDiagramPanel);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }


    public static void main (String [] args) {

    }
}
