package array;

import utils.ArrayUtil;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3};
        ArrayUtil.printArray(removeDuplicates2(arr));
    }

    private static int[] removeDuplicates2(int[] arr) {
        int count = 0;
        int currCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[i - count] = arr[i];
                currCount = 1;
            } else {
                if (currCount > 1){
                    count++;
                    currCount++;
                } else{
                    currCount++;
                }
            }
        }
        return Arrays.copyOf(arr, arr.length - count);
    }
}
