package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

public class TrappingRainWater {
    public static void main(String[] args) {
        String readLine = ScannerUtil.readLine();
        int[] arr = ArrayUtil.str2Array(readLine);
        System.out.println(findMostTrappingRainWater(arr));
    }

    public static int findMostTrappingRainWater(int[] arr) {
        int ret = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (isLocalMax(arr, i)) {
                if (index == -1) {
                    index = i;
                } else {
                    int height = Math.min(arr[index], arr[i]);
                    for (int j = index + 1; j < i; j++) {
                        ret += height - arr[j];
                    }
                    index = i;
                }
            }
        }
        return ret;
    }

    public static boolean isLocalMax(int[] arr, int index) {
        if (index == 0) {
            return arr[index + 1] < arr[index];
        } else if (index == arr.length - 1) {
            return arr[index - 1] < arr[index];
        } else {
            return arr[index] > Math.max(arr[index + 1], arr[index - 1]);
        }
    }
}
