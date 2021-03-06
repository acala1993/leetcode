package array;

import utils.ArrayUtil;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3};
        ArrayUtil.printArray(removeDuplicates(arr));
    }

    private static int[] removeDuplicates(int[] arr) {
//        int start = 0;
//        int end = 1;
//        int count = 1;
//        while (end < arr.length) {
//            if (arr[end] != arr[start]) {
//                arr[count++] = arr[end];
//                start = end;
//            }
//            end++;
//        }
//        return Arrays.copyOf(arr, count);
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[i - count] = arr[i];
            }else {
                count++;
            }
        }
        return Arrays.copyOf(arr, arr.length - count);
    }
}
