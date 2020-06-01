package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.rotateArrayWithRandomIndex(ScannerUtil.readArray());
        int target = ScannerUtil.readInt();
        ArrayUtil.printArray(arr);
        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) { //找比arr[mid]小的
                if (arr[mid] < arr[left]) { // 在反常区间小部
                    right = mid - 1;
                } else if (arr[mid] > arr[right]) { //在反常区间大部
                    if (arr[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else { // 正常区间内
                    right = mid - 1;
                }
            } else { //找比arr[mid]大的
                if (arr[mid] < arr[left]) { // 在反常区间小部
                    if (arr[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (arr[mid] > arr[right]) { //在反常区间大部
                    left = mid + 1;
                } else { // 正常区间内
                    left = mid + 1;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }

}
