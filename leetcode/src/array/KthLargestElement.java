package array;

import sort.SortUtils;
import utils.ScannerUtil;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        int k = ScannerUtil.readInt();
        System.out.println(findKth(arr, k));
    }

    public static int findKth(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
        return arr[arr.length - k];
    }

}
