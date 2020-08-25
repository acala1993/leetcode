package array;

import utils.ScannerUtil;

public class IncreaseTripletSubsequence {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        System.out.println(checkIfExistTripletIncreaseSubsequence(arr));
    }

    public static boolean checkIfExistTripletIncreaseSubsequence(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i : arr) {
            if (first > i) {
                first = i;
            } else if (second > i) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
