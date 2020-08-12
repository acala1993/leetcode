package array;

import utils.ScannerUtil;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        System.out.println(getLargestRectangle(arr));
    }

    public static int getLargestRectangle(int[] arr) {
        int ret = Integer.MIN_VALUE;
        Stack<Integer> ascendIndex = new Stack<>();
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length) {
                int rightIndex = ascendIndex.peek();
                while (!ascendIndex.empty() && arr[ascendIndex.peek()] > 0) {
                    int leftIndex = ascendIndex.pop();
                    int height = arr[leftIndex];
                    ret = Math.max(height * (rightIndex - leftIndex + 1), ret);
                }
            } else {
                if (ascendIndex.empty()) {
                    ascendIndex.push(i);
                } else {
                    if (arr[ascendIndex.peek()] > arr[i]) { // 栈顶元素大于当前元素，则需要退栈
                        int rightIndex = ascendIndex.peek();
                        while (!ascendIndex.empty() && arr[ascendIndex.peek()] > arr[i]) {
                            int leftIndex = ascendIndex.pop();
                            int height = arr[leftIndex];
                            ret = Math.max(height * (rightIndex - leftIndex + 1), ret);
                        }
                    } else { //栈顶元素不大于当前元素
                        ascendIndex.push(i);
                    }
                }
            }
        }
        return ret;
    }
}
