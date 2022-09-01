package gui;

import main.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    private JPanel calculatorPanel;
    private JButton backToMainFrameButton;
    private JTextField timeField;
    private JTextField distanceField;
    private JButton calculateButton;
    private JTextField paceField;
    private JLabel resultLabel;


    public CalculatorFrame() {
        setContentPane(calculatorPanel);
        setTitle("Kalkulator");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        backToMainFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = timeField.getText();
                try {
                    double distance = Double.parseDouble(distanceField.getText());
                    double calculatedDistance = Double.parseDouble(paceField.getText());
                    if (Calculator.isTimeCorrect(time)) {
                        resultLabel.setText(Calculator.countPace(distance, calculatedDistance));
                    } else {
                        JOptionPane.showMessageDialog(null, "Format czasu jest nieprawidłowy.");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Podane nieodpowiednie dane.");
                }
            }
        });
    }
}
