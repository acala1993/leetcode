package utils;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int[] result = rotateArrayWithRandomIndex(arr);
        ArrayUtil.printArray(result);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.valueOf(arr[i]) + (i == arr.length - 1 ? "" : ","));
        }
        System.out.print("\n");
    }

    public static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.valueOf(arr[i]) + (i == arr.length - 1 ? "" : ","));
        }
        System.out.print("\n");
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ","));
        }
        System.out.print("\n");
    }

    public static int[] str2Array(String s) {
        String[] strings = s.split(" ");
        int[] ret = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ret[i] = Integer.parseInt(strings[i]);
        }
        return ret;
    }

    public static int countSum(int[] arr) {
        int ret = 0;
        for (int i : arr) {
            ret += i;
        }
        return ret;
    }

    public static int[] rotateArrayWithRandomIndex(int[] arr) {
        int startRotateIndex = (int) (Math.random() * arr.length);
        return rotateArray(arr, startRotateIndex);
    }

    public static int[] rotateArray(int[] arr, int startRotateIndex) {
        int[] ret = arr;
        int temp = arr[0];
        int step = arr.length - startRotateIndex;
        for (int i = 0; i < step; i++) {
            ret = moveOneStep(ret);
        }
        return ret;
    }

    public static int[] moveOneStep(int[] arr) {
        int lastElem = arr[0];
        for (int i = 1; i < arr.length + 1; i++) {
            int temp = arr[i % arr.length];
            arr[i % arr.length] = lastElem;
            lastElem = temp;
        }
        return arr;
    }
}
