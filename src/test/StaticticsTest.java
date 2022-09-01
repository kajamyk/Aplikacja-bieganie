package test;

import main.Statistics;
import main.Training;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
public class StaticticsTest {
    @Test
    public void getTotalDistanceTest () throws ParseException {
        Training.getList().removeAllElements();
        LocalDate currentDate = LocalDate.now();
        String myDate = currentDate.getDayOfMonth() + "/" + currentDate.getMonthValue() + "/" + +currentDate.getYear();
        Training.addTraining(myDate, "20", "");
        double distance = Statistics.getTotalDistance("Aktualny tydzień");
        assertTrue(distance == 20);
    }

    @Test
    public void getTotalDistanceTest2 () throws ParseException {
        LocalDate date = LocalDate.now();
        date = date.minusDays(10);
        String myDate = (date.getDayOfMonth()) + "/" + date.getMonthValue() + "/" + +date.getYear();
        Training.addTraining(myDate, "20", "");
        double distance = Statistics.getTotalDistance("Aktualny tydzień");
        assertTrue(distance == 0);
    }

    @Test
    public void getTotalDistanceTest3 () throws ParseException {
        LocalDate date = LocalDate.now();
        date = date.plusDays(10);
        String myDate = (date.getDayOfMonth()) + "/" + date.getMonthValue() + "/" + +date.getYear();
        Training.addTraining(myDate, "20", "");
        double distance = Statistics.getTotalDistance("Aktualny tydzień");
        assertTrue(distance == 0);
    }

    @Test
    public void getNumberOfTrainingsTest () throws ParseException {
        Training.getList().removeAllElements();
        LocalDate date = LocalDate.now();
        date = date.minusDays(date.getDayOfMonth() - 1);
        String myDate = (date.getDayOfMonth()) + "/" + date.getMonthValue() + "/" + +date.getYear();
        Training.addTraining(myDate, "20", "");

        date = date.plusDays(10);
        myDate = (date.getDayOfMonth()) + "/" + date.getMonthValue() + "/" + +date.getYear();
        Training.addTraining(myDate, "20", "");
        double distance = Statistics.getTotalDistance("Aktualny miesiąc");
        assertTrue(Statistics.getNumberOfTrainings() == 2);
    }

}
