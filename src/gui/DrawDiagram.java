package gui;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Calendar;

import main.Statistics;
import main.Training;

public class DrawDiagram extends JPanel {

    private String timeperiod;
    private Color myPink = new Color(187,129,153);
    private Color myWhite = new Color(214, 214, 214);

    DrawDiagram(String timeperiod) {
        this.timeperiod = timeperiod;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawBasicDiagram(g);


        Statistics.getTotalDistance(timeperiod);

        double [] distance = Statistics.getTrainingsDistanceForWeek();
        double max = findMax(distance);
        if(timeperiod.equals("Aktualny tydzień")){
            drawStrings(g);
            drawRectangles(g, distance, max);
        }
        else {
            drawRectanglesForMonth(g, distance, max);
        }
        g2d.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
        g2d.drawString(Double.toString(max), 40, 55);

    }

    protected void  drawRectanglesForMonth(Graphics g, double[] distance, double maxDistance ) {
        Graphics2D g2d = (Graphics2D) g;
        int maxHeight = 240;
        int width = 13;
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);;
        g2d.setFont(new Font("Book Antiqua", Font.PLAIN, 10));
        for(int i = 0; i < monthMaxDays; i++) {

            int height = (int)(maxHeight*(distance[i]) / maxDistance );
            if(distance[i] == 0) {
                height = 0;
            }
            g2d.setColor(Color.darkGray);
            g2d.drawRect(60 + width*i, 60+(maxHeight-height), width, height);
            g2d.fillRect(60 + width*i, 60+(maxHeight-height), width, height);
            g2d.setColor(myWhite);
            g2d.drawString(Integer.toString(i+1), 60 + width*i, 70+(maxHeight-0));
        }
    }

    protected void drawBasicDiagram (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(myPink);
        g2d.drawRect(0, 0, 600, 400);
        g2d.fillRect(0, 0, 600, 400);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));

        g2d.drawLine(20, 300, 20, 40);
        g2d.drawLine(15, 60, 25, 60);
        g2d.drawLine(20, 300, 550, 300);

        g2d.drawLine(20, 40, 10, 50);
        g2d.drawLine(20, 40, 30, 50);

        g2d.drawLine(550, 300, 540, 290);
        g2d.drawLine(550, 300, 540, 310);

        g2d.setColor(myWhite);
        g2d.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
        g2d.drawString("0", 15, 320);
    }

    protected void drawStrings (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        String [] weekDays = {"pon", "wt", "srd", "czw", "pt", "sb", "nd"};
        g2d.setColor(myWhite);
        g2d.setFont(new Font("Book Antiqua", Font.PLAIN, 14));

        for(int i = 0; i < weekDays.length; i++) {
            g2d.drawString(weekDays[i], 60+65*i, 320);
        }
    }
    private double findMax (double [] tab) {
        double max = 0;
        for(int i = 0; i < tab.length; i++){
            if(tab[i] > max) {
                max = tab[i];
            }
        }
        return max;
    }

    protected void drawRectangles (Graphics g, double [] distance, double maxDistance) {
        Graphics2D g2d = (Graphics2D) g;
        int maxHeight = 240;
        int width = 20;

        for(int i = 0; i < distance.length; i++) {

            int height = (int)(maxHeight*(distance[i]) / maxDistance );
            if(distance[i] == 0) {
                height = 0;
            }
            g2d.setColor(Color.darkGray);
            g2d.drawRect(60 + 65*i, 60+(maxHeight-height), width, height);
            g2d.fillRect(60 + 65*i, 60+(maxHeight-height), width, height);
        }
    }
    public static void main(String [] args) {

    }
}