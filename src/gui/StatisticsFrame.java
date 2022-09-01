package gui;

import main.Statistics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsFrame extends JFrame {
    private JPanel statisticsPanel;
    private JButton backToMainFrameButton;
    private JComboBox timePeriodComboBox;
    private JTextField totalDistanceField;
    private JTextField distanceField;
    private JTextField numberOfTrainingsField;

    public StatisticsFrame() {
        setContentPane(statisticsPanel);
        setTitle("Statystyki");
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

        timePeriodComboBox.addItem("Wybierz...");
        timePeriodComboBox.addItem("Aktualny tydzień");
        timePeriodComboBox.addItem("Aktualny miesiąc");

        timePeriodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                String timePeriod = (String) cb.getSelectedItem();
                if (timePeriod.equals("Wybierz...")) {
                    totalDistanceField.setText("");
                    numberOfTrainingsField.setText("");
                    distanceField.setText("");
                    return;
                }
                double totalDistance = Statistics.getTotalDistance(timePeriod);
                if (totalDistance == 0) {
                    JOptionPane.showMessageDialog(null, "Brak danych o treningach z podanego okresu.");
                    return;
                }
                totalDistanceField.setText(Double.toString(Statistics.getTotalDistance(timePeriod)));
                numberOfTrainingsField.setText(Integer.toString(Statistics.getNumberOfTrainings()));
                distanceField.setText(Double.toString(Statistics.getDistance()));
            }
        });
    }

}
