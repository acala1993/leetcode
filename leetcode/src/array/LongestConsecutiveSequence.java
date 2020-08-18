package array;

import utils.ScannerUtil;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        System.out.println(findLongestSequence(arr));
    }

    public static int findLongestSequence(int[] arr) {
        Set<Integer> originSet = new HashSet<>();
        int result = 0;
        for (int i : arr) {
            originSet.add(i);
        }
        for (int curr : arr) {
            if (!originSet.contains(curr - 1)) { // 当前元素为最左边界
                int next = curr + 1;
                int count = 1;
                while (originSet.contains(next)) {
                    count++;
                    next++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
