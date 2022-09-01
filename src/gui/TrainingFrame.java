package gui;

import main.Training;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrainingFrame extends JFrame {
    private JPanel trainingPanel;
    private JButton backToMainFrameButton;
    private JButton addTrainingButton;
    private JTextField distanceField;
    private JTextField dateField;
    private JTextPane commentPane;


    public TrainingFrame() {
        setContentPane(trainingPanel);
        setTitle("Dodaj trening");
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
        addTrainingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String distance = distanceField.getText();
                String comment = commentPane.getText();
                dateField.setText("dd/mm/rrrr");
                distanceField.setText("0.0");
                commentPane.setText("-");
                try {
                    Training.addTraining(date, distance, comment);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Podane nieodpowiednie dane.");
                }
            }
        });
    }
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }
}
