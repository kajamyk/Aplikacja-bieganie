package main;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Statistics {
    private static Date finalDate;
    private static Date startingDate;
    private static double totalDistance;
    private static int numberOfTrainings;

    private static void setHours(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
    }

    public static void setHours(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        setHours(cal);
        date = cal.getTime();
    }

    private static void findDate(String timePeriod) {
        Date currentDate = new Date(System.currentTimeMillis());

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        if (timePeriod.equals("Aktualny tydzień")) {
            cal.setTime(currentDate);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != 1) {
                cal.add(Calendar.DATE, -(dayOfWeek - 2));
            } else {
                cal.add(Calendar.DATE, -6);
            }

            setHours(cal);
            startingDate = cal.getTime();
            cal.add(Calendar.DATE, +6);
            setHours(cal);
            finalDate = cal.getTime();
        } else if (timePeriod.equals("Aktualny miesiąc")) {

            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

            cal.add(Calendar.DATE, -dayOfMonth + 1);
            setHours(cal);
            startingDate = cal.getTime();

            LocalDate localDate = startingDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            YearMonth yearMonthObject = YearMonth.from(localDate);
            int daysInMonth = yearMonthObject.lengthOfMonth();
            cal.add(Calendar.DATE, +daysInMonth - 1);
            setHours(cal);
            finalDate = cal.getTime();
        }
    }

    public static double getTotalDistance(String timeperiod) {
        findDate(timeperiod);

        totalDistance = Training.getResult(startingDate, finalDate);
        return totalDistance;
    }

    public static double getDistance() {
        return totalDistance / numberOfTrainings;
    }

    public static int getNumberOfTrainings() {
        numberOfTrainings = Training.getNumberOfTrainings(startingDate, finalDate);
        return numberOfTrainings;
    }

    public static double [] getTrainingsDistanceForWeek () {
        return Training.getTableResult(startingDate, finalDate);
    }

}
