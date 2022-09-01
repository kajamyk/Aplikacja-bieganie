package main;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Goals {
    private static final DefaultListModel goalsList = new DefaultListModel<SingleGoal>();

    public static DefaultListModel getList() {
        return goalsList;
    }

    public static void addGoal(String startingDate, String finalDate, double distance) throws ParseException {
        Date myStartingDate = new SimpleDateFormat("dd/MM/yyyy").parse(startingDate);
        Date myFinalDate = new SimpleDateFormat("dd/MM/yyyy").parse(finalDate);
        Statistics.setHours(myFinalDate);
        Statistics.setHours(myStartingDate);
        SingleGoal singleGoal = new SingleGoal(distance, myStartingDate, myFinalDate);
        goalsList.addElement(singleGoal);
    }

    private static class SingleGoal {
        private final double distance;
        private final Date startingDate;
        private final Date finalDate;

        public SingleGoal(double distance, Date startingDate, Date finalDate) {
            this.distance = distance;
            this.finalDate = finalDate;
            this.startingDate = startingDate;
        }

        private String goalStatus(double result, double distance, Date finalDate) {
            Date currentDate = new Date(System.currentTimeMillis());
            if (result >= distance) {
                return "Cel osiągnięty";
            }
            if (!finalDate.after(currentDate)) {
                return "Cel nie został osiągnięty";
            }
            return "Cel jeszcze nie został osiągnięty";
        }

        @Override
        public String toString() {
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String finalDateString = simpleDateFormat.format(finalDate);
            String startingDateString = simpleDateFormat.format(startingDate);

            double result = Training.getResult(startingDate, finalDate);
            return "Data początkowa : " + startingDateString + "        Data końcowa : "
                    + finalDateString + "        Dystans : " + result + " / " + distance
                    + "        Status : " + goalStatus(result, distance, finalDate);
        }
    }
}
