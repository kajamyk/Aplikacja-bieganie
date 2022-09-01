package test;

import main.Calculator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    public void isTimeCorrectTest () {
        assertTrue(Calculator.isTimeCorrect("00:00:01"));
        assertFalse(Calculator.isTimeCorrect("00:00"));
        assertFalse(Calculator.isTimeCorrect("11111111"));
        assertFalse(Calculator.isTimeCorrect("aa:aa:aa"));
    }

    @Test
    public void timeToSecondsTest() {
        Calculator.isTimeCorrect("00:00:00");
        Assert.assertTrue(Calculator.timeToSeconds() == 0);
        Calculator.isTimeCorrect("00:00:10");
        Assert.assertTrue(Calculator.timeToSeconds() == 10);
        Calculator.isTimeCorrect("01:01:10");
        Assert.assertTrue(Calculator.timeToSeconds() == 3670);
    }

    @Test
    public void countPaceTest() {
        Calculator.isTimeCorrect("00:01:00");
        Assert.assertEquals(Calculator.countPace(10, 20), "00:02:00");
        Assert.assertEquals(Calculator.countPace(10, 5), "00:00:30");
        Assert.assertEquals(Calculator.countPace(10, 2.5), "00:00:15");
    }

    @Test
    public void addZeroesTest() {
        assertTrue(Calculator.addZeros(1).equals("01"));
        assertTrue(Calculator.addZeros(0).equals("00"));
        assertTrue(Calculator.addZeros(10).equals("10"));
    }

    @Test
    public void convertSecondsTest () {
        assertTrue(Calculator.convertSeconds(10).equals("00:00:10"));
        assertTrue(Calculator.convertSeconds(00).equals("00:00:00"));
        assertTrue(Calculator.convertSeconds(60).equals("00:01:00"));
        assertTrue(Calculator.convertSeconds(3666).equals("01:01:06"));
    }

}
