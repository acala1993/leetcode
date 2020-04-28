package array;

import utils.ArrayUtil;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] arr = ArrayUtil.str2Array(s);
        System.out.println(findMostWater(arr));
    }

    public static int findMostWater(int[] arr) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex < rightIndex) {
            int curr = Math.min(arr[leftIndex], arr[rightIndex]) * (rightIndex - leftIndex);
            max = Math.max(max, curr);
            boolean flag = false;
            if (arr[leftIndex] < arr[rightIndex]) {
                int tempIndex = leftIndex + 1;
                while (tempIndex < rightIndex && arr[tempIndex] < arr[leftIndex]) {
                    tempIndex++;
                }
                if (tempIndex != rightIndex){
                    flag = true;
                    leftIndex = tempIndex;
                }
            } else {
                int tempIndex = rightIndex - 1;
                while (tempIndex > leftIndex && arr[tempIndex] < arr[rightIndex]) {
                    tempIndex--;
                }
                if (tempIndex != leftIndex){
                    flag = true;
                    rightIndex = tempIndex;
                }
            }
            if (!flag) {
                break;
            }
        }
        return max;
    }
}
