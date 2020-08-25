package array;

import utils.ScannerUtil;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        System.out.println(findMajorityElement(arr));
    }

    public static int findMajorityElement(int[] arr) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
                count++;
            } else if (result == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

}
