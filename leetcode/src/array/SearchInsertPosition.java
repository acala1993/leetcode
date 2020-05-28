package array;

import utils.ScannerUtil;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        int target = ScannerUtil.readInt();
        System.out.println(findPosition(arr, target));
        System.out.println(findPositionWithBinarySearch(arr, target));
    }

    /**
     * O(n)时间复杂度，O(1)空间复杂度
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findPosition(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return arr.length;
    }

    /**
     * O(lg(n))时间复杂度
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findPositionWithBinarySearch(int[] arr, int target) {
        if (arr[0] > target) return 0;
        if (arr[arr.length - 1] < target) return arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (arr[left] == target) return left;
        else if (arr[left] > target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
