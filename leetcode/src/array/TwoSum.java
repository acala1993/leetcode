package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 9, 12,15, 17};
        List<int[]> ret = findTwoSum(nums, 14);
        for (int[] ints : ret) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<int[]> findTwoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<int[]> ret = new ArrayList<>();
        while (left < right) {
            if (nums[left] == (target - nums[right])) {
                ret.add(new int[]{nums[left], nums[right]});
                left ++;
                right --;
            } else if (nums[left] < (target - nums[right])) {
                left ++;
            } else {
                right --;
            }
        }
        return ret;
    }
}
