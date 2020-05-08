package utils;

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
}
