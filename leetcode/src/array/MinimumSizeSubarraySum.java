package array;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nums = scan.nextLine();
        int target = scan.nextInt();
        int[] arr = ArrayUtils.str2Array(nums);
        ArrayUtils.printArray(findMinimumSizeSubarraySum(arr, target));
    }

    public static int[] findMinimumSizeSubarraySum(int[] arr, int target) {
        int i = -1;
        int j = -1;
        int leftIndex = 0;
        int currSum = 0;
        for (int rightIndex = 0; rightIndex < arr.length; rightIndex++) {
            currSum += arr[rightIndex];
            if (currSum >= target) {
                while (currSum - arr[leftIndex] >= target && leftIndex < rightIndex) {
                    currSum -= arr[leftIndex];
                    leftIndex++;
                }
                // 间距比上次最小间距小，则更新左右边界
                if (i == -1 || (rightIndex - leftIndex) < (j - i)) {
                    i = leftIndex;
                    j = rightIndex;
                }
            }
        }
        return Arrays.copyOfRange(arr, i, j + 1);
    }
}
