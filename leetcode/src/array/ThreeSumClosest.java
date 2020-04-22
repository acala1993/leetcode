package array;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int target = scanner.nextInt();
        System.out.println(getClosestSum(target, arr));
    }

    public static int getClosestSum(int target, int[] arr) {
        Arrays.sort(arr);
        int lastMinDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int mid = i + 1;
            int right = arr.length - 1;
            while (mid < right) {
                if (arr[i] + arr[mid]+arr[right] == target){
                    return target;
                } else if (arr[i] + arr[mid]+arr[right] < target){
                    int diff = arr[i] + arr[mid] + arr[right] - target;
                    if (Math.abs(diff) <Math.abs(lastMinDiff)){
                        lastMinDiff = diff;
                    }
                    mid ++;
                } else{
                    int diff = arr[i] + arr[mid] + arr[right] - target;
                    if (Math.abs(diff) <Math.abs(lastMinDiff)){
                        lastMinDiff = diff;
                    }
                    right --;
                }
            }
        }
        return target + lastMinDiff;
    }
}
