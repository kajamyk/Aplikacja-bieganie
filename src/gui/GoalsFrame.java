package gui;

import main.Goals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class GoalsFrame extends JFrame {
    private JPanel goalsPanel;
    private JButton backToMainFrameButton;
    private JSpinner distanceSpinner;
    private JButton addGoalButton;
    private JScrollPane scrollPane;
    private JList goalsList;
    private JButton deleteGoalButton;
    private JTextField startingDayField;
    private JTextField finalDayField;

    public GoalsFrame() {
        setContentPane(goalsPanel);
        setTitle("Cele treningowe");
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

        goalsList.setModel(Goals.getList());
        scrollPane.setViewportView(goalsList);

        deleteGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = goalsList.getSelectedIndex();
                DefaultListModel model = (DefaultListModel) goalsList.getModel();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }
            }
        });

        goalsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                goalsList.setSelectedIndex(goalsList.getSelectedIndex());
                goalsList.setSelectionBackground(Color.darkGray);
            }
        });


        addGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double distance = ((Integer) distanceSpinner.getValue()).doubleValue();
                String startingDate = startingDayField.getText();
                String finalDate = finalDayField.getText();
                try {
                    Goals.addGoal(startingDate, finalDate, distance);
                    distanceSpinner.setToolTipText("0");
                    startingDayField.setText("dd/mm/rrrr");
                    finalDayField.setText("dd/mm/rrrr");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Podane nieodpowiednie dane.");
                }
            }
        });
    }
}
