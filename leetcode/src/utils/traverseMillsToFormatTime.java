package utils;

import java.util.Calendar;

public class traverseMillsToFormatTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toInstant());
        System.out.println();
    }

    private static String formatMillsTime(long millisUntilFinished) {
        int secondsUntilFinished = (int)(millisUntilFinished / 1000);
        return String.format("%02d:%02d", secondsUntilFinished / 60 % 60, secondsUntilFinished % 60);

    }
}
