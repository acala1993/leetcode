package array;

import utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class GetTargetNumber {
    public static void main(String[] args) {
        List<Integer> numbers = ScannerUtil.readList();
        int target = ScannerUtil.readInt();
        System.out.println(isReachable(numbers, target));
    }

    public static boolean isReachable(List<Integer> numbers, int target) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        }
        int left = 0;
        int right = numbers.size() - 1;
        List<Integer> result = getResults(numbers, left, right);
        for (Integer integer : result) {
            if (integer == target) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> getResults(List<Integer> numbers, int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left == right) {
            result.add(numbers.get(left));
            return result;
        } else if (left > right) {
            return result;
        }
        for (int i = left; i < right; i++) {
            List<Integer> leftResults = getResults(numbers, left, i);
            List<Integer> rightResults = getResults(numbers, i + 1, right);
            for (Integer leftResult : leftResults) {
                for (Integer rightResult : rightResults) {
                    result.add(leftResult + rightResult);
                    result.add(leftResult - rightResult);
                    result.add(leftResult * rightResult);
                    if (rightResult != 0) {
                        result.add(leftResult / rightResult);
                    }
                }
            }
        }
        return result;
    }
}
