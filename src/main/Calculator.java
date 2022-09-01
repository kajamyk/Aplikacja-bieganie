package main;

public class Calculator {
    private static String convertedTime;

    public static boolean isTimeCorrect(String time) {
        if (time.length() != 8) {
            return false;
        }
        if (time.charAt(2) != ':' || time.charAt(5) != ':') {
            return false;
        }

        StringBuffer stringBuffer = new StringBuffer(time);
        stringBuffer.deleteCharAt(5);
        stringBuffer.deleteCharAt(2);

        try {
            convertedTime = String.valueOf(stringBuffer);
            Integer.parseInt(convertedTime);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static double timeToSeconds() {
        double timeInSeconds = 0;
        timeInSeconds += (convertedTime.charAt(4) - '0') * 10 + convertedTime.charAt(5) - '0';
        timeInSeconds += ((convertedTime.charAt(2) - '0') * 10 + convertedTime.charAt(3) - '0') * 60;
        timeInSeconds += ((convertedTime.charAt(0) - '0') * 10 + convertedTime.charAt(1) - '0') * 3600;
        return timeInSeconds;
    }

    public static String addZeros(int number) {
        if ((number % 10) == number) {
            return '0' + Integer.toString(number);
        }
        return Integer.toString(number);
    }

    public static String convertSeconds(int time) {
        int seconds = time % 60;
        time -= seconds;
        int minutes = (time / 60) % 60;
        int hours = (time - minutes * 60) / 3600;
        String result = addZeros(hours) + ':' + addZeros(minutes) + ":" + addZeros(seconds);
        return result;
    }

    public static String countPace(double distance, double calculatedDistance) {
        double timeInSeconds = timeToSeconds();
        int x = (int) (timeInSeconds * calculatedDistance / distance);
        return convertSeconds(x);
    }

}
