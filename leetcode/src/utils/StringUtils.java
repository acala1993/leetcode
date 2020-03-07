package utils;

public class StringUtils {
    public static int[] Strings2Array(String str) {
        String[] strings = str.split(" ");
        int[] ret = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ret[i] = Integer.parseInt(strings[i]);
        }
        return ret;
    }
}
