package sort;

import utils.PrintUtils;
import utils.ScannerUtil;

public class SortUtils {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        bubbleSort(arr);
        PrintUtils.printIntArray(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[left]; // 基准值
        int i = left + 1;
        int j = right;
        while (i < j) {
            while (i <= right && arr[i] < pivot) i++;
            while (j >= left && arr[j] > pivot) j--;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j); // 将基准值与j下标进行交换
        quickSort(arr, left, j - 1);
        quickSort(arr, i, right);
    }

    /**
     * 交换两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
