package utils;

public class ArrayUtils {
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.valueOf(arr[i]) + (i == arr.length-1?"":","));
        }
    }

    public static void printArray(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length-1?"":","));
        }
    }
    public static int[] str2Array(String s){
        String[] strings = s.split(" ");
        int[] ret = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ret[i] = Integer.parseInt(strings[i]);
        }
        return ret;
    }
}
