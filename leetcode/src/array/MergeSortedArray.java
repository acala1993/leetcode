package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = ScannerUtil.readArray();
        int[] arr2 = ScannerUtil.readArray();
        int[] ret = mergeTwoSortedArray(arr1, arr2);
        ArrayUtil.printArray(ret);
    }

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int index = 0;
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] < arr2[second]) {
                ret[index++] = arr1[first++];
            } else {
                ret[index++] = arr2[second++];
            }
        }
        if (first < arr1.length) {
            for (int i = first; i < arr1.length; i++) {
                ret[index++] = arr1[i];
            }
        }
        if (second < arr2.length) {
            for (int i = second; i < arr2.length; i++) {
                ret[index++] = arr2[i];
            }
        }
        return ret;
    }

}
