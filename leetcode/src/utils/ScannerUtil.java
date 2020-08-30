package utils;

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
}
