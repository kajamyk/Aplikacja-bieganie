package test;

import main.Goals;
import main.Training;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class GoalsTest {
    @Test
    public void addGoalTest () throws ParseException {
        assertTrue(Goals.getList().getSize() == 0);
        Goals.addGoal("06/06/2022", "06/07/2022", 60);
        assertTrue(Goals.getList().getSize() == 1);
        Goals.getList().removeAllElements();

    }

    @Test(expected = ParseException.class)
    public void addGoalTestForIncorrectInput () throws ParseException {
        Goals.addGoal("06/06/", "06/07/2022", 60);
    }

    @Test
    public void toStringTest () throws ParseException {
        Goals.addGoal("06/06/2021", "06/07/2021", 60);
        String expectedString = "Data początkowa : 06/06/2021        " +
                "Data końcowa : 06/07/2021        Dystans : 0.0 / 60.0        Status : Cel nie został osiągnięty";
        Assert.assertEquals(Goals.getList().get(0).toString(), expectedString);
        Goals.getList().removeAllElements();
    }

    @Test
    public void toStringTestForGetList () throws ParseException {
        Training.addTraining("06/06/2022", "20", "" );
        Goals.addGoal("06/06/2022", "06/07/2022", 20);
        String expectedString = "Data początkowa : 06/06/2022       " +
                " Data końcowa : 06/07/2022        Dystans : 20.0 / 20.0        Status : Cel osiągnięty";
        Assert.assertEquals(Goals.getList().get(0).toString(), expectedString);
    }
}
