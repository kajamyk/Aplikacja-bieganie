package gui;

import main.MainPanel;
import main.Training;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class MainFrame extends JFrame {
    private JComboBox comboBox1;
    private JPanel mainPanel;
    private JLabel totalDistance;
    private javax.swing.JPanel JPanel;
    private JTextPane quoteLabel;
    private JButton quoteButton;
    private JSlider moodSlider;
    private JLabel moodLabel;


    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Strona główna");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        totalDistance.setText(Double.toString(Training.getTotalDistance()));
        quoteLabel.setText(MainPanel.getRandomQuote());

        comboBox1.addItem("Wybierz...");
        comboBox1.addItem("Statystyki");
        comboBox1.addItem("Kalkulator");
        comboBox1.addItem("Cele treningowe");
        comboBox1.addItem("Dodaj trening");
        comboBox1.addItem("Lista treningów");
        comboBox1.addItem("Diagram tygodniowy");
        comboBox1.addItem("Diagram miesięczny");

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox<String> cb = (JComboBox<String>) e.getSource();
                    String item = (String) cb.getSelectedItem();
                    switch (item) {
                        case "Statystyki":
                            setVisible(false);
                            StatisticsFrame statisticsFrame = new StatisticsFrame();
                            statisticsFrame.setVisible(true);
                            break;
                        case "Kalkulator":
                            setVisible(false);
                            CalculatorFrame calculatorFrame = new CalculatorFrame();
                            calculatorFrame.setVisible(true);
                            break;
                        case "Diagram tygodniowy":
                            setVisible(false);
                            DiagramFrame diagramFrame = new DiagramFrame("Aktualny tydzień");
                            diagramFrame.setVisible(true);
                            break;
                        case "Diagram miesięczny":
                            setVisible(false);
                            DiagramFrame diagramFrameMonth = new DiagramFrame("Aktualny miesiąc");
                            diagramFrameMonth.setVisible(true);
                            break;
                        case "Cele treningowe":
                            setVisible(false);
                            GoalsFrame goalsFrame = new GoalsFrame();
                            goalsFrame.setVisible(true);
                            break;
                        case "Dodaj trening":
                            setVisible(false);
                            TrainingFrame trainingFrame = new TrainingFrame();
                            trainingFrame.setVisible(true);
                            break;
                        case "Lista treningów":
                            setVisible(false);
                            TrainingListFrame trainingListFrame = new TrainingListFrame();
                            trainingListFrame.setVisible(true);
                            break;
                    }
                }
            }
        });

        quoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quoteLabel.setText(MainPanel.getRandomQuote());
            }
        });


        moodSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                moodLabel.setForeground(MainPanel.getColor(moodSlider.getValue()));

            }
        });
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}
