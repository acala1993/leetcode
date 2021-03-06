package utils;

import sun.jvm.hotspot.utilities.Interval;

import java.util.List;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static int[] readArray() {
        return ArrayUtil.str2Array(readLine());
    }

    public static List<Integer> readList() {
        return ArrayUtil.str2List(readLine());
    }

    public static String[] readStringArray() {
        return readLine().split(" ");
    }

    public static char[] readCharArray() {
        String[] strings = readLine().split(" ");
        char[] chars = new char[strings.length];
        for (int i = 0; i < strings.length; i++) {
            chars[i] = strings[i].toCharArray()[0];
        }
        return chars;
    }

    public static Interval[] readIntervals() {
        int count = readInt();
        Interval[] result = new Interval[count];
        for (int i = 0; i < count; i++) {
            String[] strings = readLine().split(" ");
            Interval interval = new Interval(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]));
            result[i] = interval;
        }
        return result;
    }
}
