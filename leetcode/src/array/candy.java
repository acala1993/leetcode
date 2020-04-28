package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

public class candy {
    public static void main(String[] args) {
        String readLine = ScannerUtil.readLine();
        int[] array = ArrayUtil.str2Array(readLine);
        System.out.println(findLeastCandy(array));
    }

    private static int findLeastCandy(int[] arr) {
        int[] candyArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                candyArray[i] = 1;
            } else {
                if (arr[i] > getLeftRate(arr, i)) {
                    candyArray[i] = candyArray[i - 1] + 1; // 保证糖果分配的正确性
                } else {
                    candyArray[i] = 1;// 保证糖果分配的总数最小性
                }
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > getRightRate(arr, i)) {
                if (candyArray[i] <= candyArray[i - 1]) {
                    candyArray[i] = candyArray[i - 1] + 1;// 保证糖果分配的正确性
                }
            }
        }
        return ArrayUtil.countSum(candyArray);
    }

    private static int getLeftRate(int[] arr, int currIndex) {
        int leftIndex = currIndex - 1 >= 0 ?
                currIndex - 1 : currIndex - 1 + arr.length;
        return arr[leftIndex];
    }

    private static int getRightRate(int[] arr, int currIndex) {
        int rightIndex = currIndex + 1 < arr.length ?
                currIndex + 1 : currIndex + 1 - arr.length;
        return arr[rightIndex];
    }
}
