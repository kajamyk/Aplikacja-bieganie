package test;

import main.Training;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class TrainingTest {
    @Test
    public void getTotalDistanceTest () throws ParseException {
        Training.getList().removeAllElements();
        assertTrue(Training.getTotalDistance() == 0);
        Training.addTraining("11/11/2021", "20", "");
        assertTrue(Training.getTotalDistance() == 20);
        Training.addTraining("12/11/2021", "10", "");
        assertTrue(Training.getTotalDistance() == 30);
        Training.getList().removeAllElements();
    }
    @Test
    public void getListTest () throws ParseException {
        assertTrue(Training.getList().getSize() == 0);
        Training.addTraining("11/11/2021", "20", "");
        Training.addTraining("12/11/2021", "10", "");
        assertTrue(Training.getList().getSize() == 2);
        String expectedString = "Data : " + "11/11/2021" + "        Dystans : " + "20.0" + "km        Komentarz : " + "";
        assertTrue(Training.getList().get(0).toString().equals(expectedString));
        expectedString = "Data : " + "12/11/2021" + "        Dystans : " + "10.0" + "km        Komentarz : " + "";
        assertTrue(Training.getList().get(1).toString().equals(expectedString));
        Training.getList().removeAllElements();
    }
    @Test
    public void getSortedListTest () throws ParseException {
        Training.addTraining("11/11/2021", "20", "");
        Training.addTraining("12/11/2021", "10", "");
        Training.addTraining("13/11/2021", "20", "");
        assertTrue(Training.getList() == Training.getAscSortedList());
        assertTrue(Training.getList().get(0).equals(Training.getDescSortedList().get(2)));
        assertTrue(Training.getAscSortedList().size() == 3);

    }

}
