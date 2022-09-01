package gui;

import main.Training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrainingListFrame extends JFrame {
    private JButton backToMainFrameButton;
    private JPanel trainingListPanel;
    private JList trainingList;
    private JScrollPane scrollPane;
    private JButton deleteButton;
    private JButton sortButton;
    private JCheckBox sortBox;

    public TrainingListFrame() {
        setContentPane(trainingListPanel);
        setTitle("Lista treningów");
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

        trainingList.setModel(Training.getList());
        scrollPane.setViewportView(trainingList);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = trainingList.getSelectedIndex();
                DefaultListModel model = (DefaultListModel) trainingList.getModel();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                }
            }
        });
        trainingList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                trainingList.setSelectedIndex(trainingList.getSelectedIndex());
                trainingList.setSelectionBackground(Color.darkGray);
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sortBox.isSelected()){
                    trainingList.setModel(Training.getAscSortedList());
                    scrollPane.setViewportView(trainingList);
                }
                else {
                    trainingList.setModel(Training.getDescSortedList());
                    scrollPane.setViewportView(trainingList);
                }
            }
        });
    }
}
