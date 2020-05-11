package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = ScannerUtil.readArray();
        int[] arr2 = ScannerUtil.readArray();
        int[] ret = findIntersectionOfTwoArrays(arr1, arr2);
        ArrayUtil.printArray(ret);
    }

    public static int[] findIntersectionOfTwoArrays(int[] arr1, int[] arr2) {
        int count = 0;
        int[] ret = new int[Math.min(arr1.length, arr2.length)];
        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr2[index2] < arr1[index1]) {
                while (index2 < arr2.length && arr2[index2] < arr1[index1]) {
                    index2++;
                }
                if (index2 < arr2.length && arr1[index1] == arr2[index2]) {
                    ret[count++] = arr1[index1];
                    index1++;
                    index2++;
                }
            } else if (arr2[index2] > arr1[index1]) {
                while (index1 < arr1.length && arr2[index2] > arr1[index1]) {
                    index1++;
                }
                if (index1 < arr1.length && arr1[index1] == arr2[index2]) {
                    ret[count++] = arr1[index1];
                    index1++;
                    index2++;
                }
            } else {
                ret[count++] = arr1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOf(ret, count);
    }
}
