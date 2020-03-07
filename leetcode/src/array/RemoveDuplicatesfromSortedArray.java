package array;

import utils.ArrayUtils;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3};
        ArrayUtils.printArray(removeDuplicates(arr));
    }

    private static int[] removeDuplicates(int[] arr) {
        int start = 0;
        int end = 1;
        int count = 1;
        while (end < arr.length) {
            if (arr[end] != arr[start]) {
                arr[count++] = arr[end];
                start = end;
            }
            end++;
        }
        return Arrays.copyOf(arr, count);
    }
}
