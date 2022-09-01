package main;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Training {
    private static final DefaultListModel trainingList = new DefaultListModel<SingleTraining>();

    public static void addTraining(String date, String distance, String comment) throws ParseException {
        Date myDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Statistics.setHours(myDate);
        Double myDistance = Double.parseDouble(distance);
        Statistics.setHours(myDate);
        SingleTraining singleTraining = new SingleTraining(myDistance, comment, myDate);
        trainingList.addElement(singleTraining);
    }

    public static DefaultListModel getList() {
        return trainingList;
    }

    public static DefaultListModel getAscSortedList(){
        sortModel(trainingList, true);
        return trainingList;
    }

    public static DefaultListModel getDescSortedList(){
        sortModel(trainingList, false);
        return trainingList;
    }

    public static double getTotalDistance() {
        double distance = 0;
        for (int i = 0; i < trainingList.getSize(); i++) {
            SingleTraining singleTraining = (SingleTraining) trainingList.get(i);
            distance += singleTraining.getDistance();
        }
        return distance;
    }

    public static double getResult(Date startingDate, Date finalDate) {
        double distance = 0;
        for (int i = 0; i < trainingList.getSize(); i++) {

            SingleTraining singleTraining = (SingleTraining) trainingList.get(i);

            if ((startingDate.toString().equals(singleTraining.date.toString())
                    || !startingDate.after(singleTraining.date)) && !finalDate.before(singleTraining.date)) {
                distance += singleTraining.getDistance();
            }
        }
        return distance;
    }

    private static double [] createDistanceTable () {
        double [] distance = new double [31];
        for(int i = 0; i < 31; i++){
            distance[i] = 0;
        }
        return distance;
    }
    public static double [] getTableResult(Date startingDate, Date finalDate) {
        double [] distance = createDistanceTable();

        for (int i = 0; i < trainingList.getSize(); i++) {

            SingleTraining singleTraining = (SingleTraining) trainingList.get(i);

            if ((startingDate.toString().equals(singleTraining.date.toString())
                    || !startingDate.after(singleTraining.date)) && !finalDate.before(singleTraining.date)) {
                long diffrence = singleTraining.date.getTime() - startingDate.getTime();
                int diffrenceInDays = (int) (diffrence / (1000 * 60 * 60 * 24) % 365);
                if(! startingDate.toString().equals(singleTraining.date.toString())) {
                    diffrenceInDays += 1;
                }
                distance[diffrenceInDays] += singleTraining.distance;
            }
        }
        return distance;
    }

    public static int getNumberOfTrainings(Date startingDate, Date finalDate) {
        int numberOfTrainings = 0;
        for (int i = 0; i < trainingList.getSize(); i++) {
            SingleTraining singleTraining = (SingleTraining) trainingList.get(i);
            if ((startingDate.toString().equals(singleTraining.date.toString())
                    || (!startingDate.after(singleTraining.date)) && !finalDate.before(singleTraining.date))) {
                numberOfTrainings++;
            }
        }
        return numberOfTrainings;
    }

    private static void sortModel(DefaultListModel model, boolean sort) {
        List<SingleTraining> list = new ArrayList<>();
        for (int i = 0; i < model.size(); i++) {
            list.add((SingleTraining) model.get(i));
        }
        if(sort){
            Collections.sort(list);
        }
        else {
            Collections.sort(list, Collections.reverseOrder());
        }
        model.removeAllElements();
        for (SingleTraining s : list) {
            model.addElement(s);
        }
    }

    public static class SingleTraining implements Comparable<SingleTraining>{
        private final double distance;
        private final String comment;
        private final Date date;

        @Override
        public int compareTo(SingleTraining singleTraining) {
            return (this.date.compareTo(singleTraining.date));
        }
        public SingleTraining(double distance, String comment, Date date) {
            this.comment = comment;
            this.distance = distance;
            this.date = date;
        }

        public double getDistance() {
            return this.distance;
        }

        @Override
        public String toString() {
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateString = simpleDateFormat.format(date);

            return "Data : " + dateString + "        Dystans : " + this.distance + "km        Komentarz : " + this.comment;
        }
    }
}
